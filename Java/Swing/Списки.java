JList list = new JList(Vector<?>|array|ListModel);
list.getSelectedIndex(); // ���������� ������ �������� ���������� ��������
list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION|SINGLE_INTERVAL_SELECTION|MULTIPLE_INTERVAL_SELECTION);
list.getSelectedIndices(); // ���������� ������ ��������� ��������
list.getSelectedValue();
list.getSelectedValues();
list.setSelectedIndex(index);
list.setSelectedIndices(int[]);
list.setSelectedValue(Object, true|false); // ����� �������� �� �������� � ��������� � ����
list.clearSelection();
list.isSelectionEmpty();
list.getAnchorSelectionIndex(); // ���������� ������ ������� ���������� ��������
list.getLeadSelectionIndex(); // ���������� ������ ���������� ���������� ��������
list.setListData(Object[]|Vector<?>);

JComboBox box = new JComboBox(Object[]|Vector<?>);
box.getSelectedItem(); // ���������� ��������� �������
box.getSelectedIndex();
box.setSelectedItem(obj);
box.setSelectedIndex(index);
box.setEditable(true);
box.addItem(obj);
box.removeItem(obj);
box.removeItemAt(index);
box.removeAllItems();
box.getItemCount();

JSpinner spinner = new JSpinner();
JSpinner spinner = new JSpinner(new SpinnerListModel(colors));