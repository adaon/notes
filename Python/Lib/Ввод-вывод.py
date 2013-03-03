from io import StringIO, BytesIO # Имитирует поведение файлов ввода-вывода
b = StringIO()
b.getvalue() # Получить строковое значение

print('Hello, world!', file=fileobj) # Возможность одноразового перенаправления инструкции print