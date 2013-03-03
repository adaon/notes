w = Label(None, text='Hello, world!')
w['text'] = 'Text' # Изменение текста метки
w.config(text='Text') # Изменение конфигурации

lab = Label(root, text="Это метка! \n Из двух строк.", font="Arial 18")

ent = Entry(root,width=20,bd=3) # Однострочное текстовое поле (bd - ширина границы)

# Многострочное текстовое поле
text = Text(root,width=40,
          font="Verdana 12",
          wrap=WORD) 
text.delete(1.1, 1.2) # Удаление диапазона символов (в виде строка.символ)
text.insert(1.1, 'str') # Вставка строки в позицию строка.символ