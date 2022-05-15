/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author IBBN
 */
public class MeuModelo extends DefaultTableCellRenderer {

  
    public boolean Devedor;
    /**
     * 
     */
    private static final long   serialVersionUID    = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        table.setSelectionBackground(Color.orange);
        return this;
    }
    
    public boolean getDevedor() {
        return Devedor;
    }

    public void setDevedor(boolean Devedor) {
        this.Devedor = Devedor;
    }

}
