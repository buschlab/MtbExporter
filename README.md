# MtbExporter

MtbExporter is a tool that exports therapy recommendations stored in FHIR using [FhirSpark](https://github.com/buschlab/fhirspark) to a csv based file format.
It is tested and optimized to work with the core components of the MIRACUM UseCase 3 *Support for Molecular Tumor Boards*, which are available here:

- [MIRACUM-cBioportal](https://github.com/buschlab/MIRACUM-cBioPortal)
- [MIRACUM-Pipe](https://github.com/AG-Boerries/MIRACUM-Pipe) (v3.0.0 and upwards)
- [MtbImporter](https://github.com/buschlab/MtbImporter)

The data model used for the csv here is just examplary. Your individual environment may vary.

## Get started

To get started, copy the `settings.yaml.example` file to `settings.yaml`. This avoids future conflicts within the git tree. You need to tailor the configuration parameters to fit your environment first. The following configuration parameters are available:

| Parameter                  | Description                                                         |
|----------------------------|---------------------------------------------------------------------|
| outputFolder               | Folder where csv exports will be written to disk                    |
| cronIntervall              | Interval in ms how often the FHIR server is scanned for new reports |
| fhir                       | Configuration for FHIR endpoints                                    |
| fhir.clinicalDataServerUrl | Base of your FHIR server with the MTB recommendations               |

Now MtbExporter can be started. Now it will regularly (based on your cron interval) query the FHIR endpoint for *finalized* therapy recommendations and export them.

## Authors

- Niklas Reimer | [@niklas_reimer](https://twitter.com/niklas_reimer) | [n.reimer@uni-luebeck.de](mailto:n.reimer@uni-luebeck.de)

## License

GNU Affero General Public License v3 (AGPL-3.0)

## Acknowledgment

This work is funded by the German Federal Ministry of Education and Research (BMBF), grant id 01ZZ1802Z (HiGHmed).
We acknowledge the support thorugh both HiGHmed and MIRACUM consortia as part of the Medical Informatics Initiative Germany.