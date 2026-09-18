// "Latest Listings" carousel with category filtering.
// Each listing card carries data-type="land|house|apartment". Clicking a tab
// shows only the matching cards; the row auto-rotates (4 visible at a time)
// only when there are enough matching cards to make that worthwhile.
document.addEventListener('DOMContentLoaded', function () {
    const track = document.getElementById('listingTrack');
    const tabs = document.querySelectorAll('.listing-tab');
    if (!track) {
        return;
    }

    const visibleCount = 4;

    // Keep the full set of listings in memory, detached from the track, so we
    // can freely rebuild the track's contents for whichever category is active.
    const allCards = Array.from(track.children);
    track.innerHTML = '';

    let rotateTimer = null;

    function stopRotating() {
        if (rotateTimer !== null) {
            window.clearInterval(rotateTimer);
            rotateTimer = null;
        }
    }

    function render(filterType) {
        stopRotating();
        track.style.transition = 'none';
        track.style.transform = 'translateX(0%)';
        track.innerHTML = '';

        const matches = allCards.filter(function (card) {
            return card.dataset.type === filterType;
        });

        matches.forEach(function (card) {
            track.appendChild(card.cloneNode(true));
        });

        // Only loop/auto-rotate when there are more matching listings than
        // visible slots — otherwise everything already fits, so just show it.
        if (matches.length <= visibleCount) {
            return;
        }

        matches.slice(0, visibleCount - 1).forEach(function (card) {
            track.appendChild(card.cloneNode(true));
        });

        const totalOriginal = matches.length;
        let index = 0;

        function goToIndex(newIndex, animate) {
            track.style.transition = animate ? 'transform 0.6s ease' : 'none';
            track.style.transform = 'translateX(-' + (newIndex * (100 / visibleCount)) + '%)';
        }

        function advance() {
            index += 1;
            goToIndex(index, true);

            if (index >= totalOriginal) {
                window.setTimeout(function () {
                    index = 0;
                    goToIndex(index, false);
                }, 620);
            }
        }

        rotateTimer = window.setInterval(advance, 4000);
    }

    tabs.forEach(function (tab) {
        tab.addEventListener('click', function () {
            tabs.forEach(function (t) {
                t.classList.remove('active');
            });
            tab.classList.add('active');
            render(tab.dataset.filter);
        });
    });

    // Start on whichever tab is marked active in the HTML (Lands, by default).
    const initialTab = document.querySelector('.listing-tab.active') || tabs[0];
    if (initialTab) {
        render(initialTab.dataset.filter);
    }
});
