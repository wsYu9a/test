package com.opos.mobad.o.d;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.e.a.b.d.a;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: com.opos.mobad.o.d.e$1 */
    static final class AnonymousClass1 implements b {

        /* renamed from: b */
        final /* synthetic */ a f23102b;

        /* renamed from: c */
        final /* synthetic */ com.opos.cmn.e.a.b.f.a f23103c;

        AnonymousClass1(a aVar, com.opos.cmn.e.a.b.f.a aVar2) {
            aVar2 = aVar;
            aVar = aVar2;
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            b bVar = b.this;
            if (bVar != null) {
                bVar.a();
            }
            aVar2.a();
            aVar.dismiss();
        }
    }

    /* renamed from: com.opos.mobad.o.d.e$2 */
    static final class AnonymousClass2 implements DialogInterface.OnKeyListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            b bVar = b.this;
            if (bVar != null) {
                bVar.a();
            }
            dialogInterface.dismiss();
            return true;
        }
    }

    /* renamed from: com.opos.mobad.o.d.e$3 */
    static final class AnonymousClass3 implements b {

        /* renamed from: b */
        final /* synthetic */ a f23106b;

        AnonymousClass3(a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            b bVar = b.this;
            if (bVar != null) {
                bVar.a();
            }
            aVar.a();
        }
    }

    public static final class a extends RelativeLayout {

        /* renamed from: a */
        private LinearLayout f23107a;

        /* renamed from: b */
        private TextView f23108b;

        /* renamed from: c */
        private Context f23109c;

        /* renamed from: d */
        private b f23110d;

        /* renamed from: e */
        private d f23111e;

        /* renamed from: com.opos.mobad.o.d.e$a$1 */
        class AnonymousClass1 implements View.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f23110d != null) {
                    a.this.f23110d.a();
                }
            }
        }

        public a(Context context) {
            super(context);
            this.f23109c = com.opos.mobad.service.b.a(context.getApplicationContext());
            b();
        }

        private void a(int i2, b bVar) {
            d dVar = this.f23111e;
            if (dVar != null) {
                if (i2 == dVar.a()) {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "Same type use last view");
                    return;
                } else {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "differ type use new one");
                    removeView(this.f23111e.b());
                    this.f23111e.c();
                }
            }
            d a2 = c.a(getContext(), i2, bVar);
            this.f23111e = a2;
            View b2 = a2.b();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.f23107a.getId());
            addView(b2, layoutParams);
        }

        private void b() {
            setBackgroundColor(-1);
            LinearLayout linearLayout = new LinearLayout(this.f23109c);
            this.f23107a = linearLayout;
            linearLayout.setId(View.generateViewId());
            this.f23107a.setOrientation(0);
            TextView textView = new TextView(this.f23109c);
            this.f23108b = new TextView(this.f23109c);
            textView.setBackground(com.opos.cmn.an.d.a.a.c(this.f23109c, "opos_module_biz_ui_cmn_privacy_web_close_bn.png"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.d.e.a.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.f23110d != null) {
                        a.this.f23110d.a();
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23109c, 16.58f), com.opos.cmn.an.h.f.a.a(this.f23109c, 12.73f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f23109c, 23.71f);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23109c, 18.71f);
            this.f23107a.addView(textView, layoutParams);
            this.f23108b.setGravity(8388627);
            this.f23108b.setTextSize(1, 16.0f);
            this.f23108b.setTextColor(-16777216);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.f23107a.addView(this.f23108b, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f23109c, 50.0f));
            layoutParams3.addRule(10);
            addView(this.f23107a, layoutParams3);
        }

        public void a() {
            removeAllViews();
            d dVar = this.f23111e;
            if (dVar != null) {
                dVar.c();
            }
        }

        public void a(b bVar) {
            this.f23110d = bVar;
        }

        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show url = " + str);
            a(0, this.f23110d);
            this.f23111e.a(str);
            this.f23108b.setText(str2);
        }

        public void a(Map<String, String> map, String str) {
            if (map == null) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show Map");
            a(1, this.f23110d);
            this.f23111e.a(map);
            this.f23108b.setText(str);
        }
    }

    public interface b {
        void a();
    }

    public static Dialog a(Activity activity, String str, String str2, b bVar) {
        return a(activity, str, str2, (Map<String, String>) null, bVar);
    }

    public static Dialog a(Activity activity, String str, String str2, Map<String, String> map, b bVar) {
        com.opos.cmn.e.a.b.f.a aVar = new com.opos.cmn.e.a.b.f.a(activity, R.style.Theme.NoTitleBar, new a.C0384a().a(R.style.Theme.NoTitleBar).a(false).b(false).a());
        a aVar2 = new a(activity);
        aVar2.a(new b() { // from class: com.opos.mobad.o.d.e.1

            /* renamed from: b */
            final /* synthetic */ a f23102b;

            /* renamed from: c */
            final /* synthetic */ com.opos.cmn.e.a.b.f.a f23103c;

            AnonymousClass1(a aVar22, com.opos.cmn.e.a.b.f.a aVar3) {
                aVar2 = aVar22;
                aVar = aVar3;
            }

            @Override // com.opos.mobad.o.d.e.b
            public void a() {
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.a();
                }
                aVar2.a();
                aVar.dismiss();
            }
        });
        if (TextUtils.isEmpty(str2)) {
            aVar22.a(map, str);
        } else {
            aVar22.a(str2, str);
        }
        aVar3.setContentView(aVar22);
        aVar3.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        aVar3.getWindow().setLayout(-1, -1);
        aVar3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.opos.mobad.o.d.e.2
            AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.a();
                }
                dialogInterface.dismiss();
                return true;
            }
        });
        aVar3.show();
        return aVar3;
    }

    public static a a(Context context, String str, String str2, Map<String, String> map, b bVar) {
        a aVar = new a(context);
        aVar.a(new b() { // from class: com.opos.mobad.o.d.e.3

            /* renamed from: b */
            final /* synthetic */ a f23106b;

            AnonymousClass3(a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.o.d.e.b
            public void a() {
                b bVar2 = b.this;
                if (bVar2 != null) {
                    bVar2.a();
                }
                aVar.a();
            }
        });
        if (TextUtils.isEmpty(str2)) {
            aVar2.a(map, str);
        } else {
            aVar2.a(str2, str);
        }
        aVar2.setBackgroundColor(-1);
        return aVar2;
    }
}
