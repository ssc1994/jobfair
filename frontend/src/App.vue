<template>
  <div>
    <Header v-if="!isChecked"></Header>
    <router-view/>
  </div>
</template>

<script>
import Header from './components/layout/HeaderView';
// import Footer from './layout/FooterView';

export default  {
  isChecked: false,
  components: {
    Header,
    // Footer
  },
  created() {
    if(document.location.pathname === '/') {
      this.isChecked = true;
      console.log(this.isChecked)
    } else {
      this.isChecked = false;
    }
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
