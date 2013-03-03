new GridLayout(rows, cols, horzHap, vertGap); // Создание сеточного менеджера компоновки

frame.setContentPane(pane); // Установка панели содержимого

JScrollPane pane = new JScrollPane(component);
pane.setRowHeaderViuw(comp);
pane.setColumnHeaderViuw(comp);
pane.setViewportBorder(border); // Устанавливает рамку вокруг области просмотра
pane.setVerticalScrollBarPolicy(int value); // Устанавливает политику вертикальных полос прокрутки
pane.setHorizontalScrollBarPolicy(int value); // Устанавливает политику горизонтальных полос прокрутки
pane.getVerticalScrollBar(); // Возвращает вертикальную полосу прокрутки
pane.getHorizontalScrollBar(); // Возвращает горизонтальную полосу прокрутки
pane.setCorner(String which, comp); // Помещает компонент у угловую область

JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP|LEFT|BOTTOM|RIGHT, JTabbedPane.WRAP_TAB_LAYOUT|SCROLL_TAB_LAYOUT);
pane.addTab(String name,[ icon,] comp|null[, String tooltip]);
pane.insertTab(String name,[ icon,] comp|null[, String tooltip, int index]); // Вставляет вкладку в указанную позицию
pane.setForegroundAt(); // Установка увета переднего плана вкладки
pane.setBackgroundAt();
pane.setMnemonicAt(); // Мнемоническое обозначение
pane.setSelectedIndex(); // Выбор вкладки из программы
pane.setEnabledAt(); // разрешение или запрет доступа к вкладке
pane.isEnabledAt();
pane.setDisabledIconAt();

JSplitPane pane = new JSplitPane();
pane.setOrientation(JSplitPane.HORIZONTAL_SPLIT|VERTICAL_SPLIT);
pane.setBottomComponent(comp);
pane.setLeftComponent(comp);
pane.setRightComponent(comp);
pane.setTopComponent(comp);
pane.setContinuousLayout(true|false);
pane.setOneTouchExpandable(true); // Разрешает мгновенное расширение (кнопки)