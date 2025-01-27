package com.opos.exoplayer.core.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.opos.exoplayer.core.i.u;

@TargetApi(17)
/* loaded from: classes4.dex */
public final class DummySurface extends Surface {

    /* renamed from: b */
    private static int f19205b;

    /* renamed from: c */
    private static boolean f19206c;

    /* renamed from: a */
    public final boolean f19207a;

    /* renamed from: d */
    private final a f19208d;

    /* renamed from: e */
    private boolean f19209e;

    private static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

        /* renamed from: a */
        private final int[] f19210a;

        /* renamed from: b */
        private EGLDisplay f19211b;

        /* renamed from: c */
        private EGLContext f19212c;

        /* renamed from: d */
        private EGLSurface f19213d;

        /* renamed from: e */
        private Handler f19214e;

        /* renamed from: f */
        private SurfaceTexture f19215f;

        /* renamed from: g */
        private Error f19216g;

        /* renamed from: h */
        private RuntimeException f19217h;

        /* renamed from: i */
        private DummySurface f19218i;

        public a() {
            super("dummySurface");
            this.f19210a = new int[1];
        }

        private void b() {
            try {
                SurfaceTexture surfaceTexture = this.f19215f;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.f19210a, 0);
                }
            } finally {
                EGLSurface eGLSurface = this.f19213d;
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(this.f19211b, eGLSurface);
                }
                EGLContext eGLContext = this.f19212c;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.f19211b, eGLContext);
                }
                this.f19213d = null;
                this.f19212c = null;
                this.f19211b = null;
                this.f19218i = null;
                this.f19215f = null;
            }
        }

        private void b(int i2) {
            EGLSurface eGLSurface;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f19211b = eglGetDisplay;
            com.opos.exoplayer.core.i.a.b(eglGetDisplay != null, "eglGetDisplay failed");
            int[] iArr = new int[2];
            com.opos.exoplayer.core.i.a.b(EGL14.eglInitialize(this.f19211b, iArr, 0, iArr, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            com.opos.exoplayer.core.i.a.b(EGL14.eglChooseConfig(this.f19211b, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f19211b, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
            this.f19212c = eglCreateContext;
            com.opos.exoplayer.core.i.a.b(eglCreateContext != null, "eglCreateContext failed");
            if (i2 == 1) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            } else {
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f19211b, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                this.f19213d = eglCreatePbufferSurface;
                com.opos.exoplayer.core.i.a.b(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                eGLSurface = this.f19213d;
            }
            com.opos.exoplayer.core.i.a.b(EGL14.eglMakeCurrent(this.f19211b, eGLSurface, eGLSurface, this.f19212c), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.f19210a, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f19210a[0]);
            this.f19215f = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.f19218i = new DummySurface(this, this.f19215f, i2 != 0);
        }

        public DummySurface a(int i2) {
            boolean z;
            start();
            this.f19214e = new Handler(getLooper(), this);
            synchronized (this) {
                z = false;
                this.f19214e.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f19218i == null && this.f19217h == null && this.f19216g == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f19217h;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f19216g;
            if (error == null) {
                return this.f19218i;
            }
            throw error;
        }

        public void a() {
            this.f19214e.sendEmptyMessage(3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            try {
                if (i2 == 1) {
                    try {
                        try {
                            b(message.arg1);
                            synchronized (this) {
                                notify();
                            }
                        } catch (RuntimeException e2) {
                            com.opos.cmn.an.f.a.d("DummySurface", "Failed to initialize dummy surface", e2);
                            this.f19217h = e2;
                            synchronized (this) {
                                notify();
                            }
                        }
                    } catch (Error e3) {
                        com.opos.cmn.an.f.a.d("DummySurface", "Failed to initialize dummy surface", e3);
                        this.f19216g = e3;
                        synchronized (this) {
                            notify();
                        }
                    }
                } else if (i2 == 2) {
                    this.f19215f.updateTexImage();
                } else if (i2 == 3) {
                    try {
                        b();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f19214e.sendEmptyMessage(2);
        }
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f19208d = aVar;
        this.f19207a = z;
    }

    /* synthetic */ DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z, AnonymousClass1 anonymousClass1) {
        this(aVar, surfaceTexture, z);
    }

    public static DummySurface a(Context context, boolean z) {
        a();
        com.opos.exoplayer.core.i.a.b(!z || a(context));
        return new a().a(z ? f19205b : 0);
    }

    private static void a() {
        if (u.f19078a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static boolean a(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            try {
                if (!f19206c) {
                    f19205b = u.f19078a < 24 ? 0 : b(context);
                    f19206c = true;
                }
                z = f19205b != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @TargetApi(24)
    private static int b(Context context) {
        String eglQueryString;
        int i2 = u.f19078a;
        if (i2 < 26 && ("samsung".equals(u.f19080c) || "XT1650".equals(u.f19081d))) {
            return 0;
        }
        if ((i2 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")) {
            return eglQueryString.contains("EGL_KHR_surfaceless_context") ? 1 : 2;
        }
        return 0;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f19208d) {
            if (!this.f19209e) {
                this.f19208d.a();
                this.f19209e = true;
            }
        }
    }
}
