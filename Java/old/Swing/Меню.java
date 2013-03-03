JMenuBar menuBar = new JMenuBar()
menuBar.add(comp)
menuBar.add(comp, index)
menuBar.remove(comp)
menuBar.remove(index, comp)
menuBar.getMenuCount()
frame.setJMenuBar(menuBar)

JMenu menu = new JMenu(string)
menu.add(comp)
menu.add(comp, index)
menu.addSeparator()
menu.insertSeparator(index)
menu.getMenuComponentCount()
menu.getMenuComponents()
menu.setMnemonic(KeyEvent.VK_A);
menu.setDisplayedMnemonicIndex(0);
menuItem.setAccelerator(KeyStroke.getKeyStroke('a', InputEvent.CTRL_MASK))

JMenuItem menuItem = new JMenuItem("Name");

JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem();

JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem();

JSeparator ser = new JSeparator();

JPopupMenu popupMenu = new JPopupMenu();

JToolBar toolBar = new JToolBar();