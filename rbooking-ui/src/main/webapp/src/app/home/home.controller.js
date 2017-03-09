
'use strict';
var dashboradModule = angular.module('home.module', []);
dashboradModule.controller('HomeCtrl',
    [
        '$scope',
        '$rootScope',
        '$state',
        function ($scope, $rootScope, $state) {			
			$state.go("home");
        }
    ]);
