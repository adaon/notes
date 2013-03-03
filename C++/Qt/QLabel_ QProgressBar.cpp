QLabel *l = new QLabel("Text");
l->setAlignment(align);
// Align:
AlignLeft;
AlignRight;
AlignHCenter;
AlignJustify;
AlignTop;
AlignBottom;
AlignVCenter;
AlignCenter;

// Создание метки с изображением
QPixmap pix;
pix.load("image.png");
QLabel label;
label.resize(pix.size());
label.setPixmap(pix);

label->setBuddy(wid); // Устанавливает партнера метки

// QProgressBar;
QProgressBar *p = new QProgressBar;
p->setRange(0, 100);
p->setValue(77);