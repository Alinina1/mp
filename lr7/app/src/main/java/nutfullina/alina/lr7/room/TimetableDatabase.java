package nutfullina.alina.lr7.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TimetableEntity.class}, version = 1, exportSchema = false)
public abstract class TimetableDatabase extends RoomDatabase {

    private static TimetableDatabase timetableDatabase;

    private static String DATABASE_NAME = "DB";

    public synchronized static TimetableDatabase getInstance(Context context) {
        if (timetableDatabase == null) {
            timetableDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    TimetableDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return timetableDatabase;
    }

    public abstract TimetableDao mainDao();
}
