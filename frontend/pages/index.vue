<template>
  <div class="container">
    <b-container class="bv-example-row">
      <b-row>
        <b-col>
          <SideMenuBar></SideMenuBar>
        </b-col>
        <b-col cols="8">
          <!-- Tweet 投稿フォーム -->
          <FoodActivityForm></FoodActivityForm>

          <!-- Tweet Cardリスト -->
          <div v-for="foodActivity in foodActivitys" v-bind:key="foodActivity.id">
            <FoodActivityCard :foodActivity="foodActivity"></FoodActivityCard>
          </div>
        </b-col>
        <b-col>
          <SideTrendBar></SideTrendBar>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import FoodActivityForm from "~/components/foodActivity/Form.vue";
import FoodActivityCard from "~/components/foodActivity/Card.vue";
import SideMenuBar from "~/components/foodActivity/SideMenuBar.vue";
import SideTrendBar from "~/components/foodActivity/SideTrendBar.vue";
import { mapGetters } from 'vuex'

export default {
  components: {
    FoodActivityForm,
    FoodActivityCard,
    SideMenuBar,
    SideTrendBar
  },
  data() {
    return {
      foodActivitys: []
    };
  },
  created() {
    this.getFoodActivitys();
  },
  computed: {
    ...mapGetters(['isAuthenticated', 'loggedInUser'])
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