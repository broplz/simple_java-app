# Этап сборки Java-приложения
FROM maven:3.8.3-openjdk-17 AS builder

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование файлов приложения и pom.xml в контейнер
COPY project_x.java .
COPY pom.xml .

# Сборка артефакта
RUN mvn package

# Копирование артефакта в папку artifact/v0.0
RUN mkdir -p /app/artifact/v0.0
RUN cp /app/target/terminal-app-1.0.jar /app/artifact/v0.0/terminal-app.jar

# Отдельный этап для создания образа Java-приложения
FROM openjdk:17-jdk AS final

# Копирование собранного JAR-файла из предыдущего этапа в контейнер
COPY --from=builder /app/artifact/v0.0/terminal-app.jar /app/terminal-app.jar

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Запуск Java-приложения при старте контейнера
CMD ["java", "-jar", "terminal-app.jar"]

