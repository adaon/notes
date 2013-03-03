window = QWidget(
    parent, # Ссылка на родительский компонент. Если не указано, виджет имеет свое собственное окно
    flags # Тип окна. Если указано, виджет имеет свое окно, но остается зависимым от родителя
)

window.setWindowTitle('MyTitle') # Установка заголовка окна
window.resize(300, 200) # Изменения размеров окна
window.setParent(obj) # Указание ссылки на родительский компонент
window.parentWidget() # Получение ссылки на родительский компонент
window.show() # Отображение окна и всех дочерних компонентов
window.hide() # Скрытие окна
window.setVisible(true|false) # Скрытие или отображение окна
window.isVisible() # Отображается ли окно
window.isHidden() # Скрыто ли окно
# Принимает аттрибуты Qt.<name>:
window.setWindowFlags(
    Widget # Тип по умолчанию
    Window # Является окном, независимо от наличия родителя
    Dialog # Диалоговое окно
    Sheet
    Drawer
    Popup # Всплывающее меню. Выводится без рамки и заголовка
    Tool # Панель инструментов
    ToolTip # Всплывающая подсказка
    SplashScreen # Заставка
    Desktop # Рабочий стол. Значение по умолчанию для класса QDesktopWidget
    SubWindow # Окно является дочерним компонентом, независимо от наличия родителя
    |
    # Следующие аттрибуты только для окон верхнего уровня
    |MSWindowsFixedSizeDialogHint # Запрещает изменение размеров окна
    |FramekessWindowHint # Убирает рамку и заголовок окна. Изменять размеры окна и перемещать его нельзя
    |CustomizeWindowHint # Убирает рамку и заголовок окна, но добавляет эффект объемности
    |WindowTitleHint # Добавляет заголовок окна
    |WindowSystemMenuHint # Добавляет оконное меню и кнопку Закрыть
    |WindowMinimizeButtonHint # Кнопка Свернуть в заголовке окна делается активной, а кнопка Развернуть - неактивной
    |WindowMaximizeButtonHint # Кнопка Развернуть в заголовке окна делается активной, а кнопка Свернуть - неактивной
    |WindowMinMaxButtonHint # Кнопки Свернуть и Развернуть в заголовке окна делаются активными
    |WindowCloseButtonHint # Добавляет кнопку Закрыть
    |WindowContextHelpButtonHint # Добавляет кнопку Справка
    |WindowStaysOnTopHint # Всегда поверх других окон
    |WindowStaysOnBottomHint # Всегда позади других окон
)
window.windowType() # Возвращает тип окна
window.windowFlags() # Получить все установленные флаги окна:
#if (window.windowFlags() & Qt.WindowType_Mask) == Qt.Window: ...


### Изменение и получение размеров окна ###

w.width()
w.height()
w.size() # Возвращает QSize
w.x()
w.y()
w.pos() # Возвращает QPoint
w.geometry() # Возвращает QRect
w.move(x, y)
w.resize(width, height)
w.setGeometry(x, y, width, height)
w.setFixedSize(width, height) # Задает фиксированый размер (нельзя изменить)
w.setFixedWidth(width)
w.setFixedHeight(height)

window.setWindowOpacity(0.0-1.0) # Изменение прозрачности окна