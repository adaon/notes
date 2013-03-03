isCanVote = age > 18 ? true : false; // Тернарный оператор

// Перегрузка операторов
class Class {
public:
	Person operator+(Person obj) {} // Параметром передается объект, стоящий справа от оператора
	Person operator++() {} // Перегрузка префиксной формы инкремента
	Person operator++() {int notused} // Перегрузка постфиксной формы инкремента
	friend ostream& operator<<(ostream &stream, Person& obj); // При перегрузке операторов с помощью внешней функции
	//передаются 2 параметра
};

// Перегрузка оператора вывода
ostream& operator<<(ostream &stream, Class& obj) {
	stream << obj.x << " (" << obj.y << ")";
	return stream;
}

// Перегрузка оператора ввода
istream& operator>>(istream& stream, Person& obj) {
	//...
	return stream;
}

x = (y = 3, y + 1); // Оператор последовательного вычисления связывает несколько выражений в одно и присваивает переменной правое из них