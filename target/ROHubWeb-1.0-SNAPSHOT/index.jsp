<%@ page contentType="text/html; charset=utf-8" language="java"  import="java.util.*, com.oeg.rohubweb.ParseROs, com.oeg.rohubweb.RO"%>

<!DOCTYPE html>
<html lang="en" prefix="dc: http://purl.org/dc/terms/ schema: http://schema.org/ prov: http://www.w3.org/ns/prov#">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>rohub.linkeddata.es</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="landing page for rohub.linkeddata.es" />
    <meta property="dc:creator prov:wasAttributedTo schema:creator" content="http://delicias.dia.fi.upm.es/members/DGarijo/#me" />
    <meta property="dc:contributor prov:wasAttributedTo schema:contributor" content="http://delicias.dia.fi.upm.es/members/mpoveda/" />
    <meta property="prov:wasDerivedFrom" content="http://vocab.linkeddata.es" />
    
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap-transition.js"></script>
    <script src="assets/js/bootstrap-alert.js"></script>
    <script src="assets/js/bootstrap-modal.js"></script>
    <script src="assets/js/bootstrap-dropdown.js"></script>
    <script src="assets/js/bootstrap-scrollspy.js"></script>
    <script src="assets/js/bootstrap-tab.js"></script>
    <script src="assets/js/bootstrap-tooltip.js"></script>
    <script src="assets/js/bootstrap-popover.js"></script>
    <script src="assets/js/bootstrap-button.js"></script>
    <script src="assets/js/bootstrap-collapse.js"></script>
    <script src="assets/js/bootstrap-carousel.js"></script>
    <script src="assets/js/bootstrap-typeahead.js"></script>

    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72pcomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="assets/ico/favicon.png">
  </head>

  <body resource="" typeof="foaf:Document schema:WebPage">

    <div class="container">

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1 property="dc:title schema:name">rohub.linkeddata.es</h1>
        <p class="lead" property="dc:description">Here you can find the Research Objects that support the papers the <a href = "http://www.oeg-upm.net" target="_blank">Ontology Engineering Group (OEG)</a> is researching on.
        This page is generated automatically, based on the rdf-a descriptions used within the Research Objects.</p>
      </div>

      <hr />
      
		<%		
		ParseROs processVocabs = new ParseROs();
		ArrayList<RO> ros = processVocabs.getROs();
		
		for (int i = 0; i < ros.size() ; i++){
			//print 1 row for each 3 vocabs
			
			RO currentRO = ros.get(i);
			
			if (i % 3 == 0){ //if it is th first vocabulary of the row open it
				out.println("<div class=\"row\">");
			}
			
			//print the vocabulary at any case
			%>
			<div class="span4">
	          <h2><a href="<%out.print(currentRO.getUri()); %>" target="_blank"><%out.print(currentRO.getTitle()); %></a></h2>
                  <p><% if (currentRO.getAbstractSection().equals("")) {
	        	  		out.print("Can't believe you didn't include a dc:abstract in your RO!");
					}
			        else{
                                    String s = currentRO.getAbstractSection();
                                    if(s.length()<250)
			        	out.print(s);
                                    else{
                                        out.print(s.substring(0, 250)+"... (click <a href=\""+currentRO.getUri()+"\" target=\"_blank\">here</a>  to see more)");
                                    }
			        }
	          		 %></p>
	          <!--<p>
                    add all the different descriptions for the ros here.
                   </p>-->
	          <!-- <p><a class="btn" href="<%out.print(currentRO.getUri()); %>">Query vocab &raquo;</a></p> -->
	        </div>
			<%
			
			if ((i % 3 == 2) || ( i == ros.size()-1)){ //if it is the third or last vocabulary close the row
				out.println("</div>");
			}
 		}
		
		%>
 
      <hr />

      <footer>
      
      <div class="row">
    	<div class="span10">
    		Team: 
	        <a href = "http://delicias.dia.fi.upm.es/members/dgarijo/" target="_blank">Daniel Garijo</a> -
	        <a href = "http://delicias.dia.fi.upm.es/members/mpoveda/" target="_blank">María Poveda</a> (site designer)
	       
	        <br />
	        Latest revision January 2014
        </div>
    	<div class="span2">
    		<a href="http://www.oeg-upm.net/" target="_blank"><img src="images/logoOEG.png" alt="OEG logo" /></a>
    	</div>
      </div>

      </footer>

    </div> 

   
    
    <!--Google analyitcs' code -->
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){ (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-47002640-1', 'linkeddata.es');
        ga('send', 'pageview');

    </script>

  </body>
</html>
