# Классы являются объектами, которые служат фабриками экземпляров.

def register(cls):
	cls['name'] = 'dgs'
	return cls

@register # Декоратор класса
class My:
	
	__slots__ = ('name', 'age') # Класс может иметь аттрибуты только с такими именами
	# В таком случае уже не используется атрибут __dict__
	# Все подклассы должны также определять эту переменную
	
	# Вызов родительского конструктора
	def __init__(self, arg):
		SuperClass.__init__(self, arg)
		
		self.__name = '' # Аттрибуты с двойным символом подчеркивания автоматически переименовываются в _Classname__name
		
		super(My, self).method() # Альтернативный способ вызова метода суперкласса
	
	# Перезапись метода подкласса
	def overridedMethod(self, arg):
		SuperClass.overridedMethod(self, arg+5)
		
	# Определение метода класса, который получает ссылку на класс
	@classmethod
	def myMethod(cls, arg):
		...
		
	# Определение статического метода
	@staticmethod
	def getCount():
		...
		
	# Определение свойства — аттрибута, который вычисляется при попытке обращения к нему
	@property
	def count(self):
		return 45
	# Изменение свойства
	@count.setter
	def count(self, value):
		self.count = value
	# Удаление свойства
	@count.deleter
	def count(self):
		...

# Абстрактные классы: ================================================================================
from abc import ABCMeta, abstractmethod, abstractproperty
class Foo('''metaclass=ABCMeta'''):
	"""__metaclass__ = ABCMeta"""
	@abstractmethod
	def spam(self, a, b):
		pass
	@abstractproperty
	def name(self):
		pass
Foo.register(My) # Регистрация подкласса

# Метаклассы =========================================================================================
class DocMeta(type):
	def __init__(self,name,bases,dict):
		for key, value in dict.items():
			if key.startswith("__"): continue
			if not hasattr(value,"__call__"): continue
			if not getattr(value,"__doc__"):
				raise TypeError("%s must have a docstring" % key)
		type.__init__(self,name,bases,dict)

class Documented:
	__metaclass__ = DocMeta # class Documented(metaclass=DocMeta)
	
class Foo(Documented):
	spam(self,a,b):
		"""Doc String"""
		pass

# Определение дескриптора — объекта-свойства, обладающего методами __get__, __set__, __delete__
# Экземпляры могут создаваться ТОЛЬКО НА УРОВНЕ КЛАССОВ
class Prop:
	def __get__(self, instance, cls):
		return ...
	def __set__(self, instance, val):
		...
	def __delete__(self, instance):
		...

# Аттрибуты экземпляра:		
object.__class__ # Ссылается на объект класса экземпляра
object.__dict__ # Словарь атрибутов

# Аттрибуты класса:
Class.__name__ # Содержит имя класса
Class.__bases__ # Содержит последовательность суперклассов
Class.__module__ # Имя модуля, в котором определен класс
Class.__abstractmethods__ # Множество имен абстрактных методов
Class.__dict__ # Словарь, в котором хранятся ссылки на методы

# Аттрибуты метода:
m.__doc__ # Строка документирования
m.__name__ # Имя метода
m.__class__ # Класс, в котором определен данный метод
m.__func__ # Объект функции, реализующей данный метод
m.__self__ # Ссылка на экземпляр, ассоциированный с данным методом