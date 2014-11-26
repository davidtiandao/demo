<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<title>课程分类级联下拉列表</title>
<script type="text/javascript">
	$(document).ready(function () {	
			alert("开始------");
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/category/findCategoryParent.action',
				data: 'categoryParentId=' + "0" ,
				dataType: "json",
				success : function(msg)
				{
					// 清空表格
					$("#categoryParentID").empty();				
					var option = "<option value=\"\">请选择...</option>";
					// 循环组装下拉框选项
					$.each(msg, function(k, v)
					{
						option +="<option value=\"" + v['id'] + "\">" + v['categoryName'] + "</option>";  
					});
					$("#categoryParentID").append(option);
					$("#categoryParentID").change(function()  
				            {  
								alert($(this).val());
				               show_childrenInfo($(this).val());  
				            });  
				}
			});
	});
	
	function show_childrenInfo(categoryParentId)
	{
		$.ajax(
		{
			type : 'POST',
			url : '${pageContext.request.contextPath}/category/findCategoryParent.action',
			data : 'categoryParentId=' + categoryParentId ,
			dataType: "json",
			success : function(msg)
			{
				// 清空表格
				$("#categoryID").empty();
				var option = "<option value=\"\">请选择...</option>";
				// 循环组装下拉框选项
				$.each(msg, function(k, v)
				{
					option += "<option value=\"" + v['id'] + "\">" + v['categoryName'] + "</option>";
				});
				
				$("#categoryID").append(option);
				
			}
		});
	}	
</script>

</head>
<body>
	  <select name="categoryParentID" id="categoryParentID" style="width:318px">  
            <option value="">一级分类...</option>  
        </select>  
	<select name="categoryID" id="categoryID" style="width:318px">  
            <option value="">二级分类...</option>  
        </select>  
</body>
</html>