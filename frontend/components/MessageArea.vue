<template>
  <div>
    <b-alert show variant="props.variant">{{ message }}</b-alert>
  </div>
</template>

<script>
export default {
  props: {
    message: {
      type: String,
      default: ""
    },
    variant: {
      type: String,
      default: "info"
    }
  }
};
</script>
