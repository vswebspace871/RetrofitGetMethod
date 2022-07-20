package com.example.vbvretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    // getting all data simply
/*    @GET("posts")
    Call<List<Model>> getPosts();*/



    //get all data but using Query
//    @GET("posts")
//    Call<List<Model>> getPosts(@Query("userId") int userId);//retrofit automatically make questionmark
    // and will add query perimeter




    // get all data using MULTIPLE QUERY on endpoint
   /* @GET("posts")
    Call<List<Model>> getPosts(
            @Query("userId") int userId,// agar query me NULL bhejna hai to , int se INTEGER karo
            @Query("_sort") String sort,// null value primitive par nahi kaam karegi
            @Query("_order") String order
    );*/



    //agar do userID ka eksath query Search karna hai to ...
   /* @GET("posts")
    Call<List<Model>> getPosts(
            @Query("userId") int userId,// agar query me NULL bhejna hai to , int se INTEGER karo
            @Query("userId") int userId2,
            @Query("_sort") String sort,// null value primitive par nahi kaam karegi
            @Query("_order") String order
    );*/




    // agar do nahin 4,5 userID se query search karna ho to ArrayList bana do....
    @GET("posts")
    Call<List<Model>> getPosts(
            @Query("userId") Integer[] userId,// agar query me NULL bhejna hai to , int se INTEGER karo

            @Query("_sort") String sort,// null value primitive par nahi kaam karegi
            @Query("_order") String order
    );





    /* @GET("posts/2/comments")
     Call<List<ModelComment>> getComments();
 */



    //    agar Dynamic end point using Path karna hai to

    //    @GET("posts/{id}/comments")
    //    Call<List<ModelComment>> getComments(@Path("id") int postId);
    // @Path me jo value hogi wo same @Get wale end point se match honi chaiye




}
