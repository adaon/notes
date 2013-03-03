// Конструкторы ===============================================================

var obj = new MyObject(); // Создание объекта с помощью функции-конструктора

// Функция-конструктор
// Если конструктор возвращает объект, он становится значением выражения new. В таком случае объект this просто уничтожается
function Rectangle(w, h) {
    this.width = w;
    this.height = h;
}

// Прототипы и наследование ===================================================

// Добавление свойства к прототипу конструктора (становится общим свойством для всех создаваемых объектов)
Rectangle.prototype.area = function() { return this.width * this.height; }

// При ЧТЕНИИ свойства сначала выполняется поиск в объекте, затем в прототипе
// При ЗАПИСИ свойства значение всегда записывается в объект

// Автоматический поиск свойств в прототипе происходит ТОЛЬКО ПРИ ЧТЕНИИ, но не при записи

// С помощью прототипов можно расширять встроенные типы:
String.prototype.show() = function() { alert(this); }

// Свойства класса ============================================================

// Свойства класса имитируются свойствами функций-конструкторов
Rectangle.INIT = new Rectangle(1, 1);
Rectangle.parse = function() { return new Rectangle(); }

// Частные члены ==============================================================

// Можно имитировать частные члены посредством замыканий
function Rectangle(w, h) {
    this.getWidth = function() { return w; }
    this.getHeight = function() { return h; }
}

// Подклассы и надклассы ======================================================

// Надкласс
function Rectangle(w, h) {
    this.width = w;
    this.height = h;
}
// Подкласс
function PositionedRectangle(x, y, w, h) {
    // Сначала необходимо вызвать конструктор надкласса для текущего объекта (вызов конструктора по цепочке)
    Rectangle.call(this, w, h);
    this.x = x;
    this.y = y;
}
// Далее необходимо явно создать объект-прототип
PositionedRectangle.prototype = new Rectangle();
// В наследовании width и height нет необходимости
delete PositionedRectangle.prototype.width;
delete PositionedRectangle.prototype.height;
// Изменение ссылки на конструктор прототипа
PositionedRectangle.prototype.constructor = PositionedRectangle;

// Вызов переопределенного метода из нового
return Rectangle.prototype.toString.apply(this);