/**
 * @author Serhii Kryvtsov
 * @since 03/07/2014.
 */
webApp.factory('GenericHttpService',
    ['$http', '$q', function ($http, $q) {
        var httpService;
        return httpService = {
            get: function (url) {
                var deferred = $q.defer();
                $http.get(url)
                    .success(function (data, status, header, config) {
                        deferred.resolve(data);
                    })
                    .error(function (data, status, headers, config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            post: function (url, json) {
                var deferred = $q.defer();
                $http.post(url, json)
                    .success(function (data, status, header, config) {
                        deferred.resolve(data);
                    })
                    .error(function (data, status, headers, config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            put: function (url, json) {
                var deferred = $q.defer();
                $http.put(url, json)
                    .success(function (data, status, header, config) {
                        deferred.resolve(data);
                    })
                    .error(function (data, status, headers, config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }, 'delete': function (url) {
                var deferred = $q.defer();
                $http['delete'](url)
                    .success(function (data, status, header, config) {
                        deferred.resolve(data);
                    })
                    .error(function (data, status, headers, config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }, head: function (url) {
                var deferred = $q.defer();
                $http.head(url)
                    .success(function (data, status, header, config) {
                        deferred.resolve(data);
                    })
                    .error(function (data, status, headers, config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }
        }
    }]
);


