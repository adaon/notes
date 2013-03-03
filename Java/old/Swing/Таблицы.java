JTable table = new JTable(data[][], headers[]);
JTable table = new JTable(new MyModel);

table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION|SINGLE_INTERVAL_SELECTION|MULTIPLE_INTERVAL_SELECTION); // Установить режим выбора строк таблицы
table.setColumnSelectionAllowed(true); 
table.setRowSelectionAllowed(false);
table.setCellSelectionEnabled(true);
table.print(); // throws PrinterException
table.setGridColor(Color.GREEN);
table.setShowGrid(false); // Не выводить разделительные линии
table.setShowVerticalLines(false);
table.setShowHorizontalLines(false);
table.addColumn(colimn);
table.removeColumn(colimn);
table.moveColumn();
table.setDefaultRenderer(TableCellRenderer renderer);
table.setDefaultEditor(TableCellEditor editor);

int i = table.getSelectedRow();
int[] i = table.getSelectedRows();
int i = table.getSelectedColumn();
int[] i = table.getSelectedColumns();
ListSelectionModel selectionModel = table.getSelectionModel();
TableColumnModel columnModel = table.getColumnModel();

JTableHeader tableHeader = table.getTableHeader(); // Возврашает заголовки таблицы

selectionModel.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent event) {}
});

TableColumnModel columnModel = table.getColumnModel();
ListSelectionModel selectionModel = columnModel.getSelectionModel();
selectionModel.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent event) {}
});

table.getModel().addTableModelListener(new TableModelListener() {
	public void tableChanged(TableModelEvent event) {
		event.getFirstRow();
		event.getLastRow();
		event.getColumn();
		event.getType(); // Возвращает TableModelEvent.DELETE|INSERT|UPDATE
	}
});
table.getModel().getValueAt(row, column);
table.getModel().setValueAt(value, row, column);
table.setAutoResizeMode(JTable.AUTO_RESIZE_{ALL_COLUMNS|LAST_COLUMN|NEXT_COLUMN|OFF});
TableColumn col = table.getColumnModel().getColumn(index /* >= 0 */);
col.setPreferredWidth(500);
col.setMinWidth(n);
col.setMaxWidth(n);
col.getWidth();
col.getPreferredWidth();
col.getMaxWidth();
col.getMinWidth();



AbstractTableModel model new AbstractTableModel();
model.addTableModelListener(TableModelListener tml);
Class<?> getColumnClass(index); // Возвращает тип данных, которые содержатся в столбце.
int getColumnCount(); // Не реализован
String getColumnName(index);
int getRowCount(); // Не реализован
Object getValueAt(row, col); // Не реализован
boolean isCellEditable(row, col);
removeTableModelListener((TableModelListener tml);
setValueAt(Object value, row, col);