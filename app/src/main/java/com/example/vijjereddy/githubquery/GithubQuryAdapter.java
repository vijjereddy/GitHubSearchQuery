package com.example.vijjereddy.githubquery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GithubQuryAdapter extends RecyclerView.Adapter<GithubQuryAdapter.GithubQueryViewHolder> {
    Context context;
    ArrayList<GithubQueryModel>githubQueryModelArrayList;
    public GithubQuryAdapter(Second second, ArrayList<GithubQueryModel> arrayList) {
        this.context=second;
        this.githubQueryModelArrayList=arrayList;
    }

    @NonNull
    @Override
    public GithubQueryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.recyclerviewesign,parent,false);
        return new GithubQueryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubQueryViewHolder holder, int position) {
        GithubQueryModel model=githubQueryModelArrayList.get(position);
        holder.tv1.setText(model.getJob());
        holder.tv2.setText(model.getLocation());
        holder.tv3.setText(model.getHow_to_apply());

    }

    @Override
    public int getItemCount() {
        return (githubQueryModelArrayList==null)?0:githubQueryModelArrayList.size();
    }

    public class GithubQueryViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        public GithubQueryViewHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1d);
            tv2=itemView.findViewById(R.id.tv2d);
            tv3=itemView.findViewById(R.id.tv3d);
        }
    }
}
