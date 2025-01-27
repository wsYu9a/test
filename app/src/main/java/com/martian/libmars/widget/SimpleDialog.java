package com.martian.libmars.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public class SimpleDialog extends Dialog {

    /* renamed from: b */
    public static final String f12697b = "IphoneDialog";

    public SimpleDialog(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
    }

    public SimpleDialog(Context context, int i10) {
        super(context, i10);
    }

    public SimpleDialog(Context context) {
        super(context, R.style.Theme_Transparent);
        setContentView(LayoutInflater.from(context).inflate(R.layout.loading_dialog, (ViewGroup) null));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        getWindow().setAttributes(attributes);
    }
}
