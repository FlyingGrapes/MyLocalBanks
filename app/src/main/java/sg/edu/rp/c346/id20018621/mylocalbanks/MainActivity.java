package sg.edu.rp.c346.id20018621.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs, tvOcbc, tvUob;
    String wordClicked="";
    boolean favdbs = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.dbs);
        tvOcbc = findViewById(R.id.ocbc);
        tvUob = findViewById(R.id.uob);

        //to register TextView to the context menu should be associated by calling registerForContextMenu(),
        //pass in TextView variable
        registerForContextMenu(tvDbs);
        registerForContextMenu(tvUob);
        registerForContextMenu(tvOcbc);
    }


    //for context
    //create Context Menu (long click event)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact");
        menu.add(0,2,2,"Toggle Favourite");
        if(v==tvDbs){
            wordClicked = "1st";
        }else if(v == tvOcbc){
            wordClicked = "2nd";
        }else if(v==tvUob){
            wordClicked = "3rd";
        }
    }

    //context menu selection
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //for "1st (tvDbs)
        if (wordClicked.equalsIgnoreCase("1st")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.urldbs)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.tel) + getResources().getString(R.string.dbsnum)));
                startActivity(intentCall);

            } else if (item.getItemId() == 2){
                if(tvDbs.getCurrentTextColor()!=getResources().getColor(android.R.color.holo_red_dark)){
                    tvDbs.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }else{
                    tvDbs.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        }
        //for "2nd (tvOcbc)
        else if (wordClicked.equalsIgnoreCase("2nd")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.urlocbc)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.tel) + getResources().getString(R.string.ocbcnum)));
                startActivity(intentCall);
            }  else if (item.getItemId() == 2){
                if(tvOcbc.getCurrentTextColor()!=getResources().getColor(android.R.color.holo_red_dark)){
                    tvOcbc.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }else{
                    tvOcbc.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        }
        //for "3rd (tvUob)
        else if (wordClicked.equalsIgnoreCase("3rd")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.urluob)));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getResources().getString(R.string.tel) + getResources().getString(R.string.uobnum)));
                startActivity(intentCall);
            }  else if (item.getItemId() == 2){
                if(tvUob.getCurrentTextColor()!=getResources().getColor(android.R.color.holo_red_dark)){
                    tvUob.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }else{
                    tvUob.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }



    //options menu (top right)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //perform LANGUAGES transition for options menu(upon opt selected)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //assign id
        int id = item.getItemId();

        if (id == R.id.engSelection){
            tvDbs.setText("DBS");
            tvUob.setText("UOB");
            tvOcbc.setText("OCBC");
            return true;

        } else if (id == R.id.chiSelection){
            tvDbs.setText(getResources().getString(R.string.xzyh));
            tvOcbc.setText(getResources().getString(R.string.hjyh));
            tvUob.setText(getResources().getString(R.string.thyh));
            return true;

        } else {
            tvOcbc.setText(getResources().getString(R.string.error));
            tvDbs.setText(getResources().getString(R.string.error));
            tvUob.setText(getResources().getString(R.string.error));
        }
        return super.onOptionsItemSelected(item);
    }


}