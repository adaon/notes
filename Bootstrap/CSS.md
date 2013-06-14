    <p class="lead"></p>
    
    <p class="text-left"></p>
    <p class="text-center"></p>
    <p class="text-right"></p>
    

Color:

    <p class="muted"></p>
    <p class="text-warning"></p>
    <p class="text-error"></p>
    <p class="text-info"></p>
    <p class="text-success"></p>

Немного уменьшенный текст аббревиатуры%

    <abbr title="fff" class="initialism">HTML></abbr>

Цитаты:

    <blockquote>
        <p>...</p>
    </blockquote>

    <blockquote>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
        <small>Someone famous <cite title="Source Title">Source Title</cite></small>
    </blockquote>

    <blockquote class="pull-right">
        ...
    </blockquote>

Списки

    <ul class="unstyled">
        <li>...</li>
    </ul>
    
    <!-- В строку -->
    <ul class="inline">
        <li>...</li>
    </ul>

Список с описаниями

    <dl>
        <dt>...</dt>
        <dd>...</dd>
    </dl>

Горизонтальный список с описаниями

    <dl class="dl-horizontal">
        <dt>...</dt>
        <dd>...</dd>
    </dl>

Строковой код

    <code>...</code>

Блок кода

    <pre>...</pre>

Базовая таблица

    <table class="table">
    </table>

Таблица с полосками

    <table class="table table-stripped">
    </table>

Таблица с рамкой

    <table class="table table-bordered">
    </table>

Таблица с выделением строк при наведении

    <table class="table table-hover">
    </table>

Таблица с уменьшенной высотой строк

    <table class="table table-condensed">
    </table>

Цветовое выделение строк:

    <tr class="success"></tr>
    <tr class="error"></tr>
    <tr class="warning"></tr>
    <tr class="info"></tr>

Поддерживаемые табличные теги

* `<table>`: Оберточный тег таблицы.
* `<thead>`: Контейнер для строк заголовков.
* `<tbody>`: Контейнер для строк тела таблицы.
* `<tr>`: Контейнер строки.
* `<td>`: Ячейка таблицы.
* `<th>`: Заголовочная ячейка.
* `<caption>`: Описание содержимого таблицы.

Элементы ввода

    <form>
      <fieldset>
        <legend>Legend</legend>
        <label>Label name</label>
        <input type="text" placeholder="Type something…">
        <span class="help-block">Example block-level help text here.</span>
        <label class="checkbox">
          <input type="checkbox"> Check me out
        </label>
        <button type="submit" class="btn">Submit</button>
      </fieldset>
    </form>

Форма поиска

    <form class="form-search">
      <input type="text" class="input-medium search-query">
      <button type="submit" class="btn">Search</button>
    </form>

Однострочная форма

    <form class="form-inline">
      <input type="text" class="input-small" placeholder="Email">
      <input type="password" class="input-small" placeholder="Password">
      <label class="checkbox">
        <input type="checkbox"> Remember me
      </label>
      <button type="submit" class="btn">Sign in</button>
    </form>

Горизонтальная форма

    <form class="form-horizontal">
      <div class="control-group">
        <label class="control-label" for="inputEmail">Email</label>
        <div class="controls">
          <input type="text" id="inputEmail" placeholder="Email">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="inputPassword">Password</label>
        <div class="controls">
          <input type="password" id="inputPassword" placeholder="Password">
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <label class="checkbox">
            <input type="checkbox"> Remember me
          </label>
          <button type="submit" class="btn">Sign in</button>
        </div>
      </div>
    </form>

Добавление знаков к элементу ввода (до и/или после)

    <div class="input-prepend">
      <span class="add-on">@</span>
      <input class="span2" id="prependedInput" type="text" placeholder="Username">
    </div>
    <div class="input-append">
      <input class="span2" id="appendedInput" type="text">
      <span class="add-on">.00</span>
    </div>

Добавление кнопок к элементу ввода

    <div class="input-append">
      <input class="span2" id="appendedInputButton" type="text">
      <button class="btn" type="button">Go!</button>
    </div>

Выпадающее меню на кнопке

    <div class="input-append">
      <input class="span2" id="appendedDropdownButton" type="text">
      <div class="btn-group">
        <button class="btn dropdown-toggle" data-toggle="dropdown">
          Action
          <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
          ...
        </ul>
      </div>
    </div>

Segmented dropdown groups

    <form>
      <div class="input-prepend">
        <div class="btn-group">...</div>
        <input type="text">
      </div>
      <div class="input-append">
        <input type="text">
        <div class="btn-group">...</div>
      </div>
    </form>

Форма поиска

    <form class="form-search">
      <div class="input-append">
        <input type="text" class="span2 search-query">
        <button type="submit" class="btn">Search</button>
      </div>
      <div class="input-prepend">
        <button type="submit" class="btn">Search</button>
        <input type="text" class="span2 search-query">
      </div>
    </form>

Размер элементов ввода

    <input class="input-mini" type="text" placeholder=".input-mini">
    <input class="input-small" type="text" placeholder=".input-small">
    <input class="input-medium" type="text" placeholder=".input-medium">
    <input class="input-large" type="text" placeholder=".input-large">
    <input class="input-xlarge" type="text" placeholder=".input-xlarge">
    <input class="input-xxlarge" type="text" placeholder=".input-xxlarge">

Расположение нескольких элементов в одной строке

    <div class="controls">
      <input class="span5" type="text" placeholder=".span5">
    </div>
    <div class="controls controls-row">
      <input class="span4" type="text" placeholder=".span4">
      <input class="span1" type="text" placeholder=".span1">
    </div>
    ...

Нередактируемые поля ввода

    <span class="input-xlarge uneditable-input">Some value here</span>

Кнопки действий форм

    <div class="form-actions">
      <button type="submit" class="btn btn-primary">Save changes</button>
      <button type="button" class="btn">Cancel</button>
    </div>

