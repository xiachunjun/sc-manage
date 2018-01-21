var asiderMenu=function(){
	var menuCode=$('title').attr('menu-code');
	var menu=$("#"+menuCode);
	var parentCode=$(menu).attr('parent-menu-code');
	$(menu).addClass('active');
	$("#"+parentCode).addClass('open');
}
asiderMenu();
