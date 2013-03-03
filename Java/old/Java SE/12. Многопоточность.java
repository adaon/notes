thread.interrupt() // Устанавливает для потока флаг прерывания
//Когда метод interrupt вызывается для заблокированного потока, генерируется исключение InterrupredException

Thread.currentThread().isInterrupted() // Проверяет флаг прерывания
Thread.interrupted() // Проверяет флаг прерывания текущего потока и сбрасывает флаг прерывания

//Поток может находиться в одном из четырех состояний: new, runnable, blocked, dead

thread.isAlive() // Возвращает true, если поток запущен или блокирован, и false, если поток новый или мертвый.

thread.join() // Ожидает завершения потока
thread.join(millis) // Ожидает завершение потока либо истечения указанного времени

// Возможный приоритет потоков находится от MIN_PRIORITY (1 Thread) до MAX_PRIORITY (10 Thread).
// Обычный приоритет - NORM_PRIORITY (5 Thread).
thread.setPriority(prior) // Устанавливает приоритет потока

Thread.yield() // Принудительно отнимает управление у текущего потока

thread.setDaemon(true) // Превращает поток в демона

ThreadGroup group = new ThreadGroup("groupName") // Создает группу потоков
ThreadGroup group = new ThreadGroup(parentGroup, "groupName") // Создает группу в родительской группе
Thread t = new Thread(group, threadName);
group.activeCount() // Возвращает число активных потоков
group.interrupt() // Прерывает все потоки из группы
thread.getThreadGroup() // Возвращает группу потока
group.enumerate() // Возвращает массив Thread, принадлежащих группе
group.getParent() // Возвращает родительскую группу

// Устанавливает или возвращает обработчик неперехваченных исключений по умолчанию
Thread.setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler handler)
Thread.getDefaultUncaughtExceptionHandler()
// Устанавливает или возвращает обработчик неперехваченных исключений
thread.setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler handler)
thread.getUncaughtExceptionHandler()
uncaughtExceptionHandler.uncaughtException(Thread t, Throwable e) // Переопределяет метод
// для обработки неперехваченного исключения
threadGroup.uncaughtException(Thread t, Throwable e) // Вызывает аналогичный метод родительской группы,
// если она существует, либо вызывает обработчик по умолчанию класса Thread, если данный обработчик существует.
// В противном случае вывполит трассировку.

class MyClass
{
	Lock myLock = ReentrantLock();// Создание объекта блокировки для родительского объекта.
	Lock myLock = ReentrantLock(true); // Справедливая блокировка
}
myLock.lock() // Блокировка объекта
myLock.tryLock() // Пытается получить блокировку, не приостанавливая выполнение потока.
myLock.tryLock(long time, TimeUnit unit) // Пытается получить блокировку. В случае приостановки выполнения потока
// это происходит на время, не превышающее указанное значение тайм-аута.
myLock.lockInterruptibly() // Запрашивает блокировку, приостанавливая при необходимости выполнение потока на
// неопределенный отрезок времени.
myLock.unLock() // Разблокировка объекта
Condition cond = myLock.newCondition() // Создание объекта условия
cond.await() // Ждет, пока условие будет выполнено
cond.await(long time, TimeUnit unit) // Добавляет поток к множеству ожидания для данного условия.
// Выполнение потока приостанавливается до тех пор, пока он не будет удален из множества ожидания,
// либо до истечения указанного отрезка времени.
cond.awaitInterruptibly() // до тех пор, пока он не будет удален из множества ожидания.
cond.signalAll() // Условие выполнено. В результате, все потоки, ожидающие выполнения этого условия возобновляются.
cond.signal() // Возобновляет только один ожидающий поток
while(!условие) // Использование на практике
{
	cond.await();
}

object.notifyAll() // Разблокирует потоки, вызвавшие метод wait() для данного объекта
object.notify() // Разблокирует один поток
object.wait() // Переводит поток в режим ожидания
object.wait(millis)
object.wait(millis, nanos) // Переводит поток в режим ожидания до получения уведомления либодо истечения указанного интервала времени

synchronized (obj)
{
	// Синхронизированный блок
}

public volatile boolean isRead; // Объявление переменной класса, которая будет синхронизированной

ReentrantReadWriteLock = new ReentrantReadWriteLock(); // Блокировка чтения-записи
Lock readLock = lock.readLock() // Получение объекта блокировки чтения
Lock writeLock = lock.writeLock() // Получение объекта блокировки записи

