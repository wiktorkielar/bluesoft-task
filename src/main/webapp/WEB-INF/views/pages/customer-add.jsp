<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section id="customer-add-section">
    <div class="container">
        <div class="mt-5 mb-5">
            <h3>Dodaj klienta</h3>
            <p class="mt-3 mb-5">
                Uzupełnij wszystkie pola aby dodać nowego klienta.
            </p>
            <form:form action="/customer/save" modelAttribute="customer" method="POST">
                <div class="form-group">
                    <label for="customerName">Nazwa klienta</label>
                    <form:input path="name" type="text" class="form-control" id="customerName"
                                placeholder="Podaj nazwę klienta"/>
                    <br>
                    <form:errors path="name" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="customerNip">Numer NIP</label>
                    <form:input path="nip" type="text" class="form-control" id="customerNip"
                                placeholder="Podaj numer NIP"/>
                    <br>
                    <form:errors path="nip" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="customerStreetName">Ulica</label>
                    <form:input path="streetName" type="text" class="form-control" id="customerStreetName"
                                placeholder="Podaj ulicę i numer domu"/>
                    <br>
                    <form:errors path="streetName" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="customerPostalCode">Kod Pocztowy</label>
                    <form:input path="postalCode" type="text" class="form-control" id="customerPostalCode"
                                placeholder="Podaj kod pocztowy"/>
                    <br>
                    <form:errors path="postalCode" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="customerCity">Miasto</label>
                    <form:input path="city" type="text" class="form-control" id="customerCity"
                                placeholder="Podaj miasto"/>
                    <br>
                    <form:errors path="city" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="customerCountry">Kraj</label>
                    <form:input path="country" type="text" class="form-control" id="customerCountry"
                                placeholder="Podaj kraj"/>
                    <br>
                    <form:errors path="country" cssClass="alert alert-danger"/>
                </div>
                <input type="submit" class="btn btn-success btn-block" value="Zapisz">
            </form:form>
        </div>
    </div>
</section>