package com.example.cosain.cres;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by cosain on 5/13/2017.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
    ArrayList<User> user = new ArrayList<>();


    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean save(User user)
    {
        if(user==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("users").push().setValue(user);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        user.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            User suck=ds.getValue(User.class);
            user.add(suck);
        }
    }

    public ArrayList<User> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return user;
    }


}