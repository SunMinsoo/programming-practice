<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading v-if="loading"></cycle-loading>
    <main class="scroll-h scroll overflow-auto rounded-lg" v-else-if="!loading && isApiOk">
      <div>
        <register-main 
        v-if="responseData"
        :responseData="responseData"></register-main>
      </div>
    </main>
    <content-error v-else></content-error>
  </div>

  <!-- <footer>
    <the-footer></the-footer>
  </footer> -->
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import RegisterMain from '@/components/RegisterMain.vue'
import CycleLoading from '@/components/CycleLoading.vue'
import ContentError from '@/components/ContentError.vue'
import { getSaasListApi } from '@/apis/register.js'

let loading = ref(true)
let isApiOk = ref(false)
let responseData = ref(null);
let error = ref(null);
let orgId = 1;

// 원본 API 호출 코드용
// Promise.all([
//   getSaasListApi()
// ]).then((values) => {
//   responseData.value = values[0];

//   isApiOk.value = true;
// }).catch((err) => {
  
// }).finally(() => {
//   loading.value = false;
// });

// 테스트용으로 성공으로 가정
responseData.value = [
    {
        "name": "slack",
        "status": 1,
        "id": 28,
        "alias": "fffffff",
        "adminEmail": "sasd@123123.vv",
        "apiToken": "bd4aae9045dcc1c77d56edd32394fccbf734635f093cf2be1c3c63e53ed352bd",
        "webhookUrl": "https://back.grummang.com/webhook/slack/590aa7c1-02d5-4a3f-9ae5-a5c685d18e7e",
        "registerDate": "2024-08-17T13:44:51.000+00:00"
    },
    {
        "name": "o365",
        "status": 1,
        "id": 371,
        "alias": "mstest",
        "adminEmail": "test@test.com",
        "apiToken": "bd4aae9045dcc1c77d56edd32394fccbf734635f093cf2be1c3c63e53ed352bd",
        "webhookUrl": "https://back.grummang.com/webhook/o365/1b7c9fe8-ff28-4ca9-9d21-bd9608963161",
        "registerDate": "2024-10-03T07:00:27.000+00:00"
    },
    {
        "name": "GoogleDrive",
        "status": 1,
        "id": 378,
        "alias": "GDTEST",
        "adminEmail": "test@test.com",
        "apiToken": "bd4aae9045dcc1c77d56edd32394fccbf734635f093cf2be1c3c63e53ed352bd",
        "webhookUrl": "https://back.grummang.com/webhook/GoogleDrive/0f99c047-5b11-4080-b4f4-d26fe590c7b3",
        "registerDate": "2024-10-03T08:48:50.000+00:00"
    }
]
isApiOk.value = true;
loading.value = false;


</script>
