Model.objects.create(params) # Создание и сохранение объекта за один шаг
model.mtmfield.add(obj) # Добавление объекта ManyToManyField

Model.objects.filter(author__name='sdgfsd').exclude(author__register='dg') # Исключающий фильтр

# Создание запроса не повлекает обращение к базе данных. Оно происходит при первом использовании результатов запроса.

Model.objects.get(pk=100) # Если подходящих записей не будет найдено, возбуждается исключение Model.DoesNotExist. Если будет найдено больше одной записи, возбудится исключение Model.MultipleObjectsReturned.

# Поиск по полям:
__exact='' # Точное совпадение по содержимому
__iexact='' # Точное совпадение без учета регистра
__contains='' # Поле содержит значение
__icontains='' # Поле содержит значение (без учета регистра)
__startswith='' # Начинается с ...
__endswith='' # Оканчивается на ...
__istartswith='' # Начинается с ... (без учета регистра)
__iendswith='' # Оканчивается на ... (без учета регистра)
__isnull=True

__fieldname__fieldattr__exact='' # Поиск по полям отношений. Можно использовать в обратном порядке.

# Сравнение двух полей одной модели
from django.db.models import F
Model.objects.filter(field1=F('field2'))
from datetime import timedelta
Entry.objects.filter(mod_date__gt=F('pub_date') + timedelta(days=3))

# Комплексный поиск с объектами Q
from django.db.models import Q
Model.objects.filter(Q(question__startswith='Who') | Q(question__startswith='What'))

# Обновление нескольких объектов за раз
Model.filter(...).update(name='...')

Model.objects.select_related() # Рекурсивно подготавливает кэш всех one-to-many отношений

Model.objects.filter(...).count() # Количество записей

model.model_set.add(obj1, obje2, obj3, ...) # Добавляет объекты в набор
model.model_set.create(**kwargs) # Создает новый объект, сохраняет его и добавляет в набор. Возвращает создынный объект
model.model_set.remove(obj1, obj2, obj3, ...) # Удаляет объекты из набора
model.model_set.clear() # Очищяет набор

model.model_set = [obj1, obj2, obj3] # Создание набора

Entry.objects.filter(blog=b) # Запрос с использованием объекта
Entry.objects.filter(blog=b.id) # Запрос с использованием id объекта
Entry.objects.filter(blog=5) # Запрос с использованием id напрямую