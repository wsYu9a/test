package x9;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public class b {
    public static void a(View view, Drawable drawable, float f10, float f11, float f12, float f13, String str) {
        if (f10 == 0.0f && f11 == 0.0f && f12 == 0.0f && f13 == 0.0f) {
            view.addOnLayoutChangeListener(new e(view, drawable, str));
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                return;
            }
            Glide.with(view).load2(drawable).override(view.getMeasuredWidth(), view.getMeasuredHeight()).into((RequestBuilder) new f(view));
            return;
        }
        x9.a aVar = new x9.a(view.getContext(), f10, f11, f12, f13);
        view.addOnLayoutChangeListener(new g(view, drawable, aVar, str));
        if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
            return;
        }
        Glide.with(view).load2(drawable).transform(aVar).override(view.getMeasuredWidth(), view.getMeasuredHeight()).into((RequestBuilder) new h(view, str));
    }

    public static void b(View view, Drawable drawable, float f10, String str) {
        if (f10 == 0.0f) {
            view.addOnLayoutChangeListener(new a(view, drawable, str));
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                return;
            }
            Glide.with(view).asDrawable().load2(drawable).transform(new CenterCrop()).override(view.getMeasuredWidth(), view.getMeasuredHeight()).into((RequestBuilder) new C0808b(view));
            return;
        }
        view.addOnLayoutChangeListener(new c(view, drawable, f10, str));
        if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
            return;
        }
        Glide.with(view).load2(drawable).transform(new CenterCrop(), new RoundedCorners((int) f10)).override(view.getMeasuredWidth(), view.getMeasuredHeight()).into((RequestBuilder) new d(view));
    }

    public class a implements View.OnLayoutChangeListener {

        /* renamed from: a */
        public final /* synthetic */ View f31923a;

        /* renamed from: b */
        public final /* synthetic */ Drawable f31924b;

        /* renamed from: c */
        public final /* synthetic */ String f31925c;

        public a(View view, Drawable drawable, String str) {
            this.f31923a = view;
            this.f31924b = drawable;
            this.f31925c = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f31923a.removeOnLayoutChangeListener(this);
            Glide.with(this.f31923a).asDrawable().load2(this.f31924b).transform(new CenterCrop()).override(this.f31923a.getMeasuredWidth(), this.f31923a.getMeasuredHeight()).into((RequestBuilder) new C0807a());
        }

        /* renamed from: x9.b$a$a */
        public class C0807a extends CustomTarget<Drawable> {
            public C0807a() {
            }

            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                if (((String) a.this.f31923a.getTag(R.id.action_container)).equals(a.this.f31925c)) {
                    a.this.f31923a.setBackground(drawable);
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(@Nullable Drawable drawable) {
            }
        }
    }

    public class c implements View.OnLayoutChangeListener {

        /* renamed from: a */
        public final /* synthetic */ View f31928a;

        /* renamed from: b */
        public final /* synthetic */ Drawable f31929b;

        /* renamed from: c */
        public final /* synthetic */ float f31930c;

        /* renamed from: d */
        public final /* synthetic */ String f31931d;

        public c(View view, Drawable drawable, float f10, String str) {
            this.f31928a = view;
            this.f31929b = drawable;
            this.f31930c = f10;
            this.f31931d = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f31928a.removeOnLayoutChangeListener(this);
            Glide.with(this.f31928a).load2(this.f31929b).transform(new CenterCrop(), new RoundedCorners((int) this.f31930c)).override(this.f31928a.getMeasuredWidth(), this.f31928a.getMeasuredHeight()).into((RequestBuilder) new a());
        }

        public class a extends CustomTarget<Drawable> {
            public a() {
            }

            @Override // com.bumptech.glide.request.target.Target
            @RequiresApi(api = 16)
            /* renamed from: a */
            public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                if (((String) c.this.f31928a.getTag(R.id.action_container)).equals(c.this.f31931d)) {
                    c.this.f31928a.setBackground(drawable);
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(@Nullable Drawable drawable) {
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {

        /* renamed from: a */
        public final /* synthetic */ View f31934a;

        /* renamed from: b */
        public final /* synthetic */ Drawable f31935b;

        /* renamed from: c */
        public final /* synthetic */ String f31936c;

        public e(View view, Drawable drawable, String str) {
            this.f31934a = view;
            this.f31935b = drawable;
            this.f31936c = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f31934a.removeOnLayoutChangeListener(this);
            Glide.with(this.f31934a).load2(this.f31935b).override(this.f31934a.getMeasuredWidth(), this.f31934a.getMeasuredHeight()).into((RequestBuilder) new a());
        }

        public class a extends CustomTarget<Drawable> {
            public a() {
            }

            @Override // com.bumptech.glide.request.target.Target
            @RequiresApi(api = 16)
            /* renamed from: a */
            public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                if (((String) e.this.f31934a.getTag(R.id.action_container)).equals(e.this.f31936c)) {
                    e.this.f31934a.setBackground(drawable);
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(@Nullable Drawable drawable) {
            }
        }
    }

    public class g implements View.OnLayoutChangeListener {

        /* renamed from: a */
        public final /* synthetic */ View f31939a;

        /* renamed from: b */
        public final /* synthetic */ Drawable f31940b;

        /* renamed from: c */
        public final /* synthetic */ x9.a f31941c;

        /* renamed from: d */
        public final /* synthetic */ String f31942d;

        public g(View view, Drawable drawable, x9.a aVar, String str) {
            this.f31939a = view;
            this.f31940b = drawable;
            this.f31941c = aVar;
            this.f31942d = str;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f31939a.removeOnLayoutChangeListener(this);
            Glide.with(this.f31939a).load2(this.f31940b).transform(this.f31941c).override(this.f31939a.getMeasuredWidth(), this.f31939a.getMeasuredHeight()).into((RequestBuilder) new a());
        }

        public class a extends CustomTarget<Drawable> {
            public a() {
            }

            @Override // com.bumptech.glide.request.target.Target
            @RequiresApi(api = 16)
            /* renamed from: a */
            public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                if (((String) g.this.f31939a.getTag(R.id.action_container)).equals(g.this.f31942d)) {
                    g.this.f31939a.setBackground(drawable);
                }
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(@Nullable Drawable drawable) {
            }
        }
    }

    /* renamed from: x9.b$b */
    public class C0808b extends CustomTarget<Drawable> {

        /* renamed from: b */
        public final /* synthetic */ View f31927b;

        public C0808b(View view) {
            this.f31927b = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        @RequiresApi(api = 16)
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            this.f31927b.setBackground(drawable);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }
    }

    public class d extends CustomTarget<Drawable> {

        /* renamed from: b */
        public final /* synthetic */ View f31933b;

        public d(View view) {
            this.f31933b = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        @RequiresApi(api = 16)
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            this.f31933b.setBackground(drawable);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }
    }

    public class f extends CustomTarget<Drawable> {

        /* renamed from: b */
        public final /* synthetic */ View f31938b;

        public f(View view) {
            this.f31938b = view;
        }

        @Override // com.bumptech.glide.request.target.Target
        @RequiresApi(api = 16)
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            this.f31938b.setBackground(drawable);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }
    }

    public class h extends CustomTarget<Drawable> {

        /* renamed from: b */
        public final /* synthetic */ View f31944b;

        /* renamed from: c */
        public final /* synthetic */ String f31945c;

        public h(View view, String str) {
            this.f31944b = view;
            this.f31945c = str;
        }

        @Override // com.bumptech.glide.request.target.Target
        @RequiresApi(api = 16)
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            if (((String) this.f31944b.getTag(R.id.action_container)).equals(this.f31945c)) {
                this.f31944b.setBackground(drawable);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }
    }
}
