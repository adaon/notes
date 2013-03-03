QCheckBox checkBoc = new CheckBox(tr("name")); // Создание чекбокса

QPushButton button = new QPushButton(tr(name));
button->setDefault(); // задание кнопки по умолчанию, т.е. она будет вызываться при нажатии <Enter>
button->setEnabled(false); // Деактивация кнопки
