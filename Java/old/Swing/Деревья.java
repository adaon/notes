DefaultMutableTreeNode node = new DefaultMutableTreeNode(object);
node.add(new DefaultMutableTreeNode(object));
tree.setRootVisible(false); // Должен ли корневой метод отображаться на экране
tree.setShowsRootHandles(true); // Показывать ли иконку корневого узла
tree.setUserObject(Obj); // Установить корневой узел

JTree tree = new JTree(rootNode);
tree.setEditable(true);
tree.setSelectionModel().setSelectionMode(mode);

node.remove(childNote);
node.isLeaf(); // Является ли узел листом

tree.addTreeSelectionListener(new TreeSelectionListener() {
	public void valueChanged(TreeSelectionEvent event) {
		TreePath path = event.getPath();
		Object[] p = path.getPath(); // Массив всех узлов в пути
		Object p = path.getLathPathComponent(); // Последний узел
	}
});

tree.addTreeExpansionListener(new TreeExpansionListener() {
	public void treeCollapsed(TreeExpansionEvent event) { // Свертывание поддерева
		TreePath path = event.getPath();
	}
	
	public void treeExpanded(TreeExpansionEvent event) { // Развертывание дерева
		TreePath path = event.getPath();
	}
});

tree.getModel().addTreeModelListener(new TreeModelListener() {
	public void treeNodesChanged(TreeModelEvent event) {
		TreePath path = event.getTreePath(); // Возвращает путь к родительскому узлу, потомок которого претерпел изменения
	}
	public void treeStructureChanged(TreeModelEvent event) {
		
	}
	public void treeNodesInserted(TreeModelEvent event) {
		
	}
	public void treeNotedRemoved(TreeModelEvent event) {
		
	}
});