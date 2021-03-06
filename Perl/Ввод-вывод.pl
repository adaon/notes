$name = <STDIN>; # Считывание строки с клавиатуры. При достижении конца файла оператор возвращает undef
# Считывание всех строк из потока (до конца файла). Данное сокращение работает ТОЛЬКО в такой записи
while(<STDIN>) {
    print $_;
}
# В списочном контексте оператор ввода возвращает все оставшиеся строки потока
foreach (<STDIN>) {
    print $_;
}
$name = <>; # Оператор <> поочередно обрабатывает файлы, указанные в аргуменах командной строки. При этом имя текущего файла хранится в $ARGV

### Аргументы вызова ###

@ARGV; # Данный массив содержит аргументы командной строки
$0; # В данной переменной хранится полное имя файла выполняемой программы

print arg; # Получает список значений и последовательно передает их в стандартный вывод
printf("Hello, %s, your password expires in %d days!", $user, $days_to_die); # Форматирование вывода. Автоматическое преобразование: %g (выбирает наиболее подходящую форму записи)

### Файловые дескрипторы ###

my.pl <input.txt >output.txt # Задание стандартных потоков ввода-вывода при запуске интерпретатора

STDIN # Стандартный дескриптор ввода
STDOUT # Стандартный дескриптор вывода
STDERR # Стандартный дескриптор ошибок

# Открывают поток и возвращают true или false в зависимости от успешности
open MYDESC, "myfile.txt"; # Открытие потока
open MYDESC, "<myfile.txt"; # Открытие потока для ввода
open MYDESC, ">myfile.txt"; # Открытие потока для вывода
open MYDESC, ">>myfile.txt"; # Открытие потока для вывода в режиме присоединения

close MYDESC; # Закрытие файлового дескриптора

print MYDESC "Hello"; # Вывод в файловый дескриптор
printf MYDESC "Hello"; # Форматированный вывод в файловый дескриптор

select MYDESC; # Установка файлового дескриптора как потока вывода по умолчанию

open STDERR, ">>logs.txt"; # Переопределение стандартного вывода ошибок и предупреждений (можно также переопределять STDIN и STDOUT)

# Выводит строку и добавляет символ новой строки
use 5.010;
say("Hello, world!");