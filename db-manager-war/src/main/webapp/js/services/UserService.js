/**
 * @author Serhii Kryvtsov
 * @since 03/07/2014.
 */

webApp.factory('UserService',
    ['GenericHttpService', function (GenericHttpService) {
        var userService;
        return userService = {
            login: function (loginData) {
                return GenericHttpService.post('/services/account/login', loginData);
            },
            createAccount: function (accountModel) {
                return GenericHttpService.post('/services/account/register', accountModel);
            }
        };

    }]
);