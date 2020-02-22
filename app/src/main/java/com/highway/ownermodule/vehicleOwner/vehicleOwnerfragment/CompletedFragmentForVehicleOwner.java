package com.highway.ownermodule.vehicleOwner.vehicleOwnerfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.highway.R;
import com.highway.common.base.activity.DashBoardActivity;
import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.allHighwayTripModel.CompletedTrip;
import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.allHighwayTripModel.OngoingTrip;
import com.highway.ownermodule.vehicleOwner.vehicleOwnerAdapter.CompletedTripAdapterForVehicleOwner;
import com.highway.ownermodule.vehicleOwner.vehicleOwnerAdapter.OnGoingTripAdapterForVehicleOwner;

import java.util.ArrayList;
import java.util.List;


public class CompletedFragmentForVehicleOwner extends Fragment {
    DashBoardFragmentForVehicleOwner dashBoardFragmentForVehicleOwner;
    RecyclerView completedRecycler;
    DashBoardActivity dashBoardActivity;
    Context context;
    CompletedTripAdapterForVehicleOwner completedTripAdapterForVehicleOwner;
    SwipeRefreshLayout swiptorefresh;

    public CompletedFragmentForVehicleOwner() {

    }


    public static CompletedFragmentForVehicleOwner newInstance(String param1, String param2) {
        CompletedFragmentForVehicleOwner fragment = new CompletedFragmentForVehicleOwner();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle_completed, container, false);
        completedRecycler = view.findViewById(R.id.CompletedRecyclerViewForVehicle);
        swiptorefresh = view.findViewById(R.id.swiptorefresh);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dashBoardActivity = (DashBoardActivity) getActivity();

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public void vehiclecompletedUpdatedTripList(List<CompletedTrip> completedTrips) {
        if (completedTrips!=null && completedTrips.size()>0){
            completedTripAdapterForVehicleOwner = new CompletedTripAdapterForVehicleOwner(completedTrips,getActivity());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            completedRecycler.setLayoutManager(layoutManager);
            completedRecycler.setItemAnimator(new DefaultItemAnimator());
            completedRecycler.setAdapter(completedTripAdapterForVehicleOwner);
        }else{
            Toast.makeText(dashBoardActivity, "No! trip data are found for Completed trip for vehicle owner", Toast.LENGTH_SHORT).show();
        }
    }
}
