-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12 Des 2017 pada 07.05
-- Versi Server: 10.1.28-MariaDB
-- PHP Version: 7.0.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ppdb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data`
--

CREATE TABLE `data` (
  `Nama` varchar(160) NOT NULL,
  `Alamat` text NOT NULL,
  `Kelamin` varchar(15) NOT NULL,
  `Beasiswa` varchar(50) NOT NULL,
  `TTL` varchar(160) NOT NULL,
  `Photo` text NOT NULL,
  `Telpon` varchar(12) NOT NULL,
  `Mtk` double NOT NULL,
  `Ipa` double NOT NULL,
  `Indo` double NOT NULL,
  `Ing` double NOT NULL,
  `NEM` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data`
--

INSERT INTO `data` (`Nama`, `Alamat`, `Kelamin`, `Beasiswa`, `TTL`, `Photo`, `Telpon`, `Mtk`, `Ipa`, `Indo`, `Ing`, `NEM`) VALUES
('IKA', 'bantul', 'Perempuan', 'Bidikmisi', 'jogja, 19 April 2000', 'H:/Temporary/Project/src/assets/icon-profile.png', '08261718281', 8, 7, 6, 7, 28),
('kabalon', 'ngapak', 'Laki - Laki', 'Bidikmisi', 'Jateng, 27 Agustus 2002', 'H:/Temporary/Project/src/assets/icon-profile.png', '085742416711', 8.75, 8.75, 8, 8, 33.5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `User` varchar(50) NOT NULL,
  `PW` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`User`, `PW`) VALUES
('123160777', '123456'),
('123160888', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`Nama`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`User`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
