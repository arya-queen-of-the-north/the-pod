FROM node:latest
WORKDIR /user
COPY package*.json ./
RUN npm install
COPY ./ ./
ENV MONGOLAB_URI=MONGOLAB_URI
EXPOSE 3000
CMD ["node", "server.js"]