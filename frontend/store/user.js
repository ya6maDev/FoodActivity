export const state = () => ({
  user: {}
});

export const mutations = {
  insertUser: function(state, res) {
    state.users = { res };
  },
  updateUser: function(state, res) {
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
  async updateUserAction({ commit }, req) {
    const url = "http://localhost:8080/api/user/";

    const res = await this.$axios.$put(url, req.user);
    commit("updateUser", res);
  },
  async findUserByUserIdAction({ commit }, req) {
    const url = "http://localhost:8080/api/user/" + req.userId;

    const res = await this.$axios.$get(url);
    commit("findUser", res);
  },
};
