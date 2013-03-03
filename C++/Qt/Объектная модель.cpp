QObject //  Основной, базовый класс. Классы, имеющие сигналы и слоты, должны быть унаследованы от этого класса. В механизме наследования он должен стоять первым.

class MyClass : QObject {
    Q_OBJECT // Данный макрос должен содержаться в каждом классе (на первой строке) для поддержки механизма сигналов и слотов.
};

qobject_cast<T>() // Приведение типов

// Задание свойства
Q_PROPERTY(type name
    READ getFunction
    [WRITE setFunction]
    [RESET resetFunction]
    [DESIGNABLE bool] // Должно ли свойство появляться в инспекторе свойств Qt Designer
    [SCRIPTABLE bool] // Доступно ли свойство для языка сценария Qt Script
    [STORED bool] // Будет ли свойство запоминаться во время сохранения объекта
)

obj->setProperty("propName", value); //  Изменение значения свойства
obj->property("propName"); // Получение значения свойства

/* Сигналы и слоты */
class MyClass {
    Q_OBJECT
public:
    void sendSignal() {
        emit doIt("MyString"); // Высылка сигнала
    }
signals:
    void doIt(const QString&); // Определение сигнала (можно также передавать параметр, но не обязательно)
};

class MyClass : public QObject {
    Q_OBJECT
public slots:
    // Определение слота
    void slot() {
        ...
        sender(); // Возвращает QObject
    }
};

QObject::connect(
    const QObject* sender, // Указатель на объект, высылающий сигнал
    const char* signal, // Сигнал, с которым осуществляется соединение. Прототип сигнала должен быть заключен в специальном макросе SIGNAL(method())
    const QObject* receiver, // Указатель на объект, который имеет слот для обработки сигнала. Если в качестве получателя используется this, данный параметр можно опустить
    const char* slot, // Слот, который вызывается при получении сигнала. Прототип слота должен быть заключен в специальном макросе SLOT(method())
    Qt::ConnectionType type = Qt::AutoConnection // Управляет режимом обработки. Имеется три возможных значения: Qt::DirectConnection — сигнал обрабатывается сразу, вызовом соответствующего слота. Qt::QueuedConnection - сигнал преобразуется в событие и ставится в общую очередь для обработки. Qt::QutoConnection - автоматический режим, который действует следующим образом: если объект, высылающий сигнал находитяс в одном потоке с объектом, принимающим его, устанавливается режим QueuedConnection, иначе - режим DirectConnection
);
// Сигналы можно соединять друг с другом
connect(pSender, SIGNAL(singalMethod()), SIGNAL(mySigna()));

// Разъединение сигналов
QObject::disconnect(pSender, SIGNAL(signalMethod), pReceiver, SLOT(slotMethod));
// Существуют два сокращенных, нестатических варианта:
disconnect(signal, received, slot);
disconnect(receiver, slot);

/* Объектные иерархии */
QObject(QObject* pobj); // Конструктор класса QObject. В параметре передается объект-предок, благодаря чему появляется возможность создавать иерархии. При уничтожении предка автоматически уничтожаются все его потомки
obj->setParent(obj); // Изменение предка объекта
obj->setObjectName(name); // Установка имени объекта
obj->objectName(); // получение имени объекта
obj->parent(); // Возвращает указатель на объект-предок. Для объектов верхнего уровня возвращает 0.
obj->children(); // Возвращает константный указатель на список объектов-потомков
obj->findChild<QObject*>(name); // Возвращает указатель на дочерний объект с указанным именем

/* QVariant */
QVariant v1(34);
QVariant v2(true);
QVariant v3("Hello");
v1.type(); // Возвращает целочисленный идентификатор типа. Чтобы получить из него имя типа, нужно передать его статической функции QVariant::typeToName(type)
v1.typeName(); // Возвращает имя типа
v1.toInt(); // Получение значения
v1.value<int>(); // Получение значения