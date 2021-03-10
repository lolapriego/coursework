// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

class Queue {
  constructor() {
      this.inStack = [];
      this.outStack = [];
      this.size = 0;
  }
  
  _moveItems(_from, _to) {
      while (_from.length > 0) {
          _to.push(_from.pop());
      }
  }
  
  enqueue(item) {
      if (this.outStack.length > 0)
          this._moveItems(this.outStack, this.inStack);
      this.inStack.push(item);
      this.size++;
      return this;
  }
  
  dequeue() {
      if (this.size > 0) {
          if (this.inStack.length > 0) {}
              this._moveItems(this.inStack, this.outStack);
          this.size--;
          return this.outStack.pop();
      }
      return undefined;
  }
  
  front() {
      if (this.size == 0) return undefined;
      if (this.outStack.length > 0)
          return this.outStack[this.size - 1];
      return this.inStack[0];
  }
}


// HackerRank specific
function processData(input) {
  let lines = input.split('\n').map(line => line.split(' '));
  
  const q = new Queue();
  
  // skip line 1
  for (let i = 1; i < lines.length; i++) {
      let line = lines[i];
      if (line[0] == '1') q.enqueue(line[1]);
      else if (line[0] == '2') q.dequeue();
      else if (line[0] == '3') console.log(q.front());
  }
}