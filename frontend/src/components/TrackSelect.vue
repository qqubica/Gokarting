<template>
  <v-select
      v-model="selectedTrack"
      :items="tracks"
      :item-text="item => `długość:${item.length}m śr. prędkość: ${item.avgSpeed}km/h liczba zakrętów:${item.nrOfTurns}`"
      @change="trackSelected($event)"
      return-object
      label="Wybierz tor"
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
  name: 'TrackSelect',

  data: () => ({
    tracks: [],
    selectedTrack: null,
  }),

  methods: {
    async getTracks(loc) {
      let localization = loc.links.self.href.split("/").pop()

      let apiResponse = await axios({
        method: "GET",
        url: appConfig.apiUrl + `track/search/getTrackByLocalisation?localisation=/${localization}`,
      })
      .catch((error) => {
        console.log(error);
        return error;
      });

      this.tracks = this.adaptTracks(apiResponse.data._embedded.track)
    },

    adaptTracks(tracks){
      return tracks.map(t => {
        return {
          length: t.length,
          avgSpeed: t.avgSpeed,
          nrOfTurns: t.nrOfTurns,
          links: t._links,
        }
      });
    },
    trackSelected(track){
      this.$emit('trackSelected', track)
    },
  },
  props: {
    isDisabled: {
      type: Boolean,
      required: false
    }
  },
}
</script>

<style scoped>

</style>