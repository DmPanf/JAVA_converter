# Пример приложения на Flask
from flask import Flask
from datetime import date
from usd_to_rub import usd_to_rub

app = Flask(__name__)

@app.route("/help")
def hello():
    return "Добро пожаловать в конвертер USD -> RUB!"

@app.route('/')
def view():
  today = date.today()
  course = usd_to_rub(1)  # get the exchange rate for 1 USD to RUB
  txt = f'Сегодня {today} за 1 USD дают: {course} рублей'
  return txt

if __name__ == '__main__':
  app.run(host='0.0.0.0', port=5000)
