// Создание объектов ==========================================================

var o = new Object(); // Создание объекта с помощью функции-конструктора

var obj = {x:3, y:4}; // Объектный литерал
var obj = {}; // Пустой объект

// Преобразование объектов ====================================================

obj.valueOf(); // Данный метод вызывается при использовании объекта в числовом контексте
obj.toString(); // Данный метод вызывается при использовании объекта в строковом контексте или при неудачном вызове valueOf()

// Свойства объектов ==========================================================

// Проверка существования свойства (имя свойства указывается в виде строки)

if('x' in obj) { }
if(obj.x !== undefined) { }
    
// Удаление свойства

delete obj.x;

// Свойства Object ============================================================

obj.constructor; // Ссылается на функцию-конструктор

obj.toString(); // Вызывается при использовании объекта в строковом контексте
obj.toLocaleString(); // Возвращает локализованную строку
obj.valueOf(); // Вызывается при использовании объекта в контексте элементарного типа (числа)
obj.hasOwnProperty('prop'); // Определено ли объектом собственное свойство (не унаследованное)
obj.propertyIsEnumerable('prop'); // Возвращает true, если в объекте определено свойство, которе может быть перечислено циклом for/in
obj.isPrototypeOf(o); // Является ли объект прототипом

// Сравнение объектов =========================================================

// При сравнивании объектов с помощью операторов сравнения выясняется, указывают ли ссылки на ОДИН И ТОТ ЖЕ объект, но не сравниваются значения данных объектов

// Для сравнения объектов можно определить метод экземпляра equals(obj), который принимает объект и возвращает true в случае их идентичности
function Rectangle() {
    this.equals = function(obj) {
        if this.width == obj.width && this.height == obj.height return true;
        else return false;
    }
}

// При сравнении объектов < > сначала вызывается метод valueOf. Для пользовательского сравнения можно реализовать функцию compareTo
function Rectangle() {
    this.compareTo = function(obj) {
        if(this > obj) return 1;
        if(this == obj) return 0;
        if(this < obj) = return -1;
    }
}
// Имея такую функцию легко реализовать сортировку массива
arr.sort(function(a, b){ return a.comparetTo(b); });
// Следует предусмотреть статический метод compare для упрощенной сортировки массивов
Rectangle.compare = function(a, b) { return a.compareTo(b); }
arr.sort(Rectangle.compare);

// Определение типа объекта ===================================================

Object.prototype.toString.apply(obj); // Вызов метода toString для объекта по умолчанию

// Сериализация объектов =======================================================

// Работает ТОЛЬКО В FIREFOX
object.toSource(); // Возвращает строковой источник объекта, который после передачи функции eval() возвращает исходный объект