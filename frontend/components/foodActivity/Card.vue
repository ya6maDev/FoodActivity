<template>
  <div>
    <b-card :title="foodActivity.title" tag="article" class="mb-2">
      <!-- Tweet -->
      <b-card-text>{{ foodActivity.tweet }}</b-card-text>
      <!-- 詳細リンク -->
      <a href="/foodActivity/:foodActivity.id" class="card-link">詳細</a>
      <div slot="footer">
        <small class="text-muted">更新日 : {{ foodActivity.updateDate }}</small>
        <b-button variant="light">
          <font-awesome-icon icon="thumbs-up" class="headder-icon" />
        </b-button>
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
  }
};
</script>