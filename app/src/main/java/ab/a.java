package ab;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import ba.g;
import ba.l;
import com.martian.libfeedback.request.FeedbackInfoParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.activity.EnterActivity;
import com.martian.mibook.mvvm.home.activity.HomeActivity;
import java.io.IOException;
import java.lang.Thread;
import t8.b;
import x8.c;

/* loaded from: classes3.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: c */
    public static a f131c = null;

    /* renamed from: d */
    public static final String f132d = "mibook_breakdown_file";

    /* renamed from: a */
    public String f133a;

    /* renamed from: b */
    public long f134b;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f131c == null) {
                    f131c = new a();
                }
                aVar = f131c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public void b() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void c(String str) {
        this.f133a = str;
        this.f134b = System.currentTimeMillis();
    }

    public void d() {
        try {
            Context applicationContext = ConfigSingleton.D().getApplicationContext();
            e(applicationContext, g.B(applicationContext, f132d), false);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(Context context, String str, boolean z10) {
        if (l.q(str)) {
            return;
        }
        C0002a c0002a = new C0002a(z10, context);
        ((FeedbackInfoParams) c0002a.k()).setSubject(str);
        ((FeedbackInfoParams) c0002a.k()).setCategoryId(7);
        ((FeedbackInfoParams) c0002a.k()).setSubCategoryId(70004);
        c0002a.j();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
        Context applicationContext = ConfigSingleton.D().getApplicationContext();
        try {
            String e10 = b.e(th2);
            if (!l.q(this.f133a)) {
                e10 = e10 + "\n" + this.f133a;
            }
            g.F(applicationContext, f132d, (e10 + " " + ConfigSingleton.D().p0()) + " " + (System.currentTimeMillis() - this.f134b) + "ms");
        } catch (IOException unused) {
        }
        if (HomeActivity.class.getName().equalsIgnoreCase(this.f133a) || EnterActivity.class.getName().equalsIgnoreCase(this.f133a)) {
            return;
        }
        ((AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 1000, PendingIntent.getActivity(applicationContext, 0, kc.b.b(applicationContext), 134217728));
        Process.killProcess(Process.myPid());
    }

    /* renamed from: ab.a$a */
    public class C0002a extends b9.b {

        /* renamed from: i */
        public final /* synthetic */ boolean f135i;

        /* renamed from: j */
        public final /* synthetic */ Context f136j;

        public C0002a(boolean z10, Context context) {
            this.f135i = z10;
            this.f136j = context;
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(Integer num) {
            if (this.f135i) {
                return;
            }
            try {
                g.F(this.f136j, a.f132d, "");
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }

        @Override // y8.a
        public void onResultError(c cVar) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
