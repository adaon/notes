# Создание middleware
class MyMiddleware:
    # Данный метод вызывается при каждом запросе, перед тем как django решит какую функцию вызывать
    def process_request(self, request):
        # Данный метод должен вернуть None или объект HttpRespobse. Если будет возвращено None, django продолжит цепочку вызовов. Если же вернется HttpResponse-объект, будет сразу же возвращен данный объект.

    # Данный метод вызывается сразу перед вызовом представления.
    def process_view(self, request, view_func, view_args, view_kwargs):
        # Данный метод должен вернуть None или объект HttpRespobse. Если будет возвращено None, django продолжит цепочку вызовов. Если же вернется HttpResponse-объект, будет сразу же возвращен данный объект.

    # Данный метод ВСЕГДА вызывается перед возвратом значения
    def process_response(self, request, response):
        # Должен вернуть HttpResponse-объект.

    # Вызывается при возникновении исключения в отображении.
    def process_exception(self, request, exception):
        # Должен вернуть None или HttpResponse-объект. Если возвращается None, исключение будет обработано по умолчанию, иначе результат возвращается пользователю.

    def __init__(self):
        raise django.core.exceptions.MiddlewareNotUsed # Отмена использования класса