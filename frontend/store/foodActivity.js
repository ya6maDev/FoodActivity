export const state = () => ({
  foodActivitys: {}
});

export const mutations = {
  getFoodActivitys: function(state, res) {
    state.foodActivitys = { res };
  },
  getFoodActivityById: function(state, res) {
    state.foodActivitys = { res };
  },
  insertFoodActivity: function(state, res) {
    state.foodActivitys = { res };
  },
  updateFoodActivity: function(state, res) {
    state.foodActivitys = { res };
  }
};

export const actions = {
  async getFoodActivityAction({ commit }) {
    const url = "http://localhost:8080/api/foodActivity/";

    const res = await this.$axios.$get(url);
    commit("getFoodActivitys", res);
  },
  async getFoodActivityByIdAction({ commit }, req) {
    const url = "http://localhost:8080/api/foodActivity/" + req.id;

    const res = await this.$axios.$get(url);
    commit("getFoodActivityById", res);
  },
  async insertFoodActivityAction({ commit }, req) {
    const url = "http://localhost:8080/api/foodActivity/";

    const res = await this.$axios.$post(url, req.foodActivity);
    commit("insertFoodActivity", res);
  },
  async updateFoodActivityAction({ commit }, req) {
    const url = "http://localhost:8080/api/foodActivity/";

    const res = await this.$axios.$put(url, req.foodActivity);
    commit("updateFoodActivity", res);
  }
};
