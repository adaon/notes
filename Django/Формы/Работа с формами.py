from django import forms

# Реализация класса формы
class MyForm(forms.Form):
    # Текстовое поле
    subject = forms.CharField(max_length=100)
    message = forms.CharField()
    # Поле e-mail
    sender = forms.EmailField()
    cc_myself = forms.BooleanField(required=False)

# Если форма не была отправлена (метод не POST), создается несвязанная форма и возвращается клиенту
# Если форма была отправлена (метод POST), форма связывается с помощью request.POST. Если форма корректна, совершается перенаправление
# Если форма отправлена, но некорректна, связанная форма возвращается клиенту
def contact(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            return HttpResponseRedirect('/thanks/')
    else:
        form = ContactForm()

    return render_to_response('contact.html', { 'form': form, })

form.cleaned_data['field_name'] # Получение очищенных данных (преобразованных в соответствующий тип)

# template.html
# Представляет форму в виде абзацев (без тега form и кнопки)
# Каждое поле снабжается аттрибутом id (id_fieldname)
{{ form.as_p }}
# Представляет форму в виде таблицы (без тега form и table)
{{ form.as_table }}
# Представляет форму в виде маркированного списка
{{ form.as_ul }}

# Собственное представление формы
<form action="/contact/" method="post">
    {{ form.non_field_errors }}
    <div class="fieldWrapper">
        {{ form.subject.errors }}
        <label for="id_subject">E-mail subject:</label>
        {{ form.subject }}
    </div>
    <div class="fieldWrapper">
        {{ form.message.errors }}
        <label for="id_message">Your message:</label>
        {{ form.message }}
    </div>
    <div class="fieldWrapper">
        {{ form.sender.errors }}
        <label for="id_sender">Your email address:</label>
        {{ form.sender }}
    </div>
    <div class="fieldWrapper">
        {{ form.cc_myself.errors }}
        <label for="id_cc_myself">CC yourself?</label>
        {{ form.cc_myself }}
    </div>
    <p><input type="submit" value="Send message" /></p>

</form>
{{form.non_field_errors}} # Список общих ошибок
{{form.field.errors}} # Список ошибок для поля
{{form.field}} # Генерирует виджет ввода

# Переход в цикле по полям формы
<form action="/contact/" method="post">
    {% for field in form %}
        <div class="fieldWrapper">
            {{ field.errors }}
            {{ field.label_tag }}: {{ field }}
        </div>
    {% endfor %}
    <p><input type="submit" value="Send message" /></p>
</form>

# Метка поля
{{ field.label }}
# HTML-тег метки
{{ field.label_tag }}
# Имя поля ввода (name)
{{ field.html_name }}
# Текст помощи поля
{{ field.help_text }}
# Список ошибок поля
{{ field.errors }}
# Скрыто ли поле
field.is_hidden

# Проход в цикле по скрытым полям
{% for hidden in form.hidden_fields %}
    {{ hidden }}
{% endfor %}