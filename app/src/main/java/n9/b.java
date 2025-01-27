package n9;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.martian.libmars.widget.RecylingImageView;
import java.lang.ref.WeakReference;
import l9.s0;

/* loaded from: classes3.dex */
public class b extends AsyncTask<Void, Void, BitmapDrawable> {

    /* renamed from: a */
    public final String f28803a;

    /* renamed from: b */
    public final WeakReference<ImageView> f28804b;

    public b(ImageView imageView, String str) {
        this.f28804b = new WeakReference<>(imageView);
        this.f28803a = str;
    }

    public static synchronized BitmapDrawable b(byte[] bArr, String str, ImageView imageView) {
        synchronized (b.class) {
            if (imageView == null) {
                return null;
            }
            try {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i10 = -1;
                int i11 = layoutParams == null ? -1 : layoutParams.width;
                if (layoutParams != null) {
                    i10 = layoutParams.height;
                }
                Bitmap j10 = l9.b.j(bArr, i11, i10);
                if (j10 == null) {
                    return null;
                }
                if (!(imageView instanceof RecylingImageView)) {
                    return new BitmapDrawable(imageView.getResources(), j10);
                }
                Drawable drawable = imageView.getDrawable();
                o oVar = new o(imageView.getResources(), j10, drawable instanceof a ? (a) drawable : null);
                ((RecylingImageView) imageView).b(str, oVar);
                return oVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final BitmapDrawable a(byte[] bArr) {
        return b(bArr, this.f28803a, d());
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public BitmapDrawable doInBackground(Void... voidArr) {
        byte[] c10 = s0.c(this.f28803a);
        if (c10 == null) {
            return null;
        }
        ImageView d10 = d();
        if (d10 instanceof RecylingImageView) {
            ((RecylingImageView) d10).n(this.f28803a, c10);
        }
        return a(c10);
    }

    public final ImageView d() {
        return this.f28804b.get();
    }

    public String e() {
        return this.f28803a;
    }

    @Override // android.os.AsyncTask
    /* renamed from: f */
    public void onPostExecute(BitmapDrawable bitmapDrawable) {
        ImageView d10 = d();
        if (isCancelled() || bitmapDrawable == null || d10 == null) {
            return;
        }
        d10.setImageDrawable(bitmapDrawable);
        if (d10 instanceof RecylingImageView) {
            ((RecylingImageView) d10).m(this.f28803a, bitmapDrawable);
        }
    }
}
