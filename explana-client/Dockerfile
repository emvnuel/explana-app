FROM node:20.17.0 as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
ENV NODE_OPTIONS=--openssl-legacy-provider
RUN npm install --loglevel verbose --legacy-peer-deps
RUN npm run build

FROM nginx:1.17.2
COPY --from=build /usr/local/app/dist/app /usr/share/nginx/html
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
EXPOSE 8080
CMD ["nginx", "-g", "daemon off;"]
