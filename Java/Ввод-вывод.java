inputStream.read() // Считывает и возвращает 1 байт. Обнаружив конец потока, метод возвращает -1.
inputStream.read(byte arr[]) // Считывает байты в массив. Максимальное количество ограничивается длиной массива.
inputStream.read(byte arr[], int смещение, int max_count) // Считывает байты в массив. Максимальное количество ограничивается длиной массива.
inputStream.skip(long n) // Пропускает n байтов. Возвращает фактическое количество пропущенных байтов.
inputStream.available() // Возвращает количество доступных байтов.
inputStream.close()
inputStream.mark(int readlimit) // Помещает маркер в текущую позицию. Если из потока было прочитано больше чем readlimit маркер может быть потерян.
inputStream.reset() // Возврат к последнему маркеру.
inputStream.markSupported() // Проверяет, доступна ли установка маркера.
outputStream.write(byte) // Записывает 1 байт в поток.
outputStream.flush() // Выводит буфер.

FileInputStream fis = new FileInputStream({"filename"|new File("filename")}) // Открытие байтового файлового потока
FileOutputStream fos = new FileOutputStream(file[, true/*добавление в конец файла*/]);

System.getProperty("user.dir") // Получает текущую директорию

DataInputStream dis = new DataInputStream(fis)
double s = dis.readDouble() // Читает число из файла

BufferedInputStream bis = new BufferedInputStream(fis[, int n/*размер буфера*/]) // Создает буферизованный поток ввода
BufferedOutputStream bis = new BufferedOutputStream(fis[, int n/*размер буфера*/]) // Создает буферизованный поток вывода
PushbackInputStream pis = new PushbackInputStream(bis) // Создание потока отменяемого ввода
int b = pis.read() // Считывание байта
pis.unread(b) // Возвращение назад

dataInput.readBoolean() // Читает логическое значение
dataInput.readByte() // Читает байт
dataInput.readChar() // Читает 16-битовый символ (Unicode)
dataInput.readDouble() // Читает 64-битовое число
dataInput.readFloat() // Читает 32-битовое число
dataInput.readFully(byte[] b) // Читает байты в массив. Выполнение программы блокируется, пока массив не будет заполнен.
dataInput.readFully(byte[] b, int off, int len) // Читает байты в указанную часть массива
dataInput.readInt() // Читает 32-битовое целое число
dataInput.readLine() // Читает строку
dataInput.readLong() // Читает 64-битовое целое число
dataInput.readShort() // Читает 16-битовое целое число
dataInput.readUTF() // Читает строку в формате UTF
dataInput.skipBytes(int n) // Пропускает байты

dataOutput.writeBoolean()
dataOutput.writeByte()
dataOutput.writeChar()
dataOutput.writeChars()
dataOutput.writeDouble()
dataOutput.writeFloat()
dataOutput.writeInt()
dataOutput.writeLong()
dataOutput.writeShort()
dataOutput.writeUTF()

RandomAccessFile file = new RandomAccessFile("filename", "{r|rw}") // Открывает поток для произвольного доступа к файлу
// Реализует интерфейсы DataOutput и DataInput
file.getFilePointer() // Возвращает текущее значение указателя для файла
file.seek(long pos) // Перемещает указатель
file.length() // Возвращает длину файла, выраженную в байтах

InputStreamReader in = new InputStreamReader(inputStream, "кодировка")

// Преобразование строк Unicode в кодированные байтовые последовательности
String str = ...;
ByteBuffer buffer = charSet.encode(str);
byte[] bytes = buffer.array();
// Для обратного преобразования необходим байтовый буфер
byte[] bytes = ...;
ByteBuffer bbuf = ByteBuffer.wrap(bytes, offset, length);
CharBuffer cbuf = cset.decode(bbuf);
String str = cbuf.toString();

