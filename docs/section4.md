# Artillery 활용
## 시나리오 작성해서 테스트 하기
```yaml
config:
  target: 'http://localhost:8080'
  phases:
    - duration: 30
      arrivalRate: 3
      name: Warm up
    - duration: 30
      arrivalRate: 3
      rampTo: 30
      name: Ramp up load
    - duration: 60
      arrivalRate: 30
      name: Sustained load
    - duration: 30
      arrivalRate: 30
      rampTo: 10
      name: End of load
scenarios:
  - name: "login and use some functions"
    flow:
      - post:
          url: "/login"
      - get:
          url: "/some-function-one"
      - get:
          url: "/some-function-two"
  - name: "just login"
    flow:
      - post:
          url: "/login"
```

## 파라미터 활용하여 테스트 하기
```yaml
config:
  target: 'http://localhost:8080'
  phases:
    - duration: 30
      arrivalRate: 3
      name: Warm up
  payload:
    path: "id-password.csv"
    fields:
      - "id"
      - "password"
scenarios:
  - name: "just login"
    flow:
      - post:
          url: "/login-with-id-password"
          json:
            id: "{{ id }}"
            password: "{{ password }}"
```

## 높은 부하를 받았을 때 성능 테스트 결과 해석하기
```yaml
config:
  target: 'http://localhost:8080'
  phases:
    - duration: 30
      arrivalRate: 20
      name: Warm up
    - duration: 10
      arrivalRate: 20
      rampTo: 200
      name: Ramp up load
    - duration: 10
      arrivalRate: 200
      name: Sustained load
    - duration: 30
      arrivalRate: 200
      rampTo: 20
      name: End of load
scenarios:
  - name: "high load cpu"
    flow:
      - get:
          url: "/high-load-cpu"
#  - name: "high load memory"
#    flow:
#      - get:
#          url: "high-load-memory"
```