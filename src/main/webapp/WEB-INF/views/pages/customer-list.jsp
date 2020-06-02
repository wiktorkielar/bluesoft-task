<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="customer-list-section">
    <div class="container">
        <div class="mt-5 mb-5">
            <h3>Klienci</h3>
            <p class="mt-3">
                W przypadku pustej bazy klientów, dodaj przynajmniej jednego nowego klienta.
            </p>
            <p class="mb-5">
                Po zdefiniowaniu klientów przejdź do zakładki "Systemy".
            </p>
            <table id="customers" class="display">
                <thead>
                <tr>
                    <th>Nazwa klienta</th>
                    <th>NIP</th>
                    <th>Ulica</th>
                    <th>Kod Pocztowy</th>
                    <th>Miasto</th>
                    <th>Kraj</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.name}</td>
                        <td>${customer.nip}</td>
                        <td>${customer.streetName}</td>
                        <td>${customer.postalCode}</td>
                        <td>${customer.city}</td>
                        <td>${customer.country}</td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</section>
<section id="customer-add-button">
    <div class="container">
        <a href="/customer/add" class="btn btn-success btn-block">Dodaj nowego klienta</a>
    </div>
</section>