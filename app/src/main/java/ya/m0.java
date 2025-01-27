package ya;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.martian.mibook.activity.KeepLiveActivity;
import com.martian.mibook.receiver.KeepLiveReceiver;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class m0 {

    /* renamed from: c */
    public static final m0 f33306c = new m0();

    /* renamed from: a */
    public WeakReference<KeepLiveActivity> f33307a;

    /* renamed from: b */
    public KeepLiveReceiver f33308b;

    public static m0 b() {
        return f33306c;
    }

    public void a() {
        WeakReference<KeepLiveActivity> weakReference = this.f33307a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f33307a.get().finish();
    }

    public void c(Context context) {
        this.f33308b = new KeepLiveReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(this.f33308b, intentFilter);
    }

    public void d(KeepLiveActivity keepLiveActivity) {
        this.f33307a = new WeakReference<>(keepLiveActivity);
    }

    public void e(Context context) {
        Intent intent = new Intent(context, (Class<?>) KeepLiveActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void f(Context context) {
        KeepLiveReceiver keepLiveReceiver = this.f33308b;
        if (keepLiveReceiver != null) {
            try {
                context.unregisterReceiver(keepLiveReceiver);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
