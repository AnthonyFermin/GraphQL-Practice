package com.fuzz.anthonyfermin.starwarsgraphql;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.anthonyfdev.graphQLQueryGen.models.GraphQL_GraphQLData;
import com.fuzz.anthonyfermin.starwarsgraphql.model.GraphQLResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private GraphQLRequestTask requestTask;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestTask = new GraphQLRequestTask();
        textView = (TextView) findViewById(R.id.text);
    }

    public void onClick(View v) {
        textView.setText(R.string.Loading);
        if (requestTask != null) {
            requestTask.cancel(true);
        }
        requestTask = new GraphQLRequestTask();
        requestTask.execute();
    }

    public class GraphQLRequestTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String graphQLRequest = GraphQL_GraphQLData.getQuery();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://graphql-swapi.parseapp.com")
                    .client(new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Log.d("REQUEST", String.format("\nrequest:\n%s\nheaders:\n%s",
                                    request.body(), request.headers()));
                            return chain.proceed(request);
                        }
                    }).build())
                    .addConverterFactory(com.github.aurae.retrofit2.LoganSquareConverterFactory.create())
                    .build();

            SwapiAPI swapiAPI = retrofit.create(SwapiAPI.class);
            Call<GraphQLResponse> call = swapiAPI.getGenData(new GraphQLQuery(graphQLRequest));
            String response = null;
            try {
                Response<GraphQLResponse> stringResponse = call.execute();
                if (stringResponse.body() == null) {
                    response = stringResponse.errorBody().string();
                } else {
                    response = stringResponse.body().toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                textView.setText(s);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (requestTask != null) {
            requestTask.cancel(true);
            requestTask = null;
        }
    }

    public interface SwapiAPI {

        @POST("/")
        Call<GraphQLResponse> getGenData(@Body GraphQLQuery body);

    }
}
