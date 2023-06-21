<template>
    <div>
        <div id="nav">
            <header> Meghan's Plant House</header>
            <div id="nav-routes">
                <router-link class="navbtn" v-bind:to="{ name: 'home' }">Home</router-link>
                <router-link class="navbtn" v-bind:to="{ name: 'login' }">Login</router-link>
                <router-link class="navbtn" v-bind:to="{ name: 'logout' }"
                    v-if="$store.state.token != ''">Logout</router-link>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'navbar'
}
</script>



<style scoped>
#nav {
    position: sticky;
    top: 0;
    width: 100%;
}

header {
    display: inline-block;
    font-size: 48px;
    font-family: 'Cherry Bomb One', cursive;
    margin-bottom: 20px;
    text-align: center;
    color: #136334;
}

#nav-routes {
    max-width: max-content;
    display: inline-block;
    margin: 24px;
    text-decoration: none;
}

.navbtn {
    padding: 16px;
    text-decoration: none;
}

.navbtn:hover {
    font-size: 110%;
    text-decoration: underline;

}
</style>