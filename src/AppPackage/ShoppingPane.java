
package AppPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShoppingPane extends JPanel{
    JPanel generated;
    JPanel custom;
    DecimalFormat formatter = new DecimalFormat("#0.00");
    
    JLabel generatedTitle;
    JLabel customTitle;
    
    public ShoppingPane(){
        generated = new JPanel();
        custom = new JPanel();
        generatedTitle = new JLabel("Generated Shopping List");
        customTitle = new JLabel("Customizable Shopping List");
        generated.setLayout(new BoxLayout(generated,BoxLayout.Y_AXIS));
        
        
        generated.add(generatedTitle);
        custom.add(customTitle, BorderLayout.NORTH);
        add(generated, BorderLayout.WEST);
    }
    public void update(ShoppingList list){
        generated.removeAll();
        generated.setLayout(new BoxLayout(generated,BoxLayout.Y_AXIS));
        generated.add(generatedTitle);
        printList(list);
    }
    
    public void printList(ShoppingList list){
        for (int i = 0; i<list.size(); i++){
            generated.add(new JLabel(list.get(i).getName() + "          $" + formatter.format(list.get(i).getPrice())));
        }
        generated.add(new JLabel("Total:        $" + formatter.format(list.generatedSum())));
    }
}
