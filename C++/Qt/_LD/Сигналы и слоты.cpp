class MySignal {
	Q_OBJECT
	
	signals:
		void doIt(const QString&); // Определение сигнала
	public slots:
		void slot() {
			sender()->objectName(); // Вызывющий объект
		} // Реализация слота
};

emit doIt("Lol"); // Вызов сигнала

QObject->connect(from, SIGNAL(...), to, SLOT(...));
QObject->disconnect(from, SIGNAL(...), to, SLOT(...));