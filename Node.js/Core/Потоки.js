/* Потоки чтения данных */

read.on('data', function(data) {
	console.log(data.toString()); // Полученные данные представлены буфером
});

read.setEncoding('utf8'); // Указание кодировки получаемых данных
read.on('data', function(data) {
	console.log(data); // Полученные данные представлены строкой в указанной кодировке.
});

// Приостановка и возобновление потока
stream.pause(); // Приостановка потока. Прекращает эмитирование событий 'data'.
stream.resume(); // Возобновляет поток.

// Получение информации о закрытии потока
read.on('end', function() {
	// Поток закрыт.
});

/* Потоки ввода данных */

// Запись строки в поток
stream.write('This is a string...'[, 'base64']);

// Запись буфера в поток
var buffer = new Buffer('This is a string...');
stream.write(buffer);
// Когда поток опустошен.
stream.on('drain', function() {

});


/* Файловые потоки */

// Создание файлового потока ввода
var options = {
	encoding: null|'encoding',
	fd: myFd, // Можно указать уже сушествующий файловый дескриптор. В таком случае в качестве имени файла нужно указать null.
	bufferSize: 1024, // Размер буфера блока в байтах. По умолчанию - 64KB.
	start: 0, // Позиция начала считывания.
	end: 0 // Позиция конца считывания.
};
var read = createReadStream('/path/to/file', [options]);

// Создание файлового потока вывода
var options = {
	flags: 'w', // Флаги, используемые при открытии файла.
	encoding: null,
	mode: 0666 // Используемые разрешения.
};
var stream = fs.createWriteStream('path/to/file'[, options]);


read.pipe(write); // Связывание потока чтения с потоком записи (данные передаются напрямую от одного к другому).