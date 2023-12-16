import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlitepractisekotlin.ContactModel

class SqliteDb(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        const val DB_NAME = "contact.db"
        const val DB_VERSION = 1
        const val TABLE_NAME = "contacts_table"
        const val FIRST_COLUMN = "_id"
        const val SECOND_COLUMN = "name"
        const val THIRD_COLUMN = "number"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val queryCreate =
            ("CREATE TABLE $TABLE_NAME ("
                    + "$FIRST_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "$SECOND_COLUMN TEXT, "
                    + "$THIRD_COLUMN TEXT" + ")")
        db.execSQL(queryCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertRecord(record: ContactModel): Boolean {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(SECOND_COLUMN, record.name)
            put(THIRD_COLUMN, record.number)
        }

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success != -1L
    }

    @SuppressLint("Range")
    fun getAllRecords(): ArrayList<ContactModel> {
        val recordList = ArrayList<ContactModel>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val id = it.getInt(it.getColumnIndex(FIRST_COLUMN))
                    val name = it.getString(it.getColumnIndex(SECOND_COLUMN))
                    val number = it.getString(it.getColumnIndex(THIRD_COLUMN))

                    val record = ContactModel(id, name, number)
                    recordList.add(record)
                } while (it.moveToNext())
            }
        }
        cursor?.close()
        db.close()
        return recordList
    }

    fun deleteRecord(id: Int): Boolean {
        val db = writableDatabase
        val success = db.delete(TABLE_NAME, "$FIRST_COLUMN=?", arrayOf(id.toString())).toLong()
        db.close()
        return success != -1L
    }

    fun update(dataToBeChanged: ContactModel): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(SECOND_COLUMN, dataToBeChanged.name)
            put(THIRD_COLUMN, dataToBeChanged.number)
        }

        val success = db.update(TABLE_NAME, values, "$FIRST_COLUMN=?", arrayOf(dataToBeChanged.id.toString())).toLong()
        db.close()
        return success != -1L
    }

    @SuppressLint("Range")
    fun selectRecord(id: Int): ContactModel {
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $FIRST_COLUMN =$id"
        val cursor = db.rawQuery(selectQuery, null)
        cursor?.moveToFirst()
        val Id = cursor?.getInt(cursor.getColumnIndex(FIRST_COLUMN)) ?: 0
        val name = cursor?.getString(cursor.getColumnIndex(SECOND_COLUMN)) ?: ""
        val number = cursor?.getString(cursor.getColumnIndex(THIRD_COLUMN)) ?: ""
        val particularRecord = ContactModel(Id, name, number)
        cursor?.close()
        db.close()
        return particularRecord
    }
}
