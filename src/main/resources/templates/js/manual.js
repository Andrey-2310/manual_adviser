/**
 * Created by Андрей on 17.07.2017.
 */
function manualController($scope, $http) {
    $http.get('manual').
    success(function(data) {
        $scope.manuals = data;
    });
}