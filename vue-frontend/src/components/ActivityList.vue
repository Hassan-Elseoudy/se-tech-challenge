<template>
  <div>
    <h1>ActivityList</h1>

    <!-- Search Input -->
    <input
        v-model="searchQuery"
        type="text"
        placeholder="Search for an activity..."
        @input="searchActivities"
        class="search-input"
    />

    <!-- Display the activities -->
    <ul>
      <li v-for="activity in activities" :key="activity.id">
        {{ activity.title }} - {{ activity.price }} - {{ activity.currency }} - {{ activity.location }} -
        {{ activity.rating }} - {{ activity.specialOffer }} - {{ activity.supplierName }} - {{
          activity.supplierLocation
        }}
      </li>
    </ul>
  </div>
</template>

<script>
import {ActivityService} from "../services/activity-service.ts";

export default {
  data() {
    return {
      activities: [],
      searchQuery: "",
    };
  },
  methods: {
    async searchActivities() {
      if (this.searchQuery.trim() === '') {
        return;
      }

      try {
        this.activities = await ActivityService.searchActivities(this.searchQuery);
      } catch (error) {
        console.error('Error searching activities:', error);
      }
    }
  }
};
</script>

<style scoped>
h1 {
  font-size: 2rem;
  margin-bottom: 1rem;
}

.search-input {
  padding: 8px;
  margin-bottom: 1rem;
  width: 100%;
  max-width: 300px;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 10px 0;
  font-size: 1.2rem;
}
</style>
