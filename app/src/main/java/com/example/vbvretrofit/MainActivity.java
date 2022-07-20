package com.example.vbvretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        getposts();

        //get_Comments();


    }

   /* private void get_Comments() {
        api = RetrofitInstance.getRetrofit().create(API.class);

        api.getComments(4).enqueue(new Callback<List<ModelComment>>() {
            @Override
            public void onResponse(Call<List<ModelComment>> call, Response<List<ModelComment>> response) {

                List<ModelComment> data = response.body();

                if (data != null) {
                    for (ModelComment item : data)
                    {
                        String content = "";
                        content += "postId : "+item.getPostId()+"\n\n";
                        content += "id : "+item.getId()+"\n\n";
                        content += "Name : "+item.getName()+"\n\n";
                        content += "email : "+item.getEmail()+"\n\n";
                        content += "body : "+item.getBody()+"\n\n\n\n\n";
                        textView.append(content);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<ModelComment>> call, Throwable t) {

            }
        });
    }*/

  /*  private void getposts() {
        api = RetrofitInstance.getRetrofit().create(API.class);

        api.getPosts(new Integer[]{1,2,3,4}, "id", "desc").enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Model>> call, @NonNull Response<List<Model>> response) {
                if (!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
                List<Model> data = response.body();
                if (data != null) {
                    for (Model item : data)
                    {
                        String content = "";
                        content += "userId : "+item.getUserId()+"\n";
                        content += "id : "+item.getId()+"\n";
                        content += "title : "+item.getTitle()+"\n";
                        content += "body : "+item.getSubTitle()+"\n\n\n";
                        textView.append(content);
                    }
                }


            }

            @Override
            public void onFailure(@NonNull Call<List<Model>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load response", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void getposts() {
        Map<String, String> parameters = new HashMap<>(); // hash map create kara hai
        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");


        api = RetrofitInstance.getRetrofit().create(API.class);

        api.getPosts(parameters).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(@NonNull Call<List<Model>> call, @NonNull Response<List<Model>> response) {
                if (!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
                List<Model> data = response.body();
                if (data != null) {
                    for (Model item : data)
                    {
                        String content = "";
                        content += "userId : "+item.getUserId()+"\n";
                        content += "id : "+item.getId()+"\n";
                        content += "title : "+item.getTitle()+"\n";
                        content += "body : "+item.getSubTitle()+"\n\n\n";
                        textView.append(content);
                    }
                }


            }

            @Override
            public void onFailure(@NonNull Call<List<Model>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load response", Toast.LENGTH_SHORT).show();
            }
        });
    }


}