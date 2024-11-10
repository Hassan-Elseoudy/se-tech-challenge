// src/services/activity-service.js
import axios from 'axios';

const BASE_URL = 'http://localhost:8080'; // Update with your actual API URL

const ActivityService = {
    // Fetch activities based on search query
    async searchActivities(query) {
        try {
            const response = await axios.get(`${BASE_URL}/search?title=${query}`);
            return response.data;
        } catch (error) {
            console.error('Error searching activities:', error);
            throw error;
        }
    },

};

export {ActivityService};
