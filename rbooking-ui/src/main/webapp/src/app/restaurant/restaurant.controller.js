
'use strict';
var restaurantModule = angular.module('restaurant.module', []);
restaurantModule.controller('RestaurantCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
		'Restangular',
		'toaster',
        function ($scope, $rootScope, $state, Restangular, toaster) {
			
			$scope.restaurant = {};
			$scope.monday = {day : 'MON'};
			$scope.tuesday = {day : 'TUE'};
			$scope.wednesday = {day : 'WED'};
			$scope.thursday = {day : 'THU'};
			$scope.friday = {day : 'FRI'};
			$scope.saturday = {day : 'SAT'};
			$scope.sunday = {day : 'SUN'};
			
			$scope.update = function()
			{
				$scope.updateTiming()
				Restangular.all('restaurant').post($scope.restaurant).then(function(data){
					toaster.success('Success','Restaurant Information Updated')
				}, function(){
					toaster.error('Error','Error while updating Restaurant Information')
				});
			};
			
			$scope.getInfo = function()
			{
				Restangular.all('restaurant').getList().then(function(data){
					$scope.restaurant = data[0];
				}, function(){
					toaster.error('Error','Error while getting Restaurant Information')
				});
			};
			$scope.updateTiming = function()
			{
				var timing = [];
				timing.push($scope.monday);
				timing.push($scope.tuesday);
				timing.push($scope.wednesday);
				timing.push($scope.thursday);
				timing.push($scope.friday);
				timing.push($scope.saturday);
				timing.push($scope.sunday);
				Restangular.all('timing/list').post(timing).then(function(data){
					toaster.success('Success','Restaurant Timing Updated')
				}, function(){
					toaster.error('Error','Error while updating Restaurant Timing')
				});
			}
			$scope.getTiming = function()
			{
				Restangular.all("timing").getList().then(function(data){
					data = Restangular.stripRestangular(data);
					angular.forEach(data, function(d,i){
						
						if(d.day === 'MON')
						{
							$scope.monday = d;
						}
						else if(d.day === 'TUE')
						{
							$scope.tuesday = d;
						}
						else if(d.day === 'WED')
						{
							$scope.wednesday = d;
						}
						else if(d.day === 'THU')
						{
							$scope.thursday = d;
						}
						else if(d.day === 'FRI')
						{
							$scope.friday = d;
						}
						else if(d.day === 'SAT')
						{
							$scope.saturday = d;
						}
						else if(d.day === 'SUN')
						{
							$scope.sunday = d;
						}
					});
				});
			};
			
			$scope.getTiming();
			$scope.getInfo();
        }
    ]);
