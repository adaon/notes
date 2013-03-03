/////// Исключения




/////// Логи

Logger logger = Logger.getLogger("ru.wesf.newtech"); // Получить или создать логгер
logger.setLevel(Level.SEVERE|WARNING|INFO|CONFIG|FINE|FINER|FINEST|ALL|OFF); // Установить уровень выводимых сообщений
logger.severe|warning|info|config|fine|finer|finest("Program started!");
logger.log(Level.LEVEL, message);
logger.log(Level.LEVEL, message, exception);
logger.entering(String className, String methodName); // Трассировка вхождения
logger.exiting(String className, String methodName); // Трассировка выхода
logger.throwing(String className, String methodName, Throwable t); // регистрирует запись, имеющую уровень FINEST
logger.setUseParentHandlers(false); // Отключение автоматического использования обработчиков
logger.addHandler(handler); // Добавление к логгеру обработчика событий
logger.setFilter(Filter filter);

Handler handler = new ConsoleHandler();
handler.setLevel(Level.FINE);

FileHandler handler = new FileHandler([filename]); // Без имени файла логи записываются в файл ~/java<n>.log
// Имя файла может включать шаблоны:
// %h - user.home
// %t - временный системный каталог
// %u - уникальный номер
// %g - генерация номера для ротации
// %% - символ %

// Создание своего фильтра
class MyFilter implements Filter {
    public boolean isLoggable(LogRecord rec) {
        return true|false;
    }
}

////// Утверждения

assert x > 0;
java -ea Cur; // Запуск программы с включенными утверждениями
java -da Cur; // Запуск программы с отключенными утверждениями