package com.highway.drivermodule.driverFragment;

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

import com.highway.R;
import com.highway.common.base.activity.DashBoardActivity;
import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.allHighwayTripModel.OngoingTrip;
import com.highway.drivermodule.driverAdapter.OnGoingTripAdapterForDriver;

import java.util.ArrayList;
import java.util.List;


public class OnGoingFragmentForDriver extends Fragment {
    private List<OngoingTrip> ongoingTrips = new ArrayList<>();
    RecyclerView onGoingRecyForDriver;
    DashBoardActivity dashBoardActivity;
    OnGoingTripAdapterForDriver onGoingTripAdapterForDriver;

    public OnGoingFragmentForDriver() {}

    public static OnGoingFragmentForDriver newInstance() {
        OnGoingFragmentForDriver fragment = new OnGoingFragmentForDriver();
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
        View view = inflater.inflate(R.layout.fragment_driver_on_going, container, false);
        onGoingRecyForDriver = view.findViewById(R.id.OnGoingRecyclerForDriver);
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

    public void onGoingUpdatedTripListForDriver(List<OngoingTrip> ongoingTrips) {
        if (ongoingTrips != null && ongoingTrips.size() > 0) {
            onGoingTripAdapterForDriver = new OnGoingTripAdapterForDriver(ongoingTrips, getContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            onGoingRecyForDriver.setLayoutManager(layoutManager);
            onGoingRecyForDriver.setItemAnimator(new DefaultItemAnimator());
            onGoingRecyForDriver.setAdapter(onGoingTripAdapterForDriver);
        }else{
            Toast.makeText(dashBoardActivity, "Something is wrong of Ongoing trip list for Driver", Toast.LENGTH_SHORT).show();
        }
    }
}



