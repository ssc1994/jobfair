<template>
  <div>

    <Header v-if="link == '/' "></Header>
    <router-view/>
  </div>
</template>

<script>
import Header from './components/layout/HeaderView';
// import Footer from './layout/FooterView';

export default  {
  link : document.location.pathname,
  isChecked: false,
  components: {
    Header
    // Footer
  },
  created() {
    console.log(document.location.pathname)
    if(document.location.pathname == '/') {

      this.isChecked = true;
    } else {
      this.isChecked = false;
    }
    console.log(this.isChecked)
  }


}



</script>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
