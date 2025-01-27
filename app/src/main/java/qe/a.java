package qe;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes3.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c */
    public static final String f30008c = "a";

    /* renamed from: d */
    public static final long f30009d = 1500;

    /* renamed from: a */
    public Handler f30010a;

    /* renamed from: b */
    public int f30011b;

    public void a(Handler handler, int i10) {
        this.f30010a = handler;
        this.f30011b = i10;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z10, Camera camera) {
        Handler handler = this.f30010a;
        if (handler == null) {
            Log.d(f30008c, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.f30010a.sendMessageDelayed(handler.obtainMessage(this.f30011b, Boolean.valueOf(z10)), f30009d);
        this.f30010a = null;
    }
}
