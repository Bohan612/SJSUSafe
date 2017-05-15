package com.example.bohan.sjsusafe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SJSU,15));



        mMap.addMarker(new MarkerOptions()
                .position(ArtBuilding)
                .title("Department of Art").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(ADM)
                .title("Administration").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(StudentUnion)
                .title("Student Union").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(MLK)
                .title("Martin Luther King Library").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(ASPrint)
                .title("Associated Student Print Shop").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(ClarkHall)
                .title("Clark Hall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(Music)
                .title("The school of Music and Dance").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(EventCenter)
                .title("Event Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(VillageMarket)
                .title("Village Market I").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(DC)
                .title("Dinning commons").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(Starbucks)
                .title("StarBucks").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(BBC)
                .title("Boccardo Business Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(CareerCenter)
                .title("Career Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(Mech)
                .title("Building of Engineering").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions()
                .position(WellnessCenter)
                .title("Wellness Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        mMap.addMarker(new MarkerOptions()
                .position(CampusVillageA)
                .title("Campus Village A").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(SpartanMemorial)
                .title("Spartan Memorial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(AS)
                .title("Associated Students").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(Morris)
                .title("Morris Dalley Auditorium").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        mMap.addMarker(new MarkerOptions()
                .position(Lucas)
                .title("Lucas College and Graduate School of Business").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(McQuire)
                .title("MacQuirrie Hall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        mMap.addMarker(new MarkerOptions()
                .position(JoeWest)
                .title("JoeWest").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(PoliceDepartment)
                .title("University Police Department").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(Chem)
                .title("Department of Chemistry").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(Mech)
                .title("Mechanical Engineering").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(Dudley)
                .title("Dudley Morrey Hall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(SthGarage)
                .title("South Garage").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));












        // mMap.addMarker(new MarkerOptions()
         //       .position(ArtBuilding)
           //     .title("Art Building").icon(vectorToBitmap(R.drawable.ic_menu_camera, Color.parseColor("#db4437"))));





    }



}
