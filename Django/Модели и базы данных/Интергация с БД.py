manage.py inspectdb > file.txt # Просматривает базу данных и выводит в файл программный код, отображающий модели на таблицы

# settings.py
# В данном параметре содержатся источники аутентификации. При аутентификации django проходит по ним сверху вниз до первой успешной аутентификации
AUTHENTICATION_BACKENDS = (
    'django.contrib.auth.backends.ModelBackend', # По умолчанию
)