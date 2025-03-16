<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading
      v-if="loading"></cycle-loading>
    <main 
      class="scroll-h scroll overflow-auto rounded-lg"
      v-else-if="!loading && isApiOk">
      <div>
        <history-statistics :historyStatistics="historyStatistics"></history-statistics>
        <history-trends :historyTrends="historyTrends"></history-trends>
        <history-details :historyDetails="historyDetails"></history-details>
      </div>

      <!-- <file-test></file-test> -->
    </main>
    <content-error
      v-else></content-error>
  </div>
  <!-- <footer>
    <the-footer></the-footer>
  </footer> -->
</template>

<script setup>
import { ref } from 'vue'
import { historyStatisticsApi, historyDetailsApi } from '@/apis/file.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'
import HistoryStatistics from '@/components/file/HistoryStatistics.vue'
import HistoryTrends from '@/components/file/HistoryTrends.vue'
import HistoryDetails from '@/components/file/HistoryDetails.vue'
import FileTest from '@/components/file/FileTest.vue'

let loading = ref(true);
let isApiOk = ref(false);

let historyStatistics = ref([]);
let historyTrends = ref([]);
let historyDetails = ref([]);

// 원본용 코드
// Promise.all([
//   historyStatisticsApi(),
//   historyDetailsApi(),
// ]).then((values) => {
//   historyStatistics.value = [values[0].data.totalUpload, values[0].data.totalChanged, values[0].data.totalDeleted];
//   historyTrends.value = values[0].data.fileHistoryStatistics;
//   historyDetails.value = values[1].data[0];
//   isApiOk.value = true;
// }).catch((err) => {

// }).finally(() => {
//   loading.value = false;
// });

