// Добавление новых глобальных функций ========================================

jQuery.myFunction = function() {
    
}

jQuery.extend({
    func1 = function() {},
    fucn2 = function() {}
});

jQuery.myPlugin = function() {
    func1 = function() {},
    fucn2 = function() {}
}

// Добавление методов объекта jQuery ==========================================

// Дополнение объекта jQuery
jQuery.fn.myMethod = function() {
    this // Ссылка на текущий объект jQuery
    return this; // Все методы расширения должны возвращать объект jQuery
}

element.setArray(elems); // Заменяет набор элементов