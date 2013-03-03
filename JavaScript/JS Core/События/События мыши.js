// Введение: клики, кнопка, координаты ========================================

// Простые события
mousedown // Кнопка мыши нажата над элементом
mouseup // Кнопка мыши отпущена над элементом
mouseover // Мышь появилась над элементом
mouseout // Мышь ушла с элемента
mousemove // Каждое движение мыши над элементом
mousewheel // Прокрутка колесика мыши (в Firefox - DOMMouseScroll)
// Комплексные события
click
contextmenu // Клик правой кнопкой мыши (контекстное меню - действие браузера по умолчанию)
dblclick // Двойной щелчок

// Получение информации о кнопке
// Не работают в IE<9
event.which == 1 // Левая кнопка
event.which == 2 // Средняя кнопка
event.which == 3 // Правая кнопка
// Работает в IE<9
event.button & 1 == 1 // Левая кнопка
event.button & 2 == 1 // Средняя кнопка
event.button & 3 == 1 // Правая кнопка

// Модификаторы
event.shiftKey // Нажата ли shift
event.altKey // Нажата ли alt
event.ctrlKey // Нажата ли ctrl
event.metaKey // для Mac

// Координаты мыши
// Относительно окна
event.clientX
event.clientY
// Относительно документа
event.pageX
event.pageY

// События mouseover/mouseout, свойство relatedTarget =========================

// mouseover
event.target // Элемент под курсором
event.relatedTarget // Элемент, с которого курсор пришел

// mouseout
event.target // Элемент, с которого курсор пришел
event.relatedTarget // Элемент под курсором

// События mouseenter и mouseleave ============================================

// Поддерживаются IE6+ Opera11.10+ Firefox 10+
// Отличие от mouseover и mouseout в том, что при переходе на потомка курсор не уходит с родителя
// Другое отличие в том, что данные события не всплывают