(function () {

    angular
        .module('app', ['ngRoute'])
        .config(config);

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'main/main.html',
                controller: 'mainController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

})();