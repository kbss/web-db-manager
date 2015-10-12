webApp.directive('webappHeader',
    [function () {
        return {
            restrict: "E",
            priority: 500,
            templateUrl: 'templates/header.html',
            replace: true,
            controller: ('webAppHeaderController', function ($scope) {
            })
        }
    }]
);