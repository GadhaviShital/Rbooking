
'use strict';
var dashboradModule = angular.module('user.module', []);
dashboradModule.controller('UserCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
        'UserService',
        function ($scope, $rootScope, $state, UserService) {
            $rootScope.selectedMenu = 'user';
            $scope.users = [];
            
            UserService.getUsers().then(function(users){
                $scope.users = users;
            });
        }
    ]);
