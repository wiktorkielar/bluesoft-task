<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section id="system-add-section">
    <div class="container">
        <div class="mt-5 mb-5">
            <h3>Dodaj system</h3>
            <p class="mt-3 mb-5">
                Uzupełnij wszystkie pola aby dodać nowy system.
            </p>
            <form:form action="/system/save" modelAttribute="system" method="POST">
                <div class="form-group">
                    <label for="systemName">Nazwa systemu</label>
                    <form:input path="name" type="text" class="form-control" id="systemName"
                                placeholder="Podaj nazwę systemu"/>
                    <br>
                    <form:errors path="name" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="systemDescription">Opis</label>
                    <form:input path="description" type="text" class="form-control" id="systemDescription"
                                placeholder="Podaj opis systemu"/>
                    <br>
                    <form:errors path="description" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="systemTechnologies">Technologie</label>
                    <form:input path="technologies" type="text" class="form-control" id="systemTechnologies"
                                placeholder="Podaj technologie"/>
                    <br>
                    <form:errors path="technologies" cssClass="alert alert-danger"/>
                </div>
                <div class="form-group">
                    <label for="systemCustomer">Klient</label>
                    <form:select path="customer.id" class="form-control" id="systemCustomer">
<%--                        <form:options items="${customers}" itemValue="id" itemLabel="name"></form:options>--%>
                        <c:forEach items="${customers}" var="theCustomer">
                            <form:option value="${theCustomer.id}">${theCustomer.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <br>
                </div>
                <input type="submit" class="btn btn-success btn-block" value="Zapisz">
            </form:form>
        </div>
    </div>
</section>