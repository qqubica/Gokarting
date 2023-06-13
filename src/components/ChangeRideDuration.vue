<template>
  <div>
    <v-btn
        class="ml-10"
        @click="changeDurationClicked"
    >
      Zmień czas trwania przejazdu
    </v-btn>

    <v-dialog
        v-model="changeDurationDialog"
        width="500px"
    >
      <v-card>
        <v-card-title>
          <span class="headline">Zmień czas przejazdu</span>
        </v-card-title>
        <v-card>
          <v-card-text>
            <v-text-field
                v-if="editRide"
                label="Czas trwania"
                v-model="editRide.duration"
            ></v-text-field>
          </v-card-text>
        </v-card>
        <v-card-actions>
          <v-btn color="primary" text @click="changeRideDuration(editRide)">Save</v-btn>
          <v-btn color="red" text @click="cancelDialog()">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
import appConfig from "@/app_config";
export default {
  name: 'ChangeRideDuration',

  data: () => ({
    changeDurationDialog: false,
    editRide: null,
  }),
  methods: {
    changeRideDuration(ride) {
      this.patchRideDuration(ride)
    },

    async patchRideDuration(ride) {
      let rideId = ride._links.self.href.split("/").pop()
      await axios.patch(appConfig.apiUrl + `ride/${rideId}`, ride)
          .then(response => {
            console.log(response)
          })
          .catch(error => {
            console.log(error)
          })
      this.cancelDialog()
    },

    cancelDialog() {
      this.changeDurationDialog = !this.changeDurationDialog
      this.editRide = null
    },

    changeDurationClicked() {
      this.editRide = this.ride
      this.changeDurationDialog = !this.changeDurationDialog
    },
  },
  props: {
    ride: {
      type: Object,
    },
  },
}
</script>

<style scoped>

</style>