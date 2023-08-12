# Используем официальный образ Python
FROM python:3.9

MAINTAINER "Dmitry <7292337@gmail.com>"
LABEL version="1.0"
LABEL description="Server on Flask <- JAVA-client"

# Установка рабочей директории
WORKDIR /app

# Добавление содержимого текущей директории в контейнер с рабочим каталогом
ADD . /app

# установка зависимостей
RUN pip install --no-cache-dir -r requirements.txt

# Открываем порт для приложения
EXPOSE 5001

# Переменные окружения
ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0
ENV FLASK_RUN_PORT=5001

# Запускаем приложение
CMD ["flask", "run"]
