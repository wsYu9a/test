package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import m5.c;

/* loaded from: classes3.dex */
public class BaseImageDownloader implements ImageDownloader {

    /* renamed from: d */
    public static final int f16353d = 5000;

    /* renamed from: e */
    public static final int f16354e = 20000;

    /* renamed from: f */
    public static final int f16355f = 32768;

    /* renamed from: g */
    public static final String f16356g = "@#&=*+-_.,:!?()/~'%";

    /* renamed from: h */
    public static final int f16357h = 5;

    /* renamed from: i */
    public static final String f16358i = "content://com.android.contacts/";

    /* renamed from: j */
    public static final String f16359j = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";

    /* renamed from: a */
    public final Context f16360a;

    /* renamed from: b */
    public final int f16361b;

    /* renamed from: c */
    public final int f16362c;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16363a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f16363a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16363a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16363a[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16363a[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16363a[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16363a[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16363a[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this.f16360a = context.getApplicationContext();
        this.f16361b = 5000;
        this.f16362c = 20000;
    }

    public HttpURLConnection a(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, f16356g)).openConnection();
        httpURLConnection.setConnectTimeout(this.f16361b);
        httpURLConnection.setReadTimeout(this.f16362c);
        return httpURLConnection;
    }

    public InputStream b(String str, Object obj) throws IOException {
        return this.f16360a.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    public InputStream c(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.f16360a.getContentResolver();
        Uri parse = Uri.parse(str);
        if (h(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(f16358i)) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, parse);
        }
        return contentResolver.openInputStream(parse);
    }

    public InputStream d(String str, Object obj) {
        return this.f16360a.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    public InputStream e(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        return new af.a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    public InputStream f(String str, Object obj) throws IOException {
        HttpURLConnection a10 = a(str, obj);
        for (int i10 = 0; a10.getResponseCode() / 100 == 3 && i10 < 5; i10++) {
            a10 = a(a10.getHeaderField(c.f28347t0), obj);
        }
        try {
            return new af.a(new BufferedInputStream(a10.getInputStream(), 32768), a10.getContentLength());
        } catch (IOException e10) {
            hf.c.d(a10.getErrorStream());
            throw e10;
        }
    }

    public InputStream g(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format(f16359j, str));
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (a.f16363a[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return f(str, obj);
            case 3:
                return e(str, obj);
            case 4:
                return c(str, obj);
            case 5:
                return b(str, obj);
            case 6:
                return d(str, obj);
            default:
                return g(str, obj);
        }
    }

    public final boolean h(Uri uri) {
        String type = this.f16360a.getContentResolver().getType(uri);
        if (type == null) {
            return false;
        }
        return type.startsWith("video/");
    }

    public BaseImageDownloader(Context context, int i10, int i11) {
        this.f16360a = context.getApplicationContext();
        this.f16361b = i10;
        this.f16362c = i11;
    }
}
