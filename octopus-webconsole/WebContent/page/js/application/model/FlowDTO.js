Ext.define("Octopus.model.FlowDTO",{
	extend:"Ext.data.Model",
	fields:[{
		name:"id", type:"string"
	},{
		name:"name", type:"string"
	},{
		name:"creator"
	},{
		name:"createTime", type:"string"
	},{
		name:"status"
	},{
		name:"modifier"
	},{
		name:"modifyTime", type:"string"
	},{
		name:"cronExpr", type:"string"
	}]
})