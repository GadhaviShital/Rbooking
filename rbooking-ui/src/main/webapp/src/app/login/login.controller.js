
'use strict';
var loginModule = angular.module('login.module', []);
loginModule.controller('LoginCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
		'Restangular',
		'$q',
		'toaster',
        function ($scope, $rootScope, $state, Restangular, $q, toaster) {
			$scope.userName = "";
			$scope.password = "";
			$rootScope.user = null;
			if($rootScope.user !== null)
			{
				$state.go('dashboard');
			}
			$scope.isLoggedIn = function()
			{
				if($rootScope.user !== null)
				{
					return true;
				}
				return false;
			}
			$scope.logout = function()
			{
				$rootScope.user = null;
				console.log($rootScope.user);
				$state.go('login');
			}
			$scope.login = function () {				
				var credential = {};
				credential.userName = $scope.userName;
				credential.password = $scope.password;
                var newResDeferred = $q.defer();
                Restangular.all('login').post(credential).then(function (result) {
					$rootScope.user = result;
					if(result.type === 'server')
					{
						$state.go('server-view');
					}
					else
					{
						$state.go('dashboard');
					}
                }, function error(data) {
					toaster.error('Error', 'Invalid Credential');
                    return newResDeferred.reject(data);
                });
                return newResDeferred.promise;
            };
        }
    ]);