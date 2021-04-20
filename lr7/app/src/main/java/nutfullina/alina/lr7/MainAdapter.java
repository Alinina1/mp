package nutfullina.alina.lr7;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nutfullina.alina.lr7.room.TimetableDatabase;
import nutfullina.alina.lr7.room.TimetableEntity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<TimetableEntity> dataList;
    private Activity context;
    private TimetableDatabase timetableDatabase;

    public MainAdapter(Activity context, List<TimetableEntity> dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TimetableEntity data = dataList.get(position);

        timetableDatabase = TimetableDatabase.getInstance(context);

        holder.textView.setText(data.getSubject());
        holder.textView2.setText(data.getTeacher());
        holder.textView3.setText(data.getCabinet());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimetableEntity d = dataList.get(holder.getAdapterPosition());

                int sID = d.getID();
                String subject = d.getSubject();
                String teacher = d.getTeacher();
                String cabinet = d.getCabinet();

                Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.timetable_update);

                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();

                EditText editText1 = dialog.findViewById(R.id.edit_text1);
                EditText editText2 = dialog.findViewById(R.id.edit_text2);
                EditText editText3 = dialog.findViewById(R.id.edit_text3);

                Button btnUpdate = dialog.findViewById(R.id.btn_update);

                editText1.setText(subject);
                editText2.setText(teacher);
                editText3.setText(cabinet);

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                        String subject = editText1.getText().toString().trim();
                        String teacher = editText2.getText().toString().trim();
                        String cabinet = editText3.getText().toString().trim();

                        timetableDatabase.mainDao().update(sID, subject, teacher, cabinet);
                        dataList.clear();
                        dataList.addAll(timetableDatabase.mainDao().getAll());
                        notifyDataSetChanged();
                    }
                });
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimetableEntity d = dataList.get(holder.getAdapterPosition());

                timetableDatabase.mainDao().delete(d);

                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataList.size());

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView2, textView3;
        ImageView btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textViewTeacher);
            textView3 = itemView.findViewById(R.id.textViewCabinet);

            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
