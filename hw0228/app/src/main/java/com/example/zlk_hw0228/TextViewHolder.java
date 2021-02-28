package com.example.zlk_hw0228;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mTextView;
    private Integer index;

    public TextViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this);
    }

    public void bind(String text) {
        mTextView.setText(text);
    }
    public void bindindex(Integer _index) {
        index=_index;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), showindex.class);
        intent.putExtra("index", index);
        v.getContext().startActivity(intent);
    }
}
