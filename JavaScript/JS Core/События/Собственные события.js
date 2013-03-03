element.trigger(event);
element.trigger({
    type: 'myevent',
    value: 'hello'
});

element.bind(function(event) {
    alert(event.value); // hello
});