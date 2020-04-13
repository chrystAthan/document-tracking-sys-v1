/*
 * To change this license header, choose License Deaners in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package document_tracking_system;

import com.mysql.jdbc.Connection;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Thread.sleep;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Admin
 */
public final class ReceiveSubmitPage extends JFrame {

    public ReceiveSubmitPage(String username) {
        initComponents();
        sub();
        autoId();
        clock();
        numRowTrackingPagr();
        permission();

        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonSubmit.setEnabled(false);

//        numRowViewDetails();
        jTextFieldTracking.setEnabled(false);
        jButtonHomeV.setEnabled(false);
        jButtonTransactionHistoryV.setEnabled(false);
        jButtonTrackingPageV.setEnabled(false);
        jButtonIncomingMenu.setEnabled(false);
        jButtonPendingMenu.setEnabled(false);
        jButtonOutgoingMenu.setEnabled(false);

        jTextFieldFrom.setEnabled(false);
        jTextFieldBy.setEnabled(false);
        //visble label for nutify
        jLabelIncomingMenuNumber.setVisible(false);
        jLabelIncomingMenuCircle.setVisible(false);
        jLabelPendingMenuNumber.setVisible(false);
        jLabelPendingMenuCircle.setVisible(false);
        jLabelOutgoingMenuNumber.setVisible(false);
        jLabelOutgoingMenuCircle.setVisible(false);
        jLabelTrackingPageMenuCircle.setVisible(false);
        jLabelTrackingPageMenuNumber.setVisible(false);
        jLabelTransactionHistoryMenuNumber.setVisible(false);
        jLabelTransactionHistoryMenuCircle.setVisible(false);        //
        //
        //visend
        jLabelUsername.setText(username);
        jLabel24.setText(username);

        jTabletracking.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTabletracking.setRowHeight(30);

        jTableTransactionHistory.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableTransactionHistory.setRowHeight(30);

        jTableViewdetails.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableViewdetails.setRowHeight(30);

        jTableIncoming.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableIncoming.setRowHeight(30);

        jTablePending.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTablePending.setRowHeight(30);

        jTableOutgoing.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableOutgoing.setRowHeight(30);

        jTableIncomingList.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableIncomingList.setRowHeight(30);

        jTablePendingList.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTablePendingList.setRowHeight(30);

        jTableOutgoingList.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableOutgoingList.setRowHeight(30);

        jTableTransactionHistory.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    int row = jTableTransactionHistory.getSelectedRow();
                    if (row == -1) {

                    } else {
                        jButtonTransactionHistoryViewDetails.setEnabled(true);
                        jLabelGetTrackingID.setText(jTableTransactionHistory.getValueAt(row, 0).toString());

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        jTableIncoming.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    int row = jTableIncoming.getSelectedRow();
                    if (row == -1) {

                    } else {
                        jButtonIncomingAccept.setEnabled(true);

                        jLabeltracking_data.setText(jTableIncoming.getValueAt(row, 0).toString());
                        jLabelFrom_data.setText(jTableIncoming.getValueAt(row, 1).toString());
                        jLabelby_data.setText(jTableIncoming.getValueAt(row, 2).toString());
                        jLabelto_data.setText(jTableIncoming.getValueAt(row, 3).toString());
                        jLabeltype_data.setText(jTableIncoming.getValueAt(row, 4).toString());
                        jLabelPurpose_data.setText(jTableIncoming.getValueAt(row, 5).toString());
                        jLabelDetail_data.setText(jTableIncoming.getValueAt(row, 6).toString());

                        String var = jLabeltracking_data.getText();
                        try {
                            con = myConnection.getConnection();
                            Statement s = con.createStatement();
                            ResultSet rs = s.executeQuery("SELECT userID FROM incoming where tracking_data ='" + var + "'");

                            if (rs.next()) {
                                int idd = rs.getInt(1);
                                String sd = String.valueOf(idd);
                                jLabelTracingID.setText(sd);
                            }
                            con.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        jTablePending.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    ReceiveSubmitAcction DocTrackSubmit = new ReceiveSubmitAcction();
//     
                    if (me.getClickCount() == 1) {
                        int row = jTablePending.getSelectedRow();

                        if (row == -1) {

                        } else {
                            DocTrackSubmit.setVisible(true);
                            jButtonPendingAccept.setEnabled(true);

                            jLabeltracking_data.setText(jTablePending.getValueAt(row, 0).toString());
                            jLabelFrom_data.setText(jTablePending.getValueAt(row, 1).toString());
                            jLabelby_data.setText(jTablePending.getValueAt(row, 2).toString());
                            jLabelto_data.setText(jTablePending.getValueAt(row, 3).toString());
                            jLabeltype_data.setText(jTablePending.getValueAt(row, 4).toString());
                            jLabelPurpose_data.setText(jTablePending.getValueAt(row, 5).toString());
                            jLabelDetail_data.setText(jTablePending.getValueAt(row, 6).toString());
                            jLabelpendingdetails.setText(jTablePending.getValueAt(row, 7).toString());
                            //  jTextAreaDetails

                            DocTrackSubmit.jTextFieldFrom.setText(jLabelFrom_data.getText());
                            DocTrackSubmit.jTextFieldBy.setText(jLabelby_data.getText());
                            DocTrackSubmit.jTextDoctype.setText(jLabeltype_data.getText());
                            DocTrackSubmit.jTextAreaDetails.setText(jLabelpendingdetails.getText());
                            DocTrackSubmit.jTextAreaPurpose.setText(jLabelPurpose_data.getText());
                            DocTrackSubmit.jLabelTrackingForPending.setText(jLabeltracking_data.getText());
                            DocTrackSubmit.jLabelPermission.setText(jLabelPermission.getText());
                            DocTrackSubmit.jLabelUsername.setText(jLabelUsername.getText());
                            DocTrackSubmit.jComboBoxPermission.setSelectedItem("sjdfhl");

                            String var = jLabeltracking_data.getText();

                            try {
                                con = myConnection.getConnection();
                                Statement s = con.createStatement();
                                ResultSet rs = s.executeQuery("SELECT userID FROM pending where tracking_number ='" + var + "'");

                                if (rs.next()) {
                                    int idd = rs.getInt(1);
                                    String sd = String.valueOf(idd);
                                    jLabelTracingID.setText(sd);
                                    DocTrackSubmit.jLabelUserID.setText(jLabelTracingID.getText());
                                }
                                con.close();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (("Vice-President for Reseach Development and Extension".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Administrative");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Vice-President for Academic Affairs".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Administrative");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Vice-President for Administrative".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            }/////
                            else if (("President of DOSCST Alumni Association".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Head of Quality of Management Office".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Entrepreneurship and Management Officer".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Public Information Officer".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Executive Assistant to the President".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Director for Planning and Development".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Head of Infrastructure Committee".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Head of Management Information System".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("School President");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Reseach Development and Extension");
                                DocTrackSubmit.jComboBoxField.addItem("Vice of Academic");
                                DocTrackSubmit.jComboBoxField.addItem("Office of College Council");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Head of ICE".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("Academic ");
                                DocTrackSubmit.jComboBoxField.addItem("Administrative ");
                                DocTrackSubmit.jComboBoxField.addItem("Research Development and Extension ");
                                DocTrackSubmit.jComboBoxField.addItem("College Council ");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Head of IBPA".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("Academic ");
                                DocTrackSubmit.jComboBoxField.addItem("Administrative ");
                                DocTrackSubmit.jComboBoxField.addItem("Research Development and Extension ");
                                DocTrackSubmit.jComboBoxField.addItem("College Council ");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            } else if (("Head of IALS".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("Academic ");
                                DocTrackSubmit.jComboBoxField.addItem("Administrative ");
                                DocTrackSubmit.jComboBoxField.addItem("Research Development and Extension ");
                                DocTrackSubmit.jComboBoxField.addItem("College Council ");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(false);
                            } else if (("Head of IETT".equals(DocTrackSubmit.jLabelPermission.getText()))) {
                                DocTrackSubmit.jComboBoxField.removeAllItems();
                                DocTrackSubmit.jComboBoxField.addItem("Select");
                                DocTrackSubmit.jComboBoxField.addItem("Academic ");
                                DocTrackSubmit.jComboBoxField.addItem("Administrative ");
                                DocTrackSubmit.jComboBoxField.addItem("Research Development and Extension ");
                                DocTrackSubmit.jComboBoxField.addItem("College Council ");

                                DocTrackSubmit.jComboBoxPermission.removeAllItems();
                                DocTrackSubmit.jButtonSubmit.setEnabled(false);
                                DocTrackSubmit.jButtonReturn.setEnabled(true);
                                DocTrackSubmit.jButtonDone.setEnabled(true);
                            }

                        }

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });
    }
    java.sql.Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFrom = new javax.swing.JTextField();
        jTextFieldBy = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDetails = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaPurpose = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxField = new javax.swing.JComboBox<>();
        jSeparator19 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBoxDocType = new javax.swing.JComboBox<>();
        jComboBoxPermission = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabelTransactionHistoryNumber = new javax.swing.JLabel();
        jLabelTransactionHistoryCircle = new javax.swing.JLabel();
        jButtonTransactionHistory = new javax.swing.JButton();
        jLabeltrackingPageNumber = new javax.swing.JLabel();
        jLabelTrackingPageCircle = new javax.swing.JLabel();
        jButtonTrackingPage = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jLabelIncomingNumber = new javax.swing.JLabel();
        jLabelPendingNumber = new javax.swing.JLabel();
        jLabelOutgoingNumber = new javax.swing.JLabel();
        jLabelOutgoingCircle = new javax.swing.JLabel();
        jLabelPendingCircle = new javax.swing.JLabel();
        jLabelIncomingCircle = new javax.swing.JLabel();
        jButtonIncoming = new javax.swing.JButton();
        jButtonPending = new javax.swing.JButton();
        jButtonOutgoing = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabletracking = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextFieldTrackingPage = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTransactionHistory = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxTransactionHistory = new javax.swing.JComboBox<>();
        jTextFieldTracnsac = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButtonTransactionHistoryViewDetails = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableViewdetails = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableIncoming = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jTextFieldIncoming = new javax.swing.JTextField();
        jButtonIncomingP = new javax.swing.JButton();
        jButtonIncomingAccept = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePending = new javax.swing.JTable();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextFieldPending = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButtonPendingAccept = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        jSeparator35 = new javax.swing.JSeparator();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableOutgoing = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jTextFielOutgoing = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButtonTransactionHistoryViewDetails4 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableIncomingList = new javax.swing.JTable();
        jTextFieldIncomingList = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButtonincommingList = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jSeparator37 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTablePendingList = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        jTextFieldPendingList = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jComboBoxPendingList = new javax.swing.JComboBox<>();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jSeparator40 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        jSeparator41 = new javax.swing.JSeparator();
        jSeparator42 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableOutgoingList = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jTextFieldoutgoingList = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jPanel15ccccccccccccccccccccccc = new javax.swing.JPanel();
        jLabeluserID = new javax.swing.JLabel();
        jLabelFrom_data = new javax.swing.JLabel();
        jLabelby_data = new javax.swing.JLabel();
        jLabelto_data = new javax.swing.JLabel();
        jLabelPurpose_data = new javax.swing.JLabel();
        jLabeltype_data = new javax.swing.JLabel();
        jLabelTo_data = new javax.swing.JLabel();
        jLabelDetail_data = new javax.swing.JLabel();
        jLabeltracking_data = new javax.swing.JLabel();
        jLabelForwarded = new javax.swing.JLabel();
        jLabelstatus = new javax.swing.JLabel();
        jLabelTrackingFK = new javax.swing.JLabel();
        jLabelGetTrackingID = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelSubmitedto = new javax.swing.JLabel();
        jLabelField = new javax.swing.JLabel();
        jLabelSSID = new javax.swing.JLabel();
        jLabelView = new javax.swing.JLabel();
        jLabelPermission = new javax.swing.JLabel();
        jLabelTracingID = new javax.swing.JLabel();
        jLabelFrom = new javax.swing.JLabel();
        jLabelpendingdetails = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldTracking = new javax.swing.JTextField();
        jLabelTransactionHistoryMenuNumber = new javax.swing.JLabel();
        jLabelTransactionHistoryMenuCircle = new javax.swing.JLabel();
        jLabelTrackingPageMenuNumber = new javax.swing.JLabel();
        jLabelTrackingPageMenuCircle = new javax.swing.JLabel();
        jButtonTransactionHistoryV = new javax.swing.JButton();
        jButtonHomeV = new javax.swing.JButton();
        jButtonTrackingPageV = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelIncomingMenuNumber = new javax.swing.JLabel();
        jLabelIncomingMenuCircle = new javax.swing.JLabel();
        jLabelPendingMenuNumber = new javax.swing.JLabel();
        jLabelPendingMenuCircle = new javax.swing.JLabel();
        jLabelOutgoingMenuNumber = new javax.swing.JLabel();
        jLabelOutgoingMenuCircle = new javax.swing.JLabel();
        jButtonOutgoingMenu = new javax.swing.JButton();
        jButtonPendingMenu = new javax.swing.JButton();
        jButtonIncomingMenu = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1055, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1055, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 102, 0));
        jLabel21.setText("School Personnel Group | Routed incoming document");

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Home");

        jLabel42.setBackground(new java.awt.Color(102, 102, 102));
        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Submit Document");

        jLabelTime.setBackground(new java.awt.Color(102, 102, 102));
        jLabelTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTime.setText("December/12/ 2019");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 1070, 30));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(204, 102, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Cancel_22px.png"))); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/cheek.png"))); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Submission");

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Submit Document");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("From (DOSCST):");

        jTextFieldFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFromActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel7.setText("By:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Document type:");

        jTextAreaDetails.setColumns(20);
        jTextAreaDetails.setRows(5);
        jTextAreaDetails.setText("Please type text \n");
        jScrollPane1.setViewportView(jTextAreaDetails);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setText("Details:");

        jTextAreaPurpose.setColumns(20);
        jTextAreaPurpose.setRows(5);
        jTextAreaPurpose.setText("For approval");
        jScrollPane2.setViewportView(jTextAreaPurpose);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel10.setText("Purpose of submission:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel11.setText("To:");

        jComboBoxField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Academic", "Administrative", "Research Development and Extension", "College Council" }));
        jComboBoxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFieldActionPerformed(evt);
            }
        });

        jSeparator19.setBackground(new java.awt.Color(0, 51, 102));

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setText("Edit");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jComboBoxDocType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leave Form", "Request Form" }));
        jComboBoxDocType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDocTypeActionPerformed(evt);
            }
        });

        jComboBoxPermission.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxPermissionKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel17.setText("Field:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxField, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(7, 7, 7)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldBy, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldFrom, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxDocType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 438, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator19))
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(204, 102, 0));
        jPanel14.setForeground(new java.awt.Color(204, 102, 0));
        jPanel14.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Documents");
        jPanel13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, 25));
        jPanel13.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 198, 350, -1));

        jLabelTransactionHistoryNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelTransactionHistoryNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelTransactionHistoryNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTransactionHistoryNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTransactionHistoryNumber.setText("0");
        jPanel13.add(jLabelTransactionHistoryNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 20, 20));

        jLabelTransactionHistoryCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTransactionHistoryCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelTransactionHistoryCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTransactionHistoryCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel13.add(jLabelTransactionHistoryCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 40, 40));

        jButtonTransactionHistory.setBackground(new java.awt.Color(0, 51, 100));
        jButtonTransactionHistory.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonTransactionHistory.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTransactionHistory.setText("Transaction History");
        jButtonTransactionHistory.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionHistoryActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonTransactionHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 220, 50));

        jLabeltrackingPageNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabeltrackingPageNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabeltrackingPageNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabeltrackingPageNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltrackingPageNumber.setText("0");
        jPanel13.add(jLabeltrackingPageNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 20, 20));

        jLabelTrackingPageCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTrackingPageCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelTrackingPageCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTrackingPageCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel13.add(jLabelTrackingPageCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 40, 60));

        jButtonTrackingPage.setBackground(new java.awt.Color(0, 51, 100));
        jButtonTrackingPage.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButtonTrackingPage.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTrackingPage.setText("Tracking Page");
        jButtonTrackingPage.setAlignmentY(0.0F);
        jButtonTrackingPage.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonTrackingPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrackingPageActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonTrackingPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Davao_Oriental_State_College_of_Science_and_Technology.png"))); // NOI18N
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 190, 170));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Document Tracking System (DTS)");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("The Davao Oriental State University");
        jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 10));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 102, 0));
        jLabel37.setText("(DOrSU) ");
        jPanel13.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, 30));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("is a state university in Mati City, Davao Oriental,");
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, 40));
        jPanel13.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jSeparator20.setBackground(new java.awt.Color(0, 51, 102));
        jPanel13.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 250, 17));

        jLabelIncomingNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelIncomingNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelIncomingNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIncomingNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIncomingNumber.setText("0");
        jPanel13.add(jLabelIncomingNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 20, 20));

        jLabelPendingNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelPendingNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelPendingNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPendingNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPendingNumber.setText("0");
        jPanel13.add(jLabelPendingNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 20, 20));

        jLabelOutgoingNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelOutgoingNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelOutgoingNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOutgoingNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOutgoingNumber.setText("0");
        jPanel13.add(jLabelOutgoingNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 20, 20));

        jLabelOutgoingCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelOutgoingCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelOutgoingCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOutgoingCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel13.add(jLabelOutgoingCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 40, 40));

        jLabelPendingCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPendingCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelPendingCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPendingCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel13.add(jLabelPendingCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 40));

        jLabelIncomingCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelIncomingCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelIncomingCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIncomingCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel13.add(jLabelIncomingCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 40, 60));

        jButtonIncoming.setBackground(new java.awt.Color(0, 51, 100));
        jButtonIncoming.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonIncoming.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIncoming.setText("Incoming");
        jButtonIncoming.setAlignmentY(0.0F);
        jButtonIncoming.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonIncoming.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonIncoming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncomingActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonIncoming, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 50));

        jButtonPending.setBackground(new java.awt.Color(0, 51, 100));
        jButtonPending.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonPending.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPending.setText("Pending");
        jButtonPending.setMargin(null);
        jButtonPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPendingActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, 50));

        jButtonOutgoing.setBackground(new java.awt.Color(0, 51, 100));
        jButtonOutgoing.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonOutgoing.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOutgoing.setText("Outgoing"); // NOI18N
        jButtonOutgoing.setMargin(null);
        jButtonOutgoing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutgoingActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonOutgoing, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 100, 50));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/logo.png"))); // NOI18N
        jPanel44.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 11, -1, 48));
        jPanel44.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 246, -1));

        jPanel13.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 370, 70));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(204, 102, 0));
        jPanel17.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Document Tracking Result Data");

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Tracking Page (Monitoring)");

        jTabletracking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "Destination", "Document Type", "Action Needed", "Details", "Status", "Posted Time"
            }
        ));
        jScrollPane3.setViewportView(jTabletracking);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10" }));

        jTextFieldTrackingPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTrackingPageActionPerformed(evt);
            }
        });
        jTextFieldTrackingPage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTrackingPageKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTrackingPageKeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton10.setText("Refresh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel62.setBackground(new java.awt.Color(102, 102, 102));
        jLabel62.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Result Data");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(263, 263, 263)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTrackingPage, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTrackingPage, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(204, 102, 0));
        jPanel21.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel33.setBackground(new java.awt.Color(102, 102, 102));
        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("History Data Transaction");

        jLabel34.setBackground(new java.awt.Color(102, 102, 102));
        jLabel34.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("All Transaction History / Data Records");

        jTableTransactionHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "Document Type", "Action Needed", "Details", "Status", "Posted Time"
            }
        ));
        jScrollPane5.setViewportView(jTableTransactionHistory);

        jLabel35.setBackground(new java.awt.Color(102, 102, 102));
        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Show");

        jComboBoxTransactionHistory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View", "Approved", "Rejected" }));
        jComboBoxTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTransactionHistoryActionPerformed(evt);
            }
        });

        jTextFieldTracnsac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTracnsacKeyReleased(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton17.setText("Refresh");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButtonTransactionHistoryViewDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Open View_22px.png"))); // NOI18N
        jButtonTransactionHistoryViewDetails.setText("View Details");
        jButtonTransactionHistoryViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionHistoryViewDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTracnsac, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator21, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTransactionHistoryViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTracnsac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTransactionHistoryViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(204, 102, 0));
        jPanel19.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel29.setBackground(new java.awt.Color(102, 102, 102));
        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Document Tracking Transaction Result Data");

        jLabel30.setBackground(new java.awt.Color(102, 102, 102));
        jLabel30.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("View Details Transaction");

        jTableViewdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "To", "Document Type", "Action Needed", "Details", "Status", "Posted Time"
            }
        ));
        jScrollPane4.setViewportView(jTableViewdetails);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10" }));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Go Back_22px.png"))); // NOI18N
        jButton16.setText("Back");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Print_22px.png"))); // NOI18N
        jButton13.setText("Print Data");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel63.setBackground(new java.awt.Color(102, 102, 102));
        jLabel63.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("Result Data");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGap(157, 157, 157)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab4", jPanel1);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jPanel31.setBackground(new java.awt.Color(204, 102, 0));
        jPanel31.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel44.setBackground(new java.awt.Color(102, 102, 102));
        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("Results Data");

        jLabel45.setBackground(new java.awt.Color(102, 102, 102));
        jLabel45.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Incoming Documents");

        jTableIncoming.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "By", "Destination", "Document Type", "Action Needed", "Details", "Posted Time"
            }
        ));
        jScrollPane8.setViewportView(jTableIncoming);

        jLabel46.setBackground(new java.awt.Color(102, 102, 102));
        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Show");

        jTextFieldIncoming.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIncomingKeyReleased(evt);
            }
        });

        jButtonIncomingP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButtonIncomingP.setText("Search");
        jButtonIncomingP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncomingPActionPerformed(evt);
            }
        });

        jButtonIncomingAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Accepted_22px.png"))); // NOI18N
        jButtonIncomingAccept.setText("Receive");
        jButtonIncomingAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncomingAcceptActionPerformed(evt);
            }
        });

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Open View_22px.png"))); // NOI18N
        jButton25.setText("View All List");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton29.setText("Refresh");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIncomingP, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIncoming, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonIncomingAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonIncomingP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldIncoming, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncomingAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab5", jPanel25);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jPanel33.setBackground(new java.awt.Color(204, 102, 0));
        jPanel33.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Document Tracking Result Data");

        jLabel47.setBackground(new java.awt.Color(102, 102, 102));
        jLabel47.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("Pending (Action Needed)");

        jTablePending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "By", "Destination", "Document Type", "Action Needed", "Status", "Details", "Posted Time"
            }
        ));
        jTablePending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTablePendingMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTablePendingMouseReleased(evt);
            }
        });
        jTablePending.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTablePendingKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePendingKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTablePending);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10" }));

        jTextFieldPending.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPendingKeyReleased(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonPendingAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/pending List_22px.png"))); // NOI18N
        jButtonPendingAccept.setText("View Data");
        jButtonPendingAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPendingAcceptActionPerformed(evt);
            }
        });

        jLabel49.setBackground(new java.awt.Color(102, 102, 102));
        jLabel49.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("Show");

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Open View_22px.png"))); // NOI18N
        jButton26.setText("View All List");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton32.setText("Refresh");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPending, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator30, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator29, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPendingAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jTextFieldPending)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPendingAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab6", jPanel26);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jPanel37.setBackground(new java.awt.Color(204, 102, 0));
        jPanel37.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel52.setBackground(new java.awt.Color(102, 102, 102));
        jLabel52.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setText("Results Data");

        jLabel53.setBackground(new java.awt.Color(102, 102, 102));
        jLabel53.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("Document Outgoing for Actions");

        jTableOutgoing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "By", "Destination", "Document Type", "Action Needed", "Status", "Details", "Posted Time"
            }
        ));
        jScrollPane10.setViewportView(jTableOutgoing);

        jLabel54.setBackground(new java.awt.Color(102, 102, 102));
        jLabel54.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("Show");

        jTextFielOutgoing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielOutgoingKeyReleased(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton15.setText("Search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButtonTransactionHistoryViewDetails4.setText("Accept");
        jButtonTransactionHistoryViewDetails4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionHistoryViewDetails4ActionPerformed(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Open View_22px.png"))); // NOI18N
        jButton23.setText("View All List");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton30.setText("Refresh");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFielOutgoing, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator36, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator35, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonTransactionHistoryViewDetails4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFielOutgoing, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTransactionHistoryViewDetails4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab7", jPanel27);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jPanel34.setBackground(new java.awt.Color(204, 102, 0));
        jPanel34.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel48.setBackground(new java.awt.Color(102, 102, 102));
        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("Results Data");

        jLabel50.setBackground(new java.awt.Color(102, 102, 102));
        jLabel50.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("Document Incoming List");

        jTableIncomingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "By", "Destination", "Document Type", "Action Needed", "Details", "Status", "Posted Time"
            }
        ));
        jScrollPane9.setViewportView(jTableIncomingList);

        jTextFieldIncomingList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIncomingListKeyReleased(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton14.setText("Search");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButtonincommingList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Print_22px.png"))); // NOI18N
        jButtonincommingList.setText("Print Data");
        jButtonincommingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonincommingListActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton18.setText("Refresh");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel61.setBackground(new java.awt.Color(102, 102, 102));
        jLabel61.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Result Data");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(237, 237, 237)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIncomingList, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator33, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator32, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonincommingList, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIncomingList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonincommingList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab8", jPanel29);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        jPanel40.setBackground(new java.awt.Color(204, 102, 0));
        jPanel40.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel55.setBackground(new java.awt.Color(102, 102, 102));
        jLabel55.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Results Data");

        jLabel56.setBackground(new java.awt.Color(102, 102, 102));
        jLabel56.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("Document Pending List");

        jTablePendingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "By", "Destination", "Document Type", "Action Needed", "Details", "Status", "Posted Time"
            }
        ));
        jScrollPane11.setViewportView(jTablePendingList);

        jLabel57.setBackground(new java.awt.Color(102, 102, 102));
        jLabel57.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Show");

        jTextFieldPendingList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPendingListKeyReleased(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton19.setText("Search");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jComboBoxPendingList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View", "Accepted", "Rejected" }));
        jComboBoxPendingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPendingListActionPerformed(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Print_22px.png"))); // NOI18N
        jButton21.setText("Print Data");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton22.setText("Refresh");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPendingList, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPendingList, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator39, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator38, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel39Layout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPendingList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldPendingList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator39, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab9", jPanel35);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        jPanel42.setBackground(new java.awt.Color(204, 102, 0));
        jPanel42.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel58.setBackground(new java.awt.Color(102, 102, 102));
        jLabel58.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("Results Data");

        jLabel59.setBackground(new java.awt.Color(102, 102, 102));
        jLabel59.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("Document Outgoing List");

        jTableOutgoingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking", "From", "By", "Destination", "Document Type", "Action Needed", "Details", "Status", "Posted Time"
            }
        ));
        jScrollPane12.setViewportView(jTableOutgoingList);

        jLabel60.setBackground(new java.awt.Color(102, 102, 102));
        jLabel60.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Result Data");

        jTextFieldoutgoingList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldoutgoingListKeyReleased(evt);
            }
        });

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton24.setText("Search");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Print_22px.png"))); // NOI18N
        jButton27.setText("Print Data");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton28.setText("Refresh");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addGap(528, 528, 528))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldoutgoingList, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator42, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator41, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel41Layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldoutgoingList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator42, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab10", jPanel38);

        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel15cccccccccccccccccccccccLayout = new javax.swing.GroupLayout(jPanel15ccccccccccccccccccccccc);
        jPanel15ccccccccccccccccccccccc.setLayout(jPanel15cccccccccccccccccccccccLayout);
        jPanel15cccccccccccccccccccccccLayout.setHorizontalGroup(
            jPanel15cccccccccccccccccccccccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel15cccccccccccccccccccccccLayout.setVerticalGroup(
            jPanel15cccccccccccccccccccccccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        jPanel43.add(jPanel15ccccccccccccccccccccccc, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, -5, 160, 410));

        jLabeluserID.setText("userid");
        jPanel43.add(jLabeluserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 91, 91, 31));

        jLabelFrom_data.setText("from_data");
        jPanel43.add(jLabelFrom_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 11, 61, 31));

        jLabelby_data.setText("By_data");
        jPanel43.add(jLabelby_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 11, 91, 31));

        jLabelto_data.setText("to_data");
        jPanel43.add(jLabelto_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 11, 123, 31));

        jLabelPurpose_data.setText("Purpose");
        jPanel43.add(jLabelPurpose_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 11, 91, 31));

        jLabeltype_data.setText("TypeDAta");
        jPanel43.add(jLabeltype_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 11, 95, 31));

        jLabelTo_data.setText("tatus");
        jPanel43.add(jLabelTo_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 100, 91, 31));

        jLabelDetail_data.setText("Detals");
        jPanel43.add(jLabelDetail_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 11, 121, 31));

        jLabeltracking_data.setText("tracking_data");
        jPanel43.add(jLabeltracking_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 91, 31));

        jLabelForwarded.setText("Forwarded");
        jPanel43.add(jLabelForwarded, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 179, 95, 31));

        jLabelstatus.setText("Received");
        jPanel43.add(jLabelstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 11, 89, 31));

        jLabelTrackingFK.setText("trackingNumber");
        jPanel43.add(jLabelTrackingFK, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 88, 88, 20));

        jLabelGetTrackingID.setText("transactiongetTracdata");
        jPanel43.add(jLabelGetTrackingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, -1, 20));

        jLabelStatus.setText("incoSta");
        jPanel43.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 134, 70, -1));

        jLabelSubmitedto.setText("subto");
        jPanel43.add(jLabelSubmitedto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 279, 143, 20));

        jLabelField.setForeground(new java.awt.Color(255, 51, 51));
        jLabelField.setText("field");
        jPanel43.add(jLabelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 91, 53, -1));

        jLabelSSID.setForeground(new java.awt.Color(51, 51, 255));
        jLabelSSID.setText("0");
        jPanel43.add(jLabelSSID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 317, 48, 22));

        jLabelView.setText("Ongoing");
        jPanel43.add(jLabelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 366, 162, 20));

        jLabelPermission.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPermission.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelPermission.setForeground(new java.awt.Color(0, 153, 0));
        jLabelPermission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPermission.setText("(Employee)");
        jPanel43.add(jLabelPermission, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 85, 121, 25));

        jLabelTracingID.setText("get Gracing id");
        jPanel43.add(jLabelTracingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 91, -1, -1));

        jLabelFrom.setText("from");
        jPanel43.add(jLabelFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 83, 61, 31));

        jLabelpendingdetails.setText("PendingDetails");
        jPanel43.add(jLabelpendingdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 81, 72, 35));

        jTabbedPane1.addTab("tab11", jPanel43);

        jPanel10.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 1060, 590));

        jPanel7.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAVAO ORIENTAL STATE UNIVERSITY");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Person_48px.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Jonathan Cabrera");

        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/icons8_Exit_22px.png"))); // NOI18N
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Log-out");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 627, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addGap(70, 70, 70))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel10.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 1060, 10));

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 250, 10));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Person_48px.png"))); // NOI18N
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 50, 51));

        jLabelUsername.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("dfkdfkdjfkdjfkd");
        jPanel8.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Logged in");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jTextFieldTracking.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTracking.setText("Tracking number here");
        jTextFieldTracking.setToolTipText("Tracking number");
        jTextFieldTracking.setDisabledTextColor(new java.awt.Color(0, 153, 0));
        jTextFieldTracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTrackingActionPerformed(evt);
            }
        });
        jPanel8.add(jTextFieldTracking, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, 33));

        jLabelTransactionHistoryMenuNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelTransactionHistoryMenuNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelTransactionHistoryMenuNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTransactionHistoryMenuNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTransactionHistoryMenuNumber.setText("0");
        jPanel8.add(jLabelTransactionHistoryMenuNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 40, 20));

        jLabelTransactionHistoryMenuCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTransactionHistoryMenuCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelTransactionHistoryMenuCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTransactionHistoryMenuCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel8.add(jLabelTransactionHistoryMenuCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 40));

        jLabelTrackingPageMenuNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelTrackingPageMenuNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelTrackingPageMenuNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTrackingPageMenuNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTrackingPageMenuNumber.setText("0");
        jPanel8.add(jLabelTrackingPageMenuNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 40, 20));

        jLabelTrackingPageMenuCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTrackingPageMenuCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelTrackingPageMenuCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTrackingPageMenuCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel8.add(jLabelTrackingPageMenuCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 40, 40));

        jButtonTransactionHistoryV.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonTransactionHistoryV.setForeground(new java.awt.Color(51, 51, 51));
        jButtonTransactionHistoryV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/viewDocument.png"))); // NOI18N
        jButtonTransactionHistoryV.setText("Transaction History");
        jButtonTransactionHistoryV.setAlignmentY(0.0F);
        jButtonTransactionHistoryV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonTransactionHistoryV.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jButtonTransactionHistoryV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionHistoryVActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonTransactionHistoryV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 190, 40));

        jButtonHomeV.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonHomeV.setForeground(new java.awt.Color(51, 51, 51));
        jButtonHomeV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/home.png"))); // NOI18N
        jButtonHomeV.setText("Home");
        jButtonHomeV.setAlignmentY(0.0F);
        jButtonHomeV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonHomeV.setMargin(new java.awt.Insets(2, 30, 2, 1));
        jButtonHomeV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeVActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonHomeV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, 40));

        jButtonTrackingPageV.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonTrackingPageV.setForeground(new java.awt.Color(51, 51, 51));
        jButtonTrackingPageV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/ViewDetails.png"))); // NOI18N
        jButtonTrackingPageV.setText("Tracking Page");
        jButtonTrackingPageV.setAlignmentY(0.0F);
        jButtonTrackingPageV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonTrackingPageV.setMargin(new java.awt.Insets(2, 30, 2, 1));
        jButtonTrackingPageV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrackingPageVActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonTrackingPageV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 190, 40));
        jPanel8.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 250, 10));

        jLabelIncomingMenuNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelIncomingMenuNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelIncomingMenuNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIncomingMenuNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIncomingMenuNumber.setText("0");
        jPanel8.add(jLabelIncomingMenuNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 40, 20));

        jLabelIncomingMenuCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelIncomingMenuCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelIncomingMenuCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIncomingMenuCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel8.add(jLabelIncomingMenuCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 40, 40));

        jLabelPendingMenuNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelPendingMenuNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelPendingMenuNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPendingMenuNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPendingMenuNumber.setText("0");
        jPanel8.add(jLabelPendingMenuNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 40, 20));

        jLabelPendingMenuCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelPendingMenuCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelPendingMenuCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPendingMenuCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel8.add(jLabelPendingMenuCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 40, 40));

        jLabelOutgoingMenuNumber.setBackground(new java.awt.Color(0, 102, 153));
        jLabelOutgoingMenuNumber.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabelOutgoingMenuNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOutgoingMenuNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOutgoingMenuNumber.setText("0");
        jPanel8.add(jLabelOutgoingMenuNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 40, 20));

        jLabelOutgoingMenuCircle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelOutgoingMenuCircle.setForeground(new java.awt.Color(0, 102, 0));
        jLabelOutgoingMenuCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOutgoingMenuCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/red Moon_32px.png"))); // NOI18N
        jPanel8.add(jLabelOutgoingMenuCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 40, 40));

        jButtonOutgoingMenu.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonOutgoingMenu.setForeground(new java.awt.Color(51, 51, 51));
        jButtonOutgoingMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Outgoing Data_22px.png"))); // NOI18N
        jButtonOutgoingMenu.setText("Outgoing");
        jButtonOutgoingMenu.setAlignmentY(0.0F);
        jButtonOutgoingMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonOutgoingMenu.setMargin(new java.awt.Insets(2, 30, 2, 1));
        jButtonOutgoingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutgoingMenuActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonOutgoingMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 190, 40));

        jButtonPendingMenu.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonPendingMenu.setForeground(new java.awt.Color(51, 51, 51));
        jButtonPendingMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Pending_22px.png"))); // NOI18N
        jButtonPendingMenu.setText("Pending");
        jButtonPendingMenu.setAlignmentY(0.0F);
        jButtonPendingMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonPendingMenu.setMargin(new java.awt.Insets(2, 30, 2, 1));
        jButtonPendingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPendingMenuActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonPendingMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 190, 40));

        jButtonIncomingMenu.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonIncomingMenu.setForeground(new java.awt.Color(51, 51, 51));
        jButtonIncomingMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Incoming.png"))); // NOI18N
        jButtonIncomingMenu.setText("Incoming");
        jButtonIncomingMenu.setAlignmentY(0.0F);
        jButtonIncomingMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonIncomingMenu.setMargin(new java.awt.Insets(2, 30, 2, 1));
        jButtonIncomingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncomingMenuActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonIncomingMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, 40));

        jPanel10.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 600));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Document tracking system version 1.0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Copyright 2019 DOrSU all right reserve ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 867, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(67, 67, 67))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1366, 766));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        try {
            if (log == null || log.isClosed()) {
                LogInPage home = new LogInPage();
                home.setVisible(true);
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonLogoutActionPerformed


    private void jTextFieldTrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTrackingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTrackingActionPerformed

    private void jButtonTransactionHistoryVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionHistoryVActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(false);

        jLabelTrackingPageMenuCircle.setVisible(true);
        jLabelTrackingPageMenuNumber.setVisible(true);
        jLabelTransactionHistoryMenuNumber.setVisible(true);
        jLabelTransactionHistoryMenuCircle.setVisible(true);
        pendingNumberNotify();
        OutgoingNumberNotify();
        incomingNumberNotify();
        trackingHistoryDisplayTable();
        trackingHistoryNum();
        numRowTrackingPagr();
        trackingPageTable();
        notifyNumber();
    }//GEN-LAST:event_jButtonTransactionHistoryVActionPerformed

    private void jButtonHomeVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeVActionPerformed

        jTabbedPane1.setSelectedIndex(0);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(false);
        jButtonIncomingMenu.setEnabled(false);
        jButtonPendingMenu.setEnabled(false);
        jButtonOutgoingMenu.setEnabled(false);
        jButtonTrackingPageV.setEnabled(false);
        jButtonTransactionHistoryV.setEnabled(false);

        jLabelIncomingMenuNumber.setVisible(false);
        jLabelIncomingMenuCircle.setVisible(false);
        jLabelPendingMenuNumber.setVisible(false);
        jLabelPendingMenuCircle.setVisible(false);
        jLabelOutgoingMenuNumber.setVisible(false);
        jLabelOutgoingMenuCircle.setVisible(false);
        jLabelTrackingPageMenuNumber.setVisible(false);
        jLabelTrackingPageMenuCircle.setVisible(false);
        jLabelTransactionHistoryMenuNumber.setVisible(false);
        jLabelTransactionHistoryMenuCircle.setVisible(false);

        pendingNumberNotify();
        OutgoingNumberNotify();
        incomingNumberNotify();
        trackingHistoryNum();
        numRowTrackingPagr();
        notifyNumber();
        ///
        ///
    }//GEN-LAST:event_jButtonHomeVActionPerformed

    private void jButtonTrackingPageVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrackingPageVActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(false);
        jButtonTransactionHistoryV.setEnabled(true);
        pendingNumberNotify();
        OutgoingNumberNotify();
        incomingNumberNotify();
        numRowTrackingPagr();
        trackingPageTable();
        notifyNumber();
    }//GEN-LAST:event_jButtonTrackingPageVActionPerformed

    private void jButtonOutgoingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutgoingMenuActionPerformed
        jTabbedPane1.setSelectedIndex(6);

        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(false);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(true);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jLabelIncomingMenuCircle.setEnabled(true);
        jLabelPendingMenuCircle.setEnabled(true);
        jLabelOutgoingMenuCircle.setEnabled(true);
        jLabelOutgoingMenuNumber.setVisible(false);
        jLabelOutgoingMenuCircle.setVisible(false);
        OutgoingisplayTable();
        incomingNumberNotify();
        pendingNumberNotify();
        OutgoingNumberNotify();
        trackingHistoryNum();
        numRowTrackingPagr();
        notifyNumber();
    }//GEN-LAST:event_jButtonOutgoingMenuActionPerformed

    private void jButtonPendingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPendingMenuActionPerformed
        jTabbedPane1.setSelectedIndex(5);

        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(false);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(true);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jLabelIncomingMenuCircle.setEnabled(true);
        jLabelPendingMenuCircle.setEnabled(true);
        jLabelOutgoingMenuCircle.setEnabled(true);
        jLabelPendingMenuNumber.setVisible(false);
        jLabelPendingMenuCircle.setVisible(false);
        PendingDisplayTable();
        pendingNumberNotify();
        OutgoingNumberNotify();
        incomingNumberNotify();
        trackingHistoryNum();
        numRowTrackingPagr();
        notifyNumber();
    }//GEN-LAST:event_jButtonPendingMenuActionPerformed

    private void jButtonIncomingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncomingMenuActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        jLabelIncomingMenuNumber.setVisible(false);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(false);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(true);

        jLabelIncomingMenuCircle.setEnabled(true);
        jLabelPendingMenuCircle.setEnabled(true);
        jLabelOutgoingMenuCircle.setEnabled(true);
        jLabelIncomingMenuNumber.setVisible(false);
        jLabelIncomingMenuCircle.setVisible(false);
        IncomingDisplayTable();
        pendingNumberNotify();
        OutgoingNumberNotify();
        incomingNumberNotify();
        trackingHistoryNum();
        numRowTrackingPagr();
        notifyNumber();
    }//GEN-LAST:event_jButtonIncomingMenuActionPerformed

    private void jButtonPendingAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPendingAcceptActionPerformed

    }//GEN-LAST:event_jButtonPendingAcceptActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        searchPending();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonIncomingAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncomingAcceptActionPerformed
        jButtonIncomingAccept.setEnabled(false);
        saveToIncomingList();
        saveToViewdetailsFromIncoming();
        saveToPending();
        SaveToOutGoingList();
        updateTracingPage();
        deleteIncoming();
        deleteOutgoing();
        IncomingDisplayTable();
        pendingNumberNotify();
        incomingNumberNotify();
        OutgoingNumberNotify();
        notifyNumber();
    }//GEN-LAST:event_jButtonIncomingAcceptActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        viewDetailsReport();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        trackingHistoryDisplayTable();
        jTabbedPane1.setSelectedIndex(2);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonTransactionHistoryViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionHistoryViewDetailsActionPerformed
        // TODO add your handling code here:
        ViewDetails();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButtonTransactionHistoryViewDetailsActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        trackingHistoryDisplayTable();
        jButtonTransactionHistoryViewDetails.setEnabled(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        trackingPageTable();
        notifyNumber();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        searchTrackingPage();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonOutgoingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutgoingActionPerformed
        jTabbedPane1.setSelectedIndex(6);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(false);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(true);
        OutgoingisplayTable();
        incomingNumberNotify();
        pendingNumberNotify();
        OutgoingNumberNotify();
        numRowTrackingPagr();
        trackingHistoryNum();
        notifyNumber();
    }//GEN-LAST:event_jButtonOutgoingActionPerformed

    private void jButtonPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPendingActionPerformed
        jTabbedPane1.setSelectedIndex(5);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(false);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(true);
        jLabelPendingMenuNumber.setVisible(true);
        jButtonTransactionHistoryV.setEnabled(true);
        IncomingDisplayTable();
        PendingDisplayTable();
        pendingNumberNotify();
        incomingNumberNotify();
        OutgoingNumberNotify();
        numRowTrackingPagr();
        trackingHistoryNum();
        notifyNumber();
    }//GEN-LAST:event_jButtonPendingActionPerformed

    private void jButtonIncomingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncomingActionPerformed

        jTabbedPane1.setSelectedIndex(4);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(false);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(true);
        IncomingDisplayTable();