ArrayBlockingQueue queue = new ArrayBlockingQueue(int capacity)
ArrayBlockingQueue queue = new ArrayBlockingQueue(int capacity, boolean fair) // Создает блокирующую очередь
// с заданынм объемом. При необходимости позволяет запросить справедливую блокировку.
LinkedBlockingQueue queue = new LinkedBlockingQueue()
LinkedBlockingQueue queue = new LinkedBlockingQueue(int capacity)
// Создает блокирующую очередь, реализованную как связный список.
DelayQueue queue = new DelayQueue() // Создает блокирующую очередь неограниченного оюъекма, состоящую
// из элементов Delayed. Из очереди могут быть удалены только те элементы, для которых время истекло.
delayed.getDelay(TimeUnit unit) // Возвращает задержку для текущего объекта

blockingQueue.put(element) // Добавляет элемент. При необходимости блокирует выполнение.
blockingQueue.offer(element) // Добавляет указанный элемент. Возвращает true или false.
blockingQueue.offer(element, time, TimeUnit unit) // Блокирует выполнение до успешного добавления или истечения.
blockingQueue.take() // Удаляет элемент из головы очереди и возвращает его. При необходимости осуществляеься блокировка.
blockingQueue.poll(time, TimeUnit unit) // Удаляет и возвращает элемент из головы очереди. Блокирует до успешного
// выполнения или истечения.
queue.poll() // удаляет элемент из головы очереди и возвращает его или null.
queue.peek() // возвращает элемент из головы очереди или null.

ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue<E>() // Создает неблокирующую очередь неограниченного
// объема, к которой можно осуществить безопасное обращение из нескольких потоков.
ConcurrentHashMap map = new ConcurrentHashMap<K, V>()
ConcurrentHashMap map = new ConcurrentHashMap<K, V>(int initialCapacity)
ConcurrentHashMap map = new ConcurrentHashMap<K, V>(int initialCapacity, float loadFactor, int concurrencyLevel)
// Создает hash-таблицу, к которой можно осуществить бехопасное обращение из нескольких потоков.
// initialCapacity - начальный объем. По умолчанию - 16.
// loadFactor - управляет изменением размера. Если загрузка превышает значение, размер увеличивается.
// concurrencyLevel - приблизительное число одновременно обращающихся записывающих потоков.
map.putIsAbsent(K key, V value) // Если ключ отсутствует, метод связывает значение с ключом и возвращает
// null. В противном случае возвращает значение, связанное с существующим ключом.
map.remove(K key, V value) // Если ключ уже связан с указанным значением, метод удаляет ключ и значение и
// возвращает true. В противном случае возвращает false.
map.replace(K key, V oldValue, V newValue) / Если указанный ключ связан с oldValue, он связывается с newValue
// В противном случае возвращается значение false.

new Callable<V>
{
	public V call()
	{}
}
new Future<V>()
{
	public V get(){}
	public V get(long time, TimeUnit unit){}
	// Предоставляет результат, причем выполнение блокируется до его готовности или до истечения.
	boolean cancel(boolean mayInterrupt){}
	// Пытается отменить выполнение задачи. Если задача уже запущена и значение параметра mayInterrupt равно
	// true, она прерывается. Если отмена задачи произошла успешно, метод возвращает значение true.
	boolean isCancelled(){} // Была ли задача отменена
	boolean isDone(){} // Была ли задача завершена.
}
FutureTask task = new FutureTask(Callable<V> task)
FutureTask task = new FutureTask(Runnable task, V result) // Создает объект, реализующий как Future<V>, так и Runnable


java.util.concurrent.Executors:
ExecutorService newCachedThreadPool() // Возвращает пул потоков, в котором потоки создаются по мере необходимости и удаляются, если
// бездействуют более 50 секунд
ExecutorService newFixedThreadPool(int threads) // Возвращает пул, содержащий заданное количество потоков
ExecutorService newSingleThreadExecutor() // Возвращает пул, в котором все задачи выполняются последовательно одним потоком
ScheduledExecutorService newScheduledThreadPool(int threads) // Возвращает пул, в котором ждя планируемого выполнения задач используется указанное
// число потоков
ScheduledExecutorService new SingleThreadScheduledExecutor() // Возвращает пул, в котором планируемое выполнение задач производиться одним потоком

java.util.concurrent.ExecutorService:
Future<T> submit(Callable<T> task)
Future<T> submit(Runnable task, T result)
Future<?> submit(Runnable task) // Передает указанную задачу на выполнение
void shutdown() // Завершает работу службы, оканчивая выполнение уже принятых задач, но не принимая новых
T invokeAny(Collection<Callable<T>> tasks)
T invokeAny(Collection<Callable<T>> tasks, long timeout, TimeUnit unit)
// Запускает указанные задачи и возвращает результаты выполнения одной из них. Второй вариант метода поддерживает тайм-аут. Если результат не
// не получен в течение указанного времени, генерируется исключение TimeoutException
List<Future<T>> invokeAll(Collection<Callable<T>> tasks)
List<Future<T>> invokeAll(Collection<Callable<T>> tasks, long timeOut, TimeUnit unit)
// Выполняет указанные задачи и возвращает результаты их выполнения. Второй вариант метода поддерживает тайм-аут, по истечении указанного времени
// генерируется исключение TimeoutException

