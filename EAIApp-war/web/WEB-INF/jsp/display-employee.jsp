<%-- 
    Document   : display-employee
    Created on : Apr 4, 2018, 2:09:12 PM
    Author     : Syarif_H657
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Employee List</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row" style="margin-top: 30px">
                <div class="col-md-6 offset-4">
                    <nav class="navbar navbar-light bd-faded">
                        <h2>
                            <label class="text-sm-center">BEAN MANAGE TRANSACTION EXAMPLE</label>
                        </h2>
                    </nav>
                </div>
            </div>

            <div class="row" style="margin-top: 30px">
                <div class="col-md-6 offset-4">
                    <nav class="navbar navbar-light bd-faded">
                        <h3>
                            <label class="text-sm-center">Employee List</label>
                        </h3>
                    </nav>
                </div>
            </div>

            <div class="row" style="margin-top: 30px">
                <div class="col-md-8 offset-3">
                    <table BORDER=1 ALIGN="CENTER" class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th CLASS="TITLE">ID</th>
                                <th CLASS="TITLE">FIRSTNAME</th>
                                <th CLASS="TITLE">LASTNAME</th>
                                <th CLASS="TITLE">TITLE</th>
                                <th CLASS="TITLE">SALARY</th>
                                <th CLASS="TITLE">CREATED DATE</th>
                            </tr>
                        </thead>
                        <tbody>	
                        <c:forEach items="${employeeList}" var="employee">		
                            <tr>
                                <td>${employee.id}</td>
                                <td>${employee.name}</td>
                                <td>${employee.surname}</td>
                                <td>${employee.title}</td>
                                <td>${employee.salary}</td>
                                <td>${employee.created}</td>
                            </tr>
                        </c:forEach>			
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
