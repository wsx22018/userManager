var url = "";
$(function(){
	initTable(null, null);
});
function initTable(queryData, id) {  
    $("#dg").datagrid({  
        url: '/userManager/user/queryAll',  
        nowrap: true,  
        striped: true,  
        sortOrder: 'asc',  
        remoteSort: false,  
        idField: 'id',  
        queryParams: queryData,
        pagination : true,
        pageSize: 10,  
        pageList: [10, 50, 100, 200],
        columns:[[      
            {field:'id',hidden:'true'},   
            {field:'name',title:'用户名称',width:150},   
            {field:'age',title:'用户年龄',width:150}, 
            {field:'sex',title:'用户性别',width:150,formatter: function(value,row,index){
    				if (row.sex == 0){
    					return '女';
    				} else if(row.sex == 1){
    					return '男';
    				}
    		}}, 
            {field:'email',title:'E-mail',width:150}
        ]],
      //工具栏
        toolbar: [{
	        text:'添加用户信息',
			    iconCls: 'icon-add',
			    handler: function(){
			    	newUser();
			    }
			 },'-',{
			    text:'修改用户信息',
			    iconCls: 'icon-edit',
			    handler: function(){
			    	editUser();
			    }
			 },'-',{
			    text:'删除用户信息',
			    iconCls: 'icon-remove',
			    handler: function(){
			    	delUser();
			    }
	    }]
    });  
} 
function newUser(){
	$('#dlg').dialog('open').dialog('setTitle','添加用户信息');
	$('#fm').form('clear');
	$('#id').val(0);
	url = '/userManager/user/insertUser';
}
function editUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle','修改用户信息');
		$('#fm').form('load',row);
		url = '/userManager/user/updateUser';
	}else{
		$.messager.show({
			title: '提示',
			msg: '请选择一条数据进行修改！'
		});
	}
}
function delUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('提示','确认要删除选择的数据么?',function(r){
			if (r){
				$.get('/userManager/user/delUser/'+row.id,function(result){
					if (result.code != '201'){
						$('#dg').datagrid('reload');
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				});
			}
		});
	}
}
function saveUser(){
	$('#fm').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.code != '200'){
				$.messager.show({
					title: 'Error',
					msg: result.msg
				});
			} else {
				$('#dlg').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
			}
		}
	});
}