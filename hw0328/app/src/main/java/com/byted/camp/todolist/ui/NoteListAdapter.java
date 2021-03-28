package com.byted.camp.todolist.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.byted.camp.todolist.MainActivity;
import com.byted.camp.todolist.NoteActivity;
import com.byted.camp.todolist.NoteOperator;
import com.byted.camp.todolist.R;
import com.byted.camp.todolist.beans.Note;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private static final int REQUEST_CODE_ADD = 1002;
    private Context context;
    private final NoteOperator operator;
    private final List<Note> notes = new ArrayList<>();

    public NoteListAdapter(NoteOperator operator) {
        this.operator = operator;
    }

    public void refresh(List<Note> newNotes) {
        notes.clear();
        if (newNotes != null) {
            notes.addAll(newNotes);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        this.context=parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView, operator);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int pos) {
        final Note note=notes.get(pos);
        holder.bind(note);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id= (int) (note.getId());
                Intent intent=new Intent(context, NoteActivity.class);
                intent.putExtra("Id",(Integer)id);
                intent.putExtra("Content",note.getContent());

                startActivityForResult((Activity) context, intent,REQUEST_CODE_ADD,null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
