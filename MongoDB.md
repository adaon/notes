# MongoDB
    
## Командные утилиты

### mongodump и mongostore

Стандартные утилиты резервного копирования и восстановления базы данных. `mongodump` сохраняет данные во внутреннем формате BSON, и потому применяется главным образом для создания резервных копий. Впоследствии можно восстановить эту базу с помощью `mongostore`.

### mongoexport и mongoimport

Экспортируют и импортируют файлы в форматах JSON, CSV и TSV.

### mongosniff

Анализатор протокола для просмотра команд, посылаемых серверу базы данных. Транслирует передаваемые команды в формате BSON в понятные человеку команды оболочки.

### mongostat

Постоянно опрашивает MongoDB и операционную систему для выдачи полезной статичтики, в том числе количества операций в секунду, объема выделенной виртуальной памяти и числа подключений к серверу.

## JavaScript-оболочка

    use database // Использовать базу данных

### Добавление документов

    db.users.insert({name: 'denis'}); // Вставить документ

### Изменение документов

    db.users.update({
        username: 'zuncou'
    }, {
        // Устанавливает значение свойства
        $set: {
            password: 'charmed'
        },
        // Удаляет свойство
        $unset: {
            country: 1
        },
        // Добавляет в набор уникальных значений
        $addToSet: {
            'favourites.movies': 'myMovie'
        }
    },
    false,
    true // Множественное обновление (по умолчанию применяется только к
        // первому найденному документу)
    );

### Получение документов

    db.users.find(); // Извлечение записей
    db.users.find({'favorites.moview': 'mymovie'});
    
    // Диапазон по запросу
    db.numbers.find({
        num: {
            $gt: 2000,
            $lt: 5000
        }
    }); 

### Удаление документов

    db.users.remove(); Удалить все документы из коллекции.
    
    db.users.remove({username: 'zuncou'}); // Удаление некоторых документов.
    
    db.users.drop(); // Уничтожение колекции вместе со всеми построенными над ней индексами.

### Индексы

    db.users.ensureIndex({num: 1}); // Установка индекса в порядке возрастания
    
    db.users.getIndexes();

## Администрирование

    // Статистика выполнения команды
    db.users.find(...).explain();

    // Показать список баз данных в системе
    show dbs;
    
    // Показать список всех коллекций в текущей базе данных
    show collections;
    show tables;
    
    // Подробная информация
    db.stats();
    db.users.stats();

Команда `db.stats()` эквивалентна команде `db.runCommand({dbstats: 1})`.

Команда базы данных - это запрос к специальной коллекции $cmd, в котором селектор определяет саму команду.

    db.$cml.findOne({collstats: 'numbers'});

## Справка

    // Вывод наиболее употребительных методов работы с базой данных
    db.help
    
    // Вывод методов работы с коллекцией
    db.users.help()

Если ввести первые буквы метода и затем дважды нажать <Tab>, выведется список ревалентных методов.