System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(url, user, password);
Statement stat = conn.createStatement();
stat.execute("DROP TABLE new_table2");
ResultSet rs = stat.executeQuery("SELECT * FROM Account");
while(rs.next()) {
    System.out.println(rs.getString("username"|1));
}
conn.close();

stat.executeUpdate("QUERY"); // Возвращает количество строк, полученых в результате. Применяется для команд INSERT, UPDATE, DELETE и команд определения данных (CREATE, DROP и т.д.)
stat.executeQuery("QUERY"); // для запросов SELECT. Возвращает ResultSet.
stat.getResultSet(); // Возвращает результаты предыдущего запроса.
stat.findColumn(name); // Возвращает номер столбца.

String query = "SELECT * FROM books WHERE name=?"; // Запрос с подстановочной переменной
PreparedStatement stat = conn.prepareStatement(query); // Создание запроса с подстановочными переменными
stat.setString(1, "name"); // Установка строки в подстановочный параметр с индексом 1
Statement stat = conn.createStatement(
    ResultSet.TYPE_FORWARD_ONLY|TYPE_SCROLL_INSENSITIVE|TYPE_SCROLL_SENSITIVE, // Без прокрутки/с прокруткой, но без учета изменений / с прокруткой и учетом
    ResultSet.CONCUR_READ_ONLY|CONCUR_UPDATABLE);
ResultSet result = stat.executeStat(query); // Возвращает набор результатов с курсором
result.previous(); // Есть ли предыдущие строки
result.relative(-1); // перемещает курсор на одну строку назад. Возвращает false при выходе за границы
result.absolute(5); // Помещает курсор на 5 строку
result.getRow(); // Возвращает текущий курсор (1-n). Возвращает 0 при выходе за границы
result.first();
result.last();
result.beforeFirst();
result.afterLast();
result.isFirst();
result.isLast();
result.isBeforeFirst();
result.isAfterLast();
// Обновление данных запроса
result.updateInt("balance", Integer.parseInt(table.getModel().getValueAt(row, column) + ""));
result.updateRow();

// Вставка строки:
result.moveToInsertRow(); // Перемешение курсора в позицию вставки
result.updateString("Title", "title");
// ...
result.insertString();
result.moveToCurrentRow();

result.deleteRow(); // Удаление строки из запроса и базы данных

DatabaseMetaData meta = conn.getMetaData();
ResultSet tables = meta.getTables(null, null, null, new String[] { "TABLE" }); // 5 столбцов: TABLE_CAT, TABLE_SCHEM, TABLE_NAME, TABLE_TYPE, REMARKS
ResultSet dbs = meta.getCatalogs(); // Список баз данных
while(tables.next()) {
    System.out.println(tables.getString(3)); // Имя таблицы
    System.out.println(dbs.getString(1)); // Имя бд
}

ResultSetMetaData meta = result.getMetaData();
meta.getColumnCount(); // Количество столбцов
meta.getColumnLabel(index); // Имя столбца с указанным индексом
meta.getColumnDisplaySize(index); // Макс. ширина столбца в символах