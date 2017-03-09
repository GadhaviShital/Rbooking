'use strict';

var navbar = angular.module('navbar.module',['restangular', 'ui.bootstrap']);
navbar.controller('NavbarCtrl',
[
    '$rootScope',
    'Restangular',
    '$scope',
    '$timeout',
    '$translate',
    '$location',
    '$window',
    '$state',
    'toaster',
    function ($rootScope, Restangular, $scope,
                $timeout,$translate,
                $location,
                $window,$state,toaster)
    {
        $scope.currentURL = $location.absUrl();
        // Get the loclae that is selected in CAS login page by user. Defaults
		// to en-US.
        // Keep the locale in rootscope so that it can be used across
		// application when needed.
       
        $rootScope.selectedTab = 'dashboard';
       
        $scope.init = function()
        {
       
        };
        
        $scope.init();
    }
]);
