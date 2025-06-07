✈️ TripSync: Travel & Tourism Management System 🌍
TripSync is a desktop application meticulously designed to streamline travel planning and management for both individual travelers and travel agencies. Built with the robust Java Swing framework, it offers a user-friendly interface to simplify every step of your travel journey.

📋 Overview
This project aims to provide a comprehensive solution for managing various travel and tourism activities. From booking accommodations and exploring destinations to handling customer details and payments, TripSync offers a seamless and intuitive experience that bridges the gap between travelers' aspirations and efficient administrative control.

✨ Key Features
TripSync comes packed with functionalities to make travel management effortless:

🖥️ User-Friendly Interface
Intuitive Graphical Interface: Crafted with Java Swing and AWT components for a smooth, accessible user experience.
Navigation: Simple "Back" buttons ensure effortless movement between screens.
Splash Screen & Loading: Enhances user experience with dynamic splash screens and loading animations.
👥 User & Customer Management
Secure Authentication: 🔑 Implement secure login and signup functionalities with password recovery options for both travelers and administrators.
Customer Details: Add, update, or delete customer information with ease.
📍 Travel Services
Destination Exploration: Explore and view various travel destinations.
Hotel & Package Booking: 🏨 Facilitates hotel booking and management, along with the creation and viewing of diverse travel packages.
Basic Map Integration: Displays a map (default location: Pune, India) using JEditorPane to visualize travel destinations or other relevant locations. Includes basic map image display.
Booked Views: 📂 View all your booked hotels and travel tickets in one organized place.
💳 Payment Integration
Payment Gateway Simulation: Includes a simulated payment gateway using Paytm for smooth transaction processing.
🤖 Planned: AI-Powered Chatbot
Destination Suggestions: We plan to integrate a chatbot that can interact with users to understand their preferences and suggest ideal travel destinations, making trip planning even more personalized!

🛠️ Technologies Used
TripSync is built on a robust set of Java technologies:

Frontend: Java Swing, AWT
Backend: JDBC for database connectivity
Programming Language: Java
Database: MySQL Workbench 8.0
Development Environment: NetBeans IDE (for project development) & Eclipse (as referenced for backend setup).

⚙️ Code Structure
The core logic of TripSync is primarily managed through the following key elements:
Map.java: The main class, extending JFrame and implementing ActionListener. It provides the primary window for the application and handles initial interactions.
JFrame: The main application window.
JButton: "Back" button for screen navigation.
JLabel: Displays map images.
JEditorPane: Used for rendering map content.
ActionListener: Manages button click events.
