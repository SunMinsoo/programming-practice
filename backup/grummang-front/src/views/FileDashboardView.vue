<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading
      v-if="loading"></cycle-loading>
    <main 
      class="scroll-h scroll overflow-auto rounded-lg"
      v-else-if="!loading && isApiOk">
      <div class="grid grid-cols-2 gap-5 mb-5">
        <div class="grid grid-cols-2 grid-rows-3 gap-5">
          <div class="flex items-center bg-white p-4 rounded-lg shadow-sm">
            <div>
              <h2 class="text-lg font-semibold mb-2">총 파일</h2>
              <p class="text-3xl font-bold">{{ reponseData.totalCount }} 개</p>
            </div>
            <v-icon :size="48" class="text-orange ml-auto">mdi-file-cloud-outline</v-icon>
          </div>
          <div class="flex items-center bg-white p-4 rounded-lg shadow-sm">
            <div>
              <h2 class="text-lg font-semibold mb-2">전체 파일 용량</h2>
              <p class="text-3xl font-bold">{{ formatFileSize(reponseData.totalVolume) }}</p>
            </div>
            <v-icon :size="48" class="text-indigo-900 ml-auto">mdi-server</v-icon>
          </div>
          <div class="row-span-2 bg-white p-4 rounded-lg shadow-sm">
            <h2 class="text-lg font-semibold mb-2">DLP 비율</h2>
            <semicircular-chart :score=dlpRatio :color="'#fbbf24'" class="size-40"></semicircular-chart>
          </div>
          <div class="row-span-2 bg-white p-4 rounded-lg shadow-sm">
            <h2 class="text-lg font-semibold mb-2">악성 비율</h2>
            <semicircular-chart :score=malwareRatio :color="'#dc2626'" class="size-40"></semicircular-chart>
          </div>
        </div>
        <div class="bg-white p-4 rounded-lg shadow-sm">
          <type-ratio-chart :data="reponseData.totalType" class="grow"></type-ratio-chart>
        </div>
      </div>
      <!-- 파일 선 그래프 -->
      <div class="grid grid-cols-2 gap-5">
        <div class="bg-white p-4 rounded-lg shadow-sm">
            <count-line-chart :data="statistics"></count-line-chart>
          </div>
          <div class="bg-white p-4 rounded-lg shadow-sm">
            <size-line-chart :data="statistics"></size-line-chart>
          </div>
      </div>
    </main>
    <content-error v-else></content-error>
  </div>
  <!-- <footer>
    <the-footer></the-footer>
  </footer> -->
</template>

<script setup>
import { ref, onMounted, computed } from 'vue'
import { totalFileInfoApi } from '@/apis/file.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'
// 임시로
import SemicircularChart from '@/components/file/SemicircularChart.vue'
import TypeRatioChart from '@/components/file/TypeRatioChart.vue'
import CountLineChart from '@/components/file/CountLineChart.vue'
import SizeLineChart from '@/components/file/SizeLineChart.vue'

import { BarController, DoughnutController, LineController } from 'chart.js'
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, PointElement, LineElement, ArcElement } from 'chart.js';

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, PointElement, LineElement, ArcElement);

let loading = ref(true);
let isApiOk = ref(false);

let totalCount = ref(0);
let dlpRatio = ref(0);
let malwareRatio = ref(0);
let statistics = ref(null);

const reponseData = ref(null);


// 원본용 코드
// Promise.all([
//   totalFileInfoApi(),
// ]).then((values) => {
//   reponseData.value = values[0].data; 
//   totalCount = values[0].data.totalCount;
//   malwareRatio.value = Math.floor((values[0].data.totalMalware / values[0].data.totalCount) * 100);
//   dlpRatio.value = Math.floor((values[0].data.totalDlp / values[0].data.totalCount) * 100);
//   statistics.value = values[0].data.statistics;
//   isApiOk.value = true;
// }).catch((err) => {

// }).finally(() => {
//   loading.value = false;
// });

const formatFileSize = (bytes) => {
  const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB'];
  if (bytes === 0) return '0 Byte';
  const i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
  return Math.round(bytes / Math.pow(1024, i), 2) + ' ' + sizes[i];
};


/* 
테스트용 성공으로 가정
*/
const values = [
{
    "status": "success",
    "data": {
        "totalCount": 74,
        "totalVolume": 125508246,
        "totalDlp": 5,
        "totalMalware": 19,
        "totalType": [
            {
                "type": "cpp",
                "count": 5
            },
            {
                "type": "pdf",
                "count": 15
            },
            {
                "type": "docx",
                "count": 4
            },
            {
                "type": "binary",
                "count": 3
            },
            {
                "type": "exe",
                "count": 7
            },
            {
                "type": "php",
                "count": 2
            },
            {
                "type": "xlsx",
                "count": 9
            },
            {
                "type": "python",
                "count": 1
            },
            {
                "type": "png",
                "count": 8
            },
            {
                "type": "text",
                "count": 9
            },
            {
                "type": "csv",
                "count": 1
            },
            {
                "type": "xls",
                "count": 2
            },
            {
                "type": "zip",
                "count": 2
            },
            {
                "type": "jpg",
                "count": 1
            },
            {
                "type": "doc",
                "count": 1
            },
            {
                "type": "pptx",
                "count": 4
            }
        ],
        "statistics": [
            {
                "date": "2024-09-04",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-05",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-06",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-07",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-08",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-09",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-10",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-11",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-12",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-13",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-14",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-15",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-16",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-17",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-18",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-19",
                "volume": 1517471,
                "count": 7
            },
            {
                "date": "2024-09-20",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-21",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-22",
                "volume": 9760171,
                "count": 17
            },
            {
                "date": "2024-09-23",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-24",
                "volume": 397686,
                "count": 6
            },
            {
                "date": "2024-09-25",
                "volume": 228998,
                "count": 5
            },
            {
                "date": "2024-09-26",
                "volume": 23424,
                "count": 1
            },
            {
                "date": "2024-09-27",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-28",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-29",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-09-30",
                "volume": 105949,
                "count": 3
            },
            {
                "date": "2024-10-01",
                "volume": 0,
                "count": 0
            },
            {
                "date": "2024-10-02",
                "volume": 11960,
                "count": 3
            },
            {
                "date": "2024-10-03",
                "volume": 19330301,
                "count": 21
            }
        ]
    }
}
]
reponseData.value = values[0].data; 
totalCount = values[0].data.totalCount;
malwareRatio.value = Math.floor((values[0].data.totalMalware / values[0].data.totalCount) * 100);
dlpRatio.value = Math.floor((values[0].data.totalDlp / values[0].data.totalCount) * 100);
statistics.value = values[0].data.statistics;
isApiOk.value = true;
loading.value = false;

</script>
