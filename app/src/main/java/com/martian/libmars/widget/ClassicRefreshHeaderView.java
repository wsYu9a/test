package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.martian.libmars.R;

/* loaded from: classes2.dex */
public class ClassicRefreshHeaderView extends RelativeLayout implements com.martian.libmars.widget.recyclerview.h.b {

    /* renamed from: a */
    private final ImageView f10303a;

    /* renamed from: b */
    private final ImageView f10304b;

    /* renamed from: c */
    private final TextView f10305c;

    /* renamed from: d */
    private final ProgressBar f10306d;

    /* renamed from: e */
    private final Animation f10307e;

    /* renamed from: f */
    private final Animation f10308f;

    /* renamed from: g */
    private boolean f10309g;

    /* renamed from: h */
    private int f10310h;

    public ClassicRefreshHeaderView(Context context) {
        this(context, null);
    }

    @Override // com.martian.libmars.widget.recyclerview.h.b
    public void a(boolean isComplete, boolean automatic, int moved) {
        if (isComplete) {
            return;
        }
        this.f10303a.setVisibility(0);
        this.f10306d.setVisibility(8);
        this.f10304b.setVisibility(8);
        if (moved <= this.f10310h) {
            if (this.f10309g) {
                this.f10303a.clearAnimation();
                this.f10303a.startAnimation(this.f10308f);
                this.f10309g = false;
            }
            this.f10305c.setText("SWIPE TO REFRESH");
            return;
        }
        this.f10305c.setText("RELEASE TO REFRESH");
        if (this.f10309g) {
            return;
        }
        this.f10303a.clearAnimation();
        this.f10303a.startAnimation(this.f10307e);
        this.f10309g = true;
    }

    @Override // com.martian.libmars.widget.recyclerview.h.b
    public void b(boolean automatic, int headerHeight, int finalHeight) {
        this.f10310h = headerHeight;
        this.f10306d.setIndeterminate(false);
    }

    @Override // com.martian.libmars.widget.recyclerview.h.b
    public void c() {
        this.f10309g = false;
        this.f10304b.setVisibility(0);
        this.f10303a.clearAnimation();
        this.f10303a.setVisibility(8);
        this.f10306d.setVisibility(8);
        this.f10305c.setText("COMPLETE");
    }

    @Override // com.martian.libmars.widget.recyclerview.h.b
    public void d() {
        this.f10309g = false;
        this.f10304b.setVisibility(8);
        this.f10303a.clearAnimation();
        this.f10303a.setVisibility(8);
        this.f10306d.setVisibility(8);
    }

    @Override // com.martian.libmars.widget.recyclerview.h.b
    public void onRefresh() {
        this.f10304b.setVisibility(8);
        this.f10303a.clearAnimation();
        this.f10303a.setVisibility(8);
        this.f10306d.setVisibility(0);
        this.f10305c.setText("REFRESHING");
    }

    @Override // com.martian.libmars.widget.recyclerview.h.b
    public void onRelease() {
    }

    public ClassicRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClassicRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f10309g = false;
        RelativeLayout.inflate(context, R.layout.layout_irecyclerview_classic_refresh_header_view, this);
        this.f10305c = (TextView) findViewById(R.id.tvRefresh);
        this.f10303a = (ImageView) findViewById(R.id.ivArrow);
        this.f10304b = (ImageView) findViewById(R.id.ivSuccess);
        this.f10306d = (ProgressBar) findViewById(R.id.progressbar);
        this.f10307e = AnimationUtils.loadAnimation(context, R.anim.rotate_up);
        this.f10308f = AnimationUtils.loadAnimation(context, R.anim.rotate_down);
    }
}
