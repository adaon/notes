# Для использования сессий должен быть активирован django.contrib.sessions.middleware.SessionMiddleware

# settings.py
SESSION_ENGINE = 'django.contrib.sessions.backends.file' # Сохранение сессий в файлах
SESSION_FILE_PATH = '' # Задание пути файлов хранения сессий
SESSION_SAVE_EVERY_REQUEST = True # Сохранять сессии при любом запросе
SESSION_EXPIRE_AT_BROWSER_CLOSE = True # Истечение сессии при закрытии браузера
SESSION_COOKIE_AGE # Время хранения сессии в секундах. По умолчанию: 1209600 (2 недели).
SESSION_COOKIE_DOMAIN # Домен (например, .mysite.ru)
SESSION_COOKIE_HTTPONLY = True # Только HTTP-cookies
SESSION_COOKIE_NAME # По умолчанию sessionid
SESSION_COOKIE_PATH # По умолчанию /
SESSION_COOKIE_SECURE # Безопасная передача. по умолчанию False

request.session # Объект класса SessionBase

class backends.base.SessionBase
    # Получение значения
    fav_color = request.session['fav_color']
    # Установка значения
    request.session['fav_color'] = 'blue'
    # Удаление значения
    del request.session['fav_color']
    # Проверка значения
    'fav_color' in request
    # Получение значения
    fav_color = request.session.get('fav_color', 'red')
    # Получение значения
    fav_color = request.session.pop('fav_color')
    keys()
    items()
    setdefault()
    clear()
    # Удаляет текущие сессионные данные и восстанавливает ключ, который посылается пользователю
    flush()
    # Устанавливает тестовые данные
    set_test_cookie()
    # Работают ли тестовые данные
    test_cookie_worked()
    # Удаляет тестовые данные
    delete_test_cookie()
    # Устанавливает срок годности для сессии
    set_expiry(value)
        # Если целое число - сессия закончится после истечения этого времени в секундах.
        # Если datetime или timedelta - сессия истечет в это указанное время.
        # Если 0 - сессия истечет при закрытии браузера.
        # Если None, сессия наследует глобальные настройки истечения.
    # Возвращает число секунд, когда сессия истечет.
    get_expiry_age()
    # Возвращает дату истечения сессии
    get_expiry_date()
    # Истекает ли сессия при закрытии браузера
    get_expire_at_browser_close()

