// Scroll-reveal: elements with class "reveal-on-scroll" start hidden/offset
// and fade + slide into place the first time they enter the viewport.
// Exposes window.ScrollReveal.observe(el) so scripts that rebuild parts of
// the page (the listings carousel, the brokers filter) can register newly
// created elements for the same effect.
(function () {
    var observer = null;

    function getObserver() {
        if (observer) {
            return observer;
        }
        if (!('IntersectionObserver' in window)) {
            return null;
        }
        observer = new IntersectionObserver(function (entries) {
            entries.forEach(function (entry) {
                // Toggle every time, in both directions, so the animation
                // replays whenever an element leaves and re-enters view —
                // scrolling back up hides it again, scrolling back down
                // triggers the reveal again.
                if (entry.isIntersecting) {
                    entry.target.classList.add('is-visible');
                } else {
                    entry.target.classList.remove('is-visible');
                }
            });
        }, { threshold: 0.15, rootMargin: '0px 0px -60px 0px' });
        return observer;
    }

    function observe(el) {
        if (!el) {
            return;
        }
        var obs = getObserver();
        if (!obs) {
            // No IntersectionObserver support: just show the element.
            el.classList.add('is-visible');
            return;
        }
        obs.observe(el);
    }

    window.ScrollReveal = { observe: observe };

    document.addEventListener('DOMContentLoaded', function () {
        document.querySelectorAll('.reveal-on-scroll').forEach(observe);
    });
})();
