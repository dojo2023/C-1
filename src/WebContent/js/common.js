/**
 * 
 */


const main = document.querySelectorAll(".sub");
const item = Array.prototype.slice.call(main,0);

console.log(main);

item.forEach(function (element) {
  element.addEventListener("mouseover",function(){
    element.querySelector(".sub-list").classList.add("open");
  },false);
  element.addEventListener("mouseout",function(){
    element.querySelector(".sub-list").classList.remove("open");
  },false);
});