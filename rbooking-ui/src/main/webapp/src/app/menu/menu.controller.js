
'use strict';
var dashboardModule = angular.module('menu.module', []);
dashboardModule.controller('MenuCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
		'Restangular',
		'toaster',
        function ($scope, $rootScope, $state, Restangular, toaster) {
			$scope.name = null;
			$scope.description = null;
			$scope.price = null;
			$scope.menues = [];
			$scope.addMenu = function()
			{
				var menu = {};
				menu.name = $scope.name;
				menu.description = $scope.description;
				menu.price = $scope.price;
				
				Restangular.all('menu').post(menu).then(function(data){
					$scope.name = null;
					$scope.description = null;
					$scope.price = null;
					toaster.success({title: "success", body:"New Menu Added"});
				}, function(error){
					toaster.error({title: "error", body:"Error while adding new Menu, please try again"});
				});
			};
			
			$scope.getAll = function()
			{
				Restangular.all('menu').getList().then(function(data){
					$scope.menues = data;
				}, function(error){
					toaster.error({title: "error", body:"Error while getting all menu"});
				});
			};
			$scope.getAll();
        }
    ]);
