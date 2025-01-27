package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class tanxc_do extends Dialog {
    public tanxc_do(@NonNull Context context, int i10) {
        super(context, i10);
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        setContentView(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) null, false));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
