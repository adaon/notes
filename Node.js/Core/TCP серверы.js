var net = require('net');

/* Создание TCP-сервера */

// Создает сервер и подключает обработчик события connection
net.createServer(function(socket) {
	// new connection
	socket.on('data', function(data) {
		// got data
	});
	socket.on('end', function(data) {
		// connection closed
	});
	socket.write('Some string');
}).listen(4001);

// Создает сервер
var server = net.createServer();

// Событие прослушивания
server.on('listening', function() {
	console.lo('Server is listening on port');
});

// Событие соединения
server.on('connection', function(socket) {
	console.log('Server has a new connection');
	socket.end();
	socket.close();
});

// Событие закрытия
server.close('close', function() {
	console.log('Server is now closed');
});

// Событие ошибки
server.on('error', function(err) {
	console.log('Error occured: ' + err.message);
});

// Прослушивает сервер
server.listen(port[, host]);

server.close();


/* Использование объекта сокета */

socket.setEncoding('utf8'); // Установка кодировки сокета

// Запись в сокет
socket.write('Hello, world!');

// Событие получения данных
socket.on('data', function(data) {
});

// Событие закрытия сокета
socket.on('end', function() {
});

// Установка значения таймера (в миллисекундах)
socket.setTimeout(60000);
socket.on('timeout', function() {
});
// То же самое
socket.setTimeout(10000, function() {
});

// Продолжительные сессии (периодически посылает пустые пакеты)
socket.setKeepAlive(true[, period]);

socket.setNoDelay(true); // Посылать данные незамедлительно.

// Обработка ошибок
socket.on('error', function(error) {

});

// Обработка необработанных исключений
socket.on('uncaughtException', function(err) {

});

// Приостановка и возобновление сокета
socket.pause();
socket.resume();