package com.changzakso.dreamcatcher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.changzakso.dreamcatcher.R;

import java.util.ArrayList;
import java.util.List;

public class SearchWordAdapter extends RecyclerView.Adapter<SearchWordAdapter.ViewHolder> {

    public interface WordSelectListener {
        public void onSearchWord(String title);
    }

    private List<String> labels;
    private WordSelectListener listener;
    public SearchWordAdapter(WordSelectListener _listener) {
        listener = _listener;
        labels = new ArrayList<>();

        labels.add("자연");
        labels.add("인물");
        labels.add("신체");
        labels.add("동물");
        labels.add("식물");
        labels.add("물건");
        labels.add("장소");
        labels.add("행동");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String label = labels.get(position);
        holder.textView.setText(label);

        //handling item click event
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSearchWord(label);
            }
        });
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
