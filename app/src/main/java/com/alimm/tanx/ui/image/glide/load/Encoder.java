package com.alimm.tanx.ui.image.glide.load;

import java.io.OutputStream;

/* loaded from: classes.dex */
public interface Encoder<T> {
    boolean encode(T t10, OutputStream outputStream);

    String getId();
}
