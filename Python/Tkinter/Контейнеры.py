root = Tk() # Получение предопределенного объекта главного окна
root.title('Title') # Изменение заголовка главного окна
root.quit() # Закрывает окно и заканчивает его цикл mainloop
root.destroy() # Разрушение (закрытие) окна

# Frame
fra2 = Frame(root, width=300, height=200, bg="green", bd=20) # bf - аналог padding

# Toplevel - дочерние окна верхнего уровня
win = Toplevel(root,relief=SUNKEN,bd=10,bg="lightblue")
win.title("Дочернее окно")
win.minsize(width=400,height=200) 
win.maxsize(width=600,height=400) 