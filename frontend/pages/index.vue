<template>
  <div class="container">
    <FoodActivityForm></FoodActivityForm>

    <div v-for="foodActivity in foodActivitys" v-bind:key="foodActivity.id">
      <b-card :title="foodActivity.name" tag="article" class="mb-2">
        <!-- Tweet -->
        <b-card-text>{{ foodActivity.tweet }}</b-card-text>
        <!-- 詳細リンク -->
        <a href="/foodActivity/:foodActivity.id" class="card-link">詳細</a>
        <div slot="footer">
          <small class="text-muted">更新日 : {{ foodActivity.updateDate }}</small>
        </div>
      </b-card>
    </div>
  </div>
</template>

<script>
import FoodActivityForm from "~/components/foodActivity/Form.vue";

export default {
  components: {
    FoodActivityForm
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