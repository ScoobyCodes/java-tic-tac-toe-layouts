package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tictactoe extends Frame{
    Button b[];
    final static int BTN_COUNT = 9;
    Button okDialog;
    Dialog d1;
    Dialog d2;
    int turn;
    boolean[][] covered;
    final static int ROW_START = 0;
    final static int COLUMN_START = 3;
    final static int DIAGONAL_START = 6;
    final static int MAX_MINUS = 2;

    public tictactoe(String st) {
        super(st);
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setSize(400,400);
        turn = 1;
        covered = new boolean[8][3];
        setDialogBox1();

        Panel labelPanel = new Panel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        Label l1 = new Label("TIC TAC TOE");

        labelPanel.add(l1);
        Panel game = new Panel();
        b = new Button[BTN_COUNT];

        for(int i=0;i<BTN_COUNT;i++) {
            b[i] = new Button("");
            b[i].setActionCommand((new Integer(i)).toString());
            game.add(b[i]);
        }

        game.setLayout(new GridLayout(3,3));
        game.setPreferredSize(new Dimension(200,200));
        game.setMaximumSize(new Dimension(200,200));

        this.add(labelPanel,BorderLayout.PAGE_START);
        this.add(game, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);

        addActionListeners();
    }

    private void setDialogBox1() {
        d1 = new Dialog(this,"Dialog Box",true);
        Panel ctrlPanel = new Panel();
        d1.setLayout(new FlowLayout(FlowLayout.CENTER));
        ctrlPanel.setLayout(new BoxLayout(ctrlPanel,BoxLayout.Y_AXIS));
        Label l1 = new Label("PLAYER 1 STARTS");
        Label l2 = new Label("PLAYER 1 : X");
        Label l3 = new Label("PLAYER 1 : O");
        l1.setPreferredSize(new Dimension(150,40));
        l2.setPreferredSize(new Dimension(100,40));
        l3.setPreferredSize(new Dimension(100,40));
        ctrlPanel.add(l1);
        ctrlPanel.add(l2);
        ctrlPanel.add(l3);

        d1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d1.setVisible(false);
            }
        });

        okDialog = new Button("OK");
        ctrlPanel.add(okDialog);

        okDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(false);
            }
        });

        d1.add(ctrlPanel);
        d1.setSize(300,300);
        d1.setVisible(true);
    }

    private void setDialogBox2(int turn) {

        d2 = new Dialog(this,"Winner",true);
        Panel ctrlPanel = new Panel();
        d2.setLayout(new FlowLayout(FlowLayout.CENTER));
        ctrlPanel.setLayout(new BoxLayout(ctrlPanel,BoxLayout.Y_AXIS));

        String player = (turn == 1) ? "2" : "1";
        Label l1 = new Label("PLAYER " + player + " WINS");
        l1.setPreferredSize(new Dimension(150,40));
        ctrlPanel.add(l1);

        d2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d2.setVisible(false);
                System.exit(0);
            }
        });

        Button okDialog2 = new Button("OK");
        ctrlPanel.add(okDialog2);

        okDialog2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(false);
                System.exit(0);
            }
        });

        d2.add(ctrlPanel);
        d2.setSize(300,300);
        d2.setVisible(true);
    }

    private void addActionListeners() {

        for(int i=0;i<9;i++) {
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Button b = (Button)e.getSource();
                    char symbol = 'a';
                    if(turn == 1) {
                        turn = 2;
                        b.setLabel("X");
                        symbol = 'X';
                    }
                    else {
                        turn = 1;
                        b.setLabel("O");
                        symbol = 'O';
                    }

                    int x = new Integer(b.getActionCommand());
                    int row = x/3;
                    int column = x%3-1;

                    if(column == -1) {
                        column += 3;
                    }
                    covered[ROW_START + row][column] = true;
                    covered[COLUMN_START + column][row] = true;

                    if(row == column) {
                        covered[DIAGONAL_START + 0][row] = true;
                    }

                    if(row + column == MAX_MINUS) {
                        covered[DIAGONAL_START + 1][row] = true;
                    }

                    checkWinOrNot(turn);
                }

                private void checkWinOrNot(int turn) {
                    boolean win = false;
                    for(int i=0;i<8;i++) {
                        int j;
                        for(j=0;j<3;j++) {
                            if(covered[i][j] == false) {
                                break;
                            }
                        }

                        if(j == 3) {
                            win = true;
                            break;
                        }
                    }

                    if(win) {
                        setDialogBox2(turn);
                    }
                }
            });
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
