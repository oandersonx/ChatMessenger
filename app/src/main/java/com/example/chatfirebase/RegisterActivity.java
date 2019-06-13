package com.example.chatfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtEmail2;
    private EditText edtSenha2;
    private TextView txtNaotenhoumaconta;
    private Button btnCadastrar;
    private Button btnSelecionarFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_register);

        edtEmail2 = findViewById(R.id.edtEmail2);
        edtSenha2 = findViewById(R.id.edtSenha2);
        txtNaotenhoumaconta = findViewById(R.id.txtNaotenhoumaconta);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnSelecionarFoto = findViewById(R.id.btnSelecionarFoto)

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        String email = edtEmail2.getText().toString();
        String senha = edtSenha2.getText().toString();

        // Controle de login

        if(email == null || email.isEmpty()){
            Toast.makeText(this, "Email em branco", Toast.LENGTH_SHORT).show(); return;
        }
        else if(senha == null || senha.isEmpty()){
            Toast.makeText(this, "Senha em branco", Toast.LENGTH_SHORT).show(); return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.i("Teste", task.getResult().getUser().getUid());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Teste", e.getMessage());
                    }
                });





    }




}