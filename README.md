# Rules
- [x] Use GitHub to upload the project.
- Project create with clear purpose suer posts
- README file added to describe purpose, technologies and architecture used
- Included gitignore file target for Android/Kotlin to prevent unnecessary files from being tracked.
- [x] Follow an architecture and programming principles.
- MVVM, Kotlin Android project, the MVVM (Model-View-ViewModel) architecture was used as its ideal for separation of concerns, particularly when working with Flows
- Clean Architecture layers to separate domain logic from data handling and UI, usage of model to not over engineer the project with DTO
- Presentation Layer: ViewModel uses Kotlin Flows to handle data streams from API
- Domain Layer: usage of Viewmodel to not over engineer the project with usecase
- Data Layer: Repositories to manage data sources (API, local DB), usage of model to not over engineer the project with repository

# Pointers
- [x] Avoid static variables and hardcoded data.
- No use of static / companion variables / objects
- Storing state or configuration data handling
- store resources in string.xml and dimens.xml
- [x] Follow naming convention.
- Used Kotlin camelCase for variables and functions, PascalCase for classes, including descriptive
  names for classes and variables
- [x] Kotlin is highly recommended with flows.
- Kotlin Data Flow implemented, Kotlin State Flow not implemented
