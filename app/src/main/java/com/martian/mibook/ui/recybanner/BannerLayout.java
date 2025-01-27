package com.martian.mibook.ui.recybanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.badge.BadgeDrawable;
import com.martian.mibook.R;
import com.martian.mibook.ui.recybanner.BannerLayout;
import com.vivo.advv.Color;

/* loaded from: classes4.dex */
public class BannerLayout extends FrameLayout {

    /* renamed from: a */
    private int f14847a;

    /* renamed from: b */
    private boolean f14848b;

    /* renamed from: c */
    private RecyclerView f14849c;

    /* renamed from: d */
    private Drawable f14850d;

    /* renamed from: e */
    private Drawable f14851e;

    /* renamed from: f */
    private c f14852f;

    /* renamed from: g */
    private int f14853g;

    /* renamed from: h */
    private RecyclerView f14854h;

    /* renamed from: i */
    private BannerLayoutManager f14855i;

    /* renamed from: j */
    private final int f14856j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    int p;
    float q;
    float r;
    private e s;
    protected final Handler t;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message msg) {
            if (msg.what != 1000 || BannerLayout.this.m != BannerLayout.this.f14855i.g()) {
                return false;
            }
            BannerLayout.c(BannerLayout.this);
            BannerLayout.this.f14854h.smoothScrollToPosition(BannerLayout.this.m);
            BannerLayout.this.t.sendEmptyMessageDelayed(1000, r5.f14847a);
            BannerLayout.this.o();
            return false;
        }
    }

    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        /* renamed from: m */
        public /* synthetic */ void n() {
            BannerLayout.this.f14854h.smoothScrollToPosition(BannerLayout.this.m);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            int g2 = BannerLayout.this.f14855i.g();
            if (BannerLayout.this.m != g2) {
                BannerLayout.this.m = g2;
            }
            if (newState == 0) {
                new Handler().post(new Runnable() { // from class: com.martian.mibook.ui.recybanner.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        BannerLayout.b.this.n();
                    }
                });
                if (BannerLayout.this.s != null) {
                    BannerLayout.this.s.onPageSelected(BannerLayout.this.m);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            if (dx != 0) {
                BannerLayout.this.setPlaying(false);
            }
        }
    }

    protected class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a */
        int f14859a = 0;

        class a extends RecyclerView.ViewHolder {
            a(View arg0) {
                super(arg0);
            }
        }

        protected c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return BannerLayout.this.l;
        }

        public void n(int currentPosition) {
            this.f14859a = currentPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ImageView) holder.itemView).setImageDrawable(this.f14859a == position ? BannerLayout.this.f14850d : BannerLayout.this.f14851e);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(BannerLayout.this.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
            layoutParams.setMargins(BannerLayout.this.f14853g, BannerLayout.this.f14853g, BannerLayout.this.f14853g, BannerLayout.this.f14853g);
            imageView.setLayoutParams(layoutParams);
            return new a(imageView);
        }
    }

    public interface d {
        void a(int position);
    }

    public interface e {
        void onPageSelected(int position);
    }

    public BannerLayout(Context context) {
        this(context, null);
    }

    static /* synthetic */ int c(BannerLayout bannerLayout) {
        int i2 = bannerLayout.m + 1;
        bannerLayout.m = i2;
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 0) {
            setPlaying(false);
        } else if (action == 1 || action == 3) {
            setPlaying(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    public RecyclerView getRecyclerView() {
        return this.f14854h;
    }

    protected int l(int dp) {
        return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
    }

    protected void m(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.BannerLayout);
        this.f14848b = obtainStyledAttributes.getBoolean(6, true);
        this.f14847a = obtainStyledAttributes.getInt(2, 4000);
        this.o = obtainStyledAttributes.getBoolean(0, true);
        this.p = obtainStyledAttributes.getInt(3, 20);
        this.q = obtainStyledAttributes.getFloat(1, 1.2f);
        this.r = obtainStyledAttributes.getFloat(4, 1.0f);
        if (this.f14850d == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-65536);
            gradientDrawable.setSize(l(5), l(5));
            gradientDrawable.setCornerRadius(l(5) / 2.0f);
            this.f14850d = new LayerDrawable(new Drawable[]{gradientDrawable});
        }
        if (this.f14851e == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(Color.GRAY);
            gradientDrawable2.setSize(l(5), l(5));
            gradientDrawable2.setCornerRadius(l(5) / 2.0f);
            this.f14851e = new LayerDrawable(new Drawable[]{gradientDrawable2});
        }
        this.f14853g = l(4);
        int l = l(16);
        int l2 = l(0);
        int l3 = l(11);
        int i2 = obtainStyledAttributes.getInt(5, 0) != 1 ? 0 : 1;
        obtainStyledAttributes.recycle();
        this.f14854h = new RecyclerView(context);
        addView(this.f14854h, new FrameLayout.LayoutParams(-1, -1));
        BannerLayoutManager bannerLayoutManager = new BannerLayoutManager(getContext(), i2);
        this.f14855i = bannerLayoutManager;
        bannerLayoutManager.I(this.p);
        this.f14855i.E(this.q);
        this.f14855i.L(this.r);
        this.f14854h.setLayoutManager(this.f14855i);
        new PagerSnapHelper().attachToRecyclerView(this.f14854h);
        this.f14849c = new RecyclerView(context);
        this.f14849c.setLayoutManager(new LinearLayoutManager(context, i2, false));
        c cVar = new c();
        this.f14852f = cVar;
        this.f14849c.setAdapter(cVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.f6715d;
        layoutParams.setMargins(l, 0, l2, l3);
        addView(this.f14849c, layoutParams);
        if (this.f14848b) {
            return;
        }
        this.f14849c.setVisibility(8);
    }

    public boolean n() {
        return this.n;
    }

    protected synchronized void o() {
        int i2;
        if (this.f14848b && (i2 = this.l) > 1) {
            this.f14852f.n(this.m % i2);
            this.f14852f.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPlaying(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPlaying(false);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        setPlaying(visibility == 0);
    }

    public void setAdapter(RecyclerView.Adapter<?> adapter) {
        this.k = false;
        this.f14854h.setAdapter(adapter);
        this.l = adapter.getItemCount();
        this.f14855i.H(false);
        setPlaying(true);
        this.f14854h.addOnScrollListener(new b());
        this.k = true;
    }

    public void setAutoPlayDuration(int autoPlayDuration) {
        this.f14847a = autoPlayDuration;
    }

    public void setAutoPlaying(boolean isAutoPlaying) {
        this.o = isAutoPlaying;
        setPlaying(isAutoPlaying);
    }

    public void setCenterScale(float centerScale) {
        this.q = centerScale;
        this.f14855i.E(centerScale);
    }

    public void setItemSpace(int itemSpace) {
        this.p = itemSpace;
        this.f14855i.I(itemSpace);
    }

    public void setMoveSpeed(float moveSpeed) {
        this.r = moveSpeed;
        this.f14855i.L(moveSpeed);
    }

    public void setOnPageChangeListener(e onPageChangeListener) {
        this.s = onPageChangeListener;
    }

    public void setOrientation(int orientation) {
        this.f14855i.setOrientation(orientation);
    }

    protected synchronized void setPlaying(boolean playing) {
        if (this.o && this.k) {
            boolean z = this.n;
            if (!z && playing) {
                this.t.sendEmptyMessageDelayed(1000, this.f14847a);
                this.n = true;
            } else if (z && !playing) {
                this.t.removeMessages(1000);
                this.n = false;
            }
        }
    }

    public void setShowIndicator(boolean showIndicator) {
        this.f14848b = showIndicator;
        this.f14849c.setVisibility(showIndicator ? 0 : 8);
    }

    public BannerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f14856j = 1000;
        this.l = 1;
        this.n = false;
        this.o = true;
        this.t = new Handler(new a());
        m(context, attrs);
    }
}
