f = request.FILES['file'] # Извлекает загруженный файл из запроса и возвращает объект-обертку UploadedFile
f.read() # Считывает все данные из файла
f.multiple_chunks() # Проверяет, является ли файл достаточно большим для использования множественных частей для записи
f.chunks() # Генератор частей файла
f.name # Имя загруженного файла
f.size # Размер в байтах

f.content_type # Тип содержимого, загруженный с файлом (например, text-plain, application/pdf)
f.charset # Кодировка файла
f.temporary_file_path # Путь временного файла (только для файлов, загружаемых на диск)

# Пример записи файла
destination = open('some/file/name.txt', 'wb+')
for chunk in f.chunks():
    destination.write(chunk)
destination.close()

# settings.py
FILE_UPLOAD_NAX_MEMORY_SIZE = 2500 # Максимальный размер сохраняемого в пямяти файла в байтах 
FILE_UPLOAD_TEMP_DIR = '/temp' # Папка для временного сохранения выгружаемых файлов
FILE_UPLOAD_PERMISSIONS = 0644 # Разрешения для выгружаемых файлов
FILE_UPLOAD_HANDLERS = (..., ...) # Обработчики. По умолчанию: ("django.core.files.uploadhandler.MemoryFileUploadHandler", "django.core.files.uploadhandler.TemporaryFileUploadHandler",)