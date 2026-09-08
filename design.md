Taskly UI Design Guide

Tài liệu này là quy chuẩn giao diện chung của Taskly. Đây là luật, không phải gợi ý — trước khi tạo hoặc chỉnh sửa bất kỳ màn hình frontend nào, phải đọc file này và tuân theo. Nếu một quyết định không được nêu ở đây, chọn phương án gần nhất với tinh thần của tài liệu và cập nhật tài liệu này ngay sau đó, không tự quyết rồi bỏ qua.

1. Định hướng sản phẩm

Taskly là ứng dụng quản lý dự án và công việc cho nhóm. Giao diện phải ưu tiên:

Tập trung vào công việc và tiến độ, không phải nội dung quảng bá.
Thao tác nhanh, ít bước, dễ quét thông tin.
Cảm giác hiện đại, yên tĩnh, chuyên nghiệp và đáng tin cậy.
Dùng tiếng Việt cho toàn bộ nội dung người dùng nhìn thấy.
Hỗ trợ tốt cho quy trình: xem việc, thêm việc, lọc, giao việc, theo dõi deadline và trạng thái.

Không biến giao diện thành landing page, không dùng card trang trí dày đặc, không dùng hiệu ứng rối mắt hoặc màu sắc quá sặc sỡ.

2. Ngôn ngữ và nội dung
Tất cả text hiển thị trong UI dùng tiếng Việt.
Tên biến, type, API field và giá trị kỹ thuật có thể dùng tiếng Anh để nhất quán với code.
Câu chữ ngắn, rõ, hướng về hành động.
Ưu tiên động từ cho nút: Thêm việc, Lưu, Cập nhật, Xóa, Giao việc.
Không dùng text giả kiểu Lorem ipsum trong giao diện thật.
Ngày tháng hiển thị theo cách tự nhiên của tiếng Việt, ví dụ Hôm nay, Ngày mai, 9 tháng 9, 2026.
Hành động giữ nguyên tên xuyên suốt luồng: nút Giao việc thì thông báo sau đó phải nói "Đã giao việc", không đổi thành từ khác.
Lỗi và trạng thái rỗng nói bằng giọng hệ thống, không xin lỗi, không mơ hồ — nêu rõ chuyện gì xảy ra và cách xử lý.
3. Bảng màu

Màu nền và màu chữ:

css
--ink: #202533;       /* chữ chính, sidebar */
--canvas: #fbfaf7;    /* nền trang */
--line: #e8e5df;      /* đường viền, phân cách */
--orange: #d26f4b;    /* màu hành động chính */

Màu mức ưu tiên (ánh xạ cố định, không đổi giữa các lần code):

css
--priority-high: #d47a5b;    /* Ưu tiên cao */
--priority-medium: #d3ad5b;  /* Ưu tiên trung bình */
--priority-low: #83a989;     /* Ưu tiên thấp / hoàn thành */

Màu dự án (ánh xạ cố định theo dự án hiện có; khi thêm dự án mới, chọn màu chưa dùng và ghi thêm vào bảng này):

css
--project-coral: #e98268;  /* Ứng dụng Taskly */
--project-green: #8fb989;  /* Thiết kế sản phẩm */
--project-blue:  #799bc3;  /* Nghiên cứu */

Quy tắc màu:

Màu cam chỉ dành cho hành động chính, điểm nhấn và trạng thái cần chú ý.
Nền chính là kem rất nhạt, không dùng nền trắng tinh cho toàn bộ trang.
Sidebar dùng xanh mực đậm, nội dung sidebar có độ tương phản vừa phải.
Không dùng nền tím, gradient tím hoặc palette đơn sắc.
Trạng thái phải có màu và text/icon, không chỉ dựa vào màu để truyền đạt thông tin.
Không tạo màu mới ngoài các token ở trên trừ khi thêm vào tài liệu này trước.
4. Typography

Font đang dùng:

css
--body: 'DM Sans', sans-serif;
--display: 'Space Grotesk', sans-serif;
Space Grotesk: tiêu đề, số liệu lớn, tên thương hiệu.
DM Sans: nội dung, label, nút, form và dữ liệu.

Type scale (dùng đúng các mức này, không tự chế thêm size khác):

css
--text-xs: 12px;    /* meta phụ, badge nhỏ */
--text-sm: 13px;    /* label, caption */
--text-base: 14px;  /* nội dung mặc định, task row */
--text-md: 16px;    /* input, nút */
--text-lg: 20px;    /* tiêu đề section */
--text-xl: 28px;    /* tiêu đề trang */
--text-2xl: 36px;   /* số liệu lớn, hero số liệu */
Không dùng heading quá lớn trong sidebar, bảng, modal hoặc card nhỏ.
Không dùng letter-spacing âm quá mạnh.
Không tô đậm/in nghiêng một chữ đơn lẻ trong heading để tạo điểm nhấn giả tạo.
Không dùng chữ hoa toàn bộ (all caps) cho label.
Text phải có line-height đủ thoáng, đặc biệt với tiếng Việt (khuyến nghị 1.4–1.6 cho nội dung, 1.2–1.3 cho heading).
Khi chuỗi dài, cho phép xuống dòng thay vì làm tràn hoặc chồng lấn.
5. Spacing, bo góc, độ nổi (elevation)

