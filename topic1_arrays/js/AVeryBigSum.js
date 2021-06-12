// https://www.hackerrank.com/challenges/a-very-big-sum/problem

function aVeryBigSum(ar) {
  let sum = BigInt(0);
  
  for (let num of ar) {
      sum += BigInt(num);
  }
  
  return sum;
}


/**
# Commentary:

- Max safe integer in JS is Number.MAX_SAFE_INTEGER, which is \
equal to 2**53 - 1.
- For safety, use BigInt which can handle _anything_ larger than that.
 */
