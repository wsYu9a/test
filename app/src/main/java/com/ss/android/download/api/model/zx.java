package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: g */
    public String f24082g;
    public boolean gv;

    /* renamed from: i */
    public String f24083i;

    /* renamed from: j */
    public Context f24084j;
    public View k;
    public Drawable lg;
    public int pa;
    public String q;
    public InterfaceC0493zx y;
    public String zx;

    public static final class j {

        /* renamed from: g */
        private String f24085g;
        private String gv;

        /* renamed from: i */
        private Context f24086i;

        /* renamed from: j */
        public View f24087j;
        private Drawable k;
        private String lg;
        private InterfaceC0493zx pa;
        private String q;
        private boolean y;
        public int zx;

        public j(Context context) {
            this.f24086i = context;
        }

        public j g(String str) {
            this.lg = str;
            return this;
        }

        public j i(String str) {
            this.gv = str;
            return this;
        }

        public j j(String str) {
            this.f24085g = str;
            return this;
        }

        public j zx(String str) {
            this.q = str;
            return this;
        }

        public j j(boolean z) {
            this.y = z;
            return this;
        }

        public j j(Drawable drawable) {
            this.k = drawable;
            return this;
        }

        public j j(InterfaceC0493zx interfaceC0493zx) {
            this.pa = interfaceC0493zx;
            return this;
        }

        public j j(int i2) {
            this.zx = i2;
            return this;
        }

        public zx j() {
            return new zx(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.zx$zx */
    public interface InterfaceC0493zx {
        void i(DialogInterface dialogInterface);

        void j(DialogInterface dialogInterface);

        void zx(DialogInterface dialogInterface);
    }

    /* synthetic */ zx(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    private zx(j jVar) {
        this.gv = true;
        this.f24084j = jVar.f24086i;
        this.zx = jVar.f24085g;
        this.f24083i = jVar.q;
        this.f24082g = jVar.gv;
        this.q = jVar.lg;
        this.gv = jVar.y;
        this.lg = jVar.k;
        this.y = jVar.pa;
        this.k = jVar.f24087j;
        this.pa = jVar.zx;
    }
}
