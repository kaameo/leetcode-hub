# leetcode-hub
Collection of LeetCode questions to ace the coding interview! - Created using [LeetHub-3.0](https://github.com/raphaelheinz/LeetHub-3.0)
---

# Array

## sort

```java
Arrays.sort(arr);
```

## Deque

### Deque to Array

[문제](0735-asteroid-collision/0735-asteroid-collision.java)

```java
// deque.size()는 반복문이 도는 동안 줄어듭니다.
int[] arr = new int[deque.size()];
for (int i = 0; i < deque.size(); i++) {
    arr[i] = deque.pollFirst();
}
// deque = [5, 10]
// arr = [5]

// 맞는 코드
int n = deque.size();
int[] arr = new int[n];
for (int i = 0; i < n; i++) {
    arr[i] = deque.pollFirst();
}
// deque = [5, 10]
// arr = [5, 10]

```

# String

## char[] to String

```java
Arrays.toString(charArray);
// == "[a, b, c, d, e]"

new String(charArray)
// "abcde"
```

## char

```java
char[] c = s.toCharArray();

char c = s.charAt(i);
```

## isTargetCharacter

[문제](1456-maximum-number-of-vowels-in-a-substring-of-given-length/1456-maximum-number-of-vowels-in-a-substring-of-given-length.java)

```java
// 1번
private boolean isVowel(char c) {
  if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;

  return false;
}
isVowel(targetChar);

// 2번
Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
VOWELS.contains(targetChar)

// 1번이 더 빠름
```

## Map & Set

[문제](1207-unique-number-of-occurrences/1207-unique-number-of-occurrences.java)

### Map

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i : arr) {
    map.put(i, map.getOrDefault(i, 0) + 1);
}

map.values(); // return Collection(v);
map.keySet(); // return Set<K>;
```

---

[문제](2352-equal-row-and-column-pairs/2352-equal-row-and-column-pairs.java)

```java
 public int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<String, Integer> rowCount = new HashMap<>();

    // 각 행을 문자열로 변환해서 개수 저장
    for (int[] row : grid) {
        String key = Arrays.toString(row);
        rowCount.put(key, rowCount.getOrDefault(key, 0) + 1);
    }

    int ans = 0;
    // 각 열도 문자열로 변환하여 행 맵에서 조회
    for (int j = 0; j < n; j++) {
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = grid[i][j];
        }
        String key = Arrays.toString(col);
        ans += rowCount.getOrDefault(key, 0);
    }

    return ans;
}

```

int 배열 비교시 각 index value 비교뿐만 아니라,  String으로 변환후 비교하는 방식도 있음

### Set

```java
Set<String> names = new HashSet<>(map.values());
```

## Stack

> java.util.Stack 은 약간 구식

[문제](0841-keys-and-rooms/0841-keys-and-rooms.java)

-> ArrayDeque 사용, String인경우 StringBuilder 사용가능(StringBuilder는 String 변경마다 객체생성 안함)
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.push(n);
deque.pop();
```


## Queue

```java
// 맞음
Queue<Integer> queue = new LinkedList<>();
// 틀림
Queue<Integer> queue = new ArrayList<>();
```
