# Вычисление среднего значения
from django.db.models import Avg
Book.objects.[all().]aggregate(Avg('price')) # Вернет {'price__avg': 34.456}
Book.objects.aggregate(average_price=Avg('price')) # Вернет {'average_price': 34.456}

from django.db.models import Avg, Max, Min, Count
Book.objects.aggregate(Avg('price'), Max('price'), Min('price'))
# {'price__avg': 34.35, 'price__max': Decimal('81.20'), 'price__min': Decimal('12.99')}

# Вычисление количества авторов для каждой книги
q = Book.objects.annotate(Count('authors')) # Назначает каждому объекту в queryset дополнительные аттрибуты. Возвращает объект QuerySet.
q[0].authors__count
q = Book.objects.annotate(num_authors=Count('authors')) # Пользовательское имя аттрибута
q[0].num_authors

# Применение агрегации к отношениям
Store.objects.annotate(min_price=Min('books__price'), max_price=Max('books__price'))
Store.objects.aggregate(min_price=Min('books__price'), max_price=Max('books__price'))
Store.objects.aggregate(youngest_age=Min('books__authors__age'))