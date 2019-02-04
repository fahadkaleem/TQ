package com.mohammedfahadkaleem.tafseerquran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.mohammedfahadkaleem.tafseerquran.utils.Tools;

public class MainActivity extends AppCompatActivity {
  private BottomNavigationView bottomNavigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loadFragment(FragmentMusicSong.newInstance());
    initComponent();
  }

  private void initComponent() {
    bottomNavigationView = findViewById(R.id.navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
          case R.id.navigation_recent:
            //mTextMessage.setText(item.getTitle());
            Fragment songListFragment = FragmentMusicSong.newInstance();
            loadFragment(FragmentMusicSong.newInstance());
            return true;
          case R.id.navigation_favorites:
            //mTextMessage.setText(item.getTitle());
            Intent intent = new Intent(MainActivity.this,PlayerMusicLight.class);
            startActivity(intent);
            return true;
          case R.id.navigation_nearby:
            //mTextMessage.setText(item.getTitle());
            loadFragment(FragmentMusicSong.newInstance());
            return true;
        }
        return false;
      }
    });
    Tools.setSystemBarColor(this, R.color.grey_5);
    Tools.setSystemBarLight(this);
  }

  private boolean loadFragment(Fragment fragment) {
    //switching fragment
    if (fragment != null) {
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.fragment_container, fragment)
          .commit();
      return true;
    }
    return false;
  }


}