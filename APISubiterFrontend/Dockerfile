FROM node:lts-alpine

RUN npm install -g http-server

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 4200

CMD [ "http-server", "dist" ]

# docker build -t subter-frontend:1.0.0  .

# docker run -p 4200:8080  subter-frontend:1.0.0