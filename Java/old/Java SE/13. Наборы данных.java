java.awt.EventQueue:
static void invokeLater(Runnable runnable) // Запускает метод run() объекта Runnable в потоке управления событиями после обработки всех событий в
// очереди.
static void invokeAndWait(Runnable runnable) // Запускает метод run объекта runnable в потоке управления событиями после обработки всех событий
// в очереди. Вызов блокируется до тех пор, пока не завершиться выполнение метода run.

java.util.Collection<E>:
Iterator<E> iterator() // Возвращает итератор, используемый для обращения к элементам набора данных.
int size() // Возвращет текущее количество элементов в наборе данных.
boolean isEmpty() // Возвращает значение truem если набор данных не содержить элементов.
boolean contains(Object obj) // Возвращает значение true, если набор данных содержить объект, эквивалентный obj.
boolean containsAll(Collection<?> other) // Возвращает значение true, если текущий набор данных содержить все элементы набора данных other.
boolean add(Object element) // Добавляет элемент в набор данных. Возвращает true, если набор изменился.
boolean addAll(Collection<? extends E> other) //Добавляет все элементы в набор данных.
boolean remove(Object obj) // Удаляет объект.
boolean removeAll(Collection<?> other)
void clear()
boolean retainAll(Collection<?> other) // Удаляет из данного набора данных элементы, не совпадающие с теми, которые содержатся в наборе other.
// Возвращает значение true, если набор данных изменился.
Object[] toArray()

java.util.Iterator<E>:
boolean hasNext()
Object next() // Возвращает следующий объект. Генерирует исключение NoSuchElementException, если достигнут конец набора.
void remove() // Удаляет последний прочитанный элемент.

Наборы данных из библиотеки Java:
ArrayList           Индексированная последовательность, резмеры которой могут динамически увеличиваться или уменьшаться.
LinkedList          Упорядоченная последовательность, обеспечивающая эффективное выполнение операций включения или удаления элемента в любой позиции.
HashSet             Неупорядоченный набор, не допускающий дублирования элементов.
TreeSet             Сортированное множество.
EnumSet             Набор значений нумерованного типа.
LinkedHashSet       Множество, которое помнит порядок, в котором элементы были включены в него.
PriorityQueue       Набор, обеспечивающий эффективное удаления наименьшего элемента.
HashMap             Карта, которая хранит связи ключ/значение.
TreeMap             Карта, в которой ключи сортированы.
EnumMap             Карта, в которой ключи принадлежат нумерованному типу.
LinkedHashMap       Карта, которая помнит порядок включения элементов.
WeakHashMap         Карта, неиспользуемые значения которой могут быть обработаны системой сборки мусора.
IdentityHashMap Карта, для сравнения ключей которой может быть использована операция =.