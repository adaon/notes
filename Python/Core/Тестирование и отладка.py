# Отыскивает в модуле строки документирования, выполняет интерактивные примеры из них и проверяет результаты
import splitter
import doctest

nfail, ntests = doctest.testmod(splitter)

# Модульное тестирование
# testsplitter.py
import splitter
import unittest

class TestSplitFunction(unittest.TestCase):
	# Начальные действия
	def setUp(self):
		pass
	# Конечные действия
	def tearDown(self):
		pass
	# Имена отдельных тестов должны начинаться со слова 'test'
	def testsimplestring(self):
		r = splitter.split('GOOG 100 490.50')
		self.assertEqual(r,['GOOG','100','490.50'])
	def testtypeconvert(self):
		r = splitter.split('GOOG 100 490.50',[str, int, float])
		self.assertEqual(r,['GOOG', 100, 490.5])
	def testdelimiter(self):
		r = splitter.split('GOOG,100,490.50',delimiter=',')
		self.assertEqual(r,['GOOG','100','490.50'])
if __name__ == '__main__':
	unittest.main()
		
# Методы self:
setUp() # Вызывается для выполнения настроек, перед вызовом любых методов тестирования
tearDown() # Вызывается для выполнения заключительных действий после выполнения всех тестов
assert_(expr[, msg]) # 
failUnless(expr[, msg]) # Сообщает об ошибке тестирования, если выражение expr оценивается как False.
assertEqual(x, y[, msg]) # 
failUnlessEqual(x, y[, msg]) # Сообщает об ошибке тестирования, если x и y не равны.
assertNotEqual(x, y[, msg]) # 
failIfEqual(x, y[, msg]) # Сообщает об ошибке тестирования, если x и y равны
assertAlmostEqual(x, y[, places][, msg]) # 
failUnlessAlmostEqual(x, y[, places][, msg]) # Сообщает об ошибке тестирования, если числа x и y не совпадают с точностью до знака places после дес. точки.
assertRaises(exc, callable, ...) # 
failUnlessRaises(exc, callable, ...) # Сообщает об ошибке тестирования, если вызываемый объект callable не возбуждает исключение exc.
failIf(expr[, msg]) # Сообщает об ошибке тектирования, если выражение expr оценивается как True
fail([msg]) # Сообщает об ошибке тестирования
failureException # В этом атрибуте сохраняется последнее исключение, перехваченное в тесте.