<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="contract-list-section">
    <div class="container">
        <div class="mt-5 mb-5">
            <h3>Umowy</h3>
            <p class="mt-3">
                W przypadku pustej bazy umów, dodaj przynajmniej jedną nową umowę.
            </p>
            <p class="mb-5">
                Po zdefiniowaniu umowy możesz dodać kolejną, edytować lub usunuąć istniejące umowy.
            </p>
            <table id="contracts" class="display">
                <thead>
                <tr>
                    <th>Numer umowy</th>
                    <th>Od</th>
                    <th>Do</th>
                    <th>Wpływy</th>
                    <th>W skali</th>
                    <th>Aktywna</th>
                    <th>Nazwa systemu</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="contract" items="${contracts}">

                        <c:url var="contractUpdateLink" value="/contract/update">
                            <c:param name="contractId" value="${contract.id}" />
                        </c:url>
                        <c:url var="contractDeleteLink" value="/contract/delete">
                            <c:param name="contractId" value="${contract.id}" />
                        </c:url>
                        <tr>
                            <td>${contract.contractNumber}</td>
                            <td>${contract.startDate}</td>
                            <td>${contract.endDate}</td>
                            <td>${contract.amount}</td>
                            <td>${contract.billingPeriod}</td>
                            <td>${contract.active}</td>
                            <td>${contract.system.name}</td>
                            <td><a href="${contractUpdateLink}" class="btn btn-warning">Edytuj</a></td>
                            <td><a href="${contractDeleteLink}" class="btn btn-danger" on>Usuń</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<section id="add-contract-section">
    <div class="container">
        <a href="/contract/add" class="btn btn-success btn-block">Dodaj nową umowę</a>
    </div>
</section>