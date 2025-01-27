package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.martian.libmars.R;
import u9.b;

/* loaded from: classes3.dex */
public class ClassicRefreshHeaderView extends RelativeLayout implements b {

    /* renamed from: b */
    public final ImageView f12514b;

    /* renamed from: c */
    public final ImageView f12515c;

    /* renamed from: d */
    public final TextView f12516d;

    /* renamed from: e */
    public final ProgressBar f12517e;

    /* renamed from: f */
    public final Animation f12518f;

    /* renamed from: g */
    public final Animation f12519g;

    /* renamed from: h */
    public boolean f12520h;

    /* renamed from: i */
    public int f12521i;

    public ClassicRefreshHeaderView(Context context) {
        this(context, null);
    }

    @Override // u9.b
    public void a(boolean z10, boolean z11, int i10) {
        if (z10) {
            return;
        }
        this.f12514b.setVisibility(0);
        this.f12517e.setVisibility(8);
        this.f12515c.setVisibility(8);
        if (i10 <= this.f12521i) {
            if (this.f12520h) {
                this.f12514b.clearAnimation();
                this.f12514b.startAnimation(this.f12519g);
                this.f12520h = false;
            }
            this.f12516d.setText("SWIPE TO REFRESH");
            return;
        }
        this.f12516d.setText("RELEASE TO REFRESH");
        if (this.f12520h) {
            return;
        }
        this.f12514b.clearAnimation();
        this.f12514b.startAnimation(this.f12518f);
        this.f12520h = true;
    }

    @Override // u9.b
    public void b(boolean z10, int i10, int i11) {
        this.f12521i = i10;
        this.f12517e.setIndeterminate(false);
    }

    @Override // u9.b
    public void onComplete() {
        this.f12520h = false;
        this.f12515c.setVisibility(0);
        this.f12514b.clearAnimation();
        this.f12514b.setVisibility(8);
        this.f12517e.setVisibility(8);
        this.f12516d.setText("COMPLETE");
    }

    @Override // u9.b
    public void onRefresh() {
        this.f12515c.setVisibility(8);
        this.f12514b.clearAnimation();
        this.f12514b.setVisibility(8);
        this.f12517e.setVisibility(0);
        this.f12516d.setText("REFRESHING");
    }

    @Override // u9.b
    public void onRelease() {
    }

    @Override // u9.b
    public void onReset() {
        this.f12520h = false;
        this.f12515c.setVisibility(8);
        this.f12514b.clearAnimation();
        this.f12514b.setVisibility(8);
        this.f12517e.setVisibility(8);
    }

    public ClassicRefreshHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicRefreshHeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12520h = false;
        View.inflate(context, R.layout.layout_irecyclerview_classic_refresh_header_view, this);
        this.f12516d = (TextView) findViewById(R.id.tvRefresh);
        this.f12514b = (ImageView) findViewById(R.id.ivArrow);
        this.f12515c = (ImageView) findViewById(R.id.ivSuccess);
        this.f12517e = (ProgressBar) findViewById(R.id.progressbar);
        this.f12518f = AnimationUtils.loadAnimation(context, R.anim.rotate_up);
        this.f12519g = AnimationUtils.loadAnimation(context, R.anim.rotate_down);
    }
}
