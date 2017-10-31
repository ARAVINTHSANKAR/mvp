var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope,$http,$window) {
	$scope.trainData = [];
	$scope.selectedRow = null;
	$scope.getTrains = function getTrains(fromStation,toStation,journeyDate){
	var url = "http://localhost:8080/irctc/rest/booking/getTrainDetails?From="+fromStation+"&To="+toStation+"&Date="+journeyDate;
	console.log("##-----url--",url)
	$http({
    	upload: {
            method: 'GET',
           
          },
	url: url
		}).then(function (response) {
	if(response.status == 200)
			{
		$scope.trainData = response.data;
			$window.alert("fine");
			}
		else {
			$window.alert("fail");
		}
		console.log(response);
		}, function (response) {
			$window.alert("oops");
		});
	}
	
	   
	$scope.setClickedRow = function setClickedRow(index){
		$scope.selectedRow = index;
	}
	
	$scope.showVariable = false;
	$scope.firstAC = function firstAC() {
		$scope.firstAcAvailability = 50 - ($scope.trainData[$scope.selectedRow].oneA);
		$scope.showVariable = true;
	}
	
	$scope.showVariable = false;
	$scope.secondAC = function secondAC() {
		$scope.secondAcAvailability = 50 - ($scope.trainData[$scope.selectedRow].twoA);
		$scope.showVariable = true;
	}
	
	$scope.showVariable = false;
	$scope.thirdAC = function thirdAC() {
		$scope.thirdAcAvailability = 50 - ($scope.trainData[$scope.selectedRow].threeA);
		$scope.showVariable = true;
	}
	
	$scope.showVariable = false;
	$scope.Sleeper = function Sleeper() {
		$scope.sleeperAvailability = 50 - ($scope.trainData[$scope.selectedRow].sl);
		$scope.showVariable = true;
	}
	
	$scope.showTable = false;
	$scope.getTrains(fromStation,toStation,journeyDate) = function $scope.getTrains(fromStation,toStation,journeyDate) {
		$scope.showTable = true;
	}
});


/*//		$scope.firstAcAvailablity = [];
var url = "http://localhost:8080/irctc/rest/booking/getTrainDetails";
$http({
	upload: {
		method: 'GET',
	},
	url: url
}).then(function (response) {
	$window.alert("availability here");
}, function (response) {
	$window.alert("error in availability");
});*/
