-- Создание базы данных
CREATE DATABASE GPT_arch;

-- Использование базы данных
\c GPT_arch;

-- Создание таблицы terminal_input
CREATE TABLE terminal_input (
  id SERIAL PRIMARY KEY,
  input_text TEXT
);

