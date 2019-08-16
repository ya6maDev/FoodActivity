<template>
  <div class="container">
    <div v-show="messageFlg">
      <MessageArea :message="message" :variant="variant"></MessageArea>
    </div>
    <b-form @submit="onSubmit" v-if="show">
      <b-form-input id="textarea" v-model="foodActivity.name" placeholder="タイトルをつけよう！"></b-form-input>
      <b-form-textarea
        id="textarea"
        v-model="foodActivity.tweet"
        placeholder="食べたものについて、つぶやいてみよう！"
        rows="3"
        max-rows="6"
      ></b-form-textarea>

      <b-button type="submit" variant="primary">Tweet</b-button>
    </b-form>
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
      foodActivity: {
        name: "",
        userId: 2,
        tweet: ""
      },
      show: true,
      messageFlg: false,
      message: "",
      variant: "info"
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      console.log(this.foodActivity);
      this.$store
        .dispatch("foodActivity/insertFoodActivityAction", {
          foodActivity: this.foodActivity
        })
        .then(() => {
          this.foodActivity = this.$store.state.foodActivity.foodActivitys.res;
          this.messageFlg = true;
          this.message = "Tweetしました！";
          this.variant = "success";
        });
    }
  }
};
</script>