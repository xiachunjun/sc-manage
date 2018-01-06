var tree = {
	/**用来封装数据*/
	data:{
		
	},
	
	/**初始化事件和数据*/
	init:{
		initEvent:function(){
			
		},
		initData:function(){
			
		}
	},
	
	/**页面上所有操作*/
	operation:{
		tree:{
			zTree: '',
			setting:{
				isSimpleData: true,
				treeNodeKey: "tid",
				treeNodeParentKey: "pid",
				showLine: true,
				root:{ 
					isRoot:true,
					nodes:[]
				},
				callback:{
					/**
					 * treeId: 当前tree容器Id
					 * treeNode: 当前点击的节点
					 */
					expand:function(event, treeId, treeNode){
						//如果点击的节点没子节点
						if(!tree.operation.tree.zTree.getNodeByParam("pid", treeNode.tid)){
							tree.operation.tree.ajaxMethod({
								url: "/tree/show/node/byPid",
								data: {pid : treeNode.tid},
								callback: function(data){
									tree.operation.tree.zTree.addNodes(treeNode, data.dataMap.treeList, true)
								}
							})
						}
					}
				}
			},
			
			/**加载根节点*/
			loadRoot:function(){
				tree.operation.tree.ajaxMethod({
					url: "/tree/show/node/byPid",
					data: {pid : 0},
					callback: function(data){
						tree.operation.tree.zTree = $("#tree").zTree(tree.operation.tree.setting, data.dataMap.treeList);	
					}
				})
			},
			
			/**简单封装*/
			ajaxMethod:function(ajaxJson){
				$.post(ajaxJson.url, ajaxJson.data, function(data){
					ajaxJson.callback(data);
				})
			}
			
		}
	}
}

$(function(){
	//点击事件加载树节点
	tree.operation.tree.loadRoot();
})
