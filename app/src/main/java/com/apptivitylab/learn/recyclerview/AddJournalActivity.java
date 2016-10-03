package com.apptivitylab.learn.recyclerview;

/**
 * Created by jamehii on 10/3/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by jamehii on 10/3/2016.
 */

public class AddJournalActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_journal);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_add_journal, new FragmentAddJournal())
                .commit();
    }
}

