var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl'
      })
		.when('/mygeeks/:sexe/:id', {
        templateUrl: 'views/geeks.html',
        controller: 'GeeksCtrl'
      })
		.when('/geek/:id', {
        templateUrl: 'views/geek.html',
        controller: 'GeekCtrl'
      });
	});

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('HomeCtrl', function($scope, $http, $location) {
	$scope.interets = {};
	$scope.sexe = "M";
	$scope.monInteret = "";
	
	$scope.cacher = true;
		
    $http.get('/api/interet').success(function(data) {
        $scope.interets = data;
    });
    
    $scope.rechercher = function () {
    	if($scope.monInteret== ""){
    		$scope.cacher = false;
    	} else {
    		$scope.cacher = true;
    		$location.url("/mygeeks/"+$scope.sexe+'/'+$scope.monInteret.id);
    	}
    };
});

app.controller('GeeksCtrl', function($scope, $routeParams, $http, $location) {
	$scope.sexe = $routeParams.sexe;
	$scope.idInteret = $routeParams.id;
	$scope.geeks = {};
	$scope.cacher = true;
	$http.get('/api/geek/' + $scope.sexe + '/' + $scope.idInteret).success(function(data) {
        $scope.geeks = data;

        if(data.length == 0){
        	$scope.cacher = false;
        }else {
        	$scope.cacher = true;
        }
    });
	
	$scope.openGeek = function(id){
		$location.url("/geek/"+id);
	};
});

app.controller('GeekCtrl', function($scope, $routeParams, $http, $location) {
	$scope.geek = {};
	$scope.id = $routeParams.id;
	$http.get('/api/geek/'+$scope.id).success(function(data) {
        $scope.geek = data;
        $scope.geek.view += 1;
        $http.post('/api/geek/'+$scope.id+'/'+$scope.geek.view).success(function(data) {
    		console.log("gooood");
    	});
	});
	
	
	
});