//        saveToViewdetailsFromIncoming();
        incomingNumberNotify();
        pendingNumberNotify();
        OutgoingNumberNotify();
        numRowTrackingPagr();
        trackingHistoryNum();
        notifyNumber();
    }//GEN-LAST:event_jButtonIncomingActionPerformed

    private void jButtonTrackingPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrackingPageActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(false);
        jButtonTransactionHistoryV.setEnabled(true);
        incomingNumberNotify();
        pendingNumberNotify();
        OutgoingNumberNotify();
        numRowTrackingPagr();
        trackingPageTable();
        trackingHistoryNum();
        notifyNumber();
    }//GEN-LAST:event_jButtonTrackingPageActionPerformed

    private void jButtonTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionHistoryActionPerformed

        jTabbedPane1.setSelectedIndex(2);
        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonHomeV.setEnabled(true);
        jButtonIncomingMenu.setEnabled(true);
        jButtonPendingMenu.setEnabled(true);
        jButtonOutgoingMenu.setEnabled(true);
        jButtonTrackingPageV.setEnabled(true);
        jButtonTransactionHistoryV.setEnabled(false);
        trackingHistoryDisplayTable();
        incomingNumberNotify();
        pendingNumberNotify();
        OutgoingNumberNotify();
        trackingHistoryNum();
        trackingPageTable();
        numRowTrackingPagr();
        notifyNumber();
    }//GEN-LAST:event_jButtonTransactionHistoryActionPerformed

    private void jComboBoxDocTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDocTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDocTypeActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if (jCheckBox1.isSelected()) {
            jComboBoxDocType.setEditable(true);
        } else {
            jComboBoxDocType.setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextFieldFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFromActionPerformed

    }//GEN-LAST:event_jTextFieldFromActionPerformed
    PrintTrackingNumber reg;
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed

        submit();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonTransactionHistoryViewDetails4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionHistoryViewDetails4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTransactionHistoryViewDetails4ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jTabbedPane1.setSelectedIndex(9);
        jButtonOutgoingMenu.setEnabled(true);
        OutgoingListDisplayTable();
        // jButtonOutgoingMenu.setEnabled(true);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
        jButtonIncomingMenu.setEnabled(true);
        IncomingListDisplayTable();
