JButton button = new JButton("Exit");
JButton button = new JButton(text, icon);
JButton button = new JButton(icon);

button.isSelected(); // Выбрана ли кнопка
jbutton.isRolloverEnabled(); // Разрешено ли изменение при наведении

jbutton.setIcon(icon); // Установить изображение кнопки по умолчанию
jbutton.getIcon();
jbutton.setDisabledIcon(icon);
jbutton.setPressedIcon(icon);
jbutton.setRolloverIcon(icon);
jbutton.setRolloverSelectedIcon(icon);
jbutton.setSelectedIcon(icon);

frame.getRootPane().setDefaultButton(button); // Определение кнопки по умолчанию (выбирается при нажатии <Enter>)

JCheckBox checkBox = new JCheckBox();
checkBox.setSelected(true/false);

ButtonGroup bg = new ButtonGroup();
bg.add(radioButton);