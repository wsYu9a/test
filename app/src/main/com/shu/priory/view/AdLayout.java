package com.shu.priory.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: classes3.dex */
public abstract class AdLayout extends RelativeLayout {

    /* renamed from: a */
    private final int f17402a;

    /* renamed from: b */
    protected com.shu.priory.listener.a f17403b;

    /* renamed from: c */
    private boolean f17404c;

    /* renamed from: d */
    private a f17405d;

    /* renamed from: com.shu.priory.view.AdLayout$1 */
    public class AnonymousClass1 implements com.shu.priory.listener.a {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.listener.a
        public boolean a() {
            if (AdLayout.this.f17404c) {
                return false;
            }
            AdLayout.this.f17404c = true;
            if (AdLayout.this.f17405d != null) {
                AdLayout.this.f17405d.sendEmptyMessage(1);
            }
            return true;
        }
    }

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            AdLayout.this.destroy();
        }
    }

    public AdLayout(Context context) {
        super(context);
        this.f17402a = 1;
        this.f17404c = false;
        this.f17403b = new com.shu.priory.listener.a() { // from class: com.shu.priory.view.AdLayout.1
            public AnonymousClass1() {
            }

            @Override // com.shu.priory.listener.a
            public boolean a() {
                if (AdLayout.this.f17404c) {
                    return false;
                }
                AdLayout.this.f17404c = true;
                if (AdLayout.this.f17405d != null) {
                    AdLayout.this.f17405d.sendEmptyMessage(1);
                }
                return true;
            }
        };
        this.f17405d = new a(context.getMainLooper());
    }

    public synchronized void destroy() {
        try {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            removeAllViews();
            setVisibility(8);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
