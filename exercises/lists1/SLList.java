public class SLList {
    // static: NEVER LOOKS OUTWARDS
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(int x) {
        IntNode p = sentinel;

        // 空列表报错引入sentinel
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    /**
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }
    */

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.size());
    }
}
