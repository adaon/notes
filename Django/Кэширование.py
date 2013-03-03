### Настройка кэша ###

# Можно также использовать механизм memcached

# Создание таблцы для хранения кэша в базе данных
manage.py createcachetable my_table
# settings.py
CACHE_BACKEND = 'db://my_table'

# Хранение кэша в файловой системе
# settings.py
CACHE_BACKEND = 'file://C:/foo/bar' # Данный путь должен быть абсолютным

# Кэширование в локальной памяти
# settings.py
CACHE_BACKEND = 'locmem:///'

# Фиктивное кэширование (для разработки)
# settings.py
CACHE_BACKEND = 'dummy:///'

# Также в URL кэша можно использовать следующие параметры (locmem://?param=value):
timeout # Время хранения кэша в секундах. По умолчанию - 300
max_entries # Для механизмов locmem, filesystem, database определяет максимальное количество эллементов в кэше, по достижении которого старые значения начинают удаляться. По умолчанию - 300
cull_percentage # Доля элементов кэша, удаляемых при достижении порога mzx_entries. Вычисляется как 1/cull_percentage, то есть при 2 будет удалена половина элементов кэша

### Кэширование на уровне сайта ###

# Кэшированию подвергаются все страницы, для которых в запросе GET или POST нет параметров
# settings.py
MIDDLEWARE_CLASSES = (
    #...
    django.middleware.cache.UpdateCacheMiddleware,
    django.middleware.common.CommonMiddleware,
    django.middleware.cache.FetchFromCacheMiddleware
)
CACHE_MIDDLEWARE_SECONDS = 0 # Сколько секунд страница должна храниться в кэше
CACHE_MIDDLEWARE_KEY_PREFIX = '' # Если на одном сервере под управлением одной инсталляции django работает несколько сайтов с общим кэшем, то укажите в этом параметре имя сайта или еще какую-нибудь уникальную строку, чтобы предотвратить коллизии ключей
CACHE_MIDDLEWARE_ANONYMOUS_ONLY = True # Кэшировать только запросы от анонимных пользователей

### Кэширование на уровне представлений ###
from django.views.decorators.cache import cache_page

@cache_page(300) # Принимает время хранения в секундах
def my_view(request):
    ...
# или url
(r'^foo/bar/$', cache_page(my_view, 300)),

### Кэширование фрагментов шаблона ###

# Можно передать дополнительные аргументы, которые будут использоваться для уникального кэширования
{% load cache %}
{% cache 300 my_frag [request.user.username] %}
    ...
{% endcache %}

### Низкоуровневый API кэширования ###

from django.core.cache import cache

cache.set('my_key', 'my_value', 30) # Установка значения в кэш
cache.add('my_key', 'my_value', 30) # Добавляет значение в кэш, если оно еще не существует (возвращает True в случае успеха или False)
cache.get('my_key'[, 'default_value']) # Получение значения из кэша. Если объекта нет в кэше, возвращает None
cache.get_many(['key1', 'key2']) # Возвращает словарь с ключами и значениями запрощенных элементов из кэша
cache.delete('key') # Удаление элемента из кэша
cache.incr('key'[, 10]) # Увеличение численного значения в кэше (по умолчанию на 1)
cache.decr('key'[, 10]) # Уменьшение численного значения в кэше (по умолчанию на 1)

### Заголовка Vary ###

from django.views.decorators.vary import vary_on_headers
# Включение уникальности кэширования по заголовку
@vary_on_headers('User-Agent')
def my_view(reqeust):
    ...
    
### Управление кэшем ###

# Управление дополнительными свойствами кэширования
from django.views.decorators.cache import cache_control
@cache_control(
    public=True,
    private=True,
    no_cache=True,
    no_transform=True,
    must_revalidate=True,
    proxy_revalidate=True,
    max_age=num_seconds,
    s_maxage=num_seconds
)
def my_view(request):
    ...
    
# Никогда не кэшировать
from django.views.decorators.cache import never_cache
@never_cache
def my_view(request):
    ...