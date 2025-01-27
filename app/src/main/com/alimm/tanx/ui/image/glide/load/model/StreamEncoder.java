package com.alimm.tanx.ui.image.glide.load.model;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(InputStream inputStream, OutputStream outputStream) {
        byte[] bytes = ByteArrayPool.get().getBytes();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bytes);
                    if (read == -1) {
                        ByteArrayPool.get().releaseBytes(bytes);
                        return true;
                    }
                    outputStream.write(bytes, 0, read);
                } catch (IOException e10) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Failed to encode data onto the OutputStream", e10);
                    }
                    ByteArrayPool.get().releaseBytes(bytes);
                    return false;
                }
            } catch (Throwable th2) {
                ByteArrayPool.get().releaseBytes(bytes);
                throw th2;
            }
        }
    }
}
