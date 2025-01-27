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
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.badge.BadgeDrawable;
import com.martian.mibook.R;
import com.martian.mibook.ui.recybanner.BannerLayout;

/* loaded from: classes3.dex */
public class BannerLayout extends FrameLayout {

    /* renamed from: b */
    public int f16079b;

    /* renamed from: c */
    public boolean f16080c;

    /* renamed from: d */
    public RecyclerView f16081d;

    /* renamed from: e */
    public Drawable f16082e;

    /* renamed from: f */
    public Drawable f16083f;

    /* renamed from: g */
    public IndicatorAdapter f16084g;

    /* renamed from: h */
    public int f16085h;

    /* renamed from: i */
    public RecyclerView f16086i;

    /* renamed from: j */
    public BannerLayoutManager f16087j;

    /* renamed from: k */
    public final int f16088k;

    /* renamed from: l */
    public boolean f16089l;

    /* renamed from: m */
    public int f16090m;

    /* renamed from: n */
    public int f16091n;

    /* renamed from: o */
    public boolean f16092o;

    /* renamed from: p */
    public boolean f16093p;

    /* renamed from: q */
    public int f16094q;

    /* renamed from: r */
    public float f16095r;

    /* renamed from: s */
    public float f16096s;

    /* renamed from: t */
    public d f16097t;

    /* renamed from: u */
    public final Handler f16098u;

    public class IndicatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: c */
        public int f16099c = 0;

        public class a extends RecyclerView.ViewHolder {
            public a(View view) {
                super(view);
            }
        }

