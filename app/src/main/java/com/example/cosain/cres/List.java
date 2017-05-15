package com.example.cosain.cres;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class List extends AppCompatActivity{


private RecyclerView recycler;
private DatabaseReference refrigerator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recycler = (RecyclerView) findViewById(R.id.recyclerview);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        refrigerator = FirebaseDatabase.getInstance().getReference().child("/users");

        FirebaseRecyclerAdapter<User, BlogViewHolder> adapter = new FirebaseRecyclerAdapter<User, BlogViewHolder>(
                User.class,
                R.layout.recycler_view_item,
                BlogViewHolder.class,
                refrigerator

        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, User model, int position) {
        viewHolder.setName(model.getName());
                viewHolder.setStatus(model.getStatus());
            }
        };

        recycler.setAdapter(adapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView user, statuss;

        public BlogViewHolder(View itemView) {
            super(itemView);
            user = (TextView) itemView.findViewById(R.id.list_item_text);
            statuss = (TextView) itemView.findViewById(R.id.status);
        }

        public void setName(String name) {
            user.setText("User: "+name);
        }

        public void setStatus(String status) {
            statuss.setText("Status: "+status);
        }
    }

}
