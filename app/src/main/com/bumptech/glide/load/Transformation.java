package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes2.dex */
public interface Transformation<T> extends Key {
    @NonNull
    Resource<T> transform(@NonNull Context context, @NonNull Resource<T> resource, int i10, int i11);
}
