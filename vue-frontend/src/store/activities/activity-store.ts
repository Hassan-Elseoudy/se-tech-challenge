import {createStore} from 'vuex'

// TODO: for a better state management, we should use the stores, but for now, we will use ad-hoc state management
const store = createStore({
    state() {
        return {
            activities: [],
        }
    },
    actions: {},
    mutations: {},
    getters: {}
})

export default store;
