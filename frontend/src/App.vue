<template>
  <main>
    <div id="app">
      <Header />
      <router-view />
    </div>
  </main>
</template>

<script setup>
import Header from "@/components/layout/Header.vue";
</script>