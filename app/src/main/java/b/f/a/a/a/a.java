package b.f.a.a.a;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes4.dex */
final class a implements Camera.AutoFocusCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4793a = a.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private static final long f4794b = 1500;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4795c;

    /* renamed from: d, reason: collision with root package name */
    private int f4796d;

    a() {
    }

    void a(Handler autoFocusHandler, int autoFocusMessage) {
        this.f4795c = autoFocusHandler;
        this.f4796d = autoFocusMessage;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean success, Camera camera) {
        Handler handler = this.f4795c;
        if (handler == null) {
            Log.d(f4793a, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.f4795c.sendMessageDelayed(handler.obtainMessage(this.f4796d, Boolean.valueOf(success)), f4794b);
        this.f4795c = null;
    }
}
