# TRẢ LỜI BÀI TẬP TUẦN 1
## Bài 1: Mong muốn và định hướng của Bạn là gì sau khi học xong môn học là gì?  
### Bài làm
- Nắm vững được các kiến thức và kỹ năng trong việc xây dựng ứng dụng trên nền tảng Android. Mục tiêu nhỏ nhất là sau dự án cuối kì ở trên lớp thì có dự án cảu riêng mình. 


## Bài 2: Theo bạn, trong tương lai gần (10 năm) lập trình di động có phát triển không? Giải thích tại sao?
### Bài làm
Theo bản thân mình, thì ngành lập trình di động thì tiếp tục phát triển mạnh mẽ trong 10 năm tới.  
Tương lai về sau thì nhu cầu của người tiêu dùng ngày càng cao,kéo yêu cầu cho các ngành lập trình di động ngày càng cao nên thiết bị di động luôn được thay đổi để phục vụ cho người dùng.  
Là công cụ không thể thiếu trong cuộc sống thường ngày - học tập, làm việc, giải trí.  
Ngoài ra, sự ra đời của AI, IoT, 5G cũng giúp ứng dụng di động ngày càng thông minh và tiện lợi hơn. Vì vậy, lập trình di động sẽ vẫn là ngành nghề có nhiều cơ hội trong tương lai.


## Bài 3: Viết một ứng dụng có UI như sau đây lên github. (Đã push ở thư mục SourceCode)
### Bài làm
Trong phần SourceCode, chúng ta có 4 file chính để thực hiện cho bài tập thực hành bao gồm: *AppNavigation.kt, HelloScreen.kt, InfoScreen.kt, MainActivity.kt*.  
Ở phân yêu cầu bài tập chỉ có yêu cầu thiết UI theo hình cho, mình muốn thiết kế giao diện UI khác đi. Không những thế mà mình sẽ làm 2 trang thay vì 1 trang theo yêu cầu.  
Hai trang mà mình nói ở đây bao gồm: 
- Trang đầu là trang hiển thị "Hello, Vu Tri Dung! và có ảnh đại diện và có nút bấm xem thông tin.
- Trang sau là các thông tin cá nhân, thông tin sinh viên và có các đường dẫn đến các trang cá nhân của mình trên mạng xã hội bao gồm Facebook, X và Instagram và có nút quay về trang Hello.
- Đặc biệt là mình có code thêm hình nền background đằng sau.
<img width="417" height="930" alt="image" src="https://github.com/user-attachments/assets/8bbabcc6-5d62-4c55-a9d7-84ef72d4cb05" />
<img width="417" height="923" alt="image" src="https://github.com/user-attachments/assets/6c150a79-1196-4852-8151-e4c972f39d27" />

https://github.com/user-attachments/assets/41738a3b-9428-4989-afbf-4d2aebcd5a77

Mình sẽ báo cáo chức năng 4 file chính mà mình đã nhắc ở trên:   
📂 MainActivity.kt: Tệp khởi động chính
Đây là điểm khởi đầu của ứng dụng, chịu trách nhiệm thiết lập cửa sổ và hiển thị giao diện người dùng đầu tiên.
- Chế độ toàn màn hình (Immersive Mode): Tệp này cấu hình cho ứng dụng chạy ở chế độ toàn màn hình, ẩn đi thanh trạng thái và thanh điều hướng hệ thống để mang lại trải nghiệm xem trọn vẹn hơn.
- Tải giao diện: Nó gọi đến AppNavigation(), là composable chịu trách nhiệm quản lý việc điều hướng giữa các màn hình của ứng dụng.

📂 AppNavigation.kt: Bộ điều hướng ứng dụng
Tệp này định nghĩa "bản đồ" của ứng dụng, cho biết có những màn hình nào và cách di chuyển giữa chúng.
- Thiết lập NavHost: Nó sử dụng NavHost để tạo một khu vực trong giao diện nơi các màn hình có thể được hiển thị và thay thế.
- Định nghĩa các "route" (tuyến đường):
  - startDestination = "hello": Xác định HelloScreen là màn hình sẽ xuất hiện đầu tiên khi mở ứng dụng.
  - composable("hello"): Liên kết chuỗi "hello" với HelloScreen.
  - composable("info"): Liên kết chuỗi "info" với InfoScreen.

📂 HelloScreen.kt: Màn hình chào mừng
Đây là màn hình chính và đơn giản, đóng vai trò như một trang bìa.
- Giao diện:
  - Hiển thị một ảnh nền toàn màn hình.
  - Hiển thị một ảnh đại diện (avatar) hình con ếch trong một khung tròn.
  - Có một hộp thoại với nền xám mờ chứa dòng chữ chào mừng "Hello, Vu Tri Dung!".
- Chức năng:
  - Có một nút bấm duy nhất với nhãn "Xem thông tin".
  -  Khi người dùng nhấn vào nút này, ứng dụng sẽ điều hướng họ đến màn hình "info" (tức là InfoScreen).

📂 InfoScreen.kt: Màn hình thông tin chi tiết
Đây là màn hình chính chứa tất cả thông tin cá nhân của người dùng, được trình bày một cách chi tiết.
- Giao diện:
  - Sử dụng cùng một ảnh nền và ảnh đại diện như HelloScreen.
  - Thông tin được chia thành ba phần riêng biệt, mỗi phần nằm trong một hộp Card có nền xám trong suốt để dễ đọc:
    1. THÔNG TIN CÁ NHÂN: Hiển thị họ tên, ngày sinh, email và số điện thoại.
    2. THÔNG TIN HỌC TẬP: Hiển thị thông tin về trường, mã số sinh viên, ngành học, v.v..
    3. MẠNG XÃ HỘI: Hiển thị các biểu tượng của Facebook, Instagram và X (Twitter).
- Chức năng:
  - Tương tác với mạng xã hội: Các biểu tượng mạng xã hội có thể được nhấn vào. Khi nhấn, ứng dụng sẽ mở trình duyệt web hoặc ứng dụng tương ứng để truy cập vào trang cá nhân của người dùng trên nền tảng đó.
  - Nút "Quay lại": Ở cuối màn hình, có một nút "Quay lại" cho phép người dùng trở về màn hình chào mừng (HelloScreen).


