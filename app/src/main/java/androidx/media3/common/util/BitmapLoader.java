package androidx.media3.common.util;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import p5.c0;

@UnstableApi
/* loaded from: classes.dex */
public interface BitmapLoader {
    c0<Bitmap> decodeBitmap(byte[] bArr);

    c0<Bitmap> loadBitmap(Uri uri);

    @Nullable
    c0<Bitmap> loadBitmapFromMetadata(MediaMetadata mediaMetadata);
}
