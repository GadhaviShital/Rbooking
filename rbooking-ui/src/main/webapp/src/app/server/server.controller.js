
'use strict';
var restaurantModule = angular.module('server.module', []);
restaurantModule.controller('ServerCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
		'Restangular',
		'toaster',
        function ($scope, $rootScope, $state, Restangular, toaster) {
			
			$scope.reservations = [];
			
			$scope.getReservations = function()
			{
				Restangular.all('reservation?server=true').getList().then(function(data){
					$scope.reservations = data;
				}, function(){
					toaster.error('Error','Error while getting Reservation')
				});
			};
			
			$scope.getReservations();
			$scope.getTable();
			$scope.getServer();
        }
    ]);
