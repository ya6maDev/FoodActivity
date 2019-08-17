<template>
  <div class="container">
    <div v-show="messageFlg">
      <MessageArea :message="message" :variant="variant"></MessageArea>
    </div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-1" label="名前:" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="user.userName"
          :plaintext="updateFlg"
          required
          placeholder="名前を入力下さい。"
        ></b-form-input>
      </b-form-group>

      <div v-if="updateFlg">
        <b-button type="button" variant="primary" @click="onClick">編集</b-button>
      </div>
      <div v-else>
        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">クリア</b-button>
      </div>
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
      user: {
        userName: ""
      },
      show: true,
      updateFlg: true,
      messageFlg: false,
      message: "",
      variant: "info"
    };
  },
  created() {
    this.getUserByUserId();
  },
  methods: {
    getUserByUserId: function() {
      this.$store
        .dispatch("user/findUserByUserIdAction", {
          userId: this.$route.params["id"]
        })
        .then(() => {
          this.user = this.$store.state.user.users.res;
        });
    },
    onClick(evt) {
      evt.preventDefault();
      this.updateFlg = false;
      this.messageFlg = false;
      this.message = "";
      this.variant = "";
    },
    onSubmit(evt) {
      evt.preventDefault();
      this.updateFlg = true;
      this.$store
        .dispatch("user/updateUserAction", {
          user: this.user
        })
        .then(() => {
          this.user = this.$store.state.user.users.res;
          this.messageFlg = true;
          this.message = "ユーザー情報の更新に成功しました。";
          this.variant = "success";
        });
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.user.userName = "";
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>