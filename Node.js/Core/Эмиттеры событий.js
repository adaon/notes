emitter.once('event', eventListener); // Добавлет слушатель события и удаляет его после первого возникновения события.

emitter.removeAllListeners('event'); // Удаляет все обработчики данного события.


/* Создание эмиттера событий */

// Наследование EventEmitter

util = require('util');
var EventEmitter = require('events').EventEmitter;
var MyClass = function() {
	// ...
}
util.inherits(MyClass, EventEmitter);


// Эмитирование событий

MyClass.prototype.someMethod = function() {
	this.emit('custom_event', 'argument 1', 'argument 2');
};

var myInstance = new MyClass();
myInstance.on('custom_event', function(str1, str2) {
	console.log(str1, str2);
});
