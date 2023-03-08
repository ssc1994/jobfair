<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light" style="font-size: 20px; height:100%;" >
    <div class="container-fluid" style="width:1200px;">
      <a class="navbar-brand" href="#">logo</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">채용공고</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">마이페이지</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Pricing</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown link
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit" style="border: 1px solid blue, background-color:{{blue}}" @mouseover='OnBlue'>Search</button>
        </form>
      </div>



    </div>
  </nav>
</template>

<script>
export default {
  name: "HeaderView2",
  data : function(){
    blue : "#efefef"
  },
  methods : {
    onBlue (){
      blue = "blue";
    }
  }
}
</script>

<style scoped>

</style>
