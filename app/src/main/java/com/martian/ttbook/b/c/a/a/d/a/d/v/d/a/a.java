package com.martian.ttbook.b.c.a.a.d.a.d.v.d.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.e.d;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class a extends Activity {

    /* renamed from: a */
    private Context f15592a;

    public a(Context context) {
        if (context != null) {
            this.f15592a = context;
            attachBaseContext(context);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                try {
                    d.g("xxx", "reflect application");
                    Field declaredField = Activity.class.getDeclaredField("mApplication");
                    declaredField.setAccessible(true);
                    declaredField.set(this, applicationContext);
                } catch (Exception e2) {
                    e2.printStackTrace();
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
        d.g("xxx", "main create empty act");
        return new a(context);
    }

    @Override // android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(this.f15592a);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        return this.f15592a.getSystemService(str);
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return (WindowManager) this.f15592a.getSystemService("window");
    }
}
