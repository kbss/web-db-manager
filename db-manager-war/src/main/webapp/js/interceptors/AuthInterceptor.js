/**
 * @author Serhii Kryvtsov
 * @since 03/07/2014.
 */

webApp.factory('AuthInterceptor',
    ['$rootScope', '$q', function ($rootScope, $q) {
        return {
            response: function (res) {
                return res;
            }
            , responseError: function (res) {
                if (res.status == 401) {
                    //TODO: implement logout
                    return $q.reject(res);
                }
                return $q.reject(res);
            }
        };
    }]
);