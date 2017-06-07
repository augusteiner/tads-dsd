
FROM php:alpine

RUN apk add --no-cache --purge curl

RUN curl -sS https://getcomposer.org/installer \
  | php -- --install-dir=/usr/local/bin --filename=composer

