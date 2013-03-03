// Получение стилей ===========================================================

elem.className // Содержит значение аттрибута class

// НЕ ПОДДЕРЖИВАЕТСЯ В IE<10
elem.classList.contains('class') // Есть ли у элемента указанный класс
elem.classList.add/remove('class') // Добавляет/удаляет класс
elem.classList.toggle('class') // Добавляет класс class если его нет, если есть - удаляет

elem.style // Доступ к стилю элемента
elem.style.backgroundColor = 'black';
elem.style.cssText = 'css text'; // Чтение/установка целого набора свойств

getComputedStyle(element, pseudo); // Получить вычисленное значение стиля (можно указать псевдоселектор)

// Пропущено:
http://learn.javascript.ru/metrics
http://learn.javascript.ru/metrics-window
http://learn.javascript.ru/coordinates