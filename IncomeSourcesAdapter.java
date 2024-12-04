package com.sdaproject.frugalflowapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IncomeSourcesAdapter extends RecyclerView.Adapter<IncomeSourcesAdapter.IncomeSourceViewHolder> {
    private List<IncomeSource> incomeSources;

    public IncomeSourcesAdapter(List<IncomeSource> incomeSources) {
        this.incomeSources = incomeSources;
    }

    @NonNull
    @Override
    public IncomeSourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_income_source, parent, false);
        return new IncomeSourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeSourceViewHolder holder, int position) {
        IncomeSource incomeSource = incomeSources.get(position);
        holder.tvSourceName.setText(incomeSource.getName());
        holder.tvSourceAmount.setText(incomeSource.getAmount());
        holder.tvSourceGrowth.setText(incomeSource.getGrowth());
    }

    @Override
    public int getItemCount() {
        return incomeSources.size();
    }

    static class IncomeSourceViewHolder extends RecyclerView.ViewHolder {
        TextView tvSourceName;
        TextView tvSourceAmount;
        TextView tvSourceGrowth;

        public IncomeSourceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSourceName = itemView.findViewById(R.id.tvSourceName);
            tvSourceAmount = itemView.findViewById(R.id.tvSourceAmount);
            tvSourceGrowth = itemView.findViewById(R.id.tvSourceGrowth);
        }
    }
}