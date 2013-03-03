# _thread
_thread.start_new_thread(func, (args,)) # Открывает новый поток, вызывая функцию func с аргументами в кортеже args

mut = _thread.allocate_lock() # Создание объекта блокировки
mut.acquire() # Заблокировать объект
mut.release() # Освободить блокировку
mut.locked() # Проверяет блокировку потока

with mut: # Блокировка приобретается/освобождается автоматически
	...

# threading
threading.Lock() # Создает объект блокировки (то же, что _thread.allocate_lock())

class MyThread(threading.Thread):
	def run(self):
		...
		
thread = MyThread()
thread.start() # Запускает метод run объекта в новом потоке
thread.join() # Ждать завершения потока

thread = threading.Thread(target=func[, args=(arg, )]) # Создает объект потока, вызывающий функцию func