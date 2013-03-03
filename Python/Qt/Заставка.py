spl = QSplashScreen(QPixmap('myimg.png'))
spl.show() # Отобразить заставку
spl.finish(window) # Закрыть заставку. Принимает ссылку на главное окно приложения
spl.showMessage('Message', align, color) # Отобразить сообщение
spl.clearMessage() # Стереть сообщение
spl.setPixmap(pixmap) # Устанавливает изображение
spl.pixmap() # Возвращает изображение !Pixmap