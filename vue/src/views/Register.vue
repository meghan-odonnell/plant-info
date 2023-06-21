<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1 class="form-title">Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button class="form-button" type="submit">Create Account</button>
      <p id="login">Already have an account? <router-link class="link" :to="{ name: 'login' }">Log in</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#register {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  /* background-image: url('https://images3.alphacoders.com/129/1297776.jpg'); */
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

#login {
  padding-top: 32px;
  text-align: center;
}

.link {
  color: #5dbb8b;
  text-decoration: none;
  text-align: center;
}
.link:hover {
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
