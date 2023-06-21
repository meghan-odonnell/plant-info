<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 class="form-title">Welcome back</h1>
      <div class="alert-message" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert-message" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button class="form-button" type="submit">Sign in</button>
      <p id="register">
        Need an account? 
      <router-link class="register-link" :to="{ name: 'register' }">Sign up here</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>


<style scoped>


#login {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-image: url('https://images3.alphacoders.com/129/1297776.jpg');
  background-color: #0c3f13;
  
  font-family: 'Arial', sans-serif;
}

form{
  max-width: 400px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
  background-color: rgba(239, 242, 239, 0.8);
  padding: 16px;
  font-size: 16px;
}

.form-title {
  font-size: 32px;
  font-family: 'Cherry Bomb One';
  margin-bottom: 20px;
  text-align: center;
  color:#4a9f6e;
}

.form-input-group {
  width: 300px;
  margin-bottom: 20px;
}

label {
  display: block;
  color:#2b3a2d;
  padding-bottom: 4px;
  padding-left: 4px;
}

input[type="text"],
input[type="password"] {
  align-items: center;
  width: stretch;
  height: 20px;
  padding:10px;
  border: 1px solid #ccc;
  border-radius: 50px;
}
.form-button {
  width: stretch;
  align-items: center;
  padding: 10px;
  border: none;
  border-radius: 50px;
  color: #ffffff;
  background-color: #5dbb8b;
  font-size: 16px;
  cursor: pointer;
}

.form-button:hover {
  background-color: #4a9f6e;
}

#register {
  padding-top: 32px;
  text-align: center;
}

.register-link {
  color: #5dbb8b;
  text-decoration: none;
  text-align: center;
}
.register-link:hover {
  text-decoration: underline;
}

.alert-message {
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 5px;
  font-size: 14px;
  color: #c75f4b;
  background-color: #f9e3e0;
}

</style>