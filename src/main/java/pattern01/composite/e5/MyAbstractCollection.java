package pattern01.composite.e5;

public abstract class MyAbstractCollection implements MyCollection {

    @Override
    public void addAll(MyCollection col) {
        MyIterator it = col.getIterator();
        while (!it.isEnd())
            add(it.getNext());
    }

    @Override
    public MyCollection clone() throws CloneNotSupportedException {
        MyCollection col = null;
        try {
            col = this.getClass().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new CloneNotSupportedException();
        }
        col.addAll(this);
        return col;
    }

    @Override
    public int hashValue() {
        int result = getClass().hashCode();
        MyIterator it = getIterator();
        while (!it.isEnd()) {
            MyObject value = it.getNext();
            if (value != null)
                result = (31 * result + value.hashValue()) & 0xFFFFFF;
        }
        return result;
    }

    @Override
    public boolean equals(MyObject obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MyCollection col = (MyCollection)obj;
        MyIterator it1 = this.getIterator();
        MyIterator it2 = col.getIterator();
        while (!it1.isEnd() && !it2.isEnd()) {
            MyObject o1 = it1.getNext();
            MyObject o2 = it2.getNext();
            if (o1 == o2) continue;
            if (o1 != null && o1.equals(o2)==false) return false;
        }
        return it1.isEnd() && it2.isEnd();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append("( ");
        MyIterator it = getIterator();
        while (!it.isEnd()) {
            MyObject value = it.getNext();
            builder.append(value).append(' ');
        }
        builder.append(')');
        return builder.toString();
    }
}
