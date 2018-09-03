-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 31, 2018 lúc 05:56 AM
-- Phiên bản máy phục vụ: 10.1.34-MariaDB
-- Phiên bản PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbquanlysach`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnhaxuatban`
--

CREATE TABLE `tblnhaxuatban` (
  `manxb` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tennxb` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `diachi` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `dienthoai` varchar(11) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblnhaxuatban`
--

INSERT INTO `tblnhaxuatban` (`manxb`, `tennxb`, `diachi`, `dienthoai`) VALUES
('nxb1', 'Nhà xuất bản 1', 'hà nội ', '0123'),
('nxb2', 'Nhà xuất bản 2', 'thành phố hồ chí minh', '0123446'),
('nxb3', 'Nhà xuất bản 3', 'NY', '098766'),
('nxb4', 'Nhà xuất bản 4', 'Đà Nẵng', '826378568'),
('nxb5', 'test', 'test', '2222222');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsach`
--

CREATE TABLE `tblsach` (
  `masach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenSach` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sotrang` int(11) DEFAULT NULL,
  `manxb` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblsach`
--

INSERT INTO `tblsach` (`masach`, `tenSach`, `sotrang`, `manxb`) VALUES
('s01', 'Sách 1', 100, 'nxb1'),
('s02', 'Sách 2', 300, 'nxb1'),
('s03', 'Sách 3', 45, 'nxb2'),
('s04', 'Sách 4', 399, 'nxb3'),
('s06', 'test', 12, 'nxb1'),
('s07', 'abc', 2342, 'nxb4');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblnhaxuatban`
--
ALTER TABLE `tblnhaxuatban`
  ADD PRIMARY KEY (`manxb`);

--
-- Chỉ mục cho bảng `tblsach`
--
ALTER TABLE `tblsach`
  ADD PRIMARY KEY (`masach`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
