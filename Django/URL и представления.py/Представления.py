return HttpResponse(status=201) # Возвращение кода ошибки

# По умолчанию исключение обрабатывается представлением django.views.defaults.page_not_found, которое использует шаблон 404.html
from django.http import Http404
raise Http404

# Указание собственного обработчика исключений 404
# root/urls.py
handler404 = 'my.views.my_404'

# По умолчанию внутренняя ошибка обрабатывается представлением django.views.defaults.server_error, которое згружает шаблон 500.html

# Указание собственного обработчика 500
handler500 = 'my.views.my_500'

# Декораторы ====================
from django.views.decorators.http import *
@require_http_methods(request_method_list)
@require_GET()
@require_POST()

from django.views.decorators.gzip import *
@gzip_page() # Данный декоратор сжимает содержимое, если браузер поддерживает сжатие.