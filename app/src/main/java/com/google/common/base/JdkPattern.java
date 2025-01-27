package com.google.common.base;

import b5.d;
import b5.e;
import b5.g;
import b5.u;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@g
@a5.c
/* loaded from: classes2.dex */
final class JdkPattern extends e implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    public static final class a extends d {

        /* renamed from: a */
        public final Matcher f9110a;

        public a(Matcher matcher) {
            this.f9110a = (Matcher) u.E(matcher);
        }

        @Override // b5.d
        public int a() {
            return this.f9110a.end();
        }

        @Override // b5.d
        public boolean b() {
            return this.f9110a.find();
        }

        @Override // b5.d
        public boolean c(int i10) {
            return this.f9110a.find(i10);
        }

        @Override // b5.d
        public boolean d() {
            return this.f9110a.matches();
        }

        @Override // b5.d
        public String e(String str) {
            return this.f9110a.replaceAll(str);
        }

        @Override // b5.d
        public int f() {
            return this.f9110a.start();
        }
    }

    public JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) u.E(pattern);
    }

    @Override // b5.e
    public int flags() {
        return this.pattern.flags();
    }

    @Override // b5.e
    public d matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // b5.e
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // b5.e
    public String toString() {
        return this.pattern.toString();
    }
}
