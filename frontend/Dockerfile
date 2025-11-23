FROM nginx:stable-alpine

RUN rm -rf /usr/share/nginx/html/*

COPY ./frontend /usr/share/nginx/html/
COPY ./frontend/nginx/default.conf /etc/nginx/conf.d/default.conf
