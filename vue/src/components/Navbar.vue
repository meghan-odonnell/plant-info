<template>
  
  <div>
    <div id="nav">
      <header> Meghan's Plant House</header>
      <div id="nav-routes">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
      </div>
  </div>
    
   
</template>

<script>
export default {
    name: 'navbar'
}
</script>



<style>

#nav {
    /* display: grid; */
    position: sticky;
    top: 0;
    width: 100%;
  }

  header {
  font-size: 48px;
  font-family: 'Cherry Bomb One', cursive;
  margin-bottom: 20px;
  text-align: center;
  color:#136334;
}

#nav-routes {
  display: flex;
  justify-content: space-evenly;
  margin: 8px;
  text-decoration: none;
  /* font-family: 'Arial', sans-serif; */
}
</style>