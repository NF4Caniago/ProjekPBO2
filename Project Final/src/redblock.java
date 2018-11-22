import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class redblock extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int coloumn){
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, coloumn);
        if(row>14){
            component.setBackground(Color.decode("#D80000"));
            component.setForeground(Color.WHITE);
        }else if(row>9 && row <=14){
            component.setBackground(Color.YELLOW);
        }else{
            component.setBackground(Color.white);
        }
        return component;
    }
}
