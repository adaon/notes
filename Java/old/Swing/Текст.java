JTextField text = new JTextField(int cols); // ������� ��������� ����
text.getSelectedText();
text.setCaretPosition(pos); // ��������� ������� �������
text.moveCaretPosition(pos); // ����������� ������� ������� (� ����������)
text.cut();
text.copy();
text.paste();

JPasswordField pass = new JPasswordField(int cols);
pass.getPassword(); // ���������� ������ � ���� ������� ��������
pass.setEchoChar('$'); // ���������� ������ ������

JFormattedTextField fText = new JFormattedTextField(); // ��������������� ���� �����

JTextArea text = new JTextArea();
text.setLineWrap(true); // ��������� �������� ������
text.setWrapStyleWord(true); // ������� ������ �� ������
text.setTabSize(5); // ��������� ������� ����������
text.append(text); // ��������� ����� � ����� �������
text.insert(text, index); // ��������� ����� � ��������� �����
text.replaceRange(text, start, end); // �������� ��������� �������� �������
text.getLineCount(); // ���������� ����� � ������� (��� ��������������� ��������)