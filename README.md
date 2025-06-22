
# 📘 Selenium + TestNG + RestAssured Framework

This project is a test automation framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **RestAssured**. It demonstrates a hybrid testing approach that includes **UI testing** of a web application and **API testing** of backend services.

---

## 📁 Project Structure

```
Assignment4/
│
├── pom.xml                         # Maven project config
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── api/               # API client logic (SearchClient.java)
│   │   │   ├── base/              # Base page classes
│   │   │   ├── config/            # ConfigReader for environment properties
│   │   │   ├── pages/             # Page Object Model classes
│   │   │   └── utils/             # Reporting and utility functions
│   └── test/
│       ├── java/
│       │   ├── base/              # BaseTest with WebDriver setup
│       │   ├── data/              # Test constants and test data
│       │   ├── tests/             # Test classes
│       │   └── util/              # Test helper utilities
│       └── resources/
│           └── testng.xml        # TestNG suite configuration
```

---

## 🚀 Features

- 🧪 **TestNG-based test execution**
- 🧩 **Page Object Model** implementation for UI tests
- 🔗 **API Testing** using RestAssured (SearchClient)
- 📊 **Extent Reports** integration for test reporting
- 🔁 Supports both **UI and API regression testing**
- 🧷 Soft assertions via TestNG `SoftAssert`

---

## 🔧 Prerequisites

- Java 11 or above
- Maven 3.6+
- Chrome or Firefox browser
- Internet connection (for Maven dependencies)

---

## 🛠️ How to Run

### Run Tests via Maven

```bash
mvn clean test
```

Or using a specific profile (if configured):

```bash
mvn clean test -P <profile-name>
```

### Run Specific TestNG Suite

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

---

## 📄 Sample Test

Example UI + API validation in `Assignment4Test.java`:
- Perform a product search via UI
- Capture the product list
- Verify the same list via Search API

---

## 📊 Reports

After execution, Extent reports are generated under:

```
/test-output/ExtentReports/
```

Open `index.html` for the interactive test report.

---

## 🧹 Clean and Build

```bash
mvn clean install
```

---

## 🧩 Future Improvements
- Integrate CI/CD with GitHub Actions or Jenkins
- Parameterize environment configs
- Add more API coverage
