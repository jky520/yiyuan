$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'assort/list',
        datatype: "json",
        colModel: [			
			{ label: '商品分类Id', name: 'assortId', index: 'assort_id', width: 50, key: true },
			{ label: '分类名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '商品分类图片', name: 'imgUrl', index: 'img_url', width: 80, formatter: function (value, options, row) {
				console.log(!!value)
				return value == null ?
					'<i class="fa fa-cloud-upload fa-6"></i>' :
					'<img src=baseURL+"images/"+value></img>';
            }},
			{ label: '状态', name: 'status', index: 'status', width: 80, formatter: function(value, options, row) {
                return value === 0 ?
                    '<span class="label label-danger">停用</span>' :
                    '<span class="label label-success">可用</span>';
            }}
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		assort: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.assort = {};
		},
		update: function (event) {
			var assortId = getSelectedRow();
			if(assortId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(assortId)
		},
		saveOrUpdate: function (event) {
			var url = vm.assort.assortId == null ? "assort/save" : "assort/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.assort),
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
			var assortIds = getSelectedRows();
			if(assortIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "assort/delete",
                    contentType: "application/json",
				    data: JSON.stringify(assortIds),
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
		getInfo: function(assortId){
			$.get(baseURL + "assort/info/"+assortId, function(r){
                vm.assort = r.assort;
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