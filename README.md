# FoodBackstageSys
自助点餐系统后台数据管理界面

![前台](https://github.com/BugCatEcho/FoodSys)

该项目是点餐系统的后台项目
使用了[Bootstrap](https://getbootstrap.com/)美化前端布局，大量使用了JQuery js代码实现完全异步的增删改查操作。
后端则使用Spring+Struts2+Hibernate实现。
这个后台并非完全针对FoodSys这个前台项目制作的，而是他的改进版，因为我发现前台项目的数据库字段设计非常不严谨，
缺少了许多功能需要的字段，因此我改进表后制作了这个后台项目。

>厨师管理界面(ChefBackstage)
>>厨师登陆自己的厨师账号则可进入厨师管理操作界面
>>一个厨师可以对自己添加的菜品进行增删改查
>>登陆后页面会将厨师的fid通过Chef.js中的async方法通过Ajax技术获得食物List 并通过writefoodview()将数据写入页面
>>ID为#bt_showaddview的红色`添加`按钮会被监听，点击时打开一个模态框，同样会先异步获取FoodType List且异步添加
>>`删除`和`修改`按钮则是通过writefoodview()生成OnClick="delfoodajax(fid)"属性来执行异步删除和异步修改操作，
>>`分页显示`后台提供了food_querypagebychefjson接口：通过向后台发送chefID与页码来获取json格式的菜品数据。
-----------------------
>管理远管理界面(AdminBackstage)
>>管理员通过index的`管理登陆入口`可进入管理员操作界面
>>登入后页面上方有多个分类 页面下方隐藏有一个input用于存储临时页码
>>页面载入时 Castle.js中的 writeuserview(1) 默认载入用户管理模块的第一页，单击页面上方各个类别可操作各表数据
>>当执行修改或者删除操作时 会重新请求该页数据 不会回到第一页。

管理页面右上方按钮包含管理者姓名 单独更改自己信息功能未实现 点击登出即可回到登陆页面
