<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<br/><br/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="panel-group">
		<div class="panel panel-success">
			<div class="panel-heading text-center">
						<span style="font-size: 30px">Add Details</span>
			</div>
			<div class="panel-body table-responsive">
<ul class="nav nav-tabs nav-justified">
  <li class="active"><a data-toggle="tab" href="#product"><h3>Add Product</h3></a></li>
  <li><a data-toggle="tab" href="#category"><h3>Add Category</h3></a></li>
  <li><a data-toggle="tab" href="#supplier"><h3>Add Supplier</h3></a></li>
</ul>

<div class="tab-content">
  <div id="product" class="tab-pane fade in active">
    <br/>
   <div class="modal-body col-sm-offset-3 col-sm-6" style="border:5px solid pink">
		    <center><h2>Add Product</h2></center><br/>
			<h3>Product form goes here</h3>
      </div>
  </div>
  <div id="category" class="tab-pane fade">
  <br/>
   <div class="modal-body col-sm-offset-3 col-sm-6" style="border:5px solid pink">
		    <center><h2>Add Category</h2></center><br/>
			<form action="addCategory" method="post" class="form-inline">
			<label style="font-size: 20px">Enter Category Name : </label>
			<input name="name" class="form-control"/><br/><br/><br/>
			<button type="submit" class="btn btn-success btn-block">Add</button>
			</form>
      </div>
  </div>
  <div id="supplier" class="tab-pane fade">
<br/>
   <div class="modal-body col-sm-offset-3 col-sm-6" style="border:5px solid pink">
		    <center><h2>Add Supplier</h2></center><br/>
			<form action="addSupplier" method="post" class="form-inline">
			<label style="font-size: 20px">Enter Supplier Name : </label>
			<input name="name" class="form-control"/><br/><br/><br/>
			<button type="submit" class="btn btn-success btn-block">Add</button>
			</form>
      </div>
    </div>
</div>
			</div>
		</div>
	</div>
</div><br/><br/><br/><br/><br/><br/>
<%@include file="footer.jsp"%>
</body>
</html>