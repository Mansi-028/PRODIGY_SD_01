// Task 01 - Temperature Converter
// Author: Mansi (B.Tech)
// Logic: take input value + its unit, convert to other two units.

// keep track of which unit is currently selected
let selectedUnit = "C";

// grab elements once
const tempInput = document.getElementById("tempInput");
const form = document.getElementById("convertForm");
const resetBtn = document.getElementById("resetBtn");
const errorBox = document.getElementById("errorBox");
const resultBox = document.getElementById("resultBox");
const unitButtons = document.querySelectorAll(".unit-btn");

// handle unit button clicks
unitButtons.forEach(function (btn) {
  btn.addEventListener("click", function () {
    unitButtons.forEach(function (b) { b.classList.remove("active"); });
    btn.classList.add("active");
    selectedUnit = btn.getAttribute("data-unit");
  });
});

// round to 2 decimal places (simple way)
function round2(num) {
  return Math.round(num * 100) / 100;
}

function showError(msg) {
  errorBox.textContent = msg;
  errorBox.style.display = "block";
  resultBox.style.display = "none";
}

function hideError() {
  errorBox.style.display = "none";
  errorBox.textContent = "";
}

function showResults(c, f, k) {
  document.querySelector("#resC .result-value").textContent = round2(c) + " °C";
  document.querySelector("#resF .result-value").textContent = round2(f) + " °F";
  document.querySelector("#resK .result-value").textContent = round2(k) + " K";
  resultBox.style.display = "block";
}

form.addEventListener("submit", function (e) {
  e.preventDefault();
  hideError();

  const raw = tempInput.value.trim();
  if (raw === "") {
    showError("Please enter a temperature value.");
    return;
  }

  const value = parseFloat(raw);
  if (isNaN(value)) {
    showError("Please enter a valid number.");
    return;
  }

  let celsius = 0, fahrenheit = 0, kelvin = 0;

  // first convert input to celsius, then derive the others
  if (selectedUnit === "C") {
    celsius = value;
    fahrenheit = (value * 9) / 5 + 32;
    kelvin = value + 273.15;
  } else if (selectedUnit === "F") {
    celsius = ((value - 32) * 5) / 9;
    fahrenheit = value;
    kelvin = celsius + 273.15;
  } else if (selectedUnit === "K") {
    celsius = value - 273.15;
    fahrenheit = (celsius * 9) / 5 + 32;
    kelvin = value;
  }

  // sanity check - cannot be below absolute zero
  if (kelvin < 0) {
    showError("Temperature is below absolute zero, that's not possible.");
    return;
  }

  showResults(celsius, fahrenheit, kelvin);
});

resetBtn.addEventListener("click", function () {
  tempInput.value = "";
  hideError();
  resultBox.style.display = "none";
  unitButtons.forEach(function (b) { b.classList.remove("active"); });
  unitButtons[0].classList.add("active");
  selectedUnit = "C";
});
