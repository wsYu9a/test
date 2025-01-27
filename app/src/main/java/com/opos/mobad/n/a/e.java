package com.opos.mobad.n.a;

import android.view.View;
import com.opos.mobad.n.d;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class e implements com.opos.mobad.n.d {

    /* renamed from: a */
    private d.a f21773a;

    /* renamed from: com.opos.mobad.n.a.e$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (e.this.f21773a != null) {
                e.this.f21773a.a(view, iArr);
            }
        }
    }

    public e(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.e.1
                AnonymousClass1() {
                }

                @Override // com.opos.mobad.n.c.g
                public void a(View view2, int[] iArr) {
                    if (e.this.f21773a != null) {
                        e.this.f21773a.a(view2, iArr);
                    }
                }
            };
            view.setOnClickListener(anonymousClass1);
            view.setOnTouchListener(anonymousClass1);
        }
    }

    @Override // com.opos.mobad.n.d
    public void a(d.a aVar) {
        this.f21773a = aVar;
    }
}
