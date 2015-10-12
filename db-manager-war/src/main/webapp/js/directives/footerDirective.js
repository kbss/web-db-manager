webApp.directive('webappFooter',
    [function () {
        return {
            restrict: "E",
            priority: 400,
            templateUrl: 'templates/footer.html',
            replace: true,
            controller: ('webAppFooterController', function ($scope) {
            })
        }
    }]
);