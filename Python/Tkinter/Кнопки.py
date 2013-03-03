exitButton = Button(main, text='Exit', command=sys.exit)

but = Button(root,
          text="Это кнопка", #надпись на кнопке
          width=30,height=5, #ширина и высота
          bg="white",fg="blue") #цвет фона и надписи

# Радиокнопки
var=IntVar() # Создание группы-переменной
var.set(1) # Установка переменной
rad0 = Radiobutton(root,text="Первая",
          variable=var,value=0)
rad1 = Radiobutton(root,text="Вторая",
          variable=var,value=1)
var.get() # Получение значения переменной

# Флажки
c1 = IntVar()
c2 = IntVar()
che1 = Checkbutton(root, text="Первый флажок", variable=c1, onvalue=1, offvalue=0)