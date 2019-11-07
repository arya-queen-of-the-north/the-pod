def COLOR_MAP = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']
pipeline {
  environment {
    PROJECT = "th-ninakas17"
    APP_NAME = "pod-api"
    FE_SVC_NAME = "${APP_NAME}-frontend"
    CLUSTER = "internat"
    CLUSTER_ZONE = "us-central1-a"
    IMAGE_TAG = "gcr.io/${PROJECT}/${APP_NAME}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"
    JENKINS_CRED = "${PROJECT}"
  }
  agent {
    kubernetes {
      label 'pod-app'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  serviceAccountName: cd-jenkins
  containers:
  - name: node
    image: node:latest
    command:
    - cat
    tty: true
  - name: gcloud
    image: gcr.io/cloud-builders/gcloud
    command:
    - cat
    tty: true
  - name: kubectl
    image: gcr.io/cloud-builders/kubectl
    command:
    - cat
    tty: true
"""
}
  }
  stages {
    // Test stage
    // stage('Test') {
    //   steps {
    //     container('node') {
    //       sh """
    //         npm install
    //         npm test
    //       """
    //     }
    //   }
    //   post {
    //     failure {
    //       slackSend channel: "#internat",
    //         color: COLOR_MAP[currentBuild.currentResult],
    //         message: "*TESTS*: Some tests have failed. \nJob: ${env.JOB_NAME} [Build ${env.BUILD_NUMBER}]"
    //     }
    //   }
    // }
    
    // Build stage
    stage('Build and push image with Container Builder') {
      steps {
        container('gcloud') {
          sh "PYTHONUNBUFFERED=1 gcloud builds submit -t ${IMAGE_TAG} ."
        }
      }
      post {
        failure {
          slackSend channel: "#internat",
            color: COLOR_MAP[currentBuild.currentResult],
            message: "*BUILD*: Building docker image failed. \nJob: ${env.JOB_NAME} [Build ${env.BUILD_NUMBER}]"
        }
      }
    }
    
    // Deploy stage
    stage('Deploy Backend API') {
      // Developer Branches
      when { branch 'development' }
      steps {
        container('kubectl') {
          sh("kubectl get ns backend")
          sh("sed -i.bak 's#gcr.io/gcr-project/sample:1.0.0#${IMAGE_TAG}#' ./k8s/deployments/*.yaml")
          step([$class: 'KubernetesEngineBuilder',namespace: "backend", projectId: env.PROJECT, clusterName: env.CLUSTER, zone: env.CLUSTER_ZONE, manifestPattern: 'k8s/services', credentialsId: env.JENKINS_CRED, verifyDeployments: false])
          step([$class: 'KubernetesEngineBuilder',namespace: "backend", projectId: env.PROJECT, clusterName: env.CLUSTER, zone: env.CLUSTER_ZONE, manifestPattern: 'k8s/deployments', credentialsId: env.JENKINS_CRED, verifyDeployments: true])
        }
      }
      post {
        failure {
          slackSend channel: "#internat",
            color: COLOR_MAP[currentBuild.currentResult],
            message: "*DEPLOY*: Deployment to the server failed. \nJob: ${env.JOB_NAME} [Build ${env.BUILD_NUMBER}]"
        }
      }
    }
  }
  post {
    always {
        slackSend channel: "#internat",
          color: COLOR_MAP[currentBuild.currentResult],
          message: "*${currentBuild.currentResult}* \nJob: ${env.JOB_NAME} [Build ${env.BUILD_NUMBER}] \n${env.BUILD_URL}"
    }
  }
}