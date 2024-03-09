package com.app.callapi.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getAllData();

        //getStudentById();v

//        addNewData(new StudentModel("", "Pham Truong", "23478", "hkdgsfhkas", ""));
//        deleteStudent();
        editStudent(new StudentModel("3", "Duy Nguyen","009999","hhffkso", ""));
    }
    private void getAllData() {
        StudentApiService.apiService.getAllStudent().enqueue(new Callback<ArrayList<StudentModel>>() {
            @Override
            public void onResponse(Call<ArrayList<StudentModel>> call, Response<ArrayList<StudentModel>> response) {
                Toast.makeText(MainActivity.this, "Call Ok", Toast.LENGTH_SHORT).show();

                ArrayList<StudentModel> listData = response.body();

                for (StudentModel item : listData) {
                    Log.e("truong", "data: " + item.getName());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<StudentModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getStudentById() {
        StudentApiService.apiService.getStudentById("200").enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                Toast.makeText(MainActivity.this, "Call Ok", Toast.LENGTH_SHORT).show();

                StudentModel item = response.body();
                if (item != null)
                    Log.e("truong", "data: " + item.getName());
                else
                    Log.e("truong", "data: " + "null");
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteStudent(){
        StudentApiService.apiService.deleteStudent("2").enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Fail", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void editStudent(StudentModel studentModel){
        JSONObject jsonObject= new JSONObject();

        try {
            jsonObject.put("name", studentModel.getName());
            jsonObject.put("phone", studentModel.getPhone());
            jsonObject.put("avatar", studentModel.getAvatar());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(mediaType, jsonObject.toString());

        StudentApiService.apiService.editStudent(requestBody, studentModel.getId()).enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                Toast.makeText(MainActivity.this, "PUT OK", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail ", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void addNewData(StudentModel studentModel) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name", studentModel.getName());
            jsonObject.put("phone", studentModel.getPhone());
            jsonObject.put("avatar", studentModel.getAvatar());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(mediaType, jsonObject.toString());


        StudentApiService.apiService.postNewStudent(requestBody).enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                Toast.makeText(MainActivity.this, "Post OK", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Post Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}