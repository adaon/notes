JList list = new JList(Vector<?>|array|ListModel);
list.getSelectedIndex(); // Возвращает индекс текущего выбранного элемента
list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION|SINGLE_INTERVAL_SELECTION|MULTIPLE_INTERVAL_SELECTION);
list.getSelectedIndices(); // возвращает массив выбранных индексов
list.getSelectedValue();
list.getSelectedValues();
list.setSelectedIndex(index);
list.setSelectedIndices(int[]);
list.setSelectedValue(Object, true|false); // Выбор элемента по значению и прокрутка к нему
list.clearSelection();
list.isSelectionEmpty();
list.getAnchorSelectionIndex(); // Возвращает индекс первого выбранного элемента
list.getLeadSelectionIndex(); // Возвращает индекс последнего выбранного элемента
list.setListData(Object[]|Vector<?>);

JComboBox box = new JComboBox(Object[]|Vector<?>);
box.getSelectedItem(); // Возвращает выбранный элемент
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