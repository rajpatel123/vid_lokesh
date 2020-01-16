package com.highway.commonretrofit;


import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.AllHighwayTripsRequest;
import com.highway.common.base.commonModel.customerDiverOwnerModelsClass.AllHighwayTripsResponse;
import com.highway.common.base.commonModel.login.LoginRegisterRequest;
import com.highway.common.base.commonModel.otpverify.VerifyOtpRequest;
import com.highway.common.base.commonModel.otpverify.VerifyOtpResponse;
import com.highway.common.base.commonModel.registration.RegistrationRequest;
import com.highway.common.base.commonModel.registration.RegistrationResponse;
import com.highway.customer.customerModelClass.bookingVehicleList.BookingVehicleListRequest;
import com.highway.customer.customerModelClass.bookingVehicleList.BookingVehicleListResponse;
import com.highway.customer.customerModelClass.selectYoursGoodsType.GoodsTypeDataRequest;
import com.highway.customer.customerModelClass.selectYoursGoodsType.GoodsTypeDataResponse;
import com.highway.customer.customerModelClass.updateReceiverModel.UpdateReceiverPhoneNoAndNameRequest;
import com.highway.customer.customerModelClass.updateReceiverModel.UpdateReceiverPhoneNoAndNameResponse;
import com.highway.customer.customerModelClass.vehicleInfo.VehicleInfoRequest;
import com.highway.customer.customerModelClass.vehicleInfo.VehicleInfoResponse;
import com.highway.millUserModule.SpinnerModelForMiller.ApproxLoad.ApproxLoadDropDownRequest;
import com.highway.millUserModule.SpinnerModelForMiller.ApproxLoad.ApproxLoadDropDownResponse;
import com.highway.millUserModule.SpinnerModelForMiller.GoodsTypes.GoodsTypeDropDownRequest;
import com.highway.millUserModule.SpinnerModelForMiller.GoodsTypes.GoodsTypesDropDownResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addNewDriverThroughVehicleOwner.AddNewDriverRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addNewDriverThroughVehicleOwner.AddNewDriverResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addVehicle.AddVehicleRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.addVehicle.AddVehicleResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.vehicleAssignSpinner.VehicleAssignDropDowanRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.vehicleAssignSpinner.VehicleAssignDropDowanResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.vehiceLoadCapicity.VehicleLoadCapicityRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.vehiceLoadCapicity.VehicleLoadCapicityResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.vehicleDimensionSize.VehicleDiamensionSizeRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.vehicleDimensionSize.VehicleDiamensionSizeResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.assignD2V_Model.AssignD2VRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.assignD2V_Model.AssignD2VResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.driverAssignSpinner.DriverDropDownRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.assignD2V.driverAssignSpinner.DriverDropDownResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllDriver.GetAllDriverRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllDriver.GetAllDriverResponse;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllVehicle.GetAllVehicleRequest;
import com.highway.ownermodule.vehicleOwner.vehileOwnerModelsClass.getAllVehicle.GetAllVehicleResponse;
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
    @POST("http://dev.thehighways.in/index.php/api/Vehicle/addVehicle")
    Call<AddVehicleResponse>addVehicleResponseCall(@Body AddVehicleRequest addVehicleRequest);

    // Add new Driver
    @POST("http://dev.thehighways.in/index.php/api/Login/addDriver")
    Call<AddNewDriverResponse>addNewDriverResponseCall(@Body AddNewDriverRequest addNewDriverRequest);

   // vehicle type drop dowan --spinner for vehicle owners for Add new Vehicle
    @POST("http://dev.thehighways.in/api/Vehicle/vehicleTypeDropdown")
    Call<VehicleTypeDropDowanResponse>vehicleTypeDropDowanResp(@Body VehicleTypeDropDowanRequest vehicleTypeDropDowanRequest);

    // Driver drop down ----spinners
    @POST("http://dev.thehighways.in/index.php/api/vehicle/driverDropdown")
    Call<DriverDropDownResponse>driverDataResponse(@Body DriverDropDownRequest driverDropDownRequest);

    //vehicle drop dowan --spinner for AssignD2V
    @POST("http://dev.thehighways.in/index.php/api/vehicle/vehicleAssignDropdown")
    Call<VehicleAssignDropDowanResponse> VEHICLE_ASSIGN_DROP_DOWAN_RESPONSE_CALL(@Body VehicleAssignDropDowanRequest vehicleAssignDropDowanRequest);

    // Assign Driver 2 vehicle
    @POST("http://dev.thehighways.in/api/Vehicle/assignDriverToVehicle")
    Call<AssignD2VResponse>assignD2VReq(@Body AssignD2VRequest assignD2VRequest);

    // Goods  Types in miller module ..book load ----Spinners
    @POST("http://dev.thehighways.in/index.php/api/trip/goodType")
    Call<GoodsTypesDropDownResponse>goodsTypesResponse(@Body GoodsTypeDropDownRequest goodsTypeDropDownRequest);

    // Approx load spinners -- for miller Book load
    @POST("http://dev.thehighways.in/index.php/api/trip/approxLoad")
    Call<ApproxLoadDropDownResponse> approxLoadResponse(@Body ApproxLoadDropDownRequest approxLoadDropDownRequest);

    // getAll Driver List for owner;
    @POST("http://dev.thehighways.in/index.php/api/login/getAlldriverDetails")
    Call<GetAllDriverResponse>getAllDriverDetailsRes(@Body GetAllDriverRequest getAllDriverRequest);

    @POST("http://dev.thehighways.in/index.php/api/Vehicle/getAllVehicleDetails")
    Call<GetAllVehicleResponse>getVehicleResponse(@Body GetAllVehicleRequest getAllVehicleRequest);

    //Goods type DataVehicle Booking With details Activity
    @POST("http://dev.thehighways.in/api/Trip/selectYourGoodType")
     Call<GoodsTypeDataResponse>SELECT_UR_GOODS_TYPE_DATA_RESPONSE_CALL(@Body GoodsTypeDataRequest goodsTypeDataRequest);

    // Add receiver mob no and name
    @POST("http://dev.thehighways.in/api/Login/updateReceiver")
    Call<UpdateReceiverPhoneNoAndNameResponse>UPDATE_RECEIVER_PHONE_NO_AND_NAME_RESPONSE_CALL(@Body UpdateReceiverPhoneNoAndNameRequest updateReceiverPhoneNoAndNameRequest);

       /// vehicle diamension size in add vehicle through vehicle owner
    @POST("http://dev.thehighways.in/api/Vehicle/vehicleDimensionSize")
    Call<VehicleDiamensionSizeResponse>VEHICLE_DIAMENSION_SIZE_RESPONSE_CALL(@Body VehicleDiamensionSizeRequest vehicleDiamensionSizeRequest);

    // vehicle load capicity through vehicle owner
    @POST("http://dev.thehighways.in/api/Vehicle/vehicleLoadingCapicity")
    Call<VehicleLoadCapicityResponse>VEHICLE_LOAD_CAPICITY_RESPONSE_CALL(@Body VehicleLoadCapicityRequest vehicleLoadCapicityRequest);

  // Booking vehicle List
   @POST("http://dev.thehighways.in/api/Vehicle/bookingVehicleList")
    Call<BookingVehicleListResponse>BOOKING_VEHICLE_LIST_RESPONSE_CALL(@Body BookingVehicleListRequest bookingVehicleListRequest);

   // Vehicle Info
   @POST("http://dev.thehighways.in/api/Vehicle/getVehicleinfo")
    Call<VehicleInfoResponse>VEHICLE_INFO_RESPONSE_CALL(@Body VehicleInfoRequest vehicleInfoRequest);

}
