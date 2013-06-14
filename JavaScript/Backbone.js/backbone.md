# Backbone

## Backbone.Events

    var object = {};
    _.extends(object, Backbone.Events);
    object.on('alert', function (msg) {
        alert(msg);
    });
    object.trigger('alert', 'message');
    
    var dispatcher = _.clone(Backbone.Events);