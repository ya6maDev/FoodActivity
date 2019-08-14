<template>
  <div>
    <b-table stacked :items="users"></b-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: []
    };
  },
  created() {
    this.getUserByUserId();
  },
  methods: {
    getUserByUserId: function() {
      this.$store
        .dispatch("user/findUserAction", {
          userId: this.$route.params['id']
        })
        .then(() => {
          this.users.push(this.$store.state.user.users.res);
        });
    }
  }
};
</script>