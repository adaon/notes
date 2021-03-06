string s1("hello"); // Инициализация путем передачи строки конструктору
string s1(5, "a"); // Создает строку "ааааа"
string s2(s1, 0, 8); // Копирование первых 8 символов в новую строку
string s2 = s1.substr(20, 10); // Копирует 10 символов, начиная с элемента 20
string s2 = s1.substr(); // Возвращает копию всего объекта

// Данные функции возвращают текущую длину строки
s1.size();
s1.length();
s1.capacity(); // Возвращает количество символов, которое может хранить строка без перераспределения памяти

s1.insert(5, "hello"); // Вставка строки в позицию перед 5
s1.reserve(500); // Резервирование достаточного объема памяти
s1.apend("hello"); // Присоединение строки в конец
s1.replace(5, 3, "hello"); // Заменяет 3 символа после 5 строкой "hel"

s1.find("hello"); // Возвращает индекс вхождения подстроки. Если подстрока не найдена, возвращает string::npos
s1.find("hello", 5); // 5 — начальная позиция поиска
s1.find_first_of(); // Ищет в строке и возвращает позицию первого символа, совпадающего с любым символом группы
s1.find_last_of(); // Ищет в строке и возвращает позицию последнего символа, совпадающего с любым символом группы
s1.find_first_not_of(); // Ищет в строке и возвращает позицию первого элемента, не совпадающего ни с одним из группы.
s1.find_last_not_of(); // Ищет в строке и возвращает позицию последнего элемента, не совпадающего ни с одним из группы.
rfind(); // Перебирает строку в обратном направлении, ищет заданные лексемы и возвращает индекс совпадающего элемента

replace(name.begin(), name.end(), 'h', 'b'); // Алгоритм поиска и замены одного объекта другим на определенном интервале

s1.erase(0, 5); // Удаляет первые 5 символов из строки
s1.c_str(); // Возвращает указатель const char.

s1.compare("hello"); // Возвращает 0 при идентичности строк
s1.compare(0, 5, s2[, 0, 5]); // сравнивает 5 первых символов строки с первыми 5 символами другой строки

s1.at(2); // Возврашает 2 символ. Отличие данного метода от оператора [] в генерации исключения out_of_range функцией at при выходе за границы