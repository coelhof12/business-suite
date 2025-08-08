# Business Suite

## 💡 The Concept

Business Suite is a demonstration Spring Boot application that exposes a modular API for common business operations.  It currently focuses on stock management but is designed so additional modules—such as employee time tracking, sales and invoice management—can be plugged in over time.  The project highlights typical patterns for building secured REST services with Swagger documentation, validation and unit tests.

### Features
* Inventory and client management
* Supplier tracking
* Preference-based alerts
* Basic authentication setup
* Example unit tests with Mockito

This public demo omits sensitive code that exists in the private version.  Planned modules include:

* Worker clock in/out tracking
* Sales and purchase processing
* Invoicing and payment flows
* Notification and email automations

### Getting Started
1. Ensure Java 17+ and Maven are installed.
2. Configure the database connection in `src/main/resources/application.properties`.
3. Build and run using `mvn spring-boot:run` or generate the wrapper with `mvn -N wrapper:wrapper`.
4. Execute the unit tests with `mvn test`.

The provided data and configurations are for demonstration only.  Review and adapt them before using the code in production.
