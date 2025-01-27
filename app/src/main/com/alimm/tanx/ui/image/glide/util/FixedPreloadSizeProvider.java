package com.alimm.tanx.ui.image.glide.util;

import com.alimm.tanx.ui.image.glide.ListPreloader;
import java.util.Arrays;

/* loaded from: classes.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i10, int i11) {
        this.size = new int[]{i10, i11};
    }

    @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t10, int i10, int i11) {
        int[] iArr = this.size;
        return Arrays.copyOf(iArr, iArr.length);
    }
}
