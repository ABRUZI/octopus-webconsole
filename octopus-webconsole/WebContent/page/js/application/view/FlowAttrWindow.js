Ext.define("Octopus.view.FlowAttrWindow", {
	extend:"Octopus.view.CommonWindow",
	title:"流程属性设置窗口",
	
	initComponent:function(){
		
		this.callParent();
	},
	
	constructor:function(){
		
		this.callParent();
	},
	
	
	getWindowHeight:function(){
		return window.screen.height * 0.6;
	},
	
	getWindowWidth:function(){
		return window.screen.width * 0.8;
	}
});