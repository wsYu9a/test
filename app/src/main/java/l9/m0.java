package l9;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.common.ConfigSingleton;
import java.io.File;

/* loaded from: classes3.dex */
public class m0 {

    public class a extends CustomTarget<Drawable> {

        /* renamed from: b */
        public final /* synthetic */ c f28021b;

        public a(c cVar) {
            this.f28021b = cVar;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            c cVar = this.f28021b;
            if (cVar != null) {
                cVar.a(drawable);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            c cVar = this.f28021b;
            if (cVar != null) {
                cVar.onError();
            }
        }
    }

    public class b implements RequestListener {

        /* renamed from: b */
        public final /* synthetic */ c f28022b;

        public b(c cVar) {
            this.f28022b = cVar;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target target, boolean z10) {
            c cVar = this.f28022b;
            if (cVar == null) {
                return false;
            }
            cVar.onError();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z10) {
            c cVar = this.f28022b;
            if (cVar == null) {
                return false;
            }
            cVar.a((Drawable) obj);
            return false;
        }
    }

    public interface c {
        void a(Drawable drawable);

        void onError();
    }

    public static void A(Context context, String str, ImageView imageView, int i10, int i11, int i12) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).transform(new RoundedCorners(ConfigSingleton.i(i10))).placeholder(i11).error(i12).into(imageView);
        }
    }

    public static boolean B(Context context) {
        return D(context, true);
    }

    public static boolean C(Context context) {
        return D(context, false);
    }

    public static boolean D(Context context, boolean z10) {
        return (z10 && (context instanceof BaseActivity)) ? ((BaseActivity) context).s1() : context instanceof Activity ? !((Activity) context).isDestroyed() : context != null;
    }

    public static void E(Context context, String str, c cVar) {
        if (C(context)) {
            i9.a.i(context).load(str).into((i9.c<Drawable>) new a(cVar));
        }
    }

    public static void F(Context context) {
        if (!C(context) || i9.a.i(context).isPaused()) {
            return;
        }
        i9.a.i(context).pauseRequests();
    }

    public static void G(Context context) {
        if (C(context) && i9.a.i(context).isPaused()) {
            i9.a.i(context).resumeRequests();
        }
    }

    public static boolean a(Context context, ImageView imageView) {
        return imageView != null && C(context);
    }

    public static void b(Context context, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).clear(imageView);
        }
    }

    public static boolean c(Context context) {
        return context instanceof Activity ? ((Activity) context).isDestroyed() : context == null;
    }

    public static void d(Context context, String str, ImageView imageView, int i10) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).transform(new CenterCrop(), new RoundedCorners(ConfigSingleton.i(i10))).into(imageView);
        }
    }

    public static void e(Context context, String str, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).transform(new CircleCrop()).into(imageView);
        }
    }

    public static void f(Context context, String str, ImageView imageView, int i10, int i11) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).thumbnail(i9.a.i(context).load(Integer.valueOf(i10)).apply(new RequestOptions().transform(new CircleCrop()))).thumbnail(i9.a.i(context).load(Integer.valueOf(i11)).apply(new RequestOptions().transform(new CircleCrop()))).apply(new RequestOptions().placeholder(i10).error(i11).transform(new CircleCrop())).into(imageView);
        }
    }

    public static void g(Context context, int i10, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).load(Integer.valueOf(i10)).into(imageView);
        }
    }

    public static void h(Context context, Drawable drawable, ImageView imageView, int i10) {
        if (a(context, imageView)) {
            if (i10 > 0) {
                i9.a.i(context).load(drawable).transform(new FitCenter(), new RoundedCorners(ConfigSingleton.i(i10))).into(imageView);
            } else {
                i9.a.i(context).load(drawable).into(imageView);
            }
        }
    }

    public static void i(Context context, Uri uri, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).load(uri).into(imageView);
        }
    }

    public static void j(Context context, File file, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).load(file).into(imageView);
        }
    }

    public static void k(Context context, String str, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).into(imageView);
        }
    }

    public static void l(Context context, String str, ImageView imageView, int i10) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).placeholder(i10).into(imageView);
        }
    }

    public static void m(Context context, String str, ImageView imageView, int i10, int i11) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).placeholder(i10).error(i11).into(imageView);
        }
    }

    public static void n(Context context, String str, ImageView imageView, int i10, int i11, boolean z10, int i12) {
        if (z10) {
            A(context, str, imageView, i12, i10, i11);
        } else {
            v(context, str, imageView, i10, i11, i12);
        }
    }

    public static void o(Context context, String str, ImageView imageView, int i10, boolean z10) {
        if (z10) {
            l(context, str, imageView, i10);
        } else {
            t(context, str, imageView, i10);
        }
    }

    public static void p(Context context, String str, ImageView imageView, int i10, boolean z10, int i11) {
        if (z10) {
            z(context, str, imageView, i11, i10);
        } else {
            u(context, str, imageView, i10, i11);
        }
    }

    public static void q(Context context, String str, ImageView imageView, c cVar) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).listener(new b(cVar)).override(ConfigSingleton.i(360.0f), ConfigSingleton.i(640.0f)).into(imageView);
        }
    }

    public static void r(Context context, byte[] bArr, ImageView imageView) {
        if (a(context, imageView)) {
            i9.a.i(context).load(bArr).into(imageView);
        }
    }

    public static void s(Context context, String str, ImageView imageView, int i10, int i11) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).override(i10, i11).into(imageView);
        }
    }

    public static void t(Context context, String str, ImageView imageView, int i10) {
        if (ConfigSingleton.D().N0()) {
            l(context, str, imageView, i10);
        } else if (a(context, imageView)) {
            i9.a.i(context).load(str).placeholder(i10).onlyRetrieveFromCache(true).into(imageView);
        }
    }

    public static void u(Context context, String str, ImageView imageView, int i10, int i11) {
        if (ConfigSingleton.D().N0()) {
            z(context, str, imageView, i11, i10);
        } else if (a(context, imageView)) {
            i9.a.i(context).load(str).transform(new CenterCrop(), new RoundedCorners(ConfigSingleton.i(i11))).placeholder(i10).onlyRetrieveFromCache(true).into(imageView);
        }
    }

    public static void v(Context context, String str, ImageView imageView, int i10, int i11, int i12) {
        if (ConfigSingleton.D().N0()) {
            A(context, str, imageView, i12, i10, i11);
        } else if (a(context, imageView)) {
            i9.a.i(context).load(str).transform(new CenterCrop(), new RoundedCorners(ConfigSingleton.i(i12))).placeholder(i10).error(i11).onlyRetrieveFromCache(true).into(imageView);
        }
    }

    public static void w(Context context, int i10, ImageView imageView, int i11) {
        if (a(context, imageView)) {
            i9.a.i(context).load(Integer.valueOf(i10)).transform(new RoundedCorners(ConfigSingleton.i(i11))).into(imageView);
        }
    }

    public static void x(Context context, Uri uri, ImageView imageView, int i10) {
        if (a(context, imageView)) {
            i9.a.i(context).load(uri).transform(new RoundedCorners(ConfigSingleton.i(i10))).into(imageView);
        }
    }

    public static void y(Context context, String str, ImageView imageView, int i10) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).transform(new RoundedCorners(ConfigSingleton.i(i10))).into(imageView);
        }
    }

    public static void z(Context context, String str, ImageView imageView, int i10, int i11) {
        if (a(context, imageView)) {
            i9.a.i(context).load(str).transition(DrawableTransitionOptions.withCrossFade(500)).transform(new CenterCrop(), new RoundedCorners(ConfigSingleton.i(i10))).placeholder(i11).into(imageView);
        }
    }
}
