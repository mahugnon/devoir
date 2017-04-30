/**
 * Created by TECHNOPC on 26/04/2017.
 */
var app=angular.module('myApp',[]);

app.controller("myControlleur",function ($scope,$http) {
    $scope.auteurs={};
   $scope.motCle="";
    $scope.messages={};
    $scope.pageCourant=0;
    $scope.pageSize=3;
    $http.get("http://localhost:8080/messages?size="+$scope.pageSize+"&motCle="+$scope.motCle)
        .then(function (value) {
            $scope.messages=value.data.content;
            console.log(  $scope.messages)

        });
    $scope.message={
        "contenu":"",
        "auteurBean":{
            "email":""
        }
    };
$scope.plus=function () {
 $scope.pageSize=$scope.pageSize+10;
 $scope.findAllMessages();
}
   $scope.findAllMessages=function () {
       
       $http.get("http://localhost:8080/messages?size="+$scope.pageSize+"&motCle="+$scope.motCle)
           .then(function (value) {
         $scope.messages=value.data.content;
               console.log()
           });
      
   }

   $scope.Add = function (emp) {     
	    this.EmployeeObject = angular.copy(emp);
	    employees.push(this.EmployeeObject);
	    this.employee=null;
	    $scope.$setPristine(true);
	}

$scope.publier=function () {
	var msg=$scope.message;
    $http({
        method:"POST",
        url:"http://localhost:8080/messages",
        data:msg,
        headers:{'Content-Type':'application/json'}     })
        .then(function (value) {
        	  $scope.message.auteurBean.email="";
              $scope.message.contenu="";
              $scope.pageSize=3;
              $scope.findAllMessages();

        });
   
}

$scope.commentaires=null;
$scope.listeCommentaires=function(m){

	$http.get("http://localhost:8080/messages/"+m.idMessage+"/commentaires")
        .then(function (value) {
            $scope.commentaires=value.data;
        })
}
});