# Операторы выражений
yield x						# Поддержка протокола send в функциях-генераторах
lambda args expression		# Создает анонимную функцию
x if y else z				# Трехместный оператор выбора
x or y						# Логическое или
x and y						# Логическое и
not x						# Логическое не
x in y, x not in y			# Проверка на вхождение
x | y						# Битовая операция или, объединение множеств
x ^ y 						# Битовая операция исключающее или, симметрическая разность множеств
x & y 						# Битовая операция И, пересечение множеств
x << y, x >> y				# Сдвиг значения x влево или вправо на y Битов
x / y, x // y				# Деление: истинное и с округлением вниз
x ** y						# Возведение в степень

# Битовые операции
x << y # Сдвиг влево
x >> y # Сдвиг вправо
x & y # Битовая операция И
x | y # Битовая операция ИЛИ
x ^ y # Битовая операция исключающее ИЛИ
`x # Битовая операция НЕ

0 < x < 5 # Принадлежит ли x множеству от 0 до 5

x / y # Классическое деление (в python 3 - истинное деление)
x // y # Деление с округлением вниз

if x == y # Равны ли значения объектов x и y
if x is y # Ссылаются ли x и y на один и тот же объект

x or y # Вернет левый операнд, если он имеет истинное значение. Иначе вернет правый операнд
x and y # Вернет левый операнд, если он имеет ложное значение, иначе вернет правый операнд