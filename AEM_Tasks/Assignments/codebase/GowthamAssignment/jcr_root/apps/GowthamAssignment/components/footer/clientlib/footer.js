document.addEventListener("DOMContentLoaded", function () {
    const footerLinks = document.querySelectorAll(".footer-links a, .footer-social a");

    footerLinks.forEach(link => {
        link.addEventListener("mouseover", () => {
            link.style.transition = "color 0.3s";
            link.style.color = "#ffcc00";
        });

        link.addEventListener("mouseleave", () => {
            link.style.color = "white";
        });
    });
});
