class CalendarWidget(forms.TextInput):
    class Media:
        # Словарь, описывающий CSS-файлы для различных устройств
        css = {
            'all': ('pretty.css',),
            'screen': ('pretty.css',),
            'print': ('newspaper.css',)
        }
        # JavaScript - файлы
        js = ('animations.js', 'actions.js')
        # Производится ли наследование родительских ресурсов
        extend = False 
    
    # Динамическое определение ресурсов
    def _media(self):
        return forms.Media(css={'all': ('pretty.css',)},
                           js=('animations.js', 'actions.js'))
    media = property(_media)
        
w = CalendarWidget()
# Возвращает html-теги для подключения ресурсов
w.media
w.media['css']

# Ресурсы формы
class ContactForm(forms.Form):
    date = DateField(widget=CalendarWidget)
    name = CharField(max_length=40, widget=OtherWidget)
    class Media:
        css = {
            'all': ('layout.css',)
        }
f = ContactForm()
# Значением по умолчанию для этого свойства является результат сочетания ресурсов всех виджетов формы
f.media