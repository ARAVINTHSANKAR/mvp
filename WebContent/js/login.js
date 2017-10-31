var app = angular.module('myApp', []);
app.controller('formCtrl', function($scope,$http,$window) {
	
	$scope.login = function(username,pwd){
	var url = "http://localhost:8080/irctc/rest/booking/login?Email="+username+"&Password="+pwd;
	console.log("##-----url--",url)
	$http({
    	upload: {
            method: 'GET',
           
          },
	url: url
		}).then(function (response) {
			$scope.CurrentUser = JSON.parse(response.data);
			sessionStorage.setItem("CurrentUserName", $scope.CurrentUser.dbName);
			sessionStorage.setItem("CurrentUserId", $scope.CurrentUser.dbId);
			sessionStorage.setItem("CurrentUserEmail", $scope.CurrentUser.dbEmail);
			sessionStorage.setItem("CurrentUserPassword", $scope.CurrentUser.dbPassword);
			
/*			
			var CurrentUserName = sessionStorage.getItem("CurrentUserName");
			var CurrentUserId = sessionStorage.getItem("CurrentUserId");
			var CurrentUserEmail = sessionStorage.getItem("CurrentUserEmail");
			var CurrentUserPassword = sessionStorage.getItem("CurrentUserPassword");*/
		
		$scope.bool = JSON.parse(response.data);
		if($scope.bool.x == 0)
			{
			window.open("http://localhost:8080/irctc/searchTrain.html", "_blank");
			}
		else {
			$window.alert("wrong credentials");
		}
		console.log(response);
		}, function (response) {
			$window.alert("user not exist");
		});
	}
});