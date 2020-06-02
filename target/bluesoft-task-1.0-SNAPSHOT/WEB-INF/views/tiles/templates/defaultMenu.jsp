<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark p-0">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav">
                <c:set var="uri" value="${requestScope['javax.servlet.forward.request_uri']}"/>
                <li class="nav-item px-2 ${uri eq '/contract/list/active' ? ' active' : ''}">
                    <a href="/contract/list/active" class="nav-link">Aktywne umowy</a>
                </li>
                <li class="nav-item px-2 ${uri eq '/contract/list' ? ' active' : ''}">
                    <a href="/contract/list" class="nav-link">Wszystkie umowy</a>
                </li>
                    <li class="nav-item px-2 ${uri eq '/system/list' ? ' active' : ''}">
                    <a href="/system/list" class="nav-link">Systemy</a>
                </li>
                    <li class="nav-item px-2 ${uri eq '/customer/list' ? ' active' : ''}">
                    <a href="/customer/list" class="nav-link">Klienci</a>
                </li>
                    <li class="nav-item px-2 ${uri eq '/about' ? ' active' : ''}">
                    <a href="/about" class="nav-link">O aplikacji</a>
                </li>
            </ul>
        </div>
    </div>
</nav>