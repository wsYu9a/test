package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ImageVideoBitmapDecoder implements ResourceDecoder<ImageVideoWrapper, Bitmap> {
    private static final String TAG = "ImageVideoDecoder";
    private final ResourceDecoder<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder;
    private final ResourceDecoder<InputStream, Bitmap> streamDecoder;

    public ImageVideoBitmapDecoder(ResourceDecoder<InputStream, Bitmap> resourceDecoder, ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder2) {
        this.streamDecoder = resourceDecoder;
        this.fileDescriptorDecoder = resourceDecoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        return "ImageVideoBitmapDecoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(ImageVideoWrapper imageVideoWrapper, int i10, int i11) throws IOException {
        Resource<Bitmap> decode;
        ParcelFileDescriptor fileDescriptor;
        InputStream stream = imageVideoWrapper.getStream();
        if (stream != null) {
            try {
                decode = this.streamDecoder.decode(stream, i10, i11);
            } catch (IOException e10) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Failed to load image from stream, trying FileDescriptor", e10);
                }
            }
            return (decode != null || (fileDescriptor = imageVideoWrapper.getFileDescriptor()) == null) ? decode : this.fileDescriptorDecoder.decode(fileDescriptor, i10, i11);
        }
        decode = null;
        if (decode != null) {
            return decode;
        }
    }
}
