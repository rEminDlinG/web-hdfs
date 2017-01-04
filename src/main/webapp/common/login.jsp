<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>WEB-HDFS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="/resources/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/animate-custom.css" />

    <script type="text/javascript" src="/resources/js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="codrops-top">
        <a href="">
            <strong>这里什么都没有，多了这一条只是为了好看。要不然下面的标题顶到页面最上方太难看了。</strong>
        </a>
        <span class="right">
                    <a href="http://10.10.90.5:8080/kfpt/">
                        <strong>这里什么都没有，不要点</strong>
                    </a>
                </span>
        <div class="clr"></div>
    </div><!--/ Codrops top bar -->
    <header>
        <h1>欢迎使用<span>WEB-HDFS</span>在线服务</h1>
        <nav class="codrops-demos">
            <span>做的不好，有啥问题跟我们反映。</span>
            <!--<a href="index.html" class="current-demo">Demo 1</a>-->
            <!--<a href="index2.html">Demo 2</a>-->
            <!--<a href="index3.html">Demo 3</a>-->
        </nav>
    </header>
    <section>
        <div id="container_demo" >
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="/common/explorer.jsp" autocomplete="on">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u" > Your username </label>
                            <input id="username" name="username" required="required" type="text" placeholder="username"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. 123456" />
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Login" />  <!-- onclick="javaScript:doLogin();" -->
                        </p>
                        <p class="change_link">
                            亲，你还没注册呢？
                            <a href="#toregister" class="to_register">去注册</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form  action="explorer.html" autocomplete="on">
                        <h1> Sign up </h1>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="最好让我们一看就知道你是谁" />
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="填不填都行，没时间就不用填了"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="不用太麻烦，建议使用123456.大家都好记"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="把123456重复一遍"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="注册"/>
                        </p>
                        <p class="change_link">
                            亲，已经有账号了么？
                            <a href="#tologin" class="to_register"> 直接登录 </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</body>
</html>