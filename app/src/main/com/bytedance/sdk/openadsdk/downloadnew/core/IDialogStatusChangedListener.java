package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
public interface IDialogStatusChangedListener {
    void onCancel(DialogInterface dialogInterface);

    void onNegativeBtnClick(DialogInterface dialogInterface);

    void onPositiveBtnClick(DialogInterface dialogInterface);
}