Spacing scale (bội số 4px, dùng nhất quán cho margin/padding/gap):

css
--space-1: 4px;
--space-2: 8px;
--space-3: 12px;
--space-4: 16px;
--space-5: 24px;
--space-6: 32px;
--space-7: 40px;
--space-8: 56px;
Khoảng cách trong một component (padding nút, khoảng giữa icon và text): --space-2 đến --space-3.
Khoảng cách giữa các phần tử trong một nhóm (task row, item trong list): --space-3 đến --space-4.
Khoảng cách giữa các nhóm chính trong trang: --space-7 đến --space-8.

Border-radius:

css
--radius-sm: 6px;   /* input, badge nhỏ, checkbox */
--radius-md: 7px;   /* nút, card */
--radius-lg: 12px;  /* modal, panel lớn */
--radius-full: 999px; /* avatar, badge tròn, pill trạng thái */

Không dùng nút dạng pill quá tròn trừ khi đó là avatar, badge hoặc trạng thái.

Shadow (dùng đúng 3 mức, không tự chế box-shadow khác):

css
--shadow-sm: 0 1px 2px rgba(32, 37, 51, 0.06);   /* card, row hover nhẹ */
--shadow-md: 0 4px 12px rgba(32, 37, 51, 0.10);  /* dropdown, popover */
--shadow-lg: 0 12px 32px rgba(32, 37, 51, 0.16); /* modal, dialog */

Z-index scale:

css
--z-dropdown: 100;
--z-sticky-header: 200;
--z-modal-overlay: 300;
--z-modal: 310;
--z-toast: 400;
--z-tooltip: 500;
6. Layout
Breakpoint
css
--bp-sm: 640px;
--bp-md: 768px;
--bp-lg: 1024px;
--bp-xl: 1280px;
Desktop (>= --bp-lg)
Sidebar trái rộng khoảng 240px.
Nội dung chính chiếm phần còn lại.
Header trên cùng cao khoảng 64-76px.
Nội dung chính có max-width khoảng 1050px, căn giữa.
Khoảng cách lớn giữa các nhóm chính: --space-7 đến --space-8.
Mobile (< --bp-md)
Sidebar chuyển thành thanh hẹp hoặc menu thu gọn.
Không để text bị cắt trong nút.
Bảng task chuyển thành layout một cột; ẩn metadata ít quan trọng khi thiếu chỗ.
Nút hành động chính phải dễ bấm bằng một tay, tối thiểu vùng chạm 44x44px.
Không để card, form hoặc tiêu đề vượt khỏi viewport.
Dark mode

Chưa hỗ trợ dark mode. Không tự thêm theme tối trừ khi được yêu cầu rõ ràng và cập nhật vào tài liệu này.

7. Navigation

Menu trái hiện tại nên giữ cấu trúc:

Tổng quan
Việc của tôi
Hôm nay
Hộp thư
Lịch
Dự án
Ứng dụng Taskly
Thiết kế sản phẩm
Nghiên cứu
Cài đặt

Khi thêm mục mới:

Chỉ thêm nếu có chức năng hoặc luồng người dùng rõ ràng.
Dùng icon Lucide phù hợp.
Mục đang chọn có nền xanh mực sáng hơn và icon màu cam.
Nhóm menu có label ngắn, không tạo quá nhiều nhóm.
Mục đếm số lượng đặt bên phải, dùng màu phụ, không gây chú ý hơn tên mục.
8. Icon

Frontend dùng lucide-react.

Không dùng ký tự Unicode thay cho icon trong UI.
Dùng icon có ý nghĩa quen thuộc: Plus, Search, Bell, CalendarDays, ListTodo, Settings, CheckCircle2.
Icon trong nút icon-only phải có aria-label.
Kích thước thông thường: 16px trong menu, 18-20px trong toolbar, 16px trong nút chính.
Nét icon nên đồng nhất, thường dùng stroke-width: 1.8 hoặc mặc định của Lucide.
Icon không được thay thế cho text trong hành động quan trọng nếu người dùng có thể hiểu sai.
9. Component và tương tác
Nút
Nút chính: nền --orange, chữ trắng, bo góc --radius-md.
Nút phụ: nền trong suốt hoặc nền trắng, có border nhẹ dùng --line.
Nút icon-only cần tooltip hoặc aria-label.
Có trạng thái hover, focus-visible và disabled cho mọi nút.
Không dùng nút dạng pill quá tròn trừ khi đó là avatar, badge hoặc trạng thái.
Task row

