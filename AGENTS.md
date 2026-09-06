# Huong dan lam viec voi Taskly

## Pham vi du an

Taskly gom hai ung dung:

- `backend/`: Spring Boot, Java 25, Spring Data JPA, Spring Security va MySQL.
- `frontend/`: React 19, TypeScript va Vite.

## Quy tac thay doi code

- Doc `ARCHITECTURE.md` truoc khi them module moi.
- Giu thay doi nho, tap trung vao mot tinh nang hoac mot loi.
- Khong commit mat khau, token, file `.env` hoac thong tin ket noi ca nhan.
- Dung DTO cho request/response; khong tra truc tiep JPA entity ra API.
- Controller chi dieu phoi request; business logic dat trong service.
- Repository chi phu trach truy cap du lieu.
- Dat test gan voi package va tinh nang dang thay doi.
- Cap nhat `PROJECT_PLAN.md` khi hoan thanh hoac thay doi pham vi tinh nang.

## Lenh kiem tra

Backend:

```powershell
cd backend
.\mvnw.cmd test
```

Frontend:

```powershell
cd frontend
npm run lint
npm run build
```

## Quy trinh lam viec

1. Xac dinh tinh nang va cap nhat ke hoach neu can.
2. Tao hoac sua code trong dung module.
3. Viet test cho hanh vi moi.
4. Chay cac lenh kiem tra lien quan.
5. Kiem tra diff truoc khi commit.
