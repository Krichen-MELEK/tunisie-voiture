# Stage 1
FROM node:12.22.12 as node
WORKDIR /app
RUN npm install -g @angular/cli@11
COPY package*.json ./
RUN npm install
RUN npm install --save-dev @angular-devkit/build-angular
COPY . .
EXPOSE 4200
CMD ["npm","start"]
