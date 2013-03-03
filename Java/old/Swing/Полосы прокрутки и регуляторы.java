comp.getValueIsAdjusting(); // Регулируется ли элемент в данный момент
comp.setValueIsAdjusting();

boundedRangeModel.getExtent();
boundedRangeModel.getMaximum();
boundedRangeModel.getMinimum();
boundedRangeModel.getValue();
boundedRangeModel.setExtent();
boundedRangeModel.setMaximum();
boundedRangeModel.setMinimum();
boundedRangeModel.setValue();
boundedRangeModel.setRangeProperties(val, ext, min, max, isAdj);

boundedRangeModel.addChangeListener(new ChangeListener() {
	public void stateChanged(ChangeEvent event) {
		
	}
});

JScrollBar sb = new JScrollBar();

JSlider slider = new JSlider();

slider.setMajorTickSpacing(10);
slider.setMinorTickSpacing(5);
slider.setPaintTicks(true);
slider.setLabelTable(slider.createStandardLabels(20));
slider.setPaintLabels(true);
slider.setSnapToTicks(true);
slider.setInverted();

slider.getMajorTickSpacing(10);
slider.getMinorTickSpacing(5);
slider.getPaintTicks(true);
slider.getLabelTable(slider.createStandardLabels(20));
slider.getPaintLabels(true);

JProgressBar pb = new JProgressBar();
pb.setStringPainted(true); // Отображать строку
pb.isStringPainted(); // Отображается ли строка
pb.setIndeterminate(true); // Ожидание
pb.isIndeterminate(true); // Включено ли ожидание
pb.setBorderPainted(false); // Запрещает выведение рамки
pb.setString(text); // Выводит в составе компонента строку
pb.getString(); // Получает в составе компонента строку