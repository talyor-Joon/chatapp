package com.example.javastudy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;

//public class friendlistAct extends AppCompatActivity {
//    private static final String TAG = "hello";
//    final ArrayList<String> list = new ArrayList<String>();
//
//    FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.friendlist);
//
//
//
//
//        ShowFriends();
//
//
//    }
//
//    private void ShowFriends(){
//        DocumentReference docRef = db.collection("users").document();
//
//
//        db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        //if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getData());
//
//                                list.add(document.getId());
//                                friendlistprint();
//
//
//
//
//                            }
//                        //} else {
//                          //  Log.d(TAG, "Error getting documents: ", task.getException());
//                        //}
//                    }
//                });
//
//        System.out.println(list);
//
//    }
//    private void friendlistprint(){
//        ArrayAdapter<String> Adapter;
//
//        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
//
//        ListView listView = (ListView)findViewById(R.id.TextView_list);
//
//        listView.setAdapter(Adapter);
//
//
//
//    }
//}


    public class friendlistAct extends AppCompatActivity {
        private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;
        private Button Button;


        public ArrayList<memberDto> myDataset = new ArrayList<memberDto>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        private static final String TAG = "hello";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.friendlist);

            ShowFriends();
//            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//
//            // use this setting to improve performance if you know that changes
//            // in content do not change the layout size of the RecyclerView
//            recyclerView.setHasFixedSize(true);
//
//            // use a linear layout manager
//            layoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(layoutManager);
//
//            // specify an adapter (see also next example)
//            //mAdapter = new MyAdapter(myDataset);
//            recyclerView.setAdapter(mAdapter);


            Button btn = (Button) findViewById(R.id.button_show);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    friendlistprint();
                }
            });

        }

        private void ShowFriends() {
            DocumentReference docRef = db.collection("users").document();

            db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    //if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        myDataset.add(new memberDto(document.getId()));
                    }
                    //} else {
                    //  Log.d(TAG, "Error getting documents: ", task.getException());
                    //}
                }
            });

        }

        private void friendlistprint(){
        //ArrayAdapter<memberDto> mAdapter;

        //mAdapter = new ArrayAdapter<memberDto>(this, android.R.layout.simple_list_item_1, myDataset);

//        RecyclerView RecyclerView = findViewById(R.id.my_recycler_view);
//
//            RecyclerView.setAdapter(mAdapter);


            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            recyclerView.setHasFixedSize(true);

            // use a linear layout manager
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            // specify an adapter (see also next example)
            mAdapter = new MyAdapter(myDataset);
            recyclerView.setAdapter(mAdapter);

            System.out.println(myDataset);

    }
}







