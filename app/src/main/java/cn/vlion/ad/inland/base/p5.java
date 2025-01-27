package cn.vlion.ad.inland.base;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.TextureView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class p5 extends Thread implements TextureView.SurfaceTextureListener {

    /* renamed from: n */
    public static int f3281n = 10;

    /* renamed from: a */
    public a f3282a;

    /* renamed from: b */
    public final Object f3283b;

    /* renamed from: c */
    public SurfaceTexture f3284c;

    /* renamed from: d */
    public volatile boolean f3285d;

    /* renamed from: e */
    public int f3286e;

    /* renamed from: f */
    public ConcurrentHashMap f3287f;

    /* renamed from: g */
    public int f3288g;

    /* renamed from: h */
    public int f3289h;

    /* renamed from: i */
    public Resources f3290i;

    /* renamed from: j */
    public CopyOnWriteArrayList f3291j;

    /* renamed from: k */
    public Bitmap f3292k;

    /* renamed from: l */
    public Random f3293l;

    /* renamed from: m */
    public Paint f3294m;

    public interface a {
    }

    public p5(Resources resources, Bitmap bitmap) {
        super("TextureViewCanvas Renderer");
        this.f3283b = new Object();
        this.f3287f = new ConcurrentHashMap();
        this.f3291j = new CopyOnWriteArrayList();
        this.f3293l = new Random();
        try {
            this.f3290i = resources;
            this.f3294m = new Paint(1);
            this.f3292k = bitmap;
            this.f3286e = 35;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final Bitmap a(int i10) {
        ConcurrentHashMap concurrentHashMap;
        double d10;
        int width;
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            concurrentHashMap = this.f3287f;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (concurrentHashMap != null && this.f3292k != null) {
            if (concurrentHashMap.containsKey(Integer.valueOf(i10)) && ((WeakReference) this.f3287f.get(Integer.valueOf(i10))).get() != null) {
                return (Bitmap) ((WeakReference) this.f3287f.get(Integer.valueOf(i10))).get();
            }
            if (i10 != 0) {
                if (i10 == 1) {
                    d10 = 0.9d;
                    width = (int) (this.f3292k.getWidth() * 0.9d);
                    bitmap = this.f3292k;
                } else if (i10 == 2) {
                    d10 = 0.8d;
                    width = (int) (this.f3292k.getWidth() * 0.8d);
                    bitmap = this.f3292k;
                } else if (i10 == 3) {
                    d10 = 0.7d;
                    width = (int) (this.f3292k.getWidth() * 0.7d);
                    bitmap = this.f3292k;
                } else if (i10 != 4) {
                    bitmap2 = BitmapFactory.decodeResource(this.f3290i, i10);
                } else {
                    d10 = 0.6d;
                    width = (int) (this.f3292k.getWidth() * 0.6d);
                    bitmap = this.f3292k;
                }
                bitmap2 = Bitmap.createScaledBitmap(this.f3292k, width, (int) (bitmap.getHeight() * d10), true);
            } else {
                bitmap2 = this.f3292k;
            }
            this.f3287f.put(Integer.valueOf(i10), new WeakReference(bitmap2));
            return bitmap2;
        }
        return null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        try {
            Log.d("xyz RedPacketRender", "onSurfaceTextureAvailable(" + i10 + "x" + i11 + ")");
            this.f3288g = i10;
            this.f3289h = i11;
            synchronized (this.f3283b) {
                this.f3284c = surfaceTexture;
                this.f3283b.notify();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            Log.d("xyz RedPacketRender", "onSurfaceTextureDestroyed");
            synchronized (this.f3283b) {
                this.f3284c = null;
            }
            return true;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        Log.d("xyz RedPacketRender", "onSurfaceTextureSizeChanged(" + i10 + "x" + i11 + ")");
        this.f3288g = i10;
        this.f3289h = i11;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture;
        try {
            a aVar = this.f3282a;
            if (aVar != null) {
                ((r5) aVar).d();
            }
            this.f3285d = false;
            while (true) {
                if (!this.f3285d) {
                    synchronized (this.f3283b) {
                        surfaceTexture = null;
                        while (!this.f3285d && (surfaceTexture = this.f3284c) == null) {
                            try {
                                this.f3283b.wait();
                            } catch (InterruptedException e10) {
                                throw new RuntimeException(e10);
                            }
                        }
                        if (this.f3285d) {
                        }
                    }
                    break;
                }
                break;
                Log.d("xyz RedPacketRender", "Got surfaceTexture=" + surfaceTexture);
                a();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        Log.d("xyz RedPacketRender", "Renderer thread exiting");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017c A[Catch: all -> 0x0160, TryCatch #0 {all -> 0x0160, blocks: (B:46:0x014f, B:48:0x0157, B:51:0x016b, B:53:0x0179, B:54:0x018f, B:56:0x019a, B:58:0x01a1, B:60:0x01ba, B:62:0x01c6, B:64:0x01ca, B:66:0x01d2, B:68:0x01db, B:75:0x01e6, B:110:0x0208, B:116:0x017c, B:117:0x0163), top: B:45:0x014f, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0179 A[Catch: all -> 0x0160, TryCatch #0 {all -> 0x0160, blocks: (B:46:0x014f, B:48:0x0157, B:51:0x016b, B:53:0x0179, B:54:0x018f, B:56:0x019a, B:58:0x01a1, B:60:0x01ba, B:62:0x01c6, B:64:0x01ca, B:66:0x01d2, B:68:0x01db, B:75:0x01e6, B:110:0x0208, B:116:0x017c, B:117:0x0163), top: B:45:0x014f, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ba A[Catch: all -> 0x0160, TryCatch #0 {all -> 0x0160, blocks: (B:46:0x014f, B:48:0x0157, B:51:0x016b, B:53:0x0179, B:54:0x018f, B:56:0x019a, B:58:0x01a1, B:60:0x01ba, B:62:0x01c6, B:64:0x01ca, B:66:0x01d2, B:68:0x01db, B:75:0x01e6, B:110:0x0208, B:116:0x017c, B:117:0x0163), top: B:45:0x014f, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e6 A[Catch: all -> 0x0160, TRY_LEAVE, TryCatch #0 {all -> 0x0160, blocks: (B:46:0x014f, B:48:0x0157, B:51:0x016b, B:53:0x0179, B:54:0x018f, B:56:0x019a, B:58:0x01a1, B:60:0x01ba, B:62:0x01c6, B:64:0x01ca, B:66:0x01d2, B:68:0x01db, B:75:0x01e6, B:110:0x0208, B:116:0x017c, B:117:0x0163), top: B:45:0x014f, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0226 A[Catch: all -> 0x0098, TryCatch #6 {all -> 0x0098, blocks: (B:3:0x0005, B:5:0x0009, B:10:0x000f, B:11:0x0011, B:20:0x0029, B:21:0x0086, B:24:0x008d, B:25:0x009b, B:29:0x00ad, B:31:0x00dd, B:32:0x00bc, B:34:0x00cf, B:38:0x0136, B:40:0x013a, B:43:0x013f, B:100:0x025b, B:88:0x0211, B:89:0x0214, B:91:0x0226, B:97:0x022f, B:98:0x023e, B:99:0x0257, B:122:0x0242, B:123:0x0245, B:126:0x0247, B:132:0x0146, B:101:0x025e, B:137:0x026d, B:46:0x014f, B:48:0x0157, B:51:0x016b, B:53:0x0179, B:54:0x018f, B:56:0x019a, B:58:0x01a1, B:60:0x01ba, B:62:0x01c6, B:64:0x01ca, B:66:0x01d2, B:68:0x01db, B:75:0x01e6, B:110:0x0208, B:116:0x017c, B:117:0x0163, B:13:0x0012, B:15:0x0016, B:16:0x001e, B:18:0x0023, B:19:0x0028), top: B:2:0x0005, inners: #0, #1, #4, #7, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0229 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.p5.a():void");
    }
}
