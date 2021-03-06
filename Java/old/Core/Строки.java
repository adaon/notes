/*
Специальные символы:
\b      Возврат на одну позицию     \u0008
\t      Табуляция                   \u0009
\n      Переход на новую строку     \u000a
\r      Возврат каретки             \u000d
\"      Двойная кавычка             \u0022
\'      Одинарная ковычка           \u0027
\\      Обратная косая черта        \u005c
*/

str.charAt(5) // Возвращает символ, расположенный в указанной позиции.
str.codePointAt(5) // Возвращает кодовую точку, начало или конец которой находится в указанной позиции.
str.offsetByCodePoints(5, 2) // Возвращает индекс кодовой точки, которая определяется cpCount относительно startIndex
str.compareTo("other") // Возвращает отрицательное значение, если данная строка меньше строки other, и т.д.
str.endsWith("other") // Возвращает значение true, ели строка заканчивается подстрокой other.
str.startsWith("other") // Возвращает значение true, ели строка начинается подстрокой other.
str.equalsIgnoreCase("other") // Сравнивает строки без учета регистра
/* Поиск позиции первой подстроки */
str.indexOf("sub")
str.indexOf("sub", 5) // Начиная с символа 5
/* Поиск позиции первой кодовой точки */
str.indexOf(cp)
str.indexOf(cp, 5) // Начиная с символа 5
/* Поиск позиции последней подстроки */
str.lastIndexOf("sub")
str.lastIndexOf("sub", 5) // Начиная с символа 5
/* Поиск позиции последней кодовой точки */
str.lastIndexOf(cp)
str.lastIndexOf(cp, 5) // Начиная с символа 5
str.codePointCount(startIndex, en=dIndex) // Возвращает число кодовых точек между startIndex и endIndex - 1. Половина пары, обозначающей дополнительный индекс, считается как полноправная кодовая точка.
str.replace("str1", "str2") // Возвращает новую строку, которая получается путем замены всех подстрок str1 на str2. В качестве параметров (CharSequence) могут выступать объекты String или StringBuilder.
str.substring(3)
str.substring(3, 6) // Возвращает новую строку, состоящую из всех кодовых единиц, начиная с позиции 3 и заканчивая концом строки или позицией 6 - 1.
str.toLowerCase() // Возвращает новую строку, состоящую из исходной строки с пониженным регистром всех символов.
str.toUpperCase() // Возвращает новую строку, состоящую из исходной строки с повышенным регистром всех символов.
str.trim() // Возвращает новую строку, из которой исключены все предшествующие и завершающие пробелы.

System.out.printf("%8.2f", x) // Форматированный вывод. Значение x в виде числа, размер поля которого составляет 8 цифр, а дробная часть - 2
/* Параметры форматированного вывода:
d       Десятичное целое
x       Шестрадцатиричное целое
o       Восьмеричное целое
f       Число с фиксированной или плавающей точкой
e       Число с плавающей точкой в экспоненциальной форме
g       Число с плавающей точкой в общем формате (чаще
        всего используется формат e или f, в зависимости от
        того, какой из них дает более короткую запись)
a       Шестнадцатиричное представление числа с плавающей
        точкой
s       Строка
c       Символ
b       Логическое значение
h       Хэш-код
tx      Дата и время
%       Символ процента
n       Разделитель строк, зависящий от платформы
String.format() // Форматирование строки без вывода */