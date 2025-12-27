# Inventory & Sales Management System (3-Layer Architecture)

This project is a desktop application developed as a portfolio piece to demonstrate proficiency in **Java Desktop Development**. It focuses on the practical application of software engineering fundamentals, such as **3-layer architecture**, **DAO patterns**, and **OOP principles**.

<img width="1920" height="1032" alt="preview" src="https://github.com/user-attachments/assets/2a48d62c-98e2-4c3d-9e8c-c5f4cb3cb589" />


## 🎯 Project Purpose
The goal of this system is to manage a basic commercial workflow (Categories -> Products -> Sales/Purchases) while maintaining a clean, decoupled codebase that goes beyond basic scripting.

## 🛠️ Tech Stack
* **Language:** Java (OpenJDK)
* **GUI:** Java Swing (MDI - Multiple Document Interface)
* **Database:** MySQL via JDBC
* **Design Patterns:** DAO (Data Access Object) & Singleton
* **IDE:** NetBeans

---

## 🏗️ Software Architecture & SOLID Principles
To ensure the code is organized and professional, I applied several engineering principles:

### Architecture Layers
* **Presentacion:** UI logic using `JInternalFrame` and event handling.
* **Negocio:** Intermediate layer for data validation and business rules.
* **Datos:** Implementation of CRUD operations using the DAO pattern.
* **Entidades:** Encapsulated classes (POJOs) representing the domain model.

### Technical Principles Applied
| Principle | Implementation in this Project |
| :--- | :--- |
| **Encapsulation** | Private attributes and public getters/setters in all `entidades` to protect data integrity. |
| **Abstraction** | Use of Interfaces in `datos.interfaces` to decouple business logic from data access. |
| **Single Responsibility (SRP)** | Specific classes for DB connection, data access, and UI logic, avoiding "God Classes". |
| **Interface Segregation** | Using specific interfaces so that classes only implement the methods they truly need. |

---

## 🚀 Key Learning Milestones
1.  **Relational Database Mapping:** Managed one-to-many relationships and SQL joins for transactions.
2.  **Logical Deletion:** Implementing "Active/Inactive" status toggles instead of hard-deleting records to maintain audit trails.
3.  **Advanced Swing UI:** Building a professional MDI (Multiple Document Interface) using `JDesktopPane`.
4.  **Decoupled Design:** Ensuring the `negocio` layer communicates with `datos` through contracts (interfaces).

---

## 💬 Technical Q&A (Interview Readiness)

**Q: Why use a 3-layer architecture instead of putting all logic in the UI?** **A:** To ensure maintenance and scalability. By separating the UI, Business Logic, and Data Access, I can modify the database schema or the interface without breaking the entire system.

**Q: What is the benefit of the DAO (Data Access Object) pattern here?** **A:** It abstracts the data persistence logic. If the project needs to switch from MySQL to another database in the future, I only need to change the implementation in the `datos` layer; the rest of the application remains untouched.

**Q: Why did you use Interfaces in the `datos.interfaces` package?** **A:** To apply "Program to an interface, not an implementation." This allows for loose coupling and makes the code easier to test and extend by defining clear contracts for what each DAO should do.

---

## ⚙️ Setup
1.  **Database:** Import the provided `.sql` script into your MySQL server.
2.  **Configuration:** Update the `database/Conexion.java` file with your local credentials.
3.  **Compile:** Open the project in NetBeans and run the main class in the `presentacion` package.

---
> **Note:** This project was developed as a final product for a Java Programming Course. It is intended for educational and portfolio demonstration purposes, highlighting the use of clean architecture and OOP.
