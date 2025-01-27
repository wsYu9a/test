package com.alimm.tanx.ui.image.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ImageVideoWrapperEncoder implements Encoder<ImageVideoWrapper> {
    private final Encoder<ParcelFileDescriptor> fileDescriptorEncoder;

    /* renamed from: id */
    private String f6330id;
    private final Encoder<InputStream> streamEncoder;

    public ImageVideoWrapperEncoder(Encoder<InputStream> encoder, Encoder<ParcelFileDescriptor> encoder2) {
        this.streamEncoder = encoder;
        this.fileDescriptorEncoder = encoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        if (this.f6330id == null) {
            this.f6330id = this.streamEncoder.getId() + this.fileDescriptorEncoder.getId();
        }
        return this.f6330id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(ImageVideoWrapper imageVideoWrapper, OutputStream outputStream) {
        return imageVideoWrapper.getStream() != null ? this.streamEncoder.encode(imageVideoWrapper.getStream(), outputStream) : this.fileDescriptorEncoder.encode(imageVideoWrapper.getFileDescriptor(), outputStream);
    }
}
