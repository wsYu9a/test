package com.wbl.ad.yzz.util.f0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import f.b.a.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: f */
    @d
    public static final b f34242f = new b(null);

    /* renamed from: a */
    public String f34243a;

    /* renamed from: b */
    public InterfaceC0792a f34244b;

    /* renamed from: c */
    public Context f34245c;

    /* renamed from: d */
    public ImageView f34246d;

    /* renamed from: e */
    public int f34247e;

    /* renamed from: com.wbl.ad.yzz.util.f0.a$a */
    public interface InterfaceC0792a {
        void a(@d Bitmap bitmap);

        void a(@d Exception exc);
    }

    public static final class b {
        public b() {
        }

        public final a a(Context context) {
            return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9115, this, context);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(@d Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f34247e = -1;
        this.f34245c = context;
    }

    public final Activity a(Context context) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9110, this, context);
    }

    public final Activity a(View view) {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9109, this, view);
    }

    public final Context a() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9112, this, null);
    }

    public final a a(int i2) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9111, this, Integer.valueOf(i2));
    }

    public final a a(InterfaceC0792a interfaceC0792a) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9106, this, interfaceC0792a);
    }

    public final a a(String str) {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9105, this, str);
    }

    public final void a(ImageView imageView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9108, this, imageView);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9107, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9198, this, null);
    }
}
