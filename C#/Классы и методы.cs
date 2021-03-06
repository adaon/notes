/* Модификаторы доступа */

public // Доступен всем
protected // Доступен только самому объекту или его потомкам
private // Является закрытым и не доступен за его пределами даже для потомков
internal // Доступен только в пределах текущей сборки
protected internal // Доступен всем из данной сборки, а также типам, производным от данного

static // Статический метод или переменная
readonly // Переменная только для чтения

/* Свойства */

class Person {
    int age;
    // Создание свойства
    public int Age {
        get { return age; }
        private set { age = value; }
    }
    // Укороченный способ
    public int Age { get; set; }
}

// В общем случае способ объявления и использования методов идентичен java

/* Параметры метода */

// В таком случае при вызове переменной нужно передавать именно переменную, а не значение
public void MyMethod(ref int x) {}
obj.MyMethod(ref x); // При вызове также необходимо указывать ключевое слово ref

public void MyMethod(out int x) {} // Объявление параметра по ссылке, который не будет использован в методе, т.е. передается только для возвращения значения (только для присваивания). Такая переменная не будет инициализирована при передаче. Такая переменная ОБЯЗАТЕЛЬНО должна быть изменена внутри метода
obj.MyMethod(out x); // При вызове также необходимо указывать ключевое слово out

public void MyMethod(params int[] values) {} // Данный метод принимает любое число параметров типа int и записывает их в массив values. Каждый метод может иметь только 1 такой параметр, и он должен быть последним

/* Конструктор */

public Person() : this("", 0) {} // Вызов собственного конструктора

/* Деструктор и сборщик мусора */

GC.Collect(); // Принудительный запуск сборки мусора

~Person() {} // Деструктор, который вызывается перед уничтожением объекта

/* Метод Main() */

public static void Main(string[] args) {}

string[] args = Environment.GetCommandLineArgs(); // Альтернативный способ получения аргументов командной строки. Первым элементом всегда является полное имя запущенной программы

/* Наследование */

// Все объекты наследуют тип Object

class Person : MyClass {} // Наследование

base.attr; // Обращение к базовому классу

/* Класс Object */

// Благодаря наследованию Object, любой объект содержит содержит следующие методы (которые можно переопределять):
obj.Equals(obj2); // Проверяет идентичность объектов (сравнивает ссылки)
obj.GetHashCode(); // Возвращает хэш-значение текущего объекта в памяти
obj.GetType(); // Возвращает объект класса System.Type, по которому можно идентифицировать тип объекта
obj.ToString(); // Превращает класс в строку
obj.Finalize(); // Метод, который автоматически вызывается при уничтожении объекта
obj.MemberwiseClone(); // Создает и возвращает точную копию данного объекта

/* Переопределение методов */

// Объявление метода, который можно переопределять в подклассах
public virtual void MyMethod() {}

// Переопределение метода в подклассе
public override void MyMethod() {} // Полное переопределение (независимо от вызова)
public new void MyMethod() {} // Создание новой версии метода, которая будет вызываться только при обращении через класс наследника

/* Вложенные классы */
// Создание зависимого класса
class A {
    class B {
        
    }
}

/* Абстрактные классы и методы */

// Объявление абстрактного класса
abstract class MyClass {}

// Объявление абстрактного метода. Если у класса есть хотя бы 1 абстрактный метод, класс должен быть абстрактным
abstract public void MyMethod();