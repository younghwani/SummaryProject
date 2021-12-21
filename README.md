# Summary Project
법원 판결문 뉴스 텍스트 및 법원 주요 판결문 텍스트를 활용한 KoBART 요약 모델 추가 학습

</br>

## Text Summarization
- Data : https://aihub.or.kr/aidata/8054 (ai-hub, 문서요약 텍스트 - 법률)
- 데이터 변환 : [Json->Tsv](https://github.com/younghwani/SummaryProject/blob/master/Spring/src/main/java/com/younghwani/summarize/utils/JsonUtil.java)
- 요약 모델 : [KoBART Summarization](https://github.com/seujung/KoBART-summarization)
- KoBART 학습 : [Notebook](https://github.com/younghwani/SummaryProject/blob/master/Modeling/kobart_summarize.ipynb)

</br>

## Stack
- Flask : 요약 모델 구동 (api)
- Spring Boot : DB, 웹, 앱과 연동 (api)
- MySQL : 데이터 및 로그 적재
- ReactJS : 웹 구현, admin page (관리자 콘솔) 구현 (api - axios)
- Android : 안드로이드 요약 앱 구현
- IOS : ios 요약 앱 구현 (api - pod)


</br>
</br>
## 이전에 진행한 요약 프로젝트
### [Text-Rank 활용한 웹 페이지](https://howls-summarization-web.herokuapp.com/)
