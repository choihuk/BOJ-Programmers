# JAVA Map 연산

### putIfAbsent, computeIfAbsent
**Map에 해당하는 key 값이 발견되지 않을 때 value에 값을 넣는다.**

```java
map.putIfAbsent(key1, 초기값);
map.computeIfAbsent(key1, (k, v) -> 초기값);  # 아마 v 값은 무조건 null일 듯?
```

### put, compute
**Map에 해당하는 key 값의 유무와 관계없이 value에 값을 넣는다.**

### computeIfPresent
**Map에 해당하는 key 값이 존재할 때 value에 값을 넣는다.**
