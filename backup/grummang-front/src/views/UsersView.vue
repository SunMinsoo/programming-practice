<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading v-if="loading"></cycle-loading>
    <main class="scroll-h scroll overflow-auto rounded-lg" v-else-if="!loading && isApiOk">
      <div>
        <UserStatistics :userStatistics="userStatistics"></UserStatistics>
        <div class="grid grid-cols-3 gap-5 mb-5">
          <DormantRadioChart :dormantRadio="dormantRadio"></DormantRadioChart>
          <TopSensitiveUser :topSensitiveUser="topSensitiveUser"></TopSensitiveUser>
          <TopMalwareUser :topMalwareUser="topMalwareUser"></TopMalwareUser>
          <!-- <TopUserRanking></TopUserRanking> -->
        </div>
        <UserDetails :userDetails="userDetails"></UserDetails>
      </div>
    </main>
    <content-error v-else></content-error>
  </div>
  <!-- <footer>
    <the-footer></the-footer>
  </footer> -->
</template>

<script setup>
import { ref, toRef } from 'vue'
import { userStatisticsApi, userChartInfoApi, userDetailsApi } from '@/apis/user.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'

import UserStatistics from '@/components/user/UserStatistics.vue'
import DormantRadioChart from '@/components/user/DormantRadioChart.vue'
import TopSensitiveUser from '@/components/user/TopSensitiveUser.vue'
import TopMalwareUser from '@/components/user/TopMalwareUser.vue'
import UserDetails from '@/components/user/UserDetails.vue'
// import TopUserRanking from '@/components/user/TopUserRanking.vue'

import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'

let loading = ref(true)
let isApiOk = ref(false)

const userStatistics = ref(null)
const dormantRadio = ref(null);
const topSensitiveUser = ref(null);
const topMalwareUser = ref(null);
const userDetails = ref(null);

