package com.changzakso.dreamcatcher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.changzakso.dreamcatcher.R;

import java.util.ArrayList;
import java.util.List;

public class MonthListAdapter extends RecyclerView.Adapter<MonthListAdapter.ViewHolder> {

    public interface WordSelectListener {
        public void onSearchWord(String title);
    }

    private List<String> labels;
    private WordSelectListener listener;
    public MonthListAdapter(WordSelectListener _listener) {
        listener = _listener;
        labels = new ArrayList<>();

        labels.add("머리에서 이가 나오는 꿈");
        labels.add("몸에 멍드는 꿈");
        labels.add("부동산을 처분하는 꿈");
        labels.add("부동산 중개업소를 방문하는 꿈");
        labels.add("부동산을 사는꿈");
        labels.add("물건");
        labels.add("장소");
        labels.add("행동");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
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
