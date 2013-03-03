// QAstractSlider;
s->setOrientation(Qt::Horizontal|Vertical);
s->setRange(0, 100); // Установка диапазона
s->setMinimum(0);
s->setMaximum(100);
s->setSingleStep(5); // Установка шага
s->setPageStep(100); // Установка шага страницы
s->setValue(77); // Установка значения
s->value(); // Получение значения
s->setTracking(афдыу); // В этом случае сигнал valueChanged() будет высылаться только при отпускании указателя текущего положения.

s->setTickPosition(QSlider::NoTicks|TicksAbove|TicksBelow|TicksBothSides);
s->setTickInterval();

// Сигналы:
sliderMoved(int);
valueChanged(int);
sliderPressed();
sliderReleased();