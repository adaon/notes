public class Person implements Comparable<Person> // Реализация интерфейса Comparable для использования метода сортировки Arrays.sort()
{
	public int compareTo(Person other)
	{
		return this.val = other.val; // Простая проверка поля на равенство.
	}
}
Arrays.sort(array[])

public class Person implements Cloneable // Реализация клонирования
{
	public Object clone(){}
}

public class Person
{
	public class Employee
	{
		public void setF()
		{
			Person.this // Ссылка на объект внешнего класса
		}
	}
}

Person person = new Person();
Person.Employee = new person.new Employee(); // Создание экземпляра общедоступного внутреннего класса

public class Person
{
	public static class Employee // Статический внутренний класс (не содержит ссылку на объект внешнего класса)
	{
	}
}