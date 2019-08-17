<template>
  <div>
    <b-card :title="foodActivity.title" tag="article" class="mb-2">
      <!-- Tweet -->
      <b-card-text>{{ foodActivity.tweet }}</b-card-text>
      <!-- 詳細リンク -->
      <a :href="url + foodActivity.id" class="card-link">詳細</a>
      <div slot="footer">
        <small class="text-muted">
          更新日 : {{ foodActivity.updateDate }}
          <b-button variant="light">
            <font-awesome-icon icon="thumbs-up" class="headder-icon" @click="onClickLikeBtn" />
          </b-button>
          {{ likeCount }}
        </small>
      </div>
    </b-card>
  </div>
</template>

<script>
export default {
  props: {
    foodActivity: {
      type: Object,
      default: {}
    }
  },
  data() {
    return {
      url: '/foodActivity/',
      likePressFlg: false,
      likeCount: 0
    };
  },
  methods: {
    onClickLikeBtn(env) {
      if (!this.likePressFlg) {
        this.likeCount = this.likeCount + 1;
        this.likePressFlg = true;
      }
    }
  }
};
</script>