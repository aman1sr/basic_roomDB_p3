#ROOM DB
Room is a database layer on top of an SQLite database. Room uses the DAO to issue queries to its database.



# Components of RoomDB

- Entity — A class that describes a database table when working with Room
- DAO (Data Access Object) — A mapper of SQL queries to functions
- Database — For on device storage
- Repository — Primarily used to manage multiple data sources
  - The repository class is responsible for interacting with the Room database and will need to provide methods 
  - that use the DAO to insert, delete and query items 
- ViewModel — Communication center between data and UI
  - The ViewModel is responsible to provide data to the UI 
  - and survive configuration changes such as screen rotations

[project src](https://medium.com/@hrithik481/roomdb-in-android-with-kotlin-coroutines-bdb11ae37acb) 