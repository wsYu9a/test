package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Snapshot {

    /* renamed from: a */
    private int f1288a;

    /* renamed from: b */
    private int f1289b;

    /* renamed from: c */
    private int f1290c;

    /* renamed from: d */
    private int f1291d;

    /* renamed from: e */
    private ArrayList<Connection> f1292e = new ArrayList<>();

    static class Connection {

        /* renamed from: a */
        private ConstraintAnchor f1293a;

        /* renamed from: b */
        private ConstraintAnchor f1294b;

        /* renamed from: c */
        private int f1295c;

        /* renamed from: d */
        private ConstraintAnchor.Strength f1296d;

        /* renamed from: e */
        private int f1297e;

        public Connection(ConstraintAnchor constraintAnchor) {
            this.f1293a = constraintAnchor;
            this.f1294b = constraintAnchor.getTarget();
            this.f1295c = constraintAnchor.getMargin();
            this.f1296d = constraintAnchor.getStrength();
            this.f1297e = constraintAnchor.getConnectionCreator();
        }

        public void applyTo(ConstraintWidget constraintWidget) {
            constraintWidget.getAnchor(this.f1293a.getType()).connect(this.f1294b, this.f1295c, this.f1296d, this.f1297e);
        }

        public void updateFrom(ConstraintWidget constraintWidget) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(this.f1293a.getType());
            this.f1293a = anchor;
            if (anchor != null) {
                this.f1294b = anchor.getTarget();
                this.f1295c = this.f1293a.getMargin();
                this.f1296d = this.f1293a.getStrength();
                this.f1297e = this.f1293a.getConnectionCreator();
                return;
            }
            this.f1294b = null;
            this.f1295c = 0;
            this.f1296d = ConstraintAnchor.Strength.STRONG;
            this.f1297e = 0;
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        this.f1288a = constraintWidget.getX();
        this.f1289b = constraintWidget.getY();
        this.f1290c = constraintWidget.getWidth();
        this.f1291d = constraintWidget.getHeight();
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1292e.add(new Connection(anchors.get(i2)));
        }
    }

    public void applyTo(ConstraintWidget constraintWidget) {
        constraintWidget.setX(this.f1288a);
        constraintWidget.setY(this.f1289b);
        constraintWidget.setWidth(this.f1290c);
        constraintWidget.setHeight(this.f1291d);
        int size = this.f1292e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1292e.get(i2).applyTo(constraintWidget);
        }
    }

    public void updateFrom(ConstraintWidget constraintWidget) {
        this.f1288a = constraintWidget.getX();
        this.f1289b = constraintWidget.getY();
        this.f1290c = constraintWidget.getWidth();
        this.f1291d = constraintWidget.getHeight();
        int size = this.f1292e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1292e.get(i2).updateFrom(constraintWidget);
        }
    }
}
