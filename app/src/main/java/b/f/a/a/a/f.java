package b.f.a.a.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes4.dex */
final class f implements Camera.PreviewCallback {

    /* renamed from: a */
    private static final String f4824a = f.class.getSimpleName();

    /* renamed from: b */
    private final b f4825b;

    /* renamed from: c */
    private final boolean f4826c;

    /* renamed from: d */
    private Handler f4827d;

    /* renamed from: e */
    private int f4828e;

    f(b configManager, boolean useOneShotPreviewCallback) {
        this.f4825b = configManager;
        this.f4826c = useOneShotPreviewCallback;
    }

    void a(Handler previewHandler, int previewMessage) {
        this.f4827d = previewHandler;
        this.f4828e = previewMessage;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] data, Camera camera) {
        Point c2 = this.f4825b.c();
        if (!this.f4826c) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.f4827d;
        if (handler == null) {
            Log.d(f4824a, "Got preview callback, but no handler for it");
        } else {
            handler.obtainMessage(this.f4828e, c2.x, c2.y, data).sendToTarget();
            this.f4827d = null;
        }
    }
}
