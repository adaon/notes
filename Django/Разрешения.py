### Разрешения по умолчанию ###

# По умолчанию для каждой модели создаются три разрешения: add, change и delete.

# Проверка наличия разрешений
user.has_perm('shop.add_mymodel') # Добавления объектов MyModel
user.has_perm('shop.change_mymodel') # Изменения объектов MyModel
user.has_perm('shop.delete_mymodel') # Удаления объектов MyModel

### Пользовательские разрешения ###

class MyModel(models.Model):
    class Meta:
        permissions = (
            ("view_mymodel", "Can see available tasks"),
            ("change_mymodel_status", "Can change the status of tasks"),
            ("close_mymodel", "Can remove a task by setting its status as closed"),
        )
user.has_perm('app.view_mymodel')

### Класс Permission ###

from django.contrib.auth.models import Permission
perm.name # Требуется. Максимум 50 символов. Содержит краткое описание разрешения.
perm.content_type # Требуется. Ссылка на таблицу django_content_type, которая содержит запись для каждой установленной модели
perm.codename # Требуется. Максимум 100 символов. Например, can_vote