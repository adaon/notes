JLabel label = new JLabel("This is my frame!", SwingConstants.LEFT|RIGHT|TRAILING|CENTER|LEADING); // Горизонтальное выравнивание метки
JLabel label = new JLabel(["text", ]new ImageIcon("file.png")/*interface Icon*/[, alignment]); // Создание метки с изображением и/или текстом и/или гор. выравниванием

label.setVerticalTextPosition(alignConstant); // Вертикальное выравнивание текста относительно изображения
label.setHorizontalTextPosition(alignConstant); // Горизонтальное выравнивание текста относительно изображения
label.setHorizontalAlignment(constant); // Альтернативный способ указания гор. выравнивания
label.setVerticalAlignment(SwingConstants.TOP|CENTER|BOTTOM); // Вертикальное выравнивание
label.setEnabled(false); // Деактивизация метки
label.setDisabledIcon(Icon icon); // Задание деактивизированного изображения для метки.
label.setDisplayedMnemonic('T'); // Задание мнемонической клавиши (подчеркивание первого вхождения)
label.displayedMnemonicIndex(int index); // Задание номера вхождения подчеркивания
label.setLabelFor(component); // Задание метки для элемента