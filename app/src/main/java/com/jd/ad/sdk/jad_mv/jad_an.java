package com.jd.ad.sdk.jad_mv;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class jad_an extends Paint {
    public jad_an() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public jad_an(int i10) {
        super(i10);
    }

    public jad_an(int i10, PorterDuff.Mode mode) {
        super(i10);
        setXfermode(new PorterDuffXfermode(mode));
    }

    public jad_an(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }
}
