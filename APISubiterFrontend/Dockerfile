FROM node:lts-alpine

RUN npm install -g http-server

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 4200

CMD [ "http-server", "dist" ]

# docker logout

# docker build -t subter-frontend:2.0.0 .

# docker tag subter-frontend:2.0.0 apidocdocker/subter-frontend:2.0.0

# docker login 

# docker push apidocdocker/subter-frontend:2.0.0

# docker run -p 8080:8080 subter-frontend:2.0.0