l = [x + 1 for x in list] # Генератор списков
l = [x + x for x in list if x > 5] # Расширенный генератор списков с условием
l = [x + y for x in list for y in list] # Вложенные циклы

gen = (x + 1 for x in range(10)) # Генератор выражений формирует итерируемый генератор
gen.next()

class Iter:
	def __next__(self):
		return self.value + 1
class My:
	# Вызывается для получения итератора (который должен содержать функцию next(), __next__(3.0))
	def __iter__(self):
		return Iter()
		
iter(obj) # Вызывает функцию __iter__ и возвращает результат
next(iter) # Вызывает функцию __next__ или next и возвращает результат