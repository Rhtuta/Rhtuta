/* ═══════════════════════════════════════════════════════════
   Nimbus Weather — script.js
   Fully self-contained, zero external deps except Chart.js
═══════════════════════════════════════════════════════════ */
'use strict';

/* ── Config ─────────────────────────────────────────────── */
const API = 'http://localhost:8080/weather/forcast';

/* ── Icon map (uses your svg/ folder) ───────────────────── */
const ICON = {
  clear   : 'svg/clear.svg',
  sunny   : 'svg/clear.svg',
  cloud   : 'svg/cloudy.svg',
  overcast: 'svg/cloudy.svg',
  partly  : 'svg/cloudy.svg',
  rain    : 'svg/rainy.svg',
  drizzle : 'svg/rainy.svg',
  shower  : 'svg/rainy.svg',
  storm   : 'svg/stormy.svg',
  thunder : 'svg/stormy.svg',
  mist    : 'svg/mist.svg',
  fog     : 'svg/mist.svg',
  haze    : 'svg/mist.svg',
};

function iconFor(cond = '') {
  const lc  = cond.toLowerCase();
  const key = Object.keys(ICON).find(k => lc.includes(k));
  return key ? ICON[key] : 'svg/clear.svg';
}

/* ── Date helpers ───────────────────────────────────────── */
const DAYS  = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
const MONS  = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];

function toLocalDate(str) {
  const [y,m,d] = str.split('-').map(Number);
  return new Date(y, m-1, d);
}
function dayLabel(str)  { return DAYS[toLocalDate(str).getDay()]; }
function dateLabel(str) {
  const dt = toLocalDate(str);
  return `${dt.getDate()} ${MONS[dt.getMonth()]}`;
}
function isToday(str) {
  const n = new Date(), dt = toLocalDate(str);
  return n.getFullYear()===dt.getFullYear() && n.getMonth()===dt.getMonth() && n.getDate()===dt.getDate();
}

/* ── Clock ──────────────────────────────────────────────── */
function tickClock() {
  const n  = new Date();
  const h  = n.getHours(), m = n.getMinutes();
  const ap = h >= 12 ? 'PM' : 'AM';
  const h12 = h % 12 || 12;
  const mm  = String(m).padStart(2,'0');
  const day = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'][n.getDay()];
  document.getElementById('header-clock').textContent = `${day}, ${h12}:${mm} ${ap}`;
}
tickClock();
setInterval(tickClock, 30_000);

/* ── DOM ────────────────────────────────────────────────── */
const $city    = document.getElementById('city');
const $btn     = document.getElementById('btn');
const $loader  = document.getElementById('loader');
const $results = document.getElementById('results');
const $error   = document.getElementById('error');
const $forecast= document.getElementById('forecast');

/* ── Days selection ─────────────────────────────────────── */
let selectedDays = 1;   // tracks the active toggle value

document.getElementById('days-group').addEventListener('click', e => {
  const btn = e.target.closest('.dg-btn');
  if (!btn) return;
  document.querySelectorAll('.dg-btn').forEach(b => b.classList.remove('active'));
  btn.classList.add('active');
  selectedDays = parseInt(btn.dataset.days, 10);  // ← always updated immediately
});

/* ── Search triggers ────────────────────────────────────── */
$btn.addEventListener('click', doSearch);
$city.addEventListener('keydown', e => { if (e.key === 'Enter') doSearch(); });

/* ── Chart instance ─────────────────────────────────────── */
let chartInst = null;

