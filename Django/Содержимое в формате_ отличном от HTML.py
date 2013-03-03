### MIME-type ###
# Отображение изображения
def my_view(request):
    return HttpResponse(image_data, mimetype='image/png')
    
### Создание CSV ###
import csv

def my_view(request):
    UNRULY_PASSENGERS = [123, 456, 123, 456, 123]
    # Создать объект HttpResponse с заголовком, описываюшим формат CSV
    response = HttpResponse(mimetype='text/csv')
    response['Content-Disposition'] = 'attachment; filename=unruly.csv' # Данный заголовок говорит браузеру, что файл нужно именно сохранить, а не просто отобразить
    # Создать объект вывода CSV, используя HttpResponse как файл
    writer = csv.writer(response)
    writer.writerow(['Year', 'Unruly Airline Passengers'])
    for (year, num) in zip(range(1995, 2007), UNRULY_PASSENGERS):
        writer.writerow([year, num])
    return response
    
### Создание PDF ###
from reportlab.pdfgen import canvas

def my_view(request):
    # Создать объект HttpResponse с заголовками для PDF
    response = HttpResponse(mimetype='application/pdf')
    response['Content-Disposition' = 'attachment; filename=hello.pdf']
    # Создать объект PDF, передав объект ответа в качестве файла
    p = canvas.Canvas(response)
    # Нарисовать нечто в pdf
    p.drawString(100, 100, "Hello, world!")
    # Закрыть объект PDF
    p.showPage()
    p.save()
    return response
    
# Альтернативный вариант с использованием StringIO (для достижения большей эффективности)
from cStringIO import StringIO
from reportlab.pdfgen import canvas

def my_view(request):
    response = HttpResponse(mimetype='application/pdf')
    response['Content-Disposition'] = 'attachment; filename=hello.pdf'
    temp = StringIo()
    p = canvas.Canvas(temp)
    p.drawString(100, 100, 'Hello, world!')
    p.showPage()
    p.save()
    response.write(temp.getvalue())
    return response
    
### Библиотека zipfile, tarfile ###
### Библиотека PIL (для изображений) ###
### matplotlib (графики) ###
### pygraphviz (графики) ###

### Каналы синдицирования (RSS, Atom) ###

# urls.py:
from mysite.feeds import Feed1, Feed2
# Словарь, используемый для соединения url с пользовательскими классами RSS
feeds = {
    'feed1': Feed1,
    'feed2': Feed2
}
(r'^feeds/(?p<url>.*)/$', 'django.contrib.syndication.views.feed', {'feed_dict': feeds}),

# Реализация класса RSS
# Чтобы определить содержимое тега <link> сначала вызывается метод get_sbdolute_url объекта, если такого метода нет, вызывается метод item_link класса, передавая ему в качестве параметра объект
from django.contrib.syndication.feeds import Feed
class MyFeed(Feed):
    title = 'Мой блог' # <title>
    link = '/archive/' # <link>
    description = 'Последние новости по теме.' # <description>
    
    # В данные шаблоны передаются obj (текущий объект), site (текущий сайт, site.domain, site.name)
    title_template = 'my_template.html' # Шаблон для отображения заголовка каждой записи
    description_template = 'my_template.html' # Шаблон для отображения описания каждой записи
    
    def items(self):
        return MyModel.objects.order_by('-pub_date')[:5]
        
    def item_link(self, obj):
        return obj.get_url()