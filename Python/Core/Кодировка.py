sys.getdefaultencoding() # Получение кодировки по умолчанию

'Привет! Как дела?'.decode('utf-8'[, errors])
'dsgdgsdgsd'.encode('ascii'[, errors])

# Параметр errors:
strict				# В случае появления ошибки кодирования и декодирования возбуждается исключение UnicodeError. По умолчанию.
ignore				# Недопустимые символы игнорируются
replace				# Замещает недопустимые символы символом замены
backslashreplace	# Замещает недопустимые символы соответствующими им экранированными последовательностями, принятыми в языке
xmlcharrefreplace	# Замещает недопустимые символы ссылками в формате XML

# Кодировки
'ascii'
'latin-1'
'cp1252'
'utf-8'
'utf-16'

'utf-16-le'
'utf-16-be'

'unicode-escape'
'raw-unicode-escape'