<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<custom:layout title="Home" >
    <jsp:attribute name="content">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Student Management System <a class="btn btn-success" style="float:right" href="<c:url value="/students/create"/>">Add New Student</a></h1>
        <br>
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Students</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Grade</th>
                                <th>Roll Number</th>
                                <th>Date of Birth</th>
                                <th>Address</th>
                                <th>Gender</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.name}</td>
                                    <td>${student.grade}</td>
                                    <td>${student.rollNumber}</td>
                                    <td>${student.dateOfBirth}</td>
                                    <td>${student.address}</td>
                                    <td>${student.gender}</td>
                                    <td>
                                        <a class="btn btn-primary" href="<c:url value="/students/edit/${student.id}"/>">Edit</a>
                                        <a class="btn btn-danger" href="<c:url value="/students/delete/${student.id}"/>">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:attribute>
</custom:layout>