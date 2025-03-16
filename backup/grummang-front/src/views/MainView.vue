<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading v-if="loading"></cycle-loading>
    <main class="scroll-h scroll overflow-auto rounded-lg" v-else-if="!loading && isApiOk">
      <div>
        <ConnectingSaas :connectSaas="connectSaas"></ConnectingSaas>
        <div class="grid grid-cols-3 gap-5">
          <MainStatistics :statisticsValue="statisticsValue"></MainStatistics>
          <FileSizeChart :saasFileSize="saasFileSize"></FileSizeChart>
          <FileCountChart :saasFileCount="saasFileCount"></FileCountChart>
        </div>
        <div class="grid grid-cols-3 gap-5">
          <FileAnalysisRate :fileAnalysisRate="fileAnalysisRate"></FileAnalysisRate>
          <TodayFileDetect :todayFileDetect="todayFileDetect" class="col-span-2"></TodayFileDetect>
        </div>
        <div class="grid grid-cols-5 gap-5">
          <FileHistoryInfo :fileHistoryInfo="fileHistoryInfo" class="col-span-2"></FileHistoryInfo>
          <FileHistoryLine :fileHistoryLine="fileHistoryLine" class="col-span-3"></FileHistoryLine>
        </div>
        <div class="grid grid-cols-5 gap-5">
          <DlpPiisChart :dlpPiis="dlpPiis" class="col-span-2"></DlpPiisChart>
          <DlpStatisticsChart :dlpStatistics="dlpStatistics" class="col-span-3"></DlpStatisticsChart>
        </div>
        <!-- <p>{{ fileHistoryInfo }}</p>
        <p>{{ fileHistoryLine }}</p>
        <p>{{ dlpStatistics }}</p>
        <p>{{ dlpPiis }}</p> -->
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
import { mainTotalApi, mainStatisticsApi, mainDlpApi } from '@/apis/main.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'

import ConnectingSaas from '@/components/main/ConnectingSaas.vue'
import MainStatistics from '@/components/main/MainStatistics.vue'
import FileSizeChart from '@/components/main/FileSizeChart.vue'
import FileCountChart from '@/components/main/FileCountChart.vue'
import TodayFileDetect from '@/components/main/TodayFileDetect.vue'
import FileAnalysisRate from '@/components/main/FileAnalysisRate.vue'
import FileHistoryInfo from '@/components/main/FileHistoryInfo.vue'
import FileHistoryLine from '@/components/main/FileHistoryLine.vue'
import DlpStatisticsChart from '@/components/main/DlpStatisticsChart.vue'
import DlpPiisChart from '@/components/main/DlpPiisChart.vue'

let loading = ref(true)
let isApiOk = ref(false)

let responseData = ref(null)
let connectSaas = ref(null)
let statisticsValue = ref(null)
let saasFileSize = ref(null)
let saasFileCount = ref(null)
let todayFileDetect = ref(null)
let fileAnalysisRate = ref(null)
let fileHistoryInfo = ref(null)
let fileHistoryLine = ref(null)
let dlpStatistics = ref(null)
let dlpPiis = ref(null)

// 로그인 유도
import { fileScanApi } from '@/apis/file.js'

// 윈본 코드드
// Promise.all([
//   mainTotalApi(),
//   mainStatisticsApi(),
//   mainDlpApi()
//   ]).then((values) => {
//   connectSaas.value = values[0].data.saas,
//   statisticsValue.value = values[0].data,
//   saasFileSize.value = values[0].data.fileSizeBySaaS,
//   saasFileCount.value = values[0].data.fileUploadBySaaS,
//   todayFileDetect.value = values[1].data.fileScanInToday,
//   fileAnalysisRate.value = values[1].data.fileAnalysis,
//   fileHistoryInfo.value = values[1].data.fileHistoryInfo, 
//   fileHistoryLine.value = values[1].data.fileHistoryStatistics,
//   dlpStatistics.value = values[2].data.statisticsByPolicies,
//   dlpPiis.value = values[2].data.statisticsByPiis,
//   isApiOk.value = true;
// }).catch((err) => {
  
// }).finally(() => {
//   loading.value = false;
// });


