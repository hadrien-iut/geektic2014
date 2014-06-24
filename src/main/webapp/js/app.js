var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl'
      });
//		.when('/login', {
//        templateUrl: 'views/login.html',
//        controller: 'LoginCtrl'
//      })
//		.when('/register', {
//        templateUrl: 'views/register.html',
//        controller: 'RegisterCtrl'
//      });
	});

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('HomeCtrl', function($scope, $http) {
	$scope.interets = {};
	$scope.sexe = "M";
	$scope.monInteret = "";
	
    $http.get('/api/interet').success(function(data) {
        $scope.interets = data;
    });
    
    $scope.rechercher = function () {
    	console.log($scope.sexe);
    	console.log($scope.monInteret);
    };
});