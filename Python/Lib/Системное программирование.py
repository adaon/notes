import glob
glob.glob('*') # Возвращает список имен файлов, соответствующих заданному шаблону

# sys ======================================================================================
sys.platform # Название операционной системы
sys.maxsize # Наибольшее целое число
sys.version # Номер версии интерпретатора

sys.path # Список строк путей поиска модулей
sys.modules # Словарь, содержащий записи name:module всех загруженных модулей
sys.argv # Список аргументов командной строки

sys.exit(code) # Завершение программы с кодом. В действительности возбуждает исключение SystemExit

# os =======================================================================================
os._exit(code) # Мгновенный выход из программы, без возбуждения исключения

os.getpid() # Возвращает числовой идентификатор процесса
os.getcwd() # Возвращает текущий рабочий каталог (Current Working Directory)
os.chdir('new_dir') # Изменяет текущий рабочий каталог

os.pathsep # Разделитель путей в переменной окружения
os.sep # Разделитель пути
os.pardir # Идентификатор родительской директории
os.curdir # Идентификатор текущей директории
os.linesep # Символ разделителя строк

os.path.isdir('filename') # Проверяет директория ли это
os.path.isfile('filename') # Проверяет файл ли это
os.path.exists('filename') # Существует ли файл
os.path.getsize('filename') # Размер файла

os.path.split('filename') # Возвращает кортеж, содержащий разделенные путь и имя файла
os.path.join('dir', 'file') # Возвращает путь, объединяя директорию и файл
os.path.dirname('filename') # Возвращает директорию
os.path.basename('filename') # Возвращает имя файла по пути
os.path.splitext('filename') # Возвращает кортеж с именем файла (без рас.) и расширением

os.path.normpath('path') # Возвращает путь в корректном виде
os.path.abspath('filename') # Возвращает полное имя к файлу

os.system('command') # Запускает команду оболочки из сценария Python
os.popen('command') # Выполняет команду и возвращает файлоподобный объект для считывания вывода объект
os.startfile('filename') # Открывает файл программой по умолчанию

os.environ # Словарь переменных окружения

os.open(path, flags, mode) # Открывает файл и возвращает его дескриптор flags (os.O_RWD | os.O_BINARY)
os.read(descriptor, N) # Читает не более N байтов и возвращает строку байтов
os.write(descriptor, string) # Записывает в файл байты из строки байтов string
os.lseek(descriptor, position, how) # Перемещается в позицию position в файле

os.fdopen(descriptor, 'mode') # Обертывает файловый дескриптор объектом файла

os.chmod('span.txt', 0o777) # Изменение прав доступа к файлу
os.rename('from.txt', 'to.txt') # Переименование файла
os.remove('filename') # Удалить файл
os.stat('filename') # Возвращает кортеж низкоуровневой информации о файле

os.listdir('dirname') # Возвращает список имен файлов и каталогов в выбранной директории
os.walk('dirname') # Выполняет итеративный обход всех каталогов в дереве (и вложенных) и возвращает на каждой итерации кортеж вида
# (имя, список_папок, список_файлов)