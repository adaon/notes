INSTALLED_APPS = (
    'django.contrib.redirects',
)
MIDDLEWARE_CLASSES = (
    'django.contrib.redirect.middleware.RedirectFallbackMiddleware',
)