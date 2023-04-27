"use srict";

const header_br_img = document.querySelector(".header_br_img");

let scrolledOn = 0;

document.addEventListener ("scroll", function (e) {
    scrolledOn = window.pageYOffset;
    let s = (1 + (scrolledOn * 0.3)).toFixed(3);
    header_br_img.setAttribute('style', `transform: scale(1.01)  translateY(-${s}px);`);
});