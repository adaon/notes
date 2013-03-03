Socket socket = new Socket("address", port);
InputStream is = socket.getInputStream();
OutputStream os = socket.getOutputStream();

ServerSocket server = new ServerSocket(port)
Socket socket = server.accept()

URL url = new URL("url-address")
Scanner scanner = new Scanner(url.openStream());

URLConnection сonnection = url.openConnection() // получение соединения
connection.setDoInput(true)
connection.setDoOutput(true)
connection.connect() // установка соединения

java.net.URL:
InputStream openStream() // Открывает поток для чтения данных ресурса
URLConnection openConnection() // Возвращает объект URLConnection, который управляет соединением с ресурсом

java.net.URLConnection:
void setDoInput(boolean doInput)
boolean getDoInput() // Если параметр doInput имеет значение true, пользователь может получать данные посредством текущего объекта URLConnection
void setDoOutput(boolean doOutput)
boolean getDoOutput() // Если параметр doOutput имее значение true, пользователь может передавать данные посредством текущего объекта URLConnection
void setIfModifiedSince(long time)
long getIfModifiedSince()
// Свойство ifModifiedSince конфигурирует URLConnection для извлечения только тех данных, которые были изменены после указанного момента времени.
// Время задается в секундах, начиная с полуночи 1 января 1970 года, по Гринвичу
void setUseCached(boolean useCached)
boolean getUseCaches()
// Если значение параметра useCaches равно true, извлечение данных из локального кэша разрешено. Учтите, что объект URLConnection не поддерживает
// кэш. Кэш должен быть предоставлен внешней программой, например, браузером.
void setAllowUserInteraction(boolean allowUserInteraction)
boolean getAllowsUserInteraction() // Если значение параметра равно true, у пользователя может запрашиваться пароль. Учтите, что объект
// URLConnection не обладает никакими средствами выполнения таких запросов. Запрос пароля должен быит организован во внешней программе, например,
// в браузере или подключаемом модуле.
void setConnectionTimeout(int timeout)
int getConnectionTimeout()
// Устанавливает или возвращает значение тайм-аута (в миллисекундах) для соединения. Если время тайм-аута истекло до установления соединения,
// метод read() соответствующего потока ввода генерирует исключение SocketTimeoutException.
void setReadTimeout(int timeout)
int getReadTimeout()
// Устанавливает или возвращает значение такм-аута для чтения данных (в миллисекундах). Если время тайм-аута истекло до успешного выполнения
// операции чтения, метод connect() генерирует исключение SocketTimeoutException.
void setRequestProperty(String key, String value) // Устанавливает значение поля заголовка.
Map<String, List<String>> getRequestProperties() // Возвращает карту, содержащую свойства запроса. Несколько свойств, соответствующих одному ключу,
// помещаются в список.
void connect() // Устанавливает соединение с удаленным ресурсом и получает заголовок ответа.
Map<String, List<String>> Map getHeaderFields() // Возвращает карту, содержащую поля заголовка ответа. Все значение, соотвутствующие одному ключу,
// организуются в виде карты.
String getHeaderFieldKey(int n) // Возвращает ключ n-го заголовка ответа или null, если n меньше или равно 0 либо превышает количество полей.
String getHeaderField(int n) // Возвращает значение n-го поля заголовка ответа или null, если n меньше или равно 0 либо превышает количество полей.
int getContentLength() // Возвращает длину доступного содержимого или -1, если длина неизвестна.
String getContentType() // Возвращает тип содержимого, например text/plain мом image/gif.
String getContentEncoding() // Возвращает тип кодирование содержимого, например gzip. Применяется редко, потому что используемая по умолчанию
// кодировка не всегда указывается в поле Content-Encoding.
long getDate()
long getLastModified()
long getExpiration()
// Возвращает время создания, последней модификации ресурса, либо время, когда срок действия ресурса истекает. Время указывается в миллисекундах, начиная с 1 января 1970 года.
InputStream openInputStream()
OutputStream openOutputStream() // Возвращает поток для чтения ресурса или записи данных.
Object getContent() // Выбирает соответствующий обработчик содержимого для чтения ресурса. Этот метод вряд ли полезен для чтения данных стандартного
// типа, например, text/plain или image/gif, если только разработчику не нужно создать совственный обработчик этих типов.

//Передача данных серверу.
URL url = new URL("http://комрьютер/сценарий");
URLConnection connection = url.openConnection();
connection.setDoOutput(true);
PrintWriter out = new PrintWriter(connection.getOutputStream())
//Теперь можно передавать данные серверу:
out.println(name1 + "=" + URLEncoder.encode(value1, "UTF-8") + "&")
out.println(name2 + "=" + URLEncoder.encode(value2, "UTF-8"))
out.close();

java.net.HttpURLConnection:
InputStream getErrorStream() // Возвращает поток, из которого считываются сообщения Web-сервера об ошибках.

java.net.URLEncoder()L:
static String encode(String s, String encoding) // Возвращает строку s в URL-кодированном виде. Кодирование проводится согласно указанной схеме.
// В URL-кодировке символы A-Z, a-z, 0-9, -, _, и * остаются неизменными. Пробелы представляются в виде символов +, а все остальные символы
// передаются в виде %UV, где UV - шестнатиричное представление байта.

java.net.URLDecoder:
static String decode(String s, String encoding) // Возвращает URL-кодированную строку s в декодированном виде. Декодирование проводится
// согласно указанной схеме.

SocketChannel channel = SocketChannel(new InetSocketAddress(host, port)) // Создание объекта SocketChannel.

java.net.Socket:
Socket() // Создает сокет без соединения.
void connect(SocketAddress address) // Устанавливает посредством сокета соединение с узлом, находящимся по указанному адресу.
void connnect(SocketAddress address, int timeoutInMilliseconds) // Устанавливает посредством сокета соединение с узлом, находящимся по указанному
// адресу, либо по истечении времени тайм-аута возвращает управление.
boolean isConnected() // Возвращает trueб если посредством сокета установлено соединение с узлом.
boolean isClosed() // Возвращает true, если сокет был закрыт.
void setSoTimeout(int timeoutInillisecs) // Устанавливает значение тайм-аута для запросов на чтение, осуществляемых с помощью сокета. По истечении
// времени тайм-аута генерируется исключение InterruptedIOException.
void shutdownOutput() // Закрывает выходной поток.
void shutdownInput() // Закрывает входной поток.
boolean isOutputShutdown()
boolean isInputShutdown()

java.net.InetAddress:
static InetAddress getByBane(String host)
static InetAddress[] getAllByName(String host)
static InetAddress getLocalHost()
byte[] getAddress()
String getHostAddress()
String getHostName()

java.net.InetSocketAddress:
InetSocketAddress(String hostname, int port) // Создает объект адреса для указанного узла и порта. Преобразование имени узла осуществляется в
// процессе установления соединения. Если преобразовать имя в адрес не удалось, устанавливается значение true свойства unresolved,

java.nio.chennels.SocketChannel:
static SocketChannel open(SocketAddress address) // Открывает канал сокета и связывает с удаленным узлом.

java.nio.channels.Channels:
static InputStream newInputStream(ReadableByteChannel channel) // Создает входной поток, поддерживающий чтение из указанного канала.
static OutputStream newOutputStream(WritableByteChannel channel) // Создает входной поток, поддерживающий запись в указанного канала.