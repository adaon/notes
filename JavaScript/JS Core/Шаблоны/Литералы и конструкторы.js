// Недостатки конктруктора Object
new Object() // Object
new Object(1) // Number
new Object('str') // String

// Шаблоны принудительного использования new ==================================

// Еслив вызвать конструктор без оператора new, ссылка this внутри него будет указывать на глобальный объект (window)

// Такую проверку необходимо использовать
if(this instanceof Person !== true) {
    throw new Error('You need to call constructor with "new" operator!');
}

// Литералы массивов ==========================================================

typeof [1, 2, 3]; // object

Array.isArray(arr); // ECMAScript 5 Проверяет, является ли агрумент массивом
// Можно также самому определить данную функцию:
Array.isArray = function(arg) {
    return Object.prototype.toString.call(arg) === "[object Array]";
}

// JSON =======================================================================

var data = JSON.parse(json); // Предпочтительный способ преобразования строки в JSON
var json = JSON.stringify(json) // Преобразование объекта в строку

// Объекты Error ==============================================================

Error();
SyntaxError();
TypeError();

error.name // Значение свойства name функции-конструктора
error.message // Строка, передаваемая конструктору при создании объекта