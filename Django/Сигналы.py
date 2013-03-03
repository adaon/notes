# Возникают при вызове метода save()
django.db.models.signals.pre_save
django.db.models.signals.post_save
# Возникабт при вызове метода delete()
django.db.models.signals.pre_delete
django.db.models.signals.post_delete
# Возникает при изменении поля модели ManyToManyField
django.db.models.signals.m2m_changed
# Возникают при HTTP запросе
django.core.signals.request_started
django.core.signals.request_finished
# Возникает при удачном входе пользователя
# Аргументы: sender, request, user
django.contrib.auth.signals.user_logged_in
# Возникает при успешном выходе пользователя
# Аргументы: sender, request, user
django.contrib.auth.signals.user_logged_out()

# Соединение сигнала
Signal.connect(
    receiver, # Обратная функция, которая соединяется с данным сигналом
    sender=None, # Определяет отправителя сигнала
    weak=True, # По умолчанию сигналы связываются как слабые ссылки (т.е., могут быть удалены сборщиком мусора). Чтобы предотвратить это, нужно указать weak=False
    dispatch_uid=None # Уникальный идентификатор для получателя сигнала в случаях, когда обработчик может быть зарегистрирован много раз
)

# Функция-получатель сигнала
def my_callback(sender, **kwargs):
    print "Request finished!"
# Соединение сигнала с получателем
from django.core.signals import request_finished
request_finished.connect(my_callback)
# Альтернативный способ соединения сигнала с получателем
from django.core.signals import requst_finished
from django.dispatch import receiver
@received(request_finished)
def my_callback(sender, **kwargs):
    print "Request finished!"
    
# Регистрация сигнала для конкретного источника события
from django.db.models.signals import pre_save
from django.dispatch import receiver
from myapp.models import MyModel

@receiver(pre_save, sender=MyModel) # Сигнал будет отправляться только когда источником будет экземпляр MyModel
def my_handler(sender, **kwargs):
    ...
    
# Определение своего сигнала
from django.dispatch import Signal
# providing_args - список имен аргументов, которые сигнал будет предоставлять обработчикам
my_signal = Signal(providing_args=["arg1", "arg2"])
# Отправка сигнала. Возвращают список кортежей (receiver, response)
my_signal.send(sender=self, arg1=..., arg2=...)
my_signal.send_robust(sender=self, arg1=..., arg2=...) # Отправляет сигнал и заботится о том, чтобы все исключения были обработаны обработчиками
# Отсоединение сигнала
my_signal.disconnect([receiver=None, sender=None, weak=True, dispatch_uid=None])