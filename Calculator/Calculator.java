package hesapMakinesiGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.SystemColor;

public class Calculator extends JFrame {

    private JPanel contentPane;
    private JTextField inputPanel;
    private JTextField operationsPanel;
    private double answer, previousNum, memory;
    private int operation=-1;
    private boolean isCalculated = false;
    private boolean changeOperation = false;

    private DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("us", "US"));
    private DecimalFormat df = new DecimalFormat("#.###", symbols);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculator frame = new Calculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void addInput (String str ) {
        if ( isCalculated ) {
            inputPanel.setText("");
            isCalculated = false;
        }
        inputPanel.setText( inputPanel.getText() + str );
    }

    public void calculate() {

        String inputText = inputPanel.getText();
        if (inputText.isEmpty()) {
            return;
        }

        if( !isCalculated ) {
            try {
                double inputNumber = Double.parseDouble(inputText);

                switch (operation) {
                    case 1:
                        answer = previousNum + inputNumber;
                        break;
                    case 2:
                        answer = previousNum - inputNumber;
                        break;
                    case 3:
                        answer = previousNum * inputNumber;
                        break;
                    case 4:
                        if (inputNumber != 0) {
                            answer = previousNum / inputNumber;
                        } else {
                            JOptionPane.showMessageDialog(this, "A number cannot be divided by zero!");
                            return;
                        }
                        break;
                    case 5:
                        answer = previousNum % inputNumber;
                        break;
                    case 6:
                        answer = Math.pow(previousNum, inputNumber);
                        break;
                    case 7:
                        if ( inputNumber >=0 ) {
                            answer = Math.sqrt(inputNumber);
                        } else{
                            JOptionPane.showMessageDialog(this, "Undefined expression!");
                            return;
                        }
                        break;

                }

                operationsPanel.setText(operationsPanel.getText() + df.format(inputNumber) + "=");
                inputPanel.setText(df.format(answer));
                isCalculated = true;
                changeOperation = false;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Unvalid values!");
            }
        }

    }

    public double getPreviousNum( String text ) {
        double num = Double.parseDouble( text );

        return num;
    }


    public Calculator() {
        setType(Type.POPUP);
        setTitle("Calculator - github.com/emirsansar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 599);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(14, 24, 38));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel screen = new JPanel();
        screen.setBackground(new Color(121, 113, 122));
        screen.setBounds(10, 11, 465, 76);
        contentPane.add(screen);
        screen.setLayout(null);

        inputPanel = new JTextField();
        inputPanel.setForeground(Color.BLACK);
        inputPanel.setBackground(new Color(121, 113, 122));
        inputPanel.setEditable(false);
        inputPanel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputPanel.setFont(new Font("Tahoma", Font.BOLD, 25));
        inputPanel.setBounds(0, 26, 465, 50);
        screen.add(inputPanel);
        inputPanel.setColumns(10);
        inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        operationsPanel = new JTextField();
        operationsPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
        operationsPanel.setBackground(new Color(121, 113, 122));
        operationsPanel.setHorizontalAlignment(SwingConstants.RIGHT);
        operationsPanel.setEditable(false);
        operationsPanel.setBounds(307, 2, 158, 28);
        screen.add(operationsPanel);
        operationsPanel.setColumns(10);
        operationsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JPanel numbersPanel = new JPanel();
        numbersPanel.setForeground(SystemColor.text);
        numbersPanel.setBackground(new Color(14, 24, 38));
        numbersPanel.setBounds(10, 188, 277, 348);
        contentPane.add(numbersPanel);
        numbersPanel.setLayout(new GridLayout(0, 3, 20, 20));

        JButton btnNum_7 = new JButton("7");
        btnNum_7.setForeground(SystemColor.text);
        btnNum_7.setBackground(new Color(121, 113, 122));
        btnNum_7.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnNum_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        numbersPanel.add(btnNum_7);

        JButton btnNum_8 = new JButton("8");
        btnNum_8.setForeground(SystemColor.text);
        btnNum_8.setBackground(new Color(121, 113, 122));
        btnNum_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_8.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_8);

        JButton btnNum_9 = new JButton("9");
        btnNum_9.setForeground(SystemColor.text);
        btnNum_9.setBackground(new Color(121, 113, 122));
        btnNum_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_9.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_9);

        JButton btnNum_4 = new JButton("4");
        btnNum_4.setForeground(SystemColor.text);
        btnNum_4.setBackground(new Color(121, 113, 122));
        btnNum_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_4.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_4);

        JButton btnNum_5 = new JButton("5");
        btnNum_5.setForeground(SystemColor.text);
        btnNum_5.setBackground(new Color(121, 113, 122));
        btnNum_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_5.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_5);

        JButton btnNum_6 = new JButton("6");
        btnNum_6.setForeground(SystemColor.text);
        btnNum_6.setBackground(new Color(121, 113, 122));
        btnNum_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_6.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_6);

        JButton btnNum_1 = new JButton("1");
        btnNum_1.setForeground(SystemColor.text);
        btnNum_1.setBackground(new Color(121, 113, 122));
        btnNum_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_1.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_1);

        JButton btnNum_2 = new JButton("2");
        btnNum_2.setForeground(SystemColor.text);
        btnNum_2.setBackground(new Color(121, 113, 122));
        btnNum_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_2.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_2);

        JButton btnNum_3 = new JButton("3");
        btnNum_3.setForeground(SystemColor.text);
        btnNum_3.setBackground(new Color(121, 113, 122));
        btnNum_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !isCalculated ) {
                    addInput( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    addInput( e.getActionCommand() );
                }
            }
        });
        btnNum_3.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_3);

        JButton btnNum_0 = new JButton("0");
        btnNum_0.setForeground(SystemColor.text);
        btnNum_0.setBackground(new Color(121, 113, 122));
        btnNum_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !inputPanel.getText().equals("0") ) {
                    if ( !isCalculated ) {
                        addInput( e.getActionCommand() );
                    }
                    else {
                        inputPanel.setText("");
                        operationsPanel.setText("");
                        addInput( e.getActionCommand() );
                    }
                }
            }
        });

        JButton btnNegPos = new JButton("+/-");
        btnNegPos.setForeground(SystemColor.text);
        btnNegPos.setBackground(new Color(75, 73, 82));
        btnNegPos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !inputPanel.getText().isEmpty() ) {
                    inputPanel.setText( df.format( Double.parseDouble(inputPanel.getText().replace(',', '.')) * (-1) ) );
                }
            }
        });
        btnNegPos.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNegPos);
        btnNum_0.setFont(new Font("Tahoma", Font.BOLD, 23));
        numbersPanel.add(btnNum_0);

        JButton btnDot = new JButton(".");
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputPanel.getText();

                if (!text.endsWith(".") ) {
                    text += ".";
                    inputPanel.setText(text);
                }

            }
        });
        btnDot.setForeground(SystemColor.text);
        btnDot.setBackground(new Color(75, 73, 82));
        btnDot.setFont(new Font("Tahoma", Font.BOLD, 21));
        numbersPanel.add(btnDot);

        JPanel operationsPanel_2 = new JPanel();
        operationsPanel_2.setBackground(new Color(14, 24, 38));
        operationsPanel_2.setBounds(10, 98, 465, 76);
        contentPane.add(operationsPanel_2);

        JButton btnDelete = new JButton("DEL");
        btnDelete.setBounds(99, 0, 78, 76);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputPanel.getText();

                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    inputPanel.setText(text);
                }
            }
        });

        JButton btnClear = new JButton("C");
        btnClear.setBounds(0, 0, 78, 76);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operationsPanel.setText("");
                inputPanel.setText("") ;
            }
        });
        operationsPanel_2.setLayout(null);
        btnClear.setForeground(SystemColor.text);
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnClear.setBackground(new Color(177, 75, 106));
        operationsPanel_2.add(btnClear);
        btnDelete.setForeground(SystemColor.text);
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 21));
        btnDelete.setBackground(new Color(75, 73, 82));
        operationsPanel_2.add(btnDelete);

        JButton btnAddMemory = new JButton("M+");
        btnAddMemory.setBounds(293, 0, 76, 76);
        btnAddMemory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ( !inputPanel.getText().isEmpty() ) {
                    memory = Double.parseDouble ( inputPanel.getText() );
                    inputPanel.setText("");
                    operationsPanel.setText("");
                    previousNum = 0;
                }
            }
        });

        JButton btnGetMemory = new JButton("M");
        btnGetMemory.setBounds(198, 0, 78, 76);
        btnGetMemory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputPanel.setText( df.format(memory) );
            }
        });
        btnGetMemory.setForeground(SystemColor.text);
        btnGetMemory.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnGetMemory.setBackground(new Color(75, 73, 82));
        operationsPanel_2.add(btnGetMemory);
        btnAddMemory.setForeground(SystemColor.text);
        btnAddMemory.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnAddMemory.setBackground(new Color(75, 73, 82));
        operationsPanel_2.add(btnAddMemory);

        JButton btnAllClear = new JButton("M-");
        btnAllClear.setBounds(389, 0, 75, 76);
        btnAllClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                memory = 0;
            }
        });
        btnAllClear.setForeground(SystemColor.text);
        btnAllClear.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnAllClear.setBackground(new Color(75, 73, 80));
        operationsPanel_2.add(btnAllClear);

        JPanel operatorsPanel = new JPanel();
        operatorsPanel.setBackground(new Color(14, 24, 38));
        operatorsPanel.setBounds(304, 188, 171, 348);
        contentPane.add(operatorsPanel);
        operatorsPanel.setLayout(new GridLayout(4, 2, 20, 20));

        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( !changeOperation ) {
                    previousNum = getPreviousNum(inputPanel.getText());
                    changeOperation = true;
                    operation = 1;
                    inputPanel.setText("");
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
                else {
                    operation = 1;
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
            }
        });
        btnPlus.setForeground(SystemColor.text);
        btnPlus.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnPlus.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnPlus);

        JButton btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( !changeOperation ){
                    previousNum = getPreviousNum(inputPanel.getText());
                    changeOperation = true;
                    operation = 2;
                    inputPanel.setText("");
                    operationsPanel.setText(df.format(previousNum) + e.getActionCommand());
                }
                else {
                    operation = 2;
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
            }
        });
        btnMinus.setForeground(SystemColor.text);
        btnMinus.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnMinus.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnMinus);

        JButton btnMultiply = new JButton("x");
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( !changeOperation ) {
                    previousNum = getPreviousNum(inputPanel.getText());
                    changeOperation = true;
                    operation = 3;
                    inputPanel.setText("");
                    operationsPanel.setText(df.format(previousNum) + e.getActionCommand());
                }
                else {
                    operation = 3;
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
            }
        });
        btnMultiply.setForeground(SystemColor.text);
        btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnMultiply.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnMultiply);

        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( !changeOperation ) {
                    previousNum = getPreviousNum(inputPanel.getText());
                    changeOperation = true;
                    operation = 4;
                    inputPanel.setText("");
                    operationsPanel.setText(df.format(previousNum) + e.getActionCommand());
                }
                else {
                    operation = 4;
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
            }
        });
        btnDivide.setForeground(SystemColor.text);
        btnDivide.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnDivide.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnDivide);

        JButton btnMode = new JButton("%");
        btnMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( !changeOperation ) {
                    previousNum = getPreviousNum(inputPanel.getText());
                    changeOperation = true;
                    operation = 5;
                    inputPanel.setText("");
                    operationsPanel.setText(df.format(previousNum) + e.getActionCommand());
                }
                else {
                    operation = 5;
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
            }
        });
        btnMode.setForeground(SystemColor.text);
        btnMode.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnMode.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnMode);

        JButton btnUs = new JButton("^");
        btnUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( !changeOperation ) {
                    previousNum = getPreviousNum(inputPanel.getText());
                    changeOperation = true;
                    operation = 6;
                    inputPanel.setText("");
                    operationsPanel.setText(df.format(previousNum) + e.getActionCommand());
                }
                else {
                    operation = 6;
                    operationsPanel.setText( df.format(previousNum) + e.getActionCommand());
                }
            }
        });
        btnUs.setForeground(SystemColor.text);
        btnUs.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnUs.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnUs);

        JButton btnSqrt = new JButton("\u221A");
        btnSqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCalculated = false;
                if ( changeOperation == false ) {
                    operation = 7;
                    inputPanel.setText("");
                    operationsPanel.setText( e.getActionCommand() );
                }
                else {
                    inputPanel.setText("");
                    operationsPanel.setText( e.getActionCommand() );
                }

            }
        });
        btnSqrt.setForeground(SystemColor.text);
        btnSqrt.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnSqrt.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnSqrt);

        JButton btnCalculate = new JButton("=");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        btnCalculate.setForeground(SystemColor.text);
        btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnCalculate.setBackground(new Color(75, 73, 82));
        operatorsPanel.add(btnCalculate);
    }
}