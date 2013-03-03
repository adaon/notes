setup.py bdist_wininst # Создание исполняемого дистрибутива

cxfreeze hello.py --target-dir dist # Компиляция вместе с библиотекой python

# setup.py
from distutils.core import setup
setup(name = "spam",
	  version = "1.0",
	  py_modules = ["libspam"], # Отдельные модули
	  packages = ["spampkg"], # Пакеты
	  scripts = ["runspam.py"], # Выполняемые сценарии
)

# Дополнительные опции (строки):
name				# Имя пакета (обязательный)
version				# Номер версии (обязательный)
author				# Имя автора
author_email		# Адрес автора
maintainer			# Имя сопровождающего
maintainer_email	# Адрес сопровождающего
url					# URL
description			# Краткое описание
long_description	# Полное описание
download_url		# Адрес загрузки
classifiers			# Список строк классификаторов