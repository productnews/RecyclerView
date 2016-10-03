package com.apptivitylab.learn.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jamehii on 10/1/2016.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    private TextView mTextView;
    private RecyclerViewListener mRecyclerViewListener;
    private int mPosition;


    public void setPosition(int position)
    {
        mPosition = position;
    }


    public interface RecyclerViewListener
    {
        public void onItemSelectedListener(int position);
    }

    public RecyclerViewHolder(View itemView, RecyclerViewHolder.RecyclerViewListener listener)
    {
        super(itemView);

        mTextView = (TextView) itemView;
        mRecyclerViewListener = listener;

        mTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mRecyclerViewListener.onItemSelectedListener(mPosition);
            }
        });
    }

    public void updateTextView(int position)
    {
        mTextView.setText("Item " + mPosition);
    }

}
