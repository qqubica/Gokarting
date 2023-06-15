<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "WorkerSelect"
})
</script>
<template>
<v-select
  class="pt-10 pl-10"
  style="width: 500px"
  :items="workers"
  :item-text="item => `${item.name} ${item.surname} (${item.workerRole})`"
  v-model="selectedWorker"
  return-object
  @change="workerSelected($event)"
  label="Wybierz pracownika"
  outlined
  :disabled="isDisabled"
/>

</template>
<script>
import appConfig from "@/app_config";
const axios = require('axios');
export default {

  data: () => ({
    workers: [],
    selectedWorker: null,
  }),

  async beforeMount() {
    this.workers = await this.getWorkers()
  },

  methods: {
    workerSelected(worker){
      this.$emit('workerSelected', worker)
    },

    async getWorkers(){
      let apiResponse = await axios({
        method: "GET",
        url: appConfig.apiUrl + "worker"
      })
      .catch((error) => {
        console.log(error);
        return error;
      });
      return this.adaptWorkers(apiResponse.data._embedded.worker)
    },

    adaptWorkers(workers){
      return workers.map(w =>  {
        return {
          name: w.name,
          surname: w.surname,
          workerRole: w.workerRole,
          email: w.email,
          links: w._links,
        }
      });
    },
  },
  props: {
    isDisabled: {
      type: Boolean,
      required: false,
    }
  }
}
</script>
<style scoped>

</style>