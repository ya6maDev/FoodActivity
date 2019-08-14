<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-1" label="名前:" label-for="input-1">
        <b-form-input id="input-1" v-model="user.userName" required placeholder="名前を入力下さい。"></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group-2"
        label="メールアドレス:"
        label-for="input-2"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-2"
          v-model="user.email"
          type="email"
          required
          placeholder="メールアドレスを入力下さい。"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="パスワード:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="user.password"
          type="password"
          required
          placeholder="パスワードを入力下さい。"
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">登録</b-button>
      <b-button type="reset">クリア</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ user }}</pre>
    </b-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        userName: "",
        email: "",
        password: ""
      },
      show: true
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      this.$store
        .dispatch("user/insertUserAction", {
          user: this.user 
        })
        .then(() => {
          const userId = this.$store.state.user.users.res.userId
          this.$router.push('/user/' + userId)
        });
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.user.userName = "";
      this.user.email = "";
      this.user.password = "";
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>