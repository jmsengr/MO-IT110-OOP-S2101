# MotorPh Employee App

The repository is one Java 17 Swing application. `MotorPhApp/src` and
`With Update/src` are compiled together by the root Maven project; launch from
the repository root rather than opening either folder as a separate project.

## Build and run

```powershell
mvn package
java -jar target\motorph-employee-app-1.0.0.jar
```

The application opens one sign-in screen. Use an employee ID and birthday in
`MM/DD/YYYY` format. HR positions open the admin dashboard; other employees
open their profile dashboard. HR can manage records from **Manage Records**.

## Employee data

The first run initializes `%USERPROFILE%\.motorph\employees.csv`. The existing
40-row `MotorPhApp` dataset is retained, and records from `With Update` are
merged by employee ID. Employee management, sign-in, and dashboards all use
this same file. The two source CSVs are left unchanged.

Set `motorph.data.file` to use another writable CSV location:

```powershell
java -Dmotorph.data.file="C:\path\to\employees.csv" -jar target\motorph-employee-app-1.0.0.jar
```
