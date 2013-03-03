QWidget *w = new QWidget(Qt::Window|Qt::WindowSystemMenuHint);

// Типы окон:
Qt::Window;
Qt::Tool;
Qt::ToolTip;
Qt::Popup;
Qt::SplashScreen;

// Модификации окон:
Qt::WindowSystemMenuHint; // Только кнопка закрытия
Qt::WindowMaximizeButtonHint; // Все кнопки
Qt::FramelessWindowHint; // Без рамок и кнопок
Qt::WindowContextHelpButtonHint; // Кнопка закрытия и вопроса

// Размеры и позиция
w->width();
w->height();
w->size(); // Возвращает QSize
w->x();
w->y();
w->pos(); // QPoint
w->geometry(); // Возврашает QRect
w->move(x, y);
w.resize(width, height);
w.setGeometry(x, y, width, height);

// Фон;
QWidget *w = new QWidget(par);
QPalette pal;
pal.setColor(w->backgroundRole(), Qt::blue); // Палитра из цвета
pal.setColor(w->backgroundRole(), QBrusg(QPixmap(image.bmp))); // Палитра из изображения
w->setPalette(pale);
w->setAutoFillBackground(true); // Автоматическое отображение фона виджета.

// Курсоры (устанавливается методом win->setCursor()) пространства Qt::
ArrowCursor; // Стрелка
UpArrowCursor; // Стрелка вверх
CrossCursor; // Крест
WaitCursor; // Ожидание
IbeamCursor; // Текстовый курсор
PointingHandCursor; // Рука
ForbiddeCursor; // Запрещено
WhatsThisCursor; // Стрелка-вопрос
SizeVerCursor; // Вертикальное изменение
SizeHorCursor; // Горизонтальное изменение.
SizeBDiagCursor(); // Диагональный указатель изменения слева направо.
SizeFDiagCursor(); // Диагональный указатель изменения справа налево.
SizeAllCursor(); // Изменение во все стороны
SplitVCursor; // Вертикальное изменение высоты
SplitHCursor; // Горизонтальное изменение ширины
OpenHandCursor; // Разжатая рука
ClosedHandCursor; // Сжатая рука
BlankCursor; // Пустой указатель

QApplication::setOverrideCursor(cursor); // Установка курсора для всего приложения
QApplication::restoreOverrideCursor(); // Восстановление собственного курсора

// Стек виджетов
QStackedWidget *w = new QStackedWidget; // Создание стека виджетов
w->addWidget(&wid); // Добавление виджета в стек
w->removeWidget(&wid); // Удаление виджета из стека
w->setCurrentWidget(&wid); // Отображение определенного виджета
w->indexOf(&wid); // Возвращает идентификатор виджета

/* Рамки */
QFrame *frame = new QFrame();
frame->setFrameStyle(...);

QFrame::Raised // Выпуклая
QFrame::Plain // Плоская
QFrame::Sunken // Вогнутая
QFrame::Box
QFrame::Panel
QFrame::WinPanel
QFrame::HLine
QFrame::VLine
QFrame::NoFrame

w->setContentsMargin(x); // Установка дистанции от рамки до содержимого
// Установка ширины виджета
w->setLineMidth(x);
w->setMidLineWidth(x);

// Виджет прокрутки;
QScrollArea sa;
sa.setHorizontalScrollBarPolicy(Qt::ScrollBarAlwaysOn);
sa.setVerticalScrollBarPolicy(Qt::ScrollBarAlwaysOn);
sa.viewport(); // Получение указателя на виджет области просмотра
// Указатели QScrollBar на полосы прокрутки
sa.verticalScrollBar();
sa.horizontalScrollBar();
sa.cornerWidget();
sa.setWidget(); // Установка гланого виджета
sa.widget(); // Получение главного виджета
sa.removeChild(); // Удаление виджета

/* Пример использования полосы прокрутки */
QApplication *app = new QApplication(argc, argv);
QScrollArea *sa = new QScrollArea;
QWidget *pw = new QWidget;
QPixmap *pix = new QPixmap("C:\\Users\\L\\Test\\bill.jpg");
QPalette *pal = new QPalette;
pal->setBrush(pw->backgroundRole(), QBrush(*pix));
pw->setPalette(*pal);
pw->setAutoFillBackground(true);
pw->setFixedSize(pix->width(), pix->height());
sa->setWidget(pw);
sa->resize(350, 150);
sa->show();
return app->exec();