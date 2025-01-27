package com.martian.mibook.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import b.d.c.b.c;
import com.martian.libfeedback.b.b;
import com.martian.libfeedback.request.FeedbackInfoParams;
import com.martian.libmars.d.h;
import com.martian.libsupport.e;
import com.martian.libsupport.k;
import com.martian.mibook.activity.EnterActivity;
import com.martian.mibook.activity.Homepage;
import java.io.IOException;
import java.lang.Thread;

/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static a f11645a = null;

    /* renamed from: b */
    private static final String f11646b = "mibook_breakdown_file";

    /* renamed from: c */
    private String f11647c;

    /* renamed from: d */
    private String f11648d;

    /* renamed from: com.martian.mibook.d.a$a */
    /* loaded from: classes3.dex */
    class C0263a extends b {

        /* renamed from: h */
        final /* synthetic */ Context f11649h;

        C0263a(final Context val$context) {
            this.f11649h = val$context;
        }

        @Override // b.d.c.c.b
        public void onResultError(c errorResult) {
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(Integer id) {
            try {
                e.E(this.f11649h, a.f11646b, "");
            } catch (IOException unused) {
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f11645a == null) {
                f11645a = new a();
            }
            aVar = f11645a;
        }
        return aVar;
    }

    public void b() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void c(String activityName) {
        this.f11648d = activityName;
    }

    public void d(String adId) {
        this.f11647c = adId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e() {
        try {
            Context applicationContext = h.F().getApplicationContext();
            String B = e.B(applicationContext, f11646b);
            if (k.p(B)) {
                return;
            }
            C0263a c0263a = new C0263a(applicationContext);
            ((FeedbackInfoParams) c0263a.k()).setSubject(B);
            ((FeedbackInfoParams) c0263a.k()).setCategoryId(7);
            ((FeedbackInfoParams) c0263a.k()).setSubCategoryId(70004);
            c0263a.j();
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        Context applicationContext = h.F().getApplicationContext();
        try {
            String g2 = b.d.c.a.b.g(throwable);
            if (!k.p(this.f11648d)) {
                g2 = g2 + "\n" + this.f11648d;
            }
            if (!k.p(this.f11647c)) {
                g2 = g2 + "\nadId:" + this.f11647c;
            }
            e.E(applicationContext, f11646b, g2);
        } catch (IOException unused) {
        }
        if (k.p(this.f11648d) || Homepage.class.getName().equalsIgnoreCase(this.f11648d) || EnterActivity.class.getName().equalsIgnoreCase(this.f11648d)) {
            return;
        }
        ((AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 1000, PendingIntent.getActivity(applicationContext, 0, new Intent(applicationContext, (Class<?>) Homepage.class), 134217728));
        Process.killProcess(Process.myPid());
    }
}
