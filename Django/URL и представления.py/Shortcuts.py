from django.shortcuts import *

# Возвращает объект HttpResponse
render(request, template[, dictionary][, context_instance][, content_type][, status][, current_app])
# Обязательные аргументы:
request # Объект запроса
template # Полное имя шаблона
# Опциональные аргументы:
dictionary # Словарь значений, добавляемый в контекст
context_instance # Экземпляр контекста
content_type # MIME-тип. Значение по умолчанию размещается в переменной DEFAULT_CONTENT_TYPE settings.py
status # Код статуса ответа. По умолчанию - 200
current_app # Текущее приложение

# Возвращает объект HttpResponse
render_to_response(template_name[, dictionary][, context_instance][, mimetype])
# Обязательные параметры
template_name # Полное имя шаблона
# Опциональные аргументы
dictionary # Словарь значений, добавляемый в контекст
context_instance # Экземпляр контекста
content_type # MIME-тип. Значение по умолчанию размещается в переменной DEFAULT_CONTENT_TYPE settings.py

# Перенаправление
redirect(to[, permanent=False], *args, **kwargs)
# Перенаправление на объект (будет вызван метод get_absolute_url() объекта)
object = MyModel.objects.get(...)
return redirect(object)
# Перенаправление на представление
return redirect('some-view-name', foo='bar')
# Перенаправление на внутренний url
return redirect('/some/url/')
# Перенаправление на внешний url
return redirect('http://example.com/')

# Отыскивает и возвращает объект или возбуждает исключение 404
get_object_or_404(class, *args, **kwargs)
class # Экземпляр Model, Manager или QuerySet, в котором нужно найти объект
**kwargs # Параметры поиска

# Фильтрует и возвращает список, иначе возбуждает исключение 404
get_list_or_404(class, *args, **kwargs)
class # Экземпляр Model, Manager или QuerySet, в котором нужно найти объект
**kwargs # Параметры поиска