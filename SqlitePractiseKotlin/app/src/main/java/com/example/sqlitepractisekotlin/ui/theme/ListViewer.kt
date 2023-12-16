import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitepractisekotlin.ContactModel
import com.example.sqlitepractisekotlin.R


class ListViewer(private val context: Activity, private val array: ArrayList<ContactModel>) :
    RecyclerView.Adapter<ListViewer.MyViewHolder>() {
    private var dbHelper: SqliteDb = SqliteDb(context)
    private lateinit var dialog: Dialog

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recordName: TextView = itemView.findViewById(R.id.nameshow)
        val recordNumber: TextView = itemView.findViewById(R.id.numbershow)
        val changesButton: Button = itemView.findViewById(R.id.editButton)
        val deletesButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recordview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRecord = array[position]
        holder.recordName.text = currentRecord.name
        holder.recordNumber.text = currentRecord.number

        dialog = Dialog(context)
        dialog.setContentView(R.layout.updateview)

        holder.changesButton.setOnClickListener {
            dialog.show()

            val updateButton = dialog.findViewById<ImageButton>(R.id.updatebutton)
            updateButton.setOnClickListener {
                dialog.findViewById<EditText>(R.id.nameupdate).setText(currentRecord.name)
                dialog.findViewById<EditText>(R.id.numberupdate).setText(currentRecord.number)

                val success = dbHelper.update(currentRecord)
                if (success) {
                    Toast.makeText(context, "Updated Data Successfully", Toast.LENGTH_LONG).show()
                    notifyDataSetChanged()
                } else {
                    Toast.makeText(context, "Oops! Something went wrong", Toast.LENGTH_LONG).show()
                }
                dialog.dismiss()
            }

            val cancelButton = dialog.findViewById<ImageButton>(R.id.cancelbutton)
            cancelButton.setOnClickListener {
                dialog.dismiss()
            }
        }

        holder.deletesButton.setOnClickListener {
            val success = dbHelper.deleteRecord(currentRecord.id)
            if (success) {
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_LONG).show()
                notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Oops! Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}
