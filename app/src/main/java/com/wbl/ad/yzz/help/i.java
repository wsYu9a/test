package com.wbl.ad.yzz.help;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.wbl.ad.yzz.network.b.b.b0;
import com.wbl.ad.yzz.util.f0.a;
import com.wbl.ad.yzz.util.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a */
    public static boolean f32665a;

    /* renamed from: b */
    public static boolean f32666b;

    /* renamed from: c */
    public static boolean f32667c;

    /* renamed from: d */
    public static boolean f32668d;

    /* renamed from: f */
    @f.b.a.d
    public static final a f32670f = new a(null);

    /* renamed from: e */
    public static Handler f32669e = new Handler(Looper.getMainLooper());

    public static final class a {

        /* renamed from: com.wbl.ad.yzz.help.i$a$a */
        public static final class C0745a implements RequestListener<Drawable> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32671a;

            /* renamed from: b */
            public final /* synthetic */ String f32672b;

            public C0745a(com.wbl.ad.yzz.innerconfig.d.d dVar, String str) {
                this.f32671a = dVar;
                this.f32672b = str;
            }

            public boolean a(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13752, this, drawable, obj, target, dataSource, Boolean.valueOf(z));
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13751, this, glideException, obj, target, Boolean.valueOf(z));
            }

            @Override // com.bumptech.glide.request.RequestListener
            public /* bridge */ /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13746, this, drawable, obj, target, dataSource, Boolean.valueOf(z));
            }
        }

        public static final class b implements a.InterfaceC0792a {

            /* renamed from: a */
            public final /* synthetic */ o.a f32673a;

            /* renamed from: com.wbl.ad.yzz.help.i$a$b$a */
            public static final class RunnableC0746a implements Runnable {
                public RunnableC0746a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13745, this, null);
                }
            }

            /* renamed from: com.wbl.ad.yzz.help.i$a$b$b */
            public static final class RunnableC0747b implements Runnable {

                /* renamed from: b */
                public final /* synthetic */ Bitmap f32676b;

                public RunnableC0747b(Bitmap bitmap) {
                    this.f32676b = bitmap;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13748, this, null);
                }
            }

            public b(o.a aVar) {
                this.f32673a = aVar;
            }

            @Override // com.wbl.ad.yzz.util.f0.a.InterfaceC0792a
            public void a(Bitmap bitmap) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13747, this, bitmap);
            }

            @Override // com.wbl.ad.yzz.util.f0.a.InterfaceC0792a
            public void a(Exception exc) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13710, this, exc);
            }
        }

        public static final class c implements a.InterfaceC0792a {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f32677a;

            /* renamed from: b */
            public final /* synthetic */ String f32678b;

            public c(com.wbl.ad.yzz.innerconfig.d.d dVar, String str) {
                this.f32677a = dVar;
                this.f32678b = str;
            }

            @Override // com.wbl.ad.yzz.util.f0.a.InterfaceC0792a
            public void a(Bitmap bitmap) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13709, this, bitmap);
            }

            @Override // com.wbl.ad.yzz.util.f0.a.InterfaceC0792a
            public void a(Exception exc) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13712, this, exc);
            }
        }

        public static final class d implements o.a {

            /* renamed from: a */
            public final /* synthetic */ View f32679a;

            /* renamed from: b */
            public final /* synthetic */ Context f32680b;

            public d(View view, Context context) {
                this.f32679a = view;
                this.f32680b = context;
            }

            @Override // com.wbl.ad.yzz.util.o.a
            public void a(Bitmap bitmap) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13711, this, bitmap);
            }
        }

        public static final class e implements a.InterfaceC0792a {

            /* renamed from: a */
            public final /* synthetic */ String f32681a;

            public e(String str) {
                this.f32681a = str;
            }

            @Override // com.wbl.ad.yzz.util.f0.a.InterfaceC0792a
            public void a(Bitmap bitmap) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13706, this, bitmap);
            }

            @Override // com.wbl.ad.yzz.util.f0.a.InterfaceC0792a
            public void a(Exception exc) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13705, this, exc);
            }
        }

        public static final class f implements RequestListener<Bitmap> {

            /* renamed from: a */
            public final /* synthetic */ String f32682a;

            public f(String str) {
                this.f32682a = str;
            }

            public boolean a(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13708, this, bitmap, obj, target, dataSource, Boolean.valueOf(z));
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13707, this, glideException, obj, target, Boolean.valueOf(z));
            }

            @Override // com.bumptech.glide.request.RequestListener
            public /* bridge */ /* synthetic */ boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13702, this, bitmap, obj, target, dataSource, Boolean.valueOf(z));
            }
        }

        public a() {
        }

        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13701, this, null);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.bean.b bVar, String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13704, this, context, dVar, bVar, str, imageView);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13703, this, context, dVar, str, imageView);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, String str, ImageView imageView, int i2, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13698, this, context, dVar, str, imageView, Integer.valueOf(i2), Boolean.valueOf(z));
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, String str, ImageView imageView, Integer num, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13697, this, context, dVar, str, imageView, num, Boolean.valueOf(z));
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, String str, ImageView imageView, boolean z, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13700, this, context, dVar, str, imageView, Boolean.valueOf(z), Boolean.valueOf(z2));
        }

        public final void a(Context context, String str, View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13699, this, context, str, view);
        }

        public final void a(Context context, String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13726, this, context, str, imageView);
        }

        public final void a(Context context, String str, ImageView imageView, Integer num) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13725, this, context, str, imageView, num);
        }

        public final void a(Context context, String str, ImageView imageView, Integer num, Integer num2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13728, this, context, str, imageView, num, num2);
        }

        public final void a(Context context, String str, ImageView imageView, Integer num, Integer num2, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13727, this, context, str, imageView, num, num2, Boolean.valueOf(z));
        }

        public final void a(Context context, String str, ImageView imageView, boolean z, Integer num, Integer num2, boolean z2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13722, this, context, str, imageView, Boolean.valueOf(z), num, num2, Boolean.valueOf(z2));
        }

        public final void a(Context context, String str, a.InterfaceC0792a interfaceC0792a) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13721, this, context, str, interfaceC0792a);
        }

        public final void a(Context context, String str, o.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13724, this, context, str, aVar);
        }

        public final void a(Context context, String str, Integer num, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13723, this, context, str, num, imageView);
        }

        public final void a(Context context, String str, boolean z, o.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13718, this, context, str, Boolean.valueOf(z), aVar);
        }

        public final void a(b0.e eVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13717, this, eVar);
        }

        public final void a(String str, boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13720, this, str, Boolean.valueOf(z));
        }

        public final boolean a(String str) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13719, this, str);
        }

        public final void b(Context context, String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13714, this, context, str, imageView);
        }

        public final void b(Context context, String str, o.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13713, this, context, str, aVar);
        }

        public final void b(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13716, this, str);
        }

        public final void c(Context context, String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13715, this, context, str, imageView);
        }

        public final void c(Context context, String str, o.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13806, this, context, str, aVar);
        }

        public final void c(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13805, this, str);
        }

        public final void d(Context context, String str, ImageView imageView) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13808, this, context, str, imageView);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Handler b() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13801, null, null);
    }
}
