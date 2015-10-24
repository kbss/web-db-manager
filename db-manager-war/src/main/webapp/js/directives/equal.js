webApp.directive('equal', function ($parse) {
    return {
        require: 'ngModel',
        scope: {
            equal: '='
        },
        link: function (scope, elem, attrs, ctrl) {
            ctrl.$validators.equal = function (modelValue, viewValue) {
                console.log(modelValue + "+" + scope.equal)
                return modelValue === scope.equal;
            };
            scope.$watch('equal', function (newVal, oldVal) {
                ctrl.$validate();
            });
        }
    };
});