<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file= "/reports/init.jsp" %>

<div class=row>
<div class="col-md-12">
<label>Report </label>
<br>
<select id="<portlet:namespace/>report" name="<portlet:namespace/>report" required="required">
         <option value="0">Select Report</option>
         <option value="1">Trading Profit Breakdown</option>
         <option value="2">Full Year</option>
         <option value="3">Corporate Planning</option>
         <option value="4">Executive Management</option>
         <option value="5">Performance & Reward Management</option>
</select><br><br>
 
<label>Period </label>
<br>
<select id="<portlet:namespace/>period" name="<portlet:namespace/>period" required="required">
         <option value="0">Select Period</option>
         <option value="1">OL1 Achivement</option>
         <option value="2">OL2 Achivement</option>
         <option value="3">OL2 Adj. Achivement</option>
         <option value="4">OL3 Achivement</option>
         <option value="5">FY Achivement</option>
</select><br><br>
<label>Year </label>
<br>
<select id="<portlet:namespace/>year" name="<portlet:namespace/>year" required="required">
         <option value="0">Select Year</option>
         <option value="2017">2017</option>
         <option value="2018">2018</option>
</select><br><br>
<button class="button btn-primary" onclick="getreporturl()">SHOW</button>
</div>
</div>

<portlet:resourceURL var="ResourceUrl">
</portlet:resourceURL>
<script>
function getreporturl(){
	$.ajax({
	    url : '<%=ResourceUrl.toString()%>',
	    data : {
	    	<portlet:namespace />reportId: $("#<portlet:namespace />report").val(),
	    	<portlet:namespace />periodId: $("#<portlet:namespace />period").val(),
	    	<portlet:namespace />year: $("#<portlet:namespace />year").val()
	    },
	      type : "POST",
	      dataType: "text",
	    success : function(data) {
	        console.log(data);
	    },
	    error : function(response) {
	       console.log("Error seen for loadDivisonDepName");
	        $('#img').hide();
	    }
	});
	}
</script>