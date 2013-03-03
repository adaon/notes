### Активация ###

# settings.py
INSTALLED_APPS = (
    # ...
    'django.contrib.sites',
    'django.contrib.flatpages',
    # ...
)
MIDDLEWARE_CLASSED = (
    # ...
    'django.contrib.flatpages.middleware.FlatpageFallbackMiddleware',
    # ...
)

### Шаблоны ###

# flatpages/default.html - по умолчанию.
# В шаблон по умолчанию передается единственная контекстная переменная - flatpage (с аттрибутами url, title, content, enable_comments, template_name, registration_required, sites)