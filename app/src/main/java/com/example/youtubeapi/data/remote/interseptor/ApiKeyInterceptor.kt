package com.example.youtubeapi.data.remote.interseptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("key", "AIzaSyCnaggQ7lqRlvEjcv9rsnwIrb8dnhpOnJk").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}