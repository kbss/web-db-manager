/**
 * @author Serhii Kryvtsov
 * @since 03/07/2014.
 */
var webApp = angular.module("webApp", ['ngRoute', 'webStorageModule', 'ngCookies', 'ngAnimate', 'mc.resizer']).config(
    ['$locationProvider',
        function ($locationProvider) {
            $locationProvider.html5Mode(true);
            $locationProvider.hashPrefix('!');
        }
    ])
    .run(
    ['$rootScope', '$location', '$log',
        function ($rootScope, $log) {
            $rootScope.$on("$routeChangeStart", function (event, next, current) {

            });

            $rootScope.$on("$routeChangeError", function (event) {

            });

            $rootScope.$on("$routeChangeSuccess", function (event, next, current) {

            });
            $rootScope.$on('$viewContentLoaded', function () {
                //$('#login-modal').modal();
                $rootScope.authorized = true;
                console.log('aas');
            });
        }])
    .config(
    ['$routeProvider',
        function ($routeProvider) {
            $routeProvider.when("/", {
                templateUrl: 'templates/home.page.html',
                controller: 'HomeController'
            }).when("/404", {
                templateUrl: 'assets/templates/404.html',
                controller: '404Controller'
            }).otherwise({
                redirectTo: '/404'
            });
        }

    ])
    .config(function ($httpProvider) {
        $httpProvider.interceptors.push('AuthInterceptor');
    })
// Disables GET requests caching
    .config(
    ['$httpProvider',
        function ($httpProvider) {
            if (!$httpProvider.defaults.headers.get) {
                $httpProvider.defaults.headers.get = {};
            }
            $httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 1 Aug 1997 00:00:01 GMT';
            $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
            $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
        }
    ]);