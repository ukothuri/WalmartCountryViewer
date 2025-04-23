# WalmartCountryViewer 🌍

An Android app that displays a list of countries with their region, capital, and ISO codes using the MVVM architecture. The app fetches real-time country data from a public API and renders it in a scrollable RecyclerView.

---

## 🚀 Features

- Fetches and displays country data from a remote JSON source
- Clean architecture using **MVVM**
- Uses **ViewModel**, **LiveData**, **RecyclerView**, and **View Binding**
- Network operations handled via **OkHttp**
- JSON parsing with **Gson**
- Clean UI with support for error and loading states

---

##  Architecture

The project follows a modular MVVM pattern:

```
com.walmart.countryviewer
│
├── data
│   ├── model             # Data models and state classes
│   ├── network           # API client (OkHttp)
│   └── repository        # Repository interfaces and implementations
│
├── ui
│   ├── view              # Activities, Adapters, and View logic
│   └── viewmodel         # ViewModel and factory classes
│

```

---

## 🔧 Tech Stack

- **Kotlin** (v2.0.21)
- **AndroidX**
- **OkHttp** (v4.12.0)
- **Gson** (v2.10.1)
- **ViewModel + LiveData**
- **View Binding**
- **RecyclerView**

---

## 🧪 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/WalmartCountryViewer.git
   cd WalmartCountryViewer
   ```

2. Open the project in **Android Studio Flamingo+**.

3. Ensure your `gradle.properties` and `versions.toml` are configured.

4. Hit ▶️ **Run** on an emulator or physical device running API 26+.

---

## 🖼️ Screenshots

| Loading State         | Country List           |
|------------------------|------------------------|
| ![Loading](screenshots/loading.png) | ![List](screenshots/list.png) |

---

## 📝 Future Improvements

- Add search/filter functionality
- Offline caching with Room
- Jetpack Compose support
- Dark mode UI

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 🙌 Acknowledgements

- Public country data API: [gist.githubusercontent](https://gist.githubusercontent.com/)
- OkHttp and Gson by Square & Google

---

Made with ❤️ by [Mahesh Kothuri]
