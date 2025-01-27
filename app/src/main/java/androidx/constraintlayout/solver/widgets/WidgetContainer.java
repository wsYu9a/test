package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> L0;

    public WidgetContainer() {
        this.L0 = new ArrayList<>();
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int size = arrayList.size();
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = arrayList.get(i6);
            if (constraintWidget.getX() < i2) {
                i2 = constraintWidget.getX();
            }
            if (constraintWidget.getY() < i3) {
                i3 = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > i4) {
                i4 = constraintWidget.getRight();
            }
            if (constraintWidget.getBottom() > i5) {
                i5 = constraintWidget.getBottom();
            }
        }
        rectangle.setBounds(i2, i3, i4 - i2, i5 - i3);
        return rectangle;
    }

    public void add(ConstraintWidget constraintWidget) {
        this.L0.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    public ConstraintWidget findWidget(float f2, float f3) {
        int i2;
        WidgetContainer widgetContainer;
        int drawX = getDrawX();
        int drawY = getDrawY();
        WidgetContainer widgetContainer2 = (f2 < ((float) drawX) || f2 > ((float) (getWidth() + drawX)) || f3 < ((float) drawY) || f3 > ((float) (getHeight() + drawY))) ? null : this;
        int size = this.L0.size();
        while (i2 < size) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            if (constraintWidget instanceof WidgetContainer) {
                ?? findWidget = ((WidgetContainer) constraintWidget).findWidget(f2, f3);
                widgetContainer = findWidget;
                i2 = findWidget == 0 ? i2 + 1 : 0;
                widgetContainer2 = widgetContainer;
            } else {
                int drawX2 = constraintWidget.getDrawX();
                int drawY2 = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX2;
                int height = constraintWidget.getHeight() + drawY2;
                if (f2 >= drawX2 && f2 <= width && f3 >= drawY2) {
                    widgetContainer = constraintWidget;
                    if (f3 > height) {
                    }
                    widgetContainer2 = widgetContainer;
                }
            }
        }
        return widgetContainer2;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i2, int i3, int i4, int i5) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(i2, i3, i4, i5);
        int size = this.L0.size();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.L0.get(i6);
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            if (rectangle.b(rectangle2)) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.L0;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget parent = getParent();
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.L0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.L0.remove(constraintWidget);
        constraintWidget.setParent(null);
    }

    public void removeAllChildren() {
        this.L0.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.L0.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.L0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.L0.get(i2).resetSolverVariables(cache);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int i2, int i3) {
        super.setOffset(i2, i3);
        int size = this.L0.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.L0.get(i4).setOffset(f(), g());
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateDrawPosition() {
        super.updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.L0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            constraintWidget.setOffset(getDrawX(), getDrawY());
            if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                constraintWidget.updateDrawPosition();
            }
        }
    }

    public WidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        this.L0 = new ArrayList<>();
    }

    public WidgetContainer(int i2, int i3) {
        super(i2, i3);
        this.L0 = new ArrayList<>();
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }
}
