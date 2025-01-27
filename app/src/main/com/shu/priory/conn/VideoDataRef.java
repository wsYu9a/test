package com.shu.priory.conn;

import android.content.Context;
import com.shu.priory.b.c;
import com.shu.priory.download.DialogListener;
import com.shu.priory.g.b;
import com.shu.priory.param.AdParam;

/* loaded from: classes3.dex */
public abstract class VideoDataRef extends c {
    public VideoDataRef(Context context, b bVar, AdParam adParam, DialogListener dialogListener) {
        super(context, bVar, adParam, dialogListener);
    }

    public abstract int getDuration();

    public abstract int getHeight();

    public abstract int getWidth();
}
