<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <jsp:include page="/WEB-INF/jsp/head.jsp" />

    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp" />

        <main>
            <div class="container mt-5">
                <h1>Student Management System <a class="btn btn-success pull-right" href="/schoolmanagement/students/create">Add Student</a></h1>
                <table class="table mt-4">
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
                                    <a class="btn btn-primary" href="/schoolmanagement/students/edit/${student.id}">Edit</a>
                                    <a class="btn btn-danger" href="/schoolmanagement/students/delete/${student.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
            </div>
        </main>

        <jsp:include page="/WEB-INF/jsp/footer.jsp" />
    </body>
</html>
