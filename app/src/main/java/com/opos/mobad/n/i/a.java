package com.opos.mobad.n.i;

import android.view.View;
import com.opos.mobad.c.b.b;
import com.opos.mobad.n.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public abstract class a implements com.opos.mobad.n.a {

    /* renamed from: a */
    private int f22907a;

    /* renamed from: c */
    protected a.InterfaceC0458a f22909c;

    /* renamed from: d */
    private long f22910d;

    /* renamed from: e */
    private boolean f22911e = false;

    /* renamed from: b */
    protected C0468a f22908b = j();

    /* renamed from: com.opos.mobad.n.i.a$1 */
    class AnonymousClass1 implements Callable<Boolean> {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(a.this.g());
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$10 */
    class AnonymousClass10 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callable f22913a;

        /* renamed from: com.opos.mobad.n.i.a$10$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                if (interfaceC0458a != null) {
                    interfaceC0458a.e();
                }
                Callable callable = callable;
                if (callable != null) {
                    callable.call();
                }
                return Boolean.TRUE;
            }
        }

        AnonymousClass10(Callable callable) {
            callable = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f22908b.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.10.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.e();
                    }
                    Callable callable = callable;
                    if (callable != null) {
                        callable.call();
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$11 */
    class AnonymousClass11 implements Runnable {

        /* renamed from: com.opos.mobad.n.i.a$11$1 */
        class AnonymousClass1 implements Callable<Boolean> {

            /* renamed from: com.opos.mobad.n.i.a$11$1$1 */
            class RunnableC04671 implements Runnable {
                RunnableC04671() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.b();
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                b.a(new Runnable() { // from class: com.opos.mobad.n.i.a.11.1.1
                    RunnableC04671() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                        if (interfaceC0458a != null) {
                            interfaceC0458a.b();
                        }
                    }
                });
                return Boolean.TRUE;
            }
        }

        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f22908b.a() < 3) {
                a.this.f22908b.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.11.1

                    /* renamed from: com.opos.mobad.n.i.a$11$1$1 */
                    class RunnableC04671 implements Runnable {
                        RunnableC04671() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                            if (interfaceC0458a != null) {
                                interfaceC0458a.b();
                            }
                        }
                    }

                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        b.a(new Runnable() { // from class: com.opos.mobad.n.i.a.11.1.1
                            RunnableC04671() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                                if (interfaceC0458a != null) {
                                    interfaceC0458a.b();
                                }
                            }
                        });
                        return Boolean.TRUE;
                    }
                });
                return;
            }
            com.opos.cmn.an.f.a.b("TemplateState", "current state has showing ,no need to onShow = " + a.this.f22908b.a());
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$12 */
    class AnonymousClass12 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f22919a;

        /* renamed from: b */
        final /* synthetic */ int[] f22920b;

        AnonymousClass12(View view, int[] iArr) {
            view = view;
            iArr = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
            if (interfaceC0458a != null) {
                interfaceC0458a.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$13 */
    class AnonymousClass13 implements Callable<Boolean> {
        AnonymousClass13() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            a.this.h();
            a.this.f22909c = null;
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f22923a;

        /* renamed from: b */
        final /* synthetic */ String f22924b;

        /* renamed from: com.opos.mobad.n.i.a$2$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                if (interfaceC0458a != null) {
                    interfaceC0458a.a(i2, str);
                }
                return Boolean.TRUE;
            }
        }

        AnonymousClass2(int i2, String str) {
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f22908b.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.2.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.a(i2, str);
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f22927a;

        /* renamed from: b */
        final /* synthetic */ long f22928b;

        AnonymousClass3(long j2, long j3) {
            j3 = j2;
            j2 = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            long j2;
            int a2 = a.this.f22908b.a();
            if (a2 == 4 || a2 == 5) {
                if (a.this.f22911e) {
                    aVar = a.this;
                    j2 = j2;
                } else {
                    a.this.f22910d = j3;
                    a.this.f22911e = true;
                    aVar = a.this;
                    j2 = 0;
                }
                aVar.d(j2, aVar.f22910d);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f22930a;

        /* renamed from: b */
        final /* synthetic */ long f22931b;

        AnonymousClass4(long j2, long j3) {
            j2 = j2;
            j3 = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.InterfaceC0458a interfaceC0458a;
            if (a.this.o() == 8 || (interfaceC0458a = a.this.f22909c) == null) {
                return;
            }
            interfaceC0458a.d(j2, j3);
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            a.InterfaceC0458a interfaceC0458a = aVar.f22909c;
            if (interfaceC0458a != null) {
                interfaceC0458a.a(aVar.f22910d, a.this.f22910d);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$6 */
    class AnonymousClass6 implements Callable<Boolean> {
        AnonymousClass6() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(a.this.f());
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$7 */
    class AnonymousClass7 implements Callable<Boolean> {
        AnonymousClass7() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(a.this.g());
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$8 */
    class AnonymousClass8 implements Callable<Boolean> {
        AnonymousClass8() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(a.this.f());
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$9 */
    class AnonymousClass9 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f22937a;

        /* renamed from: com.opos.mobad.n.i.a$9$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                if (interfaceC0458a != null) {
                    interfaceC0458a.b(i2);
                }
                return Boolean.FALSE;
            }
        }

        AnonymousClass9(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f22908b.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.9.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.b(i2);
                    }
                    return Boolean.FALSE;
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.i.a$a */
    static class C0468a {

        /* renamed from: a */
        private Map<Integer, Set<Integer>> f22940a;

        /* renamed from: b */
        private AtomicInteger f22941b;

        /* renamed from: com.opos.mobad.n.i.a$a$a */
        public static class C0469a {

            /* renamed from: a */
            private int f22942a;

            /* renamed from: b */
            private Map<Integer, Set<Integer>> f22943b = new HashMap();

            public C0469a(int i2) {
                this.f22942a = i2;
            }

            public C0469a a(int i2, int i3) {
                Set<Integer> set = this.f22943b.get(Integer.valueOf(i2));
                if (set == null) {
                    set = new HashSet<>();
                    this.f22943b.put(Integer.valueOf(i2), set);
                }
                set.add(Integer.valueOf(i3));
                return this;
            }

            public C0469a a(int i2, int... iArr) {
                if (iArr != null) {
                    Set<Integer> set = this.f22943b.get(Integer.valueOf(i2));
                    if (set == null) {
                        set = new HashSet<>();
                        this.f22943b.put(Integer.valueOf(i2), set);
                    }
                    for (int i3 : iArr) {
                        set.add(Integer.valueOf(i3));
                    }
                }
                return this;
            }

            public C0468a a() {
                return new C0468a(this.f22942a, this.f22943b);
            }
        }

        protected C0468a(int i2, Map<Integer, Set<Integer>> map) {
            this.f22941b = new AtomicInteger(i2);
            a(map);
        }

        private int a(int i2, int i3, Callable<Boolean> callable) {
            try {
                if (!callable.call().booleanValue()) {
                    a("execute fail");
                    return i2;
                }
                if (!this.f22941b.compareAndSet(i2, i3)) {
                    a("unexpected fail");
                    b();
                }
                return i3;
            } catch (Exception e2) {
                a("call exception :" + e2);
                return i2;
            }
        }

        private static final void a(String str) {
            com.opos.cmn.an.f.a.b("TemplateStateController", str);
        }

        private void a(Map<Integer, Set<Integer>> map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            this.f22940a = new HashMap();
            for (Integer num : map.keySet()) {
                Set<Integer> set = map.get(num);
                if (set != null && !set.isEmpty()) {
                    this.f22940a.put(num, new HashSet(map.get(num)));
                }
            }
        }

        private boolean a(int i2, int i3) {
            String str;
            Map<Integer, Set<Integer>> map = this.f22940a;
            if (map == null) {
                str = "checkEnable but mController = null";
            } else if (!map.containsKey(Integer.valueOf(i2))) {
                str = "checkEnable but error current state:" + i2;
            } else {
                if (this.f22940a.get(Integer.valueOf(i2)).contains(Integer.valueOf(i3))) {
                    return true;
                }
                str = "checkEnable but error next state:" + i2 + ",to:" + i3;
            }
            a(str);
            return false;
        }

        private void b() {
        }

        public int a() {
            return this.f22941b.get();
        }

        public int a(int i2, Callable<Boolean> callable) {
            StringBuilder sb;
            String str;
            a("changeToStateBy:" + i2 + ", callable = " + callable + ", mCurrentState:" + this.f22941b.get());
            int i3 = this.f22941b.get();
            if (i3 == i2) {
                sb = new StringBuilder();
                str = "changeToStateBy but now target:";
            } else {
                if (a(i3, i2)) {
                    if (callable != null) {
                        return a(i3, i2, callable);
                    }
                    if (this.f22941b.compareAndSet(i3, i2)) {
                        return i2;
                    }
                    b();
                    return i2;
                }
                sb = new StringBuilder();
                str = "changeToStateBy but target is not enable:";
            }
            sb.append(str);
            sb.append(i2);
            a(sb.toString());
            return i3;
        }
    }

    public a(int i2) {
        this.f22907a = i2;
    }

    public void d(long j2, long j3) {
        b.a(new Runnable() { // from class: com.opos.mobad.n.i.a.4

            /* renamed from: a */
            final /* synthetic */ long f22930a;

            /* renamed from: b */
            final /* synthetic */ long f22931b;

            AnonymousClass4(long j22, long j32) {
                j2 = j22;
                j3 = j32;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.InterfaceC0458a interfaceC0458a;
                if (a.this.o() == 8 || (interfaceC0458a = a.this.f22909c) == null) {
                    return;
                }
                interfaceC0458a.d(j2, j3);
            }
        });
    }

    protected static final C0468a j() {
        return new C0468a.C0469a(0).a(0, 2, 1, 8).a(1, 8).a(2, 3, 8).a(3, 4, 5, 8).a(4, 7, 6, 1, 8).a(5, 7, 6, 1, 8).a(7, 4, 5, 8).a(6, 5, 8).a();
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        this.f22908b.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.6
            AnonymousClass6() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void a(int i2) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.9

            /* renamed from: a */
            final /* synthetic */ int f22937a;

            /* renamed from: com.opos.mobad.n.i.a$9$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.b(i2);
                    }
                    return Boolean.FALSE;
                }
            }

            AnonymousClass9(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f22908b.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.9.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                        if (interfaceC0458a != null) {
                            interfaceC0458a.b(i2);
                        }
                        return Boolean.FALSE;
                    }
                });
            }
        });
    }

    public void a(int i2, String str) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.2

            /* renamed from: a */
            final /* synthetic */ int f22923a;

            /* renamed from: b */
            final /* synthetic */ String f22924b;

            /* renamed from: com.opos.mobad.n.i.a$2$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.a(i2, str);
                    }
                    return Boolean.TRUE;
                }
            }

            AnonymousClass2(int i22, String str2) {
                i2 = i22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f22908b.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                        if (interfaceC0458a != null) {
                            interfaceC0458a.a(i2, str);
                        }
                        return Boolean.TRUE;
                    }
                });
            }
        });
    }

    public void a(long j2, long j3) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.c(j2, j3);
    }

    public void a(View view, int[] iArr) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.12

            /* renamed from: a */
            final /* synthetic */ View f22919a;

            /* renamed from: b */
            final /* synthetic */ int[] f22920b;

            AnonymousClass12(View view2, int[] iArr2) {
                view = view2;
                iArr = iArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                if (interfaceC0458a != null) {
                    interfaceC0458a.d(view, iArr);
                }
            }
        });
    }

    public void a(View view, int[] iArr, boolean z) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.a(view, iArr, z);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22909c = interfaceC0458a;
    }

    public void a(Callable callable) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.10

            /* renamed from: a */
            final /* synthetic */ Callable f22913a;

            /* renamed from: com.opos.mobad.n.i.a$10$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                    if (interfaceC0458a != null) {
                        interfaceC0458a.e();
                    }
                    Callable callable = callable;
                    if (callable != null) {
                        callable.call();
                    }
                    return Boolean.TRUE;
                }
            }

            AnonymousClass10(Callable callable2) {
                callable = callable2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f22908b.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.10.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        a.InterfaceC0458a interfaceC0458a = a.this.f22909c;
                        if (interfaceC0458a != null) {
                            interfaceC0458a.e();
                        }
                        Callable callable2 = callable;
                        if (callable2 != null) {
                            callable2.call();
                        }
                        return Boolean.TRUE;
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        this.f22908b.a(5, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.1
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    public void b(int i2) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.c(i2);
    }

    public void b(long j2, long j3) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.b(j2, j3);
    }

    public void b(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.c(view, iArr);
    }

    public void c(long j2, long j3) {
        com.opos.cmn.an.f.a.b("TemplateState", "onProgress = " + j2 + "," + j3 + "," + this.f22908b.a());
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.3

            /* renamed from: a */
            final /* synthetic */ long f22927a;

            /* renamed from: b */
            final /* synthetic */ long f22928b;

            AnonymousClass3(long j32, long j22) {
                j3 = j32;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                long j22;
                int a2 = a.this.f22908b.a();
                if (a2 == 4 || a2 == 5) {
                    if (a.this.f22911e) {
                        aVar = a.this;
                        j22 = j2;
                    } else {
                        a.this.f22910d = j3;
                        a.this.f22911e = true;
                        aVar = a.this;
                        j22 = 0;
                    }
                    aVar.d(j22, aVar.f22910d);
                }
            }
        });
    }

    public void c(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.b(view, iArr);
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.f22908b.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.13
            AnonymousClass13() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                a.this.h();
                a.this.f22909c = null;
                return Boolean.TRUE;
            }
        });
    }

    public void d(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.f(view, iArr);
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22907a;
    }

    public void e(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.g(view, iArr);
    }

    public void f(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.e(view, iArr);
    }

    protected abstract boolean f();

    public void g(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.h(view, iArr);
    }

    protected abstract boolean g();

    protected abstract void h();

    public void h(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.a(view, iArr);
    }

    public void i(View view, int[] iArr) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.f22908b.a() == 8 || (interfaceC0458a = this.f22909c) == null) {
            return;
        }
        interfaceC0458a.i(view, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.f22908b.a(4, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.7
            AnonymousClass7() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.f22908b.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.8
            AnonymousClass8() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void m() {
        a((Callable) null);
    }

    public void n() {
        b.b(new AnonymousClass11());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int o() {
        return this.f22908b.a();
    }

    public void p() {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                a.InterfaceC0458a interfaceC0458a = aVar.f22909c;
                if (interfaceC0458a != null) {
                    interfaceC0458a.a(aVar.f22910d, a.this.f22910d);
                }
            }
        });
    }
}
