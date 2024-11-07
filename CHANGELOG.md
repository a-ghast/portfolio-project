# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.


## [2024.09.12]

### Added

- Added brainstorm of patientPanel kernel and secondary methods
- Added brainstorm of conlangFamily kernel and secondary methods
- Added brainstorm of tibble kernel and secondary methods.

### Changed


### Fixed


### Removed

## [2024.10.02]

### Added

- ProofOfConcept implementation of kernel methods.

### Changed

- Uses ArrayList instead of Sequence for visit dates.
- removePatient() returns the entire patient object instead of just the PCP
### Fixed


### Removed

## [2024.10.15]

### Added

- Interfaces for Patient, PatientPanel, and PatientPanelKernel. I tried to nest Patient inside PatientPanel Kernel but it wouldn't resolve it in PatientPanel, so I made it a separate file. I realize that probably means I'll have to implement it in its own file later, too.

### Changed
- ProofOfConcept made into PatientPanel1 with main method as starter for kernel implementation.

### Fixed
- Patient internal class in PatientPanel1 wasn't constructing the dates field, so I added it.

### Removed

## [2024.10.30]

### Added

- PatientPanelSecondary with implementations for secondary methods
- New kernel methods: containsPatient(), addPatient(Patient), and removeAny()
- Patient1 class implementation of Patient interface--removed Patient subclass from PatientPanel1

### Changed

### Fixed

### Removed
- Patient subclass in PatientPanel1
