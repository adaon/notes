button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand(); // Получение команды действия (название кнопки по умолчанию)
		Object lol = event.getSource(); // Получение источника события
		event.getMofifiers(); // Нажаты ли клавиши ActionEvent.ALT_MASK|CTRL_MASK|META_MASK|SHIFT_MASK
		long when = event.getWhen(); // Время возникновения события
	}
});
button.addItemListener(new ItemListener() {
	public void itemStateChanged(ItemEvent event) {
		ItemSelectable source = event.getItemSelectable(); // Возвращает выбираемый объект - источник события
		event.getStateChange(); // Возврающает ItemEvent.SELECTED|DESELECTED
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