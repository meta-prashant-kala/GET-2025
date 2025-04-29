function resize() {
    if (window.innerWidth > 992) {
        const elem = document.getElementById("offcanvasScrolling");
        elem.classList.remove("offcanvas");
        elem.classList.remove("offcanvas-start");
    }
}
window.addEventListener('load', resize);
window.addEventListener('resize', resize);