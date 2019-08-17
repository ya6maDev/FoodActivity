<template>
  <div class="container">
    <div v-show="messageFlg">
      <MessageArea :message="message" :variant="variant"></MessageArea>
    </div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-1" label="タイトル:" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="foodActivity.title"
          :plaintext="updateFlg"
          required
          placeholder="タイトルを入力下さい。"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Tweet:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="foodActivity.tweet"
          :plaintext="updateFlg"
          required
          placeholder="Tweetを入力下さい。"
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
      <pre class="m-0">{{ foodActivity }}</pre>
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
      foodActivity: {},
      show: true,
      updateFlg: true,
      messageFlg: false,
      message: "",
      variant: "info"
    };
  },
  created() {
    this.getFoodActivityById();
  },
  methods: {
    getFoodActivityById: function() {
      this.$store
        .dispatch("foodActivity/getFoodActivityByIdAction", {
          id: this.$route.params["id"]
        })
        .then(() => {
          this.foodActivity = this.$store.state.foodActivity.foodActivitys.res;
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
        .dispatch("foodActivity/updateFoodActivityAction", {
          foodActivity: this.foodActivity
        })
        .then(() => {
          this.foodActivity = this.$store.state.foodActivity.foodActivitys.res;
          this.messageFlg = true;
          this.message = "FoodActivity情報の更新に成功しました。";
          this.variant = "success";
        });
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.foodActivity.title = "";
      this.foodActivity.tweet = "";
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>