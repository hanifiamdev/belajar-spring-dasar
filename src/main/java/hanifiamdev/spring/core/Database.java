package hanifiamdev.spring.core;


/*
*  Singleton
*  Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja
*  Dan ketika kitammbutuhkan object tersebut kita hanya akan menggunakan object yang sama
* */
public class Database {


    private static Database database;

    public static Database getInstance() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }

    private Database() {

    }


}
