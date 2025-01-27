package com.wbl.ad.yzz.util.f0.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.util.f0.a;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public WeakReference<Context> f34258a;

    /* renamed from: b */
    public WeakReference<ImageView> f34259b;

    /* renamed from: c */
    public com.wbl.ad.yzz.util.f0.c.b.a f34260c;

    /* renamed from: d */
    public a.InterfaceC0792a f34261d;

    /* renamed from: e */
    public List<a> f34262e;

    /* renamed from: f */
    public int f34263f = -1;

    /* renamed from: com.wbl.ad.yzz.util.f0.d.a$a */
    public class RunnableC0793a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Bitmap f34264a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f34265b;

        public RunnableC0793a(Bitmap bitmap, ImageView imageView) {
            this.f34264a = bitmap;
            this.f34265b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9214, this, null);
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ImageView f34267a;

        public b(ImageView imageView) {
            this.f34267a = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9213, this, null);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Exception f34269a;

        public c(Exception exc) {
            this.f34269a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9216, this, null);
        }
    }

    public a(Context context, ImageView imageView, com.wbl.ad.yzz.util.f0.c.b.a aVar, a.InterfaceC0792a interfaceC0792a) {
        this.f34258a = new WeakReference<>(context);
        this.f34259b = new WeakReference<>(imageView);
        this.f34260c = aVar;
        this.f34261d = interfaceC0792a;
    }

    public static /* synthetic */ WeakReference a(a aVar) {
        return (WeakReference) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9215, null, aVar);
    }

    public static /* synthetic */ a.InterfaceC0792a c(a aVar) {
        return (a.InterfaceC0792a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9209, null, aVar);
    }

    public String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9212, this, null);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9211, this, Integer.valueOf(i2));
    }

    public void a(Bitmap bitmap, Handler handler) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9206, this, bitmap, handler);
    }

    public void a(Exception exc, Handler handler) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9205, this, exc, handler);
    }

    public ImageView b() {
        return (ImageView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9208, this, null);
    }

    public com.wbl.ad.yzz.util.f0.c.b.a c() {
        return (com.wbl.ad.yzz.util.f0.c.b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9207, this, null);
    }

    public void d(a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9202, this, aVar);
    }

    public Context getActivity() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9201, this, null);
    }
}