java.util.concurrent.ExecutorCompletionService:
ExecutorCompletionService(Executor e) // Создает объект ExecutorCompletionService, который обрабатывает результаты, полученные заданным объектом
// Executor
Future<T> submit(Callable<T> task)
Future<T> submit(Callable<T> task, T result) // Передает задачу на выполнение
Future<T> take() // Удаляет следующий готовый результат. Если результаты еще не доступны, выполнение приостанавливается
Future<T> poll()
Future<T> poll(long time, TimeUnit unit)
// Удаляет следующий готовый результат. Если результаты еще не доступны, возвращает значение null. Второй вариант метода предполагает ожидание
// в течение указанного времени

java.util.concurrent.ThreadPoolExecutor:
int getLargestPoolSize() // Возвращает наибольший размер пула, достигнутый в процессе его работы

java.util.concurrent.ScheduledExecutorService:
ScheduledFuture<V> schedule(Callable<V> task, long time, TimeUnit unit)
ScheduledFuture<V> schedule(Runnable task, long time, TimeUnit unit)
// Планирует выполнение указанной задачи по истечении заданного интервала времени.
ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long initialDelay, long period, TimeUnit unit) // Планирует периодическое выполнение задачи.
// После начальной задержки задача запускается через указанный интервал времени period
ScheduledFuture<?> scheduleWithFicedDelay(Runnable task, long initialDelay, long delay, TimeUnit unit) // Планирует периодическое выполнение задачи
// После начальной задержки задача периодически запускается так, что между окончание ее предыдущего выполнения и началом следующего проходит время
// delay

java.util.concurrent.CyclicBarrier:
CyclicBarrier(int parties)
CyclicBarrier(int parties, Runnable barrierAction)
// Создает объект CyclicBarrier для указанного числа участников. Действие barrierAction выполняется, когда все участники вызывают метод await()
int await()
int await(long time, TimeUnit unit)
// Ожидает, пока все частники вызовут метод await() барьера или пока не истечет указанное время. Во второом случае генерируется исключение 
// TimeoutException. В случае успеха возвращает индекс участника. Первый участник имеет интекс parties - 1, а последник - индекс 0.

java.util.concurrent.CountDownLatch:
CountDownLatch(int count) // Создает объект CountDawnLatch с указанным значением счетчика.
void await() // Ожидает, пока счетчик достигнет значения 0.
boolean await(long time, TimeUnit unit) // Ожидает, пока счетчик достигнет значения 0, либо пока не истечет время тайм-аута. Если значение счетчика
// стало равным нулю, возвращает true, если метод окончил работу по тайм-ауту - false.
public void countDown() // Уменьшает значение счетчика для данного затвора.

java.util.concurrent.Exchanger<V>:
V exchange(V item)
V exchange(V item, long time, TimeUnit unit)
// Приостанавливает работу до тех пор, пока другой потоу не вызовет данный метод, затем обменивается объектами с этим потоком и возвращает объект
// второго потока. После истечения времени тайм-аута второй поток генерирует исключение TimeoutException

java.util.concurrent.SynchronousQueue<V>:
SynchronousQueue()
SynchronousQueue(boolean fair)
// Создает объектт SynchronousQueue, обеспечивающий передачу объектов от одного потока к другому. Если параметр fair равен true, предпочтение
// отдается потокам, находящимся в режиме ожидания.
void put(V item) // Приостанавливает выполнение до тех пор, пока другой потоу не вызовет метод take().
V take() // Приостанавливает выполнение до тех пор, пока другой поток не вызовет метод put(). Возвращает объект, переданный другим потоком.

java.util.concurrent.Semaphore:
Semaphore(int permits)
Semaphore(int permits, boolean fair)
// Создает семафор с максимальным числом разрешений. Если параметр fair равен true, очередь отдает предпочтение потокам, дольше находящимся в
// режиме ожидания.
void acquire() // Ожидает получение разрешения.
boolean tryAcquire() // Пытается получить разрешение. Если таковое недоступно, возвращает значение false.
boolean tryAcquire(long tmie, TimeUnit unit) // Пытается получить разрешение за указанный интервал времени. Если разрешение получить не удалось,
// возвращает false.
void release() // Освобождает разрешение.