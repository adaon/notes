from django.core.paginator import Paginator

objects = [1, 2, 3, 4]

p = Paginator(objects, 2[, orphans=0, allow_empty_first_page=True]) # Создание объекта-паджинатора. orphans - число элементов, допускаемых к увеличению последней страницы (чтобы на последней странице не было слишком много элементов). allow... - допускается ли первая страница пустой. Если False, при отсутствии элементов будет возбуждено исключение EmptyPage

p.count # Общее количество элементов
p.num_pages # Количество страниц
p.pahe_range # Список страниц (например, [1, 2])

page1 = p.page(1) # Получение объекта страницы

page1.objects_list # Получение списка объектов страницы
page1.number # Номер страницы (начиная с нуля)
page1.paginator # Ассоциированный объект паджинатора
page1.has_next() # Есть ли следующая страница
page1.has_previous() # Есть ли предыдущая страница
page1.has_other_pages() # Есть ли другие страницы
page1.next_page_number() # Номер следующей страницы
page1.previous_page_number() # Номер предыдущей страницы
page1.start_index() # Индекс первого элемента страницы (начиная с 1)
page1.end_index() # Идекс последнего элемента страницы (начиная с 1)

# Базовый класс для исключений некорректной страницы
InvalidPage
# Возбуждается, если параметр функции page() - не число
PageNotAnInteger
# Возбуждается, когда страница пустая
EmptyPage

# Пример использования в представлении
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger

def listing(request):
    contact_list = Contacts.objects.all()
    paginator = Paginator(contact_list, 25) # Show 25 contacts per page

    page = request.GET.get('page')
    try:
        contacts = paginator.page(page)
    except PageNotAnInteger:
        # If page is not an integer, deliver first page.
        contacts = paginator.page(1)
    except EmptyPage:
        # If page is out of range (e.g. 9999), deliver last page of results.
        contacts = paginator.page(paginator.num_pages)

    return render_to_response('list.html', {"contacts": contacts})