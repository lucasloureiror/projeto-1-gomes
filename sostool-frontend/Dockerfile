FROM node:18-alpine as build

WORKDIR /app


COPY package*.json ./


RUN npm ci


COPY . .


RUN npx ng build --configuration=production


FROM nginx:1.21-alpine


COPY --from=build app/dist/sos-tool-frontend /usr/share/nginx/html


EXPOSE 80


CMD ["nginx", "-g", "daemon off;"]