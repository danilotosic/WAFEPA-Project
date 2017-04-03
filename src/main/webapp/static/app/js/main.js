var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

/*
        APLIKACIJA BIBLIOTEKA
*/

// BIBLIOTEKA CONTROLLER
wafepaApp.controller('bibliotekaCtrl', function($scope, $http, $location){

$scope.brojacStranice = 0;

var getBooks = function(){

    var config = {'params':{'page':$scope.brojacStranice}};

    if($scope.form && $scope.form.select && $scope.form.input){
        if($scope.form.select == "name") {
            config.params.name = $scope.form.input;
        } else {
            config.params.isbn = $scope.form.input;
        }
    }

    $http.get('/api/books', config).then(function(resp){
        $scope.books = resp.data;
        $scope.totalPages = Number(resp.headers().totalpages);
        console.log($scope.totalPages);
    });
};

    getBooks();

$scope.editBook = function(book) {
    $location.path('/book/'+book.bookID);
}

$scope.deleteBook = function(bookID) {
    $http.delete('/api/books/'+bookID).then(getBooks);
};

$scope.changePage = function(i) {
    if($scope.brojacStranice >= 0) {
        $scope.brojacStranice += i;
    }
    getBooks();
};

$scope.search = getBooks;

});

// BOOK CONTROLLER
wafepaApp.controller('bookCtrl', function($scope, $http, $location, $routeParams){

    var getBook = function(){
        $http.get('/api/books/'+$routeParams.id).then(function(resp){
            $scope.book = resp.data;
        });
    };

    var getIterableAuthors = function(){
        $http.get('/api/authors').then(function(resp){
            $scope.iterAuthors = resp.data;
        });
    };

        getBook();
        getIterableAuthors();

});


/*
        APLIKACIJA FUDBALSKI SAVEZ
*/

// CLUBS CONTROLLER
wafepaApp.controller('clubsCtrl', function($scope, $http, $location){

    // BROJAC STRANICE
    $scope.brojacStranice = 0;

    // INICIJALNO PRAZAN CLUB OBJEKAT
    $scope.club = {
        "name":"",
        "players":[],
    };

    var ucitajKlubove = function(){

        // CONFIG OBJEKAT MORA BITI UNUTAR FUNKCIJE
        var config = {'params':{'page':$scope.brojacStranice}};

        if($scope.findClub && $scope.findClub.name) {
            config.params.name = $scope.findClub.name;
        }

        $http.get('/api/clubs', config).then(function(resp){
            $scope.clubs = resp.data;
            $scope.totalPages = Number(resp.headers().totalpages);
            console.log($scope.totalPages);
        });

    };

    ucitajKlubove();

    $scope.changePage = function(i) {
        if($scope.brojacStranice >= 0) {
            $scope.brojacStranice += i;
        }
        ucitajKlubove();
    };

    $scope.createClub = function() {
        $http.post('/api/clubs', $scope.club).then(ucitajKlubove);
    };

    $scope.editClub = function(club) {
        $location.path('/club/'+club.clubID);
    };

    $scope.deleteClub = function(id) {
        $http.delete('/api/clubs/'+id).then(ucitajKlubove);
    };

    $scope.search = ucitajKlubove;

});

// CLUB CONTROLLER
wafepaApp.controller('clubCtrl', function($scope, $http, $location, $routeParams){

    $scope.player = {
        "firstname":"",
        "lastname":"",
        "club":{}
    };

    var getClub = function() {
        $http.get('/api/clubs/'+$routeParams.id).then(function(resp){
            $scope.club = resp.data;
            $scope.brojIgraca = $scope.club.players.length;
            console.log($scope.brojIgraca);
        });
    };

    getClub();

    $scope.editClub = function(){
        $http.put('/api/clubs/'+$scope.club.clubID, $scope.club).then(getClub);
    };

    $scope.editPlayer = function(playerID) {
        $location.path('/player/'+playerID);
    };

    $scope.addPlayer = function(clubID) {
        $scope.player.club.clubID = clubID;
        $http.post('/api/players', $scope.player).then(function(){
            $scope.player = {};
            getClub();
        });
    };

    $scope.deletePlayer = function(id) {
        $http.delete('/api/players/'+id).then(getClub);
    };

});

