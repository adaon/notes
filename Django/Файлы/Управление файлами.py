class MyModel(models.Model):
    ...
    photo = models.ImageField(upload_to='cars')
    
car = Car.objects.get(name='...')
car.photo.name # Имя файла изображения
car.photo.path # Путь к файлу изображения
car.photo.url # Адрес изображения

from django.core.files import File
f = open('/some/path.ext', 'w')
myfile = File(f)

### Хранилище файлов ###

# settings.py
DEFAULT_FILE_STORAGE = # Хранилище файлов по умолчанию

from django.core.files.storage import default_storage
from django.core.files.base import ContentFile

path = default_storage.save('/path/to/file', ContentFile('new content')) # Сохранение файла в хранилище
default_storage.size(path) # Размер файла
default_storage.open(path).read() # Чтение файла
default_storage.delete(path) # Удаление файла
default_storage.exists(path) # Проверка существования файла

# Встроенные классы файловых хранилищ

from django.db import models
from django.core.files.storage import FileSystemStorage

fs = FileSystemStorage(location='/media/photos')

class Car(models.Model):
    ...
    photo = models.ImageField(storage=fs)