<template>
  <div>
    <WorkerSelect
        @workerSelected="respondToWorkerSelected"
    />
    <LocalisationSelect
        ref="localisationSelect"
        v-if="workerSelect"
        @localizationSelected="respondToLocalizationSelected"
    />
    <TrackSelect
        ref="trackSelect"
        v-if="localizationSelect"
        @trackSelected="respondToTrackSelected"
    />
    <RideSelect
        ref="rideSelect"
        v-if="trackSelect"
        @rideSelected="respondToRideSelected"
    />
    <v-row>
      <ChangeRideDuration
          v-if="rideSelect"
          :ride="selectedRide"
      />

    </v-row>
  </div>
</template>

<script>
import LocalisationSelect from "@/components/LocalisationSelect.vue";
import WorkerSelect from "@/components/WorkerSelect.vue";
import TrackSelect from "@/components/TrackSelect.vue";
import RideSelect from "@/components/RideSelect.vue";
import ChangeRideDuration from "@/components/ChangeRideDuration.vue";
export default {

  components: {
    ChangeRideDuration,
    RideSelect,
    TrackSelect,
    LocalisationSelect,
    WorkerSelect,
  },

  data: () => ({
    workerSelect: false,
    localizationSelect: false,
    trackSelect: false,
    rideSelect: false,

    selectedWorker: null,
    selectedLocalization: null,
    selectedTrack: null,
    selectedRide: null,
  }),

  methods: {
    respondToRideSelected(data) {
      this.rideSelect = true
      this.selectedRide = data
      this.$emit('rideSelected', data)
    },

    respondToTrackSelected(data) {
      this.selectedTrack = data
      this.trackSelect = true
      this.$nextTick(() => {
        this.$refs.rideSelect.getRides(this.selectedTrack)
      })
    },

    respondToWorkerSelected(data){
      this.selectedWorker = data
      this.workerSelect = true
      this.$nextTick(() => {
        this.$refs.localisationSelect.getLocalizations()
      })
    },

    respondToLocalizationSelected(data) {
      this.selectedLocalization = data
      this.localizationSelect = true
      this.$nextTick(() => {
        this.$refs.trackSelect.getTracks(data)
      })
    },

  },
}
</script>

<style scoped>

</style>