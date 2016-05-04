package demos.anwesh.com.demomaterial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.google.repacked.antlr.v4.Tool;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rec_v1);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout)findViewById(R.id.dr_view);
        final NavigationView navigationView = (NavigationView)findViewById(R.id.nav_bar);
        final ImageView imageView = (ImageView)(navigationView.getHeaderView(0).findViewById(R.id.header_image));
        CustomAdapter customAdapter = new CustomAdapter(this,getCustomObjects());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
        recyclerView.addItemDecoration(new CustomItemDecorator());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.profile:
                        Log.d("clicked on profile","Profile is clicked");
                        break;
                    case R.id.orders:
                        Log.d("clicked on orders","Orders is clicked");
                        break;
                    case R.id.help:
                        Log.d("Help is clicked","Help is clicked");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        navigationView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.setY(navigationView.getHeight()/16);
                imageView.setX(navigationView.getWidth()/4);
            }
        });
        final Bitmap profilePic = BitmapFactory.decodeResource(getResources(),R.drawable.mo);
        final Bitmap bitmap = ImageUtils.createCircularImage(profilePic);
        if(imageView!=null) {
            imageView.setImageBitmap(bitmap);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public List<CustomObject> getCustomObjects() {
        return new ArrayList<CustomObject>() {{
            add(new CustomObject("A1","http://media.caranddriver.com/images/media/51/2016-10best-cars-lead-photo-664005-s-original.jpg"));
            add(new CustomObject("A2","http://media.caranddriver.com/images/media/51/2016-10best-cars-lead-photo-664005-s-original.jpg"));
            add(new CustomObject("A3","http://media.caranddriver.com/images/media/51/2016-10best-cars-lead-photo-664005-s-original.jpg"));
            add(new CustomObject("A4","http://media.caranddriver.com/images/media/51/2016-10best-cars-lead-photo-664005-s-original.jpg"));
            add(new CustomObject("A5","http://media.caranddriver.com/images/media/51/2016-10best-cars-lead-photo-664005-s-original.jpg"));
        }};
    }
}
