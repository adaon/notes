# settings.py
TEMPLATE_STRING_IF_INVALID = '' # Строка, которая подставляется на место несуществующей переменной в шаблоне

{# comment #} # Комментарий

{% block content %}
{% endblock content %} # При закрытии блока можно указывать имя для большей удобочитаемости

# Отключение автозамены тегов
{% autoescape on|off %}
    content
{% endautoescape %}

{% load comments %} # Загрузка

{{block.super}} # Получение содержимого родительского блока