Charset.availableCharsets() // Предоставляет информацию о доступных наборах символов для данной виртуальной машины
// Возвращает объект SortedMap, в котором ключами являются имена наборов символов, а значения - наборами.
Charset.forName("Coding name") // Возвращает набор символов, соответствующий указанному имени
Set charset.aliases() // Возвращает набор псевдонимов для набора символов
ByteBuffer charset.encode("Coding name") // Преобразует указанную строку в байтовую последовательность
ByteBuffer charset.decode(ByteBuffer buffer) // декодирует последовательность символов. Символы, которые невозможно распознать, преобразуются в знак
// замещения (\uFFFD)
byte[] byteBuffer.array() // Возвращает массив байтов, соответствующий буферу.
ByteBuffer.wrap(byte[] bytes)
ByteBuffer.wrap(byte[] bytes, int offset, int lebgth) // Возвращает буфер, соответствующий массиву или его части
charBuffer.array() // Возвращает массив кодовых едениц, управляемый буфером
charBuffer.charAt(index) // Возвращает кодовую единицу с указанным индексом.
charBuffer.toString() // Возвращает строку, состоящую из кодовых единиц, управляемый буфером

printWriter.checkError() // Возвращает true, если обнаружена ошибка форматирования или вывода.

ZipInputStream zin = new ZipInputStream(new FileInputStream("filename"));
ZipEntry ze = zin.getNextEntry()
Scanner scanner = new Scanner(zin);
// Генерируют ZipException

FileOutputStream fout = new FileOutputStream("test.zip");
ZipOutputStream zout = new ZipOutputStream(fout);
для всех файлов
{
    ZipEntry ze = new ZipEntry("filename");
    zout.putNextEntry(ze);
    zout.closeEntry();
}
zipOutputStream.setLevel(int level) // Устанавливает уровень сжатия, принимаемый по умолчанию для последующих элементов DEFLATED (0-9)
zipOutputStream.setMethod(int method) // DEFLATED или STORE

zipEntry.getCrc() // Возвращает контрольную сумму CTC32 для объекта ZipEntry.
zipEntry.getName() // Возвращает имя элемента.
zipEntry.getSize() // Возвращает размер запакованного элемента или -1, если размер неизвестен.
zipEntry.isDirectory() // Возвращает признак того, является ли элемент каталогом.
zipEntry.setMethod(int method)
zipEntry.setSize(long size) // Только для STORED
zipEntry.setCrc(long crc)

new ZipFile(file) // Создает объект ZipFile для чтения
zipFile.entries() // Возвращает объект Enumeration, в котором перечисляются объекты ZipEntry, описывающие элементы массива.
zipFile.getEntry(name) // Возвращает элемент, соответствующий заданному имени, или ссылку null, если ничего не найдено.
zipFile.getInputStream(ZipEntry ze) // Возвращает объект InputStream для заданного элемента
zipFile.getName() // Возвращает путь к данному ZIP-файлу

StringTokenizer tok = new StringTokenizer(string, delimiters)
tok.hasMoreTokens()
tok.nextToken()
tok.countTokens()

//Для классов StringBuilder & StringBuffer
StringBuilder stringBuilder = new StringBuilder(int length)
StringBuilder stringBuilder = new StringBuilder(String str)
sB.length()
sB = sB.append(String str)
sB = sB.appendCodePoint(int cp) // Добавляет кодовую точку, преобразуя ее в одну или две кодовые единицы.
sB.setCharAt(int i, char c)
sB = sB.insert(int offset, String str)
sB = sB.insert(int offset, char c)
sB = sB.delete(int start, int end)
sB.toString()

ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filename"))
out.writeObject(object)
ObjectInputStream in = new ObjectInputStream(new FileInputStream("filename"))
(Class)in.readObject()

