package com.martian.libmars.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import i9.e;

@GlideModule
/* loaded from: classes3.dex */
public class OkHttpLibraryGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        super.applyOptions(context, glideBuilder);
        if (e.b()) {
            glideBuilder.setConnectivityMonitorFactory(new e());
        }
    }
}
