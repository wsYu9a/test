package androidx.media3.session;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.SimpleBitmapLoader;
import com.google.common.base.Suppliers;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@UnstableApi
/* loaded from: classes.dex */
public final class SimpleBitmapLoader implements androidx.media3.common.util.BitmapLoader {
    private static final b5.z<p5.g0> DEFAULT_EXECUTOR_SERVICE = Suppliers.b(new b5.z() { // from class: p0.j0
        @Override // b5.z
        public final Object get() {
            p5.g0 lambda$static$0;
            lambda$static$0 = SimpleBitmapLoader.lambda$static$0();
            return lambda$static$0;
        }
    });
    private static final String FILE_URI_EXCEPTION_MESSAGE = "Could not read image from file";
    private final p5.g0 executorService;

    public SimpleBitmapLoader() {
        this((ExecutorService) Assertions.checkStateNotNull(DEFAULT_EXECUTOR_SERVICE.get()));
    }

    public static Bitmap decode(byte[] bArr) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Assertions.checkArgument(decodeByteArray != null, "Could not decode image data");
        return decodeByteArray;
    }

    public static /* synthetic */ p5.g0 lambda$static$0() {
        return com.google.common.util.concurrent.p.j(Executors.newSingleThreadExecutor());
    }

    public static Bitmap load(Uri uri) throws IOException {
        if (com.sigmob.sdk.base.k.f18193y.equals(uri.getScheme())) {
            String path = uri.getPath();
            if (path == null) {
                throw new IllegalArgumentException(FILE_URI_EXCEPTION_MESSAGE);
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(path);
            if (decodeFile != null) {
                return decodeFile;
            }
            throw new IllegalArgumentException(FILE_URI_EXCEPTION_MESSAGE);
        }
        URLConnection openConnection = new URL(uri.toString()).openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new UnsupportedOperationException("Unsupported scheme: " + uri.getScheme());
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Invalid response status code: " + responseCode);
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            Bitmap decode = decode(k5.g.u(inputStream));
            if (inputStream != null) {
                inputStream.close();
            }
            return decode;
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public p5.c0<Bitmap> decodeBitmap(byte[] bArr) {
        return this.executorService.submit((Callable) new Callable() { // from class: p0.k0

            /* renamed from: b */
            public final /* synthetic */ byte[] f29673b;

            public /* synthetic */ k0(byte[] bArr2) {
                bArr = bArr2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap decode;
                decode = SimpleBitmapLoader.decode(bArr);
                return decode;
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public p5.c0<Bitmap> loadBitmap(Uri uri) {
        return this.executorService.submit((Callable) new Callable() { // from class: p0.i0

            /* renamed from: b */
            public final /* synthetic */ Uri f29670b;

            public /* synthetic */ i0(Uri uri2) {
                uri = uri2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap load;
                load = SimpleBitmapLoader.load(uri);
                return load;
            }
        });
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public /* synthetic */ p5.c0 loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        return o0.a.a(this, mediaMetadata);
    }

    public SimpleBitmapLoader(ExecutorService executorService) {
        this.executorService = com.google.common.util.concurrent.p.j(executorService);
    }
}
