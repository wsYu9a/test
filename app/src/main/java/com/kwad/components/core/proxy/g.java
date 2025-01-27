package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;

/* loaded from: classes3.dex */
public abstract class g extends AlertDialog {
    protected ViewGroup AK;
    public Activity mActivity;
    protected final Context mContext;

    public g(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = com.kwad.sdk.n.m.wrapContextIfNeed(activity);
    }

    public float cF() {
        return -1.0f;
    }

    public ViewGroup cG() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            com.kwad.sdk.n.m.j(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        T t10 = (T) this.AK.findViewById(i10);
        return t10 != null ? t10 : (T) super.findViewById(i10);
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void h(View view);

    public boolean og() {
        return false;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.AK = (ViewGroup) com.kwad.sdk.n.m.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.AK = cG();
            }
            setContentView(this.AK);
            setCanceledOnTouchOutside(og());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (cF() != -1.0f) {
                attributes.dimAmount = cF();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            h(this.AK);
        } catch (Throwable th2) {
            if (!com.kwad.sdk.l.At().zB()) {
                throw th2;
            }
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
            dismiss();
        }
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        super.setContentView(i10);
        this.AK = (ViewGroup) com.kwad.sdk.n.m.inflate(this.mContext, i10, null);
    }
}