File f = new File("filename")
File f = new File("path" + File.separator + "path2", "filename")
File f = new File(dir, "filename")
File dir = new File("dirname")
dir.mkdir()
dir.mkdirs()
dir.list() // 
file.canRead() // Может ли приложение прочитать файл
file.canWrite() // Можно ли записать данные в файл
File.createTempFile(prefix, suffix[, File dir]) // Создает временный файл во временном каталоге, используемом системой по умолчанию, или в каталоге
// указанном пользователем.
file.delete() // Пытается удалить файл. Возвращает true или false.
file.deleteOnExit() // Указывает, что при завершении работы виртуальной машины файл должен быть удален.
file.exists() // Проверяет, существует ли файл
file.getAbsolutePath() // Возвращает абсолютный путь к файлу.
file.getCanonicalPath() // Канонический путь к файлу
file.getCanonicalFile() // Возвращает объект File, содержащий каноническое имя пути к файлу.
file.getName()
file.getParent() // Возвращает имя родительского объекта или null.
file.getParentFile() // Возвращает родительский File.
file.getPath()
file.isDirectory()
file.isFile()
file.isHidden()
long file.lastModified() // Время последней модификации в миллисекундах, прошедших от начала эпохи (12:00,1,01,1970)
file.length() // Длина файла в байтах
String[] file.list([FilenameFilter filter]) // Список дочерних файлов
File[] file.listFiles([FilenameFilter filter])
File.listRoots() // Возвращает массив File, представляющих доступные логические устройства.
file.createNewFile() // Если файл с именем, соответствующим объекту File отсутствует, создает новый файл. Возвращает true или false.
file.renameTo(File new_file_name)
file.setLastModified(time)
file.setReadOnly()
file.toURL()

new FilenameFilter()
{
    public boolean accept(File dir, String name) // Возвращает значение true, если файл соответствует требованиям фильтра
}

java.io.FileInputStream:
FileChannel getChannel() // Возвращает канал доступа к потоку.

java.io.FileOutputStream:
FileChannel getChannel() // Возвращает канал доступа к потоку.

java.io.RandomAccessFile:
FileChannel getChannel() // Возвращает канал доступа к файлу.

java.nio.channels.FileChannel:
MappedByteBuffer map(FileChannel.MapMde mode, long position, long size) // Отображает указанную область файла в память.
// Параметры:
// mode - Одна из констант READ_ONLY, READ_WRITE, PRIVATE
// position - Начало отображаемой области.
// size - Размер отображаемой области.
FileLock lock() // Запрашивает исключительную блокировку всего файла. Метод приостанавливает свою работу до тех пор, пока не будут созданы условия
// для успешного завершения операции.
FileLock tryLock() // Запрашивает исключительную блокировку всего файла. Если файл заблокировать невозможно, возвращает null.
FileLock lock(long position, long size, boolean shared)
FileLock tryLock(long position, long size, boolean shared) // Эти методы запрашивают блокировку части файла. Если файл заблокировать невозможно, первый метод приостанавливает
// свое выполнение, а второй возвращает ссылку null.

java.nio.channels.FileLock:
void release() // разблокирует файл.

java.nio.Buffer:
boolean hasRemaining() // Возвращает значение true, если текущая позиция буфера еще не достигла граничного значения.
int limit() // Возвращает граничную позицию буфера, т.е. позицию, в которой данные ужа недоступны.
Buffer clear() // Подготавливает буфер к записи, устанавливая позицию равной нулю, а границу - равной объему. Возвращает this.
Buffer flip() // Подготавливает буфер к чтению, устанавливая границу равной текущей позиции, а гранизу - равной объему. Возвращает this.
Buffer rewind() // Водготавливает буфер к повторному чтению тех же значений, позиция становится равной нулю, а граница не изменяется.
Buffer mark() // Устанавливает маркер в текущую позицию.
Buffer reset() // Устанавливает позицию равной маркеру, что позволяет повторно читать или записывать данные.
int remaining() // Возвращает число значений, доступных для чтения или записи (разность между границей и позицией).
int position() // Возвращает позицию в буфере.
int capacity() // Возвращает объем буфера.

