from django.db import models
class MyModel(models.Model): pass # Создание класса модели

# Типы полей:
OneToOneField(model)

class My(models.Model):
	...
	blog = ForeignKey(Blog, related_name='entries') # Теперь можно обращаться к списку из модели Blog как entries
	blogs = ManyToManyField(Blog, related_name='entries') # Теперь можно обращаться к списку из модели Blog как entries
	 # Мета опции
	class Meta[(SomeClass.Meta)]: # Наследование мета-класса
		ordering = ["name"] # Сортировка
		db_table = ["my_table"] # Имя таблицы в базе
		verbose_name = "name" # Отображаемое имя
		verbose_name_plural = "names" # Отображаемое имя в множественном числе
		
		abstract = True # Создание абстрактного класса модели
	# Данный метод возвращает абсолютный url объекта
	def get_absolute_url(self): pass
	# Перезапись метода save
	def save(self, *args, **kwargs):
        do_something()
        super(My, self).save(*args, **kwargs) # Call the "real" save() method.
        do_something_else()

# Общие опции полей модели:
null # Если True, джанго будет сохранять пустые значения как NULL в базе. По умолчанию False.
blank # Если True, поле может быть пустым. По умолчанию False.
choices # Последовательность кортежей вида ('value', 'Title'), представляющих элементы выбора для этого поля. Отображаемое значение (Title) может быть получено так: model.get_FIELD_display()
default # Значение по умолчанию. Может быть переменной или вызываемым объектом, который будет вызываться каждый раз при создании нового объекта.
help_text # Подсказка для поля
primary_key # Если True, данное поле будет первичным ключом для модели.
unique # Если True, данное поле должно быть уникальным

id = models.AutoField(primary_key=True) # Джанго подставляет данное поле по умолчанию в каждую модель.
# Если определить собственное поле primary_key, данное поле не будет подставляться.

# Для каждого поля можно задать отображаемое имя, которое должно писаться с маленькой буквы.
name = models.FieldType('имя')
name = models.FieldType(verbose_name='имя')

Model.objects.create(params) # Создание объекта модели

# Дополнительные связи ManyToMany.
# Чтобы присоединить персону к группе, необходимо создать объект Membership, персона автоматически будет добавлена.
class Person(models.Model):
    name = models.CharField(max_length=128)
class Group(models.Model):
    name = models.CharField(max_length=128)
    members = models.ManyToManyField(Person, through='Membership')
# Кроме отношений промежуточная модель не может иметь полей ForeignKey
class Membership(models.Model):
    person = models.ForeignKey(Person)
    group = models.ForeignKey(Group)
    date_joined = models.DateField()
    invite_reason = models.CharField(max_length=64)

# Прокси-модель (для обеспечения дополнительной функциональности)
class MyUser(User):
    class Meta:
        proxy = True

    def do_something(self):
        ...
    
Person.objects.filter(group__name='The Beatles', membership__date_joined__gt=date(1961,1,1)) # Фильтр по промежуточной модели
    
beatles.members.clear() # Очистка всех отношений ManyToMany

Group.objects.filter(members__name__startswith='Paul') # Фильтр с учетом отношений ManyToMany