//        jButtonIncomingV.setEnabled(true);
//        jTabbedPane.setSelectedIndex(4);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        jTabbedPane1.setSelectedIndex(8);
        jButtonPendingMenu.setEnabled(true);
        PendingListDisplayTable();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButtonincommingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonincommingListActionPerformed

        incominglistReport();

    }//GEN-LAST:event_jButtonincommingListActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        IncomingListDisplayTable();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        pendingListReport();

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        PendingListDisplayTable();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        outgoingListReport();

    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        OutgoingListDisplayTable();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        IncomingDisplayTable();
        jButtonIncomingAccept.setEnabled(false);

    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        OutgoingNumberNotify();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jComboBoxTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTransactionHistoryActionPerformed
        trackingHistoryDisplayFiltTable();
    }//GEN-LAST:event_jComboBoxTransactionHistoryActionPerformed

    private void jComboBoxPendingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPendingListActionPerformed
        // TODO add your handling code here:
        pendingListDisplayFiltTable();
    }//GEN-LAST:event_jComboBoxPendingListActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        PendingDisplayTable();
        jButtonPendingAccept.setEnabled(false);
        pendingNumberNotify();
        incomingNumberNotify();
        OutgoingNumberNotify();
        notifyNumber();
        jTablePending.setEnabled(true);

    }//GEN-LAST:event_jButton32ActionPerformed

    private void jComboBoxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFieldActionPerformed
        // TODO add your handling code here:
        jButtonSubmit.setEnabled(true);
    }//GEN-LAST:event_jComboBoxFieldActionPerformed

    private void jTextFieldTrackingPageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTrackingPageKeyPressed
        searchTrackingPage();
    }//GEN-LAST:event_jTextFieldTrackingPageKeyPressed

    private void jTextFieldTrackingPageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTrackingPageKeyTyped
        // TODO add your handling code here:
        searchTrackingPage();
    }//GEN-LAST:event_jTextFieldTrackingPageKeyTyped

    private void jTextFieldTrackingPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTrackingPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTrackingPageActionPerformed

    private void jButtonIncomingPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncomingPActionPerformed
        // TODO add your handling code here:
        searchIncoming();
    }//GEN-LAST:event_jButtonIncomingPActionPerformed

    private void jTextFieldIncomingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIncomingKeyReleased
        // TODO add your handling code here:
        searchIncoming();
    }//GEN-LAST:event_jTextFieldIncomingKeyReleased

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        searchIncomingList();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextFieldIncomingListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIncomingListKeyReleased
        // TODO add your handling code here:
        searchIncomingList();
    }//GEN-LAST:event_jTextFieldIncomingListKeyReleased

    private void jTextFieldPendingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPendingKeyReleased
        searchPending();        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldPendingKeyReleased

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        searchoutgoing();        // TODO add your handling code here:

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTextFielOutgoingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielOutgoingKeyReleased

        searchoutgoing();// TODO add your handling code here:
    }//GEN-LAST:event_jTextFielOutgoingKeyReleased

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        searchoutgoingList();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextFieldoutgoingListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldoutgoingListKeyReleased
        searchoutgoingList();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldoutgoingListKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        searchTransactionHistory();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldTracnsacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTracnsacKeyReleased
        searchTransactionHistory();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTracnsacKeyReleased

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        searchPendingList();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jTextFieldPendingListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPendingListKeyReleased
        searchPendingList();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPendingListKeyReleased

    private void jComboBoxPermissionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxPermissionKeyReleased
        if (evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER) {
            submit();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPermissionKeyReleased

    private void jTablePendingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePendingKeyReleased
        if (evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER) {

            PendingDisplayTable();
            jButtonPendingAccept.setEnabled(false);

            jTablePending.setEnabled(true);
            pendingNumberNotify();
            OutgoingNumberNotify();
            incomingNumberNotify();
            numRowTrackingPagr();
            trackingHistoryNum();
            notifyNumber();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTablePendingKeyReleased

    private void jTablePendingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePendingKeyPressed
        if (evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER) {

            PendingDisplayTable();
            jButtonPendingAccept.setEnabled(false);

            jTablePending.setEnabled(true);
            pendingNumberNotify();
            OutgoingNumberNotify();
            incomingNumberNotify();
            numRowTrackingPagr();
            trackingHistoryNum();
            notifyNumber();
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jTablePendingKeyPressed

    private void jTablePendingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePendingMouseReleased

    }//GEN-LAST:event_jTablePendingMouseReleased

    private void jTablePendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePendingMouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePendingMouseExited
    LogInPage log;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonHomeV;
    private javax.swing.JButton jButtonIncoming;
    private javax.swing.JButton jButtonIncomingAccept;
    private javax.swing.JButton jButtonIncomingMenu;
    private javax.swing.JButton jButtonIncomingP;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonOutgoing;
    private javax.swing.JButton jButtonOutgoingMenu;
    private javax.swing.JButton jButtonPending;
    private javax.swing.JButton jButtonPendingAccept;
    private javax.swing.JButton jButtonPendingMenu;
    public javax.swing.JButton jButtonSubmit;
    private javax.swing.JButton jButtonTrackingPage;
    private javax.swing.JButton jButtonTrackingPageV;
    private javax.swing.JButton jButtonTransactionHistory;
    private javax.swing.JButton jButtonTransactionHistoryV;
    private javax.swing.JButton jButtonTransactionHistoryViewDetails;
    private javax.swing.JButton jButtonTransactionHistoryViewDetails4;
    private javax.swing.JButton jButtonincommingList;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBoxDocType;
    public javax.swing.JComboBox<String> jComboBoxField;
    private javax.swing.JComboBox<String> jComboBoxPendingList;
    public javax.swing.JComboBox<String> jComboBoxPermission;
    private javax.swing.JComboBox<String> jComboBoxTransactionHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDetail_data;
    public javax.swing.JLabel jLabelField;
    private javax.swing.JLabel jLabelForwarded;
    private javax.swing.JLabel jLabelFrom;
    private javax.swing.JLabel jLabelFrom_data;
    private javax.swing.JLabel jLabelGetTrackingID;
    public javax.swing.JLabel jLabelIncomingCircle;
    public javax.swing.JLabel jLabelIncomingMenuCircle;
    public javax.swing.JLabel jLabelIncomingMenuNumber;
    public javax.swing.JLabel jLabelIncomingNumber;
    public javax.swing.JLabel jLabelOutgoingCircle;
    public javax.swing.JLabel jLabelOutgoingMenuCircle;
    public javax.swing.JLabel jLabelOutgoingMenuNumber;
    public javax.swing.JLabel jLabelOutgoingNumber;
    public javax.swing.JLabel jLabelPendingCircle;
    public javax.swing.JLabel jLabelPendingMenuCircle;
    public javax.swing.JLabel jLabelPendingMenuNumber;
    public javax.swing.JLabel jLabelPendingNumber;
    public javax.swing.JLabel jLabelPermission;
    private javax.swing.JLabel jLabelPurpose_data;
    public javax.swing.JLabel jLabelSSID;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubmitedto;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelTo_data;
    private javax.swing.JLabel jLabelTracingID;
    private javax.swing.JLabel jLabelTrackingFK;
    public javax.swing.JLabel jLabelTrackingPageCircle;
    private javax.swing.JLabel jLabelTrackingPageMenuCircle;
    private javax.swing.JLabel jLabelTrackingPageMenuNumber;
    public javax.swing.JLabel jLabelTransactionHistoryCircle;
    private javax.swing.JLabel jLabelTransactionHistoryMenuCircle;
    private javax.swing.JLabel jLabelTransactionHistoryMenuNumber;
    public javax.swing.JLabel jLabelTransactionHistoryNumber;
    public javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelView;
    private javax.swing.JLabel jLabelby_data;
    private javax.swing.JLabel jLabelpendingdetails;
    private javax.swing.JLabel jLabelstatus;
    private javax.swing.JLabel jLabelto_data;
    public javax.swing.JLabel jLabeltrackingPageNumber;
    private javax.swing.JLabel jLabeltracking_data;
    private javax.swing.JLabel jLabeltype_data;
    private javax.swing.JLabel jLabeluserID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15ccccccccccccccccccccccc;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableIncoming;
    private javax.swing.JTable jTableIncomingList;
    private javax.swing.JTable jTableOutgoing;
    private javax.swing.JTable jTableOutgoingList;
    private javax.swing.JTable jTablePending;
    private javax.swing.JTable jTablePendingList;
    private javax.swing.JTable jTableTransactionHistory;
    private javax.swing.JTable jTableViewdetails;
    private javax.swing.JTable jTabletracking;
    private javax.swing.JTextArea jTextAreaDetails;
    private javax.swing.JTextArea jTextAreaPurpose;
    private javax.swing.JTextField jTextFielOutgoing;
    public javax.swing.JTextField jTextFieldBy;
    public javax.swing.JTextField jTextFieldFrom;
    private javax.swing.JTextField jTextFieldIncoming;
    private javax.swing.JTextField jTextFieldIncomingList;
    private javax.swing.JTextField jTextFieldPending;
    private javax.swing.JTextField jTextFieldPendingList;
    private javax.swing.JTextField jTextFieldTracking;
    private javax.swing.JTextField jTextFieldTrackingPage;
    private javax.swing.JTextField jTextFieldTracnsac;
    private javax.swing.JTextField jTextFieldoutgoingList;
    // End of variables declaration//GEN-END:variables
    public void sub() {

        jComboBoxField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    /////////////
                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Send to All")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("For Everyone");
                        jComboBoxPermission.setEnabled(false);
                    }
                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("School President")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("President");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Academic")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Vice-President for Academic Affairs");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Administrative")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Vice-President for Administrative");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Office of College Council")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);
                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                        jComboBoxPermission.addItem("Quality of Management Office");
                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
                        jComboBoxPermission.addItem("Public Information Officer");
                        jComboBoxPermission.addItem("Executive Assistant to the President");
                        jComboBoxPermission.addItem("Director for Planning and Development");
                        jComboBoxPermission.addItem("Office of Infrastructure Committee");
                        jComboBoxPermission.addItem("Office of Management Information System");

                    }

                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("School President")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("President");
                        jComboBoxPermission.setEnabled(false);

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Reseach Development and Extension")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Administrative")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Vice-President for Administrative");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Office of College Council")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);
                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                        jComboBoxPermission.addItem("Quality of Management Office");
                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
                        jComboBoxPermission.addItem("Public Information Officer");
                        jComboBoxPermission.addItem("Executive Assistant to the President");
                        jComboBoxPermission.addItem("Director for Planning and Development");
                        jComboBoxPermission.addItem("Office of Infrastructure Committee");
                        jComboBoxPermission.addItem("Office of Management Information System");

                    }

                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("School President")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("President");
                        jComboBoxPermission.setEnabled(false);

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Reseach Development and Extension")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Academic")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Vice-President for Academic Affairs");
                        jComboBoxPermission.setEnabled(false);
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Office of College Council")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);
                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                        jComboBoxPermission.addItem("Head of Quality of Management Office");
                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
                        jComboBoxPermission.addItem("Public Information Officer");
                        jComboBoxPermission.addItem("Executive Assistant to the President");
                        jComboBoxPermission.addItem("Director for Planning and Development");
                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
                        jComboBoxPermission.addItem("Head of Management Information System");

                    }
                    ////////////////
                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Academic ")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Head of ICE");
                        jComboBoxPermission.addItem("Head of IALS");
                        jComboBoxPermission.addItem("Head of IBPA");
                        jComboBoxPermission.addItem("Head of IETT");

                        jComboBoxPermission.addItem("Office of FASST");
                        jComboBoxPermission.addItem("Office of Health Service Unit");
                        jComboBoxPermission.addItem("Office of GCTC");
                        jComboBoxPermission.addItem("Sports Development Office");
                        jComboBoxPermission.addItem("Officed of TLR-AEC/QAD");
                        jComboBoxPermission.addItem("Registrar Office");
                        jComboBoxPermission.addItem("Office of Student and Affairs");

                        jComboBoxPermission.addItem("Dean of IALS");
                        jComboBoxPermission.addItem("Dean of IBPA");
                        jComboBoxPermission.addItem("Dean of ICE");
                        jComboBoxPermission.addItem("Dean of IETT");

                        jComboBoxPermission.addItem("Graduate School Coordinator");
                        jComboBoxPermission.addItem("Coordinator of NSTP");
                        jComboBoxPermission.addItem("Director for Instructor");
                        jComboBoxPermission.addItem("Director for Student Service");
                        jComboBoxPermission.addItem("SHS Administrator");
                        jComboBoxPermission.addItem("College Librarian");

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Administrative ")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Office of Director for Administration Services");
                        jComboBoxPermission.addItem("Office of Internal Control Unit");
                        jComboBoxPermission.addItem("Accounting Office");
                        jComboBoxPermission.addItem("Budget Office");
                        jComboBoxPermission.addItem("Cashier Office");
                        jComboBoxPermission.addItem("Procurement Office");
                        jComboBoxPermission.addItem("Office of HRMD");
                        jComboBoxPermission.addItem("Office of Supply and Property Unit");
                        jComboBoxPermission.addItem("Office of ITSU");
                        jComboBoxPermission.addItem("Office of General Service Unit");
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Research Development and Extension ")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("Journal and Publication Office");
                        jComboBoxPermission.addItem("Office of Monitoring and Evaluation Unit");
                        jComboBoxPermission.addItem("Office of Reseach and Development");
                        jComboBoxPermission.addItem("Director for Extension");
                        jComboBoxPermission.addItem("Office of CAAD");
                        jComboBoxPermission.addItem("Director of Cooperative Development Center");
                        jComboBoxPermission.addItem("Director of Gender and Development Center");
                        jComboBoxPermission.addItem("Director of Provincial Institute of Agriculture");
                        jComboBoxPermission.addItem("Director of Sentro ng Wika at Kultura");
                        jComboBoxPermission.addItem("Director of RAC XI");
                        jComboBoxPermission.addItem("Director of TIEC Center");
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("College Council ")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                        jComboBoxPermission.addItem("Quality of Management Office");
                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
                        jComboBoxPermission.addItem("Public Information Officer");
                        jComboBoxPermission.addItem("Executive Assistant to the President");
                        jComboBoxPermission.addItem("Director for Planning and Development");
                        jComboBoxPermission.addItem("Office of Infrastructure Committee");
                        jComboBoxPermission.addItem("Office of Management Information System");

                    }
                    /////////////
                    if (("Head of ICE".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Head of ICE");
                    } else {
                        jComboBoxPermission.addItem("Head of ICE");
                    }
                    if (("Head of IALS".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Head of IALS");
                    } else {
                        jComboBoxPermission.addItem("Head of IALS");
                    }
                    if (("Head of IBPA".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Head of IBPA");
                    } else {
                        jComboBoxPermission.addItem("Head of IBPA");
                    }
                    if (("Head of IETT".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Head of IETT");
                    } else {
                        jComboBoxPermission.addItem("Head of IETT");
                    }
                    if (("President of DOSCST Alumni Association".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("President of DOSCST Alumni Association");
                    } else {
                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                    }
                    if (("Quality of Management Office".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Quality of Management Office");
                    } else {
                        jComboBoxPermission.addItem("Quality of Management Office");
                    }
                    if (("Office of Entrepreneurship and Management Officer".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Office of Entrepreneurship and Management Officer");
                    } else {
                        jComboBoxPermission.addItem("Office of Entrepreneurship and Management Officer");
                    }
                    if (("Office of Public Information Officer".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Office of Public Information Officer");
                    } else {
                        jComboBoxPermission.addItem("Office of Public Information Officer");
                    }
                    if (("Executive Assistant to the President".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Executive Assistant to the President");
                    } else {
                        jComboBoxPermission.addItem("Executive Assistant to the President");
                    }
                    if (("Director for Planning and Development".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Director for Planning and Development");
                    } else {
                        jComboBoxPermission.addItem("Director for Planning and Development");
                    }
                    if (("Office of Infrastructure Committee".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Office of Infrastructure Committee");
                    } else {
                        jComboBoxPermission.addItem("Office of Infrastructure Committee");
                    }
                    if (("Office of Management Information System".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Office of Management Information System");
                    } else {
                        jComboBoxPermission.addItem("Office of Management Information System");
                    }
                    if (("Office of Management Information System".equals(jLabelPermission.getText()))) {
                        jComboBoxPermission.removeItem("Office of Management Information System");
                    } else {
                        jComboBoxPermission.addItem("Office of Management Information System");
                    }
                    ////////////////
                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Academic")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);
                        jComboBoxPermission.addItem("Head of ICE");
                        jComboBoxPermission.addItem("Head of IALS");
                        jComboBoxPermission.addItem("Head of IBPA");
                        jComboBoxPermission.addItem("Head of IETT");

                        if (("Dean of IALS".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Dean of IALS");

                            jComboBoxPermission.removeItem("Head of IALS");
                            jComboBoxPermission.removeItem("Head of IBPA");
                            jComboBoxPermission.removeItem("Head of ICE");
                            jComboBoxPermission.removeItem("Head of IETT");
                        } else {
                            jComboBoxPermission.addItem("Dean of IALS");
                        }
                        if (("Dean of IBPA".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Dean of IBPA");

                            jComboBoxPermission.removeItem("Head of IALS");
                            jComboBoxPermission.removeItem("Head of IBPA");
                            jComboBoxPermission.removeItem("Head of ICE");
                            jComboBoxPermission.removeItem("Head of IETT");
                        } else {
                            jComboBoxPermission.addItem("Dean of IBPA");
                        }
                        if (("Dean of ICE".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Dean of ICE");

                            jComboBoxPermission.removeItem("Head of IALS");
                            jComboBoxPermission.removeItem("Head of IBPA");
                            jComboBoxPermission.removeItem("Head of ICE");
                            jComboBoxPermission.removeItem("Head of IETT");
                        } else {
                            jComboBoxPermission.addItem("Dean of ICE");
                        }
                        if (("Dean of IETT".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Dean of IETT");

                            jComboBoxPermission.removeItem("Head of IALS");
                            jComboBoxPermission.removeItem("Head of IBPA");
                            jComboBoxPermission.removeItem("Head of ICE");
                            jComboBoxPermission.removeItem("Head of IETT");
                        } else {
                            jComboBoxPermission.addItem("Dean of IETT");
                        }

                        if (("Office of FASST".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of FASST");
                        } else {
                            jComboBoxPermission.addItem("Office of FASST");
                        }
                        if (("Office of Health Service Unit".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Health Service Unit");
                        } else {
                            jComboBoxPermission.addItem("Office of Health Service Unit");
                        }
                        if (("Office of GCTC".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of GCTC");
                        } else {
                            jComboBoxPermission.addItem("Office of GCTC");
                        }
                        if (("Sports Development Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Sports Development Office");
                        } else {
                            jComboBoxPermission.addItem("Sports Development Office");
                        }
                        if (("Office of TLR-AEC/QAD".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of TLR-AEC/QAD");
                        } else {
                            jComboBoxPermission.addItem("Office of TLR-AEC/QAD");
                        }
                        if (("Registrar Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Registrar Office");
                        } else {
                            jComboBoxPermission.addItem("Registrar Office");
                        }
                        if (("Office of Student and Affairs".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Student and Affairs");
                        } else {
                            jComboBoxPermission.addItem("Office of Student and Affairs");
                        }
                        if (("Office of Graduate School Coordinator".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Graduate School Coordinator");
                        } else {
                            jComboBoxPermission.addItem("Office of Graduate School Coordinator");
                        }
                        if (("Office of Coordinator of NSTP".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Coordinator of NSTP");
                        } else {
                            jComboBoxPermission.addItem("Office of Coordinator of NSTP");
                        }
                        if (("Office of Director for Instructor".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director for Instructor");
                        } else {
                            jComboBoxPermission.addItem("Office of Director for Instructor");
                        }
                        if (("Office of Director for Student Service".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Director for Student Service");
                        } else {
                            jComboBoxPermission.addItem("Office of Director for Student Service");
                        }
                        if (("Office of SHS Administrator".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of SHS Administrator");
                        } else {
                            jComboBoxPermission.addItem("Office of SHS Administrator");
                        }
                        if (("College of Librarian".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of College Librarian");
                        } else {
                            jComboBoxPermission.addItem("Office of College Librarian");
                        }

                        if (("Vice-President for Academic Affairs".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Vice-President for Academic Affairs");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Vice-President for Academic Affairs");
                        }
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Administrative")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);
                        if (("Office of ITSU".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of ITSU");
                        } else {
                            jComboBoxPermission.addItem("Office of ITSU");
                        }
                        if (("Office of Internal Control Unit".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Internal Control Unit");
                        } else {
                            jComboBoxPermission.addItem("Office of Internal Control Unit");
                        }
                        if (("Office of Director for Administration Services".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Director for Administration Services");
                        } else {
                            jComboBoxPermission.addItem("Office of Director for Administration Services");
                        }
                        
                        if (("Accounting Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Accounting Office");
                        } else {
                            jComboBoxPermission.addItem("Accounting Office");
                        }
                        if (("Budget Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Budget Office");
                        } else {
                            jComboBoxPermission.addItem("Budget Office");
                        }
                        if (("Cashier Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Cashier Office");
                        } else {
                            jComboBoxPermission.addItem("Cashier Office");
                        }
                        if (("Procurement Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Procurement Office");
                        } else {
                            jComboBoxPermission.addItem("Procurement Office");
                        }
                        if (("Office of HRMD".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of HRMD");
                        } else {
                            jComboBoxPermission.addItem("Office of HRMD");
                        }
                        if (("Office of Supply and Property Unit".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Supply and Property Unit");
                        } else {
                            jComboBoxPermission.addItem("Office of Supply and Property Unit");
                        }
                        if (("Office of General Service Unit".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of General Service Unit");
                        } else {
                            jComboBoxPermission.addItem("Office of General Service Unit");
                        }
                        if (("Vice-President for Administrative".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Vice-President for Administrative");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Vice-President for Administrative");

                        }

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Research Development and Extension")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);

                        if (("Journal and Publication Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Journal and Publication Office");
                        } else {
                            jComboBoxPermission.addItem("Journal and Publication Office");
                        }

                        if (("Office of Monitoring and Evaluation Unit".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Monitoring and Evaluation Unit");
                        } else {
                            jComboBoxPermission.addItem("Office of Office of Monitoring and Evaluation Unit");
                        }
                        if (("Office of Reseach and Development".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Reseach and Development");
                        } else {
                            jComboBoxPermission.addItem("Office of Reseach and Development");
                        }
                        if (("Office of Director for Extension".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Director for Extension");
                        } else {
                            jComboBoxPermission.addItem("Office of Director for Extension");
                        }
                        if (("Office of CAAD".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of CAAD");
                        } else {
                            jComboBoxPermission.addItem("Office of CAAD");
                        }
                        if (("Director of Cooperative Development Center".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director of Cooperative Development Center");
                        } else {
                            jComboBoxPermission.addItem("Director of Cooperative Development Center");
                        }
                        if (("Director of Gender and Development Center".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director of Gender and Development Center");
                        } else {
                            jComboBoxPermission.addItem("Director of Gender and Development Center");
                        }
                        if (("Director of Provincial Institute of Agriculture".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director of Provincial Institute of Agriculture");
                        } else {
                            jComboBoxPermission.addItem("Director of Provincial Institute of Agriculture");
                        }
                        if (("Director of Sentro ng Wika at Kultura".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director of Sentro ng Wika at Kultura");
                        } else {
                            jComboBoxPermission.addItem("Director of Sentro ng Wika at Kultura");
                        }
                        if (("Director of RAC XI".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director of RAC XI");
                        } else {
                            jComboBoxPermission.addItem("Director of RAC XI");
                        }
                        if (("Director of TIEC Center".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director of TIEC Center");
                        } else {
                            jComboBoxPermission.addItem("Director of TIEC Center");
                        }
                        if (("Vice-President for Reseach Development and Extension".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Vice-President for Reseach Development and Extension");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");

                        }
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("College Council")) {

                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(true);

                        if (("President of DOSCST Alumni Association".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("President of DOSCST Alumni Association");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                        }
                        if (("Quality of Management Office".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Quality of Management Office");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Quality of Management Office");
                        }
                        if (("Office of Entrepreneurship and Management Officer".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Entrepreneurship and Management Officer");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Office of Entrepreneurship and Management Officer");
                        }
                        if (("Office of Public Information Officer".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Public Information Officer");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Office of Public Information Officer");
                        }
                        if (("Executive Assistant to the President".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Executive Assistant to the President");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Executive Assistant to the President");
                        }
                        if (("Director for Planning and Development".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Director for Planning and Development");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Director for Planning and Development");
                        }
                        if (("Office of Infrastructure Committee".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Infrastructure Committee");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Office of Infrastructure Committee");
                        }
                        if (("Office of Management Information System".equals(jLabelPermission.getText()))) {
                            jComboBoxPermission.removeItem("Office of Management Information System");
                            jComboBoxPermission.addItem("President");
                        } else {
                            jComboBoxPermission.addItem("Office of Management Information System");
                        }

                    }
                }

            }
        });
    }

    public void incominglistReport() {
        try {
            String var = jLabelPermission.getText();
            con = myConnection.getConnection();
            String source = System.getProperty("user.dir") + "/src/incoming.jrxml";
            JasperDesign jDesign = JRXmlLoader.load(source);
            String query = "SELECT * FROM incominglist where to_data ='" + var + "'";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jDesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer jv = new JasperViewer(jPrint, false);
            jv.setVisible(true);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pendingListReport() {
        try {
            String var = jLabelPermission.getText();
            con = myConnection.getConnection();

            String source = System.getProperty("user.dir") + "/src/pendingList.jrxml";
            JasperDesign jDesign = JRXmlLoader.load(source);
            String query = "SELECT * FROM pendinglist where forwarded_by ='" + var + "'";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jDesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer jv = new JasperViewer(jPrint, false);
            jv.setVisible(true);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outgoingListReport() {
        try {
            String var = jLabelPermission.getText();
            con = myConnection.getConnection();
            String source = System.getProperty("user.dir") + "/src/outgoingList.jrxml";
            JasperDesign jDesign = JRXmlLoader.load(source);
            String query = "SELECT * FROM outgoinglist where to_data ='" + var + "'";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jDesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer jv = new JasperViewer(jPrint, false);
            jv.setVisible(true);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewDetailsReport() {
        try {
            String ussid = jLabelSSID.getText();
            String tracking = jLabelGetTrackingID.getText();
            con = myConnection.getConnection();
            String source = System.getProperty("user.dir") + "/src/viewDetails.jrxml";

            JasperDesign jDesign = JRXmlLoader.load(source);

            String query = "SELECT * FROM viewdetails where userID ='" + ussid + "' && tracking_data ='" + tracking + "'";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jDesign.setQuery(updateQuery);
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer jv = new JasperViewer(jPrint, false);
            jv.setVisible(true);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyNumber() {
        ////
        if (Integer.parseInt(jLabelTrackingPageMenuNumber.getText()) == 0) {
            jLabelTrackingPageMenuNumber.setVisible(false);
            jLabelTrackingPageMenuCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelTrackingPageMenuNumber.getText()) > 0) {
            jLabelTrackingPageMenuNumber.setVisible(true);
            jLabelTrackingPageMenuCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelTrackingPageMenuNumber.getText()) > 9) {
            String var = "9+";
            jLabelTrackingPageMenuNumber.setText(var);
            jLabelTrackingPageMenuNumber.setVisible(true);
            jLabelTrackingPageMenuCircle.setVisible(true);
        }

        /////////////2
        if (Integer.parseInt(jLabeltrackingPageNumber.getText()) == 0) {
            jLabeltrackingPageNumber.setVisible(false);
            jLabelTrackingPageCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabeltrackingPageNumber.getText()) > 0) {
            jLabeltrackingPageNumber.setVisible(true);
            jLabelTrackingPageCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabeltrackingPageNumber.getText()) > 9) {
            String var = "9+";
            jLabeltrackingPageNumber.setText(var);
            jLabeltrackingPageNumber.setVisible(true);
            jLabelTrackingPageCircle.setVisible(true);
        }
        ////
        ////
        if (Integer.parseInt(jLabelTransactionHistoryMenuNumber.getText()) == 0) {
            jLabelTransactionHistoryMenuNumber.setVisible(false);
            jLabelTransactionHistoryMenuCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelTransactionHistoryMenuNumber.getText()) > 0) {
            jLabelTransactionHistoryMenuNumber.setVisible(true);
            jLabelTransactionHistoryMenuCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelTransactionHistoryMenuNumber.getText()) > 9) {
            String var = "9+";
            jLabelTransactionHistoryMenuNumber.setText(var);
            jLabelTransactionHistoryMenuNumber.setVisible(true);
            jLabelTransactionHistoryMenuCircle.setVisible(true);
        }////////2
        if (Integer.parseInt(jLabelTransactionHistoryNumber.getText()) == 0) {
            jLabelTransactionHistoryNumber.setVisible(false);
            jLabelTransactionHistoryCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelTransactionHistoryNumber.getText()) > 0) {
            jLabelTransactionHistoryNumber.setVisible(true);
            jLabelTransactionHistoryCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelTransactionHistoryNumber.getText()) > 9) {
            String var = "9+";
            jLabelTransactionHistoryNumber.setText(var);
            jLabelTransactionHistoryNumber.setVisible(true);
            jLabelTransactionHistoryCircle.setVisible(true);
        }
        ////
        //incoming
        if (Integer.parseInt(jLabelIncomingNumber.getText()) == 0) {
            jLabelIncomingNumber.setVisible(false);
            jLabelIncomingCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelIncomingNumber.getText()) > 0) {
            jLabelIncomingNumber.setVisible(true);
            jLabelIncomingCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelIncomingNumber.getText()) > 9) {
            String var = "9+";
            jLabelIncomingNumber.setText(var);
            jLabelIncomingNumber.setVisible(true);
            jLabelIncomingCircle.setVisible(true);
        }////////2
        if (Integer.parseInt(jLabelIncomingMenuNumber.getText()) == 0) {
            jLabelIncomingMenuNumber.setVisible(false);
            jLabelIncomingMenuCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelIncomingMenuNumber.getText()) > 0) {
            jLabelIncomingMenuNumber.setVisible(true);
            jLabelIncomingMenuCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelIncomingMenuNumber.getText()) > 9) {
            String var = "9+";
            jLabelIncomingMenuNumber.setText(var);
            jLabelIncomingMenuNumber.setVisible(true);
            jLabelIncomingMenuCircle.setVisible(true);
        }
        ////
        //pending
        if (Integer.parseInt(jLabelPendingNumber.getText()) == 0) {
            jLabelPendingNumber.setVisible(false);
            jLabelPendingCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelPendingNumber.getText()) > 0) {
            jLabelPendingNumber.setVisible(true);
            jLabelPendingCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelPendingNumber.getText()) > 9) {
            String var = "9+";
            jLabelPendingNumber.setText(var);
            jLabelPendingNumber.setVisible(true);
            jLabelPendingCircle.setVisible(true);
        }////////2
        if (Integer.parseInt(jLabelPendingMenuNumber.getText()) == 0) {
            jLabelPendingMenuNumber.setVisible(false);
            jLabelPendingMenuCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelPendingMenuNumber.getText()) > 0) {
            jLabelPendingMenuNumber.setVisible(true);
            jLabelPendingMenuCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelPendingMenuNumber.getText()) > 9) {
            String var = "9+";
            jLabelPendingMenuNumber.setText(var);
            jLabelPendingMenuNumber.setVisible(true);
            jLabelPendingMenuCircle.setVisible(true);
        }
        ////
        //outgoing
        if (Integer.parseInt(jLabelOutgoingNumber.getText()) == 0) {
            jLabelOutgoingNumber.setVisible(false);
            jLabelOutgoingCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelOutgoingNumber.getText()) > 0) {
            jLabelOutgoingNumber.setVisible(true);
            jLabelOutgoingCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelOutgoingNumber.getText()) > 9) {
            String var = "9+";
            jLabelOutgoingNumber.setText(var);
            jLabelOutgoingNumber.setVisible(true);
            jLabelOutgoingCircle.setVisible(true);
        }////////2
        if (Integer.parseInt(jLabelOutgoingMenuNumber.getText()) == 0) {
            jLabelOutgoingMenuNumber.setVisible(false);
            jLabelOutgoingMenuCircle.setVisible(false);
        }
        if (Integer.parseInt(jLabelOutgoingMenuNumber.getText()) > 0) {
            jLabelOutgoingMenuNumber.setVisible(true);
            jLabelOutgoingMenuCircle.setVisible(true);
        }
        if (Integer.parseInt(jLabelOutgoingMenuNumber.getText()) > 9) {
            String var = "9+";
            jLabelOutgoingMenuNumber.setText(var);
            jLabelOutgoingMenuNumber.setVisible(true);
            jLabelOutgoingMenuCircle.setVisible(true);
        }
        ////
    }

    public void incoming() {

        try {
            String status = jLabelStatus.getText().trim();
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String type = jComboBoxDocType.getSelectedItem().toString();
            String details = jTextAreaDetails.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String tosend = jComboBoxPermission.getSelectedItem().toString();
            String time = jLabelTime.getText().trim();
            String ussid = jLabelSSID.getText();
            String trId = jLabelTrackingFK.getText();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into incoming(from_data,by_data,documenttype_data, details_data, purpose_data, to_data,postedtime_data,userID,tracking_data)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, from);
            pst.setString(2, by);
            pst.setString(3, type);
            pst.setString(4, details);
            pst.setString(5, purpose);
            pst.setString(6, tosend);
            pst.setString(7, time);
            pst.setString(8, ussid);
            pst.setString(9, trId);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveDocuments() {

        try {
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String type = jComboBoxDocType.getSelectedItem().toString();
            String details = jTextAreaDetails.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String to = jComboBoxPermission.getSelectedItem().toString();
            String time = jLabelTime.getText().trim();
            String tracking = jTextFieldTracking.getText().trim();
            String userId = jLabelSSID.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into documents(from_data,by_data,documenttype_data,details_data,purpose_data,to_data,postedtime_data,tracking_data,userID)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, from);
            pst.setString(2, by);
            pst.setString(3, type);
            pst.setString(4, details);
            pst.setString(5, purpose);
            pst.setString(6, to);
            pst.setString(7, time);
            pst.setString(8, tracking);
            pst.setString(9, userId);
            pst.executeUpdate();

            autoId();
            jLabelTrackingFK.setText(tracking);
            jLabelSubmitedto.setText("Ongoing");
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void SaveToOutGoingList() {

        try {
            String status = jLabelForwarded.getText().trim();
            String tracking = jLabeltracking_data.getText().trim();
            String from = jLabelFrom_data.getText().trim();
            String by = jLabelby_data.getText().trim();
            String to = jLabelto_data.getText().trim();
            String type = jLabeltype_data.getText().trim();
            String purpose = jLabelPurpose_data.getText().trim();
            String details = jLabelDetail_data.getText().trim();
            //  String status = "Forwarded";
            String time = jLabelTime.getText().trim();
            String trId = jLabelTracingID.getText();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into outgoinglist (tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data,userID)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking);
            pst.setString(2, from);
            pst.setString(3, by);
            pst.setString(4, to);
            pst.setString(5, type);
            pst.setString(6, purpose);
            pst.setString(7, details);
            pst.setString(8, status);
            pst.setString(9, time);
            pst.setString(10, trId);

            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveToIncomingList() {

        try {
            String tracking_data = jLabeltracking_data.getText().trim();
            String from_data = jLabelFrom_data.getText().trim();
            String by_data = jLabelby_data.getText().trim();
            String to_data = jLabelto_data.getText().trim();
            String type_data = jLabeltype_data.getText().trim();
            String purpose_data = jLabelPurpose_data.getText().trim();
            String status = jLabelstatus.getText().trim();
            String Details = jLabelDetail_data.getText().trim();
            String postedTime = jLabelTime.getText().trim();
            String userId = jLabelTracingID.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into incominglist (tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data,userID)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking_data);
            pst.setString(2, from_data);
            pst.setString(3, by_data);
            pst.setString(4, to_data);
            pst.setString(5, type_data);
            pst.setString(6, purpose_data);
            pst.setString(7, Details);
            pst.setString(8, status);
            pst.setString(9, postedTime);
            pst.setString(10, userId);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void saveToViewdetailsFromIncoming() {

        try {
            String tracking_data = jLabeltracking_data.getText().trim();
            String from_data = jLabelFrom_data.getText().trim();
            String by_data = jLabelby_data.getText().trim();
            String destination = jLabelto_data.getText().trim();
            String doctype = jLabeltype_data.getText().trim();
            String actionNeeded = jLabelPurpose_data.getText().trim();
            String details = jLabelDetail_data.getText().trim();
            String status = jLabelstatus.getText().trim();
            String time = jLabelTime.getText().trim();
            String userId = jLabelTracingID.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into viewdetails (tracking_data,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data,userID)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking_data);
            pst.setString(2, from_data);
            pst.setString(3, by_data);
            pst.setString(4, destination);
            pst.setString(5, doctype);
            pst.setString(6, actionNeeded);
            pst.setString(7, details);
            pst.setString(8, status);
            pst.setString(9, time);
            pst.setString(10, userId);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void saveToPending() {

        try {
            String status = "Received";
            String tracking_data = jLabeltracking_data.getText().trim();
            String from_data = jLabelFrom_data.getText().trim();
            String by_data = jLabelby_data.getText().trim();
            String to_data = jLabelto_data.getText().trim();
            String doctype = jLabeltype_data.getText().trim();
            String purpose = jLabelPurpose_data.getText().trim();
            String details = jLabelDetail_data.getText().trim();
            String time = jLabelTime.getText().trim();
            String userId = jLabelTracingID.getText().trim();
            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into pending (tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,postedtime_data,userID,status)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking_data);
            pst.setString(2, from_data);
            pst.setString(3, by_data);
            pst.setString(4, to_data);
            pst.setString(5, doctype);
            pst.setString(6, purpose);
            pst.setString(7, details);
            pst.setString(8, time);
            pst.setString(9, userId);
            pst.setString(10, status);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void updateTracingPage() {
        String trackID = jLabeltracking_data.getText().trim();
        String to = jLabelPermission.getText().trim();
        String status = jLabelstatus.getText();
        String time = jLabelTime.getText();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("UPDATE trackingpage SET to_data = '" + to + "',status = '" + status + "',postedtime_data ='" + time + "' where tracking_data ='" + trackID + "'");
            pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteIncoming() {
        String from = jLabeltracking_data.getText().trim();
        String username = jLabelUsername.getText().trim();
        String pres = "President";
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from incoming where tracking_data ='" + from + "' && from_data !='" + pres + "' ");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Received Forwarded to Pending");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOutgoing() {
        String from = jLabeltracking_data.getText().trim();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from outgoing where tracking_number ='" + from + "'");
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trackpage() {

        try {
            String userId = jLabelSSID.getText().trim();
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String type = jComboBoxDocType.getSelectedItem().toString();
            String details = jTextAreaDetails.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String to = jComboBoxPermission.getSelectedItem().toString();
            String time = jLabelTime.getText().trim();
            String tracking = jLabelTrackingFK.getText().trim();
            String status = jLabelSubmitedto.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into trackingpage(userID,from_data,by_data,documenttype_data,details_data,purpose_data,to_data,postedtime_data,tracking_data,status)values(?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, userId);
            pst.setString(2, from);
            pst.setString(3, by);
            pst.setString(4, type);
            pst.setString(5, details);
            pst.setString(6, purpose);
            pst.setString(7, to);
            pst.setString(8, time);
            pst.setString(9, tracking);
            pst.setString(10, status);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void InsertIntoviewDetails() {
        try {
            String userId = jLabelSSID.getText().trim();
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String type = jComboBoxDocType.getSelectedItem().toString();
            String details = jTextAreaDetails.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String to = jComboBoxPermission.getSelectedItem().toString();
            String time = jLabelTime.getText().trim();
            String tracking = jLabelTrackingFK.getText().trim();
            String status = jLabelView.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into viewdetails(userID,from_data,by_data,documenttype_data,details_data,purpose_data,to_data,postedtime_data,tracking_data,status)values(?,?,?,?,?,?,?,?,?,?)");

            pst.setString(1, userId);
            pst.setString(2, from);
            pst.setString(3, by);
            pst.setString(4, type);
            pst.setString(5, details);
            pst.setString(6, purpose);
            pst.setString(7, to);
            pst.setString(8, time);
            pst.setString(9, tracking);
            pst.setString(10, status);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void numRowTrackingPagr() {
        String var = jLabelSSID.getText();
        String username = jLabelUsername.getText();
        int number = Integer.parseInt(var);
        String all = "For Everyone";
        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM  trackingpage where userID ='" + number + "' or to_data ='" + all + "'");

            if (rs.next()) {
                String sum = rs.getString("COUNT(*)");
                jLabeltrackingPageNumber.setText(sum);
                jLabelTrackingPageMenuNumber.setText(sum);

            }
            con.close();

        } catch (Exception e) {
        }

    }

    public void trackingHistoryNum() {
        String var = jLabelSSID.getText();
     //   String username = jLabelUsername.getText();
        int number = Integer.parseInt(var);
        String all = "For Everyone";
        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM  trackinghistory where userID ='" + number + "'  or to_data ='" + all + "'");

            if (rs.next()) {
                String sum = rs.getString("COUNT(*)");
                jLabelTransactionHistoryMenuNumber.setText(sum);
                jLabelTransactionHistoryNumber.setText(sum);

            }
            con.close();

        } catch (Exception e) {
        }

    }

    public void incomingNumberNotify() {
        String var = jLabelPermission.getText();
        String username = jLabelUsername.getText();
        // int number = Integer.parseInt(var);
        String all = "For Everyone";
        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM  incoming where to_data ='" + var + "' or to_data ='" + username + "'or to_data ='" + all + "' && by_data !='"+username+"'  ");

            if (rs.next()) {
                String sum = rs.getString("COUNT(*)");
                jLabelIncomingNumber.setText(sum);
                jLabelIncomingMenuNumber.setText(sum);
            }
            con.close();

        } catch (Exception e) {
        }

    }

    public void pendingNumberNotify() {
        String var = jLabelPermission.getText();
        //  int number = Integer.parseInt(var);
        String username = jLabelUsername.getText();
        String all = "For Everyone";
        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM  pending where to_data ='" + var + "' or to_data ='" + username + "' or to_data ='" + all+ "'");

            if (rs.next()) {
                String sum = rs.getString("COUNT(*)");
                jLabelPendingNumber.setText(sum);
                jLabelPendingMenuNumber.setText(sum);

            }
            con.close();

        } catch (Exception e) {
        }

    }

    public void OutgoingNumberNotify() {
     //   String var = jLabelPermission.getText();
        //int number = Integer.parseInt(var);
        String username = jLabelUsername.getText();
        String all = "For Everyone";
        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM  outgoing where forwarded_by ='" + username + "' or forwarded_by ='" + all + "'");

            if (rs.next()) {
                String sum = rs.getString("COUNT(*)");
                jLabelOutgoingNumber.setText(sum);
                jLabelOutgoingMenuNumber.setText(sum);
            }
            con.close();

        } catch (Exception e) {
        }

    }

    public void permission() {
        String var = jLabelSSID.getText();
        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT permission from users where id ='" + var + "'");

            if (rs.next()) {
                String res = rs.getString("permission");
                jLabelPermission.setText(res);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void autoId() {

        Calendar calendar = new GregorianCalendar();

        try {
            con = myConnection.getConnection();
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery("select Max(tracking_data) from documents");
            rs.next();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            rs.getString("Max(tracking_data)");

            if (rs.getString("Max(tracking_data)") == null) {
                jTextFieldTracking.setText(sdf.format(calendar.getTime()) + "-0001");

            } else {
                Long id = Long.parseLong(rs.getString("Max(tracking_data)").substring(10, rs.getString("Max(tracking_data)").length()));
                id++;
                jTextFieldTracking.setText(sdf.format(calendar.getTime()) + "-0" + String.format("%03d", id));
            }
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
//            Logger.getLogger(autoIn1.class.getName()).log(Level.SEVERE, null, ex);
        }
//            Logger.getLogger(autoIn1.class.getName()).log(Level.SEVERE, null, ex);

    }

    public void trackingHistoryDisplayTable() {
        try {
            //   pst = con.prepareStatement("SELECT tracking_number, from_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM trackinghistory where userID = '" + id + "' && status = '" + status + "'");

            // String status = jComboBoxTransactionHistory.getSelectedItem().toString();
            String id = jLabelSSID.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number, to_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM trackinghistory where userID ='" + id + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableTransactionHistory.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),});
            }
            jTableTransactionHistory.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trackingHistoryDisplayFiltTable() {
        try {

            String status = jComboBoxTransactionHistory.getSelectedItem().toString();
            String id = jLabelSSID.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number, to_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM trackinghistory where userID = '" + id + "' && status = '" + status + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableTransactionHistory.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),});
            }
            jTableTransactionHistory.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pendingListDisplayFiltTable() {
        try {

            String status = jComboBoxPendingList.getSelectedItem().toString();
            String id = jLabelPermission.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number, from_data,by_data,to_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM pendinglist where forwarded_by = '" + id + "' && status = '" + status + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTablePendingList.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),});
            }
            jTablePendingList.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void IncomingDisplayTable() {
        try {
            String uname = jLabelUsername.getText().trim();
            String id = jLabelPermission.getText().trim();
            String all = "For Everyone";
            //String pres = "President";
            
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_data,from_data, by_data,to_data, documenttype_data, purpose_data, details_data, postedtime_data FROM incoming where  to_data ='" + id + "' or to_data = '" + uname + "' or to_data = '" + all + "' && by_data !='"+uname+"'  ");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableIncoming.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),});
            }
            jTableIncoming.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void IncomingListDisplayTable() {
        try {
            String uname = jLabelUsername.getText().trim();
            String id = jLabelPermission.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number,from_data, by_data,to_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM incominglist where to_data ='" + id + "' or to_data ='" + uname + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableIncomingList.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),});
            }
            jTableIncomingList.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PendingListDisplayTable() {
        try {
            String uname = jLabelUsername.getText().trim();
            String forwardedBy = jLabelPermission.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number,from_data, by_data,to_data, documenttype_data, purpose_data,status,details_data, postedtime_data FROM pendinglist where forwarded_by ='" + forwardedBy + "' or forwarded_by ='" + uname + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTablePendingList.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),});
            }
            jTablePendingList.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OutgoingListDisplayTable() {
        try {

            String uname = jLabelUsername.getText().trim();
            String id = jLabelPermission.getText().trim();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number, from_data,by_data,to_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM outgoinglist Where to_data ='" + id + "' or to_data ='" + uname + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableOutgoingList.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),});
            }
            jTableOutgoingList.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PendingDisplayTable() {
        try {
            String uname = jLabelUsername.getText().trim();
            String id = jLabelPermission.getText().trim();
            String all = "For Everyone";
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number,from_data, by_data,to_data, documenttype_data, purpose_data,status, details_data, postedtime_data FROM pending where to_data ='" + id + "' or to_data ='" + uname + "' or to_data ='" + all + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTablePending.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),});
            }
            jTablePending.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OutgoingisplayTable() {
        try {

            String forwarded_by = jLabelUsername.getText();
             String all = "For Everyone";
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_number,from_data, by_data,to_data, documenttype_data, purpose_data,status, details_data, postedtime_data FROM outgoing where forwarded_by ='" + forwarded_by + "' or forwarded_by ='" + all + "'");

            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableOutgoing.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),});
            }
            jTableOutgoing.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trackingViewTable() {
        try {
            String id = jLabelSSID.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_data, status, documenttype_data, purpose_data, details_data, postedtime_data FROM viewdetails where userID ='" + id + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableViewdetails.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),});
            }
            jTabletracking.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trackingPageTable() {
        try {

            String id = jLabelSSID.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_data, to_data, documenttype_data, purpose_data, details_data,status, postedtime_data FROM trackingpage where userID ='" + id + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTabletracking.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),});
            }
            jTabletracking.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ViewDetails() {
        try {
            String details = jLabelGetTrackingID.getText();
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data FROM viewdetails where tracking_data ='" + details + "'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableViewdetails.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),});
            }
            jTableViewdetails.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        Calendar calendar = new GregorianCalendar();
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM / dd / yyyy / ");

                        int seconds = calendar.get(Calendar.SECOND);
                        int minutes = calendar.get(Calendar.MINUTE);
                        int hour = calendar.get(Calendar.HOUR);
                        int am_pm = calendar.get(Calendar.AM_PM);
                        String ampm = "ampm";
                        if (am_pm == 0) {
                            ampm = "AM";
                        } else {
                            ampm = "PM";
                        }
                        jLabelTime.setText(sdf.format(calendar.getTime()) + hour + ":" + minutes + ":" + seconds + " " + ampm);
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        clock.start();

    }

    public void searchIncoming() {
        try {

            String id = jLabelPermission.getText();
            String search = jTextFieldIncoming.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM incoming where to_data = '" + id + "' and tracking_data like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableIncoming.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_data"),
                        rs.getString("from_data"),
                        rs.getString("by_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("postedtime_data"),});
                }
                jTableIncoming.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchIncomingList() {
        try {

            String id = jLabelPermission.getText();
            String search = jTextFieldIncomingList.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM incominglist where to_data = '" + id + "' and tracking_number like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableIncomingList.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_number"),
                        rs.getString("from_data"),
                        rs.getString("by_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("status"),
                        rs.getString("postedtime_data"),});
                }
                jTableIncomingList.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchoutgoing() {
        try {

            String id = jLabelPermission.getText();
            String search = jTextFielOutgoing.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM outgoing where forwarded_by = '" + id + "' and tracking_number like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableOutgoing.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_number"),
                        rs.getString("from_data"),
                        rs.getString("by_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("status"),
                        rs.getString("postedtime_data"),});
                }
                jTableOutgoing.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchPending() {
        try {

            String id = jLabelPermission.getText();
            String search = jTextFieldPending.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM pending where to_data = '" + id + "' and tracking_number like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTablePending.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_number"),
                        rs.getString("from_data"),
                        rs.getString("by_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("status"),
                        rs.getString("postedtime_data"),});
                }
                jTablePending.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchPendingList() {
        try {

            String id = jLabelPermission.getText();
            String search = jTextFieldPendingList.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM pendinglist where forwarded_by = '" + id + "' and tracking_number like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTablePendingList.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_number"),
                        rs.getString("from_data"),
                        rs.getString("by_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("status"),
                        rs.getString("postedtime_data"),});
                }
                jTablePendingList.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchoutgoingList() {
        try {

            String id = jLabelPermission.getText();
            String search = jTextFieldoutgoingList.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM outgoinglist where to_data = '" + id + "' and tracking_number like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableOutgoingList.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_number"),
                        rs.getString("from_data"),
                        rs.getString("by_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("status"),
                        rs.getString("postedtime_data"),});
                }
                jTableOutgoingList.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchTrackingPage() {
        try {

            String id = jLabelSSID.getText();
            String search = jTextFieldTrackingPage.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM trackingpage where userID = '" + id + "' and tracking_data like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTabletracking.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_data"),
                        rs.getString("to_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("Status"),
                        rs.getString("postedtime_data"),});
                }
                jTabletracking.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchTransactionHistory() {
        try {

            String id = jLabelSSID.getText();
            String search = jTextFieldTracnsac.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM trackinghistory where userID = '" + id + "' and tracking_number like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableTransactionHistory.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_number"),
                        rs.getString("from_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("purpose_data"),
                        rs.getString("details_data"),
                        rs.getString("status"),
                        rs.getString("postedtime_data"),});
                }
                jTableTransactionHistory.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void submit() {

        jButtonTransactionHistoryViewDetails.setEnabled(false);
        jButtonIncomingAccept.setEnabled(false);
        jButtonPendingAccept.setEnabled(false);
        jButtonSubmit.setEnabled(true);
        saveDocuments();
        incoming();
        trackpage();
        InsertIntoviewDetails();
        pendingNumberNotify();
        OutgoingNumberNotify();
        incomingNumberNotify();
        numRowTrackingPagr();
        trackingHistoryNum();
        notifyNumber();
        try {
            if (reg == null || reg.isClosed()) {
                PrintTrackingNumber home = new PrintTrackingNumber();
                home.setVisible(true);
                home.jLabelTracking.setText(jLabelTrackingFK.getText());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
