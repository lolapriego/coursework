// https://www.hackerrank.com/challenges/ctci-array-left-rotation/

function rotLeft(a, d) {
  // simplify the rotation
  // in case larger than length
  let r = d % a.length;
  let arr = new Array(a.length);

  for (let i = 0; i < a.length; i++) {
      let j = i + r;
      if (j >= a.length) j -= a.length;
      arr[i] = a[j];
  }
  
  return arr;
}
