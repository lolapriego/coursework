// https://www.hackerrank.com/challenges/migratory-birds/problem

function migratoryBirds(arr) {
  const _map = new Map();
  
  for (let id of arr) {
      if (_map.get(id)) _map.set(id, _map.get(id) + 1);
      else _map.set(id, 1);
  }
  
  // find max ids
  let max = 1;
  let ids = [];
  for (let [k, v] of _map) {
      if (v > max) {
          // reset ids
          ids = [ k ];
          max = v;
      }
      else if (v == max) ids.push(k);
  }
  
  // sort ids
  ids.sort((a, b) => a - b);
  return ids[0]; // lowest id
}
