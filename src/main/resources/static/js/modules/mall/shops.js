$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'shops/list',
        datatype: "json",
        colModel: [			
			{ label: '商铺ID', name: 'shopsId', index: 'shops_id', width: 50, key: true },
			{ label: '店主', name: 'userId', index: 'user_id', width: 80, formatter: getUserNameById },
			{ label: '商铺名称', name: 'name', index: 'name', width: 80 },
			{ label: '状态', name: 'status', index: 'status', width: 80, formatter: function(value, options, row) {
				return value === 0 ?
                    '<span class="label label-danger">停业中</span>' :
                    '<span class="label label-success">营业中</span>';
			}},
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });

    // 根据userId获得用户名称
    function getUserNameById(value, options, row) {
    	var $userName = "";
        $.post({
            url:baseURL + "shops/getUserNameById/"+value,
            async:false,// 加了async后，它会等ajax执行完成后再执行后面的js
            success:function(data){
                $userName=data.username;
            }
        })
        return $userName;
    }
});


var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		shops: {
            status:1,
            userId:0
		},
        users:[]
	},
	methods: {
        getUsers: function () {
            $.get(baseURL + "shops/getUsers", function(r){
                vm.users = r.users;
                if (r.users.length == 0) {
                    vm.shops = { userId:0 };
				}
                vm.users.unshift({"id":0,"name":"--请选择店主--"});
            });
        },
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.shops = { status:1 };
            vm.getUsers();
		},
		update: function (event) {
			var shopsId = getSelectedRow();
			if(shopsId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getUsers();
            vm.getInfo(shopsId)
		},
		saveOrUpdate: function (event) {
			var url = vm.shops.shopsId == null ? "shops/save" : "shops/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.shops),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var shopsIds = getSelectedRows();
			if(shopsIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "shops/delete",
                    contentType: "application/json",
				    data: JSON.stringify(shopsIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(shopsId){
			$.get(baseURL + "shops/info/"+shopsId, function(r){
                vm.shops = r.shops;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});