/* ═══════════════════════════════════════════════════════════
   MAIN SEARCH
═══════════════════════════════════════════════════════════ */
async function doSearch() {
  const city = $city.value.trim();

  /* validate */
  if (!city) {
    $error.textContent = '⚡ Please enter a city name.';
    $city.classList.add('shake');
    setTimeout(() => $city.classList.remove('shake'), 420);
    return;
  }
  $error.textContent = '';

  /* loading state */
  setLoading(true);

  const url = `${API}?city=${encodeURIComponent(city)}&days=${selectedDays}`;

  try {
    const res = await fetch(url);
    if (!res.ok) throw new Error(`Server error ${res.status}`);
    const data = await res.json();

    if (!data?.weatherResponse || !Array.isArray(data?.dayTemp)) {
      throw new Error('Unexpected API response shape');
    }

    render(data);
    show($results);
    $results.scrollIntoView({ behavior: 'smooth', block: 'start' });

  } catch (err) {
    console.error(err);
    $error.innerHTML =
      `⚠ <strong>API unreachable.</strong> Make sure <code>localhost:8080</code> is running.<br/>
       <small style="color:#64748b">${url}</small>`;
    hide($results);
  } finally {
    setLoading(false);
  }
}

/* ═══════════════════════════════════════════════════════════
   RENDER
═══════════════════════════════════════════════════════════ */
function render(data) {
  const w  = data.weatherResponse;
  const ds = data.dayTemp;

  renderHero(w);
  renderStats(w);
  renderChart(ds);
  renderForecast(ds, w.condition);
}

/* ── Hero ───────────────────────────────────────────────── */
function renderHero(w) {
  set('hc-location', `${w.city}, ${w.region} · ${w.country}`);
  set('hc-temp',     Math.round(w.temperature));
  set('hc-condition',w.condition);
  set('hc-sub',      `Feels like the skies are ${w.condition.toLowerCase()}`);

  const icon = document.getElementById('hc-icon');
  icon.src = iconFor(w.condition);
  icon.alt = w.condition;
  icon.style.animation = 'none';
  requestAnimationFrame(() => { icon.style.animation = ''; });
}

/* ── Stat pills ─────────────────────────────────────────── */
function renderStats(w) {
  const pills = [
    { label:'City',    value: w.city,    accent:'#a78bfa' },
    { label:'Region',  value: w.region,  accent:'#38bdf8' },
    { label:'Country', value: w.country, accent:'#34d399' },
  ];

  document.getElementById('stat-row').innerHTML = pills.map(p => `
    <div class="stat-pill">
      <div class="sp-label">${p.label}</div>
      <div class="sp-value">${p.value}</div>
      <span class="sp-accent" style="background:${p.accent}"></span>
    </div>
  `).join('');
}

/* ── Chart ──────────────────────────────────────────────── */
function renderChart(ds) {
  const labels  = ds.map(d => `${dayLabel(d.date)} ${dateLabel(d.date)}`);
  const maxData = ds.map(d => +d.maxTemp.toFixed(1));
  const avgData = ds.map(d => +d.avgTemp.toFixed(1));
  const minData = ds.map(d => +d.minTemp.toFixed(1));

  const ctx = document.getElementById('chart');

  if (chartInst) { chartInst.destroy(); chartInst = null; }

  chartInst = new Chart(ctx, {
    type: 'line',
    data: {
      labels,
      datasets: [
        {
          label: 'Max °C',
          data: maxData,
          borderColor: '#fb7185',
          backgroundColor: 'rgba(251,113,133,.12)',
          borderWidth: 2.5,
          tension: 0.42,
          fill: true,
          pointBackgroundColor: '#fb7185',
          pointBorderColor: '#0f1724',
          pointBorderWidth: 2,
          pointRadius: 5,
          pointHoverRadius: 7,
        },
        {
          label: 'Avg °C',
          data: avgData,
          borderColor: '#a78bfa',
          backgroundColor: 'rgba(167,139,250,.10)',
          borderWidth: 2.5,
          tension: 0.42,
          fill: true,
          pointBackgroundColor: '#a78bfa',
          pointBorderColor: '#0f1724',
          pointBorderWidth: 2,
          pointRadius: 5,
          pointHoverRadius: 7,
        },
        {
          label: 'Min °C',
          data: minData,
          borderColor: '#38bdf8',
          backgroundColor: 'rgba(56,189,248,.08)',
          borderWidth: 2.5,
          tension: 0.42,
          fill: true,
          pointBackgroundColor: '#38bdf8',
          pointBorderColor: '#0f1724',
          pointBorderWidth: 2,
          pointRadius: 5,
          pointHoverRadius: 7,
        },
      ]
    },
    options: {
      responsive: true,
      animation: { duration: 900, easing: 'easeInOutQuart' },
      interaction: { mode: 'index', intersect: false },
      plugins: {
        legend: {
          labels: {
            color: '#94a3b8',
            font: { family:'Syne', size:11, weight:'700' },
            boxWidth: 12, boxHeight: 12,
            usePointStyle: true,
          }
        },
        tooltip: {
          backgroundColor: 'rgba(8,12,20,.92)',
          borderColor: 'rgba(255,255,255,.12)',
          borderWidth: 1,
          titleColor: '#f0f4ff',
          bodyColor: '#94a3b8',
          titleFont: { family:'Syne', size:12, weight:'700' },
          bodyFont:  { family:'DM Sans', size:11 },
          padding: 12,
          callbacks: {
            label: ctx => ` ${ctx.dataset.label}: ${ctx.parsed.y}°C`
          }
        }
      },
      scales: {
        x: {
          grid: { color:'rgba(255,255,255,.05)', drawBorder:false },
          ticks: { color:'#475569', font:{ family:'Syne', size:10, weight:'600' }, maxRotation:0 }
        },
        y: {
          grid: { color:'rgba(255,255,255,.05)', drawBorder:false },
          ticks: {
            color:'#475569',
            font:{ family:'DM Sans', size:10 },
            callback: v => `${v}°`
          }
        }
      }
    }
  });
}

