JButton button = new JButton("Exit");
JButton button = new JButton(text, icon);
JButton button = new JButton(icon);

button.isSelected(); // ������� �� ������
jbutton.isRolloverEnabled(); // ��������� �� ��������� ��� ���������

jbutton.setIcon(icon); // ���������� ����������� ������ �� ���������
jbutton.getIcon();
jbutton.setDisabledIcon(icon);
jbutton.setPressedIcon(icon);
jbutton.setRolloverIcon(icon);
jbutton.setRolloverSelectedIcon(icon);
jbutton.setSelectedIcon(icon);

frame.getRootPane().setDefaultButton(button); // ����������� ������ �� ��������� (���������� ��� ������� <Enter>)

JCheckBox checkBox = new JCheckBox();
checkBox.setSelected(true/false);

ButtonGroup bg = new ButtonGroup();
bg.add(radioButton);