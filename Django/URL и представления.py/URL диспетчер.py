from django.conf.urls.defaults import * # Функция patterns

urlpatterns = patterns('view_prefix',
	# Неименованные группы передаются представлению
    (r'^articles/(\d{4})/(\d{2})/(\d+)/$', 'news.views.article_detail'),
    # Именованные группы передаются как именованные параметры
    (r'^path1/path2/(?P<paramname>\d+)/$', 'news.views.view1'),
    # Включение других модулей
    # Можно передавать непосредственный список (urlpatterns) адресов
    (r'^(?P<username>\w+)/blog/', include('foo.urls.blog')),
    # Передача в функцию дополнительных параметров
    (r'^some_url/$', 'some_view', {'some_name':'some_value'}),
    # Именованные адреса
    (r'^some_url/$', 'some_view', name='some_name'),
    # Пространства имен адресов (namespace:url_name)
    (r'^help/', include('apps.help.urls', namespace='foo', app_name='bar')),
)
# Добавление дополнительных адресов
urlpatterns += patterns('',
	# urld
)

handler404 = 'my.views.view' # Установка обработчика ошибок 404
handler500 = 'my.views.view' # Установка обработчика ошибок 500

from django.core.urlresolvers import reverse
# Возвращает url-адрес. viewname - имя представления или имя адреса
reverse(viewname [, urlconf=None, args=None, kwargs=None, current_app=None])

from django.core.urlresolvers import resolve
# Разрешает путь и возвращает объект ResolverMatch c информацией о разрешенном пути
rm = resolve(path, urlconf=None)
rm.func # Функция, обрабатывающая url
rm.args # Аргументы функции
rm.kwargs # Именованные аргументы функции
rm.url_name # Имя совпадающего паттерна
rm.app_name # Пространство имен приложения паттерна
rm.namespace # Пространство имен паттерна
rm.namespaces # Список индивидуальных компонентов пространств имен
# Альтернативный вариант
func, args, kwargs = resolve(path, urlconf=None)

get_script_prefix() # Возвращает префикс паттернов