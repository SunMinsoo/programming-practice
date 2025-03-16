<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <content-error v-if="isError"></content-error>
    <cycle-loading v-else-if="loading"></cycle-loading>
    <unconnect-saas v-else-if="!isApiOk"></unconnect-saas>
    <main v-else class="scroll-h scroll overflow-auto rounded-lg">
      <!-- <saas-score :saasScore="saasScore"></saas-score> -->
      <saas-statistics :fileStatistics="fileStatistics"></saas-statistics>
      <div class="grid grid-cols-2 gap-5 mb-5">
        <file-ratio-chart :fileSize="fileSize"></file-ratio-chart>
        <recent-upload-list :fileRecent="fileRecent" :saas="saas"></recent-upload-list>
      </div>
      <users-top-5 :usersTop5="usersTop5"></users-top-5>
    </main>
  </div>
  <!-- <footer>
    <the-footer></the-footer>
  </footer> -->
</template>

<script setup>
import { ref } from 'vue'
import { saasScoreApi, fileStatisticsApi, fileSizeApi, fileRecentApi, usersTop5Api } from '@/apis/saas.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'
import UnconnectSaas from '@/components/UnconnectSaas.vue'
import SaasScore from '@/components/saas/SaasScore.vue'
import SaasStatistics from '@/components/saas/SaasStatistics.vue'
import FileRatioChart from '@/components/saas/FileRatioChart.vue'
import RecentUploadList from '@/components/saas/RecentUploadList.vue'
import UsersTop5 from '@/components/saas/UsersTop5.vue'

let loading = ref(true);
let isApiOk = ref(false);
let isError = ref(false);

let saasScore = ref(0);
let fileSize = ref(null);
let fileStatistics = ref(null);
let fileRecent = ref(null);
let usersTop5 = ref(null);

const saas = 'o365';

// 원본용 코드
// Promise.all([
//   saasScoreApi(saas),
//   fileStatisticsApi(saas),
//   fileSizeApi(saas),
//   fileRecentApi(saas),
//   usersTop5Api(saas),
//   ]).then((values) => {
//   saasScore.value = values[0];
//   fileStatistics.value = values[1];
//   fileSize.value = values[2];
//   fileRecent.value = values[3];
//   usersTop5.value = values[4];

//   if(values[1].connectedAccounts) {
//     isApiOk.value = true;
//   }
// }).catch((err) => {
//   isError.value = true;
// }).finally(() => {
//   loading.value = false;
// });

/* 
테스트용으로 성공으로 가정
*/
fileStatistics.value = {
    "totalFiles": 12,
    "sensitiveFiles": 0,
    "maliciousFiles": 0,
    "connectedAccounts": 5
};
fileSize.value = {
    "totalSize": 0.006937527,
    "sensitiveSize": 0.0,
    "maliciousSize": 0.0
};
fileRecent.value = [
    {
        "fileName": "[S-개발자] 클라이언트 보안.pdf",
        "uploadedBy": "선 민수",
        "fileType": "pdf",
        "uploadTimestamp": "2024-10-03T15:20:22"
    },
    {
        "fileName": "구름망WBS_v0.8.xlsx",
        "uploadedBy": "이 인석",
        "fileType": "xlsx",
        "uploadTimestamp": "2024-10-03T07:19:00"
    },
    {
        "fileName": "구름망WBS_v0.7.xlsx",
        "uploadedBy": "이 인석",
        "fileType": "xlsx",
        "uploadTimestamp": "2024-10-03T07:19:00"
    },
    {
        "fileName": "tlsh.zip",
        "uploadedBy": "박 서현",
        "fileType": "zip",
        "uploadTimestamp": "2024-10-03T07:01:47"
    },
    {
        "fileName": "image (2).png",
        "uploadedBy": "이 인석",
        "fileType": "png",
        "uploadTimestamp": "2024-10-02T17:13:46"
    },
    {
        "fileName": "image (2).png",
        "uploadedBy": "이 인석",
        "fileType": "png",
        "uploadTimestamp": "2024-10-02T17:13:46"
    },
    {
        "fileName": "image (2).png",
        "uploadedBy": "이 인석",
        "fileType": "png",
        "uploadTimestamp": "2024-10-02T08:13:46"
    },
    {
        "fileName": "image (2).png",
        "uploadedBy": "이 인석",
        "fileType": "png",
        "uploadTimestamp": "2024-10-02T08:13:46"
    },
    {
        "fileName": "유빈의 텍스트파일_공유.txt",
        "uploadedBy": "이 유빈",
        "fileType": "text",
        "uploadTimestamp": "2024-10-01T22:47:31"
    },
    {
        "fileName": "민수의 텍스트파일_공유.txt",
        "uploadedBy": "선 민수",
        "fileType": "text",
        "uploadTimestamp": "2024-10-01T22:39:08"
    }
];
usersTop5.value = [];
isApiOk.value = true;
loading.value = false;

</script>
