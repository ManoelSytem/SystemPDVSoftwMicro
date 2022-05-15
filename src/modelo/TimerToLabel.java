/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import view.ListadeClientes;

/**
 *
 * @author IBBN
 */
public class TimerToLabel implements ActionListener {

    private Timer timer;
    private final JLabel label;
    private final int delay;
    private String texto;
    ListadeClientes viewlistaCliente;
    public TimerToLabel(final int delay, final JLabel label, ListadeClientes view) {
        this.delay = delay;
        this.label = label;
        this.viewlistaCliente = view;
    }

    public void init() {
        timer = new Timer(delay, this);
        timer.start();
    }

     public void stop(){
        timer.stop();
     }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        // faça aqui sua consulta
        
        label.setText(viewlistaCliente.buscaCliente.getText()+" ✔");
        label.updateUI();
       // System.out.println("Estou..."+Math.random());
    }
    
}