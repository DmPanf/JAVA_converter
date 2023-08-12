# функция для перевода 1 доллара в рубли
from requests import get
def usd_to_rub(num=1):
    data = get('https://www.cbr-xml-daily.ru/daily_json.js').json()
    rate = data['Valute']['USD']['Value']
    return round(num * rate, 2)
