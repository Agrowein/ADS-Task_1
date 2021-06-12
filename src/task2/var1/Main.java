package task2.var1;

public class Main {
    public static void main(String[] args) throws Exception {
        MainForm window = new MainForm();
        window.setVisible(true);
    }

    //метод нахождения числа минимальных элементов списка на нечетных позициях
    public static int countMinElements(LinkedList<Integer> list) throws Exception {
        int min = list.getFirst();
        int count = 0;
        for (int i = 0; i < list.getCount(); i += 2) {
            int el = list.get(i);
            if (el == min) count++;
            if (el < min) {
                min = el;
                i = 0;
                count = 1;
            }

        }
        return count;
    }
}
