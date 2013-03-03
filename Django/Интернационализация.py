### Переводимые строки ###

# В представлениях

from django.utils.translation import ugettext as _
def my_view(request):
    output = _('Welcome to my site!') # Создание переводимой строки
    output = _('Today is %(month)s %(day)s' % {'month': m, 'day': d}) # При интерполяции строк необходимо использовать именование, чтобы переводчик смог переставить локализованные переменные местами при необходимости
    
from django.utils.translation.ugettext_noop
ugettext_noop('string') # Создание переводимой, но не требующей перевода строки

from django.utils.translation.ugettext_lazy
ugettext_lazy('string') # Создание переводимой строки, перевод которой будет осуществлен только при обращении к строке. В моделях нужно пользоваться ТОЛЬКО ОТЛОЖЕННЫМ ПЕРЕВОДОМ

# Образование множественного числа
from django.utils.translation import ungettext
page = ungettext('string %(count)d string' % {'count':5})

# В шаблонах

{% load i18n %}
# Перевод
{% trans "This is the title." %}
{% trans myvar %}
{% trans "myvar" noop %} # Поиск переменной производится, но перевод опускается

# Блочный перевод
{% blocktrans %}
    This is my title!
{% endblocktrans %}

# Использование фильтрованной переменной (может использоваться нескоько с помощью слова add)
{% blocktrans with value|filter as myvar %}
    This is my title {{myvar}}!
{% endblocktrans %}

# Образование единственной и множественной формы
{% blocktrans count list|length as counter %}
There is only one {{name}} object.
{% plural %}
There are {{counter}} {{name}} objects.
{% endblocktrans %}

# Каждый объект RequestContext содержит:
LANGUAGES # Список кортежей, в каждом из которых первый элемент - код языка, а второй - название языка
LANGUAGE_CODE # Код предпочтительного для пользователя языка в виде строки, например, en-us
LANGUAGE_BIDI # Направление чтения (True - справа налево, False - слева направо)
# Если объект RequestContext не используется, получить эти значения можно так:
{% get_current_language as LANGUAGE_CODE %}
{% get_available_languages as LANGUAGES %}
{% get_current_language_bidi as LANGUAGE_BIDI %}

### Объекты отложенного перевода ###

from django.utils.translation import string_concat
result = string_concat(['name', 'surname']) # Создает объект отложенного вызова, который объединяет свои аргументы и преобразует их в строки, только когда результат вычисляется в строковом контексте

# Данный декоратор преобразует функцию таким образом, что если при ее вызове в первом аргументе передается объект отложенного вызова, то выполнение отклатывается до того момента, когда его будет необходимо преобразовать в строку
from django.utils.functionals import allow_lazy
@allow_lazy
def my_func(s):
    # ...
    
### Файлы перевода ###
# Пропущено с 379 до конца главы