package com.vivo.mobilead.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.vivo.mobilead.lottie.d;
import com.vivo.mobilead.lottie.f.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final Object f29124a = new Object();

    /* renamed from: b */
    private final Context f29125b;

    /* renamed from: c */
    private String f29126c;

    /* renamed from: d */
    private com.vivo.mobilead.lottie.a f29127d;

    /* renamed from: e */
    private final Map<String, d> f29128e;

    public b(Drawable.Callback callback, String str, com.vivo.mobilead.lottie.a aVar, Map<String, d> map) {
        this.f29126c = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f29126c.charAt(r4.length() - 1) != '/') {
                this.f29126c += '/';
            }
        }
        if (callback instanceof View) {
            this.f29125b = ((View) callback).getContext();
            this.f29128e = map;
            a(aVar);
        } else {
            com.vivo.mobilead.lottie.f.d.b("LottieDrawable must be inside of a view for images to work.");
            this.f29128e = new HashMap();
            this.f29125b = null;
        }
    }

    private Bitmap b(String str, Bitmap bitmap) {
        synchronized (f29124a) {
            this.f29128e.get(str).a(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        String str2;
        Bitmap a2;
        d dVar = this.f29128e.get(str);
        if (dVar == null) {
            return null;
        }
        Bitmap e2 = dVar.e();
        if (e2 != null) {
            return e2;
        }
        com.vivo.mobilead.lottie.a aVar = this.f29127d;
        if (aVar != null) {
            Bitmap a3 = aVar.a(dVar);
            if (a3 != null) {
                b(str, a3);
            }
            return a3;
        }
        String d2 = dVar.d();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!d2.startsWith("data:") || d2.indexOf("base64,") <= 0) {
            try {
                if (TextUtils.isEmpty(this.f29126c)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                a2 = h.a(BitmapFactory.decodeStream(this.f29125b.getAssets().open(this.f29126c + d2), null, options), dVar.a(), dVar.b());
            } catch (IOException e3) {
                e = e3;
                str2 = "Unable to open asset.";
                com.vivo.mobilead.lottie.f.d.a(str2, e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(d2.substring(d2.indexOf(44) + 1), 0);
                a2 = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            } catch (IllegalArgumentException e4) {
                e = e4;
                str2 = "data URL did not have correct base64 format.";
                com.vivo.mobilead.lottie.f.d.a(str2, e);
                return null;
            }
        }
        return b(str, a2);
    }

    public Bitmap a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap e2 = this.f29128e.get(str).e();
            b(str, bitmap);
            return e2;
        }
        d dVar = this.f29128e.get(str);
        Bitmap e3 = dVar.e();
        dVar.a(null);
        return e3;
    }

    public void a(com.vivo.mobilead.lottie.a aVar) {
        this.f29127d = aVar;
    }

    public boolean a(Context context) {
        return (context == null && this.f29125b == null) || this.f29125b.equals(context);
    }
}
