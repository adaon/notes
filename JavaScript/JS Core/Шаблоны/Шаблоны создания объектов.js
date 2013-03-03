// Объявление зависимостей ====================================================

function func() {
    // Объявление зависимостей
    var event = YAHOO.util.Event,
        dom = YAHOO.util.Dom;
}

// Частные члены литералов ====================================================

// С помощью замыканий
var obj = (function() {
    // Частные члены
    var name = 'Denis Ivanov';
    var age = 21;
    return {
        getName: function() {
            return name;
        }
    };
})()

// Шаблон Модуль ==============================================================

var module = (function () {
    
    // Зависимости
    var util = MYAPP.utilities,
        ladf = MYAPP.lang;
        
    // Частные свойства
    var name = 'Denis Ivanov';
    var age = 21;
    
    // Частные методы
    // ...
    
    return {
        // Общедоступные члены
    };
})();

// Шаблон открытия модуля

var module = (function() {
    // Приватные методы и свойства
    return {
        // Открытие некоторых свойств и методов
        isArray: isArray,
        name: name
    };
})();