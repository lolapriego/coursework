// https://www.hackerrank.com/challenges/balanced-brackets/problem

function isBalanced(s) {
  const closing = [];
  
  for (let c of s) {
      if (c == '(') closing.push(')');
      else if (c == '{') closing.push('}');
      else if (c == '[') closing.push(']');
      else {
          // must be closing symbol, test
          if (closing.pop() != c) return "NO";
      }
  }
  
  if (closing.length == 0) return "YES";
  return "NO";
}