/* ── Forecast strip ─────────────────────────────────────── */
function renderForecast(ds, currentCond) {
  /* update label */
  set('fc-label', `${ds.length}-Day Forecast`);

  /* set grid columns */
  $forecast.style.gridTemplateColumns = `repeat(${ds.length}, 1fr)`;

  /* global range for bars */
  const allMax = Math.max(...ds.map(d => d.maxTemp));
  const allMin = Math.min(...ds.map(d => d.minTemp));
  const range  = allMax - allMin || 1;

  $forecast.innerHTML = '';

  ds.forEach((d, i) => {
    const today  = isToday(d.date);
    const cond   = today ? currentCond : 'Clear';
    const barPct = ((d.maxTemp - allMin) / range * 100).toFixed(1);

    const card = document.createElement('div');
    card.className = `day-card${today ? ' today' : ''}`;
    card.style.cssText = 'opacity:0;transform:translateY(16px)';

    card.innerHTML = `
      ${today ? '<span class="today-badge">Today</span>' : ''}
      <div class="dc-day">${dayLabel(d.date)}</div>
      <div class="dc-day" style="font-size:.65rem;color:#475569;font-weight:500;margin-top:-6px">${dateLabel(d.date)}</div>
      <img class="dc-icon" src="${iconFor(cond)}" alt="${cond}" loading="lazy"/>
      <div class="dc-max">${Math.round(d.maxTemp)}°</div>
      <div class="dc-row">
        <span class="dc-avg">avg ${Math.round(d.avgTemp)}°</span>
        <span class="dc-min">↓${Math.round(d.minTemp)}°</span>
      </div>
      <div class="dc-bar-wrap">
        <div class="dc-bar" data-w="${barPct}"></div>
      </div>
    `;

    $forecast.appendChild(card);

    /* stagger entrance */
    setTimeout(() => {
      card.style.transition = 'opacity .4s ease, transform .4s ease';
      card.style.opacity    = '1';
      card.style.transform  = 'translateY(0)';

      /* animate bar */
      setTimeout(() => {
        card.querySelector('.dc-bar').style.width = barPct + '%';
      }, 200);
    }, 60 + i * 90);
  });
}

/* ═══════════════════════════════════════════════════════════
   HELPERS
═══════════════════════════════════════════════════════════ */
function setLoading(on) {
  $btn.disabled = on;
  $btn.classList.toggle('loading', on);
  if (on) { show($loader); hide($results); }
  else    { hide($loader); }
}

function show(el) { el.classList.remove('hidden'); }
function hide(el) { el.classList.add('hidden'); }
function set(id, val) { document.getElementById(id).textContent = val; }