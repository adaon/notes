class MyManager(models.Manager):
    # ...

class Person(models.Model):
    objects = models.Manager()
    people = models.Manager() # Изменение имени менеджера по умолчанию
    my_manager = MyManager() # Определение своего менеждера
    
# В АДМИНИСТРАТИВНОМ ИНТЕРФЕЙСЕ И ДРУГИХ СИСТЕМАХ ПО УМОЛЧАНИЮ ИСПОЛЬЗУЕТСЯ МЕНЕЖДЕР, СТОЯЩИЙ ПЕРВЫМ В ОПРЕДЕЛЕНИИ КЛАССА МОДЕЛИ