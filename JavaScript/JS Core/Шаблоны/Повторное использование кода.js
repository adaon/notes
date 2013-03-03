// Классическое наследование #1 ===============================================

function Person() {
    // ...
}

function Programmer() {
    // ...
}

extends(Person, Programmer); // Наследование

function extends(Child, Parent) {
    Child.prototype = new Parent();
}

// Классическое наследование #2 ===============================================

function Programmer(name, age) {
    Person.apply(Person, arguments);
}

// Классическое наследование #3 ===============================================

function Programmer(a, b, c) {
    Person.apply(this, arguments);
}
Programmer.prototype = new Parent();

// Классическое наследование в полной мере ====================================

function inherit(C, P) {
    var F = function () {};
    F.prototype = P.prototype;
    C.prototype = new F();
    C.uber = P.prototype;
    C.prototype.constructor = C;
}