-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 23, 2022 lúc 05:01 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltc`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bangdangkytiem`
--

CREATE TABLE `bangdangkytiem` (
  `MaDangKyTiem` int(11) NOT NULL,
  `NgayDangKy` varchar(255) NOT NULL,
  `GoiTiem` varchar(255) NOT NULL,
  `LoaiVaccineDangKy` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL,
  `maCCCD` int(11) DEFAULT NULL,
  `ngayMuonTiem` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bangdangkytiem`
--

INSERT INTO `bangdangkytiem` (`MaDangKyTiem`, `NgayDangKy`, `GoiTiem`, `LoaiVaccineDangKy`, `TrangThai`, `maCCCD`, `ngayMuonTiem`) VALUES
(14, 'Nhà Khoa học 1', '1980', 'Paris', 0, 10, ''),
(15, 'Nhà Khoa học 2', '1980', 'New York', 0, 15, ''),
(16, 'Nhà Khoa học 3', '1980', 'New York', 0, 114, ''),
(32, '2021-11-06', '1980', 'New York', 0, 147, ''),
(33, '2021-11-06', '16', 'New York', 0, 1111, ''),
(34, '2021-11-06', '16', 'New York', 0, 1174, ''),
(44, '2021-11-06', '1980', 'New York', 0, 15, ''),
(45, '2021-11-06', '1980', 'New York', 0, 10, ''),
(46, '2021-05-01', '1999', 'New York', 0, 10, ''),
(47, '2021-11-07', 'Gói 1', 'AstraZeneca', 1, 2020201515, '2021-11-07'),
(48, '2021-11-07', 'Gói 2', 'Spikevax ', 1, 2020145622, '2021-11-07'),
(49, '2021-11-06', 'đâsdsa', 'ádas', 0, 10, '2021-11-06'),
(50, '2021-11-07', 'Gois 2', 'TQ', 0, 10, '2021-11-01'),
(51, '2021-11-07', 'Gói thường', 'New York', 1, 2020111111, '2021-11-07'),
(52, '2021-11-07', 'Gói thường', 'New York', 1, 2020111111, '2021-11-07'),
(53, '2021-11-07', 'Gói 2', 'Astra', 1, 1174777777, '2021-11-07'),
(54, '2021-11-07', 'Gói VIP', 'Spikevax ', 1, 174777777, '2021-11-07'),
(55, '2021-11-07', 'Gói VIP', 'China', 1, 2020111111, '2021-11-07'),
(56, '2021-11-08', 'Gói VIP', 'China', 1, 2020111111, '2021-11-08'),
(57, '2021-11-08', 'Gói VIP', 'China', 0, 2020111111, '2021-11-08'),
(58, '2021-11-08', 'Gói 1', 'AstraZeneca', 1, 2020145622, '2021-11-19');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaCTPN` int(11) NOT NULL,
  `MaPN` int(11) NOT NULL,
  `MaVaccine` int(11) NOT NULL,
  `Gia` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaCTPN`, `MaPN`, `MaVaccine`, `Gia`, `SoLuong`, `ThanhTien`) VALUES
(18, 16, 27, 10000, 10, 100000),
(19, 16, 28, 15000, 20, 300000),
(20, 16, 27, 500000, 1, 500000),
(22, 20, 27, 100000, 1, 100000),
(23, 21, 27, 1000000, 1, 1000000),
(24, 22, 27, 1000000, 1, 1000000),
(25, 23, 45, 1000, 5, 5000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieutiem`
--

CREATE TABLE `chitietphieutiem` (
  `MaCTPT` int(11) NOT NULL,
  `MaPT` int(11) NOT NULL,
  `MaVaccine` int(11) NOT NULL,
  `NgayTra` varchar(244) NOT NULL,
  `GhiChu` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietphieutiem`
--

INSERT INTO `chitietphieutiem` (`MaCTPT`, `MaPT`, `MaVaccine`, `NgayTra`, `GhiChu`, `TrangThai`) VALUES
(41, 29, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(42, 21, 38, '2021-11-07', 'Hôm nay là hạn cuối', 1),
(43, 28, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(44, 27, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(45, 29, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 0),
(46, 24, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(47, 19, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 0),
(48, 19, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 0),
(49, 19, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(50, 19, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(51, 20, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(52, 24, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(53, 27, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(54, 28, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(55, 29, 27, '2021-11-07', 'Hết Hạn Theo Dõi', 1),
(56, 29, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 0),
(57, 30, 38, '2021-11-14', '', 1),
(58, 23, 38, '2021-11-14', 'Chưa hết hạn', 1),
(59, 31, 40, '2021-11-14', '', 0),
(60, 34, 40, '2021-11-14', '', 1),
(61, 35, 40, '2021-11-14', 'Chưa hết hạn', 1),
(62, 28, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(63, 28, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(64, 28, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(65, 28, 27, '2021-11-06', 'Hết Hạn Theo Dõi', 1),
(66, 31, 27, '2021-11-14', '', 1),
(67, 35, 40, '2021-11-14', 'Chưa hết hạn', 1),
(68, 37, 27, '2021-11-08', 'Hết Hạn Theo Dõi', 1),
(69, 21, 38, '2021-12-12', 'Hết Hạn Theo Dõi', 1),
(70, 38, 40, '2021-11-09', 'Hôm nay là hạn cuối', 1),
(71, 36, 40, '2021-11-14', 'Chưa hết hạn', 1),
(72, 38, 38, '2021-11-09', 'Chưa hết hạn', 1),
(73, 38, 40, '2021-11-09', 'Chưa hết hạn', 1),
(74, 38, 40, '2021-11-09', 'Chưa hết hạn', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `goitiem`
--

CREATE TABLE `goitiem` (
  `magoitiem` int(11) NOT NULL,
  `mapt` int(11) NOT NULL,
  `lydo` varchar(255) NOT NULL,
  `tien` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `goitiem`
--

INSERT INTO `goitiem` (`magoitiem`, `mapt`, `lydo`, `tien`) VALUES
(10, 26, 'Gói 1', '500000'),
(11, 24, 'Gói Vip', '10000000'),
(12, 24, 'Gói 2', '600000'),
(13, 35, 'Gói Vip', '10000000'),
(14, 35, 'Gói 2', '600000'),
(15, 35, 'Gói 1', '500000'),
(16, 38, 'Gói 2', '600000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kevaccine`
--

CREATE TABLE `kevaccine` (
  `MaKe` int(11) NOT NULL,
  `ViTri` varchar(255) DEFAULT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `kevaccine`
--

INSERT INTO `kevaccine` (`MaKe`, `ViTri`, `TrangThai`) VALUES
(13, 'Kệ 1', 1),
(14, 'Kệ 2', 1),
(15, 'Kệ 3', 1),
(16, 'Kệ 4', 1),
(17, 'Kệ 5', 1),
(18, 'Kệ 108', 1),
(19, 'kệ 121', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`, `TrangThai`) VALUES
(12, 'Mỹ', 1),
(13, 'Trung Quốc', 1),
(14, 'Nga', 1),
(15, 'Ấn Độ', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidan`
--

CREATE TABLE `nguoidan` (
  `manguoidan` int(11) NOT NULL,
  `tennguoidan` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL,
  `namsinh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nguoidan`
--

INSERT INTO `nguoidan` (`manguoidan`, `tennguoidan`, `gioitinh`, `diachi`, `sdt`, `TrangThai`, `namsinh`) VALUES
(1, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1988'),
(10, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1988'),
(14, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, ''),
(15, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, ''),
(16, 'Võ Hoàng Kiệt', 'Nam', 'Long An', '0396527908', 0, ''),
(17, 'Võ Hoàng Kiệt', 'Nam', 'Long An', '0396527908', 0, ''),
(18, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, ''),
(114, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1'),
(147, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1988'),
(1111, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1999'),
(1174, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1999'),
(1414, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, ''),
(1914, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1252'),
(11111, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1252'),
(11744, 'Ngô Phú Khang', 'Nam', 'Cà Ma', '0396527909', 0, '1999'),
(14914, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1989'),
(18914, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1859'),
(148914, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1998'),
(777777, 'Ngô Phú Tạ', 'Nam', 'Cà Mau', '0396527909', 1, '1999'),
(1111111, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1988'),
(1478914, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1988'),
(11747778, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1999'),
(174777777, 'Ngô Hồng Quân', 'Nam', 'Vũng Tàu', '0396522007', 1, '1999'),
(1174777777, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 1, '1999'),
(1478914555, 'Ngô Phú Khang', 'Nam', 'Cà Mau', '0396527909', 0, '1988'),
(2020111111, 'Bùi Văn Kiêm', 'Nam', 'Thái Bình', '0396527977', 1, '1998'),
(2020145622, 'Bùi Nam Hải', 'Nam', 'Thái Bình', '0396527909', 1, '1998'),
(2020201212, 'Bùi Văn Đức', 'Nam', 'Hà Nội', '0394447977', 0, '1988'),
(2020201500, 'Bùi Văn Đức', 'Nam', 'Hà Nội', '0394447977', 1, '1988'),
(2020201513, 'Bùi Văn Đức', 'Nam', 'Hà Nội', '0394447977', 1, '1988'),
(2020201515, 'Bùi Văn Đức', 'Nam', 'Hà Nội', '0394447977', 1, '1988'),
(2020201520, 'Bùi Văn Đức', 'Nam', 'Hà Nội', '0394447977', 0, '1988');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` int(11) NOT NULL,
  `TenNCC` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `TrangThai`) VALUES
(1, 'Võ Hoàng Kiệt', 0),
(2, 'Ngô Phú Khang2', 0),
(3, 'Nguyễn Văn Cừ', 0),
(4, 'Y Tế', 1),
(6, 'Huỳnh Hoàng Phúc', 0),
(7, 'Nguyễn Đình Trí', 0),
(8, 'Hà Nội', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL,
  `TenNV` varchar(255) NOT NULL,
  `NamSinh` varchar(11) NOT NULL,
  `GioiTinh` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `Sdt` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL,
  `donViTiem` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NamSinh`, `GioiTinh`, `DiaChi`, `Sdt`, `TrangThai`, `donViTiem`) VALUES
(35, 'Nam Nguyễn Văn', '1988', 'Nam', 'Hà Nội', '0396527908', 1, 'Tổ 19 Phú Diễn Bắc Từ Liêm Hà Nội'),
(36, 'Nguyễn Văn Đạt', '1998', 'Nam', 'Thái Bình', '0396526508', 1, 'Nam Từ Liêm Hà Nội'),
(37, 'Nguyễn Văn Thắng', '1997', 'Nam', 'Bến Tre', '0397377908', 1, 'Bắc Từ Liêm'),
(38, 'Bùi Nam Hải', '1998', 'Nam', 'Cà Mau', '0396524545', 1, 'Nguyên Xá Bắc Từ Liêm Hà Nội'),
(39, 'Nhân Viên 3', '2000', 'Nữ', 'Bến Tre', '0396527908', 0, 'Hà nội '),
(40, 'Bùi Nam Hải', '1998', 'Nam', 'Cà Mau', '0396524545', 0, 'Nguyên Xá Bắc Từ Liêm Hà Nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MaNhaSX` int(11) NOT NULL,
  `TenNhaSx` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `Sdt` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MaNhaSX`, `TenNhaSx`, `DiaChi`, `Sdt`, `TrangThai`) VALUES
(13, 'Công Ty ABC', 'Hồ Chí Minh', '0396527908', 1),
(14, 'Viện Nghiên cứu Quốc gia', 'Liên Bang Nga', '0396527909', 1),
(15, 'Công ty TNHH một thành viên Dược Sài Gòn', 'Hồ Chí Minh', '0396527910', 1),
(16, 'Công ty TNHH một thành viên Dược Hà Nội', 'Hồ Chí Minh', '0396527911', 1),
(17, 'Công ty TNHH Dược Thái Bình', 'Hồ Chí Minh', '0396527912', 0),
(18, 'Công ty Vimedimex', 'Hà Nội', '0396527913', 1),
(19, 'Công ty TNHH một thành viên Dược Hà Nội', 'Hồ Chí Minh', '0396527911', 1),
(20, 'Công ty TNHH một thành viên Dược Hà Nội', 'Hồ Chí Minh', '0396527911', 0),
(21, 'Công ty TNHH một thành viên Dược Hà Nội', 'Hồ Chí Minh', '0396527911', 0),
(22, 'Công ty Vimedimex', 'Hà Nội', '0396527913', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayNhap` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNCC`, `MaNV`, `NgayNhap`, `TrangThai`) VALUES
(16, 2, 36, '2021-09-15', 0),
(19, 2, 39, '2021-09-15', 1),
(20, 2, 35, '2021-09-15', 1),
(21, 4, 36, '2021-11-07', 0),
(22, 8, 35, '2021-11-07', 1),
(23, 4, 38, '2021-11-08', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieutiem`
--

CREATE TABLE `phieutiem` (
  `MaPT` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaNguoiDan` int(11) NOT NULL,
  `NgayTiem` varchar(255) NOT NULL,
  `TinhTrang` varchar(255) NOT NULL,
  `TrangThai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieutiem`
--

INSERT INTO `phieutiem` (`MaPT`, `MaNV`, `MaNguoiDan`, `NgayTiem`, `TinhTrang`, `TrangThai`) VALUES
(19, 35, 14, '2021-11-01', 'Tốt', 0),
(20, 35, 14, '2021-09-15', 'Tốt', 0),
(21, 35, 174777777, '2021-10-27', 'Theo Dõi', 1),
(22, 35, 14, '2021-10-27', 'Đã Trả', 0),
(23, 35, 777777, '2021-10-16', 'Tốt', 1),
(24, 37, 1174777777, '2021-09-15', 'Theo Dõi', 0),
(25, 35, 14, '2021-10-27', 'Đã Trả', 0),
(26, 35, 15, '2021-10-16', 'Theo dõi', 0),
(27, 35, 2020111111, '2021-11-06', 'Tốt', 1),
(28, 39, 777777, '2021-11-06', 'Tốt', 1),
(29, 35, 10, '2021-11-06', 'Tốt', 0),
(30, 35, 777777, '2021-11-07', 'Theo dõi', 1),
(31, 37, 1174777777, '2021-09-15', 'Tốt', 1),
(32, 37, 1174777777, '2021-09-15', 'Theo Dõi', 0),
(33, 35, 10, '2021-09-15', 'Theo dõi', 0),
(34, 35, 10, '2021-11-07', 'Tốt', 0),
(35, 36, 2020145622, '2021-11-07', 'Theo Dõi', 1),
(36, 35, 777777, '2021-11-06', 'Theo dõi', 1),
(37, 35, 777777, '2021-11-06', 'Tốt', 1),
(38, 38, 2020145622, '2021-11-06', 'Tốt', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `matk` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `quyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`matk`, `username`, `password`, `quyen`) VALUES
(1, 'admin', 'admin ', 0),
(35, 'nv1', 'admin', 1),
(37, 'nv37', 'admin ', 0),
(38, 'admin2', 'admin ', 0),
(39, '', 'admin ', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `testthenv`
--

CREATE TABLE `testthenv` (
  `MaThe` int(11) NOT NULL,
  `NgayBatDau` varchar(255) NOT NULL,
  `NgayKetThuc` varchar(255) NOT NULL,
  `GhiChu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `testthenv`
--

INSERT INTO `testthenv` (`MaThe`, `NgayBatDau`, `NgayKetThuc`, `GhiChu`) VALUES
(14, '2021-09-15', '2021-09-15', NULL),
(15, '2021-09-15', '2021-11-06', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vaccine`
--

CREATE TABLE `vaccine` (
  `MaVaccine` int(11) NOT NULL,
  `TenVaccine` varchar(255) NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `MaTacGia` int(11) NOT NULL,
  `NamSX` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Make` int(11) NOT NULL,
  `HinhAnh` text NOT NULL,
  `TrangThai` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `vaccine`
--

INSERT INTO `vaccine` (`MaVaccine`, `TenVaccine`, `MaLoai`, `MaNCC`, `MaTacGia`, `NamSX`, `SoLuong`, `Make`, `HinhAnh`, `TrangThai`) VALUES
(27, 'Sinovac', 12, 13, 47, 2020, 1, 13, 'Sinovac.jpg', '1'),
(28, 'Moderna', 13, 14, 47, 2019, 9, 13, 'Moderna.jpg', '1'),
(38, 'Spunik (Nga)', 12, 13, 15, 2019, 5, 13, 'Spunik.jpg', '1'),
(39, 'Spunik (Nga)', 13, 13, 15, 2019, 9, 13, 'Spunik.jpg', '0'),
(40, 'Pfizer', 12, 14, 47, 2019, 0, 13, 'Pfizer.jpg', '1'),
(41, 'Spunik (Nga)', 12, 13, 15, 2020, 9, 13, 'Spunik.jpg', '1'),
(42, 'Spunik (Nga)', 12, 13, 15, 2020, 9, 13, 'Spunik.jpg', '0'),
(43, 'Spunik (Nga)', 12, 13, 15, 2020, 9, 13, 'Spunik.jpg', '0'),
(44, 'Spunik (Nga)', 12, 13, 15, 2019, 6, 13, 'Spunik.jpg', '0'),
(45, 'Sinopharm', 13, 18, 47, 2019, 10, 18, 'Sinopharm.jpg', '1'),
(46, 'Spunik (Nga)', 12, 13, 47, 2020, 9, 13, 'Spunik.jpg', '0'),
(47, 'Spunik (Nga)', 12, 13, 47, 2020, 9, 13, 'Spunik.jpg', '0'),
(48, 'Spunik (Nga)', 12, 13, 47, 2020, 9, 13, 'Spunik.jpg', '0'),
(49, 'Spunik (Nga)', 12, 13, 47, 2020, 9, 13, 'Spunik.jpg', '0'),
(50, 'Spunik (Nga)', 12, 13, 47, 2020, 9, 13, 'Spunik.jpg', '1'),
(51, 'Spunik (Nga)', 14, 15, 47, 2019, 9, 17, 'Spunik.jpg', '0'),
(52, 'Astra Zecera', 12, 14, 47, 2019, 9, 13, 'Astra Zecera.jpg', '1'),
(53, 'Sinopharm', 13, 16, 47, 2020, 9, 18, 'Sinopharm.jpg', '0');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bangdangkytiem`
--
ALTER TABLE `bangdangkytiem`
  ADD PRIMARY KEY (`MaDangKyTiem`),
  ADD KEY `madocgia` (`maCCCD`) USING BTREE;

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaCTPN`),
  ADD KEY `MaSach` (`MaVaccine`),
  ADD KEY `MaPN` (`MaPN`);

--
-- Chỉ mục cho bảng `chitietphieutiem`
--
ALTER TABLE `chitietphieutiem`
  ADD PRIMARY KEY (`MaCTPT`),
  ADD KEY `MaPM` (`MaPT`),
  ADD KEY `MaSach` (`MaVaccine`);

--
-- Chỉ mục cho bảng `goitiem`
--
ALTER TABLE `goitiem`
  ADD PRIMARY KEY (`magoitiem`),
  ADD KEY `mapm` (`mapt`);

--
-- Chỉ mục cho bảng `kevaccine`
--
ALTER TABLE `kevaccine`
  ADD PRIMARY KEY (`MaKe`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nguoidan`
--
ALTER TABLE `nguoidan`
  ADD PRIMARY KEY (`manguoidan`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MaNhaSX`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `phieutiem`
--
ALTER TABLE `phieutiem`
  ADD PRIMARY KEY (`MaPT`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaDocGia` (`MaNguoiDan`),
  ADD KEY `MaNV_2` (`MaNV`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`matk`);

--
-- Chỉ mục cho bảng `testthenv`
--
ALTER TABLE `testthenv`
  ADD PRIMARY KEY (`MaThe`);

--
-- Chỉ mục cho bảng `vaccine`
--
ALTER TABLE `vaccine`
  ADD PRIMARY KEY (`MaVaccine`),
  ADD KEY `MaLoai` (`MaLoai`),
  ADD KEY `MaNXB` (`MaNCC`),
  ADD KEY `MaTacGia` (`MaTacGia`),
  ADD KEY `Make` (`Make`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bangdangkytiem`
--
ALTER TABLE `bangdangkytiem`
  MODIFY `MaDangKyTiem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `MaCTPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `chitietphieutiem`
--
ALTER TABLE `chitietphieutiem`
  MODIFY `MaCTPT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT cho bảng `goitiem`
--
ALTER TABLE `goitiem`
  MODIFY `magoitiem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `kevaccine`
--
ALTER TABLE `kevaccine`
  MODIFY `MaKe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  MODIFY `MaNhaSX` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPhieuNhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `phieutiem`
--
ALTER TABLE `phieutiem`
  MODIFY `MaPT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT cho bảng `vaccine`
--
ALTER TABLE `vaccine`
  MODIFY `MaVaccine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bangdangkytiem`
--
ALTER TABLE `bangdangkytiem`
  ADD CONSTRAINT `fk_dangkytiem_nguoidan` FOREIGN KEY (`maCCCD`) REFERENCES `nguoidan` (`manguoidan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaVaccine`) REFERENCES `vaccine` (`MaVaccine`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPhieuNhap`);

--
-- Các ràng buộc cho bảng `chitietphieutiem`
--
ALTER TABLE `chitietphieutiem`
  ADD CONSTRAINT `chitietphieutiem_ibfk_1` FOREIGN KEY (`MaPT`) REFERENCES `phieutiem` (`MaPT`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieutiem_ibfk_2` FOREIGN KEY (`MaVaccine`) REFERENCES `vaccine` (`MaVaccine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `goitiem`
--
ALTER TABLE `goitiem`
  ADD CONSTRAINT `goitiem_ibfk_1` FOREIGN KEY (`mapt`) REFERENCES `phieutiem` (`MaPT`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `phieutiem`
--
ALTER TABLE `phieutiem`
  ADD CONSTRAINT `phieutiem_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `phieutiem_ibfk_2` FOREIGN KEY (`MaNguoiDan`) REFERENCES `nguoidan` (`manguoidan`);

--
-- Các ràng buộc cho bảng `testthenv`
--
ALTER TABLE `testthenv`
  ADD CONSTRAINT `testthenv_ibfk_1` FOREIGN KEY (`MaThe`) REFERENCES `nguoidan` (`manguoidan`);

--
-- Các ràng buộc cho bảng `vaccine`
--
ALTER TABLE `vaccine`
  ADD CONSTRAINT `vaccine_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`),
  ADD CONSTRAINT `vaccine_ibfk_2` FOREIGN KEY (`MaNCC`) REFERENCES `nhasanxuat` (`MaNhaSX`),
  ADD CONSTRAINT `vaccine_ibfk_3` FOREIGN KEY (`MaTacGia`) REFERENCES `bangdangkytiem` (`MaDangKyTiem`),
  ADD CONSTRAINT `vaccine_ibfk_4` FOREIGN KEY (`Make`) REFERENCES `kevaccine` (`MaKe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
