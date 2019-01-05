<%@ include file="../init.jsp" %>

<%
Long medicalRecordId = ParamUtil.getLong(request, "medicalRecordId");
MedicalRecord medicalRecord = null;
if(medicalRecordId > 0) {
	medicalRecord = MedicalRecordLocalServiceUtil.getMedicalRecord(medicalRecordId);
}
if(medicalRecord != null) {
%>

<style>
	@import url(http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700);
	/* written by riliwan balogun http://www.facebook.com/riliwan.rabo*/
	.board{
	    width: 100%;
	margin: 0px auto;
	/*height: 500px;*/
	background: #fff;
	/*box-shadow: 10px 10px #ccc,-10px 20px #ddd;*/
	}
	.board .nav-tabs {
	    position: relative;
	    /* border-bottom: 0; */
	    /* width: 80%; */
	    margin: 0px auto;
	    margin-bottom: 0;
	    box-sizing: border-box;
	
	}
	
	.board > div.board-inner{
	    background: #fafafa url(http://subtlepatterns.com/patterns/geometry2.png);
	    background-size: 30%;
	}
	
	.container {
		width: 100%;
	}
	
	p.narrow{
	    width: 60%;
	    margin: 10px auto;
	}
	
	.liner{
	    height: 2px;
	    background: #ddd;
	    position: absolute;
	    width: 80%;
	    margin: 0 auto;
	    left: 0;
	    right: 0;
	    top: 50%;
	    z-index: 1;
	}
	
	.nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus {
	    color: #555555;
	    cursor: default;
	    /* background-color: #ffffff; */
	    border: 0;
	    border-bottom-color: transparent;
	}
	
	span.round-tabs{
	    width: 70px;
	    height: 70px;
	    line-height: 70px;
	    display: inline-block;
	    border-radius: 100px;
	    background: white;
	    z-index: 2;
	    position: absolute;
	    left: 0;
	    text-align: center;
	    font-size: 25px;
	}
	
	span.round-tabs.one{
	    color: rgb(34, 194, 34);border: 2px solid rgb(34, 194, 34);
	}
	
	li.active span.round-tabs.one{
	    background: #fff !important;
	    border: 2px solid #ddd;
	    color: rgb(34, 194, 34);
	}
	
	span.round-tabs.two{
	    color: #febe29;border: 2px solid #febe29;
	}
	
	li.active span.round-tabs.two{
	    background: #fff !important;
	    border: 2px solid #ddd;
	    color: #febe29;
	}
	
	span.round-tabs.three{
	    color: #3e5e9a;border: 2px solid #3e5e9a;
	}
	
	li.active span.round-tabs.three{
	    background: #fff !important;
	    border: 2px solid #ddd;
	    color: #3e5e9a;
	}
	
	span.round-tabs.four{
	    color: #f1685e;border: 2px solid #f1685e;
	}
	
	li.active span.round-tabs.four{
	    background: #fff !important;
	    border: 2px solid #ddd;
	    color: #f1685e;
	}
	
	span.round-tabs.five{
	    color: #999;border: 2px solid #999;
	}
	
	li.active span.round-tabs.five{
	    background: #fff !important;
	    border: 2px solid #ddd;
	    color: #999;
	}
	
	.nav-tabs > li.active > a span.round-tabs{
	    background: #fafafa;
	}
	.nav-tabs > li {
	    width: 20%;
	}
	/*li.active:before {
	    content: " ";
	    position: absolute;
	    left: 45%;
	    opacity:0;
	    margin: 0 auto;
	    bottom: -2px;
	    border: 10px solid transparent;
	    border-bottom-color: #fff;
	    z-index: 1;
	    transition:0.2s ease-in-out;
	}*/
	.nav-tabs > li:after {
	    content: " ";
	    position: absolute;
	    left: 45%;
	   opacity:0;
	    margin: 0 auto;
	    bottom: 0px;
	    border: 5px solid transparent;
	    border-bottom-color: #ddd;
	    transition:0.1s ease-in-out;
	    
	}
	.nav-tabs > li.active:after {
	    content: " ";
	    position: absolute;
	    left: 45%;
	   opacity:1;
	    margin: 0 auto;
	    bottom: 0px;
	    border: 10px solid transparent;
	    border-bottom-color: #ddd;
	    
	}
	.nav-tabs > li a{
	   width: 70px;
	   height: 70px;
	   margin: 20px auto;
	   border-radius: 100%;
	   padding: 0;
	}
	
	.nav-tabs > li a:hover{
	    background: transparent;
	}
	
	.tab-content{
	}
	.tab-pane{
	   position: relative;
	padding-top: 50px;
	}
	.tab-content .head{
	    font-family: 'Roboto Condensed', sans-serif;
	    font-size: 25px;
	    text-transform: uppercase;
	    padding-bottom: 10px;
	}
	.btn-outline-rounded{
	    padding: 10px 40px;
	    margin: 20px 0;
	    border: 2px solid transparent;
	    border-radius: 25px;
	}
	
	.btn.green{
	    background-color:#5cb85c;
	    /*border: 2px solid #5cb85c;*/
	    color: #ffffff;
	}
	
	
	
	@media( max-width : 585px ){
	    
	    .board {
	width: 90%;
	height:auto !important;
	}
	    span.round-tabs {
	        font-size:16px;
	width: 50px;
	height: 50px;
	line-height: 50px;
	    }
	    .tab-content .head{
	        font-size:20px;
	        }
	    .nav-tabs > li a {
	width: 50px;
	height: 50px;
	line-height:50px;
	}
	
	.nav-tabs > li.active:after {
	content: " ";
	position: absolute;
	left: 35%;
	}
	
	.btn-outline-rounded {
	    padding:12px 20px;
	    }
	}
</style>


<section style="background: #efefe9;">
	<div class="container">
		<div class="row">
			<div class="board">
				<!-- <h2>Welcome to IGHALO!<sup>™</sup></h2>-->
				<div class="board-inner">
					<ul class="nav nav-tabs" id="myTab">
						<div class="liner"></div>
						<li class="active">
							<a href="#home" data-toggle="tab" title="welcome">
								<span class="round-tabs one">
									<i class="glyphicon glyphicon-barcode"></i>
								</span>
							</a>
						</li>

						<li>
							<a href="#diagnosis" data-toggle="tab" title="diagnosis">
								<span class="round-tabs two"> 
									<i class="glyphicon glyphicon-file"></i>
								</span>
							</a>
						</li>
						<li>
							<a href="#messages" data-toggle="tab" title="bootsnipp goodies"> 
								<span class="round-tabs three">
									<i class="glyphicon glyphicon-folder-open"></i>
								</span>
							</a>
						</li>

						<li>
							<a href="#settings" data-toggle="tab" title="blah blah">
								<span class="round-tabs four">
									<i class="glyphicon glyphicon-user"></i>
								</span>
							</a>
						</li>

						<li>
							<a href="#doner" data-toggle="tab" title="completed">
								<span class="round-tabs five"> 
									<i class="glyphicon glyphicon-ok"></i>
								</span>
							</a>
						</li>

					</ul>
				</div>

				<div class="tab-content">
					<div class="tab-pane fade in active" id="home">
						<!-- IDs -->
						<%= medicalRecord.getHistonumberStart() %> - <%= medicalRecord.getHistonumberEnd() %>
						
					</div>
					<div class="tab-pane fade" id="diagnosis">
						<!-- diagnosis -->
						<div class="card" style="width: 18rem;">
							<div class="card-body">
								<h5 class="card-title">Histologic Description</h5>
						    	<p class="card-text"><%= medicalRecord.getPathologyData().getHistologicDescription() %></p>
						  	</div>
						</div>
						
						<div class="card" style="width: 18rem;">
							<div class="card-body">
								<h5 class="card-title">Macroscopic Description</h5>
						    	<p class="card-text"><%= medicalRecord.getPathologyData().getMacroscopicDescription() %></p>
						  	</div>
						</div>
						
						<div class="card" style="width: 100%;">
							<div class="card-body">
								<h5 class="card-title">Pathologic Diagnosis</h5>
						    	<p class="card-text"><%= medicalRecord.getPathologyData().getPathologicDiagnosis() %></p>
						  	</div>
						</div>

					</div>
					<div class="tab-pane fade" id="messages">
						
						
					</div>
					<div class="tab-pane fade" id="settings">
						

					</div>
					<div class="tab-pane fade" id="doner">
						
						
					</div>
					<div class="clearfix"></div>
				</div>

			</div>
		</div>
	</div>
</section>

<script>
$(function(){
	$('a[title]').tooltip();
});
</script>

<%
}
%>
