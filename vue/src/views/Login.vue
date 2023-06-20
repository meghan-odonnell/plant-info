<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 class="form-title">Welcome to Meghan's Plant House</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
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
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
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
.login-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f2f5f1;
  font-family: 'Arial', sans-serif;
}

.form-title {
  font-size: 28px;
  font-family: 'Cherry Bomb One', cursive;
  margin-bottom: 20px;
  text-align: center;
  color:#4a9f6e;
}

.alert-message {
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 5px;
  font-size: 14px;
  color: #c75f4b;
  background-color: #f9e3e0;
}

.input-label {
  display: block;
  font-size: 16px;
  color: #2b3a2d;
}

.form-input-group {
  width: 300px;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ced4cf;
  border-radius: 50px;
  font-size: 14px;
  color: #2b3a2d;
  background-color: #ffffff;
}

.form-button {
  width: 150px;
  padding: 10px;
  border: none;
  /* border-radius: 5px; */
  border-radius: 50px;
  font-size: 16px;
  color: #ffffff;
  background-color: #5dbb8b;
  cursor: pointer;
}

.form-button:hover {
  background-color: #4a9f6e;
}

.register-link {
  font-size: 14px;
  color: #2b3a2d;
  text-align: center;
}

.router-link {
  color: #5dbb8b;
  text-decoration: none;
}

.router-link:hover {
  text-decoration: underline;
}

label {
  color:#2b3a2d;
  font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif
}
</style>