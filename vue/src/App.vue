<template>
  <div id="app">
    <!-- <div id="nav">
      <header> Meghan's Plant House</header>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      <router-view />
    <!-- </div> -->
    <!-- <router-link/> -->
  </div>
</template>


<style>
  @import url('https://fonts.googleapis.com/css2?family=Cherry+Bomb+One&display=swap');

  #app {
    font-family: 'Arial', sans-serif;
  }




</style>


