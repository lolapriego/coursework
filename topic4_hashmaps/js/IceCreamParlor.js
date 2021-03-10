// https://www.hackerrank.com/challenges/icecream-parlor/problem

function icecreamParlor(m, arr) {
  // it's good practice to use Map instead
  // of the JS object, read the docs here -
  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map
  const _map = new Map();
  for (let i = 0; i < arr.length; i++) {
      let compl = _map.get(m - arr[i]);
      if (compl) {
          return [compl, i + 1];
      }
      _map.set(arr[i], i + 1);
  }
  return [];
}
