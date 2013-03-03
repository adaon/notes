# Создание обобщенного представления в виде класса
from django.veiws.generic import TemplateView
class AboutView(TemplateView):
    template_name = "about.html"
# urls.py:
(r'^about/$', AboutView.as_view()),
# или
(r'^about/$', AboutView.as_view(template_name="about.html")),

# Обобщенное представление списка объектов
# Будет использовано представление books/publisher_list.html (appname/model_list.html)
# В контексте будет содержаться переменная object_list
from django.views.generic import ListView
(r'^publishers/$', ListView.as_view(
        model=Publisher,
        context_object_name='publishers' # Установка своего имени для контекстного объекта
    )),

# Создание подкласса обобщенного представления объекта
from django.views.generic import DetailView
class PublisherDetailView(DetailView):
    context_object_name = 'publisher' # Собственное имя контекстной переменной
    model = Publisher # Модель
    # Переопределение функции получения контекста
    def get_context_data(self, **kwargs):
        context = super(PublisherDetailView, self).get_context_data(**kwargs)
        context['books_list'] = Book.objects.all() # Добавление дополнительной информации в контекст
        return context
    # Переопределение функции получения списка объектов
    def get_queryset(self):
        publisher = get_object_or_404(Publisher, name__iexact=self.args[0]) # self.args - позиционные аргументы представления, self.kwargs - именованные
        return Book.objects.filter(publisher=publisher)
    # Переопределение функции получения объекта
    def get_object(self):
        return object
    # Переопределение функции рендеринга
    def render_to_response(self, context):
        return ...
        
class Some(SomeView):
    queryset = Model.objects.filter(name='') # Указание набора данных для использования в представлении (более точный способ указания model=...)
    
### Декорирование обобщенных представлений ###
# Декорирование в URL
from django.contrib.auth.decorators import login_required, permission_required
from django.views.generic import TemplateView
from .views import VoteView

urlpatterns = patterns('',
    (r'^about/', login_required(TemplateView.as_view(template_name="secret.html"))),
    (r'^vote/', permission_required('polls.can_vote')(VoteView.as_view())),
)

# Декорирование класса
from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from django.views.generic import TemplateView

class ProtectedView(TemplateView):
    template_name = 'secret.html'
    @method_decorator(login_required)
    def dispatch(self, *args, **kwargs):
        return super(ProtectedView, self).dispatch(*args, **kwargs)