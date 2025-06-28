# 간단한 성능 개선 경험해보기
## 캐시 적용하여 성능 개선하기
```yaml
config:
  target: 'http://localhost:8080'
  phases:
    - duration: 60
      arrivalRate: 30
  payload:
    path: "numbers.csv"
    fields:
      - "number"
scenarios:
  - name: "gat hash"
    flow:
      - get:
          #url: "/no-cache-hash-string?input={{ number }}"
          url: "/cache-hash-string?input={{ number }}"
```

## ArrayList vs HashMap 검색 시간 차이 확인하기
