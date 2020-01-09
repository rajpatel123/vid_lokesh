package com.highway.commonretrofit;


import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.AllHighwayTripsRequest;
import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.AllHighwayTripsResponse;
import com.highway.common.base.commonModel.login.LoginRegisterRequest;
import com.highway.common.base.commonModel.otpverify.VerifyOtpRequest;
import com.highway.common.base.commonModel.otpverify.VerifyOtpResponse;
import com.highway.common.base.commonModel.registration.RegistrationRequest;
import com.highway.common.base.commonModel.registration.RegistrationResponse;
import com.highway.customer.customerModelClass.selectYoursGoodsType.selectUrGoodsModel.SelectUrGoodsTypeDataRequest;
import com.highway.customer.customerModelClass.selectYoursGoodsType.selectUrGoodsModel.SelectUrGoodsTypeDataResponse;
import com.highway.millUserModule.SpinnerModelForMiller.ApproxLoad.ApproxLoadDropDownRequest;
import com.highway.millUserModule.SpinnerModelForMiller.ApproxLoad.ApproxLoadDropDownResponse;
import com.highway.millUserModule.SpinnerModelForMiller.GoodsTypes.GoodsTypeDropDownRequest;
import com.highway.millUserModule.SpinnerModelForMiller.GoodsTypes.GoodsTypesDropDownResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addNewDriverThroughVehicleOwner.AddNewDriverRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addNewDriverThroughVehicleOwner.AddNewDriverResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addNewVehicleModel.AddVehicleRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addNewVehicleModel.AddVehicleResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.assignD2V_Model.AssignD2VRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.assignD2V_Model.AssignD2VResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.driverAssignSpinner.DriverDropDownRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.driverAssignSpinner.DriverDropDownResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.vehicleAssignSpinner.VehicleDropDowanRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.vehicleAssignSpinner.VehicleDropDowanResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllDriverDetailsList.GetAllDriverRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllDriverDetailsList.GetAllDriverResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllVehicleDetailsList.GetAllVehicleDetailsRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllVehicleDetailsList.GetAllVehicleDetailsResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.vehicleTypeDropDowan.VehicleTypeDropDowanRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.vehicleTypeDropDowan.VehicleTypeDropDowanResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("http://vrok.in/highway_dev/login_register")  // mobile logon
    Call<ResponseBody> loginResponseCall(@Body LoginRegisterRequest loginRequest);

    @POST("http://vrok.in/highway_dev/otp_verify") // otp verification
    Call<VerifyOtpResponse> verifyOtpResponseCall(@Body VerifyOtpRequest verifyOtpRequest);

    @POST("http://vrok.in/highway_dev/signup") // Registration Details
    Call<RegistrationResponse>regDetailsResponseCall(@Body RegistrationRequest registrationDetailsRequest);


    // Driver All Trips
    @POST("http://vrok.in/highway_dev/getAllTripByDriverId")
    Call<AllHighwayTripsResponse> driverTrips(@Body AllHighwayTripsRequest allHighwayTripsRequest);

    // Vehicle Owner trip details
    @POST("http://vrok.in/highway_dev/getAllTripByOwnerId")
    Call<AllHighwayTripsResponse>vehicleOwnerTrip(@Body AllHighwayTripsRequest allHighwayTripsRequest);

    // Miller all trips details
    @POST("http://vrok.in/highway_dev/getAllTripByOwnerId")
    Call<AllHighwayTripsResponse>millerTrip(@Body AllHighwayTripsRequest allHighwayTripsRequest);

    // Customer all trip
    @POST("http://vrok.in/highway_dev/getAllTripByCustomerId")
    Call<AllHighwayTripsResponse>customerTrip(@Body AllHighwayTripsRequest allHighwayTripsRequest);


     // Add New Vehicle
    @POST("http://highway.vrok.in/index.php/api/Vehicle/addVehicle")
    Call<AddVehicleResponse>addVehicleResponseCall(@Body AddVehicleRequest addVehicleRequest);

    // Add new Driver
    @POST("http://highway.vrok.in/index.php/api/Login/addDriver")
    Call<AddNewDriverResponse>addNewDriverResponseCall(@Body AddNewDriverRequest addNewDriverRequest);

   // vehicle type drop dowan --spinner for vehicle owners for Add new Vehicle
    @POST("http://highway.vrok.in/api/Vehicle/vehicleTypeDropdown")
    Call<VehicleTypeDropDowanResponse>vehicleTypeDropDowanResp(@Body VehicleTypeDropDowanRequest vehicleTypeDropDowanRequest);

    // Driver drop down ----spinners
    @POST("http://highway.vrok.in/index.php/api/vehicle/driverDropdown")
    Call<DriverDropDownResponse>driverDataResponse(@Body DriverDropDownRequest driverDropDownRequest);

    //vehicle drop dowan --spinner for AssignD2V
    @POST("http://highway.vrok.in/index.php/api/vehicle/vehicleDropdown")
    Call<VehicleDropDowanResponse> vehicleDataResponse(@Body VehicleDropDowanRequest vehicleDropDownRequest);

    // Assign Driver 2 vehicle
    @POST("http://highway.vrok.in/api/Vehicle/assignDriverToVehicle")
    Call<AssignD2VResponse>assignD2VReq(@Body AssignD2VRequest assignD2VRequest);


    // Goods  Types ----Spinners
    @POST("http://highway.vrok.in/index.php/api/trip/goodType")
    Call<GoodsTypesDropDownResponse>goodsTypesResponse(@Body GoodsTypeDropDownRequest goodsTypeDropDownRequest);

    // Approx load spinners -- for miller Book load
    @POST("http://highway.vrok.in/index.php/api/trip/approxLoad")
    Call<ApproxLoadDropDownResponse> approxLoadResponse(@Body ApproxLoadDropDownRequest approxLoadDropDownRequest);

    // getAll Driver List for owner;
    @POST("http://highway.vrok.in/index.php/api/login/getAlldriverDetails")
    Call<GetAllDriverResponse>getAllDriverDetailsRes(@Body GetAllDriverRequest getAllDriverRequest);

    @POST("http://highway.vrok.in/index.php/api/Vehicle/getAllVehicleDetails")
    Call<GetAllVehicleDetailsResponse>getVehicleResponse(@Body GetAllVehicleDetailsRequest getAllVehicleDetailsRequest);

    //Goods type Data Booking With details Activity
    @POST("http://highway.vrok.in/api/Trip/selectYourGoodType")
     Call<SelectUrGoodsTypeDataResponse>SELECT_UR_GOODS_TYPE_DATA_RESPONSE_CALL(@Body SelectUrGoodsTypeDataRequest selectUrGoodsTypeDataRequest);
}
