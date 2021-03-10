// https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

function designerPdfViewer(h, word) {
  // get the max height
  let maxHeight = 0;
  for (let char of word) {
      let index = char.charCodeAt(0) - "a".charCodeAt(0);
      let height = h[index];
      if (height > maxHeight) maxHeight = height;
  }
  
  return maxHeight * word.length;
}
