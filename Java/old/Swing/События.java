button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand(); // ��������� ������� �������� (�������� ������ �� ���������)
		Object lol = event.getSource(); // ��������� ��������� �������
		event.getMofifiers(); // ������ �� ������� ActionEvent.ALT_MASK|CTRL_MASK|META_MASK|SHIFT_MASK
		long when = event.getWhen(); // ����� ������������� �������
	}
});
button.addItemListener(new ItemListener() {
	public void itemStateChanged(ItemEvent event) {
		ItemSelectable source = event.getItemSelectable(); // ���������� ���������� ������ - �������� �������
		event.getStateChange(); // ����������� ItemEvent.SELECTED|DESELECTED
	}
});
button.addChangeListener(new ChangeListener() {
	public void stateChanged(ChangeEvent event) {
		
	}
});
list.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent event) {
	}
});
text.addCaretListener(new CaretListener() {
	public void caretUpdate(CaretEvent event) {
		
	}
});