# Taskly

Taskly là nền tảng quản lý dự án và cộng tác nhóm dành cho doanh nghiệp. Hệ thống giúp Leader tổ chức công việc, giao nhiệm vụ và theo dõi tiến độ của các thành viên trong dự án.

## Chức năng chính

- Đăng ký, đăng nhập và xác thực người dùng.
- Phân quyền theo vai trò và quyền thao tác.
- Quản lý thành viên trong dự án.
- Tạo, cập nhật và theo dõi dự án.
- Tạo và giao task, đặt deadline, mức độ ưu tiên và trạng thái.
- Dashboard theo dõi tình trạng và tiến độ dự án.
- Thông báo khi được giao task, thay đổi trạng thái, deadline và các hoạt động quan trọng.
- Chat nhóm realtime trong dự án.
- Tạo và tham gia video meeting, hỗ trợ camera, microphone và chia sẻ màn hình.
- Bình luận trực tiếp trong từng task.
- Kiểm soát quyền truy cập và thao tác theo vai trò người dùng.

## Công nghệ sử dụng

### Backend

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA và Hibernate
- Spring Security
- Spring Validation
- MySQL
- Maven Wrapper

### Frontend

- React 19
- TypeScript
- Vite
- ESLint

## Cấu trúc dự án

```text
Taskly/
|-- backend/
|   |-- src/main/java/com/taskly/backend/
|   |   |-- config/       Cau hinh chung
|   |   |-- security/     Xac thuc va phan quyen
|   |   |-- controller/   REST API endpoints
|   |   |-- dto/          Request/response objects
|   |   |-- entity/       Mo hinh JPA
|   |   |-- repository/   Truy cap du lieu
|   |   |-- service/      Xu ly nghiep vu
|   |   `-- exception/    Xu ly loi tap trung
|   |-- src/main/resources/application.properties
|   `-- pom.xml
|-- frontend/
|   |-- src/
|   |-- public/
|   |-- package.json
|   `-- vite.config.ts
|-- AGENTS.md
|-- ARCHITECTURE.md
|-- PROJECT_PLAN.md
`-- .gitignore
```

Chi tiết kiến trúc được mô tả trong [ARCHITECTURE.md](ARCHITECTURE.md). Kế hoạch phát triển được theo dõi trong [PROJECT_PLAN.md](PROJECT_PLAN.md).

## Yêu cầu môi trường

Cài đặt các phần mềm sau trước khi chạy:

- JDK 25
- Node.js và npm
- MySQL
- Git

Kiểm tra phiên bản:

```powershell
java -version
node --version
npm --version
```

## Cấu hình MySQL

Tạo database `taskly` trong MySQL:

```sql
CREATE DATABASE taskly;
```

Backend mặc định kết nối đến `localhost:3306/taskly` với user `root`. Cấu hình nằm trong `backend/src/main/resources/application.properties`.

Nếu MySQL có mật khẩu, đặt biến môi trường trong PowerShell trước khi chạy backend:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "mat_khau_mysql_cua_ban"
```

Không commit mật khẩu thật hoặc file `.env` vào repository.

## Chạy backend

Mở terminal tại thư mục gốc:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Backend chạy tại:

```text
http://localhost:8080
```

Các lệnh thường dùng:

```powershell
.\mvnw.cmd test
.\mvnw.cmd clean package
java -jar target\backend-0.0.1-SNAPSHOT.jar
```

## Chạy frontend

Mở terminal thứ hai tại thư mục gốc:

```powershell
cd frontend
npm install
npm run dev
```

Frontend thường chạy tại:

```text
http://localhost:5173
```

Các lệnh thường dùng:

```powershell
npm run lint
npm run build
npm run preview
```

## Chạy toàn bộ hệ thống

Cần giữ hai terminal đang hoạt động.

Terminal 1:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Terminal 2:

```powershell
cd frontend
npm install
npm run dev
```

Sau đó mở `http://localhost:5173` trên trình duyệt.

## Thành quả hiện tại

- Đã khởi tạo backend Spring Boot và frontend React + TypeScript + Vite.
- Đã kết nối backend đến MySQL database `taskly`.
- Đã tạo cấu trúc package backend theo các lớp `controller`, `service`, `repository`, `entity`, `dto`, `config`, `security` và `exception`.
- Đã tạo tài liệu kiến trúc, quy tắc làm việc và kế hoạch phát triển.
- Backend đã biên dịch và test context thành công với Maven.
- Các chức năng nghiệp vụ như đăng nhập, quản lý dự án, task, chat và video meeting đang là phạm vi phát triển tiếp theo trong [PROJECT_PLAN.md](PROJECT_PLAN.md).

## Đóng góp

1. Tạo branch cho thay đổi mới.
2. Cập nhật code và test liên quan.
3. Chạy kiểm tra backend và frontend.
4. Tạo pull request với mô tả rõ ràng về thay đổi.

## Giấy phép

Dự án hiện chưa khai báo giấy phép mã nguồn mở.
