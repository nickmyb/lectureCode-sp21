public class IntNList {
    public int first;
    public IntNList rest;

    public IntNList(int f, IntNList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }

    public int iterativeSize() {
        IntNList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.rest;
        }
        return size;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);

        /*
        // iterate
        IntNList p = this;
        while (i > 0) {
            p = p.rest;
        }
        return p.first;
         */
    }

    public static void main(String[] args) {
        IntNList L = new IntNList(15, null);
        L = new IntNList(10, L);
        L = new IntNList(5, L);

        System.out.println(L.size());
        System.out.println(L.get(1));
    }
} 