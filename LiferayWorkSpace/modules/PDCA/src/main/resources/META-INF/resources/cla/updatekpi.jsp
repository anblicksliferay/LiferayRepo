<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/cla/init.jsp" %>

<portlet:resourceURL var="listURL"/>
<portlet:actionURL var="deleteProfile" name="deleteProfile"/>
<portlet:actionURL var="editProfile" name="editProfile"/>


<div class="row">
<div class="col-md-2">
<portlet:actionURL var="addKpi" name="addKpi"/>
<form name="addKpi" id="addKpi" action="<%=addKpi.toString() %>" method="post" name="update">
<button class="btn-success">Add New Data</button>
</form>
</div>

<div class="col-md-2">
<portlet:actionURL var="getfile" name="getfile"/>
<form name="getfileFrom" id="getfileFrom" action="<%=getfile.toString() %>" method="post" name="update">
<button   class="btn-success">Get Kpi Data</button>
</form> 
</div>

<div class="col-md-2">
<portlet:actionURL var="getpdffile" name="getpdffile"/>
<form name="getpdffileFrom" id="getpdffileFrom" action="<%=getpdffile.toString() %>" method="post" name="update">
<button   class="btn-success">Get Kpi Pdf Data</button>
</form> 
</div>
</div>



<%
String kpidevData= (String) request.getAttribute("update_kpi_json");
%>
<form name="deleteForm" id="deleteForm" action="<%=deleteProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>userid" name="<portlet:namespace/>userid"/>
</form>
<form name="editForm" id="editForm" action="<%=editProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>editid" name="<portlet:namespace/>editid"/>
</form>
<div id="confirmDelete_Admin" style="background-color:#ffffff;  height: 15px; display: none;">
				<p style="margin: -9px 0 10px;" >Confirm Delete</p>
			</div> 
			 <button type="button" class="btn btn-info" onclick="renderaddkpiPage('addkpi')">Add New Data</button>
			 <div class="new-buttons-area"></div>
 <ul class="nav nav-tabs">
    <li class="active dev"><a data-toggle="tab" href="#home" onclick="drawDataTable('dev');">Development</a></li>
    <li class="dev"><a data-toggle="tab" href="#menu1" onclick="drawDataTable('OL1Achivement');" >  &nbsp;&nbsp; &nbsp;OL 1 &nbsp;&nbsp; &nbsp;  </a></li>
    <li class="dev"><a data-toggle="tab" href="#menu2" onclick="drawDataTable('OL2Achivement');" >  &nbsp;&nbsp; &nbsp;OL 2 &nbsp; &nbsp; &nbsp; </a></li>
    <li class="dev" ><a data-toggle="tab" href="#menu3" onclick="drawDataTable('OL2AdjAchivement');" > &nbsp; &nbsp; OL Adjusted &nbsp; &nbsp;</a></li>
    <li class="dev" ><a data-toggle="tab" href="#menu3" onclick="drawDataTable('OL3Achivement');" >  &nbsp; &nbsp; &nbsp;OL 3 &nbsp; &nbsp; &nbsp; </a></li>
    <li class="dev" ><a data-toggle="tab" href="#menu3" onclick="drawDataTable('FYAchivement');" > &nbsp; &nbsp; &nbsp; Full Year &nbsp; &nbsp; &nbsp; </a></li>
   
 <div class="new-search-area"></div>
  </ul>


 <table class="devDataTablePhycial" class="table-responsive  table-bordered table-hover" cellspacing="0" width="100%">
			  <thead>
		        <tr>
		        <!-- Dev columns -->
		            <th>Type</th>
		            <th>Item Des</th>
		            <th>Unit</th>
		            <th>Target</th>
		            <th>Weight</th>
		            <th>Achivement F</th>
		             <th>YTD</th>
		             <th>OL 1 FY</th>
		             <th>OL 2 FY</th>
		             <th>OL Adj.</th>
		              <th>OL3 FY</th>
		              <th>OL FY</th>
		              <th>Achivement</th>
		              <th>CLA Point</th>
		             <th></th>
		        </tr>
</table>

