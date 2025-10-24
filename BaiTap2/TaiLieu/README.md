# BÀI TẬP TUẦN 2
## Nội dung và báo cáo bài tập tuần 2
Trong folder SourceCode thì có đầy đủ 3 bài tập trong cùng 1 project (không phải 3 file làm 3 project khác nhau).

Để hoạt động được 3 bài tập chạy cùng 1 project, nghĩa là 1 trang sẽ là 1 bài tập. Ta sẽ dùng *Navigation* để chuyển giữa các trang lại với nhau để thực hiện chạy từng bài tập. 

3 bài tập tương đương với 3 file lần lượt là Number.kt, Email.kt và Info.kt. Và có 1 file MainActivity.kt để gọi hàm và hoạt động. Tổng cộng là 4 file.  

Source code này có 4 file cho 4 chức năng công việc như sau:  

📂 MainActivity.kt: Màn hình chính và điều hướng  
Đây là tệp khởi đầu của ứng dụng. Chức năng chính của nó là tạo ra một giao diện có khả năng điều hướng qua lại giữa 3 màn hình con.  
- Điều hướng (Navigation): Sử dụng một biến trạng thái currentScreen để theo dõi màn hình nào đang được hiển thị.  
- Giao diện:  
  - Hiển thị tên của bài thực hành hiện tại (ví dụ: "Bài 1: Number").  
  - Có hai nút mũi tên (trái và phải) để người dùng chuyển đổi qua lại giữa 3 màn hình theo vòng lặp: Màn hình 1 <-> Màn hình 2 <-> Màn hình 3 <-> Màn hình 1. 
- Nội dung: Dựa vào giá trị của *currentScreen*,  nó sẽ hiển thị nội dung của một trong ba màn hình: *NumberScreen*, *EmailScreen*, hoặc *InfoScreen*.


📂 Number.kt: Màn hình tạo chuỗi số (Bài 1)
Màn hình này cho phép người dùng nhập vào một số và tạo ra một chuỗi số tương ứng.
- Đầu vào: Một ô OutlinedTextField để người dùng "Nhập số".
- Nút bấm: Một nút có nhãn "Tạo".
- Xử lý logic:
  1. Khi nhấn nút "Tạo", ứng dụng sẽ kiểm tra xem đầu vào có rỗng không.
  2. Nó tiếp tục kiểm tra để đảm bảo rằng tất cả các ký tự trong ô đầu vào đều là chữ số.
  3. Nếu đầu vào là một số hợp lệ (ví dụ: người dùng nhập 5), ứng dụng sẽ tạo và hiển thị một chuỗi các số từ 1 đến số đó, mỗi số trên một dòng mới.
  ```
  1
  2
  3
  4
  5
  ```
  4. Nếu đầu vào không hợp lệ (rỗng hoặc chứa ký tự không phải số), một thông báo lỗi sẽ được hiển thị, ví dụ: "Dữ liệu bạn nhập không hợp lệ".


📂 Email.kt: Màn hình kiểm tra Email (Bài 2)
Màn hình này thực hiện một phép kiểm tra rất cơ bản để xem một chuỗi có giống định dạng email hay không.
- Đầu vào: Một ô OutlinedTextField để người dùng "Nhập email".
- Nút bấm: Một nút có nhãn "Kiểm tra".
- Xử lý logic:
  1. Khi nhấn nút, ứng dụng kiểm tra xem người dùng đã nhập gì chưa. Nếu chưa, nó báo "Email không hợp lệ".
  2. Nếu có nhập, nó sẽ kiểm tra xem chuỗi văn bản có chứa ký tự '@' hay không.
  3. Nếu có ký tự '@', nó sẽ hiển thị thông báo "Email hợp lệ".
  4. Nếu không có ký tự '@', nó sẽ báo "Email không đúng định dạng".


📂 Info.kt: Màn hình phân loại độ tuổi (Bài 3)
Màn hình này nhận thông tin tên và tuổi của người dùng, sau đó phân loại họ vào các nhóm tuổi khác nhau.
- Đầu vào: Hai ô OutlinedTextField để "Nhập tên" và "Nhập tuổi".
- Nút bấm: Một nút có nhãn "Kiểm tra".
- Xử lý logic:
  1. Khi nhấn nút, ứng dụng đảm bảo rằng cả hai ô tên và tuổi đều không bị bỏ trống.
  2. Nó xác thực rằng tuổi được nhập phải là một số.
  3. Dựa trên số tuổi (tuoi) đã nhập, nó sẽ phân loại như sau:
  ```
  tuoi > 65: "Người già"
  6 <= tuoi <= 65: "Người lớn"
  2 <= tuoi < 6: "Trẻ em"
  tuoi < 2: "Em bé"
  ```
  4. Cuối cùng, nó hiển thị kết quả bao gồm tên, tuổi và nhóm phân loại tương ứng. Ví dụ: "Tên: An\nTuổi: 25\nPhân loại: Người lớn".
  5. Nếu có lỗi (nhập thiếu, tuổi không phải là số), thông báo lỗi sẽ xuất hiện.

