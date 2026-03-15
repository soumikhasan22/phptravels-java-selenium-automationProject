# 🌍 PHPTravels Automation Testing Project

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

> A full end-to-end automation testing suite for [phptravels.net](https://phptravels.net) — built with **Java**, **Selenium WebDriver**, and **TestNG** following the **Page Object Model (POM)** design pattern.



## 📌 Table of Contents

- [About the Project](#-about-the-project)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Test Coverage](#-test-coverage)
- [Test Reports](#-test-reports)
- [Author](#-author)



## 📖 About the Project

This project automates the core user flows of the **PHPTravels** travel booking platform. It covers everything from user registration and login to searching and booking flights, hotels, cars, tours, and visa applications.

The project follows the **Page Object Model (POM)** design pattern to keep the code clean, reusable, and easy to maintain.



## 🧰 Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | JDK 8+ | Core programming language |
| Selenium WebDriver | 4.x | Browser automation |
| TestNG | 7.x | Test framework & assertions |
| Maven | 3.x | Build tool & dependency management |
| ChromeDriver | Latest | Chrome browser driver |
| IntelliJ IDEA | Latest | IDE |



## 📁 Project Structure

```
Automation_Project/
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseClass.java              # WebDriver setup, teardown & utilities
│   │   │
│   │   └── Pages/
│   │       ├── HomePage.java               # Home page interactions
│   │       ├── LoginPage.java              # Login page actions
│   │       ├── CustomerSignup_Page.java    # Customer registration flow
│   │       ├── AgentSignUp_Page.java       # Agent registration flow
│   │       ├── emailVerificationPage.java  # Email verification handling
│   │       ├── FlightPage.java             # Flight search & booking
│   │       ├── StayPage.java               # Hotel/Stay search & booking
│   │       ├── CarPage.java                # Car rental search & booking
│   │       ├── TourPage.java               # Tour search & booking
│   │       └── VisaPage.java               # Visa application flow
│   │
│   └── test/java/
│       └── TestCases/
│           └── TestCases.java              # All test cases
│
├── pom.xml                                 # Maven dependencies & plugins
└── testng.xml                              # TestNG suite configuration
```

---

## ✅ Test Coverage

| Module | Test Scenario | Status |
|--------|--------------|--------|
| 🔐 Auth | User Login | ✅ Covered |
| 👤 Registration | Customer Sign Up | ✅ Covered |
| 🧑‍💼 Registration | Agent Sign Up | ✅ Covered |
| ✉️ Verification | Email Verification | ✅ Covered |
| ✈️ Flights | Search & Book a Flight | ✅ Covered |
| 🏨 Stays | Search & Book a Hotel | ✅ Covered |
| 🚗 Cars | Search & Rent a Car | ✅ Covered |
| 🗺️ Tours | Search & Book a Tour | ✅ Covered |
| 🛂 Visa | Visa Application Flow | ✅ Covered |



## 📊 Test Reports

After running the tests, TestNG automatically generates reports inside the `test-output/` folder.

| Report File | Location |
|-------------|----------|
| Emailable Report | `test-output/emailable-report.html` |
| Full Suite Report | `test-output/old/index.html` |
| TestNG Results (XML) | `test-output/testng-results.xml` |

> Open any `.html` file in your browser to view a detailed pass/fail summary.



## 👤 Author

**Soumik Hasan**

[![GitHub](https://img.shields.io/badge/GitHub-soumikhasan22-181717?style=for-the-badge&logo=github)](https://github.com/soumikhasan22)



<p align="center">Made with using Java + Selenium + TestNG</p>
