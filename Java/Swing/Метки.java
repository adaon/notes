JLabel label = new JLabel("This is my frame!", SwingConstants.LEFT|RIGHT|TRAILING|CENTER|LEADING); // �������������� ������������ �����
JLabel label = new JLabel(["text", ]new ImageIcon("file.png")/*interface Icon*/[, alignment]); // �������� ����� � ������������ �/��� ������� �/��� ���. �������������

label.setVerticalTextPosition(alignConstant); // ������������ ������������ ������ ������������ �����������
label.setHorizontalTextPosition(alignConstant); // �������������� ������������ ������ ������������ �����������
label.setHorizontalAlignment(constant); // �������������� ������ �������� ���. ������������
label.setVerticalAlignment(SwingConstants.TOP|CENTER|BOTTOM); // ������������ ������������
label.setEnabled(false); // ������������� �����
label.setDisabledIcon(Icon icon); // ������� ������������������� ����������� ��� �����.
label.setDisplayedMnemonic('T'); // ������� ������������� ������� (������������� ������� ���������)
label.displayedMnemonicIndex(int index); // ������� ������ ��������� �������������
label.setLabelFor(component); // ������� ����� ��� ��������