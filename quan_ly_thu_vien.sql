CREATE DATABASE library_management;
USE library_management;

-- Bảng users - người dùng
CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100),
	password VARCHAR(100),
	email VARCHAR(100),
	role ENUM('USER', 'ADMIN'),
	status BOOLEAN -- true: hoạt động, false: bị khóa
);
-- Thêm tài khoản ADMIN
INSERT INTO users (username, password, email, role, status)
VALUES ('admin1', 'admin123@', 'admin@gmail.com', 'ADMIN', true);

-- Bảng books - sách
CREATE TABLE books (
	book_id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(200),
	author VARCHAR(100),
	category VARCHAR(100),
	description TEXT,
	publication_year int,
	quantity INT
);
-- Thêm dữ liệu bản ghi
INSERT INTO books (title, author, category, description, publication_year, quantity) VALUES
('Dế Mèn Phiêu Lưu Ký', 'Tô Hoài', 'Thiếu nhi', 'Cuộc phiêu lưu kỳ thú của Dế Mèn qua nhiều miền đất.', 1941, 5),
('Tuổi Thơ Dữ Dội', 'Phùng Quán', 'Văn học Việt Nam', 'Câu chuyện cảm động về thiếu niên trong kháng chiến.', 1988, 4),
('Lão Hạc', 'Nam Cao', 'Hiện thực', 'Nỗi khổ của một người nông dân già nghèo khổ.', 1943, 3),
('Chiếc Lược Ngà', 'Nguyễn Quang Sáng', 'Chiến tranh', 'Tình cha con sâu nặng trong hoàn cảnh chiến tranh.', 1966, 6),
('Tắt Đèn', 'Ngô Tất Tố', 'Hiện thực phê phán', 'Thân phận người phụ nữ nông dân dưới chế độ phong kiến.', 1939, 5),
('Đất Rừng Phương Nam', 'Đoàn Giỏi', 'Thiếu nhi', 'Hành trình của bé An giữa rừng U Minh.', 1957, 7),
('Vợ Nhặt', 'Kim Lân', 'Hiện thực', 'Tình cảnh khốn cùng và tình người trong nạn đói.', 1945, 4),
('Số Đỏ', 'Vũ Trọng Phụng', 'Trào phúng', 'Châm biếm xã hội thực dân nửa mùa.', 1936, 3),
('Chí Phèo', 'Nam Cao', 'Hiện thực', 'Bi kịch của người nông dân bị tha hóa.', 1941, 6),
('Nhật Ký Đặng Thùy Trâm', 'Đặng Thùy Trâm', 'Hồi ký', 'Nhật ký xúc động của nữ bác sĩ trong chiến tranh.', 2005, 8);
