# Temperature Converter - Java (Swing)

Task 01 of Prodigy InfoTech Software Development Internship.
This is the Java desktop version using Swing.

**Author:** Mansi (B.Tech)

## How to run

You need JDK 8 or higher installed.

```bash
javac TemperatureConverter.java
java TemperatureConverter
```

A small window will open where you can:
1. Enter a temperature value
2. Pick the unit (Celsius / Fahrenheit / Kelvin)
3. Click **Convert** to see results in the other two units
4. Click **Reset** to clear everything

## Formulas used

- C to F: `F = (C * 9/5) + 32`
- C to K: `K = C + 273.15`
- F to C: `C = (F - 32) * 5/9`
- K to C: `C = K - 273.15`

The program also checks that the result is not below absolute zero (0 K).
