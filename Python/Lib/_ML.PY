from xml.dom import minidom
root = minidom.parse('filename_or_file'[, parser]) # Производить парсинг файла и возвращает корневой узел
root = minidom.parseString(xmlString, [parser])

from xml.etree.ElementTree import ElementTree
doc = ElementTree(file='yml_all.xml')
shop = doc.find('shop')
offers = shop.find('offers')
for item in offers.findall('offer'):
	if item.get('id') == '1202996':
		offer = item
pic = offer.find('picture')
pic.text
