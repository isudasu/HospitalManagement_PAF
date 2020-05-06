-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 11:08 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `health_care_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospitalregister`
--

CREATE TABLE `hospitalregister` (
  `Hid` int(12) NOT NULL,
  `companyName` varchar(100) NOT NULL,
  `contact` int(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `services` varchar(300) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospitalregister`
--

INSERT INTO `hospitalregister` (`Hid`, `companyName`, `contact`, `email`, `address`, `services`, `userName`, `password`) VALUES
(1, 'Kottawa Nursing Home', 112383455, 'kottawaN@gmail.com', 'horana rd, kottawa', 'e-channeling and ECG scanning and FBT', 'Dimuth', 'dimuth123'),
(2, 'Lanka Hospital', 711111111, 'LH@gmail.com', 'No 234, Maharagama', 'E-channeling', 'samanmalee', 'samanmalee123'),
(4, 'National Hospital of Sri Lanka', 112691111, 'nhsl@gmail.com', 'colombo 00700', 'E-channeling , MRI & CT scan , dental ', 'Nimal', 'Nimal876'),
(11, 'Asiri Hospitals', 772399823, 'Asiri@gmail.com', 'Colombo 07', 'E-channeling, FBT and annual checkups', 'Nayana', 'nayana123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospitalregister`
--
ALTER TABLE `hospitalregister`
  ADD PRIMARY KEY (`Hid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospitalregister`
--
ALTER TABLE `hospitalregister`
  MODIFY `Hid` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
