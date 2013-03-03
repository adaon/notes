## Формат npm-пакета

	{
		"name": "packageName",
		"version": "1.0.0",
		"main": "mainModuleName",
		"modules": {
			"mod1": "lib/mod1",
			"mod2": "lib/mod2"
		},
		"dependencies": {
			{
				"foo": "1.0.0 - 2.9999.9999",
				"bar": ">=1.0.2 <2.1.2"
			}
		},
		"description": "myDescription",
		"homepage": "http://google.ru",
		"author": "teu@nm.ru"
	}


## Установка пакета в глобальном режиме

	npm install -g package

Установка пакета

	npm install <package_name>

Установка конкретной версии пакета

	npm install <package_name>@<version>
	npm install express@2.0.x
	npm install express@">=0.1.0 <0.3.1"

Удаление пакета

	npm uninstall <package_name>
	npm uninstall -g <package_name>

Обновление пакета

	npm update <package_name>
	npm update -g <package_name>