SwingUtilities.invokeLater(new Runnable() { // Запуск swing в отдельном потоке событий
	public void run() {
		new MyFrame();
	}
});