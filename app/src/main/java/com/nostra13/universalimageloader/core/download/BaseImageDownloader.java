package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import b.g.a.b.c;
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
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public class BaseImageDownloader implements ImageDownloader {

    /* renamed from: a */
    public static final int f15971a = 5000;

    /* renamed from: b */
    public static final int f15972b = 20000;

    /* renamed from: c */
    protected static final int f15973c = 32768;

    /* renamed from: d */
    protected static final String f15974d = "@#&=*+-_.,:!?()/~'%";

    /* renamed from: e */
    protected static final int f15975e = 5;

    /* renamed from: f */
    protected static final String f15976f = "content://com.android.contacts/";

    /* renamed from: g */
    private static final String f15977g = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";

    /* renamed from: h */
    protected final Context f15978h;

    /* renamed from: i */
    protected final int f15979i;

    /* renamed from: j */
    protected final int f15980j;

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f15981a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f15981a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15981a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15981a[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15981a[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15981a[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15981a[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15981a[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this.f15978h = context.getApplicationContext();
        this.f15979i = 5000;
        this.f15980j = 20000;
    }

    private boolean h(Uri uri) {
        String type = this.f15978h.getContentResolver().getType(uri);
        if (type == null) {
            return false;
        }
        return type.startsWith("video/");
    }

    protected HttpURLConnection a(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, f15974d)).openConnection();
        httpURLConnection.setConnectTimeout(this.f15979i);
        httpURLConnection.setReadTimeout(this.f15980j);
        return httpURLConnection;
    }

    protected InputStream b(String str, Object obj) throws IOException {
        return this.f15978h.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    protected InputStream c(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.f15978h.getContentResolver();
        Uri parse = Uri.parse(str);
        if (h(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(f15976f)) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, parse);
        }
        return contentResolver.openInputStream(parse);
    }

    protected InputStream d(String str, Object obj) {
        return this.f15978h.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    protected InputStream e(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    protected InputStream f(String str, Object obj) throws IOException {
        HttpURLConnection a2 = a(str, obj);
        for (int i2 = 0; a2.getResponseCode() / 100 == 3 && i2 < 5; i2++) {
            a2 = a(a2.getHeaderField(HttpHeaders.LOCATION), obj);
        }
        try {
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(a2.getInputStream(), 32768), a2.getContentLength());
        } catch (IOException e2) {
            c.d(a2.getErrorStream());
            throw e2;
        }
    }

    protected InputStream g(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format(f15977g, str));
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (a.f15981a[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
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

    public BaseImageDownloader(Context context, int i2, int i3) {
        this.f15978h = context.getApplicationContext();
        this.f15979i = i2;
        this.f15980j = i3;
    }
}
