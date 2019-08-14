export const state = () => ({
  foodActivity: {}
});

export const mutations = {
  getFoodActivitys: function(state, res) {
    state.foodActivitys = { res };
  }
};

export const actions = {
  async getFoodActivityAction({ commit }) {
    const url = "http://localhost:8080/api/foodActivity/";

    const res = await this.$axios.$get(url);
    commit("getFoodActivitys", res);
  }
};
