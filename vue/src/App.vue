<template>
  <div id="app">
    <div id="nav">
      <header> Meghan's Plant House</header>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>


<style>
  @import url('https://fonts.googleapis.com/css2?family=Cherry+Bomb+One&display=swap');


  header {
  font-size: 48px;
  font-family: 'Cherry Bomb One', cursive;
  margin-bottom: 20px;
  text-align: center;
  color:#136334;
}
</style>


