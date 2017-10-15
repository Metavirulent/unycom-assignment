FROM node:slim as BUILD

ENV REACT_APP_UNY_SERVICE https://uny-service.alioktay.org

WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app/
RUN npm run build

FROM nginx:alpine
COPY --from=BUILD /app/build /usr/share/nginx/html
