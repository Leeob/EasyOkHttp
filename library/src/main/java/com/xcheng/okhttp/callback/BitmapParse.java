package com.xcheng.okhttp.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

import com.xcheng.okhttp.error.BaseError;
import com.xcheng.okhttp.request.OkResponse;

import java.io.IOException;

import okhttp3.Response;

public class BitmapParse extends SimpleParse<Bitmap> {

    @NonNull
    @Override
    public OkResponse<Bitmap> parseNetworkResponse(OkCall<Bitmap> okCall, Response response, int id) throws IOException {
        if (response.isSuccessful()) {
            return OkResponse.success(BitmapFactory.decodeStream(response.body().byteStream()));
        }
        return OkResponse.error(BaseError.getNotFoundError("response error"));
    }
}