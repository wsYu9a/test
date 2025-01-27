package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class c extends b {

    /* renamed from: h */
    private static int f23014h;

    /* renamed from: e */
    private TextView f23015e;

    /* renamed from: f */
    private com.opos.cmn.e.a.a.c f23016f;

    /* renamed from: g */
    private final String f23017g;

    /* renamed from: i */
    private final String f23018i;

    /* renamed from: com.opos.mobad.o.b.c$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int[] f23019a;

        AnonymousClass1(int[] iArr) {
            iArr = iArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f23011b.a(cVar.f23016f, iArr);
        }
    }

    public c(Context context, e eVar) {
        super(context, eVar);
        this.f23017g = "抱歉，视频播放失败，请点击重试";
        this.f23018i = "opos_module_biz_ui_native_video_replay_cover.png";
    }

    private void e() {
        int[] iArr = new int[4];
        this.f23016f.setOnTouchListener(new com.opos.cmn.e.a.a.b(iArr));
        this.f23016f.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.c.1

            /* renamed from: a */
            final /* synthetic */ int[] f23019a;

            AnonymousClass1(int[] iArr2) {
                iArr = iArr2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.f23011b.a(cVar.f23016f, iArr);
            }
        });
    }

    @Override // com.opos.mobad.o.b.b
    protected void a() {
        ImageView imageView = new ImageView(this.f23010a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(1.0f);
        this.f23012c.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.o.b.b
    protected void b() {
        TextView textView = new TextView(this.f23010a);
        this.f23015e = textView;
        textView.setText("抱歉，视频播放失败，请点击重试");
        int a2 = com.opos.mobad.cmn.a.b.g.a();
        f23014h = a2;
        this.f23015e.setId(a2);
        this.f23015e.setTextColor(-1);
        this.f23015e.setTextSize(1, 14.0f);
        this.f23015e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.f23013d.addView(this.f23015e, layoutParams);
    }

    @Override // com.opos.mobad.o.b.b
    protected void c() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f23010a, 50.0f);
        this.f23016f = cVar;
        cVar.setScaleType(ImageView.ScaleType.CENTER);
        this.f23016f.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f23010a, "opos_module_biz_ui_native_video_replay_cover.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23010a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f23010a, 40.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23010a, 14.0f);
        layoutParams.addRule(3, f23014h);
        layoutParams.addRule(14);
        this.f23013d.addView(this.f23016f, layoutParams);
        e();
    }

    public View d() {
        return this.f23012c;
    }
}
