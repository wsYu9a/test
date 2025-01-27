package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: classes4.dex */
public class i extends b {

    /* renamed from: h */
    private static int f23042h;

    /* renamed from: e */
    private TextView f23043e;

    /* renamed from: f */
    private com.opos.cmn.e.a.a.a f23044f;

    /* renamed from: g */
    private final String f23045g;

    /* renamed from: com.opos.mobad.o.b.i$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int[] f23046a;

        AnonymousClass1(int[] iArr) {
            iArr = iArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            iVar.f23011b.b(iVar.f23044f, iArr);
        }
    }

    public i(Context context, e eVar) {
        super(context, eVar);
        this.f23045g = "当前是数据网络，播放视频将消耗流量";
    }

    private void e() {
        int[] iArr = new int[4];
        this.f23044f.setOnTouchListener(new com.opos.cmn.e.a.a.b(iArr));
        this.f23044f.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.i.1

            /* renamed from: a */
            final /* synthetic */ int[] f23046a;

            AnonymousClass1(int[] iArr2) {
                iArr = iArr2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i iVar = i.this;
                iVar.f23011b.b(iVar.f23044f, iArr);
            }
        });
    }

    @Override // com.opos.mobad.o.b.b
    protected void a() {
        ImageView imageView = new ImageView(this.f23010a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(0.4f);
        this.f23012c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.o.b.b
    protected void b() {
        TextView textView = new TextView(this.f23010a);
        this.f23043e = textView;
        textView.setText("当前是数据网络，播放视频将消耗流量");
        int a2 = com.opos.mobad.cmn.a.b.g.a();
        f23042h = a2;
        this.f23043e.setId(a2);
        this.f23043e.setTextColor(-1);
        this.f23043e.setTextSize(1, 14.0f);
        this.f23043e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f23013d.addView(this.f23043e, layoutParams);
    }

    @Override // com.opos.mobad.o.b.b
    protected void c() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f23010a, R.drawable.native_video_bt);
        this.f23044f = aVar;
        aVar.setText("继续播放");
        this.f23044f.setGravity(17);
        this.f23044f.setTextSize(1, 14.0f);
        this.f23044f.setTextColor(Color.parseColor("#2AD181"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23010a, 70.0f), com.opos.cmn.an.h.f.a.a(this.f23010a, 24.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23010a, 14.0f);
        layoutParams.addRule(3, f23042h);
        layoutParams.addRule(14);
        this.f23013d.addView(this.f23044f, layoutParams);
        e();
    }

    public View d() {
        return this.f23012c;
    }
}
