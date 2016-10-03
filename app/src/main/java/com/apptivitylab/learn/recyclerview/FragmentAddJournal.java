package com.apptivitylab.learn.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;

/**
 * Created by jamehii on 10/3/2016.
 */
public class FragmentAddJournal extends Fragment
{
    EditText mEditTextJournalDesc;
    private Button mButtonAdd;
    private Button mButtonCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootView = (View)inflater.inflate(R.layout.fragment_add_journal, container, false );

        mEditTextJournalDesc = (EditText)rootView.findViewById(R.id.edit_text_journal_description);
        mButtonAdd = (Button) rootView.findViewById(R.id.button_add_journal);
        mButtonCancel = (Button) rootView.findViewById(R.id.button_cancel);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mButtonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String journalDesc = mEditTextJournalDesc.getText().toString();

                Intent data = new Intent();
                data.putExtra("journalDesc", journalDesc);

                getActivity().setResult(Activity.RESULT_OK, data);
                getActivity().finish();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().finish();
            }
        });

    }
}
