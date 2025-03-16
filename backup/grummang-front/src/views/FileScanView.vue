<template>
  <side-nav class="w-1/6 float-left"></side-nav>
  <div class="w-5/6 float-right px-5">
    <header-breadcrumb></header-breadcrumb>
    <cycle-loading v-if="loading"></cycle-loading>
    <main class="scroll-h scroll overflow-auto rounded-lg" v-else-if="!loading && isApiOk">
      <div>
        <detection-count :detectionFileCount="detectionFileCount"></detection-count>
        <file-details :fileDetails="fileDetails"></file-details>
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
import { fileScanApi } from '@/apis/file.js'
import SideNav from '@/components/SideNav.vue'
import HeaderBreadcrumb from '@/components/HeaderBreadcrumb.vue'
import TheFooter from '@/components/TheFooter.vue'
import ContentError from '@/components/ContentError.vue'
import CycleLoading from '@/components/CycleLoading.vue'
import DetectionCount from '@/components/file/DetectionCount.vue'
import FileDetails from '@/components/file/FileDetails.vue'

let loading = ref(true)
let isApiOk = ref(false)

let detectionFileCount = ref(null)
let fileDetails = ref(null)

// 원본 코드
// Promise.all([fileScanApi()])
//   .then((values) => {
//     fileDetails.value = values[0]
//     detectionFileCount.value = [
//       values[0].data.total,
//       values[0].data.dlpTotal,
//       values[0].data.malwareTotal
//     ]
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
        "total": 74,
        "dlpTotal": 5,
        "malwareTotal": 19,
        "files": [
            {
                "id": 1,
                "name": "requirements.txt",
                "size": 265,
                "type": "cpp",
                "saas": "slack",
                "user": "hsp003636",
                "path": null,
                "date": "2024-06-18T05:51:37",
                "vtReport": {
                    "type": "txt",
                    "sha256": "886b15487fa6ae32484b1bb291abb6ac8ad78d5c09ad686651676215719f598b",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 65,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/886b15487fa6ae32484b1bb291abb6ac8ad78d5c09ad686651676215719f598b"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": null
                }
            },
            {
                "id": 2,
                "name": "cve-2018-0798.pdf",
                "size": 352543,
                "type": "pdf",
                "saas": "slack",
                "user": "hsp003636",
                "path": null,
                "date": "2024-06-18T05:30:38",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "e92a29ec079eebecc18e38f43b18f32266140ad4669dd30c813b13ab97fc25de",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 67,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/e92a29ec079eebecc18e38f43b18f32266140ad4669dd30c813b13ab97fc25de"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 3,
                "name": "DLL 다운로드.pdf",
                "size": 338027,
                "type": "pdf",
                "saas": "slack",
                "user": "hsp003636",
                "path": null,
                "date": "2024-06-18T05:33:11",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "a9d475223d9893fb7cafa400517d0caae7b9f4e46fc4ba2075bc4be870b4b9a6",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 66,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/a9d475223d9893fb7cafa400517d0caae7b9f4e46fc4ba2075bc4be870b4b9a6"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 4,
                "name": "Injector.pdf",
                "size": 435445,
                "type": "pdf",
                "saas": "slack",
                "user": "hsp003636",
                "path": null,
                "date": "2024-06-18T07:13:08",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "26a4ed4d2dd44f70bd41650874c4388bf5444290a3b9c094a9ae652bfbb6fbbc",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 67,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/26a4ed4d2dd44f70bd41650874c4388bf5444290a3b9c094a9ae652bfbb6fbbc"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 6,
                "name": "test.docx",
                "size": 13478,
                "type": "docx",
                "saas": "slack",
                "user": "여신호_9698",
                "path": "SAMSUNG/slack/psh_slacktest/개발/여신호_9698",
                "date": "2024-07-29T07:13:50",
                "vtReport": {
                    "type": "docx",
                    "sha256": "e1583e2ebd90387a6631ae07f8a96ede0b0402588f277be0d706a6054b46e4ca",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 69,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/e1583e2ebd90387a6631ae07f8a96ede0b0402588f277be0d706a6054b46e4ca"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                        "signature": "docx",
                        "extension": "docx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 7,
                "name": "2._제11회_소프트웨어_개발보안_경진대회_본선_서비스개요서.hwp",
                "size": 56832,
                "type": "binary",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-16T08:04:59",
                "vtReport": {
                    "type": "hwp",
                    "sha256": "22dc7bf56c9f3531a4a7b20657c35fe1711fdad8a4474a561497c4ba69d92aa7",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 65,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/22dc7bf56c9f3531a4a7b20657c35fe1711fdad8a4474a561497c4ba69d92aa7"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/octet-stream",
                        "signature": "unknown",
                        "extension": "hwp"
                    },
                    "step2": null
                }
            },
            {
                "id": 8,
                "name": "XENICS STORMX VM3.lnk",
                "size": 1910,
                "type": "binary",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636",
                "date": "2024-07-30T09:28:53",
                "vtReport": {
                    "type": "lnk",
                    "sha256": "d941f42479d7247091583248e14534b8657caed6d7760ad4aa78f45d23550d51",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 66,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/d941f42479d7247091583248e14534b8657caed6d7760ad4aa78f45d23550d51"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/octet-stream",
                        "signature": "unknown",
                        "extension": "lnk"
                    },
                    "step2": null
                }
            },
            {
                "id": 9,
                "name": "Hello pe.exe",
                "size": 37376,
                "type": "exe",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-16T08:06:00",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.microsoft.portable-executable",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 10,
                "name": "file9.php",
                "size": 169,
                "type": "php",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-16T08:07:55",
                "vtReport": {
                    "type": "php",
                    "sha256": "43221a48512962f46b114510bd934addab5ee57855bb7afe26b3c2420db6f101",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 64,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/43221a48512962f46b114510bd934addab5ee57855bb7afe26b3c2420db6f101"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "php"
                    },
                    "step2": null
                }
            },
            {
                "id": 11,
                "name": "file5.php",
                "size": 409,
                "type": "php",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-08-16T08:10:17",
                "vtReport": {
                    "type": "php",
                    "sha256": "aa855424e794baacefe131bf2e4d89a21ff280f7f64334cadd125b1800cdf12b",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 1,
                    "completeEngine": 64,
                    "score": 1,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/aa855424e794baacefe131bf2e4d89a21ff280f7f64334cadd125b1800cdf12b"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "php"
                    },
                    "step2": null
                }
            },
            {
                "id": 13,
                "name": "소프트웨어_개발보안_가이드(2021.12.29) (2).pdf",
                "size": 5836421,
                "type": "pdf",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-16T08:07:18",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "0621bc054baba87a62220ef2e182bdf57b70e2ab1bd0aa7d69f28e905a1fba73",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "unsupported",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 59,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/0621bc054baba87a62220ef2e182bdf57b70e2ab1bd0aa7d69f28e905a1fba73"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 15,
                "name": "구름망WBS_v0.1 (2).xlsx",
                "size": 18306,
                "type": "xlsx",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-16T08:12:24",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 16,
                "name": "requirements.txt",
                "size": 265,
                "type": "cpp",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy",
                "date": "2024-08-16T08:18:19",
                "vtReport": {
                    "type": "txt",
                    "sha256": "886b15487fa6ae32484b1bb291abb6ac8ad78d5c09ad686651676215719f598b",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 65,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/886b15487fa6ae32484b1bb291abb6ac8ad78d5c09ad686651676215719f598b"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": null
                }
            },
            {
                "id": 17,
                "name": "headache.exe.bak",
                "size": 37376,
                "type": "binary",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy",
                "date": "2024-08-16T08:15:30",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/octet-stream",
                        "signature": "unknown",
                        "extension": "bak"
                    },
                    "step2": null
                }
            },
            {
                "id": 18,
                "name": "winmine.exe",
                "size": 119808,
                "type": "exe",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy",
                "date": "2024-08-16T08:16:15",
                "vtReport": {
                    "type": "exe",
                    "sha256": "d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 5,
                    "completeEngine": 72,
                    "score": 6,
                    "threatLabel": "trojan.",
                    "reportUrl": "https://www.virustotal.com/gui/file/d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.microsoft.portable-executable",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 19,
                "name": "solve.cpp",
                "size": 2516,
                "type": "cpp",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy",
                "date": "2024-08-16T08:19:08",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "cpp"
                    },
                    "step2": null
                }
            },
            {
                "id": 20,
                "name": "programers.py",
                "size": 401,
                "type": "python",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/개발/HaHayy",
                "date": "2024-08-16T08:19:25",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "py"
                    },
                    "step2": null
                }
            },
            {
                "id": 21,
                "name": "image.png",
                "size": 53683,
                "type": "png",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy",
                "date": "2024-08-20T18:25:05",
                "vtReport": {
                    "type": "png",
                    "sha256": "d0a637e0d0b206a645c31926b3c8061c12d575836fc8e912f6b893a6d8f94f86",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 63,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/d0a637e0d0b206a645c31926b3c8061c12d575836fc8e912f6b893a6d8f94f86"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 22,
                "name": "2512-예산.cpp",
                "size": 695,
                "type": "cpp",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/개발/HaHayy",
                "date": "2024-08-28T02:05:48",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": -1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "cpp"
                    },
                    "step2": null
                }
            },
            {
                "id": 24,
                "name": "25-12.cpp",
                "size": 669,
                "type": "cpp",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy",
                "date": "2024-08-28T02:16:52",
                "vtReport": {
                    "type": "cpp",
                    "sha256": "386dc3df261dbc3032f9a133dbb6393d0e77a9982db5819e99e4bdb9f8e05d60",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 61,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/386dc3df261dbc3032f9a133dbb6393d0e77a9982db5819e99e4bdb9f8e05d60"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "cpp"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "Unsupported File Format"
                    }
                }
            },
            {
                "id": 25,
                "name": "slack_test_excel.xlsx",
                "size": 4284210,
                "type": "xlsx",
                "saas": "slack",
                "user": "이인석",
                "path": "SAMSUNG/slack/psh_slacktest/개발/이인석",
                "date": "2024-08-28T05:06:11",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 3,
                    "totalDlp": 3,
                    "comments": [
                        "탐지되면은 파일을 삭제해주세요.",
                        "TEST~"
                    ],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 1
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 1
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 1
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 3
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 26,
                "name": "소프트웨어_보안약점_진단가이드(2021) (1).pdf",
                "size": 32303234,
                "type": "pdf",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-16T08:06:59",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "75336080bd167cfd2655c5587c2c7e07c9916a70ddd4063d22178591c60ba888",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 63,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/75336080bd167cfd2655c5587c2c7e07c9916a70ddd4063d22178591c60ba888"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 27,
                "name": "slack_test_pdf.pdf",
                "size": 43885921,
                "type": "pdf",
                "saas": "slack",
                "user": "이인석",
                "path": "SAMSUNG/slack/psh_slacktest/개발/이인석",
                "date": "2024-08-28T05:06:34",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 33,
                "name": "하이루 (1).txt",
                "size": 416,
                "type": "text",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/개발/yubin",
                "date": "2024-08-28T15:10:05",
                "vtReport": {
                    "type": "txt",
                    "sha256": "2803830aa3db7b7e666b6c6feb12a2e55f9858676ed3c9968b6d91a0ee0a1775",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 63,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/2803830aa3db7b7e666b6c6feb12a2e55f9858676ed3c9968b6d91a0ee0a1775"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 35,
                "name": "하이루 (1).txt",
                "size": 422,
                "type": "text",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-08-28T15:41:25",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 38,
                "name": "나 O365해야해.txt",
                "size": 149,
                "type": "text",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636",
                "date": "2024-08-28T16:08:39",
                "vtReport": {
                    "type": "txt",
                    "sha256": "dfea4905e7dff8f6ca84c668ab8dca8a5bd230f766c643d2abe7cf6ae05bc5e7",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 64,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/dfea4905e7dff8f6ca84c668ab8dca8a5bd230f766c643d2abe7cf6ae05bc5e7"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 41,
                "name": "test_fin.xlsx",
                "size": 11785,
                "type": "xlsx",
                "saas": "slack",
                "user": "이인석",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/이인석",
                "date": "2024-08-28T19:41:56",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 3,
                    "totalDlp": 163,
                    "comments": [
                        "탐지되면은 파일을 삭제해주세요.",
                        "TEST~"
                    ],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 57
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 39
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 67
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 54
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 63
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 36
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 10
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 42,
                "name": "test_fin.pdf",
                "size": 40882,
                "type": "pdf",
                "saas": "slack",
                "user": "이인석",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/이인석",
                "date": "2024-08-28T19:41:54",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 3,
                    "totalDlp": 163,
                    "comments": [
                        "탐지되면은 파일을 삭제해주세요.",
                        "TEST~"
                    ],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 57
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 39
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 67
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 54
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 63
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 36
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 10
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 43,
                "name": "Injector.pdf",
                "size": 435445,
                "type": "pdf",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/개발/hsp003636",
                "date": "2024-08-28T19:52:39",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "26a4ed4d2dd44f70bd41650874c4388bf5444290a3b9c094a9ae652bfbb6fbbc",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 67,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/26a4ed4d2dd44f70bd41650874c4388bf5444290a3b9c094a9ae652bfbb6fbbc"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 63,
                "name": "[KISIA] S-개발자 2기 1차 프로젝트 운영 방안_교육생안내.pdf",
                "size": 698972,
                "type": "pdf",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-09-19T14:01:31",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 64,
                "name": "2024년도 정기 기사 제3회 실기시험(필답형) 시험장 현황(9.9 기준).xlsx",
                "size": 35853,
                "type": "xlsx",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-09-19T14:30:47",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 65,
                "name": "[sdev]osi-and-tcp.docx",
                "size": 41406,
                "type": "docx",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-09-19T15:08:35",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 0,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                        "signature": "docx",
                        "extension": "docx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 69,
                "name": "[KISIA] S-개발자 프로젝트 보고서 - 이유빈.docx",
                "size": 506110,
                "type": "docx",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-09-19T15:54:43",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                        "signature": "docx",
                        "extension": "docx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 135,
                "name": "나 O365해야해.txt",
                "size": 149,
                "type": "text",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636",
                "date": "2024-09-22T15:46:51",
                "vtReport": {
                    "type": "txt",
                    "sha256": "dfea4905e7dff8f6ca84c668ab8dca8a5bd230f766c643d2abe7cf6ae05bc5e7",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 64,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/dfea4905e7dff8f6ca84c668ab8dca8a5bd230f766c643d2abe7cf6ae05bc5e7"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 136,
                "name": "나 O365해야해.txt",
                "size": 169,
                "type": "text",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/hsp003636",
                "date": "2024-09-22T15:46:59",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 142,
                "name": "Slack-SAST.pdf",
                "size": 190977,
                "type": "pdf",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636",
                "date": "2024-09-22T16:09:15",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "Macro"
                    }
                }
            },
            {
                "id": 143,
                "name": "암호_알고리즘_및_키_길이_이용_안내서_2018.pdf",
                "size": 8226162,
                "type": "pdf",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636",
                "date": "2024-09-22T16:10:29",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "36c4384d6cdd941f9f3c39236ccb3cf13e9771557a21cc2a72c8fc0c35499351",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "unsupported",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 60,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/36c4384d6cdd941f9f3c39236ccb3cf13e9771557a21cc2a72c8fc0c35499351"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 144,
                "name": "virustotal.png",
                "size": 8523,
                "type": "png",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636",
                "date": "2024-09-22T16:10:57",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 167,
                "name": "7c44528fe1445378e49e0319e5ccb83e586c82d2c98c03c7c7fde50adc159b29.xlsx",
                "size": 423424,
                "type": "xlsx",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/HaHayy",
                "date": "2024-09-22T16:52:07",
                "vtReport": {
                    "type": "xls",
                    "sha256": "7c44528fe1445378e49e0319e5ccb83e586c82d2c98c03c7c7fde50adc159b29",
                    "v3": "Downloader/XLS.Agent",
                    "alyac": "Trojan.GenericKD.74179860",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "Other:Malware-gen [Trj]",
                    "sentinelone": "unsupported",
                    "detectEngine": 33,
                    "completeEngine": 64,
                    "score": 51,
                    "threatLabel": "trojan.bqdls/msexcel",
                    "reportUrl": "https://www.virustotal.com/gui/file/7c44528fe1445378e49e0319e5ccb83e586c82d2c98c03c7c7fde50adc159b29"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "unknown",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "Macro"
                    }
                }
            },
            {
                "id": 220,
                "name": "고유식별정보.docx",
                "size": 13724,
                "type": "docx",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy",
                "date": "2024-09-22T17:28:34",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 3,
                    "totalDlp": 6,
                    "comments": [
                        "탐지되면은 파일을 삭제해주세요.",
                        "TEST~"
                    ],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 2
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 2
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 2
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 3
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 3
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                        "signature": "docx",
                        "extension": "docx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 221,
                "name": "winmine.exe",
                "size": 119808,
                "type": "exe",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/HaHayy",
                "date": "2024-09-22T17:35:14",
                "vtReport": {
                    "type": "exe",
                    "sha256": "d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 5,
                    "completeEngine": 72,
                    "score": 6,
                    "threatLabel": "trojan.",
                    "reportUrl": "https://www.virustotal.com/gui/file/d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.microsoft.portable-executable",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 247,
                "name": "winmine.exe",
                "size": 119808,
                "type": "exe",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-09-22T18:24:41",
                "vtReport": {
                    "type": "exe",
                    "sha256": "d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 5,
                    "completeEngine": 72,
                    "score": 6,
                    "threatLabel": "trojan.",
                    "reportUrl": "https://www.virustotal.com/gui/file/d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.microsoft.portable-executable",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 469,
                "name": "파일첨부테스트용.txt",
                "size": 91,
                "type": "text",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin",
                "date": "2024-09-24T22:46:12",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 471,
                "name": "파일첨부테스트용.txt",
                "size": 91,
                "type": "text",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin",
                "date": "2024-09-24T23:09:51",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 472,
                "name": "antimal;wre.pdf",
                "size": 138696,
                "type": "pdf",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin",
                "date": "2024-09-24T23:10:37",
                "vtReport": {
                    "type": "pdf",
                    "sha256": "c57e36cd20b61361125aa78a22a64e023151f13ad2e150d896f37065ec4a8414",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 64,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/c57e36cd20b61361125aa78a22a64e023151f13ad2e150d896f37065ec4a8414"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "Macro"
                    }
                }
            },
            {
                "id": 473,
                "name": "winmine.exe",
                "size": 119808,
                "type": "exe",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin",
                "date": "2024-09-24T23:11:02",
                "vtReport": {
                    "type": "exe",
                    "sha256": "d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 5,
                    "completeEngine": 72,
                    "score": 6,
                    "threatLabel": "trojan.",
                    "reportUrl": "https://www.virustotal.com/gui/file/d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.microsoft.portable-executable",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 474,
                "name": "projectStats.csv",
                "size": 304,
                "type": "csv",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/슬랙테스트/yubin",
                "date": "2024-09-24T23:19:43",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/csv",
                        "signature": "unknown",
                        "extension": "csv"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "Unsupported File Format"
                    }
                }
            },
            {
                "id": 924,
                "name": "image.png",
                "size": 54840,
                "type": "png",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636",
                "date": "2024-10-03T10:32:28",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 945,
                "name": "image.png",
                "size": 40127,
                "type": "png",
                "saas": "slack",
                "user": "hsp003636",
                "path": "SAMSUNG/slack/psh_slacktest/slack-전체/hsp003636",
                "date": "2024-10-03T11:13:50",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1007,
                "name": "winmine.exe",
                "size": 119808,
                "type": "exe",
                "saas": "slack",
                "user": "yubin",
                "path": "SAMSUNG/slack/psh_slacktest/소셜/yubin",
                "date": "2024-10-03T15:59:28",
                "vtReport": {
                    "type": "exe",
                    "sha256": "d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 5,
                    "completeEngine": 72,
                    "score": 6,
                    "threatLabel": "trojan.",
                    "reportUrl": "https://www.virustotal.com/gui/file/d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.microsoft.portable-executable",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 1030,
                "name": "가족관계증명서(영문번역예시).pdf",
                "size": 40655,
                "type": "pdf",
                "saas": "slack",
                "user": "HaHayy",
                "path": "SAMSUNG/slack/psh_slacktest/개발/HaHayy",
                "date": "2024-10-03T16:46:48",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 3,
                    "totalDlp": 3,
                    "comments": [
                        "탐지되면은 파일을 삭제해주세요.",
                        "TEST~"
                    ],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 1
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 1
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 1
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 3
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "Macro"
                    }
                }
            },
            {
                "id": 1008,
                "name": "image (2).png",
                "size": 11910,
                "type": "png",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/image (2).png",
                "date": "2024-10-03T02:13:46",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1009,
                "name": "유빈의 텍스트파일_공유.txt",
                "size": 25,
                "type": "text",
                "saas": "o365",
                "user": "이 유빈",
                "path": "SAMSUNG/o365/이 유빈/downloads/유빈의 텍스트파일_공유.txt",
                "date": "2024-10-02T07:47:31",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1010,
                "name": "Anti_Malware.png",
                "size": 23424,
                "type": "png",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/Anti_Malware.png",
                "date": "2024-09-26T00:20:41",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1011,
                "name": "scans.xls",
                "size": 13312,
                "type": "xls",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/scans.xls",
                "date": "2024-09-25T09:18:36",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.ms-excel",
                        "signature": "unknown",
                        "extension": "xls"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1012,
                "name": "민수의 텍스트파일_공유.txt",
                "size": 25,
                "type": "text",
                "saas": "o365",
                "user": "선 민수",
                "path": "SAMSUNG/o365/선 민수/downloads/민수의 텍스트파일_공유.txt",
                "date": "2024-10-02T07:39:08",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "text/plain",
                        "signature": "unknown",
                        "extension": "txt"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1013,
                "name": "[S-개발자] 클라이언트 보안.pdf",
                "size": 7276012,
                "type": "pdf",
                "saas": "o365",
                "user": "선 민수",
                "path": "SAMSUNG/o365/선 민수/downloads/[S-개발자] 클라이언트 보안.pdf",
                "date": "2024-10-04T00:20:22",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "Macro"
                    }
                }
            },
            {
                "id": 1014,
                "name": "tlsh.zip",
                "size": 18129,
                "type": "zip",
                "saas": "o365",
                "user": "박 서현",
                "path": "SAMSUNG/o365/박 서현/downloads/tlsh.zip",
                "date": "2024-10-03T16:01:47",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "application/zip",
                        "signature": "zip",
                        "extension": "zip"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "Unsupported File Format"
                    }
                }
            },
            {
                "id": 1015,
                "name": "Anti_Malware.png",
                "size": 23424,
                "type": "png",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/Anti_Malware.png",
                "date": "2024-09-25T15:20:41",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1016,
                "name": "구름망WBS_v0.8.xlsx",
                "size": 28862,
                "type": "xlsx",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/구름망WBS_v0.8.xlsx",
                "date": "2024-10-03T16:19:00",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1017,
                "name": "scans.xls",
                "size": 13312,
                "type": "xls",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/scans.xls",
                "date": "2024-09-25T00:18:36",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.ms-excel",
                        "signature": "unknown",
                        "extension": "xls"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1018,
                "name": "구름망WBS_v0.7.xlsx",
                "size": 28768,
                "type": "xlsx",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/구름망WBS_v0.7.xlsx",
                "date": "2024-10-03T16:19:00",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1019,
                "name": "image (2).png",
                "size": 11910,
                "type": "png",
                "saas": "o365",
                "user": "이 인석",
                "path": "SAMSUNG/o365/이 인석/downloads/image (2).png",
                "date": "2024-10-02T17:13:46",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/png",
                        "signature": "unknown",
                        "extension": "png"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1053,
                "name": "국내_클라우드산업_활성화_저해_요인_및_애로사항.xlsx",
                "size": 13449,
                "type": "xlsx",
                "saas": "GoogleDrive",
                "user": "ysh",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/국내_클라우드산업_활성화_저해_요인_및_애로사항.xlsx",
                "date": "2024-10-03T16:15:21",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1054,
                "name": "Cat.jpg",
                "size": 6283,
                "type": "jpg",
                "saas": "GoogleDrive",
                "user": "lis",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/Cat.jpg",
                "date": "2024-10-03T13:58:58",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "image/jpeg",
                        "signature": "unknown",
                        "extension": "jpg"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1055,
                "name": "주요업무 수행 확인서.doc",
                "size": 61952,
                "type": "doc",
                "saas": "GoogleDrive",
                "user": "ysh",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/주요업무 수행 확인서.doc",
                "date": "2024-10-03T16:15:41",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/msword",
                        "signature": "unknown",
                        "extension": "doc"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1056,
                "name": "구름망WBS_v0.9.xlsx",
                "size": 28909,
                "type": "xlsx",
                "saas": "GoogleDrive",
                "user": "박서현",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/구름망WBS_v0.9.xlsx",
                "date": "2024-10-03T17:11:54",
                "vtReport": {
                    "type": "xlsx",
                    "sha256": "a9d1744583c684b20277c92d59be884cbd83c394ba953a46181a1e569b68b60c",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "undetected",
                    "detectEngine": 0,
                    "completeEngine": 65,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/a9d1744583c684b20277c92d59be884cbd83c394ba953a46181a1e569b68b60c"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [
                        {
                            "policyName": "DLP 정책 테스트",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "유빈 - TEST",
                            "dlpCount": 0
                        },
                        {
                            "policyName": "DLP 정책 테스트2",
                            "dlpCount": 0
                        }
                    ],
                    "pii": [
                        {
                            "pii": "passport",
                            "dlpCount": 0
                        },
                        {
                            "pii": "identify",
                            "dlpCount": 0
                        },
                        {
                            "pii": "drive",
                            "dlpCount": 0
                        },
                        {
                            "pii": "foreigner",
                            "dlpCount": 0
                        }
                    ]
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        "signature": "xlsx",
                        "extension": "xlsx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1057,
                "name": "하계학술대회(CISC-S’24) CFP v2.pdf",
                "size": 604967,
                "type": "pdf",
                "saas": "GoogleDrive",
                "user": "lis",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/하계학술대회(CISC-S’24) CFP v2.pdf",
                "date": "2024-10-03T13:59:36",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": 1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/pdf",
                        "signature": "pdf",
                        "extension": "pdf"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "Macro"
                    }
                }
            },
            {
                "id": 1058,
                "name": "down.zip",
                "size": 603210,
                "type": "zip",
                "saas": "GoogleDrive",
                "user": "박서현",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/down.zip",
                "date": "2024-10-03T17:03:53",
                "vtReport": {
                    "type": "zip",
                    "sha256": "c5e81cfe8477d269555fb736b5ccce2cfd9bfa35be6baa06426e4da7781968d8",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 0,
                    "completeEngine": 67,
                    "score": 0,
                    "threatLabel": "none",
                    "reportUrl": "https://www.virustotal.com/gui/file/c5e81cfe8477d269555fb736b5ccce2cfd9bfa35be6baa06426e4da7781968d8"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/x-zip-compressed",
                        "signature": "zip",
                        "extension": "zip"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "Unsupported File Format"
                    }
                }
            },
            {
                "id": 1059,
                "name": "ClamAV와 Yara로 만드는 Windows Vaccine.pptx",
                "size": 699838,
                "type": "pptx",
                "saas": "GoogleDrive",
                "user": "박서현",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/ClamAV와 Yara로 만드는 Windows Vaccine.pptx",
                "date": "2024-10-03T16:48:11",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                        "signature": "pptx",
                        "extension": "pptx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1060,
                "name": "[KISIA] 온택트 융합보안_6. 융합보안 개론.pptx",
                "size": 13191330,
                "type": "pptx",
                "saas": "GoogleDrive",
                "user": "sms",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/[KISIA] 온택트 융합보안_6. 융합보안 개론.pptx",
                "date": "2024-10-03T15:52:51",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                        "signature": "pptx",
                        "extension": "pptx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1061,
                "name": "winmine.exe",
                "size": 119808,
                "type": "exe",
                "saas": "GoogleDrive",
                "user": "박서현",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/winmine.exe",
                "date": "2024-10-03T17:37:17",
                "vtReport": {
                    "type": "exe",
                    "sha256": "d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4",
                    "v3": "undetected",
                    "alyac": "undetected",
                    "kaspersky": "undetected",
                    "falcon": "undetected",
                    "avast": "undetected",
                    "sentinelone": "unsupported",
                    "detectEngine": 5,
                    "completeEngine": 72,
                    "score": 6,
                    "threatLabel": "trojan.",
                    "reportUrl": "https://www.virustotal.com/gui/file/d1a612a1791614b628a5c99f03b60ff1b979b8d1f088e99228893cb000c5daf4"
                },
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": 1
                },
                "gscan": {
                    "step1": {
                        "correct": false,
                        "mimeType": "application/x-msdownload",
                        "signature": "exe",
                        "extension": "exe"
                    },
                    "step2": {
                        "detect": true,
                        "yara": "missing_certificate"
                    }
                }
            },
            {
                "id": 1062,
                "name": "Docker2.pptx",
                "size": 869733,
                "type": "pptx",
                "saas": "GoogleDrive",
                "user": "박서현",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/Docker2.pptx",
                "date": "2024-10-03T16:44:11",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                        "signature": "pptx",
                        "extension": "pptx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            },
            {
                "id": 1063,
                "name": "Docker1.pptx",
                "size": 2691091,
                "type": "pptx",
                "saas": "GoogleDrive",
                "user": "박서현",
                "path": "SAMSUNG/GoogleDrive/GASB_Shared/Docker1.pptx",
                "date": "2024-10-03T16:44:14",
                "vtReport": null,
                "dlpReport": {
                    "totalPolicies": 0,
                    "totalDlp": 0,
                    "comments": [],
                    "policies": [],
                    "pii": []
                },
                "fileStatus": {
                    "gscanStatus": 1,
                    "dlpStatus": -1,
                    "vtStatus": -1
                },
                "gscan": {
                    "step1": {
                        "correct": true,
                        "mimeType": "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                        "signature": "pptx",
                        "extension": "pptx"
                    },
                    "step2": {
                        "detect": false,
                        "yara": "none"
                    }
                }
            }
        ]
    }
}
]
fileDetails.value = values[0]
detectionFileCount.value = [
  values[0].data.total,
  values[0].data.dlpTotal,
  values[0].data.malwareTotal
]
isApiOk.value = true
loading.value = false
</script>