// PLAYER CONTROLLER

wafepaApp.controller('playerCtrl', function($scope, $http, $location, $routeParams){

    var getPlayer = function(){
        $http.get('/api/players/'+$routeParams.id).then(function(resp){
            $scope.player = resp.data;
        });
    };

    getPlayer();

    $scope.editPlayer = function(){
        $http.put('/api/players/'+$scope.player.playerID, $scope.player).then(function(){
            $location.path('/club/'+$scope.player.club.clubID);
        });
    };

    $scope.cancel = function (){
        $location.path('/club/'+$scope.player.club.clubID);
    };

});


/*
    
     ---------------- FRONT-END ZAVRSNI TEST --------------------

*/

// ZA NEKRETNINE
wafepaApp.controller('nekretnineCtrl', function($scope, $http, $location){

    $scope.brojacStranice = 0;

    var ucitajNekretnine = function(){

        var config = {'params':{'page':$scope.brojacStranice}};

        $http.get('/api/nekretnine', config).then(function(resp){
            $scope.nekretnine = resp.data;
            $scope.totalPages = Number(resp.headers().totalpages);
        });
    };

    ucitajNekretnine();

    $scope.obrisi = function(id) {
        $http.delete('/api/nekretnine/'+id).then(ucitajNekretnine);
    };

    $scope.izmeni = function(nekretnina) {
        $scope.nekretnina = nekretnina;
        ucitajNekretnine();
    };

    $scope.sacuvaj = function(nekretnina) {
        $http.put('/api/nekretnine/'+$scope.nekretnina.nekretninaID, $scope.nekretnina).then(function(){
            $scope.nekretnina = {};
        });
        ucitajNekretnine();
    };

    $scope.izmeniNaStrani = function(id) {
        $location.path('/nekretnina/'+ id);
    };

        $scope.changePage = function(i) {
        if($scope.brojacStranice >= 0) {
            $scope.brojacStranice += i;
        }
        ucitajNekretnine();
    };
 
});

wafepaApp.controller('nekretninaCtrl', function($scope, $http, $location, $routeParams){

    var ucitajNekretninu = function(){
        $http.get('/api/nekretnine/'+$routeParams.id).then(function(resp){
            $scope.nekretnina = resp.data;
        });
    };

    ucitajNekretninu();

});



/*
        WAFEPA CONFIGURATION
*/

wafepaApp.config(function($routeProvider) {
    $routeProvider
        //http://localhost:8080/static/app/html/index.html/#!/
        .when("/", {
          templateUrl : '/static/app/html/partials/home.html'
        })
        .when("/nekretnine", {
          templateUrl : '/static/app/html/partials/nekretnine.html'
        })
        .when("/nekretnina/:id", {
          templateUrl : '/static/app/html/partials/nekretnina.html'
        })
        .when("/clubs", {
          templateUrl : '/static/app/html/partials/clubs.html'
        })
        .when("/club/:id", {
          templateUrl : '/static/app/html/partials/club.html'
        })
        .when("/player/:id", {
          templateUrl : '/static/app/html/partials/player.html'
        })
        .when("/biblioteka", {
          templateUrl : '/static/app/html/partials/biblioteka.html'
        })
        .when("/book/:id", {
          templateUrl : '/static/app/html/partials/book.html'
        })
        //http://localhost:8080/static/app/html/index.html/#!/activities
        .when('/activities', {
         templateUrl : '/static/app/html/partials/activities.html'
       })
        //http://localhost:8080/static/app/html/index.html/#!/activity
        .when('/activity/:id', {
         templateUrl : '/static/app/html/partials/activity.html'
       })
        //sve ostalo radi redirekciju na
        //http://localhost:8080/static/app/html/index.html/#!/
        .otherwise({
         redirectTo: '/'
       });
});
