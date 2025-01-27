package com.vivo.mobilead.unified.exitFloat;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.ad.model.a0;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.view.q.c;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.t;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.z;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b extends Dialog {

    /* renamed from: a */
    private com.vivo.mobilead.unified.base.view.q.c f30283a;

    /* renamed from: b */
    private Activity f30284b;

    /* renamed from: c */
    private List<com.vivo.ad.model.b> f30285c;

    /* renamed from: d */
    private com.vivo.mobilead.unified.exitFloat.d f30286d;

    /* renamed from: e */
    private volatile boolean f30287e;

    /* renamed from: f */
    private long f30288f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f30284b == null || b.this.f30284b.isFinishing()) {
                return;
            }
            b.this.dismiss();
            b.this.f30284b.finish();
        }
    }

    /* renamed from: com.vivo.mobilead.unified.exitFloat.b$b */
    class ViewOnClickListenerC0642b implements View.OnClickListener {
        ViewOnClickListenerC0642b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f30284b == null || b.this.f30284b.isFinishing()) {
                return;
            }
            b.this.dismiss();
        }
    }

    class c implements com.vivo.mobilead.unified.base.callback.g {

        /* renamed from: a */
        final /* synthetic */ List f30291a;

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ int f30293a;

            a(int i2) {
                this.f30293a = i2;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (b.this.f30286d != null) {
                    b.this.f30286d.onAdClick(this.f30293a + 1);
                }
            }
        }

        c(List list) {
            this.f30291a = list;
        }

        @Override // com.vivo.mobilead.unified.base.callback.g
        public void a(View view, int i2, int i3, int i4, int i5, int i6, boolean z) {
            com.vivo.ad.model.b bVar;
            List list = this.f30291a;
            if (list == null || list.size() < i2 || (bVar = (com.vivo.ad.model.b) b.this.f30285c.get(i2)) == null) {
                return;
            }
            boolean a2 = com.vivo.mobilead.util.e.a(z, bVar);
            k0.a(bVar, z, i3, i4, i5, i6, "4", u.a(b.this.f30284b, bVar, a2, z, "", "4", (BackUrlInfo) null, 0, 4), "", 0, a2);
            if (!bVar.a().c()) {
                k0.a(bVar, a.EnumC0603a.CLICK, i3, i4, i5, i6, -999, -999, -999, -999, "");
                bVar.a().a(true);
            }
            z.b().a(new a(i2));
        }
    }

    class d implements c.b {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (b.this.f30286d != null) {
                    b.this.f30286d.onAdShow();
                }
            }
        }

        d() {
        }

        @Override // com.vivo.mobilead.unified.base.view.q.c.b
        public void a(GridView gridView) {
            if (b.this.f30287e) {
                return;
            }
            b.this.f30287e = true;
            b bVar = b.this;
            k0.a(bVar.a(gridView, (List<com.vivo.ad.model.b>) bVar.f30285c), "4", 0, c.a.f28912a.intValue(), 4, 43, b.this.f30288f);
            z.b().a(new a());
        }
    }

    class e implements DialogInterface.OnKeyListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || keyEvent.getRepeatCount() != 0 || b.this.f30284b == null) {
                return false;
            }
            b.this.f30284b.finish();
            return false;
        }
    }

    public b(@NonNull Activity activity) {
        super(activity);
        this.f30287e = false;
        this.f30284b = activity;
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        setOwnerActivity(activity);
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setFeatureDrawableAlpha(0, 0);
        requestWindowFeature(1);
        this.f30283a = new com.vivo.mobilead.unified.base.view.q.c(activity);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
        }
    }

    public void a(List<com.vivo.ad.model.b> list, com.vivo.mobilead.unified.exitFloat.d dVar, long j2) {
        this.f30286d = dVar;
        this.f30285c = list;
        this.f30288f = j2;
        this.f30283a.a(list);
        setContentView(this.f30283a);
        this.f30283a.setOnExitClickListener(new a());
        this.f30283a.setOnBackClickListener(new ViewOnClickListenerC0642b());
        this.f30283a.setOnADWidgetItemClickListener(new c(list));
        this.f30283a.setExposureListener(new d());
        setOnKeyListener(new e());
    }

    public String a(GridView gridView, List<com.vivo.ad.model.b> list) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (list == null || list.isEmpty()) {
            return "";
        }
        int childCount = gridView.getChildCount();
        JSONArray jSONArray = new JSONArray();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (i6 < list.size()) {
                com.vivo.ad.model.b bVar = list.get(i6);
                View childAt = gridView.getChildAt(i6);
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(bVar.P())) {
                    t.a(jSONObject, OapsKey.KEY_TOKEN, bVar.P());
                }
                if (!TextUtils.isEmpty(bVar.d())) {
                    t.a(jSONObject, "id", bVar.d());
                }
                if (!TextUtils.isEmpty("" + bVar.q())) {
                    t.a(jSONObject, "dspid", "" + bVar.q());
                }
                com.vivo.ad.model.f f2 = bVar.f();
                a0 Q = bVar.Q();
                String f3 = f2 != null ? f2.f() : "";
                if (Q != null) {
                    f3 = Q.f();
                }
                if (!TextUtils.isEmpty(f3)) {
                    t.a(jSONObject, "materialids", f3);
                }
                if (childAt != null) {
                    Rect a2 = a(childAt);
                    int i7 = a2.left;
                    int i8 = a2.top;
                    int i9 = a2.right;
                    int i10 = a2.bottom;
                    t.a(jSONObject, "adLeftTopX", "" + i7);
                    t.a(jSONObject, "adLeftTopY", "" + i8);
                    t.a(jSONObject, "adRightBottomX", "" + i9);
                    t.a(jSONObject, "adRightBottomY", "" + i10);
                    i5 = i10;
                    i2 = i7;
                    i3 = i8;
                    i4 = i9;
                } else {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                }
                k0.a(bVar, a.EnumC0603a.SHOW, -999, -999, -999, -999, i2, i3, i4, i5, "");
                if (jSONObject.length() > 0) {
                    jSONArray.put(jSONObject);
                }
            }
        }
        try {
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private Rect a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }
}
