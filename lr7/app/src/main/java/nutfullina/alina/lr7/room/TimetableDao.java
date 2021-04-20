package nutfullina.alina.lr7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TimetableDao {
    @Query("SELECT * FROM timetable")
    List<TimetableEntity> getAll();

    @Insert(onConflict = REPLACE)
    void insert(TimetableEntity timeTableEntity);

    @Delete
    void delete(TimetableEntity timeTableEntity);

    @Query("UPDATE timetable SET subject = :subject, teacher = :teacher, cabinet = :cabinet WHERE ID = :sID")
    void update(int sID, String subject, String teacher, String cabinet);

    @Query("SELECT * FROM timetable WHERE subject LIKE :search OR teacher LIKE :search OR cabinet LIKE :search")
    public List<TimetableEntity> getNamesLike(String search);
}
