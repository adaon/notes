Date d = new Date() // Создание объекта даты, инициализированного текущим временем и датой.

class java.util.GregorianCalendar:
GregorianCalendar() // Создает объект, представляющий текущее время
GregorianCalendar(int year, int month, int date)
GregorianCalendar(year, month, date, hour, minutes, seconds)
int get(int field) // Возвращает значение заданного поля:
Calendar.ERA, Calendar.YEAR,
Calendar.WEEK_OF_YEAR,
Calendar.WEEK_OF_MONTH,
Calendar.DAY_OF_MONTH,
Calendar.DAY_OF_YEAR, Calendar.DAY_OF_WEEK
Calendar.DAY_OF_WEEK_IN_MONTH,
Calendar.AM_PM, Calendar.HOUR,
Calendar.HOUR_OF_DAY, Calendar.MINUTE,
Calendar.SECOND, Calendar.MILLISECOND,
Calendar.ZONE_OFFSET
void set(int field, int value) // Устанавливаеи значения заданных полей
void set(year, month, day)
void set(year, month, day, hour, minutes, seconds)
void add(int field, int amount) // Арифметический метод для работы с датой и временем. Добавляет к полям заданную величину.
void setTime(Date time) // Устанавливает заданный момент времени
Date getTime() // Возвращает момент времени

private int count;
// Инициализационный блок
{
    count++;
}

private static int count;
// Статический инициализационный блок
static {
    count++;
}

import java.Math.*; // Импортирование статических полей и методов

//Дескрипторы метода:
@param переменная описание // параметры метода
@return описание // возвращаемое значение
@throws описание_класса // исключение
//Дескрипторы класса:
@author имя // автор
@version текст // dthcbz
//Общие дескрипторы
@since текст // Объект реализован начиная с ...
@deprecated текст // Объект не рекомендован к применению
@see ссылка // См. также. Ссылка может быть:
    "пакет.класс#элемент метка"
    "<a href="...">метка</a>"
    "текст"

javadoc -d docs {*.java/package_names}