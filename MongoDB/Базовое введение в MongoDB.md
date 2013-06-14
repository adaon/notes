## Соединение с базой данных

    var MongoClient = require('mongodb').MongoClient;
    
    MongoClient.connect('mongodb://localhost/itcomps', function (err, db) {
        if (!err) {
            console.log('We are connected!');
        }
    });

## Коллекции

Возвращает коллекцию, но не создает новую до вставки документа.

    db.collection('test', function (err, collection) {});

Возвращает коллекцию, если она существует. Если не существует, передает ошибку.

    db.collection('test', {w:1}, function (err, collection) {});

Сразу же создает коллекцию. Если коллекция уже существует, просто возвращает объект.

    db.createCollection('test', function (err, collection) {});

Сразу же создает коллекцию. Если коллекция уже существует, передает ошибку.

    db.createCollection('test', {w:1}, function (err, collection) {});

## CRUD

### Вставка

При использовании данной команды невозможно получить статус операции вставки (успешно или нет).

    collection.insert(doc1);

В данном случае при неудаче передается ошибка.

    collection.insert(doc2, {w:1}, function (err, result) {});

Вставка партии документов. Любые ошибки будут передаваться. Это более эффективный способ вставки большого количества документов.

    collection.insert(lotsOfDocs, {w:1}, function (err, result) {});

### Обновление

    collection.update({mykey:1}, {$set:{fieldtoupdate:2}}, {w:1}, function(err, resultCount) {});

    collection.update({mykey:2}, {$push:{docs:{doc2:1}}}, {w:1}, function(err, resultCount) {});

* $inc: Увеличить исходное значение на определенную величину.
* $set: Установить определенное значение.
* $unset: Удалить определенное поле.
* $push: Добавить значение в массив.
* $pushAll: Добавить несколько значений в массив.
* $addToSet: Добавить значение в массив, только если оно отсутствует.
* $pop: Удаляет последний элемент массива.
* $pull: Удалить значения из существующего массива.
* $pullAll: Удалить некоторые значения из существующего массива.
* $rename: Переименовать поле.
* $bit: Битовые операции.

### Удаление

    collection.remove({mykey:1});

    collection.remove({mykey:2}, {w:1}, function(err, result) {});

Удалить все документы в коллекции:
    
    collection.remove();

## Запросы

Метод `find()` не выполняет запрос. Он возвращает курсок, который используется для получения данных.

Получает все документы коллекции и возвращает их в виде массива.

    collection.find().toArray(function () {});

Предпочтительный путь при использовании больших объемов данных.

    var stream = collection.find({mykey:{$ne:2}}).stream();
    stream.on("data", function(item) {});
    stream.on("end", function() {});

Получить один документ:

    collection.findOne({mykey:1}, function(err, item) {});