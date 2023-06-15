<template>
  <div class="mt-10">
    <h3>Przypisz klientów do gokartów</h3>
    <v-row >
      <v-col>
        <draggable
            :list="clients"
            group="clients"
            :animation="100"
        >
          <v-list-item
              v-for="client in clients"
              :key="client.id"
          >
            {{ `${client.name} (${client.id})` }}
          </v-list-item>
        </draggable>
      </v-col>
      <v-col>
        <draggable
            :list="selectedGokarts"
            group="gokarts"
            @change="selectedGokartChange"
            :animation="100"
        >
          <v-list-item
              v-for="gokart in selectedGokarts"
              :key="gokart.id"
          >
            gokart ({{  gokart.id }})
          </v-list-item>
        </draggable>
      </v-col>
      <v-col>
        <draggable
            :list="gokarts"
            group="gokarts"
            :animation="100"
        >
          <v-list-item
              v-for="gokart in gokarts"
              :key="gokart.id"
          >
            gokart ({{  gokart.id }})
          </v-list-item>
        </draggable>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-btn
            @click="prepereRide"
            color="primary"
            :disabled="prepereRideBtnDisabled"
        >
          Gokarty przpisane
        </v-btn>
      </v-col>
      <v-col>
        <v-btn
            v-if="ridePrepered"
            color="secondary"
            @click="startRide"
        >
          Start Ride
        </v-btn>
      </v-col>
    </v-row>
    <v-snackbar v-model="rideStarted">Przejazd rozpoczęty</v-snackbar>
  </div>
</template>

<script>
import draggable from 'vuedraggable'
import axios from "axios";
import appConfig from "@/app_config";
export default {
  name: 'GokartClientDrager',

  data: () => ({
    gokarts: [],
    clients: [],
    selectedGokarts: [],
    ridePrepered: false,
    rideStarted: false,
  }),

  methods: {
    async startRide() {
      await axios({
        method: "GET",
        url: appConfig.apiUrl + "startRide/" + this.ride._links.self.href.split("/").pop() + "/" + this.selectedWorkerData.links.self.href.split("/").pop()
      })
          .then(() => {
            this.rideStarted = true
            this.$emit('rideStarted')
          })
          .catch(error => {
            console.log(error)
          })
    },

    async prepereRide() {
      if (this.clients.length != this.selectedGokarts.length) {
        return
      }

//        map clientId gokartId
      let body = {}
      for (let i = 0; i < this.clients.length; i++) {
        body[this.clients[i].id] = this.selectedGokarts[i].id
      }

      let url = appConfig.apiUrl+'updateRideGokartClient/' + this.ride._links.self.href.split("/").pop()

      await axios({
        method: 'PATCH',
        url:url,
        data: body
      })
          .then(() => {
            this.ridePrepered = true
          })
          .catch(error => {
            console.log(error)
          })
    },

    selectedGokartChange(event) {
      if (!event.added) {
        return
      }
      let element = event.added.element
      if(this.selectedGokarts.length > this.clients.length) {
        this.selectedGokarts = this.selectedGokarts.filter(gokart => gokart.id != element.id)
        this.gokarts.push(element)
      }
    },
  },

  computed: {
    prepereRideBtnDisabled() {
      return this.ridePrepered || (this.clients.length != this.selectedGokarts.length)
    }
  },

  mounted() {
    this.clients = this.ridePrepereData.clients
    this.gokarts = this.ridePrepereData.gokarts
  },

  props: {
    ridePrepereData: {
      type: Object,
      required: true,
    },
    ride: {
      type: Object,
      required: true,
    },
    selectedWorkerData: {
      type: Object,
      required: true,
    },
  },

  components: {
    draggable,
  },
}
</script>

<style scoped>

</style>