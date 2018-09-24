<p class="lead">Shop Name</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products"
			class="list-group-item" id="a_${category.name}"> ${category.name}</a>
	</c:forEach>
</div>


<%-- <p class="lead">Shop Name</p>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<c:forEach items="${categories}" var="category">
				<li>
					<a href="${contextRoot}/show/category/${category.id}/products"
					 id="a_${category.name}"> ${category.name}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div> --%>