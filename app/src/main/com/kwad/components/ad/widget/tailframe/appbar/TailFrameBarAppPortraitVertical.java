package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public class TailFrameBarAppPortraitVertical extends a {
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void f(@NonNull AdTemplate adTemplate) {
        if (e.J(adTemplate)) {
            this.Jh.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.f11911mj.setTextColor(Color.parseColor("#FFFFFF"));
            this.Kr.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.Jh.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        super.f(adTemplate);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_vertical;
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
