# Huong dan chay du an Taskly

Tai lieu nay huong dan cach cai dat va chay backend, frontend cua du an Taskly tren may Windows.

## 1. Yeu cau moi truong

Can cai dat:

- Java JDK 25
- Node.js va npm
- MySQL neu backend su dung co so du lieu
- Git (neu clone du an tu repository)

Kiem tra phien ban:

```powershell
java -version
node --version
npm --version
```

## 2. Chay backend

Mo terminal tai thu muc goc cua du an va di chuyen vao thu muc backend:

```powershell
cd backend
```

Chay ung dung Spring Boot bang Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Backend mac dinh chay tai:

```text
http://localhost:8080
```

### Lenh backend thuong dung

Chay test:

```powershell
.\mvnw.cmd test
```

Build file JAR:

```powershell
.\mvnw.cmd clean package
```

Chay file JAR sau khi build:

```powershell
java -jar target\backend-0.0.1-SNAPSHOT.jar
```

De dung backend, nhan `Ctrl + C` trong terminal dang chay backend.

## 3. Chay frontend

Mo mot terminal moi, giu backend dang chay, sau do di chuyen vao thu muc frontend:

```powershell
cd frontend
```

Cai dat cac package lan dau tien:

```powershell
npm install
```

Chay frontend o che do phat trien:

```powershell
npm run dev
```

Vite se hien thi dia chi truy cap trong terminal, thong thuong la:

```text
http://localhost:5173
```

Mo dia chi nay tren trinh duyet de su dung ung dung.

### Lenh frontend thuong dung

Kiem tra lint:

```powershell
npm run lint
```

Build frontend cho moi truong production:

```powershell
npm run build
```

Chay thu ban build:

```powershell
npm run preview
```

De dung frontend, nhan `Ctrl + C` trong terminal dang chay Vite.

## 4. Quy trinh chay day du

Can mo hai terminal rieng:

### Terminal 1: Backend

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

### Terminal 2: Frontend

```powershell
cd frontend
npm install
npm run dev
```

Sau do truy cap frontend tai `http://localhost:5173`.

## 5. Xu ly loi thuong gap

### Khong tim thay lenh Java

Kiem tra bien moi truong `JAVA_HOME` va dam bao JDK 25 da duoc cai dat. Mo lai terminal sau khi thay doi bien moi truong.

### Khong chay duoc Maven Wrapper

Tren Windows, su dung:

```powershell
.\mvnw.cmd spring-boot:run
```

Khong dung `./mvnw` trong PowerShell neu lenh nay khong duoc nhan dien.

### Loi package frontend

Xoa thu muc `node_modules` va file `package-lock.json`, sau do cai dat lai:

```powershell
Remove-Item -Recurse -Force node_modules
Remove-Item package-lock.json
npm install
```

### Cong da duoc su dung

Neu cong `8080` hoac `5173` dang bi ung dung khac su dung, dung ung dung do hoac doi cong trong cau hinh tuong ung truoc khi chay lai.

### Loi ket noi MySQL

Tao database trong MySQL neu chua co:

```sql
CREATE DATABASE taskly;
```

Backend dang ket noi den MySQL tai `localhost:3306`, database `taskly`. Cau hinh nam trong:

```text
backend/src/main/resources/application.properties
```

Mac dinh backend dung user `root` va mat khau rong. Neu MySQL cua ban co mat khau, dat bien moi truong truoc khi chay backend:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "mat_khau_mysql_cua_ban"
cd backend
.\mvnw.cmd spring-boot:run
```

Hoac thay doi gia tri ket noi truc tiep trong file `application.properties`. Khong nen commit mat khau that vao Git.
