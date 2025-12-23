#!/bin/bash

# Java Selenium TDD TestNG Execution Script
# This script runs the OrangeHRM test suite using Maven and TestNG

echo "========================================"
echo "Java Selenium TDD TestNG Framework"
echo "Test Execution Script"
echo "========================================"
echo ""

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "ERROR: Maven is not installed. Please install Maven to run the tests."
    exit 1
fi

echo "[INFO] Maven version:"
mvn --version
echo ""

# Clean and compile the project
echo "[INFO] Cleaning and compiling the project..."
mvn clean compile

if [ $? -ne 0 ]; then
    echo "[ERROR] Compilation failed. Please check the errors above."
    exit 1
fi

echo ""
echo "[INFO] Compilation successful!"
echo ""

# Run the test suite using testng.xml
echo "[INFO] Running OrangeHRM Test Suite..."
mvn test -Dsurefire.suiteXmlFiles=testng.xml

if [ $? -ne 0 ]; then
    echo "[ERROR] Tests failed. Please check the test reports."
    exit 1
fi

echo ""
echo "[SUCCESS] All tests executed successfully!"
echo ""
echo "Test Reports Location:"
echo "  - HTML Report: target/surefire-reports/"
echo "  - ExtentReport: test-output/"
echo ""
echo "========================================"
echo "Test Execution Completed"
echo "========================================"
