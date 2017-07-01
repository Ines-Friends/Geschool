-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 01 Juillet 2017 à 14:08
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gestschool_nyobe`
--

-- --------------------------------------------------------

--
-- Structure de la table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `idAttendance` int(11) NOT NULL,
  `dateAbsenceJournee` date DEFAULT NULL,
  `heureDebut` datetime DEFAULT NULL,
  `heureFin` datetime DEFAULT NULL,
  `periode` int(11) DEFAULT NULL,
  `StatutAttendance_idStatutAttendance` int(11) NOT NULL,
  `SuiviSessionClasseEleve_idSuiviSessionClasseEleve` int(11) NOT NULL,
  `SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere` int(11) NOT NULL,
  PRIMARY KEY (`idAttendance`),
  KEY `fk_Attendance_StatutAttendance1_idx` (`StatutAttendance_idStatutAttendance`),
  KEY `fk_Attendance_SuiviSessionClasseEleve1_idx` (`SuiviSessionClasseEleve_idSuiviSessionClasseEleve`),
  KEY `fk_Attendance_SuiviSessionClasseMatiere1_idx` (`SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `idClasse` varchar(10) NOT NULL,
  `dateCreationClasse` date DEFAULT NULL,
  `nombreEleveMax` int(11) DEFAULT '100',
  PRIMARY KEY (`idClasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `detailversementtranche1`
--

CREATE TABLE IF NOT EXISTS `detailversementtranche1` (
  `idDetailVersementTranche1` int(11) NOT NULL,
  `montantVersement` int(11) DEFAULT NULL,
  `ModePaiement_idModePaiement` int(11) NOT NULL,
  `Tranche1_idTranche1` int(11) NOT NULL,
  PRIMARY KEY (`idDetailVersementTranche1`),
  KEY `fk_DetailVersementTranche1_ModePaiement1_idx` (`ModePaiement_idModePaiement`),
  KEY `fk_DetailVersementTranche1_Tranche11_idx` (`Tranche1_idTranche1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `detailversementtranche2`
--

CREATE TABLE IF NOT EXISTS `detailversementtranche2` (
  `idDetailVersementTranche2` int(11) NOT NULL,
  `montantVersement` int(11) DEFAULT NULL,
  `ModePaiement_idModePaiement` int(11) NOT NULL,
  `Tranche2_idTranche2` int(11) NOT NULL,
  PRIMARY KEY (`idDetailVersementTranche2`),
  KEY `fk_DetailVersementTranche1_ModePaiement1_idx` (`ModePaiement_idModePaiement`),
  KEY `fk_DetailVersementTranche2_Tranche21_idx` (`Tranche2_idTranche2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `detailversementtranche3`
--

CREATE TABLE IF NOT EXISTS `detailversementtranche3` (
  `idDetailVersementTranche3` int(11) NOT NULL,
  `montantVersement` int(11) DEFAULT NULL,
  `ModePaiement_idModePaiement` int(11) NOT NULL,
  `Tranche3_idTranche3` int(11) NOT NULL,
  PRIMARY KEY (`idDetailVersementTranche3`),
  KEY `fk_DetailVersementTranche1_ModePaiement1_idx` (`ModePaiement_idModePaiement`),
  KEY `fk_DetailVersementTranche3_Tranche31_idx` (`Tranche3_idTranche3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE IF NOT EXISTS `eleve` (
  `idEleve` int(11) NOT NULL,
  `nomEleve` varchar(260) NOT NULL,
  `prenomEleve` varchar(260) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `adresse` varchar(520) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `dateCreation` date NOT NULL,
  `dateModification` date NOT NULL,
  `Sexe_idSexe` int(11) NOT NULL,
  PRIMARY KEY (`idEleve`),
  KEY `fk_Eleve_Sexe1_idx` (`Sexe_idSexe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `emploidutemps`
--

CREATE TABLE IF NOT EXISTS `emploidutemps` (
  `idEmploiDuTemps` int(11) NOT NULL,
  `dateEmploiDuTemps` date DEFAULT NULL,
  `heureDebut` datetime DEFAULT NULL,
  `heureFin` datetime DEFAULT NULL,
  `commentaire` text,
  `SessionTrimestre_idSessionTrimestre` int(11) NOT NULL,
  `SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere` int(11) NOT NULL,
  PRIMARY KEY (`idEmploiDuTemps`),
  KEY `fk_EmploiDuTemps_SessionTrimestre1_idx` (`SessionTrimestre_idSessionTrimestre`),
  KEY `fk_EmploiDuTemps_SuiviSessionClasseMatiere1_idx` (`SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE IF NOT EXISTS `enseignant` (
  `idEnseignant` int(11) NOT NULL,
  `nomEnseignant` varchar(255) DEFAULT NULL,
  `prenomEnseignant` varchar(255) DEFAULT NULL,
  `adresse` varchar(260) DEFAULT NULL,
  `telephone1` varchar(45) DEFAULT NULL,
  `telephone2` varchar(45) DEFAULT NULL,
  `dateCreation` date NOT NULL,
  `dateModification` date NOT NULL,
  `Sexe_idSexe` int(11) NOT NULL,
  PRIMARY KEY (`idEnseignant`),
  KEY `fk_Enseignant_Sexe1_idx` (`Sexe_idSexe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE IF NOT EXISTS `evaluation` (
  `idEvaluation` int(11) NOT NULL,
  `libelleEvaluation` varchar(255) DEFAULT NULL,
  `note` int(11) NOT NULL,
  `coefficientEvaluation` int(11) NOT NULL,
  `noteCoefficiee` int(11) NOT NULL,
  `plafondCoefficiant` int(11) NOT NULL,
  `Examen_idExamen` int(11) NOT NULL,
  PRIMARY KEY (`idEvaluation`),
  KEY `fk_Evaluation_Examen1_idx` (`Examen_idExamen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `idExamen` int(11) NOT NULL,
  `libelleExamen` varchar(255) NOT NULL,
  `dateExamen` date DEFAULT NULL,
  `heureDebut` datetime DEFAULT NULL,
  `heureFin` datetime DEFAULT NULL,
  `TypeExamen_idTypeExamen` int(11) NOT NULL,
  `SessionTrimestre_idSessionTrimestre` int(11) NOT NULL,
  `SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere` int(11) NOT NULL,
  `SessionEnseignant_idSessionEnseignant` int(11) NOT NULL,
  PRIMARY KEY (`idExamen`),
  KEY `fk_Examen_TypeExamen1_idx` (`TypeExamen_idTypeExamen`),
  KEY `fk_Examen_SessionTrimestre1_idx` (`SessionTrimestre_idSessionTrimestre`),
  KEY `fk_Examen_SuiviSessionClasseMatiere1_idx` (`SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere`),
  KEY `fk_Examen_SessionEnseignant1_idx` (`SessionEnseignant_idSessionEnseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupeutilisateur`
--

CREATE TABLE IF NOT EXISTS `groupeutilisateur` (
  `idGroupeUtilisateur` int(11) NOT NULL,
  `libelleGroupeUtilisateur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idGroupeUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE IF NOT EXISTS `inscription` (
  `idInscription` int(11) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `Tranche1Ok` int(11) DEFAULT NULL,
  `Tranche2Ok` int(11) DEFAULT NULL,
  `Tranche3Ok` int(11) DEFAULT NULL,
  `SuiviParametrageInscription_idSuiviParametrageInscription` int(11) NOT NULL,
  `SuiviSessionClasseEleve_Eleve_idEleve` int(11) NOT NULL,
  PRIMARY KEY (`idInscription`),
  KEY `fk_Inscription_SuiviSessionClasseEleve1_idx` (`SuiviSessionClasseEleve_Eleve_idEleve`),
  KEY `fk_Inscription_SuiviParametrageInscription1_idx` (`SuiviParametrageInscription_idSuiviParametrageInscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `idMatiere` int(11) NOT NULL,
  `libelleMatiere` varchar(260) NOT NULL,
  `sigleMatiere` varchar(260) DEFAULT NULL,
  PRIMARY KEY (`idMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `modepaiement`
--

CREATE TABLE IF NOT EXISTS `modepaiement` (
  `idModePaiement` int(11) NOT NULL,
  `libelleModePaiement` varchar(45) NOT NULL,
  `actif` int(11) DEFAULT '1',
  PRIMARY KEY (`idModePaiement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `parent`
--

CREATE TABLE IF NOT EXISTS `parent` (
  `idParent` int(11) NOT NULL,
  `nomParent` varchar(260) NOT NULL,
  `prenomParent` varchar(260) DEFAULT NULL,
  `adresse` varchar(260) DEFAULT NULL,
  `telephone1` varchar(45) DEFAULT NULL,
  `telephone2` varchar(45) DEFAULT NULL,
  `telephone3` varchar(45) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `dateModification` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `Profession_idProfession` int(11) NOT NULL,
  `Sexe_idSexe` int(11) NOT NULL,
  PRIMARY KEY (`idParent`),
  KEY `fk_Parent_Profession1_idx` (`Profession_idProfession`),
  KEY `fk_Parent_Sexe1_idx` (`Sexe_idSexe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `idPermission` int(11) NOT NULL,
  `motif` varchar(520) DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `heureDebut` datetime DEFAULT NULL,
  `heureFin` datetime DEFAULT NULL,
  `nombreJours` int(11) DEFAULT NULL,
  `nombreHeures` int(11) DEFAULT NULL,
  `SuiviSessionClasseEleve_idSuiviSessionClasseEleve` int(11) NOT NULL,
  PRIMARY KEY (`idPermission`),
  KEY `fk_Permission_SuiviSessionClasseEleve1_idx` (`SuiviSessionClasseEleve_idSuiviSessionClasseEleve`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `profession`
--

CREATE TABLE IF NOT EXISTS `profession` (
  `idProfession` int(11) NOT NULL,
  `libelleProfession` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProfession`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE IF NOT EXISTS `session` (
  `idSession` varchar(45) NOT NULL,
  `anneeDebut` int(11) NOT NULL,
  `anneFin` int(11) NOT NULL,
  `dateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `actif` int(11) DEFAULT '1',
  PRIMARY KEY (`idSession`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sessionclasse`
--

CREATE TABLE IF NOT EXISTS `sessionclasse` (
  `idSessionClasse` int(11) NOT NULL,
  `Classe_idClasse` varchar(10) NOT NULL,
  `Session_idSession` varchar(45) NOT NULL,
  PRIMARY KEY (`idSessionClasse`),
  KEY `fk_SessionClasse_Session1_idx` (`Session_idSession`),
  KEY `fk_SessionClasse_Classe1` (`Classe_idClasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sessionenseignant`
--

CREATE TABLE IF NOT EXISTS `sessionenseignant` (
  `idSessionEnseignant` int(11) NOT NULL,
  `Session_idSession` varchar(45) NOT NULL,
  `Enseignant_idEnseignant` int(11) NOT NULL,
  `actif` int(11) DEFAULT '1',
  PRIMARY KEY (`idSessionEnseignant`),
  KEY `fk_Session_has_Enseignant_Enseignant1_idx` (`Enseignant_idEnseignant`),
  KEY `fk_Session_has_Enseignant_Session1_idx` (`Session_idSession`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sessiontrimestre`
--

CREATE TABLE IF NOT EXISTS `sessiontrimestre` (
  `idSessionTrimestre` int(11) NOT NULL,
  `Trimestre_idTrimestre` int(11) NOT NULL,
  `Session_idSession` varchar(45) NOT NULL,
  `actif` int(11) DEFAULT '1',
  PRIMARY KEY (`idSessionTrimestre`),
  KEY `fk_SessionTrimestre_Session1_idx` (`Session_idSession`),
  KEY `fk_SessionTrimestre_Trimestre1` (`Trimestre_idTrimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sexe`
--

CREATE TABLE IF NOT EXISTS `sexe` (
  `idSexe` int(11) NOT NULL,
  `libelleSexe` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSexe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `statutattendance`
--

CREATE TABLE IF NOT EXISTS `statutattendance` (
  `idStatutAttendance` int(11) NOT NULL,
  `libelleStatutAttendance` varchar(255) DEFAULT NULL,
  `actif` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStatutAttendance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `statuteleve`
--

CREATE TABLE IF NOT EXISTS `statuteleve` (
  `idStatutEleve` int(11) NOT NULL,
  `libelleStatutEleve` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStatutEleve`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `suiviparametrageinscription`
--

CREATE TABLE IF NOT EXISTS `suiviparametrageinscription` (
  `idSuiviParametrageInscription` int(11) NOT NULL,
  `montantTranche1` int(11) DEFAULT NULL,
  `montantTranche2` int(11) DEFAULT NULL,
  `montantTranche3` int(11) DEFAULT NULL,
  `montantTotal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSuiviParametrageInscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `suivisessionclasseeleve`
--

CREATE TABLE IF NOT EXISTS `suivisessionclasseeleve` (
  `idSuiviSessionClasseEleve` int(11) NOT NULL,
  `dateSuiviSessionClasseEleve` date NOT NULL,
  `ordreRangement` int(11) NOT NULL DEFAULT '1',
  `SessionClasse_idSessionClasse` int(11) NOT NULL,
  `Eleve_idEleve` int(11) NOT NULL,
  PRIMARY KEY (`idSuiviSessionClasseEleve`),
  KEY `fk_SuiviSessionClasseEleve_Eleve1_idx` (`Eleve_idEleve`),
  KEY `fk_SuiviSessionClasseEleve_SessionClasse1_idx` (`SessionClasse_idSessionClasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `suivisessionclassematiere`
--

CREATE TABLE IF NOT EXISTS `suivisessionclassematiere` (
  `idSuiviSessionClasseMatiere` int(11) NOT NULL,
  `Matiere_idMatiere` int(11) NOT NULL,
  `SessionClasse_idSessionClasse` int(11) NOT NULL,
  `SessionEnseignant_idSessionEnseignant` int(11) NOT NULL,
  PRIMARY KEY (`idSuiviSessionClasseMatiere`),
  KEY `fk_SuiviSessionClasseMatiere_SessionEnseignant1_idx` (`SessionEnseignant_idSessionEnseignant`),
  KEY `fk_SuiviSessionClasseMatiere_SessionClasse1_idx` (`SessionClasse_idSessionClasse`),
  KEY `fk_SuiviSessionClasseMatiere_Matiere1` (`Matiere_idMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `suivistatuteleve`
--

CREATE TABLE IF NOT EXISTS `suivistatuteleve` (
  `idSuiviStatutEleve` int(11) NOT NULL,
  `StatutEleve_idStatutEleve` int(11) NOT NULL,
  `Utilisateur_idUtilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idSuiviStatutEleve`),
  KEY `fk_SuiviStatutEleve_StatutEleve1_idx` (`StatutEleve_idStatutEleve`),
  KEY `fk_SuiviStatutEleve_Utilisateur1_idx` (`Utilisateur_idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tranche1`
--

CREATE TABLE IF NOT EXISTS `tranche1` (
  `idTranche1` int(11) NOT NULL,
  `montantTranche1` int(11) DEFAULT NULL,
  `TotalVerseTranche1` int(11) DEFAULT NULL,
  `Tranche1Ok` int(11) DEFAULT NULL,
  `Inscription_idInscription` int(11) NOT NULL,
  PRIMARY KEY (`idTranche1`),
  KEY `fk_Tranche1_Inscription1_idx` (`Inscription_idInscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tranche2`
--

CREATE TABLE IF NOT EXISTS `tranche2` (
  `idTranche2` int(11) NOT NULL,
  `montantTranche2` int(11) DEFAULT NULL,
  `TotalVerseTranche2` int(11) DEFAULT NULL,
  `Tranche2Ok` int(11) DEFAULT NULL,
  `Inscription_idInscription` int(11) NOT NULL,
  PRIMARY KEY (`idTranche2`),
  KEY `fk_Tranche2_Inscription1_idx` (`Inscription_idInscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tranche3`
--

CREATE TABLE IF NOT EXISTS `tranche3` (
  `idTranche3` int(11) NOT NULL,
  `montantTranche3` int(11) DEFAULT NULL,
  `TotalVerseTranche3` int(11) DEFAULT NULL,
  `Tranche3Ok` int(11) DEFAULT NULL,
  `Inscription_idInscription` int(11) NOT NULL,
  PRIMARY KEY (`idTranche3`),
  KEY `fk_Tranche3_Inscription1_idx` (`Inscription_idInscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

CREATE TABLE IF NOT EXISTS `trimestre` (
  `idTrimestre` int(11) NOT NULL,
  `libelleTrimestre` varchar(260) NOT NULL,
  `sigleTrimestre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTrimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `typeexamen`
--

CREATE TABLE IF NOT EXISTS `typeexamen` (
  `idTypeExamen` int(11) NOT NULL,
  `libelleTypeExamen` varchar(255) DEFAULT NULL,
  `actif` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTypeExamen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nomUtilisateur` varchar(520) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(256) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `etatConnexion` int(11) DEFAULT '1',
  `GroupeUtilisateur_idGroupeUtilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_Utilisateur_GroupeUtilisateur_idx` (`GroupeUtilisateur_idGroupeUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `fk_Attendance_StatutAttendance1` FOREIGN KEY (`StatutAttendance_idStatutAttendance`) REFERENCES `statutattendance` (`idStatutAttendance`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Attendance_SuiviSessionClasseEleve1` FOREIGN KEY (`SuiviSessionClasseEleve_idSuiviSessionClasseEleve`) REFERENCES `suivisessionclasseeleve` (`idSuiviSessionClasseEleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Attendance_SuiviSessionClasseMatiere1` FOREIGN KEY (`SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere`) REFERENCES `suivisessionclassematiere` (`idSuiviSessionClasseMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `detailversementtranche1`
--
ALTER TABLE `detailversementtranche1`
  ADD CONSTRAINT `fk_DetailVersementTranche1_ModePaiement1` FOREIGN KEY (`ModePaiement_idModePaiement`) REFERENCES `modepaiement` (`idModePaiement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetailVersementTranche1_Tranche11` FOREIGN KEY (`Tranche1_idTranche1`) REFERENCES `tranche1` (`idTranche1`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `detailversementtranche2`
--
ALTER TABLE `detailversementtranche2`
  ADD CONSTRAINT `fk_DetailVersementTranche1_ModePaiement10` FOREIGN KEY (`ModePaiement_idModePaiement`) REFERENCES `modepaiement` (`idModePaiement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetailVersementTranche2_Tranche21` FOREIGN KEY (`Tranche2_idTranche2`) REFERENCES `tranche2` (`idTranche2`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `detailversementtranche3`
--
ALTER TABLE `detailversementtranche3`
  ADD CONSTRAINT `fk_DetailVersementTranche1_ModePaiement100` FOREIGN KEY (`ModePaiement_idModePaiement`) REFERENCES `modepaiement` (`idModePaiement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_DetailVersementTranche3_Tranche31` FOREIGN KEY (`Tranche3_idTranche3`) REFERENCES `tranche3` (`idTranche3`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `fk_Eleve_Sexe1` FOREIGN KEY (`Sexe_idSexe`) REFERENCES `sexe` (`idSexe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `emploidutemps`
--
ALTER TABLE `emploidutemps`
  ADD CONSTRAINT `fk_EmploiDuTemps_SessionTrimestre1` FOREIGN KEY (`SessionTrimestre_idSessionTrimestre`) REFERENCES `sessiontrimestre` (`idSessionTrimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_EmploiDuTemps_SuiviSessionClasseMatiere1` FOREIGN KEY (`SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere`) REFERENCES `suivisessionclassematiere` (`idSuiviSessionClasseMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `fk_Enseignant_Sexe1` FOREIGN KEY (`Sexe_idSexe`) REFERENCES `sexe` (`idSexe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `fk_Evaluation_Examen1` FOREIGN KEY (`Examen_idExamen`) REFERENCES `examen` (`idExamen`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `fk_Examen_TypeExamen1` FOREIGN KEY (`TypeExamen_idTypeExamen`) REFERENCES `typeexamen` (`idTypeExamen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Examen_SessionTrimestre1` FOREIGN KEY (`SessionTrimestre_idSessionTrimestre`) REFERENCES `sessiontrimestre` (`idSessionTrimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Examen_SuiviSessionClasseMatiere1` FOREIGN KEY (`SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere`) REFERENCES `suivisessionclassematiere` (`idSuiviSessionClasseMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Examen_SessionEnseignant1` FOREIGN KEY (`SessionEnseignant_idSessionEnseignant`) REFERENCES `sessionenseignant` (`idSessionEnseignant`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `fk_Inscription_SuiviSessionClasseEleve1` FOREIGN KEY (`SuiviSessionClasseEleve_Eleve_idEleve`) REFERENCES `suivisessionclasseeleve` (`Eleve_idEleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Inscription_SuiviParametrageInscription1` FOREIGN KEY (`SuiviParametrageInscription_idSuiviParametrageInscription`) REFERENCES `suiviparametrageinscription` (`idSuiviParametrageInscription`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `parent`
--
ALTER TABLE `parent`
  ADD CONSTRAINT `fk_Parent_Profession1` FOREIGN KEY (`Profession_idProfession`) REFERENCES `profession` (`idProfession`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Parent_Sexe1` FOREIGN KEY (`Sexe_idSexe`) REFERENCES `sexe` (`idSexe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `permission`
--
ALTER TABLE `permission`
  ADD CONSTRAINT `fk_Permission_SuiviSessionClasseEleve1` FOREIGN KEY (`SuiviSessionClasseEleve_idSuiviSessionClasseEleve`) REFERENCES `suivisessionclasseeleve` (`idSuiviSessionClasseEleve`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sessionclasse`
--
ALTER TABLE `sessionclasse`
  ADD CONSTRAINT `fk_SessionClasse_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SessionClasse_Session1` FOREIGN KEY (`Session_idSession`) REFERENCES `session` (`idSession`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sessionenseignant`
--
ALTER TABLE `sessionenseignant`
  ADD CONSTRAINT `fk_Session_has_Enseignant_Session1` FOREIGN KEY (`Session_idSession`) REFERENCES `session` (`idSession`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Session_has_Enseignant_Enseignant1` FOREIGN KEY (`Enseignant_idEnseignant`) REFERENCES `enseignant` (`idEnseignant`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sessiontrimestre`
--
ALTER TABLE `sessiontrimestre`
  ADD CONSTRAINT `fk_SessionTrimestre_Trimestre1` FOREIGN KEY (`Trimestre_idTrimestre`) REFERENCES `trimestre` (`idTrimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SessionTrimestre_Session1` FOREIGN KEY (`Session_idSession`) REFERENCES `session` (`idSession`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `suivisessionclasseeleve`
--
ALTER TABLE `suivisessionclasseeleve`
  ADD CONSTRAINT `fk_SuiviSessionClasseEleve_Eleve1` FOREIGN KEY (`Eleve_idEleve`) REFERENCES `eleve` (`idEleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SuiviSessionClasseEleve_SessionClasse1` FOREIGN KEY (`SessionClasse_idSessionClasse`) REFERENCES `sessionclasse` (`idSessionClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `suivisessionclassematiere`
--
ALTER TABLE `suivisessionclassematiere`
  ADD CONSTRAINT `fk_SuiviSessionClasseMatiere_Matiere1` FOREIGN KEY (`Matiere_idMatiere`) REFERENCES `matiere` (`idMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SuiviSessionClasseMatiere_SessionEnseignant1` FOREIGN KEY (`SessionEnseignant_idSessionEnseignant`) REFERENCES `sessionenseignant` (`idSessionEnseignant`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SuiviSessionClasseMatiere_SessionClasse1` FOREIGN KEY (`SessionClasse_idSessionClasse`) REFERENCES `sessionclasse` (`idSessionClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `suivistatuteleve`
--
ALTER TABLE `suivistatuteleve`
  ADD CONSTRAINT `fk_SuiviStatutEleve_StatutEleve1` FOREIGN KEY (`StatutEleve_idStatutEleve`) REFERENCES `statuteleve` (`idStatutEleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SuiviStatutEleve_Utilisateur1` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `tranche1`
--
ALTER TABLE `tranche1`
  ADD CONSTRAINT `fk_Tranche1_Inscription1` FOREIGN KEY (`Inscription_idInscription`) REFERENCES `inscription` (`idInscription`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `tranche2`
--
ALTER TABLE `tranche2`
  ADD CONSTRAINT `fk_Tranche2_Inscription1` FOREIGN KEY (`Inscription_idInscription`) REFERENCES `inscription` (`idInscription`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `tranche3`
--
ALTER TABLE `tranche3`
  ADD CONSTRAINT `fk_Tranche3_Inscription1` FOREIGN KEY (`Inscription_idInscription`) REFERENCES `inscription` (`idInscription`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_Utilisateur_GroupeUtilisateur` FOREIGN KEY (`GroupeUtilisateur_idGroupeUtilisateur`) REFERENCES `groupeutilisateur` (`idGroupeUtilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
