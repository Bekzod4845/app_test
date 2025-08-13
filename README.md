# 📚 IELTS Mock Quiz Tizimi

Bu loyiha **Spring Boot + Spring Security + Thymeleaf** yordamida ishlab chiqilgan **IELTS  onlayn test tizimi** hisoblanadi.  
Tizim **Admin** va **User** rollari asosida ishlaydi, savollarni boshqarish va vaqtli testlarni yechish imkonini beradi.

---

## 🚀 Asosiy imkoniyatlar

### 🔑 Autentifikatsiya va Avtorizatsiya
- Foydalanuvchi tizimga kirishi va chiqishi (**login / logout**)
- Rollar bo‘yicha kirish huquqi:
  - **Admin** – savollarni qo‘shish, tahrirlash, o‘chirish
  - **User** – test yechish va natijani ko‘rish

### 📋 Test funksiyalari
- A, B, C, D variantli ko‘p tanlovli savollar
- 10 daqiqa vaqt chegarasi (avtomatik topshirish)
- Javoblarni tekshirish va natijani ko‘rsatish

### 🛠 Admin imkoniyatlari
- Savollarni qo‘shish, o‘zgartirish, o‘chirish
- Savollar ro‘yxatini ko‘rish

### 🎨 UI (Foydalanuvchi interfeysi)
- **Bootstrap 5** bilan chiroyli dizayn
- Admin va User uchun alohida sahifalar

---

## 📂 Loyiha tuzilishi

```
com.company
│
├── config
│   ├── CustomSuccessHandler.java       # Login muvaffaqiyatli bo‘lganda yo‘naltirish
│   ├── DataLoader.java                  # Dastlabki ma’lumotlarni yuklash
│   ├── SecurityConfig.java              # Spring Security sozlamalari
│
├── controller
│   ├── AdminController.java             # Admin uchun CRUD amallar
│   ├── AuthController.java               # Login/Logout amallari
│   ├── QuizController.java               # Testlarni boshqarish
│
├── model
│   ├── Question.java                     # Savol modeli
│   ├── User.java                         # Foydalanuvchi modeli
│
├── repository
│   ├── QuestionRepository.java           # Savollar uchun repository
│   ├── UserRepository.java                # Foydalanuvchilar uchun repository
│
├── service
│   ├── CustomUserDetailsService.java     # Foydalanuvchi ma’lumotlarini yuklash
│   ├── QuestionService.java               # Savollar ustida ishlash logikasi
│
└── AppTestApplication.java               # Asosiy Spring Boot dastur fayli
```

---

## 📁 Resurslar

```
resources
│
├── templates
│   ├── admin
│   │   ├── question_form.html           # Savol qo‘shish/tahrirlash
│   │   ├── questions.html               # Savollar ro‘yxati
│   │
│   ├── quiz
│   │   ├── quiz.html                    # Test sahifasi (taymer bilan)
│   │   ├── result.html                  # Natija sahifasi
│   │
│   ├── login.html                       # Login sahifasi
│
└── application.properties               # Dastur sozlamalari
```

---

## ⚙️ O‘rnatish va Sozlash

### 1️⃣ Loyihani yuklash
```bash
git clone https://github.com/username/app_test.git
cd app_test
```

### 2️⃣ Ma’lumotlar bazasini sozlash (PostgreSQL)
`src/main/resources/application.properties` faylini tahrirlang:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db
spring.datasource.username=postgres
spring.datasource.password=parolingiz
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Dasturni ishga tushirish
```bash
mvn spring-boot:run
```
Dastur `http://localhost:8080` manzilida ishga tushadi.

---

## 🔑 Dastlabki foydalanuvchilar

| Login | Parol    | Rol   |
|-------|----------|-------|
| admin | admin123 | ADMIN |
| user  | user123  | USER  |

*(Bu foydalanuvchilar `DataLoader.java` orqali avtomatik yaratiladi)*

---

## 🖥 Foydalanish

### 👨‍💼 Admin
- Kirish → `/admin/questions`
- Savol qo‘shish / tahrirlash / o‘chirish

### 👤 User
- Kirish → `/quiz`
- 10 daqiqa ichida test yechish
- Natijani darhol ko‘rish

---

## 🛡 Xavfsizlik
- Login sahifa: `/login`
- Logout: `/logout`
- Kirish nazorati:
  - `/admin/**` → faqat **Admin**
  - `/quiz/**` → **User** va **Admin**
