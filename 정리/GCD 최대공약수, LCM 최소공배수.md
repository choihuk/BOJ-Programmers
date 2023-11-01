## GCD 구하기
1. BigInteger 내장 함수를 사용

```java
  private static int gcdThing(int a, int b) {

      BigInteger b1 = BigInteger.valueOf(a);
      BigInteger b2 = BigInteger.valueOf(b);
      BigInteger gcd = b1.gcd(b2);

      return gcd.intValue();
  }
```

2. 직접 구현

```java
    // 재귀함수
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    // 반복문
    private static int gcd(int a, int b) {
        int tmp, n;
 
        //a에 큰 값을 위치시키기 위한 조건이다.
        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
 
        //b가 0 될때까지(a%b), 반복문을 돌게되고, b가 0인 순간의 a를 GCD로 판단하고 리턴한다
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
```

## LCM 구하기

```java
    public static int lcm(int x, int y) {
        //0이 아닌 두 수의 곱 / 두 수의 최대공약수
        return (x * y) / gcd(x, y);
    }
```
