var cartApp = angular.module ("cartApp", [])
    .config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.headers.common[header] = token;
    }]);

cartApp.controller("cartCtrl", function($scope, $http){
   $scope.refreshCart = function(cartId) {
       $http.get("/rest/cart/" + $scope.cartId).success(function (data) {
           $scope.cart = data;
       });
   }

   $scope.clearCart = function() {
       // $http.delete("/rest/cart/" + $scope.cartId).success($scope.refreshCart($scope.cartId));
       $http.delete("/rest/cart/" + $scope.cartId).success(function (data) {
           $scope.refreshCart($http.get("/rest/cart/" + $scope.cartId));
       });
   }

   $scope.initCartId = function (cartId) {
       $scope.cartId = cartId;
       $scope.refreshCart(cartId);
   }

    $scope.addToCart = function (productId) {
       $http.put("/rest/cart/add/" + productId).success(function (data) {
           $scope.refreshCart($http.get("/rest/cart/" + $scope.cartId));
           alert("Product successfully added to the cart!");
       })
    };

    $scope.removeFromCart = function (productId) {
        $http.put("/rest/cart/remove" + productId).success(function (data){
            $scope.refreshCart($http.get("/rest/cart/" + $scope.cartId));
        })
    };
});