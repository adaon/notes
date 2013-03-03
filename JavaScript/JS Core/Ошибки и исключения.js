throw new Error('My error'); // Генерация исключения

try {
    // ...
}
catch(e) {
    e.name // Тип ошибки
    e.message // Сообщение и деталях ошибки
}
finally {
    // Выполняется всегда
}