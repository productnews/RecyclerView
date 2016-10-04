package com.apptivitylab.learn.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by jamehii on 10/1/2016.
 */
public class FragmentRecyclerView extends Fragment implements RecyclerViewHolder.RecyclerViewListener
{
    private static final String TAG = "FragmentRecyclerView";
    private static final int ADD_TASK_REQUEST = 1;
    RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = (View)inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_recycler_view);

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemSelectedListener(int position)
    {
        Log.d(TAG, "onItemSelectedListener: " + position);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate( R.menu.menu_options, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = new Intent(getContext(), AddJournalActivity.class);
        startActivityForResult(intent, ADD_TASK_REQUEST);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_TASK_REQUEST)
        {
            if(resultCode == Activity.RESULT_OK && data != null)
            {
                String journalDesc = data.getStringExtra("journalDesc");

                mAdapter.addToJournalList(journalDesc);
                mAdapter.notifyItemInserted(mAdapter.mJournalList.size());
            }
        }
    }

}
