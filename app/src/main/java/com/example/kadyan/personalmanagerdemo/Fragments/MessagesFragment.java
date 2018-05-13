package com.example.kadyan.personalmanagerdemo.Fragments;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kadyan.personalmanagerdemo.R;

public class MessagesFragment extends Fragment {

    interface OnMessageFragmentListener{
        void changeTitle();
    }

    public static MessagesFragment newInstance() {

        Bundle args = new Bundle();

        MessagesFragment fragment = new MessagesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_messagess,container,false);
        ((Toolbar)getActivity().findViewById(R.id.toolbar)).setTitle("Messages");
        return view;
    }
}
