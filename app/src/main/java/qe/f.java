package qe;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes3.dex */
public final class f implements Camera.PreviewCallback {

    /* renamed from: e */
    public static final String f30046e = "f";

    /* renamed from: a */
    public final b f30047a;

    /* renamed from: b */
    public final boolean f30048b;

    /* renamed from: c */
    public Handler f30049c;

    /* renamed from: d */
    public int f30050d;

    public f(b bVar, boolean z10) {
        this.f30047a = bVar;
        this.f30048b = z10;
    }

    public void a(Handler handler, int i10) {
        this.f30049c = handler;
        this.f30050d = i10;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point c10 = this.f30047a.c();
        if (!this.f30048b) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.f30049c;
        if (handler == null) {
            Log.d(f30046e, "Got preview callback, but no handler for it");
        } else {
            handler.obtainMessage(this.f30050d, c10.x, c10.y, bArr).sendToTarget();
            this.f30049c = null;
        }
    }
}
