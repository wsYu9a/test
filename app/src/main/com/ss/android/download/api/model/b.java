package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public Context f20989a;

    /* renamed from: b */
    public String f20990b;

    /* renamed from: c */
    public String f20991c;

    /* renamed from: d */
    public String f20992d;

    /* renamed from: e */
    public String f20993e;

    /* renamed from: f */
    public boolean f20994f;

    /* renamed from: g */
    public Drawable f20995g;

    /* renamed from: h */
    public InterfaceC0631b f20996h;

    /* renamed from: i */
    public View f20997i;

    /* renamed from: j */
    public int f20998j;

    public static final class a {

        /* renamed from: a */
        public View f20999a;

        /* renamed from: b */
        public int f21000b;

        /* renamed from: c */
        private Context f21001c;

        /* renamed from: d */
        private String f21002d;

        /* renamed from: e */
        private String f21003e;

        /* renamed from: f */
        private String f21004f;

        /* renamed from: g */
        private String f21005g;

        /* renamed from: h */
        private boolean f21006h;

        /* renamed from: i */
        private Drawable f21007i;

        /* renamed from: j */
        private InterfaceC0631b f21008j;

        public a(Context context) {
            this.f21001c = context;
        }

        public a a(String str) {
            this.f21002d = str;
            return this;
        }

        public a b(String str) {
            this.f21003e = str;
            return this;
        }

        public a c(String str) {
            this.f21004f = str;
            return this;
        }

        public a d(String str) {
            this.f21005g = str;
            return this;
        }

        public a a(boolean z10) {
            this.f21006h = z10;
            return this;
        }

        public a a(Drawable drawable) {
            this.f21007i = drawable;
            return this;
        }

        public a a(InterfaceC0631b interfaceC0631b) {
            this.f21008j = interfaceC0631b;
            return this;
        }

        public a a(int i10) {
            this.f21000b = i10;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b */
    public interface InterfaceC0631b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private b(a aVar) {
        this.f20994f = true;
        this.f20989a = aVar.f21001c;
        this.f20990b = aVar.f21002d;
        this.f20991c = aVar.f21003e;
        this.f20992d = aVar.f21004f;
        this.f20993e = aVar.f21005g;
        this.f20994f = aVar.f21006h;
        this.f20995g = aVar.f21007i;
        this.f20996h = aVar.f21008j;
        this.f20997i = aVar.f20999a;
        this.f20998j = aVar.f21000b;
    }
}
