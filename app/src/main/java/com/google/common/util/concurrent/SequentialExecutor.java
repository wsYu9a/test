package com.google.common.util.concurrent;

import b5.u;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.RetainedWith;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public final class SequentialExecutor implements Executor {

    /* renamed from: g */
    public static final Logger f10355g = Logger.getLogger(SequentialExecutor.class.getName());

    /* renamed from: b */
    public final Executor f10356b;

    /* renamed from: c */
    @GuardedBy("queue")
    public final Deque<Runnable> f10357c = new ArrayDeque();

    /* renamed from: d */
    @GuardedBy("queue")
    public WorkerRunningState f10358d = WorkerRunningState.IDLE;

    /* renamed from: e */
    @GuardedBy("queue")
    public long f10359e = 0;

    /* renamed from: f */
    @RetainedWith
    public final b f10360f = new b(this, null);

    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Runnable f10361b;

        public a(SequentialExecutor sequentialExecutor, Runnable runnable) {
            this.f10361b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10361b.run();
        }

        public String toString() {
            return this.f10361b.toString();
        }
    }

    public final class b implements Runnable {

        /* renamed from: b */
        @CheckForNull
        public Runnable f10362b;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0054, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
        
            r9.f10362b.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
        
            r9.f10362b = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x008c, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        
            r4 = com.google.common.util.concurrent.SequentialExecutor.f10355g;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r9.f10362b);
            r8 = new java.lang.StringBuilder(r6.length() + 35);
            r8.append("Exception while executing runnable ");
            r8.append(r6);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
            L2:
                com.google.common.util.concurrent.SequentialExecutor r2 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L5e
                java.util.Deque r2 = com.google.common.util.concurrent.SequentialExecutor.a(r2)     // Catch: java.lang.Throwable -> L5e
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L5e
                if (r0 != 0) goto L2d
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = com.google.common.util.concurrent.SequentialExecutor.b(r0)     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L20
                if (r0 != r3) goto L22
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                r0 = move-exception
                goto L8d
            L22:
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor.d(r0)     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor.c(r0, r3)     // Catch: java.lang.Throwable -> L20
                r0 = 1
            L2d:
                com.google.common.util.concurrent.SequentialExecutor r3 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                java.util.Deque r3 = com.google.common.util.concurrent.SequentialExecutor.a(r3)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L20
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L20
                r9.f10362b = r3     // Catch: java.lang.Throwable -> L20
                if (r3 != 0) goto L4f
                com.google.common.util.concurrent.SequentialExecutor r0 = com.google.common.util.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L20
                com.google.common.util.concurrent.SequentialExecutor.c(r0, r3)     // Catch: java.lang.Throwable -> L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L4e
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4e:
                return
            L4f:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L5e
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r9.f10362b     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
                r3.run()     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
            L5b:
                r9.f10362b = r2     // Catch: java.lang.Throwable -> L5e
                goto L2
            L5e:
                r0 = move-exception
                goto L8f
            L60:
                r0 = move-exception
                goto L8a
            L62:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.SequentialExecutor.e()     // Catch: java.lang.Throwable -> L60
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L60
                java.lang.Runnable r6 = r9.f10362b     // Catch: java.lang.Throwable -> L60
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L60
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L60
                int r7 = r7 + 35
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
                r8.<init>(r7)     // Catch: java.lang.Throwable -> L60
                java.lang.String r7 = "Exception while executing runnable "
                r8.append(r7)     // Catch: java.lang.Throwable -> L60
                r8.append(r6)     // Catch: java.lang.Throwable -> L60
                java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L60
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L60
                goto L5b
            L8a:
                r9.f10362b = r2     // Catch: java.lang.Throwable -> L5e
                throw r0     // Catch: java.lang.Throwable -> L5e
            L8d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                throw r0     // Catch: java.lang.Throwable -> L5e
            L8f:
                if (r1 == 0) goto L98
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L98:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (SequentialExecutor.this.f10357c) {
                    SequentialExecutor.this.f10358d = WorkerRunningState.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f10362b;
            if (runnable != null) {
                String valueOf = String.valueOf(runnable);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                sb2.append("SequentialExecutorWorker{running=");
                sb2.append(valueOf);
                sb2.append(p3.f.f29748d);
                return sb2.toString();
            }
            String valueOf2 = String.valueOf(SequentialExecutor.this.f10358d);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 32);
            sb3.append("SequentialExecutorWorker{state=");
            sb3.append(valueOf2);
            sb3.append(p3.f.f29748d);
            return sb3.toString();
        }

        public /* synthetic */ b(SequentialExecutor sequentialExecutor, a aVar) {
            this();
        }
    }

    public SequentialExecutor(Executor executor) {
        this.f10356b = (Executor) u.E(executor);
    }

    public static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        long j10 = sequentialExecutor.f10359e;
        sequentialExecutor.f10359e = 1 + j10;
        return j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0066 A[ADDED_TO_REGION] */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execute(java.lang.Runnable r8) {
        /*
            r7 = this;
            b5.u.E(r8)
            java.util.Deque<java.lang.Runnable> r0 = r7.f10357c
            monitor-enter(r0)
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = r7.f10358d     // Catch: java.lang.Throwable -> L6d
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L6d
            if (r1 == r2) goto L6f
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUED     // Catch: java.lang.Throwable -> L6d
            if (r1 != r2) goto L11
            goto L6f
        L11:
            long r3 = r7.f10359e     // Catch: java.lang.Throwable -> L6d
            com.google.common.util.concurrent.SequentialExecutor$a r1 = new com.google.common.util.concurrent.SequentialExecutor$a     // Catch: java.lang.Throwable -> L6d
            r1.<init>(r7, r8)     // Catch: java.lang.Throwable -> L6d
            java.util.Deque<java.lang.Runnable> r8 = r7.f10357c     // Catch: java.lang.Throwable -> L6d
            r8.add(r1)     // Catch: java.lang.Throwable -> L6d
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r8 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L6d
            r7.f10358d = r8     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.Executor r0 = r7.f10356b     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            com.google.common.util.concurrent.SequentialExecutor$b r5 = r7.f10360f     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            r0.execute(r5)     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = r7.f10358d
            if (r0 == r8) goto L2e
            return
        L2e:
            java.util.Deque<java.lang.Runnable> r0 = r7.f10357c
            monitor-enter(r0)
            long r5 = r7.f10359e     // Catch: java.lang.Throwable -> L3e
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L40
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r1 = r7.f10358d     // Catch: java.lang.Throwable -> L3e
            if (r1 != r8) goto L40
            r7.f10358d = r2     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r8 = move-exception
            goto L42
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r8
        L44:
            r8 = move-exception
            goto L47
        L46:
            r8 = move-exception
        L47:
            java.util.Deque<java.lang.Runnable> r2 = r7.f10357c
            monitor-enter(r2)
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r0 = r7.f10358d     // Catch: java.lang.Throwable -> L55
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L55
            if (r0 == r3) goto L57
            com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L55
            if (r0 != r3) goto L61
            goto L57
        L55:
            r8 = move-exception
            goto L6b
        L57:
            java.util.Deque<java.lang.Runnable> r0 = r7.f10357c     // Catch: java.lang.Throwable -> L55
            boolean r0 = r0.removeLastOccurrence(r1)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L61
            r0 = 1
            goto L62
        L61:
            r0 = 0
        L62:
            boolean r1 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L6a
            if (r0 != 0) goto L6a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            return
        L6a:
            throw r8     // Catch: java.lang.Throwable -> L55
        L6b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            throw r8
        L6d:
            r8 = move-exception
            goto L76
        L6f:
            java.util.Deque<java.lang.Runnable> r1 = r7.f10357c     // Catch: java.lang.Throwable -> L6d
            r1.add(r8)     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            return
        L76:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SequentialExecutor.execute(java.lang.Runnable):void");
    }

    public String toString() {
        int identityHashCode = System.identityHashCode(this);
        String valueOf = String.valueOf(this.f10356b);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
        sb2.append("SequentialExecutor@");
        sb2.append(identityHashCode);
        sb2.append("{");
        sb2.append(valueOf);
        sb2.append(p3.f.f29748d);
        return sb2.toString();
    }
}
