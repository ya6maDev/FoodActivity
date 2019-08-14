<template>
  <div class="container">
    <b-table striped hover :items="foodActivitys"></b-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      foodActivitys: []
    };
  },
  created() {
    this.getFoodActivitys()
  },
  methods: {
    getFoodActivitys: function() {
      this.$store
        .dispatch("foodActivity/getFoodActivityAction", {})
        .then(() => {
          this.foodActivitys = this.$store.state.foodActivity.foodActivitys.res
        });
    }
  }
};
</script>