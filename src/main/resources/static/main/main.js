angular.module('app').controller('mainController', function ($scope, $http) {
    const contextPath = 'http://localhost:8191/count';

    $scope.mainContentRequest = function () {
        $http({
            url: contextPath + '/api/v1/counter',
            method: 'GET'
        }).then(function (response) {
            console.log(response.data);
            $scope.main = response.data;
        });
    };

    $scope.incrementItem = function (id) {
        $http({
            url: contextPath + '/api/v1/counter/inc/' + id,
            method: 'GET'
        }).then(function (response) {
            $scope.mainContentRequest();
        });
    };

    $scope.mainContentRequest();
});