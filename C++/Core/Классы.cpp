class Person {
	int age;
	char name[];

public:
	mutable int x; // Член-mutable может изменяться константными функциями
	void setName();
	friend void func(); // Предоставление доступа к закрытым членам
	// Определение конструктора копии:
	Person(const Person &obj) {
		// Создание копии (копией является текущий объект)
	}
	explicit Person(int x) {} // Запрещение вызова конструктора с помощью присваивания (Person p = "Denis Ivanov";)
	Person(int x, int y) : nX(x), nY(y) {} // Альтернативная версия конструктора с инициализацией
	
	void show() const {} // Константная функция-член не может модифицировать объект, который ее вызвал
};

// Наследование (возможно множественное наследование)
class Student : [private] Person[, [public] Person] {
public:
	Student(int x, int y) : Person(int x)[, Base2(int y)] { // Вызов базового конструктора
		
	}
	Person::name; // Восстановление первичного доступа члена
}

// Виртуальное наследование. При наследовании только одна копия базового класса будет включаться в дочерние классы
class Student : virtual public Person {
public:
	virtual void func() { // Виртуальная функция
	}
	
	virtual void func(int par) = 0; // Объявление чисто виртуальной (абстрактной) функции
	// Если класс содержит хотя бы одну чисто виртуальную функцию, он считается абстрактным, т.е. не может иметь объектов
};

// Определение дружественных классов
class Class1 {
	/*...*/
};
class Class2 {
	friend class Class1;
};

// Определение класса внутри функции. Все функции должны определяться внутри объявления. 
void func() {
	class MyClass {
		
	};
}