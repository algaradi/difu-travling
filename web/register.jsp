<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅游管理系统用户注册</title>
  <link rel="stylesheet" href="static/css/regist.css">
</head>

<body>
    <div style="margin: 81px 0px 17px; display: flex; align-items: center; justify-content: center;"></div>
    <div class="content">
        <br/>
    <div class="registbox">
        <br/>
        <h1 style="margin-left: 100px;">&nbsp;欢迎称为飞翼旅行员工！我们期待您的到来！</h1>
        <br/>
        <lable class="label_text" style="color: red">${msg}</lable>
        <br/>
        <lable class="lable_text"> 用户名:&nbsp;&nbsp;</lable><input class="textarea" type="text" placeholder="请输入手机号"> </input><br/><br/>
        <lable class="lable_text"> 手机号码:&nbsp;&nbsp;</lable><input class="textarea" id="phone" type="text" placeholder="请输入手机号"> </input><br/>
        <lable class="lable_text"> 密码:&nbsp;&nbsp;&nbsp;</lable> <input class="textarea" type="text" placeholder="请输入密码"> </input><br/>
<!--        <button name="getidcode" class="button_getidcode_text">获取验证码</button><br/>-->
        <lable class="lable_text"> 确认密码:</lable>
        <input class="textarea" type="text" placeholder="再次输入密码"></input>
        <br/>
        <button name="getidcode" class="regist_button">注册</button>
        <br/>
    </div>
        <div style="margin-top: 105px; display: flex; flex-direction: column; align-items: center; justify-content: center; height: 295px; background: rgb(255, 255, 255); box-shadow: rgb(224, 224, 224) 0px -1px 0px 0px;">
            <div style="width: 80%; margin-top: 52px; display: flex; align-items: center; justify-content: space-around;">
                <div style="display: flex; align-items: center; justify-content: center;">
                    <div style="width: 47px; height: 47px; margin-right: 12px;"><img src="https://img10.360buyimg.com/imagetools/jfs/t1/156472/38/714/1858/5fdb0bddE5e22db31/904b35299483ff28.png" style="width: 100%; height: 100%;"></div>
                    <div style="height: 21px; line-height: 21px; font-family: PingFangSC-Semibold; font-size: 15px; color: rgb(46, 51, 58);">精选好货</div>
                </div>
                <div style="display: flex; align-items: center; justify-content: center;">
                    <div style="width: 47px; height: 47px; margin-right: 12px;"><img src="https://img10.360buyimg.com/imagetools/jfs/t1/145662/20/18647/1580/5fdb0c4aE2bee9206/0da7b758685b6e3f.png" style="width: 100%; height: 100%;"></div>
                    <div style="height: 21px; line-height: 21px; font-family: PingFangSC-Semibold; font-size: 15px; color: rgb(46, 51, 58);">天天低价</div>
                </div>
                <div style="display: flex; align-items: center; justify-content: center;">
                    <div style="width: 47px; height: 47px; margin-right: 12px;"><img src="https://img11.360buyimg.com/imagetools/jfs/t1/141325/5/18898/1576/5fdb0c99E7cc31f36/f354a324ef8a3418.png" style="width: 100%; height: 100%;"></div>
                    <div style="height: 21px; line-height: 21px; font-family: PingFangSC-Semibold; font-size: 15px; color: rgb(46, 51, 58);">全场自营</div>
                </div>
                <div style="display: flex; align-items: center; justify-content: center;">
                    <div style="width: 47px; height: 47px; margin-right: 12px;"><img src="https://img10.360buyimg.com/imagetools/jfs/t1/150613/22/11042/1813/5fdb0cd7E369a13ae/023bbd349d6eb8f6.png" style="width: 100%; height: 100%;"></div>
                    <div style="height: 21px; line-height: 21px; font-family: PingFangSC-Semibold; font-size: 15px; color: rgb(46, 51, 58);">京东物流</div>
                </div>
            </div>

            <div style="margin-top: 42px; display: flex; flex-direction: column; align-items: center; justify-content: center; height: 12px; line-height: 23px; font-family: PingFangSC-Regular; font-size: 12px; color: rgb(46, 51, 58);">
                <p><a href="https://beian.miit.gov.cn/#/Integrated/index" target="_blank">沪ICP备16050468号-2 </a>| <a href="http://channel.m.yhd.com/cms/view.do?topicId=190" target="_blank">经营证照 </a>| <a href="https://img10.360buyimg.com/imagetools/jfs/t1/149688/34/18315/139665/5fd754dbEe7770ef9/2c12e3863850e6a8.jpg"
                        target="_blank">互联网药品信息服务资格证(沪)-经营性-2017-0006 </a>| 违法和不良信息举报电话：4006063968 | <a href="https://img11.360buyimg.com/imagetools/jfs/t1/154336/1/9892/481325/5fd754caEbf93f1ae/b5827ba13b80455d.jpg" target="_blank">沪B2-20170039 </a>|
                    <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010502002939" target="_blank">沪公网安备 31010502002939号 </a>| <a href="https://img30.360buyimg.com/img/jfs/t1/6492/18/11106/1876411/5c239337Ef050b204/c78bc70077a34bf2.jpg"
                        target="_blank">增值电信业务经营许可证 </a></p>
                <p>Copyright© 1号会员店 2007-2021， All Rights Reserved</p>
            </div>
            <div style="margin: 81px 0px 17px; display: flex; align-items: center; justify-content: center;">
                <a href="https://www.12377.cn/" target="_blank"><img src="https://img12.360buyimg.com/imagetools/jfs/t1/137354/40/20334/8004/5fdb0dc8Ede5d5a61/2b1115492dd000af.png" style="height: 27px; margin-right: 18px;"></a>
                <a href="http://www.shjbzx.cn/" target="_blank"><img src="https://img14.360buyimg.com/imagetools/jfs/t1/150053/35/18767/7651/5fdb0d35E9957245c/1de66cd6b17463a4.png" style="height: 27px; margin-right: 18px;"></a>
                <a href="https://credit.cecdc.com/CX20150608010268010812.html" target="_blank"><img src="https://img12.360buyimg.com/imagetools/jfs/t1/155718/8/780/7554/5fdb0e2dE8307c655/9d5f4c77700cf5fc.png" style="height: 27px; margin-right: 18px;"></a>
                <a href="https://ss.knet.cn/verifyseal.dll?sn=e13050631010040492h5mq000000&amp;ct=df&amp;a=1&amp;pa=500267" target="_blank"><img src="https://img13.360buyimg.com/imagetools/jfs/t1/141210/1/18632/6718/5fdb0ea6Efae61b31/9553519db03cde8a.png" style="height: 27px; margin-right: 18px;"></a>
                <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010502002939" target="_blank"><img src="https://img13.360buyimg.com/imagetools/jfs/t1/152402/20/10276/2322/5fdb0ee4E2e5f8318/aaf00e247641e78a.png" style="width: 18px;"></a><img src="https://img14.360buyimg.com/imagetools/jfs/t1/134812/19/20245/5466/5fdb0d7aE4a0ca6a6/0c15597415912785.png"
                    style="height: 27px; margin-right: 18px;">
                <a href="https://ipr.jd.com/edition" target="_blank"><img src="https://img13.360buyimg.com/imagetools/jfs/t1/151838/6/6149/5706/5fb34370E1e368dd4/8c95102a02a19931.jpg" style="height: 27px; margin-right: 18px;"></a>
            </div>
        </div>
    </div>
</body>
</html>