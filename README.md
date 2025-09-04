# QuestApp Backend API

This is the **backend service of QuestApp**, a full-stack application, developed using **Java Spring Boot**. The project implements RESTful APIs for user, post, comment, and like management, with a focus on **CRUD operations**, **JWT authentication**, and a **layered architecture**.

> 🎓 I developed this project by following a YouTube Spring Boot tutorial, but added custom features and refinements to create a **realistic full-stack application**.  
> 🛠️ My goal was not only to learn backend development but also to integrate it with a React frontend to have a fully functional application.

---

## 🎯 Project Purpose

The main objectives of this project are:  

- Practice backend development using **Spring Boot**  
- Implement **RESTful APIs** with proper authentication and authorization  
- Learn and apply **clean architecture principles** with a layered project structure  
- Integrate the backend with a **React frontend** to build a complete full-stack project  
- Implement **JWT-based authentication**, including access tokens, refresh tokens, and token renewal  

This backend is designed to be modular, professional, and maintainable, suitable for **learning and portfolio purposes**.

---

## ⚙️ Technologies & Tools

- **Java 17**  
- **Spring Boot**  
- **Spring Web**  
- **Spring Data JPA / Hibernate**  
- **MySQL**  
- **JWT Authentication** (Access & Refresh Tokens)  
- **Maven**  
- **Postman** (API testing)  
- **Swagger (OpenAPI)**  

---

## 📦 Project Structure

The project follows a **layered architecture** with well-organized packages:

- **business** → Contains service classes implementing business logic  
- **dataAccess** → Repository interfaces for data persistence  
- **entities** → JPA entities representing database tables  
- **webapi / controllers** → REST controllers for handling requests  
- **requests & responses** → DTOs for secure and clean data transfer  
- **security** → JWT security configuration and authentication logic  
- **utilities & exceptions** → Helper classes and custom exceptions  

---

## 📌 Features

- **User Management**: Full CRUD operations for users  
- **Post Management**: CRUD operations for posts, including user-post relationships  
- **Comment & Like Management**: Full CRUD with proper entity relationships  
- **JWT Authentication**: Secure login and registration endpoints  
- **Refresh Token Mechanism**: /refresh endpoint for token renewal  
- **DTO Mapping**: PostResponse, CommentResponse, LikeResponse, UserResponse  
- **User Activity Endpoint**: /user-activity returns recent posts, comments, and likes  
- **Avatar Management**: Separate endpoint to update user avatars  
- **Exception Handling**: Custom exceptions like UserNotFoundException  
- **Timestamp Management**: Automatic createdDate for posts and comments  
- **CORS Configurations**: Proper CORS settings to prevent frontend conflicts  

---

## 🗄️ Database

The backend uses **MySQL** as the database. The tables and relationships are organized as follows:

### Database Schema (ER Diagram)
![Database Schema](https://github.com/serdararici/quest-app/blob/main/images/quest-app-db-chart.png)

### Example Table
![Database Table](https://github.com/serdararici/quest-app/blob/main/images/questapp-example-db-table-view.JPG)

> All entities use `@GeneratedValue.IDENTITY` for automatic ID generation. The schema includes `User`, `Post`, `Comment`, `Like`, and `RefreshToken` tables.

---

## 🔌 API Examples

Here’s an example of testing endpoints with **Postman**:

![Postman Example](https://github.com/serdararici/quest-app/blob/main/images/quest-app-postman-example%C4%B1.JPG)


## 🌐 Frontend Integration

This project is part of a **full-stack application**, and the frontend is developed separately using **React**.  
You can check out the frontend repository [here](https://github.com/serdararici/quest-app-frontend) to explore the complete application.

## 🚀 Installation & Usage

**Clone the repository:**

git clone https://github.com/serdararici/questapp-backend.git
cd questapp-backend


**Configure MySQL database:**

- Create a database called questapp

- Update application.properties with your MySQL username/password

**Build and run the project:**

- mvn spring-boot:run


**Access APIs at: http://localhost:8080**

**Test endpoints using Postman or Swagger UI**

## 🙋 Author & Contact
### Serdar Arıcı

[Github](https://github.com/serdararici) 

[LinkedIn](https://www.linkedin.com/in/serdar-ar%C4%B1c%C4%B1-9827981a3/)

This project was developed as part of my learning journey into backend development with Spring Boot, aiming to create a realistic full-stack application integrating both backend and frontend.
