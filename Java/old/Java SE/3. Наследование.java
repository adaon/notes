В подклассе необходимо реализовывать метод equals с помощью метода getClass(), в суперклассе - с помощью instanceof

метод equals:
    * Проверить, идентичны ли ссылки объектов (==).
    * Проверить, является ли другой объект нулевой ссылкой (null).
    * Сравнить классы.
    * Преобразовать другой объект в переменную требуемого класса.
    * Сравнить все поля.

@Override public void equals // явное переопределение

Integer i = new Integer(25);
i.intValue()
Integer.toString(int i)
Integer.toString(int i, int radix) // число в другой системе счисления
Integer.parseInt(String s)
Integer.parseInt(String s, int radix)
Integer.valueOf(String s)

public void setValues(int... values) // переменное число параметров

Class cl = obj.getClass() // возвращает экземпляр типа Class, соответствующий используемому классу
cl.getName() // Возвращает название класса
Class cl = Class.forName("Class name") // возвращает экземпляр типа Class, соответствующйи инмени
Class cl = obj.class;
cl.newInstance() // создает новый экземпляр

Field[] a = cl.getFields()
Field[] a = cl.getDeclaredFields() // возвращает массив экземпляров java.reflection.Field
Method[] a = cl.getMethods()
Method[] a = cl.getDeclaredMethods() // возвращает массив экземпляров java.reflection.Method
Constructor[] a = cl.getConstructors()
Constructor a = cl.getDeclaredConstructors()

Class a.getDeclaringClass()
Class[] a.getExceptionTypes()
int a.getModifers()
String a.getName()
Class[] a.getParameterTypes()
Class a.getReturnType()

Modifer.toString(int mods)
Modifer.isAbstract(int mods)
Modifer.isFinal(int mods)
Modifer.isInterface(int mods)
Modifer.isNative(int mods)
Modifer.isPrivate(int mods)
Modifer.isProtected(int mods)
Modifer.isPublic(int mods)
Modifer.isStatic(int mods)
Modifer.isStrict(int mods)
Modifer.isSynchronized(int mods)
Modifer.isVolatile(int mods)

Field name = cl.getDeclaredField("name")
name.setAccessible(true)
String n = name.get(object)
name.set(object, value)
name.isAccessible()