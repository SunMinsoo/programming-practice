<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading v-if="loading"></cycle-loading>
    <main class="scroll-h scroll overflow-auto rounded-lg" v-else-if="!loading && isApiOk">
      <div>
        <PolicyDetails :policyDetails="policyDetails"></PolicyDetails>
        <the-pagination></the-pagination>
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
import { dlpPolicyListApi } from '@/apis/dlp.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'
import PolicyDetails from '@/components/dlp/PolicyDetails.vue'

let loading = ref(true)
let isApiOk = ref(false)

let policyDetails = ref(null)

// 원본용 코드
// Promise.all([
//   dlpPolicyListApi()
//   ])
//   .then((values) => {
//     policyDetails.value = values[0]
//     // if(policyDetails.value[0].message.includes("No") || false) {
//     //   policyDetails.value = []
//     // }
//     isApiOk.value = true
//   })
//   .catch((err) => {

//   })
//   .finally(() => {
//     loading.value = false
//   })


/* 
테스트용 성공으로 가정
*/
policyDetails.value = [
    {
        "policyId": 39,
        "policyName": "DLP 정책 테스트",
        "orgSaasId": 28,
        "saasName": "slack",
        "alias": "fffffff",
        "description": "DLP 정책 테스트",
        "identify": true,
        "passport": true,
        "drive": true,
        "foreigner": false,
        "comment": "탐지되면은 파일을 삭제해주세요."
    },
    {
        "policyId": 40,
        "policyName": "유빈 - TEST",
        "orgSaasId": 28,
        "saasName": "slack",
        "alias": "fffffff",
        "description": "테스트핑",
        "identify": true,
        "passport": true,
        "drive": false,
        "foreigner": false,
        "comment": "TEST~"
    },
    {
        "policyId": 42,
        "policyName": "DLP 정책 테스트2",
        "orgSaasId": 28,
        "saasName": "slack",
        "alias": "fffffff",
        "description": "DLP 정책 테스트",
        "identify": true,
        "passport": true,
        "drive": true,
        "foreigner": true,
        "comment": "탐지되면은 파일을 삭제해주세요."
    },
    {
        "policyId": 43,
        "policyName": "DLP 정책 테스트2",
        "orgSaasId": 371,
        "saasName": "o365",
        "alias": "mstest",
        "description": "DLP 정책 테스트",
        "identify": true,
        "passport": true,
        "drive": true,
        "foreigner": true,
        "comment": "탐지되면은 파일을 삭제해주세요."
    }
]
isApiOk.value = true
loading.value = false

</script>
