<template>
  <v-select
    v-model="selectedRide"
    :items="rides"
    :item-text="item => 'zaplanowany start ' + item.startTime.split('T')[0] + ' - ' + item.startTime.split('T')[1].split('.')[0] + ' (czas trwania:' + item.duration + ')'"
    @change="respondToWorkerSelected($event)"
    return-object
    label="Wybierz przejazd"
    outlined
    class="pl-10"
    style="width: 500px"
    :disabled="isDisabled"
  />
</template>

<script>
import axios from "axios";
import appConfig from "@/app_config";

export default {
  name: 'RideSelect',

  data: () => ({
    rides: [],
    selectedRide: null,
  }),

  methods: {
    respondToWorkerSelected(ride){
      this.$emit('rideSelected', ride)
    },

    async getRides(track) {
      track = track.links.self.href.split("/").pop()
      let apiResponse = await axios({
        method: "GET",
        url: appConfig.apiUrl + `ride/search/findByTrackAndRideStatus?track=/${track}&rideStatus=CREATED`,
      })
          .catch((error) => {
            console.log(error);
            return error;
          });
      this.rides = this.adaptRides(apiResponse.data._embedded.ride)
    },

    adaptRides(rides) {
      return rides.map(r => r)
    },
  },
  props: {
    isDisabled: {
      type: Boolean,
      default: false
    },
    selectedTrack: {
      type: Object,
      required: true,
    },
  },
}
</script>

<style scoped>

</style>