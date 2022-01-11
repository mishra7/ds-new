import java.util.Stack;

public class MaxAreaOfRectrangle {

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 6, 2, 3};
        System.out.println(maxRectangle(a));
    }


    public static int maxRectangle(int a[]) {
        int max = Integer.MIN_VALUE;
        int size;

        if (null != a) {
            size = a.length;
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> stackIndex = new Stack<>();
            int l, r;
            stackIndex.push(-1);
            for (int i = 0; i < size; i++) {

                if (stack.isEmpty()) {
                    stack.push(a[i]);
                    stackIndex.push(i);
                } else if (stack.peek() >= a[i]) {
                    r = i;
                    while (!stack.isEmpty() && stack.peek() >= a[i]) {
                        int c = stack.pop();
                        stackIndex.pop();
                        l = stackIndex.peek();
                        max = Math.max(max, (r - l - 1) * c);
                    }
                    stack.push(a[i]);
                    stackIndex.push(i);
                } else {
                    stack.push(a[i]);
                    stackIndex.push(i);
                }
            }
            System.out.println(stack);
            System.out.println(stackIndex);
            r = stackIndex.peek() + 1;
            while (!stack.isEmpty()) {
                int c = stack.pop();
                stackIndex.pop();
                l = stackIndex.peek();
                max = Math.max(max, (r - l - 1) * c);
            }


        }
        return max;
    }
}
