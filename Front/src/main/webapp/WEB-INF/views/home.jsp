<html>
<head>
<script>
$(".carousel").swipe({

	  swipe: function(event, direction, distance, duration, fingerCount, fingerData) {

	    if (direction == 'left') $(this).carousel('next');
	    if (direction == 'right') $(this).carousel('prev');

	  },
	  allowPageScroll:"vertical"

	});
</script>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
  
  
       

  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
      <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/-1.jpg">
      </div>
      <div class="item">
        <img src="resources/images/abt-ban.jpg">
      </div>
      <div class="item">
        <img src="resources/images/download.jpg">
      </div>
      <div class="item">
        <img src="resources/images/download(1).jpg">
      </div>
      <div class="item">
        <img src="resources/images/images.jpg">
      </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

</div>
<style>
    .visible-xs-block
    <span class="cdt-hidden-xs">
    
</style>

<p><span style="font-size:20px;"><span style="color:#000080;"><strong>WELCOME TO THE STATE COLLEGE OF FLORIDA LIBRARY</strong></span></span></p>

<p> </p>

<div class="row">
<span class="hidden-xs" "hidden-sm"> <div class="col-xs-4"><a class="thumbnail" href="http://libguides.scf.edu/writing_citing_mla_apa_citation" target="_blank" title="APA, MLA, ASA AMA Citation Style Help."><img alt="Need to Know how to cite you work?" class="img-responsive" src="https://s3.amazonaws.com/libapps/accounts/390/images/ThumbnailCiting346191.jpg" /></a></div>
</span>
<div class="col-xs-4"><a class="thumbnail" href="http://libguides.scf.edu/scf_ebooks_evideos" target="_blank" title="Find eBooks and eVideos in these resources."><img alt="The State College of Florida has eBook and eVideo databases." class="img-responsive" src="https://s3.amazonaws.com/libapps/accounts/390/images/Thumbnailsebooks346191.jpg" /></a></div>

<div class="col-xs-4"><a class="thumbnail" href="http://libguides.scf.edu/FAQs_Frequently_Asked_Questions_Help" target="_blank" title="Most asked questions at the Library. Find help here."><img alt="Frequently Asked Questions." class="img-responsive" src="https://s3.amazonaws.com/libapps/accounts/390/images/thumbnailfaq346191.jpg" /></a></div>
</div>

<hr />
</body>
</html>
