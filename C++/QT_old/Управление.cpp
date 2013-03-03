// Загрузка файла ui в процессе выполнения. Для его использования необходимо добавить в файл project.pro строку "CONFIG += uitools"
QUiLoader uiLoader;
QFile file("filename.ui");
QWidget *dialog = uiLoader.load(&file);
QComboBox *box = dialog->findChild<QComboBox*>("comboBoxName"); // Доступ к дочерним виджетам загруженной формы