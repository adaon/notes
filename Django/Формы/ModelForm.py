### ModelForm ###

# Создание класса формы по модели
from django.forms import ModelForm, Textarea

class MyForm(ModelForm):
    class Meta:
        model = MyModel
        pub_date = formsDateField(label='Publication date') # Можно полностью переопределять виджеты формы
        fields = ('name', 'date') # Список полей, которые будут отображаться на форме (также определяет порядок вывода полей)
        exclude = ('place', 'last_name') # Список полей, которые не должны отображаться на форме
        # Переопределение виджетов для полей формы. Словарь, состоящий из имен полей модели и классов или экземпляров виджетов
        widgets = {
            'name': Textarea(attrs={'cols': 80, 'rows': 20}),
        }
# Если у поля модели есть blank=True, тогда к полю формы будет добавлено required=False, иначе - required=True
# Значением атрибута label поля будет значение поля verbose_name модели, причем первый символ этого значения будет преобразован в верхний регистр
# Значением атрибута help_text поля формы будет значение атрибута help_text поля модели
# Если для поля модели установлен атрибут  choices, тогда для формы будет использоваться виджет Select
model = MyModel.objects.get(pk=1)
form = MyForm(instance=model)

# Побочным эффектом данных обращений является очистка данных модели, связанной с формой (приведение их в соответствующий языку формат)
form.is_valid()
form.errors
# Создает и сохраняет объект в базе данных, используя для этого данные, введенные в форму. Если форма связана с конкретным объектом, то save() обновит данный объект, иначе создаст новый экземпляр
# Кроме того, данный метод вызывает исключение ValueError, если данные формы не прошли проверку, т.е. атрибут errors формы вычисляется в True
form.save(
    commit=True # Если False, то метод вернет объект, который еще не был сохранен в базу данных. Иначе сразу сохраняет его
)
# Данный метод добавляется при вызове save() с параметром commit=False. Используется для сохранения объектов с отношениями "многие ко многим"
form.save_m2m()

# models.py (MyModel):
# Каждая форма, созданная по данной модели с помощью ModelForm не будет включать в себя это поле
field = models.MyField(editable=False)

### Наборы модельных форм ###

from django.forms.models import modelformset_factory
AuthorFormSet = modelformset_factory(Author)
formset = AuthorFormSet(
    queryset=Author.objects.filter(name__startswith='O') # Указание набора объектов для формы
)
formset.save() # Сохранение набора форм

# Встраиваемые наборы форм
# Создание набора форм для редактирования книг, принадлежащих определенному автору
from django.forms.models import inlineformset_factory
BookFormSet = inlineformset_factory(Author, Book)
author = Author.objects.get(name=u'Mike Royko')
formset = BookFormSet(instance=author)