// 원본용 코드
// Promise.all([
//   userStatisticsApi(),
//   userChartInfoApi(),
//   userDetailsApi()
// ])
//   .then((values) => {
//     userStatistics.value = [
//       values[0].data.total,
//       values[0].data.dormantTotal,
//       values[0].data.dlpTotal,
//       values[0].data.malwareTotal,
//     ],
//     dormantRadio.value = values[1].data.lastActivities,
//     topSensitiveUser.value = values[1].data.topSensitive,
//     topMalwareUser.value = values[1].data.topMalware,
//     userDetails.value = values[2].data,
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
let values = [
{
    "status": "success",
    "data": {
        "total": 16,
        "dormantTotal": 3,
        "dlpTotal": 2,
        "malwareTotal": 8
    }
},
{
    "status": "success",
    "data": {
        "lastActivities": {
            "undormant": 13,
            "dormanting": 0,
            "dormant": 3
        },
        "topSensitive": [
            {
                "user": "이인석",
                "sensitive": 3
            },
            {
                "user": "HaHayy",
                "sensitive": 2
            },
            {
                "user": "Slackbot",
                "sensitive": 0
            },
            {
                "user": "hsp003636",
                "sensitive": 0
            },
            {
                "user": "여신호_9698",
                "sensitive": 0
            }
        ],
        "topMalware": [
            {
                "user": "HaHayy",
                "malware": 7
            },
            {
                "user": "yubin",
                "malware": 5
            },
            {
                "user": "이인석",
                "malware": 2
            },
            {
                "user": "hsp003636",
                "malware": 1
            },
            {
                "user": "박 서현",
                "malware": 1
            }
        ]
    }
},
{
    "status": "success",
    "data": [
        {
            "id": 1,
            "saas": "slack",
            "user": "Slackbot",
            "account": "none",
            "totalUpload": 0,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "-999999999-01-01T00:00:00"
        },
        {
            "id": 2,
            "saas": "slack",
            "user": "hsp003636",
            "account": "hsp003636@gmail.com",
            "totalUpload": 20,
            "sensitive": 0,
            "malware": 1,
            "lastDate": "2024-10-03T17:33:12"
        },
        {
            "id": 3,
            "saas": "slack",
            "user": "여신호_9698",
            "account": "goei4559@gmail.com",
            "totalUpload": 1,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "2024-07-29T07:13:50"
        },
        {
            "id": 4,
            "saas": "slack",
            "user": "yubin",
            "account": "lee39095296@gmail.com",
            "totalUpload": 35,
            "sensitive": 0,
            "malware": 5,
            "lastDate": "2024-10-03T15:59:28"
        },
        {
            "id": 5,
            "saas": "slack",
            "user": "HaHayy",
            "account": "coex0113@gmail.com",
            "totalUpload": 19,
            "sensitive": 2,
            "malware": 7,
            "lastDate": "2024-10-03T16:46:48"
        },
        {
            "id": 6,
            "saas": "slack",
            "user": "이인석",
            "account": "mandeuk1999@gmail.com",
            "totalUpload": 4,
            "sensitive": 3,
            "malware": 2,
            "lastDate": "2024-08-28T19:41:56"
        },
        {
            "id": 460,
            "saas": "o365",
            "user": "이 인석",
            "account": "lis@groommang.onmicrosoft.com",
            "totalUpload": 8,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "2024-10-03T16:19:00"
        },
        {
            "id": 461,
            "saas": "o365",
            "user": "이 유빈",
            "account": "lyb@groommang.onmicrosoft.com",
            "totalUpload": 1,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "2024-10-02T07:47:31"
        },
        {
            "id": 462,
            "saas": "o365",
            "user": "박 서현",
            "account": "psh@groommang.onmicrosoft.com",
            "totalUpload": 1,
            "sensitive": 0,
            "malware": 1,
            "lastDate": "2024-10-03T16:01:47"
        },
        {
            "id": 463,
            "saas": "o365",
            "user": "선 민수",
            "account": "sms@groommang.onmicrosoft.com",
            "totalUpload": 2,
            "sensitive": 0,
            "malware": 1,
            "lastDate": "2024-10-04T00:20:22"
        },
        {
            "id": 464,
            "saas": "o365",
            "user": "여 신호",
            "account": "ysh@groommang.onmicrosoft.com",
            "totalUpload": 0,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "-999999999-01-01T00:00:00"
        },
        {
            "id": 485,
            "saas": "GoogleDrive",
            "user": "박서현",
            "account": "psh@grum.store",
            "totalUpload": 6,
            "sensitive": 0,
            "malware": 1,
            "lastDate": "2024-10-03T17:37:17"
        },
        {
            "id": 486,
            "saas": "GoogleDrive",
            "user": "lis",
            "account": "lis@grum.store",
            "totalUpload": 2,
            "sensitive": 0,
            "malware": 1,
            "lastDate": "2024-10-03T13:59:36"
        },
        {
            "id": 487,
            "saas": "GoogleDrive",
            "user": "ysh",
            "account": "ysh@grum.store",
            "totalUpload": 2,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "2024-10-03T16:15:41"
        },
        {
            "id": 488,
            "saas": "GoogleDrive",
            "user": "sms",
            "account": "sms@grum.store",
            "totalUpload": 1,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "2024-10-03T15:52:51"
        },
        {
            "id": 489,
            "saas": "GoogleDrive",
            "user": "lyb",
            "account": "lyb@grum.store",
            "totalUpload": 0,
            "sensitive": 0,
            "malware": 0,
            "lastDate": "-999999999-01-01T00:00:00"
        }
    ]
}
]
userStatistics.value = [
  values[0].data.total,
  values[0].data.dormantTotal,
  values[0].data.dlpTotal,
  values[0].data.malwareTotal,
]
dormantRadio.value = values[1].data.lastActivities
topSensitiveUser.value = values[1].data.topSensitive
topMalwareUser.value = values[1].data.topMalware
userDetails.value = values[2].data
isApiOk.value = true
loading.value = false
</script>
