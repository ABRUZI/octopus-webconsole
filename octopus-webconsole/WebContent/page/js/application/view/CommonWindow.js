Ext.define("Octopus.view.CommonWindow",{
	extend:"Ext.window.Window",
	
	initComponent:function(){
		this.setHeight(this.getWindowHeight());
		this.setWidth(this.getWindowWidth());
		this.callParent();
	},
	
	
	getWindowHeight:function(){
		//return window.screen.height * 0.6;\
		throw new Error("unimplements method called");
	},
	
	getWindowWidth:function(){
		//return window.screen.width * 0.8;
		throw new Error("unimplements method called");
	}
	
	
})