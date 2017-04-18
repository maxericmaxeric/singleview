function enquiry()
{	
	var userId = $("#useridHidden").html();
	$.ajax({
		type: "GET",
		async: false,
		url: "/DEPOSIT_INFO_SEARCH/getSearchResult/",
		data: {
			userid:userId,
			customer_code:$('#cust_code').val().trim(), 
			customer_full_name:$('#cust_name').val().trim(),
			identity_no:$('#id_no').val().trim(),
			dp_account_no:$('#acct_no').val().trim(),
			ln_account_no:$('#ref_no').val().trim()
		},
		dataType: "json",
		success: function(data){
			$('#enquiryTable').DataTable({
				"paging": true,
				"lengthChange": false,
				"searching": false,
				"ordering": true,
				"info": false,
				"autoWidth": false,
				"destroy":true,
				data:data,
				columns:[
					{data:'customer_code'},
					{data:'customer_full_name'},
					{data:'identity_no'}
				]						
			});
		},
		error: function(request) {
				alert("connect failed!");
			}
        });
}


$("body").delegate('#enquiryTable tbody tr', 'click', function () {
    window.location.href = "/user/singleView?customer_code="+$(this).find('td').eq(0).html();
    $('#project-enquiry').modal('toggle');
	// self.location="../User/SingleView.html";
});

$(window).scroll(function(){
	var y=$(window).scrollTop();
	//alert(y);
	if(y>50)
	{
		$("#tabMenu").css("position","fixed");
	}
	else
		$("#tabMenu").css("position","");
});
