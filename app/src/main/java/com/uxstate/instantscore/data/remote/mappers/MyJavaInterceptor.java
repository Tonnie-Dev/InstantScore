package com.uxstate.instantscore.data.remote.mappers;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class MyJavaInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("X-Custom-Header", "MyValue")
                .build();
        return chain.proceed(request);
    }
}