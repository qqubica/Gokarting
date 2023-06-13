<template>
  <div>
    <v-row>
      <v-col>
        <WorkerSelect
            @workerSelected="respondToWorkerSelected"
            :isDisabled="ridePreparing"
        />
        <LocalisationSelect
            ref="localisationSelect"
            v-if="workerSelect"
            @localizationSelected="respondToLocalizationSelected"
            :isDisabled="ridePreparing"
        />
        <TrackSelect
            ref="trackSelect"
            v-if="localizationSelect"
            @trackSelected="respondToTrackSelected"
            :isDisabled="ridePreparing"
        />
        <RideSelect
            ref="rideSelect"
            v-if="trackSelect"
            @rideSelected="respondToRideSelected"
            :isDisabled="ridePreparing"
        />
        <v-row>
          <ChangeRideDuration
              v-if="rideSelect"
              :ride="selectedRideData"
              :isDisabled="ridePreparing"
          />
          <PrepereRideBtn
              v-if="rideSelect"
              :ride="selectedRideData"
              @preperRide="respondToPreperRide"
              :isDisabled="ridePreparing"
          />
        </v-row>
      </v-col>
      <v-col v-if="ridePreparing">

      </v-col>
    </v-row>
  </div>
</template>

<script>
import LocalisationSelect from "@/components/LocalisationSelect.vue";
import WorkerSelect from "@/components/WorkerSelect.vue";
import TrackSelect from "@/components/TrackSelect.vue";
import RideSelect from "@/components/RideSelect.vue";
import ChangeRideDuration from "@/components/ChangeRideDuration.vue";
import PrepereRideBtn from "@/components/PrepereRideBtn.vue";
export default {

  components: {
    PrepereRideBtn,
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
    ridePreparing: false,

    selectedWorkerData: null,
    selectedLocalizationData: null,
    selectedTrackData: null,
    selectedRideData: null,
    ridePrepereData: null,
  }),

  methods: {
    respondToPreperRide(data) {
      this.ridePreparing = true
      this.ridePrepereData = data
      // this.$emit('preperRide', data)
    },

    respondToRideSelected(data) {
      this.rideSelect = true
      this.selectedRideData = data
      this.$emit('rideSelected', data)
    },

    respondToTrackSelected(data) {
      this.selectedTrackData = data
      this.trackSelect = true
      this.$nextTick(() => {
        this.$refs.rideSelect.getRides(this.selectedTrackData)
      })
    },

    respondToWorkerSelected(data){
      this.selectedWorkerData = data
      this.workerSelect = true
      this.$nextTick(() => {
        this.$refs.localisationSelect.getLocalizations()
      })
    },

    respondToLocalizationSelected(data) {
      this.selectedLocalizationData = data
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