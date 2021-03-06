$(function() {
	//solving the active menu problem
	switch(menu){

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;

	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
		
	case 'User cart':
		$('#userCart').addClass('active');
		break;

	default:
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
		}
	
	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0){
		// set token header for ajax request 
		$(document).ajaxSend(function(e, xhr, options){
		    xhr.setRequestHeader(header,token);
		});
	}
	
	
	// code for jquery data tables

	var $table = $('#productListTable');

	// execute the below table only where we have this table

	if($table.length){
		console.log('Inside the table!');

		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}

		$table.DataTable({
			lengthMenu : [[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			pageLength : 5,

			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
			           {
			        	   data : 'code',
			        	   mRender : function(data, type, row){
			        		   return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" />';
			        	   }
			           },
			           {
			        	   data : 'name'
			           },
			           {
			        	   data : 'brand'
			           },
			           {
			        	   data : 'unitPrice',
			        	   mRender : function( data, type, row){
			        		   return '&#8377;' + data;  // HTML entity symbol for Rupee symbol
			        	   }
			           },
			           {
			        	   data : 'quantity',
			        	   mRender : function(data, type, row){

			        		   if( data < 1 ){
			        			   return '<span style="color:red">Out of Stock!</span>';
			        		   }

			        		   return data;
			        	   }
			           },
			           {
			        	   data : 'id',
			        	   bSortable : false,
			        	   mRender : function(data, type, row){
			        		   var str = '';
			        		   str += '<a href="'+ window.contextRoot +'/show/'+data+'/product" class="btn btn-primary">'+
			        		   '<span class="glyphicon glyphicon-eye-open"></span></a> &#160; ';

			        		   if(userRole == 'ADMIN'){
			        			   str += '<a href="'+ window.contextRoot +'/manage/'+data+'/product" class="btn btn-warning">'+
			        			   '<span class="glyphicon glyphicon-pencil"></span></a>';
			        		   }else{
			        			   if( row.quantity < 1){
				        			   str += '<a href="javascript:void(0)" class="btn btn-success disabled">'+
				        			   '<span class="glyphicon glyphicon-shopping-cart"></span></a>';
				        		   } 
				        		   else{
				        				   str += '<a href="'+ window.contextRoot +'/cart/add/'+data+'/product" class="btn btn-success">'+
					        			   '<span class="glyphicon glyphicon-shopping-cart"></span></a>';
				        		   }
			        		   }
			        		  
			        		   return str;
			        	   }
			           }

			           ]


		});
	}

	// dismissing the alert after 3 seconds

	var $alert = $('.alert');

	if($alert.length){
		setTimeout( function(){
			$alert.fadeOut('slow');
		}, 3000)
	}

	
	// --------------------------------------------------
	// data table for admin
	// --------------------------------------------------

	var $AdminProductsTable = $('#adminProductsTable');

	// execute the below table only where we have this table

	if($AdminProductsTable.length){
		console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';


		$AdminProductsTable.DataTable({
			lengthMenu : [[10, 30, 50, -1],['10 Records','30 Records','50 Records','ALL']],
			pageLength : 30,

			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
			           {
			        	   data : 'id'
			           },
			           {
			        	   data : 'code',
			        	   mRender : function(data, type, row){
			        		   return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg" />';
			        	   }
			           },
			           {
			        	   data : 'name'
			           },
			           {
			        	   data : 'brand'
			           },
			           {
			        	   data : 'quantity',
			        	   mRender : function(data, type, row){

			        		   if( data < 1 ){
			        			   return '<span style="color:red">Out of Stock!</span>';
			        		   }

			        		   return data;
			        	   }
			           },
			           {
			        	   data : 'unitPrice',
			        	   mRender : function( data, type, row){
			        		   return '&#8377;' + data;  
			        	   }
			           },
			           {
			        	   data : 'active',
			        	   bSortable : false,
			        	   mRender : function(data, type, row){
			        		   var str = '';

			        		   str += '<label class="switch">' ;
			        		   if(data){
			        			   str += '<input type="checkbox" checked="checked" value="'+ row.id+'">';
			        		   }
			        		   else {
			        			   str += '<input type="checkbox"  value="'+ row.id+'">';
			        		   }
			        		   str += '<div class="slider round"></div>';

			        		   return str;
			        	   }
			           },
			           {
			        	   data : 'id',
			        	   bSortable : false,
			        	   mRender : function(data, type, row){
			        		   var str = '';

			        		   str += '<a href="'+ window.contextRoot +'/manage/'+data+'/product" class="btn btn-warning">' ;
			        		   str += '<span class="glyphicon glyphicon-pencil"></span></a>' ;

			        		   return str;
			        	   }
			           }

			           ],

			           initComplete : function() {

			        	   var api = this.api();
			        	   api.$('.switch input[type="checkbox"]').on('change', function() {

			        		   var checkbox = $(this);
			        		   var checked = checkbox.prop('checked');
			        		   var dMsg = (checked) ? 'You want to activate the product?':
			        			   'You want to deactivate the product?';
			        		   var value = checkbox.prop('value');

			        		   bootbox.confirm({
			        			   size : 'medium',
			        			   title : 'Product Activation and Deactivation',
			        			   message: dMsg,

			        			   callback: function(confirmed){
			        				   if(confirmed){
			        					   console.log(value);

			        					   var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';

			        					   $.post(activationUrl, function(data) {
			        						   bootbox.alert({
			        							   size:'medium',
			        							   title:'Information',
			        							   message:data
			        						   });   
			        					   });

			        				   }
			        				   else{
			        					   checkbox.prop('checked', !checked);
			        				   }
			        			   }
			        		   });

			        	   });
			           }
		});
	}
	
	// --------------------------------------------------------
	// Validation code for category
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		
		$categoryForm.validate({
			
			rules : {
				name : {
					required: true,
					minlength: 2
				},
				description: {
					required: true
				}
			},

			messages : {
				name : {
					required: 'Please add the category name!',
					minlength: 'The Category name should not be less than 2 characters'
				},
				description: {
					required: 'Please add a description for this category!'
				}
			},
			
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});
	}
	
	// ------------------------------------------------------------------
	
	/*var $manageForm = $('#manageForm');
	$(function() {
		$manageForm.keyup(function() {

			$manageForm.each(function() {
				if (('#name').val() == '') {
					$('#submit').attr('disabled', 'disabled');
				}else{
					$('#submit').removeAttr('disabled');
				}
			});

			$('#file').change(function() {
				if ($(this).val() == '') {
					$('#submit').attr('disabled', 'disabled');
				}else {
					$('#submit').removeAttr('disabled');
				}
			});

			$('#categoryId').change(optionFormEnabled);
				function optionFormEnabled() {
					if ($('#categoryId').val() == '') {
						$('#submit').attr('disabled', 'disabled');
					} else {
						$('#submit').removeAttr('disabled');
					}
				}

		});
	})
	*/

	/* Manage products submit would be inactive till all form fields have been filled */
	
	$('#name, #brand, #description, #unitPrice, #quantity').bind('keyup',
			function() {
				if (allFilled())
					$('#submit').removeAttr('disabled');
			});

	function allFilled() {
		var filled = true;
		$('body input').each(function() {
			if ($(this).val() == '')
				filled = false;
		});
		return filled;
	}
	
	$('#file').change(function() {
		if ($(this).val() == '') {
			$('#submit').attr('disabled', 'disabled');
		}else {
			$('#submit').removeAttr('disabled');
		}
	});

	$('#categoryId').change(function() {
		if ($('#categoryId').val() != '') {
			$('#submit').removeAttr('disabled');
		} 
	});
	
	//-----------------------------------------------------------------------
	
// Validation code for LoginForm
	
	var $loginForm = $('#loginForm');
	
	if($loginForm.length){
		
		$loginForm.validate({
			
			rules : {
				username : {
					required: true,
					email: true
				},
				password: {
					required: true
				}
			},

			messages : {
				username : {
					required: 'Please enter the username!',
					email: 'Please enter valid email address!'
				},
				password: {
					required: 'Please enter the password!'
				}
			},
			
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});
	}
			
}); 