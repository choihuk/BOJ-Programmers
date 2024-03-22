## Disjoint Set이란

> 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조(서로소 집합 자료구조)

## Union Find 개념

### 

- `Union Find이란`: Disjoint Set을 표현할 때 사용하는 알고리즘
- `Union Find의 연산`
  - union: x가 속한 집합과 y가 속한 집합을 합치기
  - find: x가 속한 집합의 대표값(루트 노드)를 반환

### 최적화 전 버전
```java
    private static void union(int a, int b) {
        arr[find(a)] = find(b);
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a];
        }
    }
```

### 최적화 후 버전
```java
    private static void union(int a, int b) {
        arr[find(a)] = find(b);
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return find(arr[a]);
        }
    }
```

### 두 집합의 높이에 따라 더 낮은 집합이 높은 집합에 속하게 하는 버전(최적화 후 버전을 사용한다면 굳이..?)
```java
private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (rank[a] > rank[b]) {
            arr[b] = a;
        } else {
            arr[a] = b;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
```

## 참고
- https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
- 백준 문제: https://www.acmicpc.net/problem/1717
