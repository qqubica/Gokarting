<template>
  <v-btn
    @click="startRide"
    class="ml-6"
    color="primary"
    :disabled="isDisabled"
  >
    Start ride
  </v-btn>
</template>

<script>
import axios from "axios";

export default {
  name: 'PrepereRideBtn',

  data: () => ({
  }),

  methods: {
    startRide() {
      let rideId = this.ride._links.self.href.split("/").pop()
      axios.get("http://localhost:8080/prepereRide/" + rideId)
          .then(response => {
            this.$emit('preperRide', response.data)
          })
          .catch(error => {
            console.log(error)
          })
    },
  },

  props: {
    ride: {
      type: Object,
    },
    isDisabled: {
      type: Boolean,
      required: false,
    }
  },
}
</script>
<style scoped>

</style>