<script>
var kpidevJson=<%=kpidevData%>;
var devDataGrid=null;

	  devDataGrid = $('.devDataTablePhycial').DataTable( {
		  initComplete : function() {
		        $("#DataTables_Table_0_filter").detach().appendTo('.new-buttons-area');
		        $(".dt-buttons").detach().appendTo('.new-search-area');
		             
		    }, 
		    dom: 'lBfrtip',
		  // "showNEntries" : false,
		   "bInfo" : false,
		    buttons: [
        	  { className:'button',
                  extend: 'print',
                  exportOptions: {
                	  columns: [0, 1, 2, 3, 4,5, 6]
                  }
              },
            { className:'button',
                extend: 'copyHtml5',
                exportOptions: {
                    columns: [0, 1, 2, 3, 4,5]
                }
            },
            { className:'button',
                extend: 'csvHtml5',

                	 exportOptions: {
                         columns: [ 0, 1, 2, 3, 4,5 ,6,7]
                     }
            },
            {   className:'button',
                extend: 'pdfHtml5',
                exportOptions: {
                    columns: [ 0, 1, 2, 3, 4,5 ,6,7]
                }
            }
          
        ],
		  searching: false,
		   "bLengthChange": false,
		  order: [[0, 'desc'] ],
		  "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50,100, "All"]],  
        orderCellsTop: true,
        data:kpidevJson.kpi_Data, 
	    columns: [
		{ data: "type" },
		{ data: "itemDec" },
		{ data: "unit"},
		{ data: "target" },
		{ data: "weight" },
		{ data: "achivementformula" },
		{ data: "YTD" },
		{ data: "OL1FY" },
		{ data: "OL2FY" },
		{ data: "OLAdj" },
		{ data: "OL3FY" },
		{ data: "OLFY" },
		{ data: "Achivement" },
		{ data: "CLAPoint" },
		{	
			title:			'',
			orderable:		true,
			data:			null, //editbutton  deleteButton
		defaultContent: '<span class=" glyphicon glyphicon-edit editbutton" style="cursor: pointer;"> </span>   <span class="glyphicon glyphicon-trash deleteButton" style="cursor: pointer;"></span>'
		}
		],
		
		columnDefs: [{
			targets: 0,
			type: "type"},
		
			{targets: 1,
				type: "itemDec"},
				
				{   targets: 2,
					type: "unit"
				},
					{
						targets: 3,
						type: "target"
						},
						{   targets: 4,
							type: "weight"
							},
							
							{   targets: 5,
								type: "achivementformula" 
								},
								{   targets: 6,
									type: "YTD" 
									},
									{   targets: 7,
										type: "OL1FY" 
										},
										{   targets: 8,
											type: "OL2FY" 
											},
						
						
						
								
						{   targets: 9,
											type: "OLAdj" 
											},
						
						
							{   targets: 10,
											type: "OL3FY" 
											},
						
							{   targets: 11,
											type: "OLFY" 
											},
										{   targets: 12,
											type: "Achivement" 
											},
											{   targets: 13,
												type: "CLAPoint" 
												},
												
							{   targets: 14,
									type: "" ,
									 "searchable": false,
									 'sortable': false,
									 "orderable": false
									}
		]
    
	});	
	    devDataGrid.column(6).visible(false);
	    devDataGrid.column(7).visible(false); //1
	    devDataGrid.column(8).visible(false); //2
	    devDataGrid.column(9).visible(false);//adj
	    devDataGrid.column(10).visible(false);// 3
	    devDataGrid.column(11).visible(false);// fy
	    devDataGrid.column(12).visible(false);
	    devDataGrid.column(13).visible(false);
	  $('.devDataTablePhycial').addClass("table-bordered");
	  $('.devDataTablePhycial tbody').on( 'click', '.editbutton', function () {
	        var data = devDataGrid.row( $(this).parents('tr') ).data();
	        console.log("edit");
	        console.log(data.kpiId);
	        $('#<portlet:namespace/>editid').val(data.kpiId);
	       // window.location.href = 'cla';
	    //	$('#editForm').submit();
	    } );
     $('.devDataTablePhycial tbody').on( 'click', '.deleteButton', function () {
	   var data = devDataGrid.row( $(this).parents('tr') ).data();
	   console.log("deleteButton");
		        console.log(data);	 
		    	$('#<portlet:namespace/>userid').val(data.kpiId);
		         console.log("opening dialog"); 
		    	$( "#confirmDelete_Admin" ).dialog( "open" );
		});
     $("#confirmDelete_Admin").dialog({
 		height:'130',
 		width:'250',
 		modal: true,
 		autoOpen: false,
 		draggable: false,
 	buttons: {
 		"Delete": function() {
 			$( this ).dialog( "close" );
 			$('#deleteForm').submit();
 		},
 		"Cancel": function() {
 			$( this ).dialog( "close" );
 		},
 	}
 	});
     
      
function drawDataTable(val) {
	var cmd = 'list';
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: cmd,
				<portlet:namespace />cmdType: val,
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
	
		//	console.log(data.kpi_Data[0].period);
			var periodString=data.kpi_Data[0].period;
			if(periodString == "dev")
    	{  
		devDataGrid.column(6).visible(false);
		devDataGrid.column(7).visible(false); //1
	    devDataGrid.column(8).visible(false); //2
	    devDataGrid.column(9).visible(false);//adj
	    devDataGrid.column(10).visible(false);// 3
	    devDataGrid.column(11).visible(false);// fy
	    devDataGrid.column(12).visible(false);
	    devDataGrid.column(13).visible(false);
			           var data = data.kpi_Data;
				       devDataGrid.clear();	
				       devDataGrid.rows.add(data).draw();
				       devDataGrid.draw();
		    
		}
			
			if(periodString=="OL1Achivement")
			{
				devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(true); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="OL2Achivement")
			{
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(true); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="OL2AdjAchivement")
			{
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(true);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="OL3Achivement")
			{
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(true);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="FYAchivement")
			{
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(true);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
} ;


function renderaddkpiPage(val){
	if(val=='addkpi'){
		 window.location.href = 'addkpi';
	}
	
}
</script>

<style>
.new-search-area{
margin-left: 1015px;
    width: 18%;
}
</style>
