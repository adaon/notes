// Введение в браузерные события ==============================================

// Назначени обработчиков событий
<a href="/shop/" onclick="alert('Hello!');"></a> // Использование аттрибута
elem.onclick = function() { alert('Hello!'); }; // Использование свойства элемента

// Методы для старых IE<9
// У данных обработчиков нет свойства this, которое указывает на текущий элемент
element.attachEvent('on' + event, handler);
element.detachEvent('on' + event, handler);

// Назначение по стандарту (работает во всех современных браузерах, включая IE9+)
// Если phase = true, обработчик ставится на стадию перехвата (сверху вниз), иначе - на стадию всплытия (снизу вверх)
element.addEventListener(event, handler, phase);
element.removeEventListener(event. handler, phase);

// Собственные функции для кроссбраузерного назначения событий
var addEvent, removeEvent;

if (document.addEventListener) { // проверка существования метода
    addEvent = function(elem, type, handler) {
        elem.addEventListener(type, handler, false)
    }
    removeEvent = function(elem, type, handler) {
        elem.removeEventListener(type, handler, false)
    }
} else {
    addEvent = function(elem, type, handler) {
        elem.attachEvent("on" + type, handler)
    }
    removeEvent = function(elem, type, handler) {
        elem.detachEvent("on" + type, handler)
    }
}

...
// использование:
addEvent(elem, "click", function() { alert('hi') })

// Получение объекта события ==================================================

// WC3 (объект события передается первым аргументом в функцию-обработчик)
element.onclick = function(event) {};
// IE<9 (при возникновении события создается глобальный объект window.event)
element.onclick = function() {
    window.event;
};
// Кросс-браузерное решение
element.onclick = function() {
    var event = event || window.event;
};

// Всплытие и перехват ========================================================

// При возникновении события элемента-потомка событие возникает вверх по иерархии, ко всем элементам-предкам

// Самый глубокий элемент, который вызвал событие, называется целевым
// По мере всплытия он не изменяется, в отличие от this
event.srcElement // IE<9
event.target // Остальные браузеры

// Прекращение всплытия
event.cancelBubble = true; // IE<9
event.stopPropagation(); // Остальные браузеры

// Действия браузера по умолчанию =============================================

// Отмена действия браузера
event.preventDefault(); // Стандартный метод
event.returnValue = false; // IE<9

// Если обработчик, назначенный через on... вернет false, действия браузера по умолчанию отменятся
element.onclick = function(event) {
    return false;
};

// Отмена выделения, невыделяемые элементы ====================================

// Чтобы избежать выделения, нужно предотвратить действие браузера по умолчанию для события selectstart в IE и mousedown в других браузерах
// При установке на родителя все его потомки становятся невыделяемыми
<div ondblclick="alert('Тест')" onselectstart="return false" onmousedown="return false">

// Можно просто тут же снимать выделение
element.dblclick = function(event) {
    try {
        window.getSelection().removeAllRanges(); 
      } catch(e) {
        document.selection.empty(); // IE<9
      }
};

//Кроме того, можно использовать нестандартное свойство CSS user-select (кроме IE)
-webkit-user-select: none;
-moz-user-select: none;

// Делегирование событий ======================================================

// Чтобы делегировать событие, необходимо привязать обработчик к одному общему родителю, а при возникновении выяснить, на каком именно дочернем элементе оно вызвано и обработать его

// Шаблон проектирования "поведение" ==========================================

// Например, в data-toggle-id можно записать ID элемента, который будет скрываться-показываться:
<button data-toggle-id="subscribe-mail">
    Кликните для подписки
</button>
<div id="subscribe-mail" style="display:none">
  Ваша почта: <input type="email">
</div>
// Код для обработки события будет проверять наличие этого атрибута и действовать, если он есть:
document.onclick = function(e) {
  var target = e && e.target || window.event.srcElement;

  var dataToggleId = target.getAttribute('data-toggle-id');
  if (!dataToggleId) return;

  var elem = document.getElementById(dataToggleId);
  elem.style.display = elem.offsetHeight ? 'none' : 'block';
}


// Можно показывать подсказку при наведении, если есть атрибут:
<div data-tooltip="Подсказка при наведении">
  Текст
</div>

// Можно проверять значение поля формы при отправке, руководствуясь type и data-validator. 
// Можно даже сделать так, что отправка формы, при наличии атрибута, будет работать через AJAX.
<form data-ajax="1">  
  <input type="email">
  <input data-validator="integer positive">
</form>
