package com.aggmoread.sdk.z.d.a.a.d.a.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class m extends Activity {

    /* renamed from: a */
    private Context f5390a;

    public m(Context context) {
        if (context != null) {
            this.f5390a = context;
            attachBaseContext(context);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                try {
                    com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "reflect application");
                    Field declaredField = Activity.class.getDeclaredField("mApplication");
                    declaredField.setAccessible(true);
                    declaredField.set(this, applicationContext);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return null;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "main create empty act");
        return new m(context);
    }

    @Override // android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(this.f5390a);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        return this.f5390a.getSystemService(str);
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return (WindowManager) this.f5390a.getSystemService("window");
    }
}
