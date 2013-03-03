# Выполнение строкового запроса. Возвращает объект RawQuerySet, подобный QuerySet
Person.objects.raw('SELECT * FROM myapp_person')
# С отображением имен столбцов на аттрибуты
Person.objects.raw('''SELECT first AS first_name,
	                         last AS last_name,
                             bd AS birth_date,
                             pk as id,
                      FROM some_other_table''')
# С отображением имен столбцов на аттрибуты (альтернативный вариант)
name_map = {'first': 'first_name', 'last': 'last_name', 'bd': 'birth_date', 'pk': 'id'}
Person.objects.raw('SELECT * FROM some_other_table', translations=name_map)

# Выборка определенных имен
people = Person.objects.raw('SELECT id, first_name FROM myapp_person')
for p in people:
	print p.first_name, # Будет получено из оригинального запроса
	print p.last_name # Будет получено по запросу

# Вставление параметров в строковой запрос	
lname = 'Doe'
Person.objects.raw('SELECT * FROM myapp_person WHERE last_name = %s', [lname])

# Выполнение SQL-запросов напрямую
from django.db import connection, transaction
cursor = connection.cursor()

# Модификация данных - необходима отправка
cursor.execute("UPDATE bar SET foo = 1 WHERE baz = %s", [self.baz])
transaction.commit_unless_managed()

# Получение данных - отправка не нужна
cursor.execute("SELECT foo FROM bar WHERE baz = %s", [self.baz])
row = cursor.fetchone()
rows = cursor.fetch_all()

# Взаимодействие с несколькими базами
from django.db import connections
cursor = connections['my_db_alias'].cursor()
transaction.commit_unless_managed(using='my_db_alias')

def dictfetchall(cursor):
    "Возаращает полученные строки в виде списка словарей"
    desc = cursor.description
    return [
        dict(zip([col[0] for col in desc], row))
        for row in cursor.fetchall()
    ]