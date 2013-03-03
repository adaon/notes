### Настройки ###

# settings.py

LOGGING = {
    'version': 1, # Версия формата dictConfig
    'disable_existing_loggers': True, # Отключение всех существующих настроек логирования
    # Два форматтера (строка является обычной строкой форматирования python)
    'formatters': { 
        # Выводит уровень логирования, сообщение, время, название процесса, потока и модуля, который создал сообщение
        'verbose': {
            'format': '%(levelname)s %(asctime)s %(module)s %(process)d %(thread)d %(message)s'
        },
        # Просто возвращает уровень и сообщение
        'simple': {
            'format': '%(levelname)s %(message)s'
        },
    },
    # Определяет один фильр с указанием аргументов
    'filters': {
        'special': {
            '()': 'project.logging.SpecialFilter',
            'foo': 'bar',
        }
    },
    # Определяет три обработчика
    'handlers': {
        # Отправляет все сообщения уровня DEBUG (или выше) в /dev/null
        'null': {
            'level':'DEBUG',
            'class':'django.utils.log.NullHandler',
        },
        # Перенаправляет все сообщения DEBUG (или выше) в stderr.Использует формат simple
        'console':{
            'level':'DEBUG',
            'class':'logging.StreamHandler',
            'formatter': 'simple'
        },
        # Отправляет e-mail с сообщением уровня ERROR (и выше) администраторам сайта. Использует формат special
        'mail_admins': {
            'level': 'ERROR',
            'class': 'django.utils.log.AdminEmailHandler',
            'filters': ['special']
        }
    },
    # Настраивает три логера
    'loggers': {
        # Перенаправляет все сообщения уровня INFO и выше в обработчик null
        'django': {
            'handlers':['null'],
            'propagate': True,
            'level':'INFO',
        },
        # Передает все сообщения уровня ERROR в обработчик mail_admins
        'django.request': {
            'handlers': ['mail_admins'],
            'level': 'ERROR',
            'propagate': False, # Не должен передавать сообщение родительским логерам
        },
        # Передает все сообщения уровня INFO и выше прошедшие фильр special в два обработчика - console и main_admins
        'myproject.custom': {
            'handlers': ['console', 'mail_admins'],
            'level': 'INFO',
            'filters': ['special']
        }
    }
}

### Логеры (точка входа системы логирования) ###

# Уровни логирования:
DEBUG       # Низкий уровень логирования системной информации для последующего использование в отладке
INFO        # Общая системная информация
WARNING     # Информация о мелких проблемах, возникших при работе приложения
ERROR       # Информация об ошибках, возникших при работе приложения
CRITICAL    # Информация о критических ошибках

import logging
logger = logging.getLogger(__name__) # Возвращает (создает при необходимости) экземпляр логера, который определяется названием. Можно также использовать иерархические имена, например, project.my.interest, тогда будут создаваться родительские и дочерние логеры

logger.critical('Message')
logger.error('Message')
logger.warning('Message')
logger.info('Message')
logger.debug('Message')

logger.log() # Отправить сообщение с указанным уровнем логирования
logger.exception() # Создать ERROR сообщение из последнего исключения

### Расширения для логирования в Django ###

# Логеры

django # Логер, принимающий все сообщения. Сообщения не записываются непосредственно в этот логер
django.request # Принимает все сообщения, связанные с процессом обработки запросов. Содержат дополнительные данные: status_code (HTTP код ответа), request (объект запроса)
django.db.backends # Сообщения, связанные с взаимодействием кода с базой данных. Содержат дополнительные данные: duration (время выполнения SQL-запроса), sql (запрос), params (параметры запроса)

# Обработчики

import django.utils.log.AdminEmailHandler
AdminEmailHandler(include_html=False)
'''
'handlers': {
    'mail_admins': {
        'level': 'ERROR',
        'class': 'django.utils.log.AdminEmailHandler',
        'include_html': True,
    }
},
'''