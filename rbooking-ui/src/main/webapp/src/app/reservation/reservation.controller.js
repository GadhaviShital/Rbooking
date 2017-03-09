
'use strict';
var restaurantModule = angular.module('reservation.module', []);
restaurantModule.controller('ReservationCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
		'Restangular',
		'toaster',
        function ($scope, $rootScope, $state, Restangular, toaster) {
			
			$scope.reservation = {};
			$scope.customer = {};
			$scope.reservations = [];
			$scope.tables = [];
			$scope.servers = [];
			$scope.server;
			$scope.table;
			
			$scope.reservation = null;
			$scope.popup1 = {
				opened: false
			};
			$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			$scope.format = $scope.formats[0];
			$scope.altInputFormats = ['M!/d!/yyyy'];
			$scope.dateOptions = {
				dateDisabled: disabled,
				formatYear: 'yy',
				maxDate: new Date(2020, 5, 22),
				minDate: new Date(),
				startingDay: 1
			};
			// Disable weekend selection
			function disabled(data) {
				var date = data.date,
				mode = data.mode;
				return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
			}
			$scope.open1 = function() {
				$scope.popup1.opened = true;
			};
			$scope.today = function() {
				$scope.dt = new Date();
			};
			
			$scope.setReservation = function(reservation)
			{
				$scope.reservation = reservation;
			}
			$scope.getServer = function()
			{
				Restangular.all('employee/server').getList().then(function(data){
					$scope.servers = data;
				}, function(){
					toaster.error('Error','Error while getting server');
				});
			};
			$scope.getTable = function()
			{
				Restangular.all('table').getList().then(function(data){
					$scope.tables = data;
				}, function(){
					toaster.error('Error','Error while getting tables');
				});
			};
			$scope.save = function()
			{
				$scope.reservation.customer = $scope.customer;
				Restangular.all('reservation').post($scope.reservation).then(function(data){
					$scope.reservation = {};
					$scope.customer = {};
					$state.go('thank-you');
				}, function(){
					toaster.error('Error','Error while Making Reservation');
				});
				
			};
			
			$scope.checkin = function()
			{
				Restangular.all('reservation/checkin/reservationId/'+$scope.reservation.id+'/tableId/'+$scope.table+'/serverId/'+$scope.server).post().then(function(data){
					toaster.success('Success','Checkin success');
					$scope.reservation.hasShowup = true;
					Restangular.all('reservation').post($scope.reservation).then(function(data){
						$scope.getReservations();						
					}, function(){
						
					});
					$scope.reservation = {};
					
				}, function(){
					toaster.error('Error','Error while checkin')
				});
				
				
			}
			
			$scope.getReservations = function()
			{
				Restangular.all('reservation').getList().then(function(data){
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
