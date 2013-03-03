### Сайты ###

# settings.py
INSTALLED_APPS = (
    # ...
    'django.contrib.sites'
    # ...
)
# Данный параметр должен быть равен аттрибуту SITE_ID используемого объекта сайта
SITE_ID = 0

# models.py
from django.contrib.sites.models import Site
from django.contrib.sites.managers import CurrentSiteManager
class MyModel(models.Model):
    # ...
    sites = models.ManyToManyField(Site) # Ассоциирование модели с несколькими сайтами
    site = models.ForeignKey(Site) # Ассоциирование модели с одним сайтом
    objects = models.Manager()
    on_site = CurrentSiteManager(['pub_on']) # Включение в модель менеджера, который отбирает при запросе только объекты, ассоциированные с текущим сайтом. Если поле модели, ассоциированное с сайтом отличается от site, нужно передать это имя в конструктор менеджера
    
# views.py
def my_view(request):
    a = get_object_or_404(MyModel, id=456, sites__id=settings.SITE_ID) # Получение объекта, ассоциированного с определенными сайтами
    
# Получение объекта текущего сайта
Site.objects.get_current()

### Стандартная библиотека Django (django.contrib) ###

admin # Административный интерфейс
admindocs # Автоматически сгенерированная документация по административному интерфейсу
auth # Подсистема аутентификации Django
comments # Приложение для управления комментариями
contenttypes # Подстстема подключения к типам содержимого, в которой каждая установленная модель Django является отдельным типом
csrf # Защита от техники подделки запросов
databrowse # Просмотр данных
flatpages # Простые страницы
formtools # Инструменты для работы с формами
gis # Инструменты для работы с геолокационными системами
humanize # Придание данным удобочитаемости
localflavor # Инструменты локализации
markup # Набор шаблонных фильтров для реализации распространенных языков разметки
redirects # Управление переадресацией
sessions # Сессии
sitemaps # Карты сайтов
sites # Подсистема, позволяющая эксплуатировать несколько веб-сайтов с одной базой и инсталляцией Django
syndication # Создание каналов синдицирования
webdesign # Дополнительные модули для дизайнеров

### Удобочитаемость ###

# django.contrib.humanize

INSTALLED_APPS = (
    'django.contrib.humanize',
)
# template.html
{% load humanize %}

# Шаблонные фильтры:
apnumber # Возвращает словесный экфивалент цифр от 1 до 9
intcomma # Преобразует целое число в строку, где группы по три цифры разделены запятыми
intword # Преобразует большое целое число в эквивалентное текстовое представление
ordinal # Преобразует целое число в порядковое числительное

### Фильтры разметки ###

INSTALLED_APPS = (
    'django.contrib.markup',
)
# template.html
{% load markup %}
# Поддерживает textile, markdown, restructuredtext
{{ object.content|textile }}