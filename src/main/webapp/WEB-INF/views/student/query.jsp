<%@include file="/WEB-INF/views/fragment/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="get" modelAttribute="studentSearchQuery"
			class="form-horizontal"
			action="${pageContext.request.contextPath}/searchquery">
			<div class="form-group">

				<div class="col-md-1">
					<form:label path="searchText" class="col-sm-2 control-label">Search</form:label>
				</div>

				<div class="col-md-6">
					<form:input path="searchText" name="searchInputText"
						class="form-control" placeholder="Enter value to search"></form:input>
				</div>
				

			</div>
		</form:form>
<%@include file="/WEB-INF/views/fragment/footer.jsp"%>