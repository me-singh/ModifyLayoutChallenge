package com.example.kadyan.personalmanagerdemo.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.transition.Transition;
import com.example.kadyan.personalmanagerdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    String[] senders=new String[]{"Amit","asf","afa","wqr","egs","qwr","yth","hrt","rbgtv","wewe"};
    String[] times=new String[]{"10/05/2018","10/05/2018","11/05/2018","11/05/2018","11/05/2018",
            "12/05/2018","12/05/2018","13/05/2018","13/05/2018","13/05/2018"};
    int[] posts=new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a5,R.drawable.a6,R.drawable.a7,
            R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11};
    int[] avatars=new int[]{R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,
            R.drawable.i8,R.drawable.i9,R.drawable.i10};

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        ((Toolbar)getActivity().findViewById(R.id.toolbar)).setTitle("Home");
        recyclerView=view.findViewById(R.id.homeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HomeElementAdapter homeElementAdapter=new HomeElementAdapter();
        recyclerView.setAdapter(homeElementAdapter);
        return view;
    }

    class HomeElementAdapter extends RecyclerView.Adapter<HomeElementAdapter.HomeElementViewHolder>{

        @NonNull
        @Override
        public HomeElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v=LayoutInflater.from(getContext()).inflate(R.layout.single_home_recycler_item,parent,false);
            return new HomeElementViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull HomeElementViewHolder holder, int position) {
//            Picasso.get().load(avatars[position]).into(holder.avatar);
            Picasso.get().load(posts[position]).into(holder.post);
            holder.sender.setText(senders[position]);
            holder.time.setText(times[position]);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class HomeElementViewHolder extends RecyclerView.ViewHolder{

            CircleImageView avatar;
            ImageView post;
            TextView sender,time;

            public HomeElementViewHolder(View itemView) {
                super(itemView);
                avatar=itemView.findViewById(R.id.profile_image);
                post=itemView.findViewById(R.id.post);
                sender=itemView.findViewById(R.id.senderName);
                time=itemView.findViewById(R.id.time);
            }
        }
    }
}
