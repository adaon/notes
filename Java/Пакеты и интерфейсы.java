/* Пакеты */

package my.package; // Объявление пакета

import my.package.*; // Импорт пакета

/* Интерфейсы */
// Определение интерфейса
public interface IMyInterface {
    public void myMethod(String arg);
    String name = "Denis Ivanov";
}

// Реализация интерфейса
class MyClass implements MyInterface, YourInterface {}

// Наследование интерфейсов
interface MyInterface extends YourInterface {}