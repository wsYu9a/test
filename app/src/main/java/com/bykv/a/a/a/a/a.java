package com.bykv.a.a.a.a;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    private boolean f7408a = false;

    /* renamed from: b */
    private int f7409b = -1;

    /* renamed from: c */
    private String f7410c = null;

    /* renamed from: d */
    private ValueSet f7411d = null;

    /* renamed from: com.bykv.a.a.a.a.a$a */
    public static final class C0223a implements Result {

        /* renamed from: a */
        private final boolean f7412a;

        /* renamed from: b */
        private final int f7413b;

        /* renamed from: c */
        private final String f7414c;

        /* renamed from: d */
        private final ValueSet f7415d;

        public /* synthetic */ C0223a(boolean z10, int i10, String str, ValueSet valueSet, AnonymousClass1 anonymousClass1) {
            this(z10, i10, str, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f7413b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f7412a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f7414c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f7415d;
        }

        private C0223a(boolean z10, int i10, String str, ValueSet valueSet) {
            this.f7412a = z10;
            this.f7413b = i10;
            this.f7414c = str;
            this.f7415d = valueSet;
        }
    }

    private a() {
    }

    public static final a a() {
        return new a();
    }

    public Result b() {
        boolean z10 = this.f7408a;
        int i10 = this.f7409b;
        String str = this.f7410c;
        ValueSet valueSet = this.f7411d;
        if (valueSet == null) {
            valueSet = b.a().b();
        }
        return new C0223a(z10, i10, str, valueSet);
    }

    public a a(boolean z10) {
        this.f7408a = z10;
        return this;
    }

    public a a(int i10) {
        this.f7409b = i10;
        return this;
    }

    public a a(String str) {
        this.f7410c = str;
        return this;
    }

    public a a(ValueSet valueSet) {
        this.f7411d = valueSet;
        return this;
    }
}
