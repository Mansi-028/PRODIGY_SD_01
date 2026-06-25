# Prodigy InfoTech - Task 01 - Temperature Converter

This repository contains my submission for **Task 01** of the
Prodigy InfoTech **Software Development Internship**.

**Author:** Mansi (B.Tech)

## About the task

> Build a program that converts a given temperature from one unit
> (Celsius, Fahrenheit, or Kelvin) into the other two units.

I built this in two ways so it can be reviewed easily:

| Version | Folder | How to run |
| ------- | ------ | ---------- |
| Web (HTML/CSS/JS) | [`temperature-converter-web/`](./temperature-converter-web) | Open `index.html` in a browser |
| Java Desktop (Swing) | [`temperature-converter-java/`](./temperature-converter-java) | `javac` then `java TemperatureConverter` |

Both versions use the same conversion logic and validation rules.

## Features

- Convert between Celsius, Fahrenheit and Kelvin
- Input validation (empty value, non-numeric input)
- Absolute zero check (temperatures below 0 K are rejected)
- Reset button to clear input and results
- Simple and clean user interface

## Formulas

- Celsius to Fahrenheit: `F = (C * 9/5) + 32`
- Celsius to Kelvin:     `K = C + 273.15`
- Fahrenheit to Celsius: `C = (F - 32) * 5/9`
- Kelvin to Celsius:     `C = K - 273.15`

## Folder structure

```
.
├── README.md
├── .gitignore
├── temperature-converter-web/
│   ├── index.html
│   ├── style.css
│   ├── script.js
│   └── README.md
└── temperature-converter-java/
    ├── TemperatureConverter.java
    └── README.md
```

## Internship

Prodigy InfoTech - Software Development Internship - Task 01
