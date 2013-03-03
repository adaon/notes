l.setSpacing(5); // Задание размера свободного пространства между виджетами
l.setMargin(5); // Толщина бордюра лейаута
l.addWidget(wid); // Добавление виджета
l.addLayout(lay); // Добавление лейаута
l.removeWidget(wid); // Удаление виджета

// QBoxLayout | QHBoxLayout | QVBoxLayout;
QBoxLayout *l = new QBoxLayout(QBoxLayout::LeftToRight|RightToLeft|TopToBottom|BottomToTop);
l->insertWidget(); // Вставка виджета на заданную позицию
l->insertLayout(); // Вставка лейаута на заданную позицию.
l->insertSpacing(); // Вставка расстояния на заданную позицию
l->insertStretch(); // Вставка растяжения на заданную позицию
l->addSpacing(); // Добавить заданное расстояние
l->addWidget(wid, 1); // добавление виджета с параметром растяжения (по пропорции)
l->addLayout(wid, 1); // добавление лейаута с параметром растяжения (по пропорции)

// QGridLayout;
QGridLayout *l = new QGridLayout;
l->addWidget(wid, row, col, colspan, rowspan);

// QSplitter;
QSplitter *spl = new QSplitter(Qt::Vertical);
QTextEdit *t1 = new QTextEdit;
QTextEdit *t2 = new QTextEdit;
t1->setText("Line1\nLine2\nLine3\nLine4\nLine5\nLine6");
t2->setText("Line1\nLine2\nLine3\nLine4\nLine5\nLine6");
spl->addWidget(t1);
spl->addWidget(t2);
spl->show();