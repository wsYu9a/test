package com.martian.ttbook.sdk.client;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.martian.ttbook.a.i.a;

/* loaded from: classes4.dex */
public class EmptyActivity extends Activity {
    Context context;

    public EmptyActivity(Context context) {
        this.context = context;
        attachBaseContext(context);
    }

    @Override // android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        return AdClientContext.getLayoutInflater(this);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        return this.context.getSystemService(str);
    }

    @Override // android.app.Activity
    public Window getWindow() {
        throw new a("not support getWindow");
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return (WindowManager) this.context.getSystemService("window");
    }
}
