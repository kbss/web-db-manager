webApp.controller('CreateAccountController',
    ['UserService', '$scope', '$log', '$rootScope', function (UserService, $scope, $log, $rootScope) {

        var API = {
            login: function () {

                var promise = UserService.cre($scope.loginData);
                promise.then(
                    function (success) {
                        $log.debug("Authentication success!");
                        $scope.authorized = true;
                        API.clearLoginData();
                        $location.path($scope.backTo);
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
    }]
)
;