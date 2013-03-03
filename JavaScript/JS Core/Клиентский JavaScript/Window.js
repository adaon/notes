// Таймеры ====================================================================

var id = setTimeout(func, millis); // Планирует запуск функции. В качестве первого аргумента допускается передавать строку JS-кода. Возвращает идентификатор таймера
clearTimeout(id); // Отменяет таймер
var id = setInterval(func, millis); // Планирует переодический запуск функции. В качестве первого аргумента допускается передавать строку JS-кода. Возвращает идентификатор интервала
clearInterval(id); // Отменяет интервал

// Объекты Location и History =================================================

// Location

window.location // Свойство адреса окна
location.toString() // Возвращает текущий адрес (href), поэтому в выражениях можно использовать просто location вместо location.href

location.hash // Часть URL после и включая #
location.href // Текущий адрес окна
location.protocol // Протокол адреса
location.host // Хост и порт
location.hostname // Хост без порта
location.pathname // Путь относительно хоста
location.search // Параметры поиска (после вопросительного знака)

window.location = 'http://google'; // При присваивании строкового значения переменной location браузер пытается перейти по данному адресу
window.location.hash = '#top'; // Прокручивает страницу к элементу <a name="top">

location.reload(); // Перезагружает страницу
location.replace('http://google.ru/'); // Заменяет страницу в окне И ИСТОРИИ ПРОСМОТРА

// History

window.history // Объект истории окна
history.back(); // Переместиться назад
history.forward(); // Переместиться вперед
history.go(-1); // Перемещает на 1 страницу назад в истории

// Объекты Window, Screen и Navigator =========================================

// Положение окна на экране

// IE и подобные
window.screenLeft
window.screenTop
// Firefox и подобные
window.screenX
window.screenY

// Клиентская область и смещение прокрутки

// Все кроме IE
window.innerWidth // Ширина клиентской области
window.innerHeight // Высота клиентской области
window.pageXOffset // Смещение по горизонтали
window.pageYOffset // Смещение по вертикали
// IE 6 и документы с объявлением DOCTYPE
document.documentElement.clientWidth // Ширина клиентской области
document.documentElement.clientHeight // Высота клиентской области
document.documentElement.scrollLeft // Смещение по горизонтали
document.documentElement.scrollTop // Смещение по вертикали
// IE4, IE5 и IE6 без объявления DOCTYPE
document.body.clientWidth // Ширина клиентской области
document.body.clientHeight // Высота клиентской области
document.body.scrollLeft // Смещение по горизонтали
document.body.scrollTop// Смещение по вертикали

// Объект Screen

window.screen // Информация о размере экрана

screen.width // Ширина экрана
screen.height // Высота экрана
screen.availWidth // Доступная ширина экрана
screen.availHeight // Доступная высота экрана
// В браузере Firefox и подобных
screen.availLeft // Первая доступная позиция на экране
screen.availTop // Первая доступная позиция на экране

// Объект Navigator

window.navigator // Объект, содержащий общую информацию о браузере

navigator.appName // Название браузера (Netscape или Microsoft Internet Explorer)
navigator.appVersion // Номер версии и другая информация о версии браузера
navigator.userAgent // Строка USER-AGENT
navigator.appCodeName // Кодовое имя браузера
navigator.platform // Аппаратная платформа

// Методы управления окнами ===================================================

// Открытие и закрытие окон

// Открывает новое окно и возвращает объект открытого окна
window.open(
    'http://google.ru', // Адрес
    '_blank', // Имя окна (если указано имя существующего окна, оно возвращается не создавая нового)
    'width=400,height=350,status=yes,resizable=yes', // Параметры нового окна
    true // Должно ли существующее окно сделать новую запись с адресом в истории
);

window.close(); // Закрыть окно

window.opener // В данном свойстве содержится объект родительского окна или null
window.closed // Логическое значение, показывающее, было ли окно закрыто

// Геометрия окна

window.moveTo(x, y); // Перемещает окно в указанную точку
window.moveBy(dx, dy); // Перемещает окно на указанное кол-во пикселей
window.resizeTo(width, height); // Изменяет размеры окна
window.resizeBy(dwidth, dheight); // Изменяет размеры окна на указанное кол-во пикселей

// Фокус ввода и видимость

window.focus(); // Запрашивает фокус ввода
window.blur(); // Освобождает фокус ввода

// Прокрутка

window.scrollBy(x, y); // Прокручивает документ на указанное количество пикселей влево или вправо, вверх или вниз
window.scrollTo(x, y); // Прокручивает документ на абсолютную позицию

element.scrollIntoView(); // Перемещает полосу прокрутки, делая элемент видимым (пытается расположить элемент как можно ближе к верхнему краю окна)

// Простые диалоговые окна ====================================================

alert();
confirm();
prompt();

// Обработка ошибок ===========================================================

// Если присвоить свойству onerror функцию, она станет обработчиком ошибок
// Если данная функция возвращает true, это говорит браузеру о том, что ошибка обработана и не нужно выполнять никаких дополнительных действий
window.onerror = function(message, url_doc, str_number) {
    alert(error);
    return true;
}