package com.example.javastudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.javastudy.memberDto;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class memberInfoUpdate extends AppCompatActivity {
        Button memberInfoUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info_update);
        memberInfoUpdate = (Button)findViewById(R.id.update);
        memberInfoUpdate.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.update :
                        setMemberInfoUpdate();
                    break;
            }
        }
    };

    private void setMemberInfoUpdate(){
        String name = ((EditText)findViewById(R.id.update_name)).getText().toString();
        String nickname =((EditText)findViewById(R.id.update_nickname)).getText().toString();
        String phoneNumber=((EditText)findViewById(R.id.update_phone_number)).getText().toString();

        memberDto memberdto = new memberDto(name,nickname,phoneNumber);


        if(name.length()>0 && nickname.length()>0 &&phoneNumber.length() >0){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("users").document(user.getEmail()).set(memberdto)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"저장이 완료 되었습니다" ,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"저장이 실패 했습니다" , Toast.LENGTH_SHORT).show();

                        }
                    });
        }
    }
}


