Ext.Loader.setConfig({
    enabled: true
});

var systemMailPanel = null;
var systemMenuTree = null;

Ext.application({
	name:"Octopus",
	appFolder:"page/js/application",
	models:["Octopus.model.FlowDTO","Octopus.model.CodeTableDTO"],
	launch:function(){
		var panel = Ext.create("Octopus.view.Panel");
		Ext.create("Ext.container.Viewport",{
			layout:"fit",
			items:[panel]
		});
	}
});