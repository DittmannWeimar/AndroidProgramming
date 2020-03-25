package sdu.androidprogrammering.fragmentbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment blueFragment;
    Fragment redFragment;
    Fragment greenFragment;
    Fragment yellowFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        blueFragment = new BlueFragment();
        redFragment = new RedFragment();
        greenFragment = new GreenFragment();
        yellowFragment = new YellowFragment();

        //Blue button
        findViewById(R.id.blueButton).setOnClickListener(new View.OnClickListener() {
            //my solution
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, blueFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //Green button
        findViewById(R.id.greenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragment(greenFragment);
            }
        });

        //Red button
        findViewById(R.id.redButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragment(redFragment);
            }
        });

        //Yellow button
        findViewById(R.id.yellowButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragment(yellowFragment);
            }
        });
    }

    //greg's solution
    private void updateFragment(Fragment wantedFragment){
        FragmentTransaction fragTrans = fragmentManager.beginTransaction();
        fragTrans.replace(R.id.fragment_container, wantedFragment);
        fragTrans.addToBackStack(null);
        fragTrans.commit();
    }
}
