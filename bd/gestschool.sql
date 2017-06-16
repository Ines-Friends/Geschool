-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2017 at 10:24 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gestschool`
--

-- --------------------------------------------------------

--
-- Table structure for table `annee_scolaire`
--

CREATE TABLE IF NOT EXISTS `annee_scolaire` (
  `idannee_scolaire` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  PRIMARY KEY (`idannee_scolaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

CREATE TABLE IF NOT EXISTS `bulletin` (
  `idbulletin` int(11) NOT NULL,
  `appreciation` varchar(45) DEFAULT NULL,
  `note_final` float(2,2) NOT NULL,
  `eleve` int(11) NOT NULL,
  `annee_scolaire` int(11) NOT NULL,
  PRIMARY KEY (`idbulletin`,`eleve`,`annee_scolaire`),
  UNIQUE KEY `eleve` (`eleve`),
  UNIQUE KEY `annee_scolaire` (`annee_scolaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `civilite`
--

CREATE TABLE IF NOT EXISTS `civilite` (
  `idcivilite` int(11) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`idcivilite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `civilite`
--

INSERT INTO `civilite` (`idcivilite`, `libelle`) VALUES
(1, 'Mrs'),
(2, 'Mme'),
(3, 'Mlle');

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `idclasse` int(11) NOT NULL,
  `designation` varchar(45) NOT NULL,
  `nbre_eleve_max` int(11) NOT NULL,
  `nbre_eleve_min` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  PRIMARY KEY (`idclasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `detail_paiement`
--

CREATE TABLE IF NOT EXISTS `detail_paiement` (
  `iddetailpaiement` int(11) NOT NULL AUTO_INCREMENT,
  `montant_paiement` bigint(20) NOT NULL,
  `date_paiement` date NOT NULL,
  `type_paiement` int(11) NOT NULL,
  `inscription` int(11) NOT NULL,
  `annee_scolaire` int(11) NOT NULL,
  PRIMARY KEY (`iddetailpaiement`),
  KEY `annee_scolaire` (`annee_scolaire`),
  KEY `type_paiement` (`type_paiement`),
  KEY `inscription` (`inscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

CREATE TABLE IF NOT EXISTS `eleve` (
  `ideleve` int(11) NOT NULL AUTO_INCREMENT,
  `nom_eleve` varchar(45) NOT NULL,
  `prenom_eleve` varchar(45) NOT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `date_naissance` date NOT NULL,
  `tuteur_eleve` int(11) NOT NULL,
  `statut` int(11) DEFAULT NULL,
  `date_creation` date NOT NULL,
  `date_modification` date DEFAULT NULL,
  PRIMARY KEY (`ideleve`),
  KEY `fk_tuteur_eleve_id` (`tuteur_eleve`),
  KEY `fk_statut_id` (`statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `enseignement`
--

CREATE TABLE IF NOT EXISTS `enseignement` (
  `idenseignement` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenseignement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enseignement`
--

INSERT INTO `enseignement` (`idenseignement`, `libelle`) VALUES
(1, 'Primaire'),
(2, 'Secondaire');

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

CREATE TABLE IF NOT EXISTS `inscription` (
  `idinscription` int(11) NOT NULL AUTO_INCREMENT,
  `frais_inscription` varchar(45) DEFAULT NULL,
  `autre_frais` varchar(45) DEFAULT NULL,
  `date_inscrit` date NOT NULL,
  `eleve` int(11) NOT NULL,
  `classe` int(11) NOT NULL,
  `annee_scolaire` int(11) NOT NULL,
  `statut` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinscription`,`eleve`,`classe`,`annee_scolaire`),
  KEY `eleve` (`eleve`),
  KEY `classe` (`classe`),
  KEY `annee_scolaire` (`annee_scolaire`),
  KEY `statut` (`statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `idmatiere` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `coefficient` int(11) DEFAULT NULL,
  `enseignement` int(11) NOT NULL,
  PRIMARY KEY (`idmatiere`),
  KEY `enseignement` (`enseignement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `idnote` int(11) NOT NULL AUTO_INCREMENT,
  `valeur` float(2,2) NOT NULL,
  `appreciation` varchar(45) DEFAULT NULL,
  `matiere` int(11) NOT NULL,
  `classe` int(11) NOT NULL,
  `eleve` int(11) NOT NULL,
  `annee_scolaire` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `date_modification` date NOT NULL,
  PRIMARY KEY (`idnote`,`eleve`,`matiere`),
  UNIQUE KEY `matiere` (`matiere`),
  UNIQUE KEY `classe` (`classe`),
  UNIQUE KEY `eleve` (`eleve`),
  UNIQUE KEY `annee_scolaire` (`annee_scolaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `idpaiement` int(11) NOT NULL AUTO_INCREMENT,
  `eleve` int(11) NOT NULL,
  `detailpaiement` int(11) NOT NULL,
  `annee_scolaire` int(11) NOT NULL,
  PRIMARY KEY (`idpaiement`),
  KEY `eleve` (`eleve`),
  KEY `detailpaiement` (`detailpaiement`),
  KEY `annee_scolaire` (`annee_scolaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `statut_eleve`
--

CREATE TABLE IF NOT EXISTS `statut_eleve` (
  `idstatut_eleve` int(11) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`idstatut_eleve`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `statut_eleve`
--

INSERT INTO `statut_eleve` (`idstatut_eleve`, `libelle`) VALUES
(1, 'Admis'),
(2, 'Inscrit'),
(3, 'Preinscrit');

-- --------------------------------------------------------

--
-- Table structure for table `statut_inscription`
--

CREATE TABLE IF NOT EXISTS `statut_inscription` (
  `idstatut_inscription` int(11) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`idstatut_inscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `statut_inscription`
--

INSERT INTO `statut_inscription` (`idstatut_inscription`, `libelle`) VALUES
(1, 'En cours'),
(2, 'Termine');

-- --------------------------------------------------------

--
-- Table structure for table `tuteur_eleve`
--

CREATE TABLE IF NOT EXISTS `tuteur_eleve` (
  `idtuteur_eleve` int(11) NOT NULL AUTO_INCREMENT,
  `civilite` int(11) DEFAULT NULL,
  `nom_tuteur` varchar(45) NOT NULL,
  `prenom_tuteur` varchar(45) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `date_modification` date DEFAULT NULL,
  PRIMARY KEY (`idtuteur_eleve`),
  KEY `fk_civilite_id` (`civilite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `type_paiement`
--

CREATE TABLE IF NOT EXISTS `type_paiement` (
  `idtype_paiement` int(11) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  PRIMARY KEY (`idtype_paiement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_paiement`
--

INSERT INTO `type_paiement` (`idtype_paiement`, `libelle`) VALUES
(1, 'Espece'),
(2, 'Carte Bancaire');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idutilisateur` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `date_connexion` date DEFAULT NULL,
  PRIMARY KEY (`idutilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `fk_annee_scolaire_id4` FOREIGN KEY (`annee_scolaire`) REFERENCES `annee_scolaire` (`idannee_scolaire`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_eleve_id4` FOREIGN KEY (`eleve`) REFERENCES `eleve` (`ideleve`) ON UPDATE NO ACTION;

--
-- Constraints for table `detail_paiement`
--
ALTER TABLE `detail_paiement`
  ADD CONSTRAINT `fk_type_paiement_id` FOREIGN KEY (`type_paiement`) REFERENCES `type_paiement` (`idtype_paiement`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_inscription_id` FOREIGN KEY (`inscription`) REFERENCES `inscription` (`idinscription`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_annee_scolaire_id1` FOREIGN KEY (`annee_scolaire`) REFERENCES `annee_scolaire` (`idannee_scolaire`) ON UPDATE CASCADE;

--
-- Constraints for table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `fk_statut_id` FOREIGN KEY (`statut`) REFERENCES `statut_eleve` (`idstatut_eleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tuteur_eleve_id` FOREIGN KEY (`tuteur_eleve`) REFERENCES `tuteur_eleve` (`idtuteur_eleve`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `fk_eleve_status` FOREIGN KEY (`statut`) REFERENCES `statut_inscription` (`idstatut_inscription`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_eleve_id` FOREIGN KEY (`eleve`) REFERENCES `eleve` (`ideleve`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_classe_id` FOREIGN KEY (`classe`) REFERENCES `classe` (`idclasse`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_annee_scolaire_id` FOREIGN KEY (`annee_scolaire`) REFERENCES `annee_scolaire` (`idannee_scolaire`) ON UPDATE NO ACTION;

--
-- Constraints for table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `fk_enseignement_id` FOREIGN KEY (`enseignement`) REFERENCES `enseignement` (`idenseignement`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `fk_annee_scolaire_id3` FOREIGN KEY (`annee_scolaire`) REFERENCES `annee_scolaire` (`idannee_scolaire`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_eleve_id3` FOREIGN KEY (`eleve`) REFERENCES `eleve` (`ideleve`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_matiere_id` FOREIGN KEY (`matiere`) REFERENCES `matiere` (`idmatiere`) ON UPDATE NO ACTION;

--
-- Constraints for table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `fk_eleve_id1` FOREIGN KEY (`eleve`) REFERENCES `eleve` (`ideleve`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detail_paiement_id` FOREIGN KEY (`detailpaiement`) REFERENCES `detail_paiement` (`iddetailpaiement`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_annee_scolaire_id2` FOREIGN KEY (`annee_scolaire`) REFERENCES `annee_scolaire` (`idannee_scolaire`) ON UPDATE NO ACTION;

--
-- Constraints for table `tuteur_eleve`
--
ALTER TABLE `tuteur_eleve`
  ADD CONSTRAINT `fk_civilite_id` FOREIGN KEY (`civilite`) REFERENCES `civilite` (`idcivilite`);

CREATE USER 'gestschool'@'localhost' IDENTIFIED BY 'admin';
GRANT SELECT, INSERT, UPDATE ON gestschool.* TO 'gestschool'@'localhost';
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
