# Тесты могут находиться в модуле models.py или в файле tests.py в корневой директории приложения

# Если определить функцию suite() в одном из этих мест, она будет использована для построения набора тестов. Иначе будет использовано построение по умолчанию.

from django.utils import unittest

class MyTestCase(unittest.TestCase):
    def setUp(self):
        # Начальные действия
    def testSomething(self):
        self.assertEqual(self..., '...') # Проверка равенства
        
manage.py test # Тестирование всех приложений в INSTALLED_APPS
manage.py appname # Тестирование отдельного приложения
manage.py appname.TestCaseName # Применение конкретного теста
manage.py appname.TestCaseName.testMethod # Применение конкретного тестового метода

# Тестирование вне оболочки
from django.test.utils import setup_test_environment
setup_test_environment()

# settings.py
DATABASES = {
    ...
    TEST_NAME: 'my_test_database', # Задание имени для тестовой базы данных
    TEST_CHARSET: 'utf-8', # Кодировка тестовой базы
    TEST_COLLATION: '...', # Сравнение тестовой базы
    ...
}

# Тестовый клиент
from django.test.client import Client
c = Client()
# По умолчанию csrf-защита при тестировании отключена, но ее можно включить
c = Client([enforce_csrf_checks=True])
response = c.post('/login/', {'username': 'john', 'password': 'smith'}) # Эмуляция запроса POST
response.status_code # Получение кода ответа
c.get('/customers/details/', {'name': 'fred', 'age': 7}, HTTP_X_REQUESTED_WITH='XMLHttpRequest') # Эмуляция запроса GET
response = c.get('...', follow=True) # Эмуляция запроса с отслеживанием перенаправлений
response.redirect_chain # Получение цепочки перенаправлений
response.content # Получение содержимого ответа