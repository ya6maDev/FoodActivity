<template>
  <div class="container">
    <div v-show="messageFlg">
      <MessageArea :message="message" :variant="variant"></MessageArea>
    </div>
    <b-form @submit.prevent="login" v-if="show">
      <b-form-group id="input-group-1" label="ユーザーID" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="user.email"
          type="email"
          required
          placeholder="Enter email"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="パスワード" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="user.password"
          type="password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>

      <b-button type="submit" variant="primary">ログイン</b-button>
      <b-button type="button" variant="success" href="/user">新規登録</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ user }}</pre>
    </b-card>
  </div>
</template>

<script>
import MessageArea from "~/components/common/MessageArea.vue";

export default {
  components: {
    MessageArea
  },
  data() {
    return {
      user: {},
      error: null,
      show: true,
      messageFlg: false,
      message: "",
      variant: "info"
    };
  },
  methods: {
    login() {
      this.$auth
        .loginWith("local", {
          data: this.user
        })
        .then(res => {
					console.log('ログイン成功');
        })
        .catch(err => {
          console.log(err);
          this.messageFlg = true;
          this.message = "ログイン処理に失敗しました。";
          this.variant = "danger";
        });
    }
  }
};
</script>