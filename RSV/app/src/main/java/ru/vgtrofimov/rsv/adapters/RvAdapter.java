package ru.vgtrofimov.rsv.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

import ru.vgtrofimov.rsv.Courses;
import ru.vgtrofimov.rsv.R;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{

    private Vector<Courses> courses;
    private Context context;

    public RvAdapter(Vector<Courses> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Courses data = courses.get(position);

        holder.image_course.setImageDrawable(data.getImg());
        holder.name_course.setText(data.getName());

        String text_course = data.getText();
        if (text_course.length() > 115)
            text_course = text_course.substring(0, 115);
        text_course += "...\n\nПодробнее...";

        holder.text_course.setText(text_course);
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image_course;
        public TextView name_course;
        public TextView text_course;

        public ViewHolder(View itemView) {
            super(itemView);
            image_course = (ImageView) itemView.findViewById(R.id.image_course);
            name_course = (TextView) itemView.findViewById(R.id.name_course);
            text_course = (TextView) itemView.findViewById(R.id.text_course);
        }
    }
}
