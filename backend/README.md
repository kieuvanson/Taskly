# Cau truc backend

Backend su dung Spring Boot voi package goc `com.taskly.backend`.

```text
src/main/java/com/taskly/backend/
|-- BackendApplication.java
|-- config/       Cau hinh chung, CORS, bean dung trong toan ung dung
|-- security/     Cau hinh Spring Security, authentication va authorization
|-- controller/   REST API endpoints, tiep nhan request va tra response
|-- dto/          Request/response objects dung cho API
|-- entity/       JPA entities anh xa cac bang trong database
|-- repository/   Spring Data repositories, truy van database
|-- service/      Business logic, dieu phoi cac repository
`-- exception/    Exception rieng va xu ly loi tap trung
```

## Quy tac phat trien

- `controller` khong chua business logic; chi validate request va goi `service`.
- `service` xu ly nghiep vu va giao tiep voi `repository`.
- `repository` chi phu trach truy cap du lieu.
- Khong tra truc tiep `entity` ra API; dung `dto` cho request va response.
- Cac class dung chung cho toan bo ung dung dat trong `config`.
- Loi API nen duoc xu ly tap trung trong `exception`.

## Vi du luong xu ly

```text
Request -> controller -> service -> repository -> MySQL
Response <- controller <- service <- repository
```

Test dat trong package tuong ung duoi `src/test/java/com/taskly/backend/`.
Vi du: test cho `UserService` dat trong package `service` va test cho endpoint dat trong package `controller`.
