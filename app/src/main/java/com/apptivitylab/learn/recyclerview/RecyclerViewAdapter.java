package com.apptivitylab.learn.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jamehii on 10/1/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter
{
    RecyclerView mRecyclerView;
    RecyclerViewHolder.RecyclerViewListener mRecyclerViewListener;

    public RecyclerViewAdapter(RecyclerViewHolder.RecyclerViewListener listener)
    {
        mRecyclerViewListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(itemView, mRecyclerViewListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {
/*        TextView titleTextView = (TextView)holder.itemView;
        titleTextView.setText("Item " + position);

        titleTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mRecyclerViewListener.onItemSelectedListener(position);
            }
        });*/
        // onBindViewHolder will only be called on every scroll on the RecyclerView
        RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder)holder;
        recyclerViewHolder.setPosition(position);
        recyclerViewHolder.updateTextView(position);

    }



    @Override
    public int getItemCount()
    {
        return 100;
    }

}
