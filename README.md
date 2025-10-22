# leetcode-hub
Collection of LeetCode questions to ace the coding interview! - Created using [LeetHub-3.0](https://github.com/raphaelheinz/LeetHub-3.0)
---

# Array

## sort

```java
Arrays.sort(arr);
```

# String

## char

```java
char[] c = s.toCharArray();

char c = s.charAt(i);
```

## isTargetCharacter

[문제](1456-maximum-number-of-vowels-in-a-substring-of-given-length/1456-maximum-number-of-vowels-in-a-substring-of-given-length.java)

```java

# 1번
private boolean isVowel(char c) {
  if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;

  return false;
}
isVowel(targetChar);

# 2번
Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
VOWELS.contains(targetChar)

# 1번이 더 빠름
```
