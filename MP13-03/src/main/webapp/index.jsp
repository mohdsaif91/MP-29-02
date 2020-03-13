
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <title>Matrix Pharmacy Home</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel = "icon" href =  
              "CompanyLog/icons8-medical-bag-96.png" 
              type = "image/x-icon"> 
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="suggestion.css">
        <style>

            body{
                overflow-x: hidden;
            }
        </style>
    </head>
    <body>
        <div class="site-wrap">
            <div class="site-navbar py-2">
                <div class="search-wrap">
                    <div class="container">
                        <a href="#" class="search-close js-search-close"><span class="icon-close2"><div id="loadingbuffer">
                                    <div class="spinner-border text-dark mt-2"> 
                                    </div>
                                </div>
                            </span>
                        </a>
                        <input type="text" id="searchproduct" class="form-control" placeholder="Search product name and hit enter...">
                    </div>
                </div>
                <div class="container">
                    <div class="d-flex align-items-center justify-content-between">
                        <div class="logo">
                            <div class="site-logo">
                                <a href="homeController" class="js-logo-clone">
                                    <img src="CompanyLog/logo .png"/>
                                    <!--                                    Matrix Pharma-->
                                </a>
                            </div>
                        </div>

                        <div class="main-nav d-none d-lg-block">
                            <nav class="site-navigation text-right text-md-center" role="navigation">
                                <ul class="site-menu js-clone-nav d-none d-lg-block">
                                    <li class="active"><a href="homeController">Home</a></li>
                                    <li><a href="product">Products</a></li>
                                    <li><a href="myOrders">My Orders</a></li>
                                    <li><a href="about.jsp">About</a></li>
                                    <li><a href="contact.jsp">Contact</a></li>
                                    <li><b>${username}</b></li>
                                    <li style="visibility: hidden" id="gonogo">${gonogo}true</li>
                                </ul>
                            </nav>
                        </div>
                        <div class="icons">
                            <a href="#" id="searchwords" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
                            <a href="CartShow" class="icons-btn d-inline-block bag">
                                <span class="icon-shopping-bag"></span>
                            </a>
                            <a href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
                                    class="icon-menu"></span></a>

                            <a class="btn btn-primary dropdown-toggle" href="#" role="icon" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            </a>
                            <div class="dropdown-menu " aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item" href="signin.jsp">Sign In</a>
                                <a class="dropdown-item" href="signin.jsp">Log Out</a>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>

            <div class="site-blocks-cover" id="hidetopimage" style="background-image: url('medicineimage/images/hero_1.jpg');">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-7 mx-auto order-lg-2 align-self-center">
                            <div class="site-block-cover-content text-center">
                                <h2 class="sub-title">Effective Medicine, New Medicine Everyday</h2>
                                <h1>Welcome To Matrix Pharmacy</h1>
                                <p>
                                    <a href="product" class="btn btn-primary px-5 py-3">Shop Now</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="title-section text-center col-12">
                            <h2 id="heading" class="text-uppercase">Popular Company</h2>
                        </div>
                    </div>
                    <div class="row mt-4" id="inithide">
                        <div class="col-md-5 mr-auto">
                            <div class="border text-center">
                                <img id="imagecate" src="https://matrixpharamacy9167.s3.amazonaws.com//" alt="Image" class="img-fluid p-5">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <lk class="getidog" style="visibility: hidden;" id="id"></lk>
                            <h2 class="text-black" id="brandname"></h2>
                            <lp class="koo" style="visibility: hidden;" id="tabename"></lp>
                            <p id="medeidescription"></p>
                            <p>$<strong class="text-black h4" id="productprice"></strong></p>
                            <div class="mb-5">
                                <div class="input-group mb-3" style="max-width: 220px;">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-outline-info js-btn-minus" type="button">&minus;</button>
                                    </div>
                                    <input type="text" name="quantity" class="form-control text-center" id="quantity" value="1" placeholder=""
                                           aria-label="Example text with button addon" aria-describedby="button-addon1">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-info js-btn-plus" type="button">&plus;</button>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-5">
                                <div class="tab-content" id="pills-tabContent">
                                    <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                                        <table class="table custom-table">
                                            <thead>
                                            <th>Generic Name</th>
                                            <th>Packaging</th>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td id="genericname"></td>
                                                    <td id="packagig"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-lg-4 col-sm-4">
                                    <p><Button href="#" class="buy-now btn btn-sm height-auto px-4 py-3 btn-danger max-auto buy-nowo" id="buynowdis" style="padding-left: 15px">Buy Now</a></Button>
                                </div>
                                <div class="col-lg-4 col-sm-4">
                                    <p><Button href="#" class="buy-now btn btn-sm height-auto px-4 py-3 btn-black max-auto add-carto" id='supername' style="padding-left: 15px">Add To Cart</button></p>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row" id="hidecategory">
                        <c:forEach items="${allvalue}" var="lp">
                            <div  class="col-lg-4 col-sm-10 col-md-6  m-l-r-auto text-center ">
                                <!--<span class="tag">Sale</span>-->
                                <a href="#"><img src="https://kingcompanyimage.s3.amazonaws.com//${lp.companyImageName}" alt="Image"></a>
                                <h3 class="text-dark text-uppercase blockproduct"><a href="#"> ${lp.companyname}</a></h3>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="row mt-5" id="pagihide">
                <div class="col-md-12 text-center">
                    <div class="site-block-27">
                        <ul>
                            <li><a href="#">&lt;</a></li>
                                <c:forEach items="${count}" var="p">    
                                <li><a href="#" class="getidof">${p.num}</a></li>
                                </c:forEach>
                            <li><a href="#">&gt;</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="site-section bg-light">
                <div class="container">
                    <div class="row">
                        <div class="title-section text-center col-12">
                            <h2 class="text-uppercase">All Categories</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 block-3 products-wrap">
                            <div class="nonloop-block-3 owl-carousel">
                                <c:forEach items="${allvalue}" var="lp">
                                    <div class="text-center item mb-4">
                                        <a href="shop-single.html"> <img src="https://kingcompanyimage.s3.amazonaws.com//${lp.companyImageName}" alt="Image"></a>
                                        <h3 class="text-dark blockproduct"><a href="#">${lp.companyname}</a></h3>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="site-section bg-secondary bg-image" style="background-image: url('medicineimage/images/bg_2.jpg');">
                <div class="container">
                    <div class="row align-items-stretch">
                        <div class="col-lg-6 mb-5 mb-lg-0">
                            <a href="#" class="banner-1 h-100 d-flex" style="background-image: url('medicineimage/images/bg_1.jpg');">
                                <div class="banner-1-inner align-self-center">
                                    <p>Life is choices, and they are relentless. No sooner have you made one choice than another is upon you.?
                                    </p>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-6 mb-5 mb-lg-0">
                            <a href="#" class="banner-1 h-100 d-flex" style="background-image: url('medicineimage/images/bg_2.jpg');">
                                <div class="banner-1-inner ml-auto  align-self-center">
                                    <h2>Rated by Experts</h2>
                                    <p>?Declare the past, diagnose the present, foretell the future.?
                                    </p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>


            <footer class="site-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">

                            <div class="block-7">
                                <h3 class="footer-heading mb-4">About Us</h3>
                                <p>A medicine cat has no time for doubt. Put your energy into today and stop worrying about the past.</p>
                            </div>

                        </div>
                        <div class="col-lg-3 mx-auto mb-5 mb-lg-0">
                            <h3 class="footer-heading mb-4">Quick Links</h3>
                            <ul class="list-unstyled">
                                <li class="active"><a href="index.jsp">Home</a></li>
                                <li><a href="myOrders">My Orders</a></li>
                                <li><a href="signin.jsp">Sign In</a></li>
                                <li><a href="about.jsp">About</a></li>
                                <li><a href="contact.jsp">Contact</a></li>
                            </ul>
                        </div>

                        <div class="col-md-6 col-lg-3">
                            <div class="block-5 mb-5">
                                <h3 class="footer-heading mb-4">Contact Info</h3>
                                <ul class="list-unstyled">
                                    <li class="phone"><a href="tel://+18886821109">+1 8886821109</a></li>
                                </ul>
                            </div>


                        </div>
                    </div>
                    <div class="row pt-5 mt-5 text-center">
                        <div class="col-md-12">
                            <p>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;
                                <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made
                                with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank"
                                                                                         class="text-primary">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>

                    </div>
                </div>
            </footer>
        </div>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/main.js"></script>
        <script src="jquery.js"></script>
        <script>
                                    var countries = [];
                                    document.addEventListener('DOMContentLoaded', function () {
                                        myInitCode();
                                        autocomplete(document.getElementById("searchproduct"), countries);
                                    });
                                    function  myInitCode() {
                                        $.post('homeController', function (response) {
                                            if (response !== null) {
                                                $.each(response, function (key, value) {
                                                    countries.push(value.brandname);
                                                });
                                                console.log("yes you can");
                                            }
                                        });

                                    }
                                    function caled() {
                                        document.location.href = "homeController";
                                    }
                                    $(document).ready(function () {
                                        $("#loadingbuffer").hide();
                                        if ($('#gonogo').text() === 'true') {
                                            caled();
                                            $('#inithide').hide();
                                            $('#searchproduct').on("keyup", function (e) {
                                                var text = $('#searchproduct').val();
                                                console.log("Yes Insied 1");
                                                if (e.keyCode === 13) {
                                                    $("#loadingbuffer").show();
                                                    document.getElementById("imagecate").style.display = 'block';
                                                    document.getElementById("supername").disabled = false;
                                                    document.getElementById("buynowdis").disabled = false;
                                                    console.log("Yes Insied 2");
                                                    e.preventDefault();
                                                    $.get('getSingleProduct', {
                                                        text: text
                                                    }, function (responsivetext) {
                                                        $("#loadingbuffer").hide();
                                                        $('#hidecategory').hide();
                                                        $('#heading').hide();
                                                        $('#pagihide').hide();
                                                        $('#hidetopimage').hide();
                                                        $('#inithide').show();
                                                        if (responsivetext !== 'No Product Found !') {
                                                            $.each(responsivetext, function (key, value) {
                                                                $('#id').text(value.id);
                                                                $('#brandname').text(value.brandname);
                                                                $('#tabename').text(value.company);
                                                                $('#imagecate').attr('src', 'https://matrixpharamacy9167.s3.amazonaws.com//' + value.imagename);
                                                                $('#productprice').text(value.productprice);
                                                                $('#packagig').text(value.packaging);
                                                                $('#genericname').text(value.genericname);
                                                                $('#medeidescription').text(value.productdescription);
                                                            });
                                                        } else {
                                                            $('#id').text("");
                                                            $('#brandname').text("No Product Found !");
                                                            $('#medeidescription').text("");
                                                            $('#productprice').text("");
                                                            $('#tabename').text("");
                                                            $('#packagig').text("");
                                                            $('#genericname').text("");
                                                            document.getElementById("buynowdis").disabled = true;
                                                            document.getElementById("supername").disabled = true;
                                                            document.getElementById("imagecate").style.display = 'none';
                                                        }
                                                    });
                                                } else {

                                                }

                                            });
                                        } else {
                                            $('#inithide').hide();
                                            $('#searchproduct').on("keyup", function (event) {
                                                var text = $('#searchproduct').val();
                                                if (event.keyCode === 13) {
                                                    $("#loadingbuffer").show();
                                                    document.getElementById("imagecate").style.display = 'block';
                                                    document.getElementById("supername").disabled = false;
                                                    document.getElementById("buynowdis").disabled = false;
                                                    $.get('getSingleProduct', {
                                                        text: text
                                                    }, function (responsivetext) {
                                                        $("#loadingbuffer").hide();
                                                        $('#hidecategory').hide();
                                                        $('#heading').hide();
                                                        $('#pagihide').hide();
                                                        $('#hidetopimage').hide();
                                                        $('#inithide').show();
                                                        if (responsivetext !== 'No Product Found !') {
                                                            $.each(responsivetext, function (key, value) {
                                                                $('#id').text(value.id);
                                                                $('#brandname').text(value.brandname);
                                                                $('#tabename').text(value.company);
                                                                $('#imagecate').attr('src', 'https://matrixpharamacy9167.s3.amazonaws.com//' + value.imagename);
                                                                $('#productprice').text(value.productprice);
                                                                $('#packagig').text(value.packaging);
                                                                $('#genericname').text(value.genericname);
                                                                $('#medeidescription').text(value.productdescription);
                                                            });
                                                        } else {
                                                            $('#id').text("");
                                                            $('#brandname').text("No Product Found !");
                                                            $('#medeidescription').text("");
                                                            $('#productprice').text("");
                                                            $('#tabename').text("");
                                                            $('#packagig').text("");
                                                            $('#genericname').text("");
                                                            document.getElementById("imagecate").style.display = 'none';
                                                            document.getElementById("buynowdis").disabled = true;
                                                            document.getElementById("supername").disabled = true;
                                                        }
                                                    });
                                                } else {
                                                    console.log("opopopopo");
                                                }
                                            });
                                        }
                                    }
                                    );
                                    $('.icon-close2').click(function () {
                                        $('#hidecategory').show();
                                        $('#heading').show();
                                        $('#pagihide').show();
                                        $('#hidetopimage').show();
                                        $('#inithide').hide();
                                    });

                                    $('.blockproduct').click(function (event) {
                                        var og = event.target.innerHTML;
                                        document.location.href = "subcategorypage?subcatename=" + og;
                                    });
                                    $('.getidof').click(function (event) {
                                        document.location.href = "homeController?number=" + event.target.innerHTML;
                                    });
                                    var imp = null;
                                    $('.buy-nowo').click(function () {
                                        console.log("going in");
                                        var fg = $(this).index();
                                        var id = document.getElementsByClassName('getidog')[fg].innerHTML;
                                        var tabnam = document.getElementsByClassName('koo')[fg].innerHTML;
                                        var qun = $('#quantity').val();
                                        var hj = document.getElementsByClassName('text-black')[fg].innerHTML;
                                        console.log(tabnam + "&brandname=" + hj + "&id=" + id + "&qun=" + qun);
                                        document.location.href = "bookproduct2?tablename=" + tabnam + "&brandname=" + hj + "&id=" + id + "&qun=" + qun;
                                    });
                                    $('.add-carto').click(function () {
                                        $('#loadingbuffer').show();
                                        var fg = $(this).index();
                                        var id = $('.getidog').text();
                                        var tabnam = document.getElementsByClassName('koo')[fg].innerHTML;
                                        var qun = $('#quantity').val();
                                        var hj = document.getElementsByClassName('text-black')[fg].innerHTML;
                                        document.location.href = "addToCartFromSearch?tablename=" + tabnam + "&brandname=" + hj + "&qun=" + qun;
                                    });

                                    function autocomplete(inp, arr) {
                                        /*the autocomplete function takes two arguments,
                                         the text field element and an array of possible autocompleted values:*/
                                        var currentFocus;
                                        /*execute a function when someone writes in the text field:*/
                                        inp.addEventListener("input", function (e) {
                                            var a, b, i, val = this.value;
                                            /*close any already open lists of autocompleted values*/
                                            closeAllLists();
                                            if (!val) {
                                                return false;
                                            }
                                            currentFocus = -1;
                                            /*create a DIV element that will contain the items (values):*/
                                            a = document.createElement("DIV");
                                            a.setAttribute("id", this.id + "autocomplete-list");
                                            a.setAttribute("class", "autocomplete-items");
                                            /*append the DIV element as a child of the autocomplete container:*/
                                            this.parentNode.appendChild(a);
                                            /*for each item in the array...*/
                                            for (i = 0; i < arr.length; i++) {
                                                /*check if the item starts with the same letters as the text field value:*/
                                                if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
                                                    /*create a DIV element for each matching element:*/
                                                    b = document.createElement("DIV");
                                                    /*make the matching letters bold:*/
                                                    b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                                                    b.innerHTML += arr[i].substr(val.length);
                                                    /*insert a input field that will hold the current array item's value:*/
                                                    b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                                                    /*execute a function when someone clicks on the item value (DIV element):*/
                                                    b.addEventListener("click", function (e) {
                                                        /*insert the value for the autocomplete text field:*/
                                                        inp.value = this.getElementsByTagName("input")[0].value;
                                                        /*close the list of autocompleted values,
                                                         (or any other open lists of autocompleted values:*/
                                                        closeAllLists();
                                                    });
                                                    a.appendChild(b);
                                                }
                                            }
                                        });
                                        /*execute a function presses a key on the keyboard:*/
                                        inp.addEventListener("keydown", function (e) {
                                            var x = document.getElementById(this.id + "autocomplete-list");
                                            if (x)
                                                x = x.getElementsByTagName("div");
                                            if (e.keyCode === 40) {
                                                /*If the arrow DOWN key is pressed,
                                                 increase the currentFocus variable:*/
                                                currentFocus++;
                                                /*and and make the current item more visible:*/
                                                addActive(x);
                                            } else if (e.keyCode === 38) { //up
                                                /*If the arrow UP key is pressed,
                                                 decrease the currentFocus variable:*/
                                                currentFocus--;
                                                /*and and make the current item more visible:*/
                                                addActive(x);
                                            } else if (e.keyCode === 13) {
                                                /*If the ENTER key is pressed, prevent the form from being submitted,*/
                                                e.preventDefault();
                                                if (currentFocus > -1) {
                                                    /*and simulate a click on the "active" item:*/
                                                    if (x)
                                                        x[currentFocus].click();
                                                }
                                            }
                                        });
                                        function addActive(x) {
                                            /*a function to classify an item as "active":*/
                                            if (!x)
                                                return false;
                                            /*start by removing the "active" class on all items:*/
                                            removeActive(x);
                                            if (currentFocus >= x.length)
                                                currentFocus = 0;
                                            if (currentFocus < 0)
                                                currentFocus = (x.length - 1);
                                            /*add class "autocomplete-active":*/
                                            x[currentFocus].classList.add("autocomplete-active");
                                        }
                                        function removeActive(x) {
                                            /*a function to remove the "active" class from all autocomplete items:*/
                                            for (var i = 0; i < x.length; i++) {
                                                x[i].classList.remove("autocomplete-active");
                                            }
                                        }
                                        function closeAllLists(elmnt) {
                                            /*close all autocomplete lists in the document,
                                             except the one passed as an argument:*/
                                            var x = document.getElementsByClassName("autocomplete-items");
                                            for (var i = 0; i < x.length; i++) {
                                                if (elmnt !== x[i] && elmnt !== inp) {
                                                    x[i].parentNode.removeChild(x[i]);
                                                }
                                            }
                                        }
                                        /*execute a function when someone clicks in the document:*/
                                        document.addEventListener("click", function (e) {
                                            closeAllLists(e.target);
                                        });
                                    }
                                    /*An array containing all the country names in the world:*/
                                    /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/


        </script>
    </body>
</html>