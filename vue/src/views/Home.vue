<template>
  <div class="home">
    <navbar></navbar>
    <div id="home-container">
    <div id="home-left">
    <h1>Welcome, planties!</h1>
    <p>Paroxysm of global death explorations quasar kindling the energy hidden in matter colonies of brilliant syntheses. Stirred by starlight concept of the number one stirred by starlight another world extraordinary claims require extraordinary evidence courage of our questions? Are creatures of the cosmos stirred by starlight two ghostly white figures in coveralls and helmets are softly dancing realm of the galaxies from which we spring made in the interiors of collapsing stars and billions upon billions upon billions upon billions upon billions upon billions upon billions.</p>
  </div>
  <div id="home-right">
    <img src="https://i.pinimg.com/736x/89/e9/71/89e971acf50a9f04a8f4525583e345aa.jpg" alt="Cute Robot Holding a Plant"/>      
  </div>
  </div>
  </div>
</template>

<script>
import Navbar from '../components/Navbar.vue';
export default {
  components: { Navbar },
  name: "home"
};
</script>

<style>

#home-container {
  display: flex;
}
</style>
