.PHONY: up down build

# Запуск контейнеров
up:
	docker-compose up -d

# Остановка и удаление контейнеров
down:
	docker-compose down

# Пересборка образов
build:
	docker-compose build

