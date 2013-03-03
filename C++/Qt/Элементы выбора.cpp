/* Списки */

QListWidget *list = new QListWidget();
list->addItem("Item 1"); // Добавление элемента в строковом представлении или объекта QListWidgetItem
list->insertItems(qStringList);
list->insertItem("Item 1"); // Добавление элемента в строковом представлении или объекта QListWidgetItem
list->clear(); // Очистка списка
list->setItemWidget(elem, widget); // Установка виджета в качестве элемента списка
list->itemWidget(elem); // Получение виджета, установленного в качестве элемента
list->sortItems(Qt::AscendingOrder|Qt::DescendingOrder); // Сортировка списка (в возрастающем|убывающем порядке)
list->currentItem(); // Возвращает указатель на выбранный элемент
list->selectedItems(); // Возвращает список выбранных элементов
list->setSelectionMode(QAbstractItemView::MiltiSelection|NoSelection|SingleSelection);
list->setViewMode(QListView::IconMode); // Установка режима пиктограмм
/* SIGNALS */
itemClicked(); // Сигнал щелчка на элементе
itemDoubleClicked(qListWidgetItem); // Сигнал двойного щелчка на элементе
itemSelectionChanged(); // Сигнал изменения выделения
itemChanged(qListWidgetItem); // Сигнал изменения (редактирования) элемента
itemRenamed(qListWidgetItem); // Сигнал изменения (переименования) элемента

QListWidgetItem *item = new QListWidgetItem("Microsoft"); // Создание элемента списка
item->setIcon(icon); // Присваивание изображения элементу
item->setFlags(Qt::ItemIsEditable|Qt::ItemIsEnables); // Установка элемента редактируемым | активным

/* Деревья */
QTreeWidget *tree = new QTreeWidget();
tree->setHeaderLabels(qStringList); // Установка заголовков
tree->setSortingEnabled(true); // Разрешение сортировки
tree->setItemExpanded(item, true);
tree->setItemWidget(widget); // Разместить виджет
tree->setSelectionMode(QAbstractItemView::MiltiSelection|NoSelection|SingleSelection);
/* SIGNALS */
itemSelectionChanged(); // Изменение выбранных элементов
itemClicked(QTreeWidgetItem, int); // Щелчок на элементе
itemDoubleClicked(QTreeWidgetItem, int); // Двойной щелчок на элементе
itemActivated(QTreeWidgetItem, int); // При двойном щелчке, а также при нажатии <Enter>

QTreeWidgetItem *item = new QTreeWidgetItem(tree); // Создание элемента дерева
QTreeWidgetItem *item2 = new QTreeWidgetItem(item); // Создание подэлемента элемента
item->setText(0, "Local Disk (C)"); // Установка текста 1 столбца элемента
item->setIcon(0, QPixmap("icon.png")); // Установка иконки 1 столбца элемента
item->addChildren(); // Вставить сразу несколько элементов
item->insertChildren();
item->setFlags(Qt::ItemIsDragEnabled|Qt::ItemIsEnabled); // Включение поддержки перетаскивания элемента
item->setFlags(Qt::ItemIsEditable); // Включение возможности редактирования элемента

// Проход по всем элементам дерева с помощью итератора
QTreeWidgetItemIterator it(tree, QTreeWidgetItemIterator::All|Selected);
while(*(++it)) {
    cout << (*it)->text(0);
}

/* Таблицы */
QTableWidget *table = new QTableWidget(1, 4); // Создание таблицы (1 строка, 4 столбца)
table->setHorizontalHeaderLabels(qStringList); // Установка горизонтальных заголовков
table->setVerticalHeaderLabels(qStringList); // Установка вертикальных заголовков
table->setItem(0, 0, item); // Вставка элемента в ячейку 1х1
table->setCellWidget(0, 1, widget); // Вставка виджета в ячейку 1х2

QTableWidgetItem *item = new QTableWidgetItem();
item->setText("text"); // Установка текста ячейки
item->setIcon(icon); // Установка изображения ячейки

/* Выпадающий список */
QComboBox *box = new QComboBox();
box->addItem(item); // Добавление элемента
box->addItems(qStringList); // Добавление нескольких элементов
box->setDuplicatesEnabled(false); // Включение ражима, исключающего повторяющиеся элементы из списка
box->clear(); // Очистка списка
box->currentIndex(); // Возвращает порядковый номер выбранного элемента
box->setEditable(true); // Включение возможности добавления в список новых элементов

/* Вкладки */
QTabWidget *tab = new QTabWidget();
tab->addTab(widget, icon, title); // Добавление новой вкладки


/* Виджет панели инструментов */
QToolBox *tool = new QToolBox();
tool->addItem(widget, icon, title); // Добавление групп панели инструментов
/* SIGNALS */
currentChanged(int); // Вызывается при выборе одной из закладок