java.nio.ByteBuffer:
byte get() // Возвращает байт, извлеченный из указанной позиции и перемещает указатель на следующий байт.
byte get(int index) // Возвращает байт, извлеченный из указанной позиции с указанным индексом.
ByteBuffer put(byte b) // Записывает байт в текущую позицию и перемещает указатель на следующий байт. Возвращает ссылку на буфер.
ByteBuffer put(int index, byte b) // Записывает байт в позицию с указанным индексом и перемещает указатель на следующий байт.
ByteBuffer get(byte[] destination)
ByteBuffer get(byte[] destination, int offset, int length) // Заполняет массив или его часть байтами, считанными из буфера, и перемещает
// указатель вперед на число считанных байтов. Если в буфере осталось меньше байтов, чем требуется, то они не считываются и генерируется
// исключение BufferUnderflowException. Возвращает ссылку на буфер.
ByteBuffer put(byte[] source)
ByteBuffer put(byte[] source, int offset, int length) // Записывает все байты из массива или его части в буфер и перемещает указатель вперед
// на число записанных байтов. Если в буфере осталось меньше места, чем требуется, байты не записываются и генерируется исключение
// BufferOverflowException. Возвращает ссылку на буфер.
Xxx getXxx()
Xxx getXxx(int index)
ByteBuffer putXxx(xxx value)
ByteBuffer putXxx(int index, xxx value)
// Эти методы используются для считывания и записи двоичных значений. Символы Xxx означают имена классов Intm Long, Char, Float или Double.
ByteBuffer order(ByteBuffer order)
ByteBuffer order() // задает или определяет порядок записи байтов. Значение параметра order равно одной из констант, BIG_ENDIAN или LITTE_ENDIAN
// , определенных в классе ByteOrder.

java.nio.CharBuffer:
char get()
CharBuffer get(char[] destination)
CharBuffer get(char[] destination, int offset, int length) // Получает из буфера одно или несколько символьных значений, начиная с текущей позиции.
// Позиция сдвигается на количество прочитанных символов.
CharBuffer put(char c)
CharBuffer put(char[] source)
CharBuffer put(char[] source, int offset, int length)
CharBuffer put(String source)
CharBuffer put(CharBuffer source) // Помещает в буфер одно или несколько символьных значений, начиная с текущей позиции. Позиция сдвигается на
// количество записанных символов. Если в качестве параметра указан объект CharBuffer, читаются все оставшиеся символы.
CharBuffer read(CharBuffer destination) // Получает из буфера символные значения и помещает их в объект destination до тех пор, пока не будет
// достигнута граница destination.

Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(input);
if(matcher.matches()) ...

Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE + Pattern.CASE_UNICODE_CASE):
CASE_INSENSITIVE - Сравнение символов без учета регистра.
UNICODE_CASE - В сочетании с флагом CASE_INSENSITIVE задает учет регистра, распознаваемого средствами Unicode.
MULTILINE - Символы ^ и $ оздачают начало и конец строки, но не всей символной последовательности.
UNIX_LIN - Признаком окончания строки считается только символ '\n'.
DOTALL - Если установлен этот флаг, символ . совпадает с любым символом, включая символ конца строки.
CANON_EQ - Уситывает каноническую эквивалентность символов в системе Unicode.

java.util.regex.Pattern:
staticPattern compile(String expression)
staticPattern compile(String expression, int flag) // Компилирует регулярное выражение в объект шаблона. Это позволяет быстро выполять стравнение.
Matcher matcher(CharSequence input) // Возвращает объект класса matcher, который можно использовать для сравнения входной строки с шаблоном.
String[] split(CharSequence input)
String[] split(CharSequence input, int limit) // Разбивает входную строку на лексемы, используя разделители, заданные посредством шаблона.

java.util.regex.Matcher:
boolean matches() // Если входная строка соответствует шаблону, возвращает значение true.
boolean lookingAt() // Если начало входной строки соответствует шаблону, возвращает true.
boolean find()
boolean find(int start) // Пытается найти очередную последовательность символов, соответствующую регулярному выражению, и в случае удачи возвращает
// true.
int start()
int end() // Возвращает индекс начала последовательности символов, соответствующей шаблону, и индекс первого символа, не входящего в последовательность.
String group() // Возвращает текущий фрагмент, соответствующий регулярному выражению.
int groupCount() // Возвращает количество групп в шаблоне.
int start(int groupIndex)
int end(int groupIndex) // Возвращает первый индекс последовательности символов, соответствующей группе, и индекс первого символа, не входящего в 
// последовательность.
String group(int groupIndex) // Возвращает текущее соответствие.
String replaceAll(String replacement)
String replaceFirst(String relpacement) // Возвращает строку, полученную из входной строки путем замены строкой replacement.
Matcher reset()
Matcher reset(CharSequence input) // Обновляет состояние объекта Matcher.