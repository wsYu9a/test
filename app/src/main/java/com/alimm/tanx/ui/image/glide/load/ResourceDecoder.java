package com.alimm.tanx.ui.image.glide.load;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t10, int i10, int i11) throws IOException;

    String getId();
}
