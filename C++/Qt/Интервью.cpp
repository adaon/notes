/* Модели */

// Иерархия базовых классов моделей
QAbstractItemModel // Базовый класс всех моделей
    QAbstractListModel // Одномерный список
        QStringListModel // Представляет одномерную модель списка строк (QStringList)
    QDirModel // Готовый класс иерархии файловой системы
    QAbstractProxyModel // 
        QSortFilterProxyModel
    QStandartItemModel // Позволяет напрямую сохранять данные в модели
    QAbstractTableModel // Двухмерная таблица
        QSqlQueryModel
        QSqlTableModel
        QSqlRelationalTableModel
        
// Создание строковой модели списка
QStringListModel model;
model.setStringList(qStringList);

/* Представления */

veiw->setEditTriggers(QAbstractItemView::NoEditTriggers|DoubleClicked|SelectedClicked); // Задает параметры переименования элементов (переименование невозможно|переименовать, если на элементе был произведен двойной щелчок|переименовать, если на выбранном элементе был произведен еще один щелчок мышью)
view->selectionModel(); // Получение модели выделения QItemSelectionModel
view->setSelectionModel(qItemSelectionModel); // Установка модели выделения
view->setModel(model); // Установка модели

QAbstractItemView
    QHeaderView
    QListView // Одномерный список
        QListWidget
    QTableView // Отображает иерархические списки
        QTableWidget
    QTreeView // Отображает данные в виде таблицы
        QTreeWidget
        
QItemSelectionModel selection(model); // Создание модели выделения

/* Делегаты */

QAbstractItemDelegate
    QItemDelegate
        QSqlRelationDelegate
        
/* Индексы модели */
        
// Каждая ячейка таблицы имеет уникальный индекс, который представлен классом QModelIndex
QStandartItemModel *model = new QStandartItemModel(5, 3);
QModelIndex index = pModel->index(2, 5, index); // Получение определенного индекса
QVariant value = model->data(index); // Получение значения по индексу
model->setData(index, "data"); // Установка значения по индексу
model->insertRows(0, 4, index); // Вставка строк в ячейку по индексу
model->insertColumns(0, 3, index); // Вставка столбцов в ячейку по индексу

/* Пример приложения файловой системы */
QDirModel *model = new QDirModel(); // Создание модели
QTreeView *treeView = new QTreeView(); // Создание представления
treeView->setModel(model); // Установка модели
QModelIndex index = model->index("C:\\Users\\L\\Desktop"); // Получение индекса рабочего стола
treeView->setRootIndex(index); // Установка корневого индекса