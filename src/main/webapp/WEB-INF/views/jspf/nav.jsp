<div class="navbar navbar-default navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="navbar-header">
        <img src="/resources/images/logo.gif" style="width: 30px; margin-top: 10px;"/>
        <div class="navbar-brand logo"><b>BookCrossing</b></div>
    </div>


    <div class="navbar-header pull-right" style="margin-top: -5px;">
        <div class="navbar-brand">
            Welcome,
            <span ng-bind="user.data.name"></span>!
            <a class="btn btn-default logout" href="/logout">Logout</a>
        </div>
    </div>
</div>
