import time
time.sleep(sec) # Ожидание (в секундах)

from threading import Timer
t = Timer(secs, func)
t.start() # Вызывает функцию func спустя secs секунд