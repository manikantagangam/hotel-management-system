package hotelmanagement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
//Class for Customer Checkin and Details
class customer {
    JFrame hotelmanage;
    JLabel Label1, Label2, Label3, Label4, Label5, Label6, Label7, Label8, Cost;
    JTextField Text1, Text2, Text3;
    JTable jt, Tb1;
    JScrollPane js;
    JComboBox roomtype;
    JRadioButton yes, no;
    JCheckBox ac, smoke, extra_bed;
    JButton checkin;
    JPanel check, customer_disp, checkout;
    JTabbedPane jp;
    DefaultTableModel Tb1Model, Tb1Modelx;
    String rooms[] = {"Single", "Double", "Twin", "Duplex", "Suite"};
    void checkin() {
        hotelmanage = new JFrame("Hotel Management");
        hotelmanage.getContentPane().setBackground(Color.cyan);
        hotelmanage.setSize(700, 700); //Creation of Frame-Hotel Management
        check = new JPanel();
        check.setBackground(Color.pink);
        check.setLayout(null);
        jp = new JTabbedPane();
        jp.setBounds(5, 5, 650, 650);
        jp.add("Check in", check); //First Tab - Check in,allows users to check-in the hotel
        hotelmanage.add(jp);
        Label1 = new JLabel("Customer Name: ");
        Label1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label1.setBounds(20, 20, 140, 30);
        check.add(Label1);
        Text1 = new JTextField(); //For entering Customer name
        Text1.setBounds(160, 20, 120, 30);
        check.add(Text1);
        Label2 = new JLabel("Customer Phone No.");
        Label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label2.setBounds(20, 70, 150, 30);
        check.add(Label2);
        Text2 = new JTextField(); //For entering Customer's Phone no
        Text2.setBounds(160, 70, 120, 30);
        check.add(Text2);
        Label3 = new JLabel("No.of people: ");
        Label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label3.setBounds(20, 120, 140, 30);
        check.add(Label3);
        Text3 = new JTextField(); //For entering the no.of ppl staying in the room
        Text3.setBounds(160, 120, 120, 30);
        check.add(Text3);
        Label4 = new JLabel("Types:");
        Label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label4.setBounds(20, 180, 120, 30);
        check.add(Label4);
        String Room[][] = {{"Single", "1000"}, {"Double", "2000"}, {"Twin", "3000"}, {"Duplex", "4000"}, {"Suite", "5000"}};
        String coloumns[] = {"Room", "Cost"};
        jt = new JTable(Room, coloumns);
        js = new JScrollPane(jt);
        js.setBounds(160, 170, 200, 85);
        check.add(js);
        Label5 = new JLabel("Type of Room: ");
        Label5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label5.setBounds(20, 270, 120, 30);
        check.add(Label5);
        roomtype = new JComboBox(rooms); //Shows the type of room from where customer can select appropriate room
        roomtype.setBounds(160, 270, 120, 30);
        check.add(roomtype);
        Label6 = new JLabel("Additional Requsites:");
        Label6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label6.setBounds(20, 320, 140, 30);
        check.add(Label6);
        ac = new JCheckBox("AC Room");
        ac.setBounds(160, 320, 80, 30);
        check.add(ac);
        smoke = new JCheckBox("Smoking");
        smoke.setBounds(240, 320, 80, 30);
        check.add(smoke);
        extra_bed = new JCheckBox("Extra Bed");
        extra_bed.setBounds(320, 320, 80, 30);
        check.add(extra_bed);
        Label7 = new JLabel("Breakfast: ");
        Label7.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Label7.setBounds(20, 370, 100, 30);
        check.add(Label7);
        yes = new JRadioButton("Yes");
        yes.setBounds(130, 370, 80, 30);
        yes.setSelected(true);
        check.add(yes);
        no = new JRadioButton("No");
        no.setBounds(210, 370, 80, 30);
        check.add(no);
        ButtonGroup bf = new ButtonGroup();
        bf.add(yes);
        bf.add(no);
        //Provides two choices,i.e whether the customer wants complementary breakfast or not
        Cost = new JLabel("Total Cost: ");
        Cost.setFont(new Font("Times New Roman", Font.BOLD, 16));
        Cost.setBounds(20, 420, 100, 30);
        check.add(Cost);
        Label8 = new JLabel(); //Displays total cost of the user needed for purchasing the room
        Label8.setBounds(120, 420, 100, 30);
        check.add(Label8);
        checkin = new JButton("Check In"); //Button to proceed with the transaction
        checkin.setBounds(20, 500, 100, 30);
        check.add(checkin);
        checkin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String room = rooms[roomtype.getSelectedIndex()];
                int cost = 0; //Calculates Cost of Customer based on room and additional requisites
                switch (room) {
                    case "Single":
                        cost = 1000;
                        break;
                    case "Double":
                        cost = 2000;
                        break;
                    case "Twin":
                        cost = 3000;
                        break;
                    case "Duplex":
                        cost = 4000;
                        break;
                    case "Suite":
                        cost = 5000;
                        break;
                }
                if (ac.isSelected()) {
                    cost = cost + 1000;
                }
                if (smoke.isSelected()) {
                    cost = cost + 700;
                }
                if (extra_bed.isSelected()) {
                    cost = cost + 300;
                }
                String finalcst = Integer.toString(cost);
                Label8.setText(finalcst); //Sets the Text to cost required
            }
        });
        hotelmanage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hotelmanage.setLayout(null);
        hotelmanage.setVisible(true);
    }
    void check_out() {
        checkout = new JPanel();
        checkout.setBackground(Color.pink);
        checkout.setLayout(null);
        jp.add("Check out", checkout); //Tab 2- Check out,when people are leaving the hotel.
        hotelmanage.add(jp);
        JLabel phn = new JLabel("Customer Phone No:");
        phn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        phn.setBounds(20, 20, 140, 30);
        checkout.add(phn);
        JTextField PhnNo = new JTextField(); //For entering Customer's Phone no
        PhnNo.setBounds(160, 20, 120, 30);
        checkout.add(PhnNo);
        JButton chckout = new JButton("Check-out"); //Button for Checking out
        chckout.setBounds(20, 70, 100, 30);
        checkout.add(chckout);
        Tb1Modelx = new DefaultTableModel(); //Default Model for Table with coloumn based on customer's data
        Tb1Modelx.addColumn("Customer Name");
        Tb1Modelx.addColumn("Phone Number");
        Tb1Modelx.addColumn("No of People");
        Tb1Modelx.addColumn("Room Type");
        Tb1Modelx.addColumn("Extra Requisites");
        Tb1Modelx.addColumn("Breakfast");
        JTable Tb = new JTable(Tb1Modelx); //Table that shows which customer had checked out
        JScrollPane src1 = new JScrollPane(Tb);
        src1.setBounds(20, 120, 500, 500);
        checkout.add(src1);
        chckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String PhoneNo = PhnNo.getText();
                String name = null, phno = null, ppl = null, rtype = null, er = null, bf = null;
                int len = PhoneNo.length(); //Gets Length of Phone Number
                //For Validation of input
                if (len != 10) {
                    JOptionPane.showMessageDialog(checkout, "Enter Proper Phone No.");
                } else {
                    char ch[] = PhoneNo.toCharArray();
                    for (int i = 0; i < len; i++) {
                        if (ch[i] < '0' || ch[i] > '9') {
                            JOptionPane.showMessageDialog(checkout, "Enter Proper Phone No.");
                        }
                    }
                }
                //Gets the customer details based on phone no. given
                for (int i = 0; i < Tb1.getRowCount(); i++) {
                    if (Tb1.getValueAt(i, 1).equals(PhoneNo)) {
                        name = Tb1.getValueAt(i, 0).toString();
                        phno = Tb1.getValueAt(i, 1).toString();
                        ppl = Tb1.getValueAt(i, 2).toString();
                        rtype = Tb1.getValueAt(i, 3).toString();
                        er = Tb1.getValueAt(i, 4).toString();
                        bf = Tb1.getValueAt(i, 5).toString();
                        Tb1Modelx.addRow(new Object[]{name, phno, ppl, rtype, er, bf});
                        Tb1Model.removeRow(i);
                    } else if (i == Tb1.getRowCount() - 1) //If Phone No. isn't found
                    {
                        JOptionPane.showMessageDialog(checkout, "Person doesn't exist.");
                    }
                }
            }
        });
    }
    void displaycust() {
        customer_disp = new JPanel();
        customer_disp.setBackground(Color.pink);
        customer_disp.setLayout(null);
        jp.add("Customer Details", customer_disp);//Tab 2 -Displays Customer's Details
        hotelmanage.add(jp);
        Tb1Model = new DefaultTableModel(); //Default Model for Table with coloumn based on customer's data
        Tb1Model.addColumn("Customer Name");
        Tb1Model.addColumn("Phone Number");
        Tb1Model.addColumn("No of People");
        Tb1Model.addColumn("Room Type");
        Tb1Model.addColumn("Extra Requisites");
        Tb1Model.addColumn("Breakfast");
        Tb1 = new JTable(Tb1Model);
        JScrollPane src = new JScrollPane(Tb1);
        src.setBounds(20, 20, 500, 500);
        customer_disp.add(src);
        checkin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String custname = Text1.getText();
                String custphno = Text2.getText();
                String no_of_ppl = Text3.getText();
                String room_typ = rooms[roomtype.getSelectedIndex()];
                String extra_req = " ";
                if (ac.isSelected()) {
                    extra_req = extra_req + "AC Room ";
                }
                if (smoke.isSelected()) {
                    extra_req = extra_req + "Smoking Room ";
                }
                if (extra_bed.isSelected()) {
                    extra_req = extra_req + "Extra Bed ";
                }
                String breakfast;
                if (yes.isSelected()) {
                    breakfast = "Yes";
                } else {
                    breakfast = "No";
                }
                int len1 = custname.length(), len2 = custphno.length(), len3 = no_of_ppl.length();
                //Input Validation
                if (len1 == 0) {
                    JOptionPane.showMessageDialog(check, "Enter proper customer name");
                } else if (len2 == 0) {
                    JOptionPane.showMessageDialog(check, "Enter proper customer phone no.");
                } else if (len3 == 0) {
                    JOptionPane.showMessageDialog(check, "Enter no.of people properly");
                } else {
                    Tb1Model.addRow(new Object[]{custname, custphno, no_of_ppl, room_typ, extra_req, breakfast});
                }
                //Adds Data into the Table based on values taken from the user
            }
        });
    }
}
class hotelroom extends customer {
    JLabel RNO, RType, BedNo, TCost, LCost;
    JTextField Txt1, Txt3;
    JComboBox Roomtype;
    JButton add, update, del;
    DefaultTableModel Tb2Model, Tb2Modelx;
    JTable Tb2;
    JPanel room_add, room_upd, room_del, room_disp;
    String room1[] = {"Single", "Double", "Twin", "Duplex", "Suite"};
    void room_add() {
        room_add = new JPanel();
        room_add.setBackground(Color.pink);
        room_add.setLayout(null);
        jp.add("Addition of Rooms", room_add);//Tab 3- Adds rooms into the hotel
        hotelmanage.add(jp);
        RNO = new JLabel("Room No:");
        RNO.setFont(new Font("Times New Roman", Font.BOLD, 15));
        RNO.setBounds(20, 20, 140, 30);
        room_add.add(RNO);
        Txt1 = new JTextField(); //For entering room no
        Txt1.setBounds(160, 20, 140, 30);
        room_add.add(Txt1);
        RType = new JLabel("Room Type:");
        RType.setFont(new Font("Times New Roman", Font.BOLD, 15));
        RType.setBounds(20, 70, 140, 30);
        room_add.add(RType);
        Roomtype = new JComboBox(room1);
        Roomtype.setBounds(160, 70, 140, 30);
        room_add.add(Roomtype);
        BedNo = new JLabel("No.of Beds:");
        BedNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
        BedNo.setBounds(20, 120, 140, 30);
        room_add.add(BedNo);
        Txt3 = new JTextField(); //For entering no.of beds
        Txt3.setBounds(160, 120, 140, 30);
        room_add.add(Txt3);
        TCost = new JLabel("Cost of Room:");
        TCost.setFont(new Font("Times New Roman", Font.BOLD, 15));
        TCost.setBounds(20, 170, 140, 30);
        room_add.add(TCost);
        LCost = new JLabel();
        LCost.setBounds(160, 170, 140, 30);
        room_add.add(LCost);
        add = new JButton("ADD"); //button to add room
        add.setBounds(20, 220, 100, 30);
        room_add.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //For giving the cost per room
                String room = room1[Roomtype.getSelectedIndex()];
                int cost = 0;
                if (room == "Single") {
                    cost = 1000;
                }
                if (room == "Double") {
                    cost = 2000;
                }
                if (room == "Twin") {
                    cost = 3000;
                }
                if (room == "Duplex") {
                    cost = 4000;
                }
                if (room == "Suite") {
                    cost = 5000;
                }
                String CostRoom = Integer.toString(cost);
                LCost.setText(CostRoom);
            }
        });
    }
    void room_update() {
        room_upd = new JPanel();
        room_upd.setBackground(Color.pink);
        room_upd.setLayout(null);
        jp.add("Updation of Rooms", room_upd); //Tab 6- For updating details of room entered
        hotelmanage.add(jp);
        JLabel RNO1 = new JLabel("Room No:");
        RNO1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        RNO1.setBounds(20, 20, 140, 30);
        room_upd.add(RNO1);
        JTextField Txt1a = new JTextField(); //For entering room no.
        Txt1a.setBounds(160, 20, 140, 30);
        room_upd.add(Txt1a);
        JLabel RType1 = new JLabel("Room Type:");
        RType1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        RType1.setBounds(20, 70, 140, 30);
        room_upd.add(RType1);
        JComboBox Roomtypea = new JComboBox(room1);
        Roomtypea.setBounds(160, 70, 140, 30);
        room_upd.add(Roomtypea);
        JLabel BedNo1 = new JLabel("No.of Beds:");
        BedNo1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        BedNo1.setBounds(20, 120, 140, 30);
        room_upd.add(BedNo1);
        JTextField Txt3a = new JTextField(); //For entering no.of beds
        Txt3a.setBounds(160, 120, 140, 30);
        room_upd.add(Txt3a);
        JLabel TCost1 = new JLabel("Cost of Room:");
        TCost1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        TCost1.setBounds(20, 170, 140, 30);
        room_upd.add(TCost1);
        JLabel LCost1 = new JLabel();
        LCost1.setBounds(160, 170, 140, 30);
        room_upd.add(LCost1);
        update = new JButton("Update"); //button to update content
        update.setBounds(20, 220, 100, 30);
        room_upd.add(update);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //For giving the cost per room
                String room = room1[Roomtypea.getSelectedIndex()];
                int cost = 0;
                if (room == "Single") {
                    cost = 1000;
                }
                if (room == "Double") {
                    cost = 2000;
                }
                if (room == "Twin") {
                    cost = 3000;
                }
                if (room == "Duplex") {
                    cost = 4000;
                }
                if (room == "Suite") {
                    cost = 5000;
                }
                String rcost = Integer.toString(cost);
                LCost1.setText(rcost);
                String rno, nob;
                rno = Txt1a.getText();
                nob = Txt3a.getText();
                int len1 = rno.length(), len2 = nob.length();
                char ch1[] = rno.toCharArray(), ch2[] = nob.toCharArray();
                //Input Validation
                if (len1 == 0) {
                    JOptionPane.showMessageDialog(room_upd, "Enter proper room no.");
                    for (int i = 0; i < len2; i++) {
                        if (ch2[i] < '0' || ch2[i] > '9') {
                            JOptionPane.showMessageDialog(room_upd, "Enter proper no.of beds");
                        }
                    }
                } else if (len2 == 0) {
                    JOptionPane.showMessageDialog(room_upd, "Enter proper no.of beds");
                    for (int i = 0; i < len1; i++) {
                        if (ch1[i] < '0' || ch1[i] > '9') {
                            JOptionPane.showMessageDialog(room_upd, "Enter proper room no.");
                        }
                    }
                } else {
                    //Edits the value of row that has same room no. ,provided by user
                    for (int i = 0; i < Tb2.getRowCount(); i++) {
                        if (Tb2.getValueAt(i, 0).equals(rno)) {
                            Tb2Model.setValueAt(rno, i, 0);
                            Tb2Model.setValueAt(room, i, 1);
                            Tb2Model.setValueAt(nob, i, 2);
                            Tb2Model.setValueAt(rcost, i, 3);
                        } else if (i == Tb2.getRowCount() - 1) {
                            JOptionPane.showMessageDialog(room_upd, "Room doesn't exist.");
                        }
                    }
                }
            }
        });
    }
    void room_delete() {
        room_del = new JPanel();
        room_del.setBackground(Color.pink);
        room_del.setLayout(null);
        jp.add("Deletion of rooms", room_del); //Tab 6 - Deletion of room
        hotelmanage.add(jp);
        JLabel rno = new JLabel("Enter Room No.: ");
        rno.setFont(new Font("Times New Roman", Font.BOLD, 15));
        rno.setBounds(20, 20, 140, 30);
        room_del.add(rno);
        JTextField RNox = new JTextField(); //For entering the room no.
        RNox.setBounds(160, 20, 120, 30);
        room_del.add(RNox);
        del = new JButton("Room Delete"); //Button to delete
        del.setBounds(20, 70, 140, 30);
        room_del.add(del);
        Tb2Modelx = new DefaultTableModel(); //Default Model for Table with coloumn based on room's data
        Tb2Modelx.addColumn("Room No");
        Tb2Modelx.addColumn("Room Type");
        Tb2Modelx.addColumn("No of Beds");
        Tb2Modelx.addColumn("Room Cost");
        JTable Tba = new JTable(Tb2Modelx); //Table that stores information about which room was deleted
        JScrollPane src1a = new JScrollPane(Tba);
        src1a.setBounds(20, 120, 500, 500);
        room_del.add(src1a);
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String RoomNo = RNox.getText();
                String roomNo = null, type = null, beds = null, rcost = null;
                int len = RoomNo.length();
                char ch[] = RoomNo.toCharArray();
                //For input Validation
                for (int i = 0; i < len; i++) {
                    if (ch[i] < '0' || ch[i] > '9') {
                        JOptionPane.showMessageDialog(room_del, "Enter Proper Room No.");
                    }
                }
                //Deletes the room details and displays the deleted rooms in a tabular form
                for (int i = 0; i < Tb2.getRowCount(); i++) {
                    if (Tb2.getValueAt(i, 0).equals(RoomNo)) {
                        roomNo = Tb2.getValueAt(i, 0).toString();
                        type = Tb2.getValueAt(i, 1).toString();
                        beds = Tb2.getValueAt(i, 2).toString();
                        rcost = Tb2.getValueAt(i, 3).toString();
                        Tb2Modelx.addRow(new Object[]{roomNo, type, beds, rcost});
                        Tb2Model.removeRow(i);
                    } else if (i == Tb2.getRowCount() - 1) {
                        JOptionPane.showMessageDialog(room_del, "Room doesn't exist.");
                    }
                }
            }
        });
    }
    void displayroom() {
        room_disp = new JPanel();
        room_disp.setBackground(Color.pink);
        room_disp.setLayout(null);
        jp.add("Room Details", room_disp); //Tab 4-Displaying Room Details
        hotelmanage.add(jp);
        Tb2Model = new DefaultTableModel();//Default Model for Table with coloumn based on room's data
        Tb2Model.addColumn("Room No");
        Tb2Model.addColumn("Room Type");
        Tb2Model.addColumn("No of Beds");
        Tb2Model.addColumn("Room Cost");
        Tb2 = new JTable(Tb2Model);
        JScrollPane srctb = new JScrollPane(Tb2);
        srctb.setBounds(20, 20, 500, 500);
        room_disp.add(srctb);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomNo = Txt1.getText();
                String no_of_beds = Txt3.getText();
                String Room_Type = room1[Roomtype.getSelectedIndex()];
                int tcost = 0;
                if (Room_Type == "Single") {
                    tcost = 1000;
                }
                if (Room_Type == "Double") {
                    tcost = 2000;
                }
                if (Room_Type == "Twin") {
                    tcost = 3000;
                }
                if (Room_Type == "Duplex") {
                    tcost = 4000;
                }
                if (Room_Type == "Suite") {
                    tcost = 5000;
                }
                String totalcst = Integer.toString(tcost);
                int len1 = roomNo.length(), len2 = no_of_beds.length();
                char ch1[] = roomNo.toCharArray(), ch2[] = no_of_beds.toCharArray();
                //Input Validation
                if (len1 == 0) {
                    JOptionPane.showMessageDialog(room_add, "Enter proper room no.");
                    for (int i = 0; i < len2; i++) {
                        if (ch2[i] < '0' || ch2[i] > '9') {
                            JOptionPane.showMessageDialog(room_add, "Enter proper no.of beds");
                        }
                    }
                } else if (len2 == 0) {
                    JOptionPane.showMessageDialog(room_add, "Enter proper no.of beds");
                    for (int i = 0; i < len1; i++) {
                        if (ch1[i] < '0' || ch1[i] > '9') {
                            JOptionPane.showMessageDialog(room_add, "Enter proper room no.");
                        }
                    }
                } else {
                    Tb2Model.addRow(new Object[]{roomNo, Room_Type, no_of_beds, totalcst});
                }
                //Adds Data into the Table based on values taken from the user
            }
        });
    }
}
public class hotelmanagement extends hotelroom {
    void ExceptionHandling() {
        try {
            hotelroom hr = new hotelroom();
            hr.checkin();
            hr.check_out();
            hr.displaycust();
            hr.room_add();
            hr.room_update();
            hr.room_delete();
            hr.displayroom();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(hotelmanage, "Exception occured");
        }
    }
    public static void main(String[] args) {
        hotelmanagement hm = new hotelmanagement();
        hm.ExceptionHandling();
    }
}