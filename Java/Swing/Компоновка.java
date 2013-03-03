new GridLayout(rows, cols, horzHap, vertGap); // �������� ��������� ��������� ����������

frame.setContentPane(pane); // ��������� ������ �����������

JScrollPane pane = new JScrollPane(component);
pane.setRowHeaderViuw(comp);
pane.setColumnHeaderViuw(comp);
pane.setViewportBorder(border); // ������������� ����� ������ ������� ���������
pane.setVerticalScrollBarPolicy(int value); // ������������� �������� ������������ ����� ���������
pane.setHorizontalScrollBarPolicy(int value); // ������������� �������� �������������� ����� ���������
pane.getVerticalScrollBar(); // ���������� ������������ ������ ���������
pane.getHorizontalScrollBar(); // ���������� �������������� ������ ���������
pane.setCorner(String which, comp); // �������� ��������� � ������� �������

JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP|LEFT|BOTTOM|RIGHT, JTabbedPane.WRAP_TAB_LAYOUT|SCROLL_TAB_LAYOUT);
pane.addTab(String name,[ icon,] comp|null[, String tooltip]);
pane.insertTab(String name,[ icon,] comp|null[, String tooltip, int index]); // ��������� ������� � ��������� �������
pane.setForegroundAt(); // ��������� ����� ��������� ����� �������
pane.setBackgroundAt();
pane.setMnemonicAt(); // ������������� �����������
pane.setSelectedIndex(); // ����� ������� �� ���������
pane.setEnabledAt(); // ���������� ��� ������ ������� � �������
pane.isEnabledAt();
pane.setDisabledIconAt();

JSplitPane pane = new JSplitPane();
pane.setOrientation(JSplitPane.HORIZONTAL_SPLIT|VERTICAL_SPLIT);
pane.setBottomComponent(comp);
pane.setLeftComponent(comp);
pane.setRightComponent(comp);
pane.setTopComponent(comp);
pane.setContinuousLayout(true|false);
pane.setOneTouchExpandable(true); // ��������� ���������� ���������� (������)