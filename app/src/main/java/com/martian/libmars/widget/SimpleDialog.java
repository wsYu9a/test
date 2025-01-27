package com.martian.libmars.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class SimpleDialog extends Dialog {

    /* renamed from: a */
    protected static final String f10381a = "IphoneDialog";

    public SimpleDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public SimpleDialog(Context context, int theme) {
        super(context, theme);
    }

    public SimpleDialog(Context context) {
        super(context, R.style.Theme_Transparent);
        setContentView(LayoutInflater.from(context).inflate(R.layout.loading_dialog, (ViewGroup) null));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        getWindow().setAttributes(attributes);
    }
}
