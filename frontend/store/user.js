export const state = () => ({
  user: {}
});

export const mutations = {
  insertUser: function(state, res) {
    state.users = { res };
  },
  findUser: function(state, res) {
    state.users = { res };
  }
};

export const actions = {
  async insertUserAction({ commit }, req) {
    const url = "http://localhost:8080/api/user/";

    const res = await this.$axios.$post(url, req.user);
    commit("insertUser", res);
  },
  async findUserAction({ commit }, req) {
    const url = "http://localhost:8080/api/user/" + req.userId;

    const res = await this.$axios.$get(url);
    commit("findUser", res);
  },
};
