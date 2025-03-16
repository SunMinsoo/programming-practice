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

const saas = 'slack';

// 윈본용 코드
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
// saasScore.value = values[0];
fileStatistics.value = {
    "totalFiles": 51,
    "sensitiveFiles": 5,
    "maliciousFiles": 6,
    "connectedAccounts": 6
};
fileSize.value = {
    "totalSize": 0.09375247,
    "sensitiveSize": 0.012678361,
    "maliciousSize": 0.0015407018
};
fileRecent.value = [
    {
        "fileName": "가족관계증명서(영문번역예시).pdf",
        "uploadedBy": "HaHayy",
        "fileType": "pdf",
        "uploadTimestamp": "2024-10-03T16:46:48"
    },
    {
        "fileName": "winmine.exe",
        "uploadedBy": "yubin",
        "fileType": "exe",
        "uploadTimestamp": "2024-10-03T15:59:28"
    },
    {
        "fileName": "image.png",
        "uploadedBy": "hsp003636",
        "fileType": "png",
        "uploadTimestamp": "2024-10-03T11:35:16"
    },
    {
        "fileName": "image.png",
        "uploadedBy": "hsp003636",
        "fileType": "png",
        "uploadTimestamp": "2024-10-03T11:15:07"
    },
    {
        "fileName": "image.png",
        "uploadedBy": "hsp003636",
        "fileType": "png",
        "uploadTimestamp": "2024-10-03T11:13:50"
    },
    {
        "fileName": "image.png",
        "uploadedBy": "hsp003636",
        "fileType": "png",
        "uploadTimestamp": "2024-10-03T10:32:28"
    },
    {
        "fileName": "파일삭제_테스트용-3.pptx",
        "uploadedBy": "HaHayy",
        "fileType": "pptx",
        "uploadTimestamp": "2024-09-30T18:26:34"
    },
    {
        "fileName": "파일삭제_테스트용-2.pptx",
        "uploadedBy": "HaHayy",
        "fileType": "pptx",
        "uploadTimestamp": "2024-09-30T18:06:42"
    },
    {
        "fileName": "파일삭제_테스트용.pptx",
        "uploadedBy": "HaHayy",
        "fileType": "pptx",
        "uploadTimestamp": "2024-09-30T18:01:25"
    },
    {
        "fileName": "image.png",
        "uploadedBy": "yubin",
        "fileType": "png",
        "uploadTimestamp": "2024-09-25T18:20:19"
    }
];
usersTop5.value = [
    {
        "userName": "yubin",
        "sensitiveFilesCount": 0,
        "maliciousFilesCount": 8,
        "lastUploadedTimestamp": "2024-10-03T15:59:28"
    },
    {
        "userName": "HaHayy",
        "sensitiveFilesCount": 3,
        "maliciousFilesCount": 4,
        "lastUploadedTimestamp": "2024-10-03T16:46:48"
    }
]
isApiOk.value = true;
loading.value = false;

</script>
