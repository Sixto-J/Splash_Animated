package com.example.splash_animated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {

    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


        ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
        String[] items = { getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help) };
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
        menuList.setAdapter(adapt);


        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                // Note: if the list was built "by hand" the id could be used.
                // As-is, though, each item has the same id
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_play))) {
                    // Launch the Game Activity
                    //startActivity(new Intent(MenuActivity.this, GameActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))) {
                    // Launch the Help Activity
                   // startActivity(new Intent(MenuActivity.this, HelpActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_settings))) {
                    // Launch the Settings Activity
                   // startActivity(new Intent(MenuActivity.this, SettingsActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_scores))) {
                    // Launch the Scores Activity
                   // startActivity(new Intent(MenuActivity.this, ScoresActivity.class));
                }
            }
        });


    }


}






