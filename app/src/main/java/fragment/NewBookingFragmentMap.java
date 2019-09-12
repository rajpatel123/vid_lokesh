package fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.highway.R;
import com.highway.activity.ConfirmBooking;
import com.highway.activity.MainActivity;
import com.karumi.dexter.BuildConfig;


public class NewBookingFragmentMap extends Fragment implements OnMapReadyCallback, LocationListener {

    private static final String TAG = NewBookingFragmentMap.class.getSimpleName();
    SupportMapFragment mapFragment;
    LatLng origin = new LatLng(30.739834, 76.782702);
    LatLng dest = new LatLng(30.705493, 76.801256);

    LatLng sourceLocation;
    LatLng destLocation;

    // private OnFragmentInteractionListener mListener;
    private GoogleMap mMap;
    private int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    private LocationManager locationManager;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    private SupportMapFragment supportMapFragment;
    private MainActivity mainActivity;

    private ImageView imgPic_img, imgPickupFavoriteImg, imgDrop_img, imgDropAnotherLocationImg;
    private EditText edtSourceLocation, edtDestinationLocation;
    private View viewDrop;
    private LinearLayout linearLayoutBottomSheet;
    private LinearLayout conformBookingBottomSheet;
    private TextView TvAviVehicleName, TvNoAviVehicleName;
    private Button BookLatter, BookNow;

    public NewBookingFragmentMap() {
        // Required empty public constructor
    }

    public static NewBookingFragmentMap newInstance() {
        NewBookingFragmentMap fragment = new NewBookingFragmentMap();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_booking_map, container, false);


        if (!checkPermissions()) {
            requestPermissions();
        } else {
            loadMap();
        }

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        /*if (Build.VERSION.SDK_INT >= 21) {
            mainActivity.getWindow().setStatusBarColor(ContextCompat.getColor(mainActivity, R.color.transparent));
        }
*/
        /*fragment new booking id*/
        imgPic_img = view.findViewById(R.id.pic_img);
        imgPickupFavoriteImg = view.findViewById(R.id.pickupFavoriteImg);
        imgDrop_img = view.findViewById(R.id.drop_img);
        imgDropAnotherLocationImg = view.findViewById(R.id.DropAnotherLocation);
        viewDrop = view.findViewById(R.id.DropView);
        edtSourceLocation = view.findViewById(R.id.edt_pickUpFromLOcation);
        edtDestinationLocation = view.findViewById(R.id.edt_DropLOcation);
        /* bottomsheet new booking bottomSheet*/
        linearLayoutBottomSheet = view.findViewById(R.id.newBooking_bottom_sheet);
        TvAviVehicleName = view.findViewById(R.id.TxtAviVehicleName);
        TvNoAviVehicleName = view.findViewById(R.id.TxtNoAviVehicleName);
        BookLatter = view.findViewById(R.id.btnBookLatter);
        BookNow = view.findViewById(R.id.btnBookNow);
        /*Conform booking bootom sheet*/
        conformBookingBottomSheet = view.findViewById(R.id.ConformBookingBoottomSheet);



        BookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ConfirmBooking.class);
                startActivity(intent);
//                conformBookingBottomSheet.setVisibility(View.VISIBLE);

            }
        });



        return view;
    }

    private void requestPermissions() {
        boolean shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION);


        if (shouldProvideRationale) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE);

        } else {
            Log.i(NewBookingFragmentMap.class.getSimpleName(), "Requesting permission");
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    // map loading

    private void loadMap() {
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
    }


    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        try {
            mMap.setMyLocationEnabled(true);
        } catch (SecurityException ex) {
            if (!checkPermissions()) {
                requestPermissions();
            } else {
                loadMap();
            }
            ex.printStackTrace();
        }

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(origin, 15));

    }

    @Override
    public void onLocationChanged(Location location) {

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10);
        mMap.animateCamera(cameraUpdate);
        locationManager.removeUpdates(this);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {

                Log.i(TAG, "User interaction was cancelled.");

            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {    // Permission granted.
                loadMap();
            } else {

                showSnackbar(R.string.permission_denied_explanation, R.string.settings,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null);  // buildconfig error
                                intent.setData(uri);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        });
            }
        }
    }

    /**
     * @param text The Snackbar text.
     */
    private void showSnackbar(final String text) {
        View container = getActivity().findViewById(android.R.id.content);
        if (container != null) {
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show();
        }
    }

    private void showSnackbar(final int mainTextStringId, final int actionStringId, View.OnClickListener listener) {
        Snackbar.make(getActivity().findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }


    private  void DistanceBetweenSourceAndDestination(){

        Location locationA = new Location("point A");
        locationA.setLatitude(sourceLocation.latitude);
        locationA.setLongitude(sourceLocation.longitude);

        Location locationB = new Location("point B");
        locationB.setLatitude(destLocation.latitude);
        locationB.setLongitude(destLocation.longitude);

       /* double distance = locationA.distanceTo(locationB)/1000;
        Toast.makeText(navigationActivity,""+distance+"km", Toast.LENGTH_SHORT).show();*/

    }



}
