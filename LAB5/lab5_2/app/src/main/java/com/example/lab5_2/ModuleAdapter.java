package com.example.lab5_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {
    private List<Module> moduleList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public ModuleAdapter(List<Module> moduleList, OnItemClickListener listener) {
        this.moduleList = moduleList;
        this.listener = listener;
    }

    @Override
    public ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_module, parent, false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        Module module = moduleList.get(position);
        holder.title.setText(module.getTitle());
        holder.description.setText(module.getDescription());
        holder.platform.setText(module.getPlatform());
        holder.logo.setImageResource(module.getImageResId());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public void addItem(Module module) {
        moduleList.add(module);
        notifyItemInserted(moduleList.size() - 1);
    }

    public void updateItem(int position, Module module) {
        moduleList.set(position, module);
        notifyItemChanged(position);
    }

    public void removeItem(int position) {
        moduleList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ModuleViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, platform;
        ImageView logo;

        public ModuleViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
            platform = itemView.findViewById(R.id.tvPlatform);
            logo = itemView.findViewById(R.id.imgLogo);
        }
    }
}
