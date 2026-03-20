<div align="center">

# 🌍 TourMaster – Travel & Tour Management System

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-blue?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Platform-Desktop%20App-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Database-File%20System-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/UI-Java%20Swing-lightgrey?style=for-the-badge" />
  <img src="https://img.shields.io/badge/License-MIT-brightgreen?style=for-the-badge" />
</p>

<p align="center">
  <strong>A Java-based desktop application for managing travel tours, bookings, and user interactions.</strong><br/>
  Explore destinations, book travel packages, and manage tours with an intuitive interface.
</p>

</div>

---

## 📌 Table of Contents

* [Overview](#-overview)
* [Demo](#-demo)
* [Features](#-features)
* [Architecture](#-architecture)
* [Tech Stack](#-tech-stack)
* [Project Structure](#-project-structure)
* [Getting Started](#-getting-started)
* [Usage](#-usage)
* [Future Improvements](#-future-improvements)
* [License](#-license)
* [Author](#-author)

---

## 🧠 Overview

**TourMaster** is a **Java Swing-based desktop application** designed to manage travel tours and bookings efficiently.

It provides:

* 🌍 Exploration of domestic & international destinations
* 📦 Predefined and customizable tour packages
* 👤 User registration and login system
* 🔐 Admin panel for managing tours and users
* 💳 Simulated payment and booking system

This project demonstrates **object-oriented programming, GUI development, and file-based data handling**.

---

## 🎬 Demo

> Start application → Login/Register → Browse tours → Select package → Make payment → Booking confirmation

---

## ✨ Features

* 👤 **User Authentication** – Registration & Login system
* 🧑‍💼 **Admin Panel** – Manage tours and user data
* 🌏 **Domestic Tours** – Tamil Nadu, Goa, Kerala, Shillong, Andaman
* 🌎 **International Tours** – USA, UK, Japan, Thailand, South Korea
* 📦 **Tour Packages** – Predefined and custom packages
* 💳 **Payment Simulation** – Booking confirmation system
* 🤖 **ChatBot** – Basic assistance for users
* 📁 **File-based Storage** – Stores user/admin data locally

---

## 🏗️ Architecture

```text
User Interface (Java Swing)
         │
         ▼
 Application Logic (Java Classes)
         │
         ▼
 File Storage (user_data.txt / admin_data.txt)
         │
         ▼
   Booking & Payment Flow
```

---

## 🛠️ Tech Stack

| Category         | Technology                        |
| ---------------- | --------------------------------- |
| ☕ Language       | Java                              |
| 🖥️ UI Framework | Java Swing                        |
| 🧠 Programming   | Object-Oriented Programming (OOP) |
| 💾 Data Storage  | File System (`.txt` files)        |
| ⚙️ Build         | JAR Executable                    |

---

## 📁 Project Structure

```text
TourMaster/
├── src/TravelAgency/
│   ├── Admin.java
│   ├── AdminAdd.java
│   ├── AdminLogin.java
│   ├── AdminPassword.java
│   ├── ChatBot.java
│   ├── Contribution.java
│   ├── DefPackTypes.java
│   ├── DomPlaces.java
│   ├── DomesticAndamanNicobar.java
│   ├── DomesticGoa.java
│   ├── DomesticKerala.java
│   ├── DomesticShillong.java
│   ├── DomesticTamilNadu.java
│   ├── Home.java
│   ├── IntCountries.java
│   ├── InternationalJapan.java
│   ├── InternationalSouthKorea.java
│   ├── InternationalThailand.java
│   ├── InternationalUnitedKingdom.java
│   ├── InternationalUnitedStates.java
│   ├── Login.java
│   ├── Packs.java
│   ├── PaySuccess.java
│   ├── Payment.java
│   ├── Registration.java
│   ├── SelfChoosenPacks.java
│   ├── Start.java
│   ├── UserData.java
│   └── Welcome.java
│
├── images/                # UI and destination images
├── Screenshots/           # Application screenshots
├── TourMaster.jar         # Executable file
├── TourMaster_Report.pdf  # Project report
├── requirements.txt       # Dependencies (if used)
├── user_data.txt          # User data storage
├── admin_data.txt         # Admin data storage
├── LICENSE         
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

* Java JDK 8 or higher installed

---

### Run Using JAR (Recommended)

```bash
java -jar TourMaster.jar
```

---

### Run from Source

```bash
# Navigate to source directory
cd src

# Compile files
javac TravelAgency/*.java

# Run application
java TravelAgency.Start
```

---

## 📖 Usage

1. Launch the application
2. Register as a new user or login
3. Browse domestic or international tours
4. Select or customize a package
5. Proceed to payment
6. Get booking confirmation

---

## 🔮 Future Improvements

* 💳 Payment gateway integration
* 🌐 Database integration (MySQL / Firebase)
* 🔐 Secure authentication system
* 📱 Web or mobile version
* ⭐ Reviews and ratings

---

## 📄 License

This project is licensed under the [LICENSE](./LICENSE).

---

## 👤 Author : [YeshwanthrajG](https://github.com/YeshwanthrajG)
