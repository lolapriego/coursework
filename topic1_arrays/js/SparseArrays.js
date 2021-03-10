// https://www.hackerrank.com/challenges/sparse-arrays/problem

function matchingStrings(strings, queries) {
  let arr = new Array(queries.length);
  
  for (let i = 0; i < queries.length; i++) {
      let count = 0;
      for (let s of strings) {
          if (queries[i] == s) count++;
      }
      arr[i] = count;
  }
  
  return arr;
}
