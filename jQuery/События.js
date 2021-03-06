// Выполнение операций после загрузки страницы ================================

$(document).ready(function(event) {
    // Действия по окончании загрузки DOM
});

// Освобождает идентификатор $ (для работы с другими библиотеками)
jQuery.noConflict();

// Простые события ============================================================

// Простая привязка события
element.bind('click', function(event) {
    $(this); // Текущий элемент
});

element.click(function(event) {
    // Обработчик клика
});

// Краткие методы подключения обработчиков

blur
change
click
dblclick
error
focus
keydown
keypress
keyup
load
mousedown
mousemove
mouseout
mouseover
mouseup
resize
scroll
select
submit
unload

// Комбинированные события ====================================================

// При первом клике вызывает 1 функцию, при 2  - вторую и т.д.
element.toggle(function() {/*action1*/}, function() {/*action2*/}/*, function() {action3}, ...*/);

// Изменение движения события: объект события =================================

event.target // Фактический элемент генерации события

// Удаление обработчика события ===============================================

element.unbind('click'); // Отвязка события

// Пространство имен события
// После точкив имени события можно указать идентификатор, который можно будет использовать при одключении события
element.bind('click.mytype', function(event) {});
element.unbind('click.mytype');

element.unbind('click', func); // Можно удалить определенный обработчик

// Имитация действий пользователя =============================================

// Имитация клика на элементе
element.trigger('click');
element.click();

// События клавиатуры =========================================================