        public IndicatorAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return BannerLayout.this.f16090m;
        }

        public void i(int i10) {
            this.f16099c = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
            ((ImageView) viewHolder.itemView).setImageDrawable(this.f16099c == i10 ? BannerLayout.this.f16082e : BannerLayout.this.f16083f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
            ImageView imageView = new ImageView(BannerLayout.this.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
            layoutParams.setMargins(BannerLayout.this.f16085h, BannerLayout.this.f16085h, BannerLayout.this.f16085h, BannerLayout.this.f16085h);
            imageView.setLayoutParams(layoutParams);
            return new a(imageView);
        }
    }

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 1000 || BannerLayout.this.f16091n != BannerLayout.this.f16087j.q()) {
                return false;
            }
            BannerLayout.this.f16091n++;
            BannerLayout.this.f16086i.smoothScrollToPosition(BannerLayout.this.f16091n);
            BannerLayout.this.f16098u.sendEmptyMessageDelayed(1000, r5.f16079b);
            BannerLayout.this.n();
            return false;
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public final /* synthetic */ void m() {
            BannerLayout.this.f16086i.smoothScrollToPosition(BannerLayout.this.f16091n);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            int q10 = BannerLayout.this.f16087j.q();
            if (BannerLayout.this.f16091n != q10) {
                BannerLayout.this.f16091n = q10;
            }
            if (i10 == 0) {
                new Handler().post(new Runnable() { // from class: he.a
                    public /* synthetic */ a() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        BannerLayout.b.this.m();
                    }
                });
                if (BannerLayout.this.f16097t != null) {
                    BannerLayout.this.f16097t.onPageSelected(BannerLayout.this.f16091n);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0) {
                BannerLayout.this.setPlaying(false);
            }
        }
    }

    public interface c {
        void a(int i10);
    }

    public interface d {
        void onPageSelected(int i10);
    }

    public BannerLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setPlaying(false);
        } else if (action == 1 || action == 3) {
            setPlaying(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public RecyclerView getRecyclerView() {
        return this.f16086i;
    }

    public int k(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BannerLayout);
        this.f16080c = obtainStyledAttributes.getBoolean(R.styleable.BannerLayout_showIndicator, true);
        this.f16079b = obtainStyledAttributes.getInt(R.styleable.BannerLayout_interval, 4000);
        this.f16093p = obtainStyledAttributes.getBoolean(R.styleable.BannerLayout_autoPlaying, true);
        this.f16094q = obtainStyledAttributes.getInt(R.styleable.BannerLayout_itemSpace, 20);
        this.f16095r = obtainStyledAttributes.getFloat(R.styleable.BannerLayout_centerScale, 1.2f);
        this.f16096s = obtainStyledAttributes.getFloat(R.styleable.BannerLayout_moveSpeed, 1.0f);
        if (this.f16082e == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(SupportMenu.CATEGORY_MASK);
            gradientDrawable.setSize(k(5), k(5));
            gradientDrawable.setCornerRadius(k(5) / 2.0f);
            this.f16082e = new LayerDrawable(new Drawable[]{gradientDrawable});
        }
        if (this.f16083f == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(-7829368);
            gradientDrawable2.setSize(k(5), k(5));
            gradientDrawable2.setCornerRadius(k(5) / 2.0f);
            this.f16083f = new LayerDrawable(new Drawable[]{gradientDrawable2});
        }
        this.f16085h = k(4);
        int k10 = k(16);
        int k11 = k(0);
        int k12 = k(11);
        int i10 = obtainStyledAttributes.getInt(R.styleable.BannerLayout_orientations, 0) != 1 ? 0 : 1;
        obtainStyledAttributes.recycle();
        this.f16086i = new RecyclerView(context);
        addView(this.f16086i, new FrameLayout.LayoutParams(-1, -1));
        BannerLayoutManager bannerLayoutManager = new BannerLayoutManager(getContext(), i10);
        this.f16087j = bannerLayoutManager;
        bannerLayoutManager.S(this.f16094q);
        this.f16087j.O(this.f16095r);
        this.f16087j.V(this.f16096s);
        this.f16086i.setLayoutManager(this.f16087j);
        new PagerSnapHelper().attachToRecyclerView(this.f16086i);
        this.f16081d = new RecyclerView(context);
        this.f16081d.setLayoutManager(new LinearLayoutManager(context, i10, false));
        IndicatorAdapter indicatorAdapter = new IndicatorAdapter();
        this.f16084g = indicatorAdapter;
        this.f16081d.setAdapter(indicatorAdapter);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.setMargins(k10, 0, k11, k12);
        addView(this.f16081d, layoutParams);
        if (this.f16080c) {
            return;
        }
        this.f16081d.setVisibility(8);
    }

    public boolean m() {
        return this.f16092o;
    }

    public synchronized void n() {
        int i10;
        if (this.f16080c && (i10 = this.f16090m) > 1) {
            this.f16084g.i(this.f16091n % i10);
            this.f16084g.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPlaying(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPlaying(false);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        setPlaying(i10 == 0);
    }

    public void setAdapter(RecyclerView.Adapter<?> adapter) {
        this.f16089l = false;
        this.f16086i.setAdapter(adapter);
        this.f16090m = adapter.getPageSize();
        this.f16087j.R(false);
        setPlaying(true);
        this.f16086i.addOnScrollListener(new b());
        this.f16089l = true;
    }

    public void setAutoPlayDuration(int i10) {
        this.f16079b = i10;
    }

    public void setAutoPlaying(boolean z10) {
        this.f16093p = z10;
        setPlaying(z10);
    }

    public void setCenterScale(float f10) {
        this.f16095r = f10;
        this.f16087j.O(f10);
    }

    public void setItemSpace(int i10) {
        this.f16094q = i10;
        this.f16087j.S(i10);
    }

    public void setMoveSpeed(float f10) {
        this.f16096s = f10;
        this.f16087j.V(f10);
    }

    public void setOnPageChangeListener(d dVar) {
        this.f16097t = dVar;
    }

    public void setOrientation(int i10) {
        this.f16087j.setOrientation(i10);
    }

    public synchronized void setPlaying(boolean z10) {
        try {
            if (this.f16093p && this.f16089l) {
                boolean z11 = this.f16092o;
                if (!z11 && z10) {
                    this.f16098u.sendEmptyMessageDelayed(1000, this.f16079b);
                    this.f16092o = true;
                } else if (z11 && !z10) {
                    this.f16098u.removeMessages(1000);
                    this.f16092o = false;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void setShowIndicator(boolean z10) {
        this.f16080c = z10;
        this.f16081d.setVisibility(z10 ? 0 : 8);
    }

    public BannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16088k = 1000;
        this.f16090m = 1;
        this.f16092o = false;
        this.f16093p = true;
        this.f16098u = new Handler(new a());
        l(context, attributeSet);
    }
}
