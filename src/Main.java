public class Main{
    public static void main(String[] args) {
        String firstText = "Капучино - кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого насыщенного кислородом молока.";
        Paragraph p = new Paragraph(3, 2, 2, firstText);
        System.out.println(p.printText());
    }
}

abstract class Style {
    public final int maxLineWidth = 50;
    private final int leftOffset;
    private final int upOffset;

    public Style(int leftOffset, int upOffset) {
        this.leftOffset = leftOffset;
        this.upOffset = upOffset;
    }

    public abstract String printText();
    public abstract String formatText();

    public int getLeftOffset() {
        return leftOffset;
    }

    public int getUpOffset() {
        return upOffset;
    }
}

class Paragraph extends Style {
    private int number;
    private String text;

    public Paragraph(int leftOffset, int upOffset, String text) {
        super(leftOffset, upOffset);
        this.text = text;
    }

    public Paragraph(int leftOffset, int upOffset, int number, String text) {
        super(leftOffset, upOffset);
        this.number = number;
        this.text = text;
    }

    @Override
    public String printText() {
        StringBuilder str = new StringBuilder();
        for (int i = this.getUpOffset(); i > 0; i--) {
            str.append("\n");
        }
        for (int i = this.getLeftOffset(); i > 0; i--) {
            str.append(" ");
        }
        if (number != 0) {
            str.append(number).append("  ");
        }
        str.append(formatText());
        return str.substring(0);
    }

    @Override
    public String formatText() {
        StringBuilder str = new StringBuilder();
        char[] txt = text.toCharArray();
        int counter = 0;
        for (char c: txt) {
            if (counter > maxLineWidth) {
                counter = 0;
                str.append('\n');
                for (int j = getLeftOffset(); j > 0; j--) {
                    str.append(' ');
                }
            }
            str.append(c);
            counter++;
        }
        return str.substring(0);
    }
}