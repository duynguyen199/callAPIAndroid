package com.app.callapi.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface StudentApiService {

    String DOMAIN = "https://65e29073a8583365b3184085.mockapi.io/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();

    StudentApiService apiService = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(StudentApiService.class);


    // Tạo ra ra call

    @GET("student")
    Call<ArrayList<StudentModel>> getAllStudent();

    @GET("student/{id}")
    Call<StudentModel> getStudentById(@Path("id") String id);

    @POST("student")
    Call<StudentModel> postNewStudent(@Body RequestBody body);

    @DELETE("student/{id}")
    Call<StudentModel> deleteStudent(@Path("id") String id);


    @PUT ("student/{id}")
    Call<StudentModel> editStudent(@Body RequestBody body, @Path("id") String id);


}
