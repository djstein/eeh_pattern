# Enterprise Exception Handler
Contributions to the IBM EEH Pattern Project during Senior Design coursework at North Carolina State University

[IBM Services Assets Wiki Entry](https://www.ibm.com/developerworks/community/wikis/home?lang=en#!/wiki/0571da3f-2daa-4152-b791-11fb38aedd2e)

## Presentation and Demo on YouTube
[![Presentation and Demo on YouTube](http://img.youtube.com/vi/GNmirzBray0/0.jpg)](https://www.youtube.com/watch?v=GNmirzBray0 "Open Table EEH Pattern Open Project")

## Why
All applications use exception handling as part of the code to harden runtime anomalies. The reporting of exceptions should be consistent based on a finite catalog for analysis of these anomalies and the troubleshooting of these errors. The framework provides a standard for handling and reporting exceptions independent of application language or platform. To facilitate the implementation of the specification, the asset provides a Java API and other extensions for products. An extensible daemon framework and tools are also packaged with EEH.

## Who
Solution Architects benefit from a readily available, standard proven pattern to implement organization-wide

Developers benefit from the simple API implementation

System Administrators benefit from the centralization of all exceptions making troubleshooting easy

## How
The application uses the Exception Catalog for the organization and generates exceptions. Multiple catalogs can be set up as well. The application then uses the EEH API to send exceptions to a queue for being routed to a centralized location where the EEH Daemon stores it in the database. The catalog is also loaded into the database for referential integrity of the system. 
