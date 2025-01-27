package com.martian.mibook.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes4.dex */
public class t2 {
    public static Bitmap a(String urlPath) {
        try {
            URLConnection openConnection = new URL(urlPath).openConnection();
            openConnection.connect();
            Bitmap decodeStream = BitmapFactory.decodeStream(openConnection.getInputStream());
            if (decodeStream != null) {
                return com.martian.libmars.utils.i0.s(decodeStream, 84, 84, true);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
