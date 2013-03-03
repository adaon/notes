//QLineEdit;
QLineEdit *line = new QLineEdit("Enter your login."); // Создание строки текстового ввода
line->setText("text"); // Установка текстовой строки
line->text(); // Получение текстовой строки
line->setReadOnly(true); // Режим только для чтения
line->setEchoMode(QLineEdit::Password); // Поле для ввода пароля
line->setValidator(QMyValidator|QIntValidator|QDoubleValidator); // Устанавливает контроллер (можно создать свой, унаследовав класс QValidator
//и создав метод validate(QString), который должен возвращать QValidator::Invalid|QValidator::Acceptable)
// SIGNALS:
textChanged();
returnPressed();
// SLOTS:
copy();
cut();
paste();
undo();

// QTextEdit:
text->setReadOnly();
text->text();
text->setPlainText();
text->setHtml();
text->copy();
text->cut();
text->paste();
text->selectAll();
text->deselect();
text->clear();
text->textCursor(); // Получение объекта курсора (QTextCursor)
text->document(); // Получение объекта документа (QTextDocument)
text->setDocument(); // Установить документ
text->append(); // Добавление текста
text->find(); // Поиск и выделение заданной строки в тексте
text->zoomIn(); // Увеличение размера текста
text->zoomOut(); // Уменьшение размера текста
// SIGNALS:
textChanged();
selectionChanged();
// SLOTS:
document->undo();
document->redo();
insertHtml();
insertPlainText();

// Счетчики:
s->setWrapping(true); // Циклическая прокрутка счетчика
s->stepUp(); // Симуляция нажатия вверх
s->stepDown(); // Симуляция нажатия вниз
s->setSpecialValueText("text"); // Устанавливает текст независимо от числового значения

// QSpinBox:
spin->setRange(0, 100);
spin->setValue();
spin->value();
spin->setPrefix();
spin->setSuffix();
// SIGNALS:
valueChanged(int|QString);

// QDateTimeEdit:
QDateTimeEdit dateTimeEdit(QDateTime::currentDateTime()); // Текущая дата и время
// SIGNALS:
dateTimeChanged(const &QDateTime);