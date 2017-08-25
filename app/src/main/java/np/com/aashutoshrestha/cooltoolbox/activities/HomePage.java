package np.com.aashutoshrestha.cooltoolbox.activities;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import np.com.aashutoshrestha.cooltoolbox.R;
import np.com.aashutoshrestha.cooltoolbox.adapters.PostAdapter;
import np.com.aashutoshrestha.cooltoolbox.models.DataModel;

public class HomePage extends AppCompatActivity{
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private RecyclerView recyclerView;
    private PostAdapter adapter;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext()) {
        };
        recyclerView = (RecyclerView) findViewById(R.id.contentList);
        adapter = new PostAdapter(getApplicationContext(),getData());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    public static List<DataModel> getData(){
        List<DataModel> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_user,R.drawable.ic_user,R.drawable.ic_user,R.drawable.ic_user,R.drawable.ic_user,R.drawable.ic_user};
        String[] titles = {"Man shot by his wife", "A child raped and killed", "Weather is good in kathmandu", "UML lost the election", "NASA went to Mars", "Gold price all time high"};
        String[] content = {"kjashdfkjasdhkjfhasdkljfhasdjkfhklsdjfhjklsdhfkljasdhfklasdjhfkljasd","asdfsdfsdafsdafsadfsfasdffasdfsdfsfsfsdfsdfsddafsafsadfsddafsd","asdfsafsadfasfsadfsadf","asdfsafsadfsadfsadf","sdfasdfsdfsdfsdafsdfsdafsdafsdafasdf","asdfasdfsadfsdafasdfasdfsdafasdf"};
        String[] dates= {"2017","2017","2017","2017","2017","2017"};
        for(int i=0; i<titles.length && i<icons.length; i++){
            DataModel dm  = new DataModel();
            dm.setImg(icons[i]);
            dm.setTitle(titles[i]);
            dm.setContent(content[i]);
            dm.setDate(dates[i]);

        }
        return data;
    }


    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

        // The action bar home/up action should open or close the drawer.
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                mDrawer.openDrawer(GravityCompat.START);
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
    }


}
