<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="bookCrossing">
<head>
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>Bookcrossing</title>
    <link href="/resources/css/lib/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/lib/bootstrap-theme.css" rel="stylesheet"/>
    <link href="/resources/css/lib/angular-ui-notification.css" rel="stylesheet"/>
    <link href="/resources/css/main.css" rel="stylesheet"/>
    <link href="/resources/css/books.css" rel="stylesheet"/>
    <link href="/resources/css/sidebar.css" rel="stylesheet"/>
    <link href="/resources/css/navbar.css" rel="stylesheet"/>
    <link href="/resources/css/lib/ui-select.css" rel="stylesheet"/>
    <link href="/resources/css/exchange.css" rel="stylesheet"/>
    <link href="/resources/css/profile.css" rel="stylesheet"/>


</head>
<body>
<div class="container">
    <div ng-include src="'/resources/templates/nav.html'"></div>
    <div class="app-container">
        <div class="col-md-2 col-sm-12">
            <div ng-include src="'/resources/templates/sidebar.html'"></div>
        </div>
        <div class="col-md-10 col-sm-12">
            <div ng-view></div>
        </div>
    </div>
</div>
<script src="/resources/js/lib/angular.min.js"></script>
<script src="/resources/js/lib/angular-route.min.js"></script>
<script src="/resources/js/lib/angular-resource.js"></script>
<script src="/resources/js/lib/angular-animate.js"></script>
<script src="/resources/js/lib/ui-bootstrap.js"></script>
<script src="/resources/js/lib/ui-select.js"></script>
<script src="/resources/js/lib/angular-ui-notification.js"></script>

<script src="/resources/js/app.js"></script>
<script src="/resources/js/navbarCtrl.js"></script>
<script src="/resources/js/sidebarCtrl.js"></script>
<script src="/resources/js/Book/bookService.js"></script>
<script src="/resources/js/Book/bookCtrls.js"></script>
<script src="/resources/js/Book/transferService.js"></script>
<script src="/resources/js/profile/profileCtrl.js"></script>
<script src="/resources/js/profile/userTransfers.js"></script>
<script src="/resources/js/foundBook/foundBook.js"></script>
<script src="/resources/js/foundBook/foundBookCtrl.js"></script>
<script src="/resources/js/Genre/genre.js"></script>
<script src="/resources/js/User/currentUserService.js"></script>
<script src="/resources/js/Author/author.js"></script>
<script src="/resources/js/Exchange/exchangeCtrl.js"></script>
<script src="/resources/js/Exchange/exchangeService.js"></script>
<script src="/resources/js/Exchange/offersCartService.js"></script>
<script src="/resources/js/User/currentUserCtrl.js"></script>

</body>
</html>