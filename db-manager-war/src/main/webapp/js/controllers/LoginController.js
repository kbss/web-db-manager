webApp.controller('LoginController',
    ['UserService', '$scope', '$log', '$rootScope', '$location', function (UserService, $scope, $log, $rootScope, $location) {

        var API = {
            login: function () {

                var promise = UserService.login($scope.loginData);
                promise.then(
                    function (success) {
                        $log.debug("Authentication success!");
                        $scope.authorized = true;
                        API.clearLoginData();
                        $location.path($scope.backTo);
                        $scope.backTo = '/';
                    },
                    function (error) {
                        $log.debug("Authentication failed");
                        $scope.authorized = false;
                        $scope.loginData.password = "";
                    }
                )['finally'](function () {
                });

            },
            clearLoginData: function () {
                $scope.loginData = {
                    "email": "",
                    "password": ""
                }
            }
        };

        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            $scope.backTo = '/';
            if ($location.path() == '/create-account' || $location.path() == '/login') {
                return;
            }
            if (!$rootScope.authorized) {
                $log.debug("Unauthorized!");
                $scope.backTo = $location.path();
                $location.path('/login');

            }
        });
        $scope.login = function () {
            API.login();
        }
    }]
)
;