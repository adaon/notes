easy_install Celery # Установка
easy_install django-celery # Установка 2G

# После установки django-celery нужно сконфигурировать:
#добавить djcelery в список INSTALLED_APPS:
INSTALLED_APPS += ("djcelery", )
# добавить следующие строки в файл настроек django {{settings.py}}:
import djcelery
djcelery.setup_loader()
# Создать необходимые таблицы в БД:
./manage.py syncdb
# Задаём БД в качестве места хранения периодических заданий, добавляем в settings.py:
CELERYBEAT_SCHEDULER = "djcelery.schedulers.DatabaseScheduler"
# С помощью этой опции мы сможем добавлять/удалять/редактировать периодические задания через админку django.
# При использовании mod_wsgi добавить следующие строки в конфигруационный файл WSGI:
import os
os.environ["CELERY_LOADER"] = "django"
