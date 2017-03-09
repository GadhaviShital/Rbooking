'use strict';

envoyServices.service('UserService', ['Restangular', '$q', function (Restangular, $q) {
            var self = this;
            this.restUser = Restangular.all('user');

            this.getUsers = function () {
                var newResDeferred = $q.defer();
                self.restUser.getList().then(function (result) {
                    newResDeferred.resolve(result);
                }, function error(data) {
                    return newResDeferred.reject(data);
                });

                return newResDeferred.promise;
            };

            this.saveUser = function (user) {
                user.role = Restangular.stripRestangular(user.role);
                var newResDeferred = $q.defer();
                self.restUser.post(user).then(function (result) {
                    newResDeferred.resolve(self.restUser.getList().$object);
                }, function error(data) {
                    return newResDeferred.reject(data);
                });
                return newResDeferred.promise;
            };

            this.removeUser = function (user) {
                var newResDeferred = $q.defer();
                user.remove().then(function (result) {
                    //newResDeferred.resolve(result);
                    //reload updated users list
                    self.restUser.getList().then(function (result) {
                        newResDeferred.resolve(result);
                    }, function error(data) {
                        return newResDeferred.reject(data);
                    });

                }, function (data) {
                    return newResDeferred.reject(data);
                });
                return newResDeferred.promise;
            };
        }
    ]);
