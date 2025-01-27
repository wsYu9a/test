package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.Pools;

/* loaded from: classes.dex */
public class Cache {

    /* renamed from: a */
    Pools.Pool<ArrayRow> f1194a = new Pools.SimplePool(256);

    /* renamed from: b */
    Pools.Pool<SolverVariable> f1195b = new Pools.SimplePool(256);

    /* renamed from: c */
    SolverVariable[] f1196c = new SolverVariable[32];
}
