<template>
  <div class="home">
    <navbar></navbar>
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
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

/* grid-container {
  display: grid;
} */
body {
  /* https://www.eggradients.com/gradient/fresh */
/* background-color: #378b29;
background-image: linear-gradient(10deg, #378b29 0%, #ffffff 70%);
background-size: stretch; */
}
</style>
