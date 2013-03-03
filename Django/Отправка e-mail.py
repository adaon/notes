from django.core.mail import *

# settings.py
EMAIL_HOST # Хост SMTP
EMAIL_PORT # Порт SMTP
EMAIL_HOST_USER # Имя пользователя хоста
EMAIL_HOST_PASSWORD # Пароль хоста
EMAIL_USE_TLS # Использовать защищенное соединение
DEFAULT_CHARSET # Кодировка по умолчанию
EMAIL_SUBJECT_PREFIX # Префикс тем сообщений, посылаемых администраторам ([Django])
SERVER_EMAIL # Адрес "от" сообщений, посылаемых администраторам

send_mail(
    subject, # Строка
    message, # Строка
    from_email, # Строка
    recipient_list, # Список строк-адресов получателей
    fail_silently=False, # Если False, будет возбуждать исключение при smtplib.SMTPException при неудачной отправке сообщения
    auth_user=None, # Имя для аутетентификации SMTP
    auth_password=None, # Пароль для аутентификации SMTP
    connection=None # Соединение
)

# Массовая отправка e-mail
send_mass_mail(
    datatuple, # Кортеж, каждый элемент которого вида (subject, message, from_email, recipient_list)
    fail_silently=False,
    auth_user=None,
    auth_password=None,
    connection=None
)

# Посылает e-mail администраторам сайта
mail_admins(
    subject,
    message,
    fail_silently=False,
    connection=None,
    html_message=None
)

# Посылает e-mail менеджерам
mail_managers(
    subject,
    message,
    fail_silently=False,
    connection=None,
    html_message=None
)

django.core.mail.BadHeaderError # Возбуждается при неверных заголовках (например, при инъекциях)

# Класс EmailMessage
email = EmailMessage(
    subject, # Тема
    body, # Тело сообщения
    from_email, # Адрес отправителя
    to, # Список или кортеж адресов получателей
    bcc, # Список или кортеж адресов, используемых в поле заголовка "Bcc
    connection, # Соединение
    attachments, # Список вложений. Могут быть экземплярами email.MIMEBase.MIMEBase или кортежами (filename, content, mimetype)
    headers, # Словарь экстра заголовков
    cc # Список или кортеж адресов, используемых в заголовке "Cc"
)
email.content_subtype = 'html' # Переопределение типа
# Отправляет сообщение. 
email.send(file_silently=False)
# Конструирует объект django.core.mail.SafeMIMEText или django.core.mail.SafeMIMEMultipart, содержащий сообщение.
email.message()
# Возвращает список получателей сообщения, указанных в аргументах to и bcc.
email.recipients()
# Создает новый прикрепленный файл
email.attach(obj) # Принимает объект email.MIMEBase.MIMEBase
email.attach('design.png', img_data, 'image/png') # Принимает имя файла, контент и mime-тип.
# Создает новое вложение, используя внещний файл
email.attach_file('filename.ext')

# Отправка альтернативных типов содержимого
from django.core.mail import EmailMultiAlternatives
subject, from_email, to = 'hello', 'from@example.com', 'to@example.com'
text_content = 'This is an important message.'
html_content = '<p>This is an <strong>important</strong> message.</p>'
msg = EmailMultiAlternatives(subject, text_content, from_email, [to])
msg.attach_alternative(html_content, "text/html")
msg.send()

# Запуск тестового email-сервера, который будет получать все сообщения, но ничего не отправлять
python -m smtpd -n -c DebuggingServer localhost:1025