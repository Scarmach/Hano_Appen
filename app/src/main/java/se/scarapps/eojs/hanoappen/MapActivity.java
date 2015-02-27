package se.scarapps.eojs.hanoappen;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class MapActivity extends Activity implements OnMapReadyCallback{

    static final LatLng HANO = new LatLng(56.009949, 14.846024);
    static final LatLng FYREN = new LatLng(56.013792, 14.846128);
    static final LatLng VINDHALLA = new LatLng(56.009408, 14.856536);
    static final LatLng BONSACKEN = new LatLng(56.018784, 14.834176);
    static final LatLng HAMNEN = new LatLng(56.010449, 14.836041);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    public void onMapReady(GoogleMap map){

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(HANO,14));



        Marker fyren = map.addMarker(new MarkerOptions()
                .title("Fyren")
                .snippet("Information om Fyren")
                .position(FYREN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        Marker vindhalla = map.addMarker(new MarkerOptions()
                .title("Vindhalla")
                .snippet("Information om Vindhalla")
                .position(VINDHALLA)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        Marker bonsacken = map.addMarker(new MarkerOptions()
                .title("Bönsäcken")
                .snippet("Information om Bönsäcken")
                .position(BONSACKEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        Marker hamnen = map.addMarker(new MarkerOptions()
                .title("Hamnen")
                .snippet("Information om Hamnen")
                .position(HAMNEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        Marker bygdegarden = map.addMarker(new MarkerOptions()
                .title("Bygdegården")
                .snippet("Information om Bygdegården")
                .position(HAMNEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        Marker missionshuset = map.addMarker(new MarkerOptions()
                .title("Missionshuset")
                .snippet("Information om missionshuset")
                .position(FYREN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        Marker museet = map.addMarker(new MarkerOptions()
                .title("Museét")
                .snippet("Information om museét")
                .position(HAMNEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        map.addPolyline(new PolylineOptions().geodesic(true)
                .color(Color.RED)
                .width(2.0f)
                .add(FYREN)
                .add(new LatLng(56.011622, 14.849100))
                .add(VINDHALLA));

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
