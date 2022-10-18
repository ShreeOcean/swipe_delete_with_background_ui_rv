package com.ocean.swipedelrvitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocean.swipedelrvitem.databinding.CustomlayoutBinding;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.MyViewHolder> {

    CustomlayoutBinding binding;
    private Context context;
    private List<String> dataList;
    private List<String> itemsPendingRemoval;

    private static final int PENDING_REMOVAL_TIMEOUT = 3000; // 3sec
    //todo: hanlder for running delayed runnables
    private Handler handler = new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };
    //todo: map of items to pending runnable, to cancel the removal
    HashMap<String, Runnable> pendingRunnables = new HashMap<>();


    public AdapterRV(Context context, List<String> dataList, List<String> itemsPendingRemoval) {
        this.context = context;
        this.dataList = dataList;
        this.itemsPendingRemoval = itemsPendingRemoval;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CustomlayoutBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final String data = dataList.get(position);

        if (itemsPendingRemoval.contains(data)){


        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CustomlayoutBinding binding;

        public MyViewHolder(CustomlayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
