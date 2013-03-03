# HTTP запросы

	var http = require('http');

## Создание запросов GET

	var options = {
		host: 'www.google.ru',
		post: 80,
		path: '/index.html'
	};

	http.get(options, function(res) {
		console.log('Got response: ' + res.statusCode);
	});

## Использование других методов

http.get - это сокращение от http.request

	var options = {
		host: 'www.google.ru',
		port: 80,
		method: 'POST',
		path: '/index.html',
		headers: {
			'Accept': 'text/json',
			'If-Modified-Since': 'Sat, 28 Jan 2012 00:00:52 GMT'
		}
	};

Возвращает объект http.ClientRequest, который является потоком записи.

	var request = http.request(options, function(response) {
		response.statusCode; // Целое число - статус ответа
		response.httpVersion; // Версия HTTP, реализованная сервером.
		response.headers; // Объект, содержащий заголовки ответа.

		// Получение тела ответа.
		response.setEncoding('utf8');
		response.on('data', function(data) {
			
		});

		// Связывание потока ответа
		response.pipe(fs.createWriteStream('myfile.html'));
	});

	request.on('response', function(response) {});

## Использование стороннего модуля request для упрощения http-запросов

	npm install request

	var request = require('request');

Выполнение GET-запроса

	request('http://www.it-comps.ru/about/', function(error, response, body) {

	});

	request.put();
	request.post();
	request.head();
	request.del();
	request.get();

Вместо url можно также использовать объект options:

	{
		uri/url: '', // Полный URI или URL.
		method: 'GET', // Метод запроса.
		headers: {}, // Заголовки.
		qs: {}, // Набор пар имя-значение, который будет добавлен в URL.
		body: '', // Тело POST или PUT запроса. Строка или буфер.
		form: '', // Устанавливает body в строковое представление значения и добавляет тип содержимого application/x-www/form/urlencoded; charset=utf-8 в заголовки.
		json: '', // Устанавливает body в JSON-значение и добавляет тип содержимого application/json в заголовки.
		followRedirects: true, // Переходит по перенаправлениям.
		maxRedirects: 10, // Маскимальное количество перенаправлений.
		onResponse: false, // Если true, ответ будет запущен при возникновении события response вместо end. Если это функция, она будет вызвана при событии response.
		encoding: '', // Кодировка ответных данных. Если null, данные будут в виде буфера.
		pool: {}, // Объект, содержащий агенты для этих запросов. Если опущено, будет использоваться глобальный пул.
		pool.maxSockets: 5, // Максимальное число сокетов в пуле.
		timeout: 1000 // Число миллисекунд для ожидания  запроса.
	}

Данные методы возвращают объект request, который можно перенаправить в поток записи.

request.get('http://wit-comps.ur').pipe(fs.createWriteStream('itcomps.html'));
