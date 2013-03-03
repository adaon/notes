QPushButton *pb = new QPushButton();

button.addMenu(menu); // Добавление пункта всплывающего меню на кнопке
button.setText("test");
button.text(); // получение текста кнопки
button.setIcon(icon);
button.setIconSize(size);
button.icon();
button.iconSize();
button.setFlat(); // Плоская кнопка
button.setMenu(menu);
button.setCheckable(true); // Toggle-кнопка

// Сигналы:
clicked();
pressed();
released();
toggled();

// Опрос состояния:
isDown();
setDown();
isChecked();
setChecked();
isEnabled();
setEnabled();

QCheckBox *b = new QCheckBox("Text");
b->setTristate(true); // Использование флажка в промежуточном состоянии
b->setChecked(true); // Отметка флажка

QRadioButton *rb1 = new QRadioButton("Button 1");
QRadioButton *rb2 = new QRadioButton("Button 2");