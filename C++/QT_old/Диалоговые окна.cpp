QMessageBox::warning|question|information|critical(parent, title, message, QMessageBox::|Yes|No|Cancel); // Выводит диалоговое окно предупреждения

QString filename = QFileDialog::getOpenFileName(this, "Open File", "Database files (*.db)"); // Открытие файла
if(!filename.isEmpty()){/*...*/}

this->statusBar()->showMessage("Hello, world!", 2000); // Показывать сообщение в статусной строке в течение 2 секунд