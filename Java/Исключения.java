try {
    //...
}
catch(Exception1 e) {
    //...
}
catch(Exception2 e) {
    //...
}
finally {
    // Код, выполняемый всегда, независимо от генерации исключений (используется для освобождения ресурсов и т.д.)
}
    
throw new MyException("message"); // Генерация исключения

// Указание, что метод может генерировать исключение определенных типов
public void myMethod() throws MyException, MyException2 {}

thr.fillInStackTrace(); // Возвращает Throwable-объект, который содержит полную трассу стека. Этот объект может быть выброшен повторно
thr.getLocalizedMessage(); // Возвращает локализованное описание исключения
thr.getMessage(); // Возвращает описание исключения
thr.printStackTrace(); // Отображает трассу стека
thr.printStackTrace(printWriter); // Посылает трассу стека указанному потоку
thr.printStackTrace(printStream); // Посылает трассу стека указанному потоку
thr.toString(); // Возвращает String-объект, содержащий описание исключения

/* Встроенные классы исключений */

Throwable // Базовый класс всех исключений и ошибок
    Exception // Исключительные состояния, перехватываемые пользователем
        RuntimeException // Исключения времени выполнения
    Error // Исключения среды, обрабатываемые системой времени выполнения

// Неконтролируемые исключения

ArithmeticException                 // Арифметическая ошибка, такая как деление на ноль.
ArraylndexOutOfBoundsException      // Выход индекса за границу массива.
ArrayStoreException                 // Присваивание элементу массива объекта несовместимого типа.
ClassCastException                  // Неверное приведение.
EnumConstantNotPresentException     // Попытка использования неопределенного значения перечисления.
IllegalArgumentException            // Неверный аргумент использован при вызове метода.
IllegalMonitorStateException        // Неверная операция мониторинга, такая как ожидание незаблокированного потока.
IllegalStateException               // Окружение или приложение в некорректном состоянии.
IllegalThreadStateException         // Запрошенная операция несовместима с текущим состоянием потока.
IndexOutOfBoundsException           // Некоторый тип индекса вышел за допустимые пределы.
NegativeArraySizeException          // Создан массив отрицательного размера.
NullPointerException                // Неверное использование нулевой ссылки.
NumberFormatException               // Неверное преобразование строки в числовой формат.
SecurityException                   // Попытка нарушения безопасности.
StringlndexOutOfBounds              // Попытка использования индекса за пределами строки.
TypeNotPresentException             // Тип не найден (добавлено в J2SE 5).
UnsupportedOperationException       // Обнаружена неподдерживаемая операция.

// Контролируемые исключения

ClassNotFoundException              // Класс не найден.
CloneNotSupportedException          // Попытка клонировать объект, который не реализует интерфейс Cloneable.
IllegalAccessException              // Доступ к классу не разрешен.
InstantiationException              // Попытка создать объект абстрактного класса или интерфейса.
InterruptedException                // Один поток прерван другим потоком.
NoSuchFieldException                // Запрошенное поле не существует.
NoSuchMethodException               // Запрошенный метод не существует.

/* Классы и методы */

// java.lang.Throwable:
Throwable(); // Создает новый объект Throwable, не сопроваждая его подробным сообщением
Throwable(String message); // Создает новый объект класса Throwable, сопровождая его подробным сообщением.
Throwable(Throwable cause);
Throwable(String message, Throwable cause);
// Создает объект класса Throwable, соответствующий объекту cause, который описывает причины возникновения исключения.
Throwable initCause(Throwable cause); // Указывет причину создания объекта. Если причина уже задана, генерирует исключение.
Throwable getCause(); // Созвращает объект исключения, который был определен как причина создания данного объекта. Иначе возвращает null.
StackTraceElement[] getStackTrace(); // Возвращает трассировку стека в момент создания объекта.

//java.lang.Exception:
Exception(Throwable cause);
Exception(String message, Throwable cause);
// Создает объект класса Exception, соответствующий объекту cause.

//java.lang.RuntimeException:
RuntimeException(Throwable cause);
RuntimeException(String message, Throwable cause);
// Создает объект класса RuntimeException, соответствующий объекту cause.

//java.lang.StackTraceElement:
String getFileName(); // Возвращает имя исходного файла, содержащего точку, в которой выполняется элемент. Иначе возвращается null.
int getLineNumber(); // Возвращает номер строки, содержащей точку, в которой выполняется элемент. Если информация недоступна, возвращается -1.
String getClassName(); // Возвращает полное имя класса, содержащего точку, в которой выполняется элемент.
String getMethodName(); // Возвращает имя метода, содержащего точку, в которой выполняется элемент. Имя конструктора - <init>. Имя статического
// инициализатора - <clinit>. Перегруженные методы не различаются.
boolean isNativeMethod(); // Если точка выполнения находится внутри платформенно-зависимого метода, возвращает значение true.
String toString(); // Возвращает форматированную строку, содержащую имя класса и метода, а также имя файла и номер строки (если доступно).