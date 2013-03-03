class My:
	# Метод класса. Вызывается для создания нового экземпляра.
	def __new__(cls, *args, **kwargs):
		return ...
	# Вызывается для строкового представления объекта (например, в функции str())
	def __str__(self):
		return self.title
	# Вызывается для технического строкового представления объекта (например, в функции repr())
	def __repr__(self):
		return self.title
	def __int__(self):
		...
	def __float__(self):
		...
	def __complex__(self):
		...
	# Создает форматированное строковое представление
	def __format__(self, format_spec):
		...
	# Перегрузка левого оператора + (obj + value)
	def __add__(self, value):
		return ...
	# Перегрузка правого оператора + (value + object)
	def __radd__(self, value):
		return ...
	# Перегрузка оператора комбинированного сложения (+=)
	def __iadd__(self, obj):
		return ...
	# Перегрузка индексации
	def __getitem__(self, index):
		return values[index]
	# Перегрузка присваивания элемента по индексу
	def __setitem__(self, index, value):
		self.data[index] = value
	# Перегрузка оператора in
	def __contains__(self, x):
		return True | False
	# Обращение к несуществующим аттрибутам
	def __getattr__(self, attrname):
		return ...
	# Вызывется при ЛЮБОЙ попытке присваивания значения аттрибуту
	def __setattr__(self, attrname, value):
		...
	# Вызывается при ЛЮБОМ обращении к аттрибуту
	def __getattribute__(self, attrname):
		return ...
	# Перегрузка вызова экземпляра как функции
	def __call__(self, *args, **kwargs):
		...
	# Деструктор
	def __del__(self):
		...
	# Логическое значение
	def __bool__(self):
		...
	# Hash
	def __hash__(self):
		...
	# Сравнение
	__lt__(self, other) # self < other
	__le__(self, other) # self <= other
	__gt__(self, other) # self > other
	__ge__(self, other) # self >= other
	__eq__(self, other) # self == other
	__ne__(self, other) # self != other
	
	# Проверка типа
	__instancecheck__(cls, object) # isinstance(object, cls)
	__subclasscheck__(cls, sub) # issubclass(sub, cls)
	
	# Вход и выход из контекста
	__enter__(self)
	__exit__(self, type, value, tb)