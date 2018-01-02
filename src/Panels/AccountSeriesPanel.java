package Panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountSeriesPanel extends JPanel {
    //Creating the Labels which will be placed above our comboboxes
    private JLabel MLabel = new JLabel("Select Movie");
    private JLabel SLabel = new JLabel("Select Serie");
    private JLabel ALabel = new JLabel("Select Account");
    
    public AccountSeriesPanel(){
//        //Setting the layout of the panel to a GridLayout
//        setLayout(new GridLayout(0,3));
//        setMinimumSize(new Dimension(400, 138));
//        setPreferredSize(new Dimension(400, 138));
//
//        //Creating the ComboBox "MovieList" and preventing the user from editing it
//        JComboBox MovieList = new JComboBox(Movies);
//        MovieList.setEditable(false);
//
//        /*Adding a ItemListener which allows us to get the selected item
//        / from the combobox */
////        MovieList.addItemListener(
////                new ItemListener(){
////                    public void itemStateChanged(ItemEvent event){
////                        if(event.getStateChange()==ItemEvent.SELECTED)
////                            SMovie = (Movies[MovieList.getSelectedIndex()]);
////                            Panels.MIPanel.SLabel.setText(Panels.ComboPanel.SMovie);
////                        }
////                }
////        );
//
//        //Creating the ComboBox "SerieList" and preventing the user from editing it
//        JComboBox SerieList = new JComboBox(Series);
//        MovieList.setEditable(false);
//
//        /*Adding a ItemListener which allows us to get the selected item
//        / from the combobox */
////        SerieList.addItemListener(
////                new ItemListener(){
////                    public void itemStateChanged(ItemEvent event){
////                        if(event.getStateChange()==ItemEvent.SELECTED)
////                            SSerie = (Series[SerieList.getSelectedIndex()]);
////                            Panels.MIPanel.SLabel.setText(Panels.ComboPanel.SSerie);
////                        }
////                }
////        );
//
//        //Creating the ComboBox "AccountList" and preventing the user from editing it
//        JComboBox AccountList = new JComboBox(Accounts);
//        AccountList.setEditable(false);
//
//        /*Adding a ItemListener which allows us to get the selected item
//        / from the combobox */
////        AccountList.addItemListener(
////                new ItemListener(){
////                    public void itemStateChanged(ItemEvent event){
////                        if(event.getStateChange()==ItemEvent.SELECTED)
////                            SAccount = (Accounts[AccountList.getSelectedIndex()]);
////                            Panels.AccountPanel.ALabel.setText(Panels.ComboPanel.SAccount);
////                        }
////                }
////        );
//
//        /*Adding all of our components which wil be scaled and placed by our
//        / Layout manager */
//        add(MLabel);
//        add(SLabel);
//        add(ALabel);
//        add(MovieList);
//        add(SerieList);
//        add(AccountList);
    }
}
