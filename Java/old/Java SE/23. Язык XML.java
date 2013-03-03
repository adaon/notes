javax.xml.parsers.DocumentBuilderFactory:
static DocumentBuilderFactory newInstance() // Возвращает экземпляр класса DocumentBuilderFactory.
DocumentBuilder newDocumentBuilder() // Возвращает экземпляр класса DocumentBuilder.
boolean isValidating()
void setValidating(boolean value)
// Возвращает или устанавливает признак проверки для фабрики. Значение true указывает на то, что созданные фабрикой анализаторы будут
// выполнять проверку входных данных.
boolean isIgnoringElementContentWhitespace()
void setIgnoringElementContentWhitespace(boolean value) // Возврашщает или устанавливает значение, определяющее. следует ли игнорировать разделители между элементами.

javax.sml.parsers.DocumentBuilder:
Document parse(File f)
Document parse(String url)
Document parse(InputStream in)
// Выполняет разбор XML-документа.
void setEntityResolver(EntityResolver resolver) // Устанавливает определитель примитивов, которые упоминаются в анализируемых XML-документах.
void setErrorHandler(ErrorHandler handler) // Устанавливает обработчик исключений для выдачи предупреждений и сообщений об ошибках, возникающих
// при разборе документа.

org.w3c.dom.Document:
Element getDocumentElement() // Возвращает корневой элемент документа.

org.w3.dom.Element:
String getTagName() // Возвращает имя элемента.
String getAttribute(String name) // Возвращает значение атрибута с заданным именет либо пустую строку, если такого атрибута нет.

org.w3c.dom.Node:
NodeList getChildNodes() // Возвращает список, который содержит все узлы, дочерние по отношению к данному.
Node getFirstChild()
Node getLastChild()
// Возварщает первый или последний узел из числа дочерних по отношению к данному. Если данный узел не имеет дочерних, возвращает null.
Node getNextSibling()
Node getPreviousSibling()
// Возвращает предыдущий узел того же уровня. Если для данного узла нет равноправных узлов, возвращается значение null.
Node getParentNode() // Возвращает узел, родительский по отношению к данному, либо значение null, если данный узер является корневым.
NamedNodeMap getAttributes() // Возвращает карту, которая содержить узлы типа Attr с описаниями всех атрибутов данного узла
String getNodeName() // Возвращает имя данного узла. Если узел имеет тип Atr, то возвращается имя атрибута.
String getNodeValue() // Возвращает значение данного узла. Если узел имеет тип Attr, то возвращается значение атрибута.

org.w3c.dom.CharacterData:
String getData() // Возвращает строку, которая хранится в данном узле.

org.w3c.dom.NodeList:
int getLength() // Возвращает количество узлов вданном списке.
Node item(int index) // Возвращает узел с заданным индексом.

org.w3c.dom.NamedNodeMap:
int getLength() // Возвращает количество узлов в данной карте.
Node item(int index) // Возвращает узел с заданным индексом.

org.sml.sax.EntityResolver:
public InputSource resolveEntity(String public ID, String systemID) // Возвращает источник входной информации, который содержит данные,
// определяемые заданными идентификаторами, или значение null, указывающее на то, что этот определитель не знает, как обработать данное имя.
// Параметр publicID может иметь значение null, если нет общедоступных идентификаторов.

org.sml.sax.InputSource:
InputSource(InputStream in)
InputSource(Reader in)
InputSource(String systemID)
// Создает источник входных данных на основании указанного потока, объекта Reader или системного идентификатора (обычто это URL).

org.xml.sax.ErrorHandler:
void fatalError(SAXParseException exception)
void error(SAXParseException exception)
void warning(SAXParseException exception)
// Данные методы нужно переопределить для создания собственного обработчика неустранимых ошибок, устанимых ошибок или предупреждений.

org.xml.sax.SAXParseException:
int getLineNumber()
int getColumnNumber()
// Возвращает номер строки или столбца в конце данных из входного потока, при обработке которых возникло иключением.