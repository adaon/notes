# ПОЛЬЗОВАТЕЛИ =================================================

# Для активации системы пользователей следующие строки должны быть включены в INSTALLED_APPS:
django.contrib.auth
django.contrib.contenttypes

# models.User
user.username
user.first_name
user.last_name
user.email
user.password
user.is_staff
user.is_active
user.is_superuser
user.last_login
user.date_joined

user.is_anonymous()
user.is_authenticated()
user.get_full_name()
user.set_password(password)
user.check_password(password)
user.set_unusable_password() # Установка пользователя как неимеющего пароль
user.has_unable_password() # Имеет ли пользователь пароль
user.get_group_permissions([obj]) # Возвращает набор разрешений, которые имеет пользователь из групп.
user.get_all_permissions([obj]) # Возврашает набор всех разрешений, которые имеет пользователь
user.has_perm(perm[, obj]) # Имеет ли пользователь данное разрешение (<app_name>.<permission_name>). Если пользователь неактивен, всегда возвращает False
user.has_perms(perm_list[, obj]) # Имеет ли пользователь все указанные разрешения
user.has_module_perms(package_name) # Возвращает True, если пользователь имеет любое разрешение в данном пакете
user.get_and_delete_messages() # Возвращает список Message и удаляет их из очереди
user.email_user(subject, message, [from_email]) # Отправляет e-mail пользователю. Если from_email не указано, используется DEFAULT_FROM_EMAIL
user.get_profile() # Возвращает профиль пользователя. Возбуждает django.contrib.auth.models.SiteProfileNotAvailable если текущий сайт не определяет профили

# models.UserManager
user.objects.create_user(username, email, password=None) # Создает, созраняет и возвращает User.
user.make_random_password(length=10, allowed_chars='...') # Возвращает случайный пароль с заданной длиной и набором символов.

manage.py changepassword *username* # Изменение пароля пользователя из консоли

manage.py createsuperuser --username=teu --email=teu@nm.ru # Создание суперпользователя из консоли

# Хранение дополнительной информации и пользователях
# models.py
class Profile(models.Model):
    user = models.OneToOneField(User)
    ...
# settings.py
AUTH_PROFILE_MODULE = 'common.Profile'


# АУТЕНТИФИКАЦИЯ ===============================================
# Для активации системы аутентификации следующие строки должны быть включены в MIDDLEWARE_CLASSES:
SessionMiddleware
AuthenticationMiddleware

# Логин
from django.contrib.auth import authenticate, login, logout
user = authenticate(username='teu', password='charmed') # Проверяет логин и пароль и возвращает пользователя или None
login(request, login) # Совершает вход (записывает пользователя в сессию)
logout(request) # Выход пользователя

# Защита доступа
from django.contrib.auth.decorators import login_required
# Если пользователь не вошел, перенаправляет на страницу settings.LOGIN_URL с параметром next=текущий_адрес
@login_required#(redirect_field_name='my_field_name', login_url='som_url')
def some_view(request):
    ...
    
# urls.py
from django.contrib.auth.views import login, logout, logout_then_login, password_change

# Если GET, отображает форму входа. Если POST, пытается совершить вход. Если успешно, перенаправляет на next. Если next не указано, перенаправлет на settings.LOGIN_REDIRECT_URL. Если не успешно, отображает форму входа заново.
(r'^login/$', login, {'template_name':'registration/login.html', 'redirect_field_name':'next', 'authentication_form':...}),
    # При отображении шаблона он получает 4 контекстных переменных:
    form # Объект формы, представляющий форму входа
    next # Адрес перенаправления успешного входа
    site # Текущий сайт
    site_name # Псевдоним для site.name

# Совершает выход и отображает шаблон, в который передается переменная title, содержащая локализованный текст "Logged out"
(r'^logout/$', logout, {'next_page':'...', 'template_name':'...', 'redirect_field_name':'...'})
# Совершает выход, затем перенаправляет на страницу входа
(r'^some/$', logout_then_login, {'login_url', '...'}),
# Изменяет пароль пользователя. Контекст содержит переменную form
(r'^some/$', password_change, {'template_name':'...', 'post_change_redirect':'...', 'password_change_form':...})
# Страница, которая показывается после изменения пароля
password_change_done(request[, template_name])
# Позволяет пользователю сбросить пароль с помощью генерации одноразовой ссылки для сброса, которая посылается пользователю по e-mail
password_reset(request[, is_admin_site, template_name, email_template_name, password_reset_form, token_generator, post_reset_redirect, from_email])
    template_name # Полное имя шаблона, который используется для отображения формы сброса (registration/password_reset_form.html)
    email_template_name # Полное имя шаблона, который используется для генерации e-mail с новым паролем (registration/password_reset_email.html).
    password_reset_form # Форма для установки пароля
    token_generator # Экземпляр класса для проверки пароля
    post_reset_redirect # Адрес перенаправления успешной смены пароля
# Страница, показываемая после успешного сброса пароля
password_reset_done(request[, template_name])
# Представлет форму для сброса пароля
password_reset_confirm(request[, uidb36, token, template_name, token_generator, set_password_form, post_reset_redirect])
    uidb36 # Id пользователя, закодированный в base 36
    token # Токен для проверки правильности пароля
    template_name # Полное имя шаблона для отображения подтверждения пароля (registration/password_reset_confirm.html)
    token_generator
    set_password_form # Форма для установки пароля
    post_reset_redirect
    password_reset_complete(request[, template_name])
# Перенаправляет на страницу входа
redirect_to_login(next[, login_url, redirect_field_name])

# Встроенные формы:
from django.contrib.auth.forms
AdminPasswordChangeForm # Форма, используемая в интерфейсе администрирования для изменения пароля
AuthenticationForm # Форма для совершения входа
PasswordChangeForm # Форма для изменения пароля
PasswordResetForm # Форма для генерации и отсылки по e-mail
SetPasswordForm # Форма для изменения пароля без указания старого
UserChangeForm # Форма, используемая в административном интерфейсе для измения пользователя и разрешений
UserCreationForm # Форма для создания пользователя

### Данные пользователей в шаблонах ###

# Текущие данные пользователя становятся доступны из шаблонов при использовании RequestContext
{{user}} # В данной шаблонной переменной содержится объект текущего пользователя
{{perms}} # Объект разрешений
{{perms.shop.can_vote}} # Возвращает True или False, в зависимости от разрешения can_vote приложения shop