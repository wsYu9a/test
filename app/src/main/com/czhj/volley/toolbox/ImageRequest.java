package com.czhj.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Request;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyLog;

/* loaded from: classes2.dex */
public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;

    /* renamed from: g */
    public static final Object f8812g = new Object();

    /* renamed from: a */
    public final Object f8813a;

    /* renamed from: b */
    public final Bitmap.Config f8814b;

    /* renamed from: c */
    public final int f8815c;

    /* renamed from: d */
    public final int f8816d;

    /* renamed from: e */
    public final ImageView.ScaleType f8817e;

    /* renamed from: f */
    public Response.Listener<Bitmap> f8818f;

    @Deprecated
    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i10, int i11, Bitmap.Config config, Response.ErrorListener errorListener) {
        this(str, listener, i10, i11, ImageView.ScaleType.CENTER_INSIDE, config, errorListener);
    }

    public final Response<Bitmap> a(NetworkResponse networkResponse) {
        Bitmap decodeByteArray;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f8815c == 0 && this.f8816d == 0) {
            options.inPreferredConfig = this.f8814b;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i10 = options.outWidth;
            int i11 = options.outHeight;
            int a10 = a(this.f8815c, this.f8816d, i10, i11, this.f8817e);
            int a11 = a(this.f8816d, this.f8815c, i11, i10, this.f8817e);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i10, i11, a10, a11);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a10 || decodeByteArray.getHeight() > a11)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a10, a11, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        return decodeByteArray == null ? Response.error(new ParseError(networkResponse)) : Response.success(decodeByteArray, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @Override // com.czhj.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f8813a) {
            this.f8818f = null;
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(Bitmap bitmap) {
        Response.Listener<Bitmap> listener;
        synchronized (this.f8813a) {
            listener = this.f8818f;
        }
        if (listener != null) {
            listener.onResponse(bitmap);
        }
    }

    @Override // com.czhj.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // com.czhj.volley.Request
    public Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Response<Bitmap> a10;
        synchronized (f8812g) {
            try {
                try {
                    a10 = a(networkResponse);
                } catch (OutOfMemoryError e10) {
                    VolleyLog.e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                    return Response.error(new ParseError(e10));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return a10;
    }

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i10, int i11, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.f8813a = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f8818f = listener;
        this.f8814b = config;
        this.f8815c = i10;
        this.f8816d = i11;
        this.f8817e = scaleType;
    }

    public static int a(int i10, int i11, int i12, int i13) {
        double min = Math.min(i10 / i12, i11 / i13);
        float f10 = 1.0f;
        while (true) {
            float f11 = 2.0f * f10;
            if (f11 > min) {
                return (int) f10;
            }
            f10 = f11;
        }
    }

    public static int a(int i10, int i11, int i12, int i13, ImageView.ScaleType scaleType) {
        if (i10 == 0 && i11 == 0) {
            return i12;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i10 == 0 ? i12 : i10;
        }
        if (i10 == 0) {
            return (int) (i12 * (i11 / i13));
        }
        if (i11 == 0) {
            return i10;
        }
        double d10 = i13 / i12;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d11 = i11;
            return ((double) i10) * d10 < d11 ? (int) (d11 / d10) : i10;
        }
        double d12 = i11;
        return ((double) i10) * d10 > d12 ? (int) (d12 / d10) : i10;
    }
}
