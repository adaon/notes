Стандартные файловые дескрипторы:
1 - Стандартный ввод
2 - Стандартный вывод
3 - Стандартная ошибка


/* Работа с путями */

var path = require('path')

path.normalize('C:/work/'); // => C:\\work Нормализует путь.
path.join('/foo', 'bar', 'baz/asdf'); // Конкатенация частей пути (нормализует путь).
path.resolve('server.js'); // Разрешает путь (возвращает абсолютный путь).
path.relative('/data/orandea/test/aaa', '/data/orandea/impl/bbb');
path.relative('./', 'C:/work'); // Находит относительный путь от первого до второго
path.dirname('/foo/bar/baz/asdf/quuf.txt'); // Возвращает путь к директории, в которой находится файл.
path.basename('C:/Users/L/Desktop/server.js'); // Возвращает имя файла.
path.basename('C:/Users/L/Desktop/server.js', '.js'); // Возвращает имя файла без расщирения.
path.extname('server.js'); // Возвращает расширение файла (.ext)

// Проверка существования файла или директории
path.exists('/etc/passwd', function(exists) {
	// exists - true/false
});
path.existsSync('/etc/passwd'); // Синхронная проверка существования файла или директории


/* Модуль fs */

var fs = require('fs');

// Получение информации о файле
fs.stat('./server.js', function(err, stats) {
	stats.isFile(); // Является ли путь файлом.
	stats.isDirectory(); // Является ли путь директорией.
	stats.isBlockDevice(); // Является ли путь блоковым устройством.
	stats.isCharacterDevice(); // Является ли путь символьным устройством
	stats.isSymbolicLink(); // Является ли путь символьной ссылкой.
	stats.isFifo(); // Является ли путь FIFO.
	stats.isSocket(); // Является ли путь сокетом.
});

// Открытие файла
fs.open('/path/to/file', 'r', function(err, fd) {
});

r   Открывает текстовый файл для чтения. Поток расположен в начале файла.
r+  Открывает файл для чтения и записи. Поток расположен в начале файла.
w   Усекает файл до нуля или создает текстовый файл для чтения. Поток расположен в начале файла.
w+  Открывает файл для чтения и записи. Файл создается, если не существует. В противном случае он усекается до нуля. Поток расположен в начале файла.
a   Открывает файл для чтения. Файл создается, если не сушествует. Поток расположен в конце файла. Данные, записываемые в файл, всегда будут дополняться в текущий конец файла.
a+  Открывает файл для чтения и записи. Файл создается, если не существует. Поток расположен в конце файла. Данные, записываемые в файл, всегда будут дополняться в текущий конец файла.

//Чтение из файла
var readBuffer = new Buffer(1024),
	bufferOffset = 0,
	bufferLength = readBuffer.length,
	filePosition = 0;
fs.read(fd,
		readBuffer,
		bufferOffset,
		bufferLength,
		filePosition,
		function read(err, readBytes) {
			if(err) { throw err; }
			console.log('Readed ' + readBytes + ' bytes.');
			console.log(readBuffer.slice(0, readBytes).toString());
		});

// Запись в файл
var writeBuffer = new Buffer('writing this string'),
	bufferPosition = 0,
	bufferLength = writeBuffer.length,
	filePosition = null; // Записывать в текущую позицию
fs.write(fd
		 writeBuffer,
		 bufferPosition,
		 bufferLength,
		 filePosition,
		 function wrote(err, written) {
		 	if(err) { throw err; }
		 	console.log('wrote ' + written ' bytes')
		 });

// Закрытие файла
fs.close(fd, [function() {}]);