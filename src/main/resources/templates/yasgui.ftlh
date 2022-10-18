<html lang="en">

<head>
	<meta charset="utf-8">
	<title>SPARQL Endpoint</title>

	<!--link href='http://cdn.jsdelivr.net/g/yasqe@2.2(yasqe.min.css),yasr@2.4(yasr.min.css)' rel='stylesheet' type='text/css' /-->

	<link href="https://unpkg.com/@triply/yasgui/build/yasgui.min.css" rel="stylesheet" type="text/css" />
    <script src="https://unpkg.com/@triply/yasgui/build/yasgui.min.js"></script>


	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<!-- Custom fonts for this template -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

	<style>
		.query-button {padding:4px 8px;}
	</style>

</head>

<body>
    <!-- Responsive navbar-->
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
          <a class="navbar-brand" href="#">SPARQL Endpoint</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
              <li class="nav-item"><a class="nav-link active" aria-current="page" href="..">Home</a></li>
              <li class="nav-item"><a class="nav-link active" aria-current="page" href="yasgui">SPARQL</a></li>
              <li class="nav-item"><a class="nav-link active" aria-current="page" href="logout">Logout</a></li>
            </ul>
          </div>
        </div>
      </nav>
	<section>
		<div class="container">

			<div class="row">
				<div class="col-lg-12" id="yasgui"></div>
			</div>

		</div>
	</section>

	<script src='http://cdn.jsdelivr.net/yasr/2.4/yasr.bundled.min.js'></script>
	<script src='http://cdn.jsdelivr.net/yasqe/2.2/yasqe.bundled.min.js'></script>

	<script>
	var yasgui;
	window.addEventListener("load", function() {

	  yasgui = new Yasgui(document.getElementById("yasgui"), {
	    requestConfig: {
	      endpoint: '${endpoint}'
	    },
	    copyEndpointOnNewTab: false
	  });


	});
	</script>
</body>