Mỗi task nên thể hiện:

Checkbox hoàn thành.
Tên task.
Dự án hoặc nhóm liên quan (dùng đúng màu dự án ở mục 3).
Deadline.
Mức ưu tiên (dùng đúng màu ưu tiên ở mục 3).
Menu thao tác bổ sung.

Task hoàn thành phải có:

Checkbox màu xanh nhẹ (--priority-low).
Tên gạch ngang và giảm độ tương phản.
Không xóa ngay khỏi danh sách nếu người dùng chưa yêu cầu.
Form thêm task
Luôn có input rõ ràng và placeholder hướng dẫn ngắn.
Có thể chọn mức ưu tiên.
Enter hoặc nút Thêm việc đều gửi form.
Không gửi task rỗng.
Sau khi thêm thành công, xóa input và giữ người dùng ở cùng vị trí.
Trạng thái dữ liệu

Mọi màn hình dữ liệu cần có đủ các trạng thái sau, dùng đúng văn phong mẫu:

Trạng thái	Ví dụ nội dung
Đang tải	Hiển thị skeleton hoặc spinner, không có text nhấp nháy
Rỗng	"Chưa có công việc nào. Thêm việc đầu tiên để bắt đầu."
Thành công	Hiển thị dữ liệu bình thường, không cần thông báo thêm
Lỗi	"Không tải được dữ liệu. Thử lại." kèm nút Thử lại
Không có quyền truy cập	"Bạn không có quyền xem nội dung này."

Giọng văn cho lỗi/rỗng: ngắn, không xin lỗi, không đổ lỗi cho người dùng, luôn có hướng xử lý tiếp theo nếu có thể.

10. Accessibility
Dùng phần tử HTML đúng nghĩa: button, form, input, nav, main, section.
Có label hoặc aria-label cho input và icon button.
Focus bằng bàn phím phải nhìn thấy rõ (dùng focus-visible, không tắt outline mặc định mà không thay thế).
Không dùng màu duy nhất để phân biệt trạng thái.
Đảm bảo độ tương phản đủ tốt giữa text và nền (tối thiểu AA).
Không khóa thao tác bằng hover-only.
11. Motion
Chỉ dùng chuyển động ngắn và có mục đích: focus form, hover button, xuất hiện nội dung, mở/đóng modal.
Transition thông thường khoảng 150-220ms.
Không dùng animation liên tục làm người dùng mất tập trung.
Không dùng hiệu ứng fade-slide-up hàng loạt cho mọi section/card khi load trang — chỉ một khoảnh khắc chuyển động có chủ đích, không lặp lại khắp nơi.
Tôn trọng prefers-reduced-motion nếu thêm animation lớn.
12. Quy tắc code frontend
Dùng React + TypeScript theo pattern đang có.
Dùng lucide-react cho icon.
Dùng Tailwind CSS, ánh xạ token màu/spacing/radius ở mục 3, 4, 5 vào tailwind.config thay vì viết giá trị số trực tiếp trong component.
Ưu tiên dùng component nền shadcn/ui (dựa trên Radix) cho dropdown, dialog, popover, select, toast, tooltip — đã chuẩn accessibility, chỉnh theme lại theo token ở trên thay vì viết lại từ đầu.
Dùng class-variance-authority (cva) khi một component có nhiều variant (vd: Button có primary/secondary/danger) để tránh style rời rạc, xung đột.
Dùng date-fns với locale vi để format ngày tháng, không tự viết logic format ngày bằng tay.
Dùng react-hook-form + zod cho form có nhiều field hoặc cần validate (form thêm task, form giao việc); form đơn giản một input có thể dùng state thường.
Giữ component nhỏ, tách component khi một file bắt đầu khó đọc.
Không thêm state hoặc abstraction nếu chưa cần cho hành vi thật.
Không hard-code dữ liệu lâu dài trong component khi backend/API đã sẵn sàng.
Giữ logic dữ liệu tách khỏi phần trình bày khi tính năng phát triển lớn hơn.
Sau mỗi thay đổi UI, chạy:
powershell
cd frontend
npm run lint
npm run build
13. Checklist trước khi hoàn thành UI
 Đã đọc design.md.
 Text hiển thị là tiếng Việt, đúng văn phong hành động (mục 2).
 Icon dùng lucide-react, không dùng ký tự Unicode.
 Màu dùng đúng token ở mục 3, không tự chế màu mới.
 Spacing, bo góc, shadow dùng đúng token ở mục 5.
 Có trạng thái hover, focus-visible và disabled cho thao tác chính.
 Không có text hoặc component bị tràn trên mobile.
 Có đủ 5 trạng thái dữ liệu (đang tải/rỗng/thành công/lỗi/không có quyền) nếu màn hình dùng dữ liệu, đúng văn phong mẫu ở mục 9.
 Các màu và font khớp token hiện tại.
 npm run lint thành công.
 npm run build thành công.