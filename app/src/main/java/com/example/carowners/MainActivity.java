package com.example.carowners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    Button btnCar, btnOwner;
    ImageView ivCarLogo;
    TextView tvCarModel, tvName, tvTel;
    FragmentManager fragmentManager;
    Fragment buttonFrag, listFrag, carFrag, ownerFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCar = findViewById(R.id.btnCar);
        btnOwner = findViewById(R.id.btnOwner);
        ivCarLogo = findViewById(R.id.ivCarLogo);
        tvCarModel = findViewById(R.id.tvCarModel);
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);

        fragmentManager = getSupportFragmentManager();
        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carFrag = fragmentManager.findFragmentById(R.id.carFrag);
        ownerFrag = fragmentManager.findFragmentById(R.id.ownerFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carFrag)
                .hide(ownerFrag)
                .commit();

        ItemClicked(0);

        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                    .show(carFrag)
                    .hide(ownerFrag)
                    .commit();
            }
        });

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                    .hide(carFrag)
                    .show(ownerFrag)
                    .commit();

            }
        });
    }

    @Override
    public void ItemClicked(int index) {
        tvName.setText(ApplicationClass.owners.get(index).getOwner());
        tvCarModel.setText(ApplicationClass.owners.get(index).getModel());
        tvTel.setText(ApplicationClass.owners.get(index).getOwnertel());

        if (ApplicationClass.owners.get(index).getMake().equals("Volkswagen")){
            ivCarLogo.setImageResource(R.drawable.volkswagen);
        } else if (ApplicationClass.owners.get(index).getMake().equals("Mercedes")){
            ivCarLogo.setImageResource(R.drawable.mercedes);
        } else {
            ivCarLogo.setImageResource(R.drawable.nissan);
        }
    }
}