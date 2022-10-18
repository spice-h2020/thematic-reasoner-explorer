<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Stories explorer</title>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="css/styles.css" rel="stylesheet" />
</head>

<body>
  <!-- Responsive navbar-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">DMH Stories Explorer</a>
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
  <div class="container">

    <div class="row mt-1">

      <div class="col-3">

        <div class="row mt-1">
          <div class="col">
            <input class="form-control" id="themeFilter" type="text" placeholder="Filter themes..">
          </div>
        </div>

        <#list themes as theme>
          <div class="row">
            <div class="col">
              <button type="button" class="btn w-100 btn-secondary theme-button" theme="${theme.uri}">${theme.label}</button>
            </div>
          </div>
        </#list>

      </div>

      <div class="col-9" id="results">

      </div>

    </div>
  </div>
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>
</body>

</html>
