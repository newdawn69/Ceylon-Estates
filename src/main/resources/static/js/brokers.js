// Local mortgage brokers section: province filter dropdown + arrow-scrolled row.
document.addEventListener('DOMContentLoaded', function () {
    const row = document.getElementById('brokerRow');
    const viewport = document.getElementById('brokerViewport');
    const scrollBtn = document.getElementById('brokerScrollBtn');
    const label = document.getElementById('brokerDistrictLabel');
    const options = document.querySelectorAll('.broker-district-option');

    if (!row) {
        return;
    }

    const allCards = Array.from(row.children);

    function applyFilter(province) {
        allCards.forEach(function (card) {
            const matches = province === 'all' || card.dataset.province === province;
            card.style.display = matches ? '' : 'none';
        });
        // Jump back to the start of the row whenever the filter changes.
        viewport.scrollTo({ left: 0, behavior: 'instant' in viewport ? 'instant' : 'auto' });
    }

    options.forEach(function (option) {
        option.addEventListener('click', function (event) {
            event.preventDefault();

            options.forEach(function (o) {
                o.classList.remove('active');
            });
            option.classList.add('active');

            if (label) {
                label.textContent = option.textContent.trim();
            }

            applyFilter(option.dataset.province);
        });
    });

    if (scrollBtn && viewport) {
        scrollBtn.addEventListener('click', function () {
            viewport.scrollBy({ left: 220, behavior: 'smooth' });
        });
    }
});
