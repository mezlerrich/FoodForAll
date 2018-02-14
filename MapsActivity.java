package com.example.max.foodforall;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

/* TODO
Location Listener mit Location daten füttern (ich bin mir nicht sicher, welche stelle am sinnvollsten zur deklaration ist)
manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, listener); zusätzlich zu
NETWORK_PROVIDER
custom marker bzw aus array von food-objekten marker erstellen
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager manager;
    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.d("POS", "onLocationChanged()");
            if (location != null){
                Toast toast = Toast.makeText(getApplicationContext(), "Location changed", Toast.LENGTH_LONG);
                position = new LatLng(location.getLatitude(), location.getLongitude());
                //position = new LatLng(49.9596, 7.9194);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
            }
            Toast toast = Toast.makeText(getApplicationContext(), "onLocation called, no location changed", Toast.LENGTH_LONG);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status){
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("status", "Out of service\n");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("status", "Temporarily unavailable\n");
                    break;
            }
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.d("status", "Provider enabled\n");
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d("status", "Provider disabled\n");
        }
    };
    private LatLng position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
       /* listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("POS", "onLocationChanged()");
                if (location != null){
                    Toast toast = Toast.makeText(getApplicationContext(), "Location changed", Toast.LENGTH_LONG);
                    position = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                switch (status){
                    case LocationProvider.OUT_OF_SERVICE:
                        Log.d("status", "Out of service\n");
                        break;
                    case LocationProvider.TEMPORARILY_UNAVAILABLE:
                        Log.d("status", "Temporarily unavailable\n");
                        break;
                }
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d("status", "Provider enabled\n");
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d("status", "Provider disabled\n");
            }
        };*/
        /*if (checkingPermission()){
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, listener);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, listener);
        }*/
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //stelle für  manager.requestLocationUpdates sinnvoll / richtig?
        if (checkingPermission()) {
            //manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, listener);
            mMap.setMyLocationEnabled(true);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, listener);
        }
        position = new LatLng(49.9596, 7.9194);
        mMap.addMarker(new MarkerOptions().position(position).title("Bingen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
    }
    private boolean checkingPermission()
    {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionFine = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PERMISSION_GRANTED && permissionFine == PERMISSION_GRANTED){
            //Toast toast = Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG);
            //toast.show();
            return true;
        }

        return false;
    }
    @Override
        protected void onStart(){
        super.onStart();
       // checkPermission()


    }
}
