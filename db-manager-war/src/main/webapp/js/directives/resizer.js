angular.module('mc.resizer', []).directive('resizer', function ($document) {

    return function ($scope, $element, $attrs) {

        $element.on('mousedown', function (event) {
            event.preventDefault();

            $document.on('mousemove', mousemove);
            $document.on('mouseup', mouseup);
        });

        function mousemove(event) {

            var PX = 'px';
            if ($attrs.resizer == 'vertical') {
                // Handle vertical resizer
                var x = event.pageX;
                if ($attrs.resizerMax && x > $attrs.resizerMax) {
                    x = parseInt($attrs.resizerMax);
                }
                $element.css({
                    left: x + PX
                });
                $($attrs.resizerLeft).css({
                    width: x + PX
                });
                $($attrs.resizerRight).css({
                    left: (x + parseInt($attrs.resizerWidth)) + PX
                });

            } else {
                // Handle horizontal resizer
                var y = window.innerHeight - event.pageY;

                $element.css({
                    bottom: y + PX
                });

                $($attrs.resizerTop).css({
                    bottom: (y + parseInt($attrs.resizerHeight)) + PX
                });
                $($attrs.resizerBottom).css({
                    height: y + PX
                });
            }
        }

        function mouseup() {
            $document.unbind('mousemove', mousemove);
            $document.unbind('mouseup', mouseup);
        }
    };
});