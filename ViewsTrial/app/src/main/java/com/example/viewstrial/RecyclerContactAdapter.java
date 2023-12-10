package com.example.viewstrial;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ContactModel> arrContacts;
    Context context;
    private int Lastposition=-1;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;
    };
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.img.setImageResource(arrContacts.get(position).image);
            viewHolder.number.setText(arrContacts.get(position).name);
            viewHolder.name.setText(arrContacts.get(position).number);
        setAnimation(holder.itemView,position);
        viewHolder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.addupdatelayout ); // Replace with your dialog layout XML file

                EditText cn = dialog.findViewById(R.id.cn);
                EditText cnum = dialog.findViewById(R.id.cnum);
                Button save = dialog.findViewById(R.id.save);
                TextView txtview = dialog.findViewById(R.id.txtview);
                txtview.setText("Update Contact");
                save.setText("Update");
                cn.setText(arrContacts.get(position).name);
                cnum.setText(arrContacts.get(position).number);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = cn.getText().toString().trim();
                        String number = cnum.getText().toString().trim();

                        if (name.isEmpty()) {
                            Toast.makeText(context, "Please Enter Contact Name", Toast.LENGTH_LONG).show();
                            return;
                        }

                        if (number.isEmpty()) {
                            Toast.makeText(context, "Please Enter Contact Number", Toast.LENGTH_LONG).show();
                            return;
                        }

                        arrContacts.set(position, new ContactModel(number, name));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        ((ViewHolder) holder).llrow.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Contact");
        builder.setMessage("Are you sure");
        builder.setIcon(R.drawable.baseline_delete_forever_24);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
arrContacts.remove(position);
notifyItemRemoved(position);
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
Toast.makeText(context,"Cancelled",Toast.LENGTH_LONG).show();
            }
        });
builder.show();


        return true;
    }
});

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
      TextView name,number;
      ImageView img;
      LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.ContactName);
            number=itemView.findViewById(R.id.ContactNumber);
            img= itemView.findViewById(R.id.image);
            llrow=itemView.findViewById(R.id.llrow);
        }

    }
    private void setAnimation(View viewToanimate,int position){
        if(position>Lastposition){
        Animation slidein = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        viewToanimate.startAnimation(slidein);
        Lastposition=position;
    }
    }
}
