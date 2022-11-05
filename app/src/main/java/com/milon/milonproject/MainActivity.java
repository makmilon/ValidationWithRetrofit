package com.milon.milonproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.milon.milonproject.Fragment.AccountFragment;
import com.milon.milonproject.Fragment.HistoryFragment;
import com.milon.milonproject.Fragment.HomeFragment;
import com.milon.milonproject.Fragment.OnlineFragment;
import com.milon.milonproject.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        nav=(NavigationView)findViewById(R.id.navdrawermenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,new ProfileFragment()).commit();
        nav.setCheckedItem(R.id.menu_home);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp;
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_online:
                        temp=new OnlineFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,temp).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_account:
                        temp=new AccountFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,temp).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout:

                        Dialog dialog1 = new Dialog(MainActivity.this);
                        dialog1.setContentView(R.layout.dialog_logout_layout);
                        dialog1.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialogue_background));
                        dialog1.setCancelable(false);
                        dialog1.show();

                        TextView yesText=dialog1.findViewById(R.id.textYes);
                        TextView noText=dialog1.findViewById(R.id.textNo);

                        yesText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                SharedPreferences sp= getSharedPreferences("details",MODE_PRIVATE);
                                SharedPreferences.Editor myEdit = sp.edit();
                                myEdit.remove("user_name");
                                myEdit.remove("user_lastname");
                                myEdit.remove("user_password");
                                myEdit.commit();
                                Toast.makeText(MainActivity.this, "Log out is Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();

                            }
                        });

                        noText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialog1.dismiss();


                            }
                        });


                        break;
                }
                return true;
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId())
            {
                case R.id.menu_home:
                    fragment=new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack("tag").commit();
                    break;

                case R.id.menu_video:
                    fragment=new VideoFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;

                case R.id.menu_history:
                    fragment=new HistoryFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;

                case R.id.menu_profile:
                    fragment=new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;




            }
            return true;
        }
    };



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();

    }

}
