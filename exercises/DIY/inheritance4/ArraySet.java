import java.util.Iterator;
import java.lang.Iterable;

public class ArraySet<T> implements Iterable<T> {
    private class ArraySetIterator implements Iterator<T> {
        private int pos;

        // private class 可以实现 public method
        public ArraySetIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T r = items[pos];
            pos += 1;
            return r;
        }
    }

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("null not allowed");
        }

        if (!contains(x)) {
            items[size] = x;
            size += 1;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (T item: this) {
            sb.append(item.toString());
            sb.append(", ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());

        }
        sb.append("}");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o.getClass() != ArraySet.class) {
            return false;
        }

        ArraySet<T> so = (ArraySet<T>) o;

        if (so.size != this.size) {
            return false;
        }

        for (T item: this) {
            if (!so.contains(item)) {
                return false;
            }
        }

        return true;
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> s = new ArraySet<>();
        for (Glerp x: stuff) {
            s.add(x);
        }
        return s;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());

        /**
        Iterator iter = s.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
         */

        for (String str: s) {
            System.out.println(str);
        }

        System.out.println(s);

        ArraySet<String> s2 = new ArraySet<>();
        s2.add("house");
        s2.add("horse");
        s2.add("fish");

        System.out.println(s.equals(null));
        System.out.println(s.equals("fish"));
        System.out.println(s.equals(s2));

        ArraySet<String> sof = ArraySet.of("hi", "nickmyb");
        System.out.println(sof);
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
