<div ng-controller="sidebarCtrl" class="sidebar ">
    <a href="#" class="list-group-item">
        <i class="fa fa-comment-o"></i>
        <span class="glyphicon glyphicon-bell"></span>
        News
    </a>
    <a href="#/myBooks" class="list-group-item">
        <span class="glyphicon glyphicon-heart-empty"></span>
        Mybooks
    </a>
    <a href="#" class="list-group-item">
        <i class="fa fa-user"></i>
        <span class="glyphicon glyphicon-ok"></span>
        History
    </a>
    <br/>
    <a href="#/foundBook" class="list-group-item found-book-btn" ng-if="!showFoundBook">
        <i class="fa fa-user"></i>
        <span class="glyphicon glyphicon-search"></span>
        Found a book?
    </a>
</div>