/* 
테스트용 성공으로 가정
*/
let values = [
{
    "status": "success",
    "data": {
        "totalUpload": 102,
        "totalDeleted": 27,
        "totalChanged": 9,
        "totalMoved": 0,
        "fileHistoryStatistics": [
            {
                "date": "2024-09-04",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-05",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-06",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-07",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-08",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-09",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-10",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-11",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-12",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-13",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-14",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-15",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-16",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-17",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-18",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-19",
                "uploadCount": 7,
                "deletedCount": 3,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-20",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-21",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-22",
                "uploadCount": 16,
                "deletedCount": 5,
                "modifyCount": 1,
                "movedCount": 0
            },
            {
                "date": "2024-09-23",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-24",
                "uploadCount": 6,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-25",
                "uploadCount": 5,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-26",
                "uploadCount": 1,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-27",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-28",
                "uploadCount": 0,
                "deletedCount": 1,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-29",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-09-30",
                "uploadCount": 3,
                "deletedCount": 7,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-10-01",
                "uploadCount": 0,
                "deletedCount": 0,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-10-02",
                "uploadCount": 3,
                "deletedCount": 2,
                "modifyCount": 0,
                "movedCount": 0
            },
            {
                "date": "2024-10-03",
                "uploadCount": 21,
                "deletedCount": 2,
                "modifyCount": 0,
                "movedCount": 0
            }
        ]
    }
}, 
{
    "status": "success",
    "data": [
        {
            "totalEvent": 138,
            "fileHistoryDto": [
                {
                    "eventId": 2,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "cve-2018-0798.pdf",
                    "saasFileId": "F078MT457SQ",
                    "uploadTs": "2024-06-18T05:30:38",
                    "eventTs": "2024-06-18T05:30:38",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": null
                },
                {
                    "eventId": 3,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "DLL 다운로드.pdf",
                    "saasFileId": "F078GG9D7UM",
                    "uploadTs": "2024-06-18T05:33:11",
                    "eventTs": "2024-06-18T05:33:11",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": null
                },
                {
                    "eventId": 1,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "requirements.txt",
                    "saasFileId": "F078MV1L5HS",
                    "uploadTs": "2024-06-18T05:51:37",
                    "eventTs": "2024-06-18T05:51:37",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": null
                },
                {
                    "eventId": 4,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "Injector.pdf",
                    "saasFileId": "F078KQN3X26",
                    "uploadTs": "2024-06-18T07:13:08",
                    "eventTs": "2024-06-18T07:13:08",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": null
                },
                {
                    "eventId": 6,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "test.docx",
                    "saasFileId": "F07E147HUJ3",
                    "uploadTs": "2024-07-29T07:13:50",
                    "eventTs": "2024-07-29T07:13:50",
                    "email": "goei4559@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/여신호_9698"
                },
                {
                    "eventId": 5,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "123123123123123123fsdfgdsfg.png",
                    "saasFileId": "F07EMFUPV5Z",
                    "uploadTs": "2024-07-30T05:23:37",
                    "eventTs": "2024-07-30T05:23:37",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 8,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "XENICS STORMX VM3.lnk",
                    "saasFileId": "F07FBFMM3S4",
                    "uploadTs": "2024-07-30T09:28:53",
                    "eventTs": "2024-07-30T09:28:53",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 7,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "2._제11회_소프트웨어_개발보안_경진대회_본선_서비스개요서.hwp",
                    "saasFileId": "F07H44DDKLM",
                    "uploadTs": "2024-08-16T08:04:59",
                    "eventTs": "2024-08-16T08:04:59",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 9,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "Hello pe.exe",
                    "saasFileId": "F07H9FMHS6Q",
                    "uploadTs": "2024-08-16T08:06:00",
                    "eventTs": "2024-08-16T08:06:00",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 26,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "소프트웨어_보안약점_진단가이드(2021) (1).pdf",
                    "saasFileId": "F07HVQM783S",
                    "uploadTs": "2024-08-16T08:06:59",
                    "eventTs": "2024-08-16T08:06:59",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 13,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "소프트웨어_개발보안_가이드(2021.12.29) (2).pdf",
                    "saasFileId": "F07HVQNFEDN",
                    "uploadTs": "2024-08-16T08:07:18",
                    "eventTs": "2024-08-16T08:07:18",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 10,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "file9.php",
                    "saasFileId": "F07H6TRTUBD",
                    "uploadTs": "2024-08-16T08:07:55",
                    "eventTs": "2024-08-16T08:07:55",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 11,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "file5.php",
                    "saasFileId": "F07H450ARNZ",
                    "uploadTs": "2024-08-16T08:10:17",
                    "eventTs": "2024-08-16T08:10:17",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 12,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.1.xlsx",
                    "saasFileId": "F07H0CMC4R4",
                    "uploadTs": "2024-08-16T08:12:08",
                    "eventTs": "2024-08-16T08:12:08",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 14,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.1 (1).xlsx",
                    "saasFileId": "F07H6U91675",
                    "uploadTs": "2024-08-16T08:12:18",
                    "eventTs": "2024-08-16T08:12:18",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 15,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.1 (2).xlsx",
                    "saasFileId": "F07H71VQKGA",
                    "uploadTs": "2024-08-16T08:12:24",
                    "eventTs": "2024-08-16T08:12:24",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 17,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "headache.exe.bak",
                    "saasFileId": "F07H6UMTBM1",
                    "uploadTs": "2024-08-16T08:15:30",
                    "eventTs": "2024-08-16T08:15:30",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 18,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07HVRPSG3S",
                    "uploadTs": "2024-08-16T08:16:15",
                    "eventTs": "2024-08-16T08:16:15",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy"
                },
                {
                    "eventId": 16,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "requirements.txt",
                    "saasFileId": "F07HKN997UZ",
                    "uploadTs": "2024-08-16T08:18:19",
                    "eventTs": "2024-08-16T08:18:19",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy"
                },
                {
                    "eventId": 19,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "solve.cpp",
                    "saasFileId": "F07H72NBYGJ",
                    "uploadTs": "2024-08-16T08:19:08",
                    "eventTs": "2024-08-16T08:19:08",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 20,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "programers.py",
                    "saasFileId": "F07H9H698P6",
                    "uploadTs": "2024-08-16T08:19:25",
                    "eventTs": "2024-08-16T08:19:25",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/HaHayy"
                },
                {
                    "eventId": 44,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.1.xlsx",
                    "saasFileId": "F07H0CMC4R4",
                    "uploadTs": "2024-08-16T08:12:08",
                    "eventTs": "2024-08-16T17:12:08",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 21,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "image.png",
                    "saasFileId": "F07HNHHDHB7",
                    "uploadTs": "2024-08-20T18:25:05",
                    "eventTs": "2024-08-20T18:25:05",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 22,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "2512-예산.cpp",
                    "saasFileId": "F07JTNRE3J7",
                    "uploadTs": "2024-08-28T02:05:48",
                    "eventTs": "2024-08-28T02:05:48",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/HaHayy"
                },
                {
                    "eventId": 23,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "2-5-1-2-예산.cpp",
                    "saasFileId": "F07JWBHD1CL",
                    "uploadTs": "2024-08-28T02:13:50",
                    "eventTs": "2024-08-28T02:13:50",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 24,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "25-12.cpp",
                    "saasFileId": "F07K6H18C65",
                    "uploadTs": "2024-08-28T02:16:52",
                    "eventTs": "2024-08-28T02:16:52",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 25,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "slack_test_excel.xlsx",
                    "saasFileId": "F07JUB3DDV0",
                    "uploadTs": "2024-08-28T05:06:11",
                    "eventTs": "2024-08-28T05:06:11",
                    "email": "mandeuk1999@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/이인석"
                },
                {
                    "eventId": 27,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "slack_test_pdf.pdf",
                    "saasFileId": "F07K71CCQ3B",
                    "uploadTs": "2024-08-28T05:06:34",
                    "eventTs": "2024-08-28T05:06:34",
                    "email": "mandeuk1999@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/이인석"
                },
                {
                    "eventId": 28,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "httpssw-circle-link-upload-files.s3.txt",
                    "saasFileId": "F07K73YCU65",
                    "uploadTs": "2024-08-28T05:35:03",
                    "eventTs": "2024-08-28T05:35:03",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/hsp003636"
                },
                {
                    "eventId": 29,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "httpssw-circle-link-upload-files.s3.txt",
                    "saasFileId": "F07K73YCU65",
                    "uploadTs": "2024-08-28T05:35:03",
                    "eventTs": "2024-08-28T05:35:54",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/hsp003636"
                },
                {
                    "eventId": 30,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "httpssw-circle-link-upload-files.s3.txt",
                    "saasFileId": "F07K73YCU65",
                    "uploadTs": "2024-08-28T05:35:03",
                    "eventTs": "2024-08-28T05:36:09",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/hsp003636"
                },
                {
                    "eventId": 31,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "하이루 (1).txt",
                    "saasFileId": "F07JRKLD2UD",
                    "uploadTs": "2024-08-28T14:59:49",
                    "eventTs": "2024-08-28T14:59:49",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 32,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "하이루 (1).txt",
                    "saasFileId": "F07JRKLD2UD",
                    "uploadTs": "2024-08-28T14:59:49",
                    "eventTs": "2024-08-28T15:02:05",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 33,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "하이하이하이.txt",
                    "saasFileId": "F07JRKLD2UD",
                    "uploadTs": "2024-08-28T14:59:49",
                    "eventTs": "2024-08-28T15:02:39",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 34,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "하이하이하이.txt",
                    "saasFileId": "F07JRKLD2UD",
                    "uploadTs": "2024-08-28T14:59:49",
                    "eventTs": "2024-08-28T15:03:12",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 35,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "하이루 (1).txt",
                    "saasFileId": "F07KHB2CHHN",
                    "uploadTs": "2024-08-28T15:10:05",
                    "eventTs": "2024-08-28T15:10:05",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 36,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07KHEJ3P5W",
                    "uploadTs": "2024-08-28T15:41:18",
                    "eventTs": "2024-08-28T15:41:18",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 37,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "하이루 (1).txt",
                    "saasFileId": "F07KHB2CHHN",
                    "uploadTs": "2024-08-28T15:10:05",
                    "eventTs": "2024-08-28T15:41:25",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 38,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07KHEJ3P5W",
                    "uploadTs": "2024-08-28T15:41:18",
                    "eventTs": "2024-08-28T15:41:55",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 39,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07KHEJ3P5W",
                    "uploadTs": "2024-08-28T15:41:18",
                    "eventTs": "2024-08-28T16:07:44",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 40,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07KHEJ3P5W",
                    "uploadTs": "2024-08-28T15:41:18",
                    "eventTs": "2024-08-28T16:08:05",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 41,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07K7EGA04R",
                    "uploadTs": "2024-08-28T16:08:39",
                    "eventTs": "2024-08-28T16:08:39",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 42,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "하이루 (1).txt",
                    "saasFileId": "F07JUMFRQKD",
                    "uploadTs": "2024-08-28T16:11:27",
                    "eventTs": "2024-08-28T16:11:27",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 43,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "하이루 (1).txt",
                    "saasFileId": "F07JUMFRQKD",
                    "uploadTs": "2024-08-28T16:11:27",
                    "eventTs": "2024-08-28T16:57:47",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 46,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "test_fin.pdf",
                    "saasFileId": "F07KJK7V4AC",
                    "uploadTs": "2024-08-28T19:41:54",
                    "eventTs": "2024-08-28T19:41:54",
                    "email": "mandeuk1999@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/이인석"
                },
                {
                    "eventId": 45,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "test_fin.xlsx",
                    "saasFileId": "F07JSUYQEH3",
                    "uploadTs": "2024-08-28T19:41:56",
                    "eventTs": "2024-08-28T19:41:56",
                    "email": "mandeuk1999@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/이인석"
                },
                {
                    "eventId": 47,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "Injector.pdf",
                    "saasFileId": "F078KQN3X26",
                    "uploadTs": "2024-06-18T07:13:08",
                    "eventTs": "2024-08-28T19:52:39",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/hsp003636"
                },
                {
                    "eventId": 48,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.1 (1).xlsx",
                    "saasFileId": "F07H6U91675",
                    "uploadTs": "2024-08-16T08:12:18",
                    "eventTs": "2024-08-29T15:45:15",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 49,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "구름망WBS_v0.1 (1).xlsx",
                    "saasFileId": "F07H6U91675",
                    "uploadTs": "2024-08-16T08:12:18",
                    "eventTs": "2024-08-30T11:57:34",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 50,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "구름망WBS_v0.1.xlsx",
                    "saasFileId": "F07H0CMC4R4",
                    "uploadTs": "2024-08-16T08:12:08",
                    "eventTs": "2024-08-30T11:59:05",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 51,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "포켓몬.txt",
                    "saasFileId": "F07K7CGUKCJ",
                    "uploadTs": "2024-08-30T13:27:52",
                    "eventTs": "2024-08-30T13:27:52",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 52,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "포켓몬.txt",
                    "saasFileId": "F07K7CGUKCJ",
                    "uploadTs": "2024-08-30T13:27:52",
                    "eventTs": "2024-08-30T13:28:16",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 53,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "포켓몬.txt",
                    "saasFileId": "F07K7CGUKCJ",
                    "uploadTs": "2024-08-30T13:27:52",
                    "eventTs": "2024-08-30T13:28:32",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 54,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "포켓몬.txt",
                    "saasFileId": "F07K7CGUKCJ",
                    "uploadTs": "2024-08-30T13:27:52",
                    "eventTs": "2024-08-30T13:29:04",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 71,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "[KISIA] S-개발자 2기 1차 프로젝트 운영 방안_교육생안내.pdf",
                    "saasFileId": "F07NRKNM6NL",
                    "uploadTs": "2024-09-19T14:01:31",
                    "eventTs": "2024-09-19T14:01:31",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 72,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "2024년도 정기 기사 제3회 실기시험(필답형) 시험장 현황(9.9 기준).xlsx",
                    "saasFileId": "F07MNC755KR",
                    "uploadTs": "2024-09-19T14:30:47",
                    "eventTs": "2024-09-19T14:30:47",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 73,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "[sdev]osi-and-tcp.docx",
                    "saasFileId": "F07NRRZTQKA",
                    "uploadTs": "2024-09-19T15:08:35",
                    "eventTs": "2024-09-19T15:08:35",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 74,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "스크린샷 2024-09-16 114723.txt",
                    "saasFileId": "F07N32YDNSW",
                    "uploadTs": "2024-09-19T15:10:39",
                    "eventTs": "2024-09-19T15:10:39",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 75,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "파일첨부테스트용.png",
                    "saasFileId": "F07N5J2CSPN",
                    "uploadTs": "2024-09-19T15:16:46",
                    "eventTs": "2024-09-19T15:16:46",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 76,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "하이루 (1).jpg",
                    "saasFileId": "F07N0BF0WQM",
                    "uploadTs": "2024-09-19T15:53:24",
                    "eventTs": "2024-09-19T15:53:24",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 77,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "[KISIA] S-개발자 프로젝트 보고서 - 이유빈.docx",
                    "saasFileId": "F07N0BL9JBX",
                    "uploadTs": "2024-09-19T15:54:43",
                    "eventTs": "2024-09-19T15:54:43",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 78,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "하이루 (1).jpg",
                    "saasFileId": "F07N0BF0WQM",
                    "uploadTs": "2024-09-19T15:53:24",
                    "eventTs": "2024-09-19T16:01:36",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 79,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "파일첨부테스트용.png",
                    "saasFileId": "F07N5J2CSPN",
                    "uploadTs": "2024-09-19T15:16:46",
                    "eventTs": "2024-09-19T16:01:40",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 80,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "스크린샷 2024-09-16 114723.txt",
                    "saasFileId": "F07N32YDNSW",
                    "uploadTs": "2024-09-19T15:10:39",
                    "eventTs": "2024-09-19T16:02:14",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 113,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "DFGYGVBHBN - 복사본.docx",
                    "saasFileId": "F07NVB69HJ5",
                    "uploadTs": "2024-09-22T15:45:54",
                    "eventTs": "2024-09-22T15:45:54",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 114,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07K7EGA04R",
                    "uploadTs": "2024-08-28T16:08:39",
                    "eventTs": "2024-09-22T15:46:51",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 115,
                    "saas": "slack",
                    "eventType": "file_change",
                    "fileName": "나 O365해야해.txt",
                    "saasFileId": "F07K7EGA04R",
                    "uploadTs": "2024-08-28T16:08:39",
                    "eventTs": "2024-09-22T15:46:59",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 116,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "DFGYGVBHBN - 복사본.docx",
                    "saasFileId": "F07NVB69HJ5",
                    "uploadTs": "2024-09-22T15:45:54",
                    "eventTs": "2024-09-22T15:47:49",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636"
                },
                {
                    "eventId": 122,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "Slack-SAST.pdf",
                    "saasFileId": "F07NA30V7KQ",
                    "uploadTs": "2024-09-22T16:09:15",
                    "eventTs": "2024-09-22T16:09:15",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 123,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "암호_알고리즘_및_키_길이_이용_안내서_2018.pdf",
                    "saasFileId": "F07NA32BTFG",
                    "uploadTs": "2024-09-22T16:10:29",
                    "eventTs": "2024-09-22T16:10:29",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 124,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "virustotal.png",
                    "saasFileId": "F07NA335PC6",
                    "uploadTs": "2024-09-22T16:10:57",
                    "eventTs": "2024-09-22T16:10:57",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 147,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "7c44528fe1445378e49e0319e5ccb83e586c82d2c98c03c7c7fde50adc159b29.xlsx",
                    "saasFileId": "F07P5GU4KGQ",
                    "uploadTs": "2024-09-22T16:52:07",
                    "eventTs": "2024-09-22T16:52:07",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 199,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.9.xlsx",
                    "saasFileId": "F07NA52RNNS",
                    "uploadTs": "2024-09-22T17:09:39",
                    "eventTs": "2024-09-22T17:09:39",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 200,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "고유식별정보.docx",
                    "saasFileId": "F07NA5QA36J",
                    "uploadTs": "2024-09-22T17:28:34",
                    "eventTs": "2024-09-22T17:28:34",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy"
                },
                {
                    "eventId": 201,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NGQJ0TDG",
                    "uploadTs": "2024-09-22T17:35:14",
                    "eventTs": "2024-09-22T17:35:14",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy"
                },
                {
                    "eventId": 221,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NGR4CHV0",
                    "uploadTs": "2024-09-22T17:53:17",
                    "eventTs": "2024-09-22T17:53:17",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/yubin"
                },
                {
                    "eventId": 222,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NGR4CHV0",
                    "uploadTs": "2024-09-22T17:53:17",
                    "eventTs": "2024-09-22T17:54:50",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/yubin"
                },
                {
                    "eventId": 223,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "고유식별정보.docx",
                    "saasFileId": "F07NKAB8SS0",
                    "uploadTs": "2024-09-22T17:57:27",
                    "eventTs": "2024-09-22T17:57:27",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 224,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NVFV0NSV",
                    "uploadTs": "2024-09-22T18:01:18",
                    "eventTs": "2024-09-22T18:01:18",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 225,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NKARA5K6",
                    "uploadTs": "2024-09-22T18:08:15",
                    "eventTs": "2024-09-22T18:08:15",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 226,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07P5KHDRA4",
                    "uploadTs": "2024-09-22T18:09:49",
                    "eventTs": "2024-09-22T18:09:49",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 227,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07P5KHDRA4",
                    "uploadTs": "2024-09-22T18:09:49",
                    "eventTs": "2024-09-22T18:11:43",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 228,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NKARA5K6",
                    "uploadTs": "2024-09-22T18:08:15",
                    "eventTs": "2024-09-22T18:11:48",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 229,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NVFV0NSV",
                    "uploadTs": "2024-09-22T18:01:18",
                    "eventTs": "2024-09-22T18:11:51",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/yubin"
                },
                {
                    "eventId": 230,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07N29NCFFH",
                    "uploadTs": "2024-09-22T18:13:57",
                    "eventTs": "2024-09-22T18:13:57",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 231,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NE0K9GBF",
                    "uploadTs": "2024-09-22T18:24:41",
                    "eventTs": "2024-09-22T18:24:41",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 453,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "파일첨부테스트용.txt",
                    "saasFileId": "F07PG2AUCDN",
                    "uploadTs": "2024-09-24T22:46:12",
                    "eventTs": "2024-09-24T22:46:12",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 454,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "antimal;wre.pdf",
                    "saasFileId": "F07NT8ND6N6",
                    "uploadTs": "2024-09-24T22:46:52",
                    "eventTs": "2024-09-24T22:46:52",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 455,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "파일첨부테스트용.txt",
                    "saasFileId": "F07PG7B0LG0",
                    "uploadTs": "2024-09-24T23:09:51",
                    "eventTs": "2024-09-24T23:09:51",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 456,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "antimal;wre.pdf",
                    "saasFileId": "F07PG7H80QY",
                    "uploadTs": "2024-09-24T23:10:37",
                    "eventTs": "2024-09-24T23:10:37",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 457,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07NTDT75MY",
                    "uploadTs": "2024-09-24T23:11:02",
                    "eventTs": "2024-09-24T23:11:02",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 458,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "projectStats.csv",
                    "saasFileId": "F07NTCKCUSF",
                    "uploadTs": "2024-09-24T23:19:43",
                    "eventTs": "2024-09-24T23:19:43",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 1042,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "scans.xls",
                    "saasFileId": "01SJFQ7IKKY5UQCMQISNB3DBFPGLKLYVAF",
                    "uploadTs": "2024-09-25T00:18:36",
                    "eventTs": "2024-09-25T00:18:36",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/scans.xls"
                },
                {
                    "eventId": 1036,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "scans.xls",
                    "saasFileId": "01SJFQ7IKKY5UQCMQISNB3DBFPGLKLYVAF",
                    "uploadTs": "2024-09-25T00:18:36",
                    "eventTs": "2024-09-25T09:18:36",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/scans.xls"
                },
                {
                    "eventId": 1040,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "Anti_Malware.png",
                    "saasFileId": "01SJFQ7IPC7TXQBT4UZRGYMIX5FA5UP3YH",
                    "uploadTs": "2024-09-25T15:20:41",
                    "eventTs": "2024-09-25T15:20:41",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/Anti_Malware.png"
                },
                {
                    "eventId": 550,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "9c6e0aaf301f7e0d6ec46c1bdf702a53a3cfa14aadfc2aa68d0941152439a64b.elf",
                    "saasFileId": "F07NVFCU821",
                    "uploadTs": "2024-09-25T17:35:36",
                    "eventTs": "2024-09-25T17:35:36",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 576,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "image.png",
                    "saasFileId": "F07PB91TEG1",
                    "uploadTs": "2024-09-25T18:20:19",
                    "eventTs": "2024-09-25T18:20:19",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 1035,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "Anti_Malware.png",
                    "saasFileId": "01SJFQ7IPC7TXQBT4UZRGYMIX5FA5UP3YH",
                    "uploadTs": "2024-09-25T15:20:41",
                    "eventTs": "2024-09-26T00:20:41",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/Anti_Malware.png"
                },
                {
                    "eventId": 844,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "구름망WBS_v0.9.xlsx",
                    "saasFileId": "F07NA52RNNS",
                    "uploadTs": "2024-09-22T17:09:39",
                    "eventTs": "2024-09-28T16:27:02",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 855,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "antimal;wre.pdf",
                    "saasFileId": "F07NT8ND6N6",
                    "uploadTs": "2024-09-24T22:46:52",
                    "eventTs": "2024-09-30T16:58:23",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 856,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07N29NCFFH",
                    "uploadTs": "2024-09-22T18:13:57",
                    "eventTs": "2024-09-30T17:55:07",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 857,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "파일삭제_테스트용.pptx",
                    "saasFileId": "F07Q05W5MNV",
                    "uploadTs": "2024-09-30T18:01:25",
                    "eventTs": "2024-09-30T18:01:25",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 858,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "파일삭제_테스트용.pptx",
                    "saasFileId": "F07Q05W5MNV",
                    "uploadTs": "2024-09-30T18:01:25",
                    "eventTs": "2024-09-30T18:04:25",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 859,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "파일삭제_테스트용-2.pptx",
                    "saasFileId": "F07PJL6MFBP",
                    "uploadTs": "2024-09-30T18:06:42",
                    "eventTs": "2024-09-30T18:06:42",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 860,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "파일삭제_테스트용-2.pptx",
                    "saasFileId": "F07PJL6MFBP",
                    "uploadTs": "2024-09-30T18:06:42",
                    "eventTs": "2024-09-30T18:07:23",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 861,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "파일삭제_테스트용-3.pptx",
                    "saasFileId": "F07QAC3SNSU",
                    "uploadTs": "2024-09-30T18:26:34",
                    "eventTs": "2024-09-30T18:26:34",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 862,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "파일삭제_테스트용-3.pptx",
                    "saasFileId": "F07QAC3SNSU",
                    "uploadTs": "2024-09-30T18:26:34",
                    "eventTs": "2024-09-30T18:29:29",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 863,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "image.png",
                    "saasFileId": "F07PB91TEG1",
                    "uploadTs": "2024-09-25T18:20:19",
                    "eventTs": "2024-09-30T19:34:59",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 864,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "2-5-1-2-예산.cpp",
                    "saasFileId": "F07JWBHD1CL",
                    "uploadTs": "2024-08-28T02:13:50",
                    "eventTs": "2024-09-30T19:39:51",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 1037,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "민수의 텍스트파일_공유.txt",
                    "saasFileId": "01Y7RKDP4N33PMVLW7URB2NGLCMDS4MJEL",
                    "uploadTs": "2024-10-02T07:39:08",
                    "eventTs": "2024-10-02T07:39:08",
                    "email": "sms@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/선 민수/downloads/민수의 텍스트파일_공유.txt"
                },
                {
                    "eventId": 1034,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "유빈의 텍스트파일_공유.txt",
                    "saasFileId": "01HQH4WXG7PNGV4TPF75ALJ7L7UBY5LERV",
                    "uploadTs": "2024-10-02T07:47:31",
                    "eventTs": "2024-10-02T07:47:31",
                    "email": "lyb@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 유빈/downloads/유빈의 텍스트파일_공유.txt"
                },
                {
                    "eventId": 877,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "고유식별정보.docx",
                    "saasFileId": "F07NKAB8SS0",
                    "uploadTs": "2024-09-22T17:57:27",
                    "eventTs": "2024-10-02T15:49:31",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy"
                },
                {
                    "eventId": 888,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "9c6e0aaf301f7e0d6ec46c1bdf702a53a3cfa14aadfc2aa68d0941152439a64b.elf",
                    "saasFileId": "F07NVFCU821",
                    "uploadTs": "2024-09-25T17:35:36",
                    "eventTs": "2024-10-02T17:11:51",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin"
                },
                {
                    "eventId": 1044,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "image (2).png",
                    "saasFileId": "01SJFQ7IMCW3CZU34SQFEITUPNLJ5LBIJK",
                    "uploadTs": "2024-10-02T17:13:46",
                    "eventTs": "2024-10-02T17:13:46",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/image (2).png"
                },
                {
                    "eventId": 1033,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "image (2).png",
                    "saasFileId": "01SJFQ7IMCW3CZU34SQFEITUPNLJ5LBIJK",
                    "uploadTs": "2024-10-02T17:13:46",
                    "eventTs": "2024-10-03T02:13:46",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/image (2).png"
                },
                {
                    "eventId": 926,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "image.png",
                    "saasFileId": "F07QJ3PQWL9",
                    "uploadTs": "2024-10-03T10:32:28",
                    "eventTs": "2024-10-03T10:32:28",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 947,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "image.png",
                    "saasFileId": "F07QJ72QU5P",
                    "uploadTs": "2024-10-03T11:13:50",
                    "eventTs": "2024-10-03T11:13:50",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 948,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "image.png",
                    "saasFileId": "F07QJ770UP3",
                    "uploadTs": "2024-10-03T11:15:07",
                    "eventTs": "2024-10-03T11:15:07",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 974,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "image.png",
                    "saasFileId": "F07PR21NVD5",
                    "uploadTs": "2024-10-03T11:35:16",
                    "eventTs": "2024-10-03T11:35:16",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 991,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "image.png",
                    "saasFileId": "F07PR21NVD5",
                    "uploadTs": "2024-10-03T11:35:16",
                    "eventTs": "2024-10-03T13:46:54",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 1080,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "Cat.jpg",
                    "saasFileId": "1yJawY9Vxe2LawqFy04p8mHeuQJurl6Pw",
                    "uploadTs": "2024-10-03T13:58:58",
                    "eventTs": "2024-10-03T13:58:58",
                    "email": "lis@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/Cat.jpg"
                },
                {
                    "eventId": 1083,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "하계학술대회(CISC-S’24) CFP v2.pdf",
                    "saasFileId": "1oJnIxiEsDBQl_w1TMfjco0V9r8Ow4Whu",
                    "uploadTs": "2024-10-03T13:59:36",
                    "eventTs": "2024-10-03T13:59:36",
                    "email": "lis@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/하계학술대회(CISC-S’24) CFP v2.pdf"
                },
                {
                    "eventId": 1086,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "[KISIA] 온택트 융합보안_6. 융합보안 개론.pptx",
                    "saasFileId": "1p40ORVKVH2K0zjt1aTlYq3jgRb1XHUKB",
                    "uploadTs": "2024-10-03T15:52:51",
                    "eventTs": "2024-10-03T15:52:51",
                    "email": "sms@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/[KISIA] 온택트 융합보안_6. 융합보안 개론.pptx"
                },
                {
                    "eventId": 1032,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "F07QV5LAQ0G",
                    "uploadTs": "2024-10-03T15:59:28",
                    "eventTs": "2024-10-03T15:59:28",
                    "email": "lee39095296@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/소셜/yubin"
                },
                {
                    "eventId": 1039,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "tlsh.zip",
                    "saasFileId": "01MCF5CYZF7DACR6DV2VHYFA2AXSXMGBA7",
                    "uploadTs": "2024-10-03T16:01:47",
                    "eventTs": "2024-10-03T16:01:47",
                    "email": "psh@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/박 서현/downloads/tlsh.zip"
                },
                {
                    "eventId": 1079,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "국내_클라우드산업_활성화_저해_요인_및_애로사항.xlsx",
                    "saasFileId": "1eMf3wcdnjApYfoZqsghwbXPldaYCJ1xw",
                    "uploadTs": "2024-10-03T16:15:21",
                    "eventTs": "2024-10-03T16:15:21",
                    "email": "ysh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/국내_클라우드산업_활성화_저해_요인_및_애로사항.xlsx"
                },
                {
                    "eventId": 1081,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "주요업무 수행 확인서.doc",
                    "saasFileId": "1sb6ZlVrKESioho0Sz_lv58iYRWSJMcqk",
                    "uploadTs": "2024-10-03T16:15:41",
                    "eventTs": "2024-10-03T16:15:41",
                    "email": "ysh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/주요업무 수행 확인서.doc"
                },
                {
                    "eventId": 1041,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.8.xlsx",
                    "saasFileId": "01SJFQ7IP75Y5UV4UZIVFZ2VJ2V57IVRCU",
                    "uploadTs": "2024-10-03T16:19:00",
                    "eventTs": "2024-10-03T16:19:00",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/구름망WBS_v0.8.xlsx"
                },
                {
                    "eventId": 1043,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.7.xlsx",
                    "saasFileId": "01SJFQ7IIIP2SBMO6WCFC2LPKYT4RF2N6I",
                    "uploadTs": "2024-10-03T16:19:00",
                    "eventTs": "2024-10-03T16:19:00",
                    "email": "lis@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/이 인석/downloads/구름망WBS_v0.7.xlsx"
                },
                {
                    "eventId": 1088,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "Docker2.pptx",
                    "saasFileId": "1WCr-GFIXQtqEwY19dujdMonzdMcXCB6v",
                    "uploadTs": "2024-10-03T16:44:11",
                    "eventTs": "2024-10-03T16:44:11",
                    "email": "psh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/Docker2.pptx"
                },
                {
                    "eventId": 1089,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "Docker1.pptx",
                    "saasFileId": "1xAL5mjD4zE9dItrYyWZwaLttBc3s-yk2",
                    "uploadTs": "2024-10-03T16:44:14",
                    "eventTs": "2024-10-03T16:44:14",
                    "email": "psh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/Docker1.pptx"
                },
                {
                    "eventId": 1055,
                    "saas": "slack",
                    "eventType": "file_upload",
                    "fileName": "가족관계증명서(영문번역예시).pdf",
                    "saasFileId": "F07PS1SPJNT",
                    "uploadTs": "2024-10-03T16:46:48",
                    "eventTs": "2024-10-03T16:46:48",
                    "email": "coex0113@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/개발/HaHayy"
                },
                {
                    "eventId": 1085,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "ClamAV와 Yara로 만드는 Windows Vaccine.pptx",
                    "saasFileId": "19TRtUrHvSJW8yWZviegeWkt8WNIyioFi",
                    "uploadTs": "2024-10-03T16:48:11",
                    "eventTs": "2024-10-03T16:48:11",
                    "email": "psh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/ClamAV와 Yara로 만드는 Windows Vaccine.pptx"
                },
                {
                    "eventId": 1084,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "down.zip",
                    "saasFileId": "1oRpjEnbbYQLgQbGkXhOgKhCyAuxzadZ2",
                    "uploadTs": "2024-10-03T17:03:53",
                    "eventTs": "2024-10-03T17:03:53",
                    "email": "psh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/down.zip"
                },
                {
                    "eventId": 1082,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "구름망WBS_v0.9.xlsx",
                    "saasFileId": "1O94HdYTg_n-tIMZbEAJl0DXAfXPvm60o",
                    "uploadTs": "2024-10-03T17:11:54",
                    "eventTs": "2024-10-03T17:11:54",
                    "email": "psh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/구름망WBS_v0.9.xlsx"
                },
                {
                    "eventId": 1077,
                    "saas": "slack",
                    "eventType": "file_delete",
                    "fileName": "image.png",
                    "saasFileId": "F07QJ770UP3",
                    "uploadTs": "2024-10-03T11:15:07",
                    "eventTs": "2024-10-03T17:33:12",
                    "email": "hsp003636@gmail.com",
                    "uploadChannel": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636"
                },
                {
                    "eventId": 1087,
                    "saas": "GoogleDrive",
                    "eventType": "file_upload",
                    "fileName": "winmine.exe",
                    "saasFileId": "1N3wonBaMr9OL7foKepcW_ivwrmaoSsmV",
                    "uploadTs": "2024-10-03T17:37:17",
                    "eventTs": "2024-10-03T17:37:17",
                    "email": "psh@grum.store",
                    "uploadChannel": "SAMSUNG/GoogleDrive/GASB_Shared/winmine.exe"
                },
                {
                    "eventId": 1038,
                    "saas": "o365",
                    "eventType": "file_upload",
                    "fileName": "[S-개발자] 클라이언트 보안.pdf",
                    "saasFileId": "01Y7RKDPZRNPQ6G5XBNRELZ6XN62BDJUCV",
                    "uploadTs": "2024-10-04T00:20:22",
                    "eventTs": "2024-10-04T00:20:22",
                    "email": "sms@groommang.onmicrosoft.com",
                    "uploadChannel": "SAMSUNG/o365/선 민수/downloads/[S-개발자] 클라이언트 보안.pdf"
                }
            ]
        }
    ]
}
]
historyStatistics.value = [values[0].data.totalUpload, values[0].data.totalChanged, values[0].data.totalDeleted];
historyTrends.value = values[0].data.fileHistoryStatistics;
historyDetails.value = values[1].data[0];
isApiOk.value = true;
loading.value = false;

</script>
