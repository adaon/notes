### Подготовка приложения ###
# settings.py
DEBUG = False
TEMPLATE_DEBUG = False
# Необходимо создать шаблон 404.html
# Необходимо создать шаблон 500.html
ADMINS = (
    ('Denis Ivanov', 'teu@nm.ru'), # В данный кротеж необходимо включить все адреса администраторов, которым будут посылаться сообщения обо всех возникших исключениях. Также необходимо настроить параметры отправки e-mail
)
SEND_BROKEN_LINK_EMAILS = True # Отправлять сообщение администратору при попытке перехода по "битой" ссылке

# Можно создать 2 файла с параметрами (один для разработки, другой для сервера). Чтобы изменить используемый файл настроек, нужно сменить его имя в файле manage.py

DJANGO_SETTINGS_MODULE # Данная переменная окружения рабочего сервера должна содержать путь к файлу параметров приложения, например mysite.settings