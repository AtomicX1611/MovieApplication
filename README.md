Movie Application (Java MVVM)
Overview
The Movie Application is a Java-based desktop application designed to provide users with an intuitive interface to search, view, and manage their movie collection. Built using the Model-View-ViewModel (MVVM) architecture, the app allows users to explore movie details, save favorites, and apply sorting or filtering options.

Technologies Used 

MVVM Architecture: Design pattern separating UI logic (View), business logic (ViewModel), and data (Model).
Gradle: For project dependency management and build automation.

Features

Movie Details: Displays detailed information about a selected movie, including plot, cast, and ratings.
Responsive UI: Built with JavaFX for a clean and responsive user experience.

Architecture
This project follows the MVVM (Model-View-ViewModel) architecture, ensuring a clean separation of concerns:

Model: Represents the data layer (movie details, user preferences).
View: The user interface (built with JavaFX) that displays data to the user.
ViewModel: Handles the presentation logic, fetching data from the Model and providing it to the View.
This pattern improves testability and maintainability by isolating the business logic from the UI layer.
