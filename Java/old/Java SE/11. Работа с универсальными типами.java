public class Class<T>
{
    public T getClass(){}
    ...
}

public class Class<T, U>
{
    public T getClass(){}
    ...
}

public static <T> T getMillis(T[] a){ ... } // Переменные типа указываются после модификаторов и перед типом возвращаемого значения.
Mil.<String>getMillis();

public static <T extends Comparable & Serializable> T min(T[] a) ... // Ограничение переменной T интерфейсами или классами. Класс должен быть первым в списке ограничений.

ArrayList<double> // нельзя, вместо этого:
ArrayList<Double>

//Нельзя объявлять массивы с параметрами типов
//Статические поля и методы с переменными типа запрещены

public static void printBuddies(Pair<? extends Employee> p) // Использование подстановочного типа   
public static void printBuddies(Pair<? super Employee> p) // Использование ограничения супертипа

java.lang.Class<T>:
T newInstance() // Возвращает новый объект, созданный с помощью конструктора по умолчанию.
T cast(Object obj) // Возвращает obj  в случае значения null или если объект может быть приведен к типу T. В противном случае генерируется
// исключение BadCastException
T[] getEnumConstants() // Возвращает массив всех значений, если T — нумерованный тип, и значение null в противном случае.
Class<? super T> getSuperclass() // Возвращает суперкласс данного класса или значение null, если T - не класс или класс Object
Constructor<T> getConstructor(Class... parameterTypes)
Constructor<T> getDeclaredConstructor(Class... parameterTypes)
// Предоставляет общедоступный конструктор либо конструктор с указанными типами параметров

java.lang.reflect.Constructor<T>:
T newInstance(Object... parameters) // Возвращает новый объект с указанными параметрами

java.lang.Class<T>:
TypeVariable[] getTypeParameters() // Если тип объявлен как универсальный, данный метод предоставляет переменные этого типа.
// В противном случае возвращается массив нулевой длины
Type getGenericSuperclass() // Предоставляет универсальный тип суперкласса, объявленного для данного типа. Если тип сообветствует Object или
// не является классом, возвращается null
Type[] getGenericInterfaces() // Предоставляет универсальные типы интерфейсов, объявленных для данного типа. Порядок следования интерфейсов
// соответствует порядку их объявления. Если данный тип не реализует ни одного интерфейса, возвращается массив нулевой длины.

java.lang.reflect.Method:
TypeVariable[] eTypeParameters() // Предоставляет переменные универсального типа, если метод объявлен как универсальный. В противном случае
// возвращается массив нулевой длины
Type getGenerixReturnType() // Предоставляет универсальный тип возвращаемого значения, объявленный для данного метода
Type[] getGenericParameterTypes() // Предоставляет универсальные типы параметров, объявленные для данного метода. Если метод не имеет параметров,
// возвращается массив нулевой длины.

java.lang.reflect.TypeVariable:
String getName() // Предоставляет имя переменной типа
Type[] getBounds() // Предоставляет ограничения подкласса для данной переменной типа. Если переменная не ограничена, возвращается массив нулевой
// длины

java.lang.reflect.WildcardType:
Type[] getLowerBounds() // Предоставляет ограничения подкласса для данной переменной типа. Если ограничения отсутствуют, то возвращается массив
// нулевой длины
Type[] getUpperBounds() // Предоставляет ограничения суперкласса для данно переменной типа. Если ограничения суперкласса отсутствуют, то
//возвращается массив нулевой длины.

java.lang.reflect.ParametrizedType:
Type getRawType() // Предоставляет низкоуровневый тип для данного параметризованного типа.
Type[] getActualTypeArguments() / /Предоставляет типы параметров, которые были объявлены.
Type getOwnerType() // Ждя внутреннего типа предоставляет внешний класс, для типа верхнего уровня возвращает значение null

java.lang.reflect.GenericArrayType:
Type getGenericComponentType() // Предоставляет тип универсального компонента, объявленного для массива