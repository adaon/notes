### Загрузка форм ###

uic.loadUi("mainwindow.ui", object) # Загружает код формы в заданный объект

Form, Base = uic.loadUiType("MyForm.ui") # Загружает код формы и возвращает класс формы и базовый класс
widget.ui = Form()
widget.ui.setupUi(widget)

# Преобразование кода формы в класс формы
pyuic4.bat myform.ui -o ui_myform.py
from ui_myform import Ui_MyForm
# some object
self.ui = Ui_MyForm()
self.ui.setupUi(self)