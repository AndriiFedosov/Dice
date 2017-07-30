package ua.andry.dice;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ua.andry.dice.fragments.OneEight;
import ua.andry.dice.fragments.OneFourFragment;
import ua.andry.dice.fragments.OneHundred;
import ua.andry.dice.fragments.OneSix;
import ua.andry.dice.fragments.OneTen;
import ua.andry.dice.fragments.OneTwelve;
import ua.andry.dice.fragments.OneTwenty;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {
    private static final int SHAKE_SENSITIVITY = 6;
    private SensorManager sensorManager;
    private float accel = SensorManager.GRAVITY_EARTH;
    private float accelPrevious = SensorManager.GRAVITY_EARTH;
    static int fragId;
    Fragment fragment;
    // Создадим новый фрагмент

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(
                sensorListener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.
        switch (item.getItemId()){
            case R.id.nav_d4:
                fragment = new OneFourFragment();
                fragId = 1;
                break;
            case R.id.nav_d6:
                fragment = new OneSix();
                fragId = 2;
                break;
            case R.id.nav_d8:
                fragment = new OneEight();
                fragId = 3;
                break;
            case R.id.nav_d10:
                fragment = new OneTen();
                fragId = 4;
                break;
            case R.id.nav_d12:
                fragment = new OneTwelve();
                fragId=5;
                break;
            case R.id.nav_d20:
                fragment = new OneTwenty();
                fragId = 6;
                break;
            case R.id.nav_d100:
                fragment = new OneHundred();
                fragId = 7;
                break;

        }


        // Вставляем фрагмент, заменяя текущий фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public final SensorEventListener sensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            accelPrevious = accel;
            accel = (float) Math.sqrt((double) (x * x + y * y + z * z));
            if (accel - accelPrevious > SHAKE_SENSITIVITY) {
                switch (fragId){
                    case 1 :
                        OneFourFragment.onShake();
                        break;
                    case 2 :
                        OneSix.onShake();
                        break;
                    case 3 :
                        OneEight.onShake();
                        break;
                    case 4 :
                        OneTen.onShake();
                        break;
                    case 5:
                        OneTwelve.onShake();
                        break;
                    case 6:
                        OneTwenty.onShake();
                        break;
                    case 7 :
                        OneHundred.onShake();
                        break;
                }

            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(
                sensorListener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(sensorListener);
        super.onStop();
    }


}
