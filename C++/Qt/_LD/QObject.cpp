/* Задание свойства для объекта-наследника QObject
Q_PROPERTY(type name
	READ getFunction
	[WRITE setFunction]
	[RESET resetFunction]
	[DESIGNABLE bool]
	[SCRIPTABLE bool]
	[STORED bool]
)
obj->setProperty("readOnly", true) // Установка свойства;
bool readOnly = obj->property("readOnly").toBool(); // Получение свойства
*/
class MyClass : public QObject {
	Q_OBJECT
	Q_PROPERTY(bool readOnly READ isReadOnly WRITE setReadOnly)
private:
	bool m_bReadOnly;
public:
	MyClass(QObject* obj = 0) : QObject(obj), m_bReadOnly(false) {}
public:
	void setReadOnly(bool bReadOnly) {
		m_bReadOnly = bReadOnly;
	}
	bool isReadOnly() const {
		return m_bReadOnly;
	}
};