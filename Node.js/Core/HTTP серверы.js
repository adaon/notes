// Создание простого HTTP-сервера
var http = require('http');

var server = http.createServer();

server.on('request', function(req, res) {
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.write('Hello, world!');
	res.end();
});

server.listen(7777);

/* Объект http.ServerRequest */

// req - объект ReadStream.

req.url; // Содержит запрошенный url в виде строки. Содержит путь (например, /about/).
req.method; // Метод запроса. Может ьыть GET, POST, DELETE, HEAD.
req.headers; // Содержит объект со свойствами для каждого HTTP-заголовка.

/* Объект http.ServerResponse */

// Запись заголовков
res.writeHead(200, {
	'Content-Type': 'text/plain',
	'Cache-Control': 'max-age=3600'
});

// Изменение или добавление заголовка. Данный метод работает только если тело еще не было записано. Также не сработает после использования метода res.writeHead()
res.setHeader(name, value);

// Удаление заголовка. Работает также только до отправки данных заголовка или тела.
res.removeHeader('Cache-Control');

// Запись части тела.
res.write('Hello'); // Запись тела как строки.
res.write(buffer); // Запись тела как буфера.

/* Потоковая передача блоковых HTTP ответов */

// Передача файла
var rs = fs.createReadStream('myfile.mpg');
rs.pipe(res);

/* Остановка сервера */

server.close(); // Закрытие сервера.
server.listen(port[, host]); // Возобновление сервера