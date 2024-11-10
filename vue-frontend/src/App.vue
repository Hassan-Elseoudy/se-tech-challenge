<template>
  <div id="app">
    <Activities />
  </div>
</template>

<script>
import Activities from './components/ActivityList.vue';

export default {
  name: 'App',
  components: {
    Activities
  }
};
</script>

<style>
#app {
  text-align: center;
  padding: 20px;
}
</style>
