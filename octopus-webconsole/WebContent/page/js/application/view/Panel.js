Ext.define("Octopus.view.Panel",{
	extend:"Ext.container.Container",
	title:"Octopus控制台",
	layout:{
		type:"vbox",
		align:"stretch",
		pack:"start"
	},
	initComponent:function(){
		var _self = this;
		this.items = [_self.form, _self.grid];
		this.callParent();
	},
	constructor:function(){
		var _self = this;
		
		_self.nameInput = Ext.create("Ext.form.field.Text",{
			fieldLabel:"名称",
			labelAlign:"right",
			width:200,
			labelWidth:40,
			margin:"10 5 10 5",
			emptyText:"请输入流程名称"
		});
		
		
		_self.statusInput = Ext.create("Ext.form.field.ComboBox",{
			fieldLabel:"状态",
			labelAlign:"right",
			width:200,
			labelWidth:40,
			margin:"10 5 10 5",
			emptyText:"请选择状态",
			editable:false,
			valueField:"code",
			displayField:"name",
			store:Ext.create("Ext.data.Store",{
				model:"Octopus.model.CodeTableDTO",
				autoLoad:false,
				proxy:{
					type:"ajax",
					url:"./queryFlowStatusList.do",
					reader:{
						type:"json",
						root:"res"
					}
				}
			})
		});
		
		_self.form = Ext.create("Ext.form.Panel",{
			title:"查询条件",
			height:80,
			border:1,
			bodyBorder:true,
			layout:{
				type:"hbox",
				align:"middle",
				pack:"start"
			},
			items:[_self.nameInput, _self.statusInput, {
				xtype:"button",
				text:"查询",
				margin:"10 5 10 5",
				handler:function(){
					var params = Ext.JSON.encode({
						name:_self.nameInput.getValue(),
						status:{
							code:_self.statusInput.getValue()
						}
					});
					
					
					
					_self.grid.getStore().getProxy().extraParams = {params:params};
					_self.grid.getStore().loadPage(1);
				}
			},{
				xtype:"button",
				text:"重置",
				margin:"10 5 10 5",
				handler:function(){
					_self.nameInput.setValue("");
					_self.statusInput.clearValue();
				}
			}]
		});
		
		_self.gridStore = Ext.create("Ext.data.Store",{
			model:"Octopus.model.FlowDTO",
			autoLoad:true,
			proxy:{
				type:"ajax",
				actionMethods:"POST",
				url:"./queryFlowList.do",
				reader:{
					type:"json",
					root:"res"
				}
			}
		});
		
		_self.grid = Ext.create("Ext.grid.Panel",{
			title:"流程列表",
			flex:1,
			columns:[{ 
				text:"名称",  dataIndex:"name",flex:3,sortable:false,hideable:false
			},{ 
				text:"状态", dataIndex:"status.name",flex:1 ,sortable:false,hideable:false
			},{
				text:"执行表达式", dataIndex:"cronExpr",flex:2,sortable:false,hideable:false
			},{ 
				text:"创建人", dataIndex:"creator.name" ,flex:1,sortable:false,hideable:false
			},{
				text:"创建时间", dataIndex:"createTime",flex:2,sortable:false,hideable:false
			},{
				text:"最后修改人", dataIndex:"modifier.name",flex:1,sortable:false,hideable:false
			},{
				text:"最后修改时间", dataIndex:"modifyTime",flex:2,sortable:false,hideable:false
			}],
			selType:"checkboxmodel",
			store:_self.gridStore,
			dockedItems:[{
		        xtype: 'toolbar',
		        dock: 'top',
		        items: [{
		            text:"新增",
		            handler:function(){
		            }
		        },{
		        	text:"删除",
		        	handler:function(){}
		        },{
		        	text:"编辑",
		        	handler:function(){}
		        },{
		        	text:"设计",
		        	handler:function(){
		        		
		        	}
		        },{
		        	text:"监控",
		        	handler:function(){
		        		
		        	}
		        }]
		    },{
				xtype: 'pagingtoolbar',
				store: _self.gridStore,  
				dock: 'bottom',
				displayInfo: true
			}]
		});
		this.callParent();
	}
});