/**
 * @author Serhii Kryvtsov
 * @since 03/07/2014.
 */

webApp.factory('WebStorageService',
    ['$cookieStore', 'webStorage', function ($cookieStore, webStorage) {
        var service;
        return service = {
            add: function (name, value, sessionOnly) {
                if (sessionOnly) {
                    webStorage.session.add(name, value);
                    $cookieStore.put(name, value);
                } else {
                    webStorage.local.add(name, value);
                }
            },
            get: function (name) {
                var value = webStorage.session.get(name);
                if (value) {
                    return value;
                }
                value = webStorage.local.get(name);
                if (value) {
                    return value;
                }
                value = $cookieStore.get(name);
                if (value) {
                    return value;
                }
            },
            remove: function (name) {
                webStorage.local.remove(name);
                webStorage.session.remove(name);
                $cookieStore.remove(name);
            }
        };

    }]
);