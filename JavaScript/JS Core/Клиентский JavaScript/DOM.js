document.write('String'); // Добавляет содержимое в текущее место анализа
document.write('1f', 'sttfgsd'); // Данный метод объединяет аргументы
document.writeln('sgdgd'); // Данный метод аналогичен write, за исключением того, что он выводит символ новой строки после вывода содержимого

// Запись в созданное окно
var win = window.open();
win.document.write('text');
win.document.close(); // Если не вызвать данный метод, браузер будет отображать процесс загрузки

// Типы узлов =================================================================

ELEMENT_NODE                = 1;
ATTRIBUTE_NODE              = 2;
TEXT_NODE                   = 3;
CDATA_SECTION_NODE          = 4;
ENTITY_REFERENCE_NODE       = 5;
ENTITY_NODE                 = 6;
PROCESSING_INSTRUCTION_NODE = 7;
COMMENT_NODE                = 8;
DOCUMENT_NODE               = 9;
DOCUMENT_TYPE_NODE          = 10;
DOCUMENT_FRAGMENT_NODE      = 11;
NOTATION_NODE               = 12;   

// Свойства Document ==========================================================

document.bgColor // Цвет фона документа
document.cookie // Позволяет читать и писать cookies
document.domain // Средство связи между скриптами на одном домене
document.lastModified // Дата последнего изменения документа
document.location // Устаревший синоним свойства url
document.referrer // Адрес документа, содержащего ссылку, которая привела к текущему документу
document.title // Содержимое тега title
document.URL // Адрес, с которого был загружен документ

// Коллекции объектов

document.anchors // Массив объектов Anchor, представляющих якорные элементы документа (<a name="...">).
document.applets // Массив объектов апплетов
document.forms // Массив объектов форм
document.images // Массив объектов изображений
document.links // Массив объектов ссылок

// Узлы DOM ===================================================================

// Могут быть
<div></div> // Узел-элемент
Hello, world! // Текстовый узел
<!-- Узел-комментарий --> // Узел-комментарий
// Пробелы и переносы строки между тегами становятся пробельными узлами

// Навигация DOM ==============================================================

document.documentElement // Ссылается на DOM-объект для тега HTML
document.body // Соответствует тегу BODY

element.childNodes // Хранит все дочерние элементы, включая текстовые
element.children // Хранит все дочерние узлы-элементы

element.firstChild // Первый дочерний узел
element.lastChild // Последний дочерний узел

element.parentNode // Ссылается на родительский элемент

element.previousSubling // Левый сосед
element.previousSubling // Правый сосед

// Дополнительные ссылки для элементов (кроме IE<9)

element.childElementCount // Число дочерних элементов
element.firstElementChild // Первый потомок-элемент
element.lastElementChild // Последний потомок-элемент
element.nextElementSubling // Правый брат-элемент
element.previousElementSubling // Левый брат-элемент

// Таблицы ====================================================================

table.rows // Список строк tr таблицы
table.caption/tHead/tFoot // Ссылки на элементы таблицы caption, thead, tfoot
table.tBodies // Список элементов таблицы tBody

tbody.rows // Список строк tr секции

tr.cells // Список ячеек th/td
tr.sectionRowIndex // Номер строки в текущей секции thead/tbody
tr.rowIndex // Номер строки в таблице

td.cellIndex // Номер ячейки в строке

// Основные свойства узла =====================================================

node.nodeType // Содержит числовой тип узла
node.nodeName // Содержит имя узла (название тега или #text)
node.tagName // Содержит название тега для элементов или undefined

node.innerHTML // Содержимое узла в виде строки
node.innerHTML = 'Hello, world!'; // Изменение содержимого узла
// В IE для табличных элементов (кроме td/th) свойство innerHTML - только для чтения

//     Содержимое текстового узла или комментария. Свойство nodeValue также определено и для других типов узлов. Можно изменять.
node.nodeValue
node.data

// Атрибуты ===================================================================

// Имена атрибутов нечуствительны к регистру
elem.hasAttribute('attr'); // Имеет ли элемент атрибут
elem.getAttribute('attr'); // Получает значение атрибута
elem.setAttribute('attr', 'value'); // Устанавливает значение атрибута
elem.removeAttribute('attr'); // Удаляет атрибут

// Стандартные DOM свойства синхронизируются с аттрибутами:
elem.id = id;
elem.href = href;
elem.value = value; // Синхронизируется только ИЗ АТТРИБУТА В СВОЙСТВО
elem.className // Соответствует аттрибуту class

// Добавление и удаление узлов ================================================

// Создание узлов
var elem = document.createElement('tag'); // Создание узла с указанным тегом
var text = document.createTextNode('text'); // Создает текстовый узел с указанным текстом. Любые специальные символы при этом экранируются

// Добавление узлов (возвращают добавленный узел)
elem.appendChild(node); // Добавляет node  в список дочерних элементов
elem.insertBefore(node, nextSubling); // Вставляет node в список дочерних элементов elem перед nextSubling

// Удаление узлов (возвращают удаленный узел)
elem.removeChild(node); // Удаляет node из списка детей
elem.replaceChild(node, currentElem); // Заменяет узел currentElem на node

// Поиск элементов ============================================================

// Возвращают "живые" списки, т.е. при изменении структуры документа изменяется и список
var elem = document.getElementById('id'); // Получить элемент по id
var elements = document.getElementsByTagName('tagname'); // Возвращает массив элементов с указанным тегом
var elements = document.getElementsByName('name'); // Возвращает массив элементов по аттрибуту name
var elements = document.getElementsByClassName('class'); // Возвращает массив элементов по имени класса

var elements = document.querySelectorAll('css'); // Массив элементов по CSS3-селекторам
var elem = document.querySelector('css'); // Возвращает первый элемент по CSS-селектору

// Мультивставка ==============================================================

 // Вставляет произвольный html (НЕ РАБОТАЮТ В Firefox до 8)
elem.insertAdjacentHTML('beforeBegin', html); // Перед elem
elem.insertAdjacentHTML('afterBegin', html); // Внутрь elem, в самое начало
elem.insertAdjacentHTML('beforeEnd', html); // Внутрь elem, в конец
elem.insertAdjacentHTML('afterEnd', html); // После elem

// Когда DocumentFragment вставляется в DOM, он исчезает, а вместо него вставляются все дочерние элементы
var fragment = document.createDocumentFragment(); // Создать временный DOM-объект
fragment.appendChild(elem); // Добавление элемента во временный объект
var other_fragment = fragment.cloneNode(true); // Копирование с подэлементами

// document.write =============================================================

// Работает корректно только пока код еще не загружен до конца
