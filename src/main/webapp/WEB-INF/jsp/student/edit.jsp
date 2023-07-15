<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<custom:layout title="Student" >
    <jsp:attribute name="content">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Edit Student</h6>
            </div>
            <div class="card-body">
                <form action="<c:url value="/students/edit/${student.id}"/>" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" value="${student.name}" required>
                    </div>
                    <div class="form-group">
                        <label for="grade">Grade:</label>
                        <input type="number" class="form-control" id="grade" name="grade" value="${student.grade}" required>
                    </div>
                    <div class="form-group">
                        <label for="rollNumber">Roll Number:</label>
                        <input type="number" class="form-control" id="rollNumber" name="rollNumber" value="${student.rollNumber}" required>
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirth">Date of Birth:</label>
                        <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" value="${student.dateOfBirth}" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" class="form-control" id="address" name="address" value="${student.address}" required>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <select class="form-control" id="gender" name="gender" required>
                            <option value="Male" ${student.gender == 'Male' ? 'selected' : ''}>Male</option>
                            <option value="Female" ${student.gender == 'Female' ? 'selected' : ''}>Female</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Update</button>
                </form>
            </div>
        </div>
    </jsp:attribute>
</custom:layout>