# Artillery
## Artillery 소개
### Get Artillery
1. Node.js가 설치되어 있어야 한다.
2. `npm install -g artillery@latest`
3. artillery 설치 확인 `artillery --version`

### Run
```yaml
config:
  target: 'http://localhost:8080'
  phases:
    - duration: 60
      arrivalRate: 5
scenarios:
  - flow:
    - get:
        url: "/hello"
```
```shell
artillery run --output report.json .\test-config.yaml
```

### Report
* report.json to report.html
```shell
artillery report .\report.json --output .\report.html
```

## 성능 테스트 결과 해석하기
### Summary
Test duration: 테스트 진행 기간
Scenarios created: 요청 생성 개수
Scenarios completed: 완료된 요청 개수

### Scenario counts

### Codes
응답 코드와 개수

### Errors
에러 발생시 에러 내용

### Charts
#### Overall Latency Distribution
* min
* max
* median
* p95
* p99

### Latency At Intervals

### Concurrent users
현재 유저가 몇명씩 요청을 하고 있는지

### Mean RPS(Mean requests per second)
매 초마다 보내지는 요청

### RPS Count

### HTTP codes
HTTP Status 코드들

