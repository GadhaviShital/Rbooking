
'use strict';
var dashboardModule = angular.module('dashboard.module', []);
dashboardModule.controller('DashboardCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
        function ($scope, $rootScope, $state) {
			$state.go("reservation-list");
        }
    ]);
