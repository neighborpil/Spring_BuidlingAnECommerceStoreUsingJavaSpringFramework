var cartApp = angular.module ("cartApp", [])
    .config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.headers.common[header] = token;
    }]);

cartApp.controller("cartCtrl", function($scope, $http){
   $scope.refreshCart = function() {
       $http.get("/rest/cart/" + $scope.cartId).success(function (data) {
           $scope.cart = data;
       });
   }

   $scope.clearCart = function() {
       // $http.delete("/rest/cart/" + $scope.cartId).success($scope.refreshCart($scope.cartId));
       $http.delete("/rest/cart/" + $scope.cartId).success(function () {
           $scope.refreshCart();
       });
   }

   $scope.initCartId = function (cartId) {
       $scope.cartId = cartId;
       $scope.refreshCart(cartId);
   }

    $scope.addToCart = function (productId) {
       $http.put("/rest/cart/add/" + productId).success(function () {
           alert("Product successfully added to the cart!");
       })
    };

    $scope.removeFromCart = function (productId) {
        $http.put("/rest/cart/remove" + productId).success(function (){
            $scope.refreshCart();
        })
    };

    $scope.callGrandTotal = function () {
        let grandTotal = 0;

        for (let i = 0; i < $scope.cart.cartItem.length; i++) {
            grandTotal += $scope.cart.cartItem[i].totalPrice
        }

        return grandTotal;
    };
});