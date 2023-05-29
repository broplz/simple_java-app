# Dockerfile для Java-приложения

# Используем базовый образ OpenJDK 17
FROM openjdk:17

# Установка рабочей директории
WORKDIR /app

# Копирование JAR-файла приложения в контейнер
COPY target/project_x.jar /app/project_x.jar

# Определение команды для запуска приложения
CMD ["java", "-jar", "project_x.jar"]
