'use strict';

module.exports = function(config) {

  config.set({
    basePath : '..', //!\\ Ignored through gulp-karma //!\\

    files : [ //!\\ Ignored through gulp-karma //!\\
        <!-- build:js scripts/vendor.js -->
        <!-- bower:js -->
        'src/bower_components/jquery/dist/jquery.js',
        'src/bower_components/angular/angular.js',
        'src/bower_components/angular-mocks/angular-mocks.js',
        'src/bower_components/angular-animate/angular-animate.js',
        'src/bower_components/angular-cookies/angular-cookies.js',
        'src/bower_components/angular-touch/angular-touch.js',
        'src/bower_components/angular-sanitize/angular-sanitize.js',
        'src/bower_components/lodash/dist/lodash.compat.js',
        'src/bower_components/restangular/dist/restangular.js',
        'src/bower_components/angular-ui-router/release/angular-ui-router.js',
        'src/bower_components/angular-translate/angular-translate.js',
        'src/bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.js',
        'src/bower_components/angular-dynamic-locale/src/tmhDynamicLocale.js',
        'src/bower_components/angular-smart-table/dist/smart-table.min.js',

        'src/bower_components/bootstrap/dist/js/bootstrap.js',
        'src/bower_components/angular-bootstrap/ui-bootstrap.js',
        'src/bower_components/angular-bootstrap/ui-bootstrap-tpls.js',

        'src/bower_components/kendo-ui-core/js/kendo.all.min.js',


        <!-- endbower -->
        <!-- endbuild -->

        <!-- build:js({src,.tmp}) scripts/main.js -->
        'src/app/envoy.js',
        'src/app/dashboard/dashboard.controller.js',
        'src/app/points/points.controller.js',
        'src/app/controller/controller.controller.js',
        'src/app/siteoverview/siteoverview.controller.js',
        'src/app/sites/sites.controller.js',
        'src/app/sites/current.site.service.js',
        'src/app/siteslist/siteslist.controller.js',
        'src/app/storesetpoints/storesetpoints.controller.js',
        <!-- 'app/underconstruction/underconstruction.controller.js', -->
        'src/app/alerts/alert.controller.js',


        'src/app/users/user.controller.js',
        'src/app/users/user.service.js',
        'src/app/roles/role.service.js',
        'src/app/directives/envoy.requiredon.js',
        'src/app/directives/locale.class.js',
        'src/app/directives/envoy.equalto.js',
        'src/app/alerts/alert.service.js',
        'src/app/overrides/override.service.js',

        'src/app/selectedpoints/selectedpoints.controller.js',
        'src/app/admin/admin.controller.js',
        'src/app/manage/manage.controller.js',
        'src/app/configuration/configuration.controller.js',

        'src/components/navbar/navbar.controller.js',
        'src/components/lightingandtemp/lighting.temp.controller.js',



        'test/unit/**/*.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['PhantomJS'],
    reporters: ['progress', 'junit','coverage'],

      // the default configuration
      junitReporter: {
          outputFile: 'build/reports/coverage/TESTS-xunit.xml',
          suite: ''
      } ,
      preprocessors: {
          // source files, that you wanna generate coverage for
          // do not include tests or libraries
          // (these files will be instrumented by Istanbul)
          'src/{app,components}/**/*.js': ['coverage']
      },

      // optionally, configure the reporter
      coverageReporter: {
          dir: 'build/reports/coverage',
          reporters:[
              {type : 'lcovonly', subdir: '.', file: 'lcov.info'},
              {type: 'html',subdir: 'html'}
              ]

      },

    plugins : [
        'karma-phantomjs-launcher',
        'karma-jasmine',
        'karma-junit-reporter',
        'karma-coverage'
    ]
  });

};
