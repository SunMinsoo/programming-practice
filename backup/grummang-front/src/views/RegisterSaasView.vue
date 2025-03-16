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
        "apiToken": "6n2hDHcpKwFDXePU67EUME+8PxGQl7Vdqq83n6REOsyIYOt2BU2bMEsUuC5+I2GebeqPzu8agiBRBYOUZC9xknPbieEfhRwAheUEtJGRB20=",
        "webhookUrl": "https://back.grummang.com/webhook/slack/590aa7c1-02d5-4a3f-9ae5-a5c685d18e7e",
        "registerDate": "2024-08-17T13:44:51.000+00:00"
    },
    {
        "name": "o365",
        "status": 1,
        "id": 371,
        "alias": "mstest",
        "adminEmail": "test@test.com",
        "apiToken": "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",
        "webhookUrl": "https://back.grummang.com/webhook/o365/1b7c9fe8-ff28-4ca9-9d21-bd9608963161",
        "registerDate": "2024-10-03T07:00:27.000+00:00"
    },
    {
        "name": "GoogleDrive",
        "status": 1,
        "id": 378,
        "alias": "GDTEST",
        "adminEmail": "test@test.com",
        "apiToken": "bwEALYvmy9SorZd/ZHvAPoDGn8Rc3ouXisoecg5eI7siBjsytF09KcyO56DKUm9Cfpg4HdL2yDTvY9mzmXYdUuEmlazYqm2g9SPZYjqjRkqhFmz7a/e8t4Xk78xmTHfC+FPqMBdsata3+XTNUbh9mHnSKK2w5spBwAKnMoANfHL+NnMkkIHXaP0rT5YbymONjhKMYPlq0L4g29O+vlzB9sc3KIxV0yIdrV4X41UqXkSAkVAHl/E9dR8vnkbacSHLoyX5bp4cqOHPS55azslXrzcwFWqgO2usLyWHLVLwFsU=",
        "webhookUrl": "https://back.grummang.com/webhook/GoogleDrive/0f99c047-5b11-4080-b4f4-d26fe590c7b3",
        "registerDate": "2024-10-03T08:48:50.000+00:00"
    }
]
isApiOk.value = true;
loading.value = false;


</script>
