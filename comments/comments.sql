-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2021 at 09:04 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comments`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ip_address` varchar(64) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `user_agent` varchar(256) NOT NULL,
  `comments` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `name`, `email`, `ip_address`, `date`, `user_agent`, `comments`) VALUES
(1, 'test', 'test@test', '127.0.0.1', '0000-00-00 00:00:00', 'Pass/1.0', 'testing comments'),
(2, 'Ahmad Dahlan', 'ahmad@example.com', '127.0.0.1', '2021-07-08 15:50:01', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36', 'hi salam....'),
(3, 'Mohammad Hafiz Ismail', 'hafiz@example.com', '127.0.0.1', '2021-07-08 15:58:13', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36', 'testing comments on home made web api'),
(4, '', '', '192.168.0.128', '2021-07-12 16:15:04', 'Dalvik/2.1.0 (Linux; U; Android 10; Android SDK built for x86 Build/QSR1.190920.001)', ''),
(5, 'sadsa', 'sadsa', '192.168.0.128', '2021-07-12 16:15:11', 'Dalvik/2.1.0 (Linux; U; Android 10; Android SDK built for x86 Build/QSR1.190920.001)', 'sdadg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