// 테스트용으로 성공으로 가정
connectSaas.value = [
            {
                "saas": "slack",
                "alias": "fffffff",
                "email": "sasd@123123.vv"
            },
            {
                "saas": "o365",
                "alias": "mstest",
                "email": "test@test.com"
            },
            {
                "saas": "GoogleDrive",
                "alias": "GDTEST",
                "email": "test@test.com"
            }
        ],
  statisticsValue.value = {
        "saas": [
            {
                "saas": "slack",
                "alias": "fffffff",
                "email": "sasd@123123.vv"
            },
            {
                "saas": "o365",
                "alias": "mstest",
                "email": "test@test.com"
            },
            {
                "saas": "GoogleDrive",
                "alias": "GDTEST",
                "email": "test@test.com"
            }
        ],
        "totalSaaS": 3,
        "totalAlert": 0,
        "totalDlp": 4,
        "totalUser": 16,
        "totalFile": 74,
        "dailyFileCountDifference": 19,
        "totalFileSize": 125508246,
        "dailyFileSizeDifference": 19233669,
        "fileSizeBySaaS": [
            {
                "saas": "slack",
                "size": 99168563,
                "dailyDifference": 255430
            },
            {
                "saas": "o365",
                "size": 173101,
                "dailyDifference": 87669
            },
            {
                "saas": "GoogleDrive",
                "size": 18890570,
                "dailyDifference": 18890570
            }
        ],
        "fileUploadBySaaS": [
            {
                "saas": "slack",
                "upload": 51,
                "dailyDifference": 4
            },
            {
                "saas": "o365",
                "upload": 11,
                "dailyDifference": 4
            },
            {
                "saas": "GoogleDrive",
                "upload": 11,
                "dailyDifference": 11
            }
        ]
    },
  saasFileSize.value = [
            {
                "saas": "slack",
                "size": 99168563,
                "dailyDifference": 255430
            },
            {
                "saas": "o365",
                "size": 173101,
                "dailyDifference": 87669
            },
            {
                "saas": "GoogleDrive",
                "size": 18890570,
                "dailyDifference": 18890570
            }
        ],
  saasFileCount.value = [
            {
                "saas": "slack",
                "upload": 51,
                "dailyDifference": 4
            },
            {
                "saas": "o365",
                "upload": 11,
                "dailyDifference": 4
            },
            {
                "saas": "GoogleDrive",
                "upload": 11,
                "dailyDifference": 11
            }
        ],
  todayFileDetect.value = [
            {
                "saas": "slack",
                "fileName": "image.png",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "hsp003636",
                "eventTs": "2024-10-03T10:32:28"
            },
            {
                "saas": "slack",
                "fileName": "image.png",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "hsp003636",
                "eventTs": "2024-10-03T11:13:50"
            },
            {
                "saas": "slack",
                "fileName": "winmine.exe",
                "suspicious": 2,
                "dlp": -1,
                "vt": 2,
                "creator": "yubin",
                "eventTs": "2024-10-03T15:59:28"
            },
            {
                "saas": "slack",
                "fileName": "가족관계증명서(영문번역예시).pdf",
                "suspicious": 2,
                "dlp": 2,
                "vt": -1,
                "creator": "HaHayy",
                "eventTs": "2024-10-03T16:46:48"
            },
            {
                "saas": "o365",
                "fileName": "image (2).png",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "이 인석",
                "eventTs": "2024-10-03T02:13:46"
            },
            {
                "saas": "o365",
                "fileName": "tlsh.zip",
                "suspicious": 2,
                "dlp": -1,
                "vt": -1,
                "creator": "박 서현",
                "eventTs": "2024-10-03T16:01:47"
            },
            {
                "saas": "o365",
                "fileName": "구름망WBS_v0.8.xlsx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "이 인석",
                "eventTs": "2024-10-03T16:19:00"
            },
            {
                "saas": "o365",
                "fileName": "구름망WBS_v0.7.xlsx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "이 인석",
                "eventTs": "2024-10-03T16:19:00"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "국내_클라우드산업_활성화_저해_요인_및_애로사항.xlsx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "ysh",
                "eventTs": "2024-10-03T16:15:21"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "Cat.jpg",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "lis",
                "eventTs": "2024-10-03T13:58:58"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "주요업무 수행 확인서.doc",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "ysh",
                "eventTs": "2024-10-03T16:15:41"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "구름망WBS_v0.9.xlsx",
                "suspicious": 1,
                "dlp": 1,
                "vt": 1,
                "creator": "박서현",
                "eventTs": "2024-10-03T17:11:54"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "하계학술대회(CISC-S’24) CFP v2.pdf",
                "suspicious": 2,
                "dlp": 1,
                "vt": -1,
                "creator": "lis",
                "eventTs": "2024-10-03T13:59:36"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "down.zip",
                "suspicious": 1,
                "dlp": -1,
                "vt": 1,
                "creator": "박서현",
                "eventTs": "2024-10-03T17:03:53"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "ClamAV와 Yara로 만드는 Windows Vaccine.pptx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "박서현",
                "eventTs": "2024-10-03T16:48:11"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "[KISIA] 온택트 융합보안_6. 융합보안 개론.pptx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "sms",
                "eventTs": "2024-10-03T15:52:51"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "winmine.exe",
                "suspicious": 2,
                "dlp": -1,
                "vt": 2,
                "creator": "박서현",
                "eventTs": "2024-10-03T17:37:17"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "Docker2.pptx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "박서현",
                "eventTs": "2024-10-03T16:44:11"
            },
            {
                "saas": "GoogleDrive",
                "fileName": "Docker1.pptx",
                "suspicious": 1,
                "dlp": -1,
                "vt": -1,
                "creator": "박서현",
                "eventTs": "2024-10-03T16:44:14"
            }
        ],
  fileAnalysisRate.value = {
            "totalCount": 74,
            "suspiciousAnalysis": 64,
            "dlpAnalysis": 38,
            "vtAnalysis": 29
        },
  fileHistoryInfo.value = [
            {
                "saas": "slack",
                "upload": 79,
                "change": 9,
                "delete": 27,
                "lastActivity": "2024-10-03"
            },
            {
                "saas": "o365",
                "upload": 12,
                "change": 0,
                "delete": 0,
                "lastActivity": "2024-10-04"
            },
            {
                "saas": "GoogleDrive",
                "upload": 11,
                "change": 0,
                "delete": 0,
                "lastActivity": "2024-10-03"
            }
        ], 
  fileHistoryLine.value = [
            {
                "month": "2024-10",
                "total": 29
            },
            {
                "month": "2024-09",
                "total": 55
            },
            {
                "month": "2024-08",
                "total": 47
            },
            {
                "month": "2024-07",
                "total": 3
            },
            {
                "month": "2024-06",
                "total": 4
            },
            {
                "month": "2024-05",
                "total": 0
            },
            {
                "month": "2024-04",
                "total": 0
            },
            {
                "month": "2024-03",
                "total": 0
            },
            {
                "month": "2024-02",
                "total": 0
            },
            {
                "month": "2024-01",
                "total": 0
            },
            {
                "month": "2023-12",
                "total": 0
            },
            {
                "month": "2023-11",
                "total": 0
            }
        ],
  dlpStatistics.value = [
            {
                "policy": "DLP 정책 테스트",
                "pii": [
                    {
                        "pii": "identify",
                        "total": 5
                    },
                    {
                        "pii": "passport",
                        "total": 3
                    },
                    {
                        "pii": "drive",
                        "total": 2
                    }
                ]
            },
            {
                "policy": "유빈 - TEST",
                "pii": [
                    {
                        "pii": "identify",
                        "total": 5
                    },
                    {
                        "pii": "passport",
                        "total": 3
                    }
                ]
            },
            {
                "policy": "DLP 정책 테스트2",
                "pii": [
                    {
                        "pii": "identify",
                        "total": 5
                    },
                    {
                        "pii": "passport",
                        "total": 3
                    },
                    {
                        "pii": "drive",
                        "total": 2
                    },
                    {
                        "pii": "foreigner",
                        "total": 2
                    }
                ]
            },
            {
                "policy": "DLP 정책 테스트2",
                "pii": [
                    {
                        "pii": "identify",
                        "total": 0
                    },
                    {
                        "pii": "passport",
                        "total": 0
                    },
                    {
                        "pii": "drive",
                        "total": 0
                    },
                    {
                        "pii": "foreigner",
                        "total": 0
                    }
                ]
            }
        ],
  dlpPiis.value = [
            {
                "pii": "identify",
                "total": 45
            },
            {
                "pii": "passport",
                "total": 37
            },
            {
                "pii": "drive",
                "total": 36
            },
            {
                "pii": "foreigner",
                "total": 20
            }
        ],
  isApiOk.value = true;
  loading.value = false;


</script>
