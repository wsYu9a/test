package com.google.common.util.concurrent;

import b5.u;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import e5.z1;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p5.c0;
import p5.l0;

@a5.b
@p5.m
/* loaded from: classes2.dex */
public abstract class AggregateFuture<InputT, OutputT> extends g<OutputT> {

    /* renamed from: i */
    public static final Logger f10266i = Logger.getLogger(AggregateFuture.class.getName());

    /* renamed from: f */
    @CheckForNull
    public ImmutableCollection<? extends c0<? extends InputT>> f10267f;

    /* renamed from: g */
    public final boolean f10268g;

    /* renamed from: h */
    public final boolean f10269h;

    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public AggregateFuture(ImmutableCollection<? extends c0<? extends InputT>> immutableCollection, boolean z10, boolean z11) {
        super(immutableCollection.size());
        this.f10267f = (ImmutableCollection) u.E(immutableCollection);
        this.f10268g = z10;
        this.f10269h = z11;
    }

    public static void F(Throwable th2) {
        f10266i.log(Level.SEVERE, th2 instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th2);
    }

    public static boolean w(Set<Throwable> set, Throwable th2) {
        while (th2 != null) {
            if (!set.add(th2)) {
                return false;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    public abstract void A();

    public final void B(Throwable th2) {
        u.E(th2);
        if (this.f10268g && !setException(th2) && w(t(), th2)) {
            F(th2);
        } else if (th2 instanceof Error) {
            F(th2);
        }
    }

    public final void C() {
        Objects.requireNonNull(this.f10267f);
        if (this.f10267f.isEmpty()) {
            A();
            return;
        }
        if (!this.f10268g) {
            p5.d dVar = new Runnable() { // from class: p5.d

                /* renamed from: c */
                public final /* synthetic */ ImmutableCollection f29790c;

                public /* synthetic */ d(ImmutableCollection immutableCollection) {
                    immutableCollection = immutableCollection;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AggregateFuture.this.E(immutableCollection);
                }
            };
            z1<? extends c0<? extends InputT>> it = this.f10267f.iterator();
            while (it.hasNext()) {
                it.next().addListener(dVar, p.c());
            }
            return;
        }
        z1<? extends c0<? extends InputT>> it2 = this.f10267f.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            c0<? extends InputT> next = it2.next();
            next.addListener(new Runnable() { // from class: p5.c

                /* renamed from: c */
                public final /* synthetic */ c0 f29786c;

                /* renamed from: d */
                public final /* synthetic */ int f29787d;

                public /* synthetic */ c(c0 next2, int i102) {
                    next = next2;
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AggregateFuture.this.D(next, i10);
                }
            }, p.c());
            i102++;
        }
    }

    public final /* synthetic */ void D(c0 c0Var, int i10) {
        try {
            if (c0Var.isCancelled()) {
                this.f10267f = null;
                cancel(false);
            } else {
                y(i10, c0Var);
            }
            E(null);
        } catch (Throwable th2) {
            E(null);
            throw th2;
        }
    }

    public final void G(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            z1<? extends Future<? extends InputT>> it = immutableCollection.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Future<? extends InputT> next = it.next();
                if (!next.isCancelled()) {
                    y(i10, next);
                }
                i10++;
            }
        }
        r();
        A();
        H(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    @ForOverride
    @OverridingMethodsMustInvokeSuper
    public void H(ReleaseResourcesReason releaseResourcesReason) {
        u.E(releaseResourcesReason);
        this.f10267f = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends c0<? extends InputT>> immutableCollection = this.f10267f;
        H(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean wasInterrupted = wasInterrupted();
            z1<? extends c0<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                it.next().cancel(wasInterrupted);
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public final String pendingToString() {
        ImmutableCollection<? extends c0<? extends InputT>> immutableCollection = this.f10267f;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(immutableCollection);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
        sb2.append("futures=");
        sb2.append(valueOf);
        return sb2.toString();
    }

    @Override // com.google.common.util.concurrent.g
    public final void q(Set<Throwable> set) {
        u.E(set);
        if (isCancelled()) {
            return;
        }
        Throwable tryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
        Objects.requireNonNull(tryInternalFastPathGetFailure);
        w(set, tryInternalFastPathGetFailure);
    }

    public abstract void x(int i10, @l0 InputT inputt);

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(int i10, Future<? extends InputT> future) {
        try {
            x(i10, l.h(future));
        } catch (ExecutionException e10) {
            B(e10.getCause());
        } catch (Throwable th2) {
            B(th2);
        }
    }

    /* renamed from: z */
    public final void E(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        int s10 = s();
        u.h0(s10 >= 0, "Less than 0 remaining futures");
        if (s10 == 0) {
            G(immutableCollection);
        }
    }
}
