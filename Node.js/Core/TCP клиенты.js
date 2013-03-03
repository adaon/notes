var net = require('net');

/* Соединение с сервером */

// Второй аргумент можно опустить, в таком случае он устанавливается в localhost.
// Возвращает объект net.Socket.
var connection = net.createConnection(7777[, '127.0.0.1'][, function(connection) {

}]);

// Альтернативный способ назначения обработчика
connection.once('connect', function() {

});

/* Отправка и получение данных */

// Запись строки
connection.write('The string'[, callback]);
// Запись строки в указанной кодировке
connection.write('sdgsdg56sd4g6sd5', 'base64'[, callback]);
// Запись буфера
connection.write(buffer[, callback]);

// Получение данных с сервера
connection.on('data', function(data) {
	console.log('Some data is arrived: ' + data);
});

/* Завершение соединения */

// Закрытие соединения. Закрывает соединение после того как все данные будут отправлены. Можно передавать завершающие данные.
connection.end(['Bye bye!', 'utf8']);


/* Обработка ошибок */

connection.on('error', function(error) {
	console.error('this error happened: ' + error.message + ', code: ' + err.code);
});

/* Восстановление потерянного соединения */

(function connect() {
	var socket = net.createConnection(7777);
	// ...
	socket.on('close', function() {
		connect();
	});
})()