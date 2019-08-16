<template>
  <div class="container">
    <b-container class="bv-example-row">
      <b-row>
        <b-col>Side menu Area</b-col>
        <b-col cols="8">
          <!-- Tweet 投稿フォーム -->
          <FoodActivityForm></FoodActivityForm>

          <!-- Tweet Cardリスト -->
          <div v-for="foodActivity in foodActivitys" v-bind:key="foodActivity.id">
            <FoodActivityCard :foodActivity="foodActivity"></FoodActivityCard>
          </div>
        </b-col>
        <b-col>Trend Area</b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import FoodActivityForm from "~/components/foodActivity/Form.vue";
import FoodActivityCard from "~/components/foodActivity/Card.vue";

export default {
  components: {
    FoodActivityForm,
    FoodActivityCard
  },
  data() {
    return {
      foodActivitys: []
    };
  },
  created() {
    this.getFoodActivitys();
  },
  methods: {
    getFoodActivitys: function() {
      this.$store
        .dispatch("foodActivity/getFoodActivityAction", {})
        .then(() => {
          this.foodActivitys = this.$store.state.foodActivity.foodActivitys.res;
        });
    }
  }
};
</script>