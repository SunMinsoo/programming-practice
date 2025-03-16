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
        <recent-upload-list :fileRecent="fileRecent" :saas="saas_gd"></recent-upload-list>
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

const saas = 'google-drive';
const saas_gd = 'googledrive';

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
    "totalFiles": 11,
    "sensitiveFiles": 0,
    "maliciousFiles": 1,
    "connectedAccounts": 5
};
fileSize.value = {
    "totalSize": 0.017593214,
    "sensitiveSize": 0.0,
    "maliciousSize": 1.11579895E-4
};
fileRecent.value = [
    {
        "fileName": "winmine.exe",
        "uploadedBy": "박서현",
        "fileType": "exe",
        "uploadTimestamp": "2024-10-03T17:37:17"
    },
    {
        "fileName": "구름망WBS_v0.9.xlsx",
        "uploadedBy": "박서현",
        "fileType": "xlsx",
        "uploadTimestamp": "2024-10-03T17:11:54"
    },
    {
        "fileName": "down.zip",
        "uploadedBy": "박서현",
        "fileType": "zip",
        "uploadTimestamp": "2024-10-03T17:03:53"
    },
    {
        "fileName": "ClamAV와 Yara로 만드는 Windows Vaccine.pptx",
        "uploadedBy": "박서현",
        "fileType": "pptx",
        "uploadTimestamp": "2024-10-03T16:48:11"
    },
    {
        "fileName": "Docker1.pptx",
        "uploadedBy": "박서현",
        "fileType": "pptx",
        "uploadTimestamp": "2024-10-03T16:44:14"
    },
    {
        "fileName": "Docker2.pptx",
        "uploadedBy": "박서현",
        "fileType": "pptx",
        "uploadTimestamp": "2024-10-03T16:44:11"
    },
    {
        "fileName": "주요업무 수행 확인서.doc",
        "uploadedBy": "ysh",
        "fileType": "doc",
        "uploadTimestamp": "2024-10-03T16:15:41"
    },
    {
        "fileName": "국내_클라우드산업_활성화_저해_요인_및_애로사항.xlsx",
        "uploadedBy": "ysh",
        "fileType": "xlsx",
        "uploadTimestamp": "2024-10-03T16:15:21"
    },
    {
        "fileName": "[KISIA] 온택트 융합보안_6. 융합보안 개론.pptx",
        "uploadedBy": "sms",
        "fileType": "pptx",
        "uploadTimestamp": "2024-10-03T15:52:51"
    },
    {
        "fileName": "하계학술대회(CISC-S’24) CFP v2.pdf",
        "uploadedBy": "lis",
        "fileType": "pdf",
        "uploadTimestamp": "2024-10-03T13:59:36"
    }
];
usersTop5.value = [
    {
        "userName": "박서현",
        "sensitiveFilesCount": 0,
        "maliciousFilesCount": 1,
        "lastUploadedTimestamp": "2024-10-03T17:37:17"
    }
];
isApiOk.value = true;
loading.value = false;
</script>
