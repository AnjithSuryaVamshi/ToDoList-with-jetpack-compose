# To-Do List App (Jetpack Compose + ViewModel + Room)

This is a simple To-Do List application built using Jetpack Compose, ViewModel, and Room Database. It demonstrates how to add, delete, and mark tasks as completed, using a modern Android development approach.

## Features
- **Add New Tasks:** Add tasks to your to-do list.
- **Mark Tasks Complete/Incomplete:** Tasks can be checked as completed, and unchecked for incompletion.
- **Delete Tasks:** Remove tasks from your list.
- **Persistent Storage:** Tasks are stored using Room in a local SQLite database, so they persist even after closing the app.
- **Modern UI:** Built with Jetpack Compose, the UI is responsive and declarative.

## Tech Stack
- **Kotlin:** Programming language.
- **Jetpack Compose:** UI framework for building modern, reactive Android UIs.
- **Room Database:** Local SQLite database for task storage.
- **ViewModel & LiveData:** Manage and observe task data across configuration changes.
- **Coroutines:** For asynchronous programming.

## Project Structure
📂 to-do-list-app/
├── 📁 db/
│   ├── 📄 TodoEntity.kt        # Data model for to-do item.
│   ├── 📄 TodoDao.kt           # DAO interface for accessing the database.
│   └── 📄 TodoDb.kt            # Room Database setup.
├── 📁 repo/
│   └── 📄 TodoRepo.kt          # Repository class to manage data operations.
├── 📁 viewmodel/
│   └── 📄 TodoViewModel.kt     # ViewModel to handle UI data.
├── 📁 jetpack/
│   ├── 📄 FullScreenDialog.kt  # Compose function for adding new tasks.
│   └── 📄 TodoListScreen.kt    # Compose function to display and manage the to-do list.
└── 📄 MainActivity.kt          # Entry point for the app.

## Screenshots 

![Untitledgitpost](https://github.com/user-attachments/assets/1d0e359b-0521-4d4d-90c1-628ea026355c)





https://github.com/user-attachments/assets/4fcca6ff-2584-4e51-93a1-9c74c6c62bc0




https://github.com/user-attachments/assets/9e6863ef-6450-45c3-be07-1ac50ac32f0e



