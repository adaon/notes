template <class T> void func(T &n1, T&n2); // Объявление шаблонной (обобщенной) функции

template <typename T> void func(); // Альтернативная форма объявления шаблона

template <class type1, class type2>
void func(); // Объявление шаблонной (обобщенной) функции с двумя типами

template<> void func<int>(); // Специализированная шаблонная функция

template <class T> class List {/*...*/} // Объявление шаблонного класса
template <class T, class X> class List {/*...*/} // Объявление шаблонного класса
template <class T=int> class List {/*...*/} // Объявление шаблонного класса с определением типа по умолчанию
template <int size> class List {/*...*/} // Объявление шаблонного класса с указанием значение вместо класса

template <class T> MyClass {
	typename T::MyType p; // Объявление переменной внутреннего типа класса T.
}