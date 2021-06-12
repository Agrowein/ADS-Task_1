package task2.var1;

import task2.var1.util.ArrayUtils;
import task2.var1.util.JTableUtils;
import task2.var1.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JPanel btnPanel;
    private JButton executeBtn;
    private JButton readFromFileBtn;
    private JButton saveToFileBtn;
    private JTable table;
    private JLabel label;
    private JLabel count;

    private LinkedList<Integer> list;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public MainForm() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTableUtils.initJTableForArray(table, 25, false, false, true, true);
        pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        //обработчик нажатия на кнопку открыть
        readFromFileBtn.addActionListener(e -> {
            try {
                if (fileChooserSave.showSaveDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
                    int[] sequence = ArrayUtils.readIntArrayFromFile(fileChooserSave.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(table, sequence);
                    list = new LinkedList<>();
                    for (int i : sequence) {
                        list.addLast(i);
                    }
                }
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });

        //обработчик нажатия на кнопку сохранить
        saveToFileBtn.addActionListener(e -> {
            try {
                if (fileChooserSave.showSaveDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
                    int[] out = JTableUtils.readIntArrayFromJTable(table);
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ArrayUtils.writeArrayToFile(file, out);
                }
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
        //обработчик нажатия на кнопку выполнить
        executeBtn.addActionListener(e -> {
            try {
                if (list == null) return;
                int count = Main.countMinElements(list);
                this.count.setText(String.valueOf(count));

            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });

        setSize(new Dimension(900, 600));
        setResizable(false);
        setVisible(true);
    }
}
