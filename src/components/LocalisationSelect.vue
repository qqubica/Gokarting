<script>
import {defineComponent} from 'vue'
import workerSelect from "@/components/WorkerSelect.vue";

export default defineComponent({
  name: "LocalisationSelect",
  computed: {
    workerSelect() {
      return workerSelect
    }
  }
})
</script>

<template>
<v-select
    class="pl-10"
    style="width: 500px"
    :items="localizations"
    :item-text="item => `${item.name}`"
    v-model="selectedLocalization"
    return-object
    @change="localizationSelected($event)"
    label="Wybierz lokalizację"
    outlined
    :disabled="isDisabled"
/>
</template>
<script>
import axios from "axios";
import appConfig from "@/app_config";

export default {
  name: 'LocalisationSelect',

  data: () => ({
    localizations: [],
    selectedLocalization: null,
    workerSelect: false,
  }),

  mounted() {
  },

  methods: {
    localizationSelected(localization){
      this.$emit('localizationSelected', localization)
    },

    async getLocalizations() {
      let apiResponse = await axios({
        method: "GET",
        url: appConfig.apiUrl + `localisation`
      })
          .catch((error) => {
            console.log(error);
            return error;
          });
      this.localizations = this.adaptLocalizations(apiResponse.data._embedded.localisation)
    },

    adaptLocalizations(localizations) {
      return localizations.map(l => {
        return {
          name: l.name,
          links: l._links,
        }
      });
    },
  },

  props: {
    isDisabled: {
      type: Boolean,
      default: false,
    }
  },
}
</script>

<style scoped>

</style>