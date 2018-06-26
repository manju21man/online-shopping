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
		
	default:
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
	    break;
	}
	
	
	// code for jquery data tables
	// create a dataset
	
	var products = [
	              	['1','ABC'],
	              	['2','DEF'],
	              	['3','GHI'],
	              	['4','JKL'],
	              	['5','MNO'],
	              	['6','PQR'],
	              	['7','STU'],
	              	['8','VWX'],
	              	['9','YZ'],
	              
	              ];
	
	var $table = $('#productListTable');
	
	// execute the below table only where we have this table
	
	if($table.length){
		console.log('Inside the table!');
		
		$table.DataTable({
			lengthMenu : [[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			pageLength : 5,
			data : products
		});
	}
}); 