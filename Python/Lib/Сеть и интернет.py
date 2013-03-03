### Сокеты ###

# Сервер
from socket import *
s = socket(AF_INET, SOCK_STREAM) # Создать объект сокета IP, TCP
s.bind(('localhost', 5007)) # Связать объект сокета с адресом и портом
s.listen(5) # Не более 5 ожидающих запросов
while True:
    connection, address = s.accept()
    print('Server connected by ' + address)
    while True:
        data = connection.recv(1024) # Читать строку из сокета
        if not data: break # Пока данные поступают
        connection.send(b'Echo=>' + data) # Отправить ответ клиенту
        connection.close() # Закрывает соединение с клиентом
        
# Клиент
import sys
from socket import *
s = socket(AF_INET, SOCK_STREAM) # Создать объект сокета
s.connect(('localhost', 5007)) # Соединиться с сервером
s.send(b'Hello') # Отправить строку байтов
data = s.recv(1024) # Получить строку байтов 
s.close() # Закрывает соединение

# Автоматическое обслуживание
import socketserver
server = socketserver.ThreadingTCPServer((host, port), handler) # Создание многопоточного сервера
server.serve_forever() # Старт обслуживания

socket.makefile() # Возвращает сокет, обернутый объектом файла, который предоставляет методы write и read