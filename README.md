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

## Testing and smoke checks

Build the application from the repository root before testing:

```powershell
mvn clean package
```

The project does not currently include a dedicated automated test suite. After
building, perform the following manual GUI checks:

1. **Sign-in:** confirm an incorrect employee ID or birthday shows the existing
   sign-in error and leaves the login screen open. Confirm a valid employee ID
   and matching birthday opens the appropriate dashboard.
2. **Dashboard routing:** sign in with an HR employee and verify the admin
   dashboard opens. Sign in with a non-HR employee and verify the employee
   dashboard opens.
3. **Employee profile:** navigate the employee dashboard's sections and check
   that the displayed personal, work, government ID, and salary fields match
   that employee's CSV record. Salary values are displayed from the record;
   this application does not calculate payroll.
4. **Legacy HR screens:** in the admin dashboard, create an employee, search
   for that employee by ID, confirm the profile displays the saved fields, then
   delete the employee and refresh the admin table.
5. **Manage Records screens:** open **Manage Records**, add an employee, view
   and edit the record, save and confirm the list reflects the change, then
   delete the record and refresh the list.
6. **Sorted selection:** sort the employee table, select a row, and verify
   view/edit or delete affects the selected employee rather than a different
   row.

These checks exercise both HR record-management paths, the existing CRUD
behavior, profile refresh, and selection in a sorted table. They are smoke
checks, not exhaustive validation of every input or CSV error condition.

### Use an isolated test data file

All HR create, edit, and delete checks write to the configured data file. To
avoid changing your normal employee records, start the application with a
separate writable CSV path:

```powershell
java -Dmotorph.data.file="C:\temp\motorph-smoke-test\employees.csv" -jar target\motorph-employee-app-1.0.0.jar
```

When that file does not exist, the application initializes it from its
available employee seed data. Perform destructive checks only against this
isolated test copy. The source CSV files are not the runtime persistence file.
