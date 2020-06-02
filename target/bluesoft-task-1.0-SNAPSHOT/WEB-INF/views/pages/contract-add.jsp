<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="system-add-section">
    <div class="container">
        <div class="mt-5 mb-5">
            <h3>Dodaj umowę</h3>
            <p class="mt-3 mb-5">
                Uzupełnij wszystkie pola aby dodać nową umowę.
            </p>
            <form:form action="/contract/save-new" modelAttribute="contract" method="POST">
                <div class="form-group">
                    <label for="contractNumber">Numer kontraktu</label>
                    <form:input path="contractNumber" type="text" class="form-control" id="contractNumber"
                                placeholder="Podaj numer kontraktu"/>
                    <br>
                    <form:errors path="contractNumber" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="contractStartDate">Od</label>
                    <form:input path="startDate" type="date" class="form-control" id="contractStartDate"/>
                </div>
                <div class="form-group">
                    <label for="contractEndDate">Do</label>
                    <form:input path="endDate" type="date" class="form-control" id="contractEndDate"/>
                </div>
                <div class="form-group">
                    <label for="contractAmount">Kwota</label>
                    <form:input path="amount" type="number" class="form-control" id="contractAmount"/>
                </div>
                <div class="form-group">
                    <label for="contractBillingPeriod">Okres rozliczeniowy</label>
                    <form:input path="billingPeriod" type="text" class="form-control" id="contractBillingPeriod"/>
                    <br>
                    <form:errors path="billingPeriod" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="contractActive">Aktywny</label>
                    <form:select path="active" class="form-control" id="contractActive">
                        <form:option value="true">Tak</form:option>
                        <form:option value="false">Nie</form:option>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="contractSystem">Klient</label>
                    <form:select path="system.id" class="form-control" id="contractSystem">
                        <c:forEach items="${systems}" var="theSystem">
                            <form:option value="${theSystem.id}">${theSystem.name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <input type="submit" class="btn btn-success btn-block" value="Zapisz">
            </form:form>
        </div>
    </div>
</section>