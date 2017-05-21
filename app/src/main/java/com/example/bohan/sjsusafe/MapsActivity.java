package com.example.bohan.sjsusafe;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    public BitmapDescriptor vectorToBitmap(@DrawableRes int id, @ColorInt int color) {
        Drawable vectorDrawable = ResourcesCompat.getDrawable(getResources(), id, null);
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        DrawableCompat.setTint(vectorDrawable, color);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
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
        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        // Add a marker in Sydney and move the camera
        LatLng SJSU = new LatLng(37.3356807, -121.8821639);
        LatLng ArtBuilding = new LatLng(37.3356807, -121.8821639);
        LatLng ADM = new LatLng(37.3356807, -121.8821639);
        LatLng StudentUnion = new LatLng(37.336387, -121.881273);
        LatLng Mech=new LatLng(37.337225,-121.881573);
        LatLng CareerCenter=new LatLng(37.336841,-121.882783);
        //LatLng Indus=new LatLng(37.337807,-121.880991);
        LatLng BBC=new LatLng(37.336747,-121.878446);
        LatLng Starbucks=new LatLng(37.3367257,-121.880296);
        LatLng DC=new LatLng(37.333983,-121.878414);
        LatLng VillageMarket=new LatLng(37.33522,-121.87704);
        LatLng EventCenter=new LatLng(37.335233,-121.880146);
        LatLng Music=new LatLng(37.335421,-121.880854);
        LatLng ClarkHall=new LatLng(37.335868,-121.88256);
        LatLng ASPrint=new LatLng(37.3367257,-121.8802965);
        LatLng MLK=new LatLng(37.335536,-121.885543);


        LatLng WellnessCenter=new LatLng(37.334742,-121.881231);
        LatLng CampusVillageA=new LatLng(37.3353836,-121.8819298);
        LatLng SpartanMemorial=new LatLng(37.3340118,-121.8833213);
        LatLng AS=new LatLng(37.3340118,-121.8827001);
        LatLng Morris=new LatLng(37.335271,-121.8833333);
        LatLng McQuire=new LatLng(37.3336549,-121.8840585);
        LatLng JoeWest=new LatLng(37.3343967,-121.8780669);
        LatLng PoliceDepartment=new LatLng(37.3334822,-121.8803096);
        LatLng SthGarage=new LatLng(37.333075,-121.881096);
        LatLng Chem=new LatLng(37.3329116,-121.8820394);
        LatLng Dudley=new LatLng(37.336726,-121.883622);
        LatLng Lucas=new LatLng(37.336726,-121.883622);



        mMap.addMarker(new MarkerOptions().position(SJSU).title("Marker in San Jose State University"));
        // Zoom level 20 -Street view
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SJSU,17));



        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("Department of Art").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(ADM)
                .title("Administration").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(StudentUnion)
                .title("Student Union").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(MLK)
                .title("Martin Luther King Library").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(ASPrint)
                .title("Associated Student Print Shop").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(ClarkHall)
                .title("Clark Hall").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(Music)
                .title("The school of Music and Dance").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(EventCenter)
                .title("Event Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(VillageMarket)
                .title("Village Market I").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(DC)
                .title("Dinning commons").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(Starbucks)
                .title("StarBucks").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(BBC)
                .title("Boccardo Business Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(CareerCenter)
                .title("Career Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(Mech)
                .title("Building of Engineering").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.addMarker(new MarkerOptions()
                .position(WellnessCenter)
                .title("Wellness Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));


        mMap.addMarker(new MarkerOptions()
                .position(CampusVillageA)
                .title("Campus Village A").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(SpartanMemorial)
                .title("Spartan Memorial").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(AS)
                .title("Associated Students").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(Morris)
                .title("Morris Dalley Auditorium").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));


        mMap.addMarker(new MarkerOptions()
                .position(Lucas)
                .title("Lucas College and Graduate School of Business").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(McQuire)
                .title("MacQuirrie Hall").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));


        mMap.addMarker(new MarkerOptions()
                .position(JoeWest)
                .title("JoeWest").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(PoliceDepartment)
                .title("University Police Department").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(Chem)
                .title("Department of Chemistry").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(Mech)
                .title("Mechanical Engineering").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(Dudley)
                .title("Dudley Morrey Hall").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        mMap.addMarker(new MarkerOptions()
                .position(SthGarage)
                .title("South Garage").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

         mMap.addMarker(new MarkerOptions()
               .position(ArtBuilding)
                .title("12/07/16 Sexual Battery").icon(BitmapDescriptorFactory.fromResource(R.drawable.sexualasssault)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.332955, -121.880967))
                .title("01/16/16 Purse Snatch").icon(BitmapDescriptorFactory.fromResource(R.drawable.robbery)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.333842, -121.881262))
                .title("01/06/16 Vehicles Burglaries").icon(BitmapDescriptorFactory.fromResource(R.drawable.robbery)));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.334013,-121.878312))
                .title("05/03/15 Dinning Commons").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.337041,-121.87976))
                .title("05/03/16 Fire").icon(BitmapDescriptorFactory.fromResource(R.drawable.fire)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.336457,-121.878725))
                .title("18/04/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.335493,-121.87976))
                .title("12/07/16 Chemical hazard").icon(BitmapDescriptorFactory.fromResource(R.drawable.hazard)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.336453,-121.879556))
                .title("01/07/16 Laptop Theft ").icon(BitmapDescriptorFactory.fromResource(R.drawable.robbery)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.335131,-121.880125))
                .title("04/02/16 ").icon(BitmapDescriptorFactory.fromResource(R.drawable.shooting)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.336342,-121.882292))
                .title("07/07/12 Vandalism").icon(BitmapDescriptorFactory.fromResource(R.drawable.vandalism)));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.336291,-121.883751))
                .title("02/06/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.332443,-121.8816648))
                .title("10/07/15 Robbery from an old lady").icon(BitmapDescriptorFactory.fromResource(R.drawable.robbery)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.332861,-121.881242))
                .title("06/07/15 Sexual battery").icon(BitmapDescriptorFactory.fromResource(R.drawable.sexualasssault)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.332712,-121.88182))
                .title("08/04/15 Sexual assault").icon(BitmapDescriptorFactory.fromResource(R.drawable.assault)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("01/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.soliciation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.solicitation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.solicitation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.solicitation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.solicitation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.solicitation)));

        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("12/07/16 Solicitation").icon(BitmapDescriptorFactory.fromResource(R.drawable.solicitation)));

    }

    protected synchronized void buildGoogleApiClient() {
     //   GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
       //         .addConnectionCallbacks(this)
         //       .addOnConnectionFailedListener(this)
           //     .addApi(LocationServices.API)
             //   .build();
       // mGoogleApiClient.connect();
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}









