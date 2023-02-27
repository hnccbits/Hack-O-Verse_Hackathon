-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2023 at 04:50 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hackathon`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_info`
--

CREATE TABLE `admin_info` (
  `admin_name` varchar(60) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `admin_password` varchar(255) NOT NULL,
  `admin_image` blob NOT NULL,
  `admin_email` varchar(90) NOT NULL,
  `admin_address` varchar(90) NOT NULL,
  `admin_number` int(20) NOT NULL,
  `admin_dob` date DEFAULT NULL,
  `admin_rank` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_info`
--

INSERT INTO `admin_info` (`admin_name`, `admin_id`, `admin_password`, `admin_image`, `admin_email`, `admin_address`, `admin_number`, `admin_dob`, `admin_rank`) VALUES
('Anshu', 20231, '12345', '', 'admin@gmail.com', 'lal bangla more ,dhanbad', 0, NULL, NULL),
('vortex', 20234, '$2y$10$oAqyaIR7zeOxHFVs3.RK7OprqcMpUcnO9IRLxMRGSyny9VZre.bxO', '', 'sfasdgffhg.@gmail.com', 'parallel space', 2147483647, '2023-02-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `faculty_info`
--

CREATE TABLE `faculty_info` (
  `faculty_name` text NOT NULL,
  `faculty_id` int(11) NOT NULL,
  `faculty_password` varchar(255) NOT NULL,
  `faculty_image` blob NOT NULL,
  `faculty_address` varchar(90) NOT NULL,
  `faculty_number` int(12) NOT NULL,
  `faculty_email` varchar(50) NOT NULL,
  `faculty_subject` varchar(20) NOT NULL,
  `faculty_dob` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `faculty_info`
--

INSERT INTO `faculty_info` (`faculty_name`, `faculty_id`, `faculty_password`, `faculty_image`, `faculty_address`, `faculty_number`, `faculty_email`, `faculty_subject`, `faculty_dob`) VALUES
('anshu', 1, 'vortex', '', 'jcjhcsajdaidckljcads', 987456321, 'dsifgdsfw@gmail.com', 'maths', '2023-02-27'),
('vaishwanavi', 2, '$2y$10$ooOBvFT0j9JuRN565o.4juAoESvRQaIvUsOONGYuL5.BWJfkVWpu2', '', 'bokaro', 2147483647, 'sfasdgffhg.@gmail.com', 'maths', '2023-02-18');

-- --------------------------------------------------------

--
-- Table structure for table `notices`
--

CREATE TABLE `notices` (
  `notice_id` int(11) NOT NULL,
  `notice_description` varchar(255) NOT NULL,
  `notice_date` date NOT NULL DEFAULT current_timestamp(),
  `notice_category` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notices`
--

INSERT INTO `notices` (`notice_id`, `notice_description`, `notice_date`, `notice_category`) VALUES
(3, 'come to it building at 10 pm', '2023-02-27', 'students'),
(4, 'bdcsbcjdbcjadhshjxhdasdjvvckncjxncsjhfdjljclkxzjckldshdfhewidedefjxkljckldjfkldjlfjw', '2023-02-27', 'teachers'),
(5, 'fgdshfuhdncmxnchshrioudiasojdkfdhfjkbejkdjfioiopdsioeifjdkjcklncdjfkejdfejf', '2023-02-27', 'admins'),
(6, 'jhvsiwef[dsmvklcvskf[pewof[pvlcvlcmvmflkfovkclkvldskfefopfovkfkvlfkv', '2023-02-27', 'students');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE `student_info` (
  `student_name` text NOT NULL,
  `student_id` int(8) NOT NULL,
  `student_password` varchar(255) NOT NULL,
  `student_dob` date NOT NULL,
  `student_branch` varchar(30) NOT NULL,
  `student_email` varchar(50) NOT NULL,
  `student_number` varchar(15) NOT NULL,
  `student_address` varchar(100) NOT NULL,
  `student_father` varchar(50) NOT NULL,
  `student_mother` varchar(50) NOT NULL,
  `father_number` varchar(15) NOT NULL,
  `mother_number` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`student_name`, `student_id`, `student_password`, `student_dob`, `student_branch`, `student_email`, `student_number`, `student_address`, `student_father`, `student_mother`, `father_number`, `mother_number`) VALUES
('anshu', 1, 'anshu', '2023-02-01', '', 'anshu@gmail.com', '9919298383', 'lal bangla dhanbad', 'ashok ', 'sapna', '6789012345', '7890123456'),
('Anshu kumar Mandal', 2, 'student1', '2003-01-08', '', 'sfasdgffhg.@gmail.com', '9087654321', 'lal bangla more', 'Ashok kumar mandal ', 'Sapna devi', '8097654321', 'Sapna devi'),
('amaan hussain', 3, '$2y$10$251enRnJrypWALKVTx64PerirE20uHtxT1if2hBy6VX/9yBYnZ2Rm', '2023-02-03', '', 'hshcshufhadhhczj@gmail.com', '9087654321', 'bokaro', 'xyz ', 'yshdh', '8097654321', 'yshdh'),
('Anu kumari', 4, '$2y$10$S9RiHG9UKKH9PyxL1i6goehxG2NkwMpmMo6gPiWfQbNu3yRB1onO6', '2016-02-02', 'Computer Science', 'anu@gmail.com', '9087654321', 'jamshedpur', 'xyz ', 'abc', '8097654321', 'abc'),
('Raj kumar', 5, '$2y$10$iTiJD3tPb3Vr8pVyNMntzunP5eazb6ZO94rJzlvCdW3aCnSn4b2cC', '1998-01-01', 'Computer Science', 'raj@gmail.com', '5632147890', 'dhanbad', 'rty ', 'yui', '7418529630', 'yui'),
('Pihu  kumari', 6, '$2y$10$jWrkEiGGrKQJVAmmPcE8kuM4rs7P0pjZNkp9VxyXvlnJ3hYquE3uq', '2020-07-08', 'Electronics and Communication ', 'pihu@789', '4017258369', 'tundi', 'poi ', 'iok', '0123654789', 'iok'),
('Isha kumari', 7, '$2y$10$3s47gzTZn6cxmC1N3zjJReAfktvAcLqh964klPaFVI3UXECpaPjiu', '2014-06-05', 'Mechanical Engineering', 'isha@gmail.com', '2013654789', 'ranchi', 'iou ', 'rtg', '8523691470', 'rtg'),
('Pappu yadav', 8, '$2y$10$IcKEtunGmzOGuVW.deKGmuL7uqyB.5wgROxY.CNiFWZdQ2udXAgPS', '2008-02-07', 'Chemical Engineering', 'pappu@gmail.com', '9063251478', 'bokaro', 'vgh ', 'jhg', '2031564789', 'jhg'),
('Ansh kumar', 9, '$2y$10$1Qqs7w3Sn4q4w2.0rB7AtuKzBN70rtEIDL83Y.FULDpd5wlWBejEe', '2015-06-10', 'Civil Engineering', 'ansh@gmail.com', '5023698741', 'jasidih', 'wsx ', 'esz', '3025614789', 'esz');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_info`
--
ALTER TABLE `admin_info`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `faculty_info`
--
ALTER TABLE `faculty_info`
  ADD PRIMARY KEY (`faculty_id`);

--
-- Indexes for table `notices`
--
ALTER TABLE `notices`
  ADD PRIMARY KEY (`notice_id`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_info`
--
ALTER TABLE `admin_info`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20235;

--
-- AUTO_INCREMENT for table `faculty_info`
--
ALTER TABLE `faculty_info`
  MODIFY `faculty_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `notices`
--
ALTER TABLE `notices`
  MODIFY `notice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `student_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
