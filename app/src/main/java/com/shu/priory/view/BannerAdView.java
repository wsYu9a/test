package com.shu.priory.view;

import android.content.Context;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.listener.IFLYAdListener;
import com.shu.priory.param.c;
import com.shu.priory.utils.a;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class BannerAdView extends AdView {

    /* renamed from: u */
    private boolean f17438u;

    /* renamed from: v */
    private Context f17439v;

    /* renamed from: w */
    private boolean f17440w;

    public BannerAdView(Context context) {
        super(context);
        this.f17438u = false;
        this.f17440w = true;
    }

    @Override // com.shu.priory.view.AdView
    public synchronized void a(IFLYAdListener iFLYAdListener) {
        if (this.f17438u) {
            return;
        }
        this.f17438u = true;
        super.a(iFLYAdListener);
    }

    @Override // com.shu.priory.view.AdView
    public synchronized void d(Message message) throws Exception {
        if (!com.shu.priory.utils.b.a(this.f17439v) && !com.shu.priory.utils.b.b(this.f17439v)) {
            ViewGroup viewGroup = (ViewGroup) this.f17410c.getParent();
            if (viewGroup == null) {
                h.a(SDKConstants.TAG, "Ad has no parent!");
                return;
            }
            if (this.f17440w) {
                this.f17440w = false;
            } else if (!this.f17410c.isShown()) {
                h.a(SDKConstants.TAG, "Ad is invisible, recycle delayed!");
                b bVar = this.f17420m;
                bVar.a(bVar.obtainMessage(1), getRecycleInterval());
                return;
            } else if (!com.shu.priory.utils.b.a(this.f17439v, viewGroup)) {
                h.a(SDKConstants.TAG, "Ad is invisible,not in screen, recycle delayed!");
                b bVar2 = this.f17420m;
                bVar2.a(bVar2.obtainMessage(1), getRecycleInterval());
                return;
            }
            super.d(message);
            return;
        }
        h.a(SDKConstants.TAG, "Ad is invisible, please check the app's state!");
        b bVar3 = this.f17420m;
        bVar3.a(bVar3.obtainMessage(1), getRecycleInterval());
    }

    @Override // com.shu.priory.view.AdView
    public synchronized void g() {
        h.a(SDKConstants.TAG, "recycleLoadAd");
        if (this.f17410c.getParent() == null) {
            h.a(SDKConstants.TAG, "There isn't valid parent widget!");
            return;
        }
        if (a.c.end != this.f17420m.a()) {
            h.a(SDKConstants.TAG, "Ad is requesting, can't recycle load ad!");
            return;
        }
        if (e()) {
            b bVar = this.f17420m;
            bVar.a(bVar.obtainMessage(1), getRecycleInterval());
        } else {
            this.f17438u = false;
        }
    }

    @Override // com.shu.priory.view.AdView
    public void j() {
        int min = Math.min(c.e(this.f17439v), c.f(this.f17439v));
        int adHeight = (this.f17413f.getAdHeight() * min) / this.f17413f.getAdWidth();
        this.f17410c.setGravity(17);
        a(min, adHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public BannerAdView(Context context, RelativeLayout relativeLayout, String str, com.shu.priory.listener.a aVar) {
        super(context, relativeLayout, str, a.EnumC0557a.BANNER, aVar);
        this.f17438u = false;
        this.f17440w = true;
        this.f17439v = context.getApplicationContext();
    }
}
