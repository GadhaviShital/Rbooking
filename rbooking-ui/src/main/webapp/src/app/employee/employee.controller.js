
'use strict';
var dashboardModule = angular.module('employee.module', []);
dashboardModule.controller('EmployeeCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
		'Restangular',
        function ($scope, $rootScope, $state, Restangular) {
			$scope.firstName = null;
			$scope.lastName = null;
			$scope.email = null;
			$scope.phoneNumber = null;
			$scope.type = null;
			$scope.userName = null;
			$scope.password = null;
			$scope.employees = [];
			$scope.addEmployee = function()
			{
				var employee = {};
				employee.firstName = $scope.firstName;
				employee.lastName = $scope.lastName;
				employee.email = $scope.email;
				employee.phoneNumber = $scope.phoneNumber;
				employee.type = $scope.type;
				
				Restangular.all('employee').post(employee).then(function(data){
					var credential = {};
					credential.userName = $scope.userName;
					credential.password = $scope.password;
					var employee = {};
					employee.id = data.id;
					credential.employee = employee;
					Restangular.all('employee/credential').post(credential).then(function(data){
						$scope.firstName = null;
						$scope.lastName = null;
						$scope.email = null;
						$scope.phoneNumber = null;
						$scope.type = null;	
						$scope.userName = null;
						$scope.password = null;
					});
					
				});
			};
			
			$scope.getAll = function()
			{
				Restangular.all('employee').getList().then(function(data){
					$scope.employees = data;
				});
			};
			$scope.getAll();
        }
    ]);
