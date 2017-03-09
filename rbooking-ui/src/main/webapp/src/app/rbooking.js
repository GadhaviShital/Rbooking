'use strict';

var rbooking = angular.module('rbooking', ['ngCookies', 'ngTouch', 'ngSanitize',
            'restangular', 'ui.router', 'pascalprecht.translate',
            'tmh.dynamicLocale', 'ui.bootstrap', 'smart-table', 'kendo.directives',
            'ui.slider', 'toaster', 'ngFileUpload', 'pasvaz.bindonce',
            'angularjs-dropdown-multiselect', 'ngIdle',

            'login.module', 'home.module', 'dashboard.module',
			'employee.module', 'menu.module','restaurant.module', 
			'reservation.module', 'server.module',

            'rbooking.services',

            'rbooking.directives',

            'rbooking.filters']);

var envoyServices = angular.module('rbooking.services', []);
var envoyDirectives = angular.module('rbooking.directives', []);
var envoyFilters = angular.module('rbooking.filters', []);

rbooking.config(
[
	'RestangularProvider',
	'$stateProvider',
	'$urlRouterProvider',
	'$httpProvider',
	'tmhDynamicLocaleProvider',
	'IdleProvider',
	'KeepaliveProvider',

	function (RestangularProvider, $stateProvider,
		$urlRouterProvider, $httpProvider,
		tmhDynamicLocaleProvider, IdleProvider,
		KeepaliveProvider) {
		IdleProvider.idle(1200); // in seconds
		IdleProvider.timeout(120); // in seconds
		

		$httpProvider.defaults.cache = false;

		// initialize get if not there
		if (!$httpProvider.defaults.headers.get) {
			$httpProvider.defaults.headers.get = {};
		}

		// disable IE ajax request caching
		$httpProvider.defaults.headers.get['If-Modified-Since'] = '0';
		function getErrorStatus(error) {
			var status = "";
			if (error.status === 500)
				status = "Internal Server Error";
			else if (error.status === 403)
				status = "Access Denied";
			else
				status = "Server Error";
			return status;
		}
		RestangularProvider.setBaseUrl('../../rbooking-webservice');

		RestangularProvider.setDefaultHeaders({
			"Cache-Control": "no-cache",
			"Accept-Language": 'en-US'
		});

		RestangularProvider.setDefaultHttpFields({
			cache: false
		});

		/**
		 * SetResponseExtractor intercept when there is a 500,403 Error.
		 */
		RestangularProvider.setResponseExtractor(
			function (data, operation, what, response, deferred) {
				return data;
			}
		);

$stateProvider
		.state('login', {
			url: '/login',
			templateUrl: 'app/login/login.html',
			controller: 'LoginCtrl'
		}).state('home', {
			url: '/home',
			templateUrl: 'app/home/home.html',
			controller: 'HomeCtrl'
		}).state('dashboard', {
			url: '/dashboard',
			templateUrl: 'app/dashboard/dashboard.html',
			controller: 'DashboardCtrl'
		}).state('menu', {
			url: '/menu',
			templateUrl: 'app/menu/menu.html',
			controller: 'MenuCtrl'
		})
		.state('contact', {
			url: '/contact',
			templateUrl: 'app/contact/contact.html',
			controller : 'RestaurantCtrl'
		})
		.state('reservation', {
			url: '/reservation',
			templateUrl: 'app/reservation/reservation.html',
			controller : 'ReservationCtrl'
		})
		.state('server-view', {
			url: '/server-view',
			templateUrl: 'app/server/server-view.html',
			controller : 'ServerCtrl'
		})
		.state('add-employee', {
			url: '/add-employee',
			templateUrl: 'app/employee/add-employee.html',
			controller: 'EmployeeCtrl'
		})
		.state('add-menu-item', {
			url: '/add-menu-item',
			templateUrl: 'app/menu/add-menu-item.html',
			controller: 'MenuCtrl'
		})
		.state('update-info', {
			url: '/update-info',
			templateUrl: 'app/restaurant/update-info.html',
			controller : 'RestaurantCtrl'
		})
		.state('employee-list', {
			url: '/employee-list',
			templateUrl: 'app/employee/employee-list.html',
			controller: 'EmployeeCtrl'
		})
		.state('reservation-list', {
			url: '/reservation-list',
			templateUrl: 'app/reservation/reservation-list.html',
			controller : 'ReservationCtrl'
		})
		.state('thank-you', {
			url: '/thank-you',
			templateUrl: 'app/thank-you.html'
		});

		$urlRouterProvider.otherwise('/home');
	}
]);