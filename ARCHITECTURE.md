# Kien truc Taskly

## Tong quan

Taskly la ung dung web gom frontend React va backend Spring Boot. Backend giao tiep voi MySQL thong qua Spring Data JPA.

```text
Trinh duyet
    |
    v
React + TypeScript + Vite (frontend)
    |
    | HTTP/JSON
    v
Spring Boot REST API (backend)
    |
    v
Spring Data JPA / Hibernate
    |
    v
MySQL - database taskly
```

## Frontend

Thu muc `frontend/src` chua giao dien va logic phia client.

- `App.tsx`: component goc hien tai.
- `main.tsx`: diem khoi dong React.
- `App.css`, `index.css`: style cua ung dung.
- `assets/`: hinh anh va tai nguyen tinh.

Khi ung dung lon dan, co the bo sung:

```text
src/
|-- components/   Component dung lai
|-- pages/        Man hinh theo route
|-- services/     Goi API backend
|-- types/        TypeScript types
|-- hooks/        Custom hooks
`-- assets/       Hinh anh va tai nguyen
```

## Backend

Package goc la `com.taskly.backend`.

```text
src/main/java/com/taskly/backend/
|-- BackendApplication.java
|-- config/       Cau hinh chung, CORS va bean dung chung
|-- security/     Authentication va authorization
|-- controller/   REST endpoints
|-- dto/          Request/response objects
|-- entity/       JPA entities anh xa bang MySQL
|-- repository/   Spring Data repositories
|-- service/      Business logic
`-- exception/    Exception va xu ly loi tap trung
```

Mot request thong thuong di qua cac lop:

```text
HTTP request -> controller -> service -> repository -> MySQL
HTTP response <- controller <- service <- repository
```

## Database

Cau hinh ket noi nam trong `backend/src/main/resources/application.properties`.
Database mac dinh la `taskly` tren MySQL cong `3306`. `spring.jpa.hibernate.ddl-auto=update` dang duoc dung trong giai doan phat trien.

Khi dua len production, nen dung migration tool nhu Flyway hoac Liquibase thay cho viec de Hibernate tu dong thay doi schema.

## Nguyen tac phu thuoc

- `controller` phu thuoc `service`.
- `service` phu thuoc `repository` va `entity`.
- `repository` phu thuoc JPA va database.
- `dto` la hop dong API, tach khoi mo hinh database.
- `config` va `security` cung cap cau hinh cho toan ung dung.
