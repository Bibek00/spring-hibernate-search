
<%@include file="/WEB-INF/views/fragment/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container custom-container">
	<form:form method="get" modelAttribute="studentsearch"
		class="form-horizontal"
		action="${pageContext.request.contextPath}/search">
		<div class="form-group">

			<div class="col-md-1">
				<form:label path="searchText" class="col-sm-2 control-label">Search</form:label>
			</div>

			<div class="col-md-6">
				<form:input path="searchText" name="searchText" class="form-control"
					placeholder="Enter value to search"></form:input>
			</div>

			<div class=" col-md-5 pull-right">
				<a href="<c:url value = "studentform"/>">
					<button type="button" class="btn btn-success btn-md custom-padding">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						Add User
					</button> 
					</a>&nbsp;
			</div>
		</div>
	</form:form>

	<div class="custom-container"></div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact</th>
				<th>Country</th>
				<th>City</th>
				<th>Zip</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="studentinfo" items="${studentSearch}">
				<tr>
					<td><c:out value="${studentinfo.fname}" /></td>
					<td><c:out value="${studentinfo.lname}" /></td>
					<td><c:out value="${studentinfo.contact}" /></td>
					<td><c:out value="${studentinfo.address.city}" /></td>
					<td><c:out value="${studentinfo.address.country}" /></td>
					<td><c:out value="${studentinfo.address.zip}" /></td>
					<td width="18%"><a
						href="<c:url value = "/edit/${studentinfo.studentId}"/>"
						class="btn btn-fill btn-primary"> <span
							class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							Edit
					</a> <a href="<c:url value = "/delete/${studentinfo.studentId}"/>"
						class="btn btn-fill btn-danger btn-md"
						onclick="if (!confirm('Are you sure you want to delete?'))
                                                               return false;">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							Delete
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="/WEB-INF/views/fragment/footer.jsp"%>