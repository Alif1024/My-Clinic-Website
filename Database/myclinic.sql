-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2022 at 08:38 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myclinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbadmin`
--

CREATE TABLE `tbadmin` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbadmin`
--

INSERT INTO `tbadmin` (`id`, `email`, `password`) VALUES
(1, 'admin@gmail.com', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `tbmessage`
--

CREATE TABLE `tbmessage` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `message` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbmessage`
--

INSERT INTO `tbmessage` (`id`, `name`, `message`) VALUES
(2, 'Alif', 'Pelayanan cepat bintang 5'),
(3, 'Pito', 'Pelayanan sangat ramah'),
(4, 'Nur', 'Websitenya mudah bagus mudah dipahami');

-- --------------------------------------------------------

--
-- Table structure for table `tbqueue`
--

CREATE TABLE `tbqueue` (
  `Queue Number` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `registrationdate` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbqueue`
--

INSERT INTO `tbqueue` (`Queue Number`, `name`, `gender`, `email`, `phone`, `registrationdate`, `alamat`) VALUES
(1, 'Nur ', 'Male', 'Nur@gmail.com', '0812345678', 'Tue Oct 18 00:00:00 ICT 2022', 'Depok'),
(2, 'Alif', 'Male', 'Alif@gmail.com', '089876443', 'Tue Oct 18 00:00:00 ICT 2022', 'Bojongsari'),
(3, 'Khirahman', 'Male', 'Khirahman@gmail.com', '08129482398', 'Tue Oct 18 00:00:00 ICT 2022', 'Sawangan'),
(4, 'Pito', 'Male', 'Pito@gmail.com', '0823848283', 'Tue Oct 18 00:00:00 ICT 2022', 'Jakarta'),
(6, 'riri', 'female', 'nyoba@gmail.com', '08123932444', 'Tue Oct 18 00:00:00 ICT 2022', 'Depok'),
(7, 'ara', 'female', 'nyoba2@gmail.com', '08123981232', 'Tue Oct 18 00:00:00 ICT 2022', 'Depok'),
(8, 'joni', 'male', 'nyoba3@gmail.com', '08123192381', 'Tue Oct 18 00:00:00 ICT 2022', 'Depok');

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`id`, `email`, `password`) VALUES
(5, 'nuralif@gmail.com', '12345678'),
(6, 'alif@gmail.com', '12345678\r\n'),
(7, 'nur@gmail.com', '12345678'),
(8, 'pitokhirahman@gmail.com', '87654321'),
(9, 'pito@gmail.com', '87654321'),
(10, 'khirahman@gmail.com\r\n', '87654321'),
(12, 'ts@gmail.com', '123456789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbadmin`
--
ALTER TABLE `tbadmin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbmessage`
--
ALTER TABLE `tbmessage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbqueue`
--
ALTER TABLE `tbqueue`
  ADD PRIMARY KEY (`Queue Number`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbadmin`
--
ALTER TABLE `tbadmin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbmessage`
--
ALTER TABLE `tbmessage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbqueue`
--
ALTER TABLE `tbqueue`
  MODIFY `Queue Number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
