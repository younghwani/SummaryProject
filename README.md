# Summary Project
법원 판결문 뉴스 텍스트 및 법원 주요 판결문 텍스트를 활용한 KoBART 요약 모델 추가 학습

<br/>

## Text Summarization
- Data : https://aihub.or.kr/aidata/8054 (ai-hub, 문서요약 텍스트 - 법률)
- 데이터 변환 : [Json->Tsv](https://github.com/younghwani/SummaryProject/blob/master/Spring/src/main/java/com/younghwani/summarize/utils/JsonUtil.java)
- 요약 모델 : [KoBART Summarization](https://github.com/seujung/KoBART-summarization)
- KoBART 학습 : [Notebook](https://github.com/younghwani/SummaryProject/blob/master/Modeling/kobart_summarize.ipynb)

<br/>

## Demo (Web)

### 텍스트 입력 페이지 및 요약 상태 메시지
<p align="center">
<img src="https://user-images.githubusercontent.com/75962307/147843210-957dbdbe-a149-4179-a42a-17ff6895ea09.png" width="30%" height="30%">
<img width="228" alt="스크린샷 2022-01-01 12 07 52" src="https://user-images.githubusercontent.com/75962307/147843220-47f3ad1c-898b-407a-94b9-cf7d19ee2e0e.png">
</p>

### 요약 결과(예시)
<p align="center">
<img width="80%" height="80%" src="https://user-images.githubusercontent.com/75962307/147843226-79180995-9b3f-4cc4-b90c-9ad87596c579.png">
<img width="80%" height="80%" src="https://user-images.githubusercontent.com/75962307/147843229-4102d540-317a-43dc-8f29-63cb7b6c9a2d.png">
</p>

<br/>

## Demo (Android)
<p align="center">
<img src="https://user-images.githubusercontent.com/75962307/147843378-906c2588-70d9-43b9-83d6-19c0a26ac954.png" width="30%" height="30%">
<img src="https://user-images.githubusercontent.com/75962307/147843383-4d8e6761-3879-4b9c-90b9-427658339f4f.png" width="30%" height="30%">
<img src="https://user-images.githubusercontent.com/75962307/147843387-e4c96458-ad54-42b8-8286-ad7299073009.png" width="30%" height="30%">
</p>

<br/>

## Demo (iOS)
<p align="center">
<img src="https://user-images.githubusercontent.com/75962307/147843626-d3882f57-5ad3-49c1-929f-073dc5ed436c.png" width="30%" height="30%">
<img src="https://user-images.githubusercontent.com/75962307/147843633-29a26ab5-22f8-4709-bbff-823dd34fe21f.png" width="30%" height="30%">
<img src="https://user-images.githubusercontent.com/75962307/147843637-43b9b5b8-97b3-402d-b305-747d57a24966.png" width="30%" height="30%">
</p>

<br/>

## Stack
- Flask : 요약 모델 구동 (api)
- Spring Boot : DB, 웹, 앱과 연동 (api)
- MySQL : 데이터 및 로그 적재
- ReactJS : 웹 구현, admin page (관리자 콘솔) 구현 (api - axios)
- Android : 안드로이드 요약 앱 구현
- IOS : ios 요약 앱 구현 (api - pod)

<br/>
<br/>

## 이전에 진행한 요약 프로젝트
### [Text-Rank 활용한 웹 페이지](https://howls-summarization-web.herokuapp.com/)
