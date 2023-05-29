# Dockerfile для контейнера PostgreSQL
FROM postgres:latest

# Установка переменных среды для PostgreSQL
ENV POSTGRES_USER=chatGPT
ENV POSTGRES_PASSWORD=chatGPT
ENV POSTGRES_DB=GPT_arch

# Копирование скриптов инициализации в контейнер
COPY source/init.sql /docker-entrypoint-initdb.d/
