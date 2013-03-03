JTextField text = new JTextField(int cols); // простое текстовое поле
text.getSelectedText();
text.setCaretPosition(pos); // Установка позиции курсора
text.moveCaretPosition(pos); // Перемещение позиции курсора (с выделением)
text.cut();
text.copy();
text.paste();

JPasswordField pass = new JPasswordField(int cols);
pass.getPassword(); // Возврашает пароль в виде массива символов
pass.setEchoChar('$'); // Установить символ замены

JFormattedTextField fText = new JFormattedTextField(); // Форматированное поле ввода

JTextArea text = new JTextArea();
text.setLineWrap(true); // Включение переноса текста
text.setWrapStyleWord(true); // Перенос текста по словам
text.setTabSize(5); // Установка размера табулятора
text.append(text); // Добавляет текст в конец области
text.insert(text, index); // Добавляет текст в указанное место
text.replaceRange(text, start, end); // Заменяет указанный диапазон строкой
text.getLineCount(); // Количество строк в области (без автоматического перевода)