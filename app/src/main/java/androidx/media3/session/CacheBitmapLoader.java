package androidx.media3.session;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes.dex */
public final class CacheBitmapLoader implements androidx.media3.common.util.BitmapLoader {
    private final androidx.media3.common.util.BitmapLoader bitmapLoader;
    private BitmapLoadRequest lastBitmapLoadRequest;

    public static class BitmapLoadRequest {

        @Nullable
        private final byte[] data;

        @Nullable
        private final p5.c0<Bitmap> future;

        @Nullable
        private final Uri uri;

        public BitmapLoadRequest(byte[] bArr, p5.c0<Bitmap> c0Var) {
            this.data = bArr;
            this.uri = null;
            this.future = c0Var;
        }

        public p5.c0<Bitmap> getFuture() {
            return (p5.c0) Assertions.checkStateNotNull(this.future);
        }

        public boolean matches(@Nullable byte[] bArr) {
            byte[] bArr2 = this.data;
            return bArr2 != null && Arrays.equals(bArr2, bArr);
        }

        public boolean matches(@Nullable Uri uri) {
            Uri uri2 = this.uri;
            return uri2 != null && uri2.equals(uri);
        }

        public BitmapLoadRequest(Uri uri, p5.c0<Bitmap> c0Var) {
            this.data = null;
            this.uri = uri;
            this.future = c0Var;
        }
    }

    public CacheBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
        this.bitmapLoader = bitmapLoader;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public p5.c0<Bitmap> decodeBitmap(byte[] bArr) {
        BitmapLoadRequest bitmapLoadRequest = this.lastBitmapLoadRequest;
        if (bitmapLoadRequest != null && bitmapLoadRequest.matches(bArr)) {
            return this.lastBitmapLoadRequest.getFuture();
        }
        p5.c0<Bitmap> decodeBitmap = this.bitmapLoader.decodeBitmap(bArr);
        this.lastBitmapLoadRequest = new BitmapLoadRequest(bArr, decodeBitmap);
        return decodeBitmap;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public p5.c0<Bitmap> loadBitmap(Uri uri) {
        BitmapLoadRequest bitmapLoadRequest = this.lastBitmapLoadRequest;
        if (bitmapLoadRequest != null && bitmapLoadRequest.matches(uri)) {
            return this.lastBitmapLoadRequest.getFuture();
        }
        p5.c0<Bitmap> loadBitmap = this.bitmapLoader.loadBitmap(uri);
        this.lastBitmapLoadRequest = new BitmapLoadRequest(uri, loadBitmap);
        return loadBitmap;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public /* synthetic */ p5.c0 loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        return o0.a.a(this, mediaMetadata);
    }
}
