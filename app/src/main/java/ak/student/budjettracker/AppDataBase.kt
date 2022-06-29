package ak.student.budjettracker

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Transaction::class),version = 1)
class AppDataBase {
    abstract class AppDataBase:RoomDatabase(){
        abstract fun transactionDao():TransactionDao
    }
}