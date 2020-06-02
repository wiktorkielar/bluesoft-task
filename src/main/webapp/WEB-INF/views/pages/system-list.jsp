<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section id="system-list-section">
    <div class="container">
        <div class="mt-5 mb-5">
            <h3>Systemy</h3>
            <p class="mt-3">
                W przypadku pustej bazy systemów, dodaj przynajmniej jeden nowy system.
            </p>
            <p class="mb-5">
                Po zdefiniowaniu systemów przejdź do zakładki "Aktywne umowy" lub "Wszystkie umowy".
            </p>
            <table id="systems" class="display">
                <thead>
                <tr>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Technologie</th>
                    <th>Klient</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="system" items="${systems}">
                    <tr>
                        <td>${system.name}</td>
                        <td>${system.description}</td>
                        <td>${system.technologies}</td>
                        <td>${system.customer.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<section id="system-add-button">
    <div class="container">
        <a href="/system/add" class="btn btn-success btn-block">Dodaj nowy system</a>
    </div>
</section>