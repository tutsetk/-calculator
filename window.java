import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.event.KeyEvent.*;

public class window extends JFrame {
    public boolean errorCheck = false;
    JTextArea area;
    JPanel text;
    JFrame frame;
    //создаем кнопочки
    JButton num1 = new JButton("CE");
    JButton num2 = new JButton("(");
    JButton num3 = new JButton(")");
    JButton num4 = new JButton("\u2795");
    JButton num5 = new JButton("e");
    JButton num6 = new JButton("\u03c0");
    JButton num7 = new JButton("\u00b1");
    JButton num8 = new JButton("7");
    JButton num9 = new JButton("8");
    JButton num10 = new JButton("9");
    JButton num11 = new JButton("\u2796");
    JButton num12 = new JButton("sin");
    JButton num13 = new JButton("^2");
    JButton num14 = new JButton("log");
    JButton num15 = new JButton("4");
    JButton num16 = new JButton("5");
    JButton num17 = new JButton("6");
    JButton num18 = new JButton("\u2731");
    JButton num19 = new JButton("cos");
    JButton num20 = new JButton("^n");
    JButton num21 = new JButton("ln");
    JButton num22 = new JButton("1");
    JButton num23 = new JButton("2");
    JButton num24 = new JButton("3");
    JButton num25 = new JButton("\u2797");
    JButton num26 = new JButton("tg");
    JButton num27 = new JButton("\u221A");
    JButton num28 = new JButton("");
    JButton num29 = new JButton("");
    JButton num30 = new JButton("0");
    JButton num31 = new JButton("");
    JButton num32 = new JButton(",");
    JButton num33 = new JButton("ctg");
    JButton num34 = new JButton("sqrt^n");
    JButton num35 = new JButton("=");
    String areaText = "";

    public window(){
        frame =new JFrame();
        frame.setSize(500,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        area = new JTextArea(10,44);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);




        text = new JPanel();
        text.add(new JScrollPane(area));
        Container container = getContentPane();
        container.add(text, BorderLayout.NORTH);

        JPanel num = new JPanel();
        num31.setEnabled(false);
        num28.setEnabled(false);
        num29.setEnabled(false);
        //добавляем кнопочки в табличку
        num.add(num1);num.add(num2);num.add(num3);num.add(num4);num.add(num5);num.add(num6);num.add(num7);
        num.add(num8);num.add(num9);num.add(num10);num.add(num11);num.add(num12);num.add(num13);num.add(num14);
        num.add(num15);num.add(num16);num.add(num17);num.add(num18);num.add(num19);num.add(num20);num.add(num21);
        num.add(num22);num.add(num23);num.add(num24);num.add(num25);num.add(num26);num.add(num27);num.add(num28);
        num.add(num29);num.add(num30);num.add(num31);num.add(num32);num.add(num33);num.add(num34);num.add(num35);
        //формируем табличку
        num.setLayout(new GridLayout(5,7));
     //пихаем все в окно
        container.add(num);
        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == VK_DELETE){
                    num1.doClick();
                }
                if (e.getKeyCode() == VK_0 || e.getKeyCode() == VK_NUMPAD0){
                    num30.doClick();
                }
                if (e.getKeyCode() == VK_1 || e.getKeyCode() == VK_NUMPAD1){
                    num22.doClick();
                }
                if (e.getKeyCode() == VK_2 || e.getKeyCode() == VK_NUMPAD2){
                    num23.doClick();
                }
                if (e.getKeyCode() == VK_3 || e.getKeyCode() == VK_NUMPAD3){
                    num24.doClick();
                }
                if (e.getKeyCode() == VK_4 || e.getKeyCode() == VK_NUMPAD4){
                    num15.doClick();
                }
                if (e.getKeyCode() == VK_5 || e.getKeyCode() == VK_NUMPAD5){
                    num16.doClick();
                }
                if (e.getKeyCode() == VK_6 || e.getKeyCode() == VK_NUMPAD6){
                    num17.doClick();
                }
                if (e.getKeyCode() == VK_7 || e.getKeyCode() == VK_NUMPAD7){
                    num8.doClick();
                }
                if (e.getKeyCode() == VK_8 || e.getKeyCode() == VK_NUMPAD8){
                    num9.doClick();
                }
                if (e.getKeyCode() == VK_9 || e.getKeyCode() == VK_NUMPAD9){
                    num10.doClick();
                }
                if (e.getKeyCode() == VK_COMMA || e.getKeyCode() == VK_SEPARATOR || e.getKeyCode() == VK_PERIOD){
                    num32.doClick();
                }
                if (e.getKeyCode() == VK_ENTER || e.getKeyCode() == VK_EQUALS){
                    num35.doClick();
                }
                if (e.getKeyCode() == VK_SLASH){
                    num4.doClick();
                }
                if (e.getKeyCode() == VK_MINUS){
                    num11.doClick();
                }
                if (e.getKeyCode() == VK_MULTIPLY){
                    num18.doClick();
                }
            }
        });
        initListner();
        frame.add(container);
        frame.setVisible(true);
    }
   /* static class KeyBinding extends AbstractAction {

       // public KeyBinding(JButton num1) {
          //  bind(component);
      //  }

        private void bind(JButton num1){
            //производит связь между событием и объектом
            InputMap im = component.getInputMap(JButton.WHEN_FOCUSED);
            //производит связь между объектом и действием
            ActionMap am = component.getActionMap();
            //объект, который будет связывать событие и действие
            String key = "clear-contents";
            //связываем нажатие ctrl+enter и объект
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_MASK, true), key);
            //связываем объект и действие(собственно наш класс)
            am.put(key, this);
        }

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "ctrl+Enter was pressed");
        }
    }*/




   public void initListner(){
        num1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // area.setText("");
                areaText = "";
                updateArea();
            }
        });

        num2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " (";
                updateArea();
            }
        });
        num3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0) ";
                    updateArea();
                }else {
                    areaText += ") ";
                    updateArea();
                }
            }
        });
        num4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0 + ";
                    updateArea();
                }else {
                    areaText += " + ";
                    updateArea();
                }
            }
        });
        num5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "e";
                updateArea();
            }
        });
        num6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "\u03c0";
                updateArea();
            }
        });
        num7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Надо думать
            }
        });
        num8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "7";
                updateArea();
            }
        });

        num9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent num8) {
                areaText += "8";
                updateArea();
            }
        });
        num10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "9";
                updateArea();
            }
        });
        num11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0 - ";
                    updateArea();
                }else {
                    areaText += " - ";
                    updateArea();
                }
            }
        });
        num12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " sin(";
                updateArea();

            }
        });
        num13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0^(2)";
                    updateArea();
                }else {
                    areaText += "^(2)";
                    updateArea();
                }
            }
        });
        num14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " log()()";
                updateArea();
            }
        });
        num15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "4";
                updateArea();
            }
        });
        num16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "5";
                updateArea();
            }
        });
        num17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "6";
                updateArea();
            }
        });
        num18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0 * ";
                    updateArea();
                }else {
                    areaText += " * ";
                    updateArea();
                }
            }
        });
        num19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " cos(";
                updateArea();
            }
        });
        num20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0^(";
                    updateArea();
                }else {
                    areaText += "^(";
                    updateArea();
                }
            }
        });
        num21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " ln(";
                updateArea();
            }
        });
        num22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "1";
                updateArea();
            }
        });
        num23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "2";
                updateArea();
            }
        });
        num24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "3";
                updateArea();
            }
        });
        num25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0 / ";
                    updateArea();
                }else {
                    areaText += " / ";
                    updateArea();
                }
            }
        });
        num26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " tg(";
                updateArea();
            }
        });
        num27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " \u221A(";
                updateArea();
            }
        });
        num30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += "0";
                updateArea();
            }
        });
        num32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.isEmpty()){
                    areaText += "0,";
                    updateArea();
                }else{
                    if(areaText.charAt(areaText.length()-1) == ','){
                        areaText += "";
                        updateArea();
                    }else {
                        if (!Character.isDigit(areaText.charAt(areaText.length() - 1))) {
                            areaText += "0,";
                            updateArea();
                        } else {
                            areaText += ",";
                            updateArea();
                        }
                    }
                }
            }
        });
        num33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " ctg(";
                updateArea();
            }
        });
        num34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaText += " \u221A()()";
                updateArea();
            }
        });
        num35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(areaText.charAt(areaText.length()-1) == ','){
                    areaText += "0";
                    updateArea();
                }else {
                    areaText += "";
                    updateArea();
                }
                if(!Solution.main(areaText).equals("ERROR")){
                    area.setText(Solution.main(areaText));
                }else{
                    puc("ERROR");
                }
                areaText = "";
            }
        });



    }
/*
    public void keyboardChecker (JPanel panel){
        panel.addKeyListener(KeyAdapter){

        }
    if ()
    }*/
    public void setError (){
        errorCheck = true;

    }

    public void puc (String message){
    JOptionPane.showMessageDialog(null, message, "Странный ты", JOptionPane.PLAIN_MESSAGE); // разобраться как это вообще работает
    }
    public void updateArea (){
        area.setText(areaText);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        new window();

    }
}
