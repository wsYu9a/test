package com.wbl.ad.yzz.ui.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a */
    public String f34206a;

    /* renamed from: b */
    public final String f34207b = ".JPEG";

    public interface a {
        void a(@f.b.a.e String str);
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f34208a;

        /* renamed from: b */
        public final /* synthetic */ Bitmap f34209b;

        /* renamed from: c */
        public final /* synthetic */ a f34210c;

        public b(String str, Bitmap bitmap, a aVar) {
            this.f34208a = str;
            this.f34209b = bitmap;
            this.f34210c = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8986, this, null);
        }
    }

    public static final class c implements a {

        /* renamed from: a */
        public final /* synthetic */ a f34211a;

        public static final class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ String f34213b;

            public a(String str) {
                this.f34213b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8985, this, null);
            }
        }

        public c(a aVar) {
            this.f34211a = aVar;
        }

        @Override // com.wbl.ad.yzz.ui.f.l.a
        public void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8988, this, str);
        }
    }

    public l(@f.b.a.e Context context) {
        this.f34206a = b(context);
    }

    public final void a(Context context, View view, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8987, this, context, view, aVar);
    }

    public final void a(String str, Bitmap bitmap, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8982, this, str, bitmap, aVar);
    }

    public final boolean a(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8981, this, context);
    }

    public final boolean a(Context context, String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8984, this, context, str);
    }

    public final String b(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8983, this, context);
    }
}
