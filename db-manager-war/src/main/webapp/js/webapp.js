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
    ['$rootScope', '$location', '$log', '$location',
        function ($rootScope, $log, $location) {
            $rootScope.$on("$routeChangeStart", function (event, next, current) {
                console.debug("$routeChangeStart");
            });

            $rootScope.$on("$routeChangeError", function (event) {
                console.debug("$routeChangeError");
            });

            $rootScope.$on("$routeChangeSuccess", function (event, next, current) {
                console.debug("$routeChangeSuccess");
            });
            $rootScope.$on('$viewContentLoaded', function () {
                console.debug("$viewContentLoaded");
            });
        }])
    .config(
    ['$routeProvider',
        function ($routeProvider) {
            $routeProvider.when("/", {
                templateUrl: 'templates/home.page.html',
                controller: 'HomeController'
            }).when("/create-account", {
                templateUrl: 'templates/create-account.html',
                controller: 'CreateAccountController'
            }).when("/login", {
                templateUrl: 'templates/login-page.html',
                controller: 'LoginController'
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