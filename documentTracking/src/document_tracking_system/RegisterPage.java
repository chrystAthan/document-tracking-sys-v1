/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package document_tracking_system;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class RegisterPage extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public RegisterPage() {
        initComponents();
        reg();
        jComboBoxPermission.addItem("");

//        jComboBoxProgram.setEnabled(false);
//        jComboBoxInsitute.setEnabled(false);
    }

    public void reg() {
        jComboBoxField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {

                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Academic")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPosition.removeAllItems();
                        jComboBoxPosition.setEnabled(true);
                        jComboBoxPermission.setEnabled(false);
                        jLabelCourse.setVisible(true);
                        jButtonSubmit.setEnabled(false);

                        jComboBoxPosition.addItem("Staff");
                        jComboBoxPosition.addItem("Faculty");
                        jComboBoxPosition.addItem("Office's Staff");
                        jComboBoxPosition.addItem("Office's Faculty");
                        jComboBoxPosition.addItem("Dean/Head/Director");
                        jComboBoxPosition.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                if (ie.getStateChange() == ItemEvent.SELECTED) {

                                    if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Faculty")) {
                                        jComboBoxInstitute.removeAllItems();
                                        jComboBoxPermission.removeAllItems();
                                        jLabelCourse.setVisible(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.setEnabled(true);
                                        jComboBoxInstitute.setEnabled(true);
                                        jComboBoxInstitute.addItem("IALS");
                                        jComboBoxInstitute.addItem("IBPA");
                                        jComboBoxInstitute.addItem("ICE");
                                        jComboBoxInstitute.addItem("IETT");

                                        jComboBoxInstitute.addItemListener(new ItemListener() {
                                            @Override
                                            public void itemStateChanged(ItemEvent ie) {
                                                if (ie.getStateChange() == ItemEvent.SELECTED) {

                                                    if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("IALS")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("ENVI-SCI Faculty");
                                                        jComboBoxPermission.addItem("BSBIO Faculty");
                                                        jComboBoxPermission.addItem("BSAM Faculty");
                                                        jComboBoxPermission.addItem("DEVCOM Faculty");
                                                        jComboBoxPermission.addItem("NURSING Faculty");
                                                        jComboBoxPermission.addItem("BAT Faculty");

                                                    } else if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("IBPA")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("BSBA Faculty");
                                                        jComboBoxPermission.addItem("HM Faculty");
                                                        jComboBoxPermission.addItem("CRIM Faculty");
                                                    } else if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("ICE")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("BSIT Faculty");
                                                        jComboBoxPermission.addItem("BITM Faculty");
                                                        jComboBoxPermission.addItem("BSMATH Faculty");
                                                        jComboBoxPermission.addItem("CE Faculty");
                                                    } else if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("IETT")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("BEED Faculty");
                                                        jComboBoxPermission.addItem("BSED-BS Faculty");
                                                        jComboBoxPermission.addItem("BSED-ENG Faculty");
                                                        jComboBoxPermission.addItem("BSED-MATH Faculty");
                                                        jComboBoxPermission.addItem("BSED-PS Faculty");
                                                        jComboBoxPermission.addItem("BSED-PE Faculty");
                                                        jComboBoxPermission.addItem("TLE Faculty");
                                                    }

                                                }

                                            }
                                        });
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Staff")) {
                                        jComboBoxInstitute.removeAllItems();
                                        //   jComboBoxPermission.removeAllItems();
                                        jButtonSubmit.setEnabled(false);
                                        jLabelCourse.setVisible(true);
                                        jComboBoxInstitute.setEnabled(true);
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jComboBoxInstitute.addItem("IALS ");
                                        jComboBoxInstitute.addItem("IBPA ");
                                        jComboBoxInstitute.addItem("ICE ");
                                        jComboBoxInstitute.addItem("IETT ");

                                        jComboBoxInstitute.addItemListener(new ItemListener() {
                                            @Override
                                            public void itemStateChanged(ItemEvent ie) {
                                                if (ie.getStateChange() == ItemEvent.SELECTED) {

                                                    if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("IALS ")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("ENVI-SCI Staff");
                                                        jComboBoxPermission.addItem("BSBIO Staff");
                                                        jComboBoxPermission.addItem("BSAM Staff");
                                                        jComboBoxPermission.addItem("DEVCOM Staff");
                                                        jComboBoxPermission.addItem("NURSING Staff");
                                                        jComboBoxPermission.addItem("BAT Staff");
                                                    } else if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("IBPA ")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("BSBA Staff");
                                                        jComboBoxPermission.addItem("HM Staff");
                                                        jComboBoxPermission.addItem("CRIM Staff");
                                                    } else if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("ICE ")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("BSIT Staff");
                                                        jComboBoxPermission.addItem("BITM Staff");
                                                        jComboBoxPermission.addItem("BSMATH Staff");
                                                        jComboBoxPermission.addItem("CE Staff");
                                                    } else if (jComboBoxInstitute.getSelectedItem().toString().equalsIgnoreCase("IETT ")) {
                                                        jComboBoxPermission.removeAllItems();
                                                        jButtonSubmit.setEnabled(false);
                                                        jComboBoxPermission.addItem("BEED Staff");
                                                        jComboBoxPermission.addItem("BSED-BS Staff");
                                                        jComboBoxPermission.addItem("BSED-ENG Staff");
                                                        jComboBoxPermission.addItem("BSED-MATH Staff");
                                                        jComboBoxPermission.addItem("BSED-PS Staff");
                                                        jComboBoxPermission.addItem("BSED-PE Staff");
                                                        jComboBoxPermission.addItem("TLE Staff");
                                                    }

                                                }

                                            }
                                        });
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Staff")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxInstitute.removeAllItems();
                                        jComboBoxInstitute.setEnabled(true);
                                        jLabelCourse.setVisible(false);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.setEnabled(true);
                                        jComboBoxPermission.addItem("Staff of FASST");
                                        jComboBoxPermission.addItem("Health Service Unit Staff");
                                        jComboBoxPermission.addItem("GCTC Staff");
                                        jComboBoxPermission.addItem("Sports Development Office Staff");
                                        jComboBoxPermission.addItem("TLR-AEC/QAD Staff");
                                        jComboBoxPermission.addItem("Registrar Staff");
                                        jComboBoxPermission.addItem("Office of Student and Affairs Staff");
                                        jComboBoxPermission.addItem("Graduate School Coordinator Staff");
                                        jComboBoxPermission.addItem("NSTP Staff");
                                        jComboBoxPermission.addItem("Director for Instructor Staff");
                                        jComboBoxPermission.addItem("Director for Student Service Staff");
                                        jComboBoxPermission.addItem("SHS Administrator Staff");
                                        jComboBoxPermission.addItem("College Librarian Staff");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Faculty")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxInstitute.removeAllItems();
                                        jLabelCourse.setVisible(false);
                                        jComboBoxInstitute.setEnabled(true);
                                        jComboBoxPermission.setEnabled(true);
                                        jComboBoxPermission.addItem("Faculty of FASST");
                                        jComboBoxPermission.addItem("Health Service Unit Faculty");
                                        jComboBoxPermission.addItem("GCTC Faculty");
                                        jComboBoxPermission.addItem("Sports Development Office Faculty");
                                        jComboBoxPermission.addItem("TLR-AEC/QAD Faculty");
                                        jComboBoxPermission.addItem("Registrar Faculty");
                                        jComboBoxPermission.addItem("Office of Student and Affairs Faculty");
                                        jComboBoxPermission.addItem("Graduate School Coordinator Faculty");
                                        jComboBoxPermission.addItem("NSTP Faculty");
                                        jComboBoxPermission.addItem("Director for Instructor Faculty");
                                        jComboBoxPermission.addItem("Director for Student Service Faculty");
                                        jComboBoxPermission.addItem("SHS Administrator Faculty");
                                        jComboBoxPermission.addItem("College Librarian Faculty");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Dean/Head/Director")) {

                                        jComboBoxInstitute.setEnabled(true);
                                        jComboBoxInstitute.removeAllItems();
                                        jLabelCourse.setVisible(false);
                                        jButtonSubmit.setEnabled(false);

                                        jComboBoxPermission.setEnabled(true);
                                        jComboBoxPermission.removeAllItems();

                                        jComboBoxPermission.addItem("Head of IALS");
                                        jComboBoxPermission.addItem("Head of IBPA");
                                        jComboBoxPermission.addItem("Head of ICE");
                                        jComboBoxPermission.addItem("Head of IETT");

                                        jComboBoxPermission.addItem("Dean of IALS");
                                        jComboBoxPermission.addItem("Dean of IBPA");
                                        jComboBoxPermission.addItem("Dean of ICE");
                                        jComboBoxPermission.addItem("Dean of IETT");

                                        jComboBoxPermission.addItem("Office of FASST");
                                        jComboBoxPermission.addItem("Office  of Health Service Unit");
                                        jComboBoxPermission.addItem("Office  of GCTC");
                                        jComboBoxPermission.addItem("Sports Development Office");
                                        jComboBoxPermission.addItem("Office  of TLR-AEC/QAD");
                                        jComboBoxPermission.addItem("Registrar Office");
                                        jComboBoxPermission.addItem("Office of Student and Affairs");

                                        jComboBoxPermission.addItem("Office of Graduate School Coordinator");
                                        jComboBoxPermission.addItem("Office of Coordinator of NSTP");
                                        jComboBoxPermission.addItem("Director for Instructor");
                                        jComboBoxPermission.addItem("Director for Student Service");
                                        jComboBoxPermission.addItem("Office of SHS Administrator");
                                        jComboBoxPermission.addItem("Office of College Librarian");
                                        jComboBoxPermission.addItem("Vice-President for Academic Affairs");
                                    }
                                }

                            }
                        });

//////////////
                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Administrative")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPosition.removeAllItems();
                        jComboBoxPosition.setEnabled(true);
                        jComboBoxPermission.setEnabled(false);
                        jComboBoxInstitute.setEnabled(false);
                        jComboBoxInstitute.removeAllItems();
                        jButtonSubmit.setEnabled(false);
                        jComboBoxPosition.addItem("Office's Staff ");
                        jComboBoxPosition.addItem("Office's Faculty ");
                        jComboBoxPosition.addItem("Dean/Head/Director ");
                        jComboBoxPosition.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                if (ie.getStateChange() == ItemEvent.SELECTED) {

                                    if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Dean/Head/Director ")) {

                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
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
                                        jComboBoxPermission.addItem("Vice-President for Administrative");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Staff ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("Internal Control Unit Staff");
                                        jComboBoxPermission.addItem("Accounting Office Staff");
                                        jComboBoxPermission.addItem("Budget Office Staff");
                                        jComboBoxPermission.addItem("Cashier Office Staff");
                                        jComboBoxPermission.addItem("Procurement Office Staff");
                                        jComboBoxPermission.addItem("HRMD Staff");
                                        jComboBoxPermission.addItem("Supply and Property Unit Staff");
                                        jComboBoxPermission.addItem("ITSU Staff");
                                        jComboBoxPermission.addItem("General Service Unit Staff");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Faculty ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("Internal Control Unit Faculty");
                                        jComboBoxPermission.addItem("Accounting Office Faculty");
                                        jComboBoxPermission.addItem("Budget Office Faculty");
                                        jComboBoxPermission.addItem("Cashier Office Faculty");
                                        jComboBoxPermission.addItem("Procurement Office Faculty");
                                        jComboBoxPermission.addItem("HRMD Faculty");
                                        jComboBoxPermission.addItem("Supply and Property Unit Faculty");
                                        jComboBoxPermission.addItem("ITSU Faculty");
                                        jComboBoxPermission.addItem("General Service Unit Faculty");
                                    }

                                }

                            }
                        });

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Research Development and Extension")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPosition.removeAllItems();
                        jComboBoxPosition.setEnabled(true);
                        jComboBoxPermission.setEnabled(false);
                        jComboBoxInstitute.setEnabled(false);
                        jComboBoxInstitute.removeAllItems();
                        jButtonSubmit.setEnabled(false);
                        jComboBoxPosition.addItem("Office's Staff  ");
                        jComboBoxPosition.addItem("Office's Faculty  ");
                        jComboBoxPosition.addItem("Dean/Head/Director  ");
                        jComboBoxPosition.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                if (ie.getStateChange() == ItemEvent.SELECTED) {

                                    if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Dean/Head/Director  ")) {
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
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
                                        jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Staff  ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("Journal and Publication Office Staff");
                                        jComboBoxPermission.addItem("Monitoring and Evaluation Unit Staff");
                                        jComboBoxPermission.addItem("Reseach and Development Staff");
                                        jComboBoxPermission.addItem("Director for Extension Staff");
                                        jComboBoxPermission.addItem("CAAD Staff");
                                        jComboBoxPermission.addItem("Cooperative Development Center Staff");
                                        jComboBoxPermission.addItem("Gender and Development Center Staff");
                                        jComboBoxPermission.addItem("Provincial Institute of Agriculture Staff");
                                        jComboBoxPermission.addItem("Sentro ng Wika at Kultura Staff");
                                        jComboBoxPermission.addItem("RAC XI Staff");
                                        jComboBoxPermission.addItem("TIEC Center Staff");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Faculty  ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("Journal and Publication Office Faculty");
                                        jComboBoxPermission.addItem("Monitoring and Evaluation Unit Faculty");
                                        jComboBoxPermission.addItem("Reseach and Development Faculty");
                                        jComboBoxPermission.addItem("Director for Extension Faculty");
                                        jComboBoxPermission.addItem("CAAD Faculty");
                                        jComboBoxPermission.addItem("Cooperative Development Center Faculty");
                                        jComboBoxPermission.addItem("Gender and Development Center Faculty");
                                        jComboBoxPermission.addItem("Provincial Institute of Agriculture Faculty");
                                        jComboBoxPermission.addItem("Sentro ng Wika at Kultura Faculty");
                                        jComboBoxPermission.addItem("RAC XI Faculty");
                                        jComboBoxPermission.addItem("TIEC Center Faculty");
                                    }

                                }

                            }
                        });

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("College Council")) {
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPosition.removeAllItems();
                        jComboBoxPosition.setEnabled(true);
                        jComboBoxPermission.setEnabled(false);
                        jComboBoxInstitute.setEnabled(false);
                        jComboBoxInstitute.removeAllItems();
                        jButtonSubmit.setEnabled(false);
                        jComboBoxPosition.addItem("Office's Staff   ");
                        jComboBoxPosition.addItem("Office's Faculty   ");
                        jComboBoxPosition.addItem("Dean/Head/Director   ");
                        jComboBoxPosition.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                if (ie.getStateChange() == ItemEvent.SELECTED) {

                                    if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Dean/Head/Director   ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
                                        jComboBoxPermission.addItem("Quality of Management Office");
                                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
                                        jComboBoxPermission.addItem("Public Information Officer");
                                        jComboBoxPermission.addItem("Executive Assistant to the President");
                                        jComboBoxPermission.addItem("Director for Planning and Development");
                                        jComboBoxPermission.addItem("Office of Infrastructure Committee");
                                        jComboBoxPermission.addItem("Office of Management Information System");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Staff   ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("DOSCST Alumni Association Staff");
                                        jComboBoxPermission.addItem("Quality of Management Office Staff");
                                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer Staff");
                                        jComboBoxPermission.addItem("Public Information Officer Staff");
                                        jComboBoxPermission.addItem("Executive Assistant to the President Staff");
                                        jComboBoxPermission.addItem("Director for Planning and Development Staff");
                                        jComboBoxPermission.addItem("Infrastructure Committee Staff");
                                        jComboBoxPermission.addItem("Management Information System Staff");
                                    } else if (jComboBoxPosition.getSelectedItem().toString().equalsIgnoreCase("Office's Faculty   ")) {
                                        jComboBoxPermission.removeAllItems();
                                        jComboBoxPermission.setEnabled(true);
                                        jButtonSubmit.setEnabled(false);
                                        jComboBoxPermission.addItem("DOSCST Alumni Association Faculty");
                                        jComboBoxPermission.addItem("Quality of Management Office Faculty");
                                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer Faculty");
                                        jComboBoxPermission.addItem("Public Information Officer Faculty");
                                        jComboBoxPermission.addItem("Executive Assistant to the President Faculty");
                                        jComboBoxPermission.addItem("Director for Planning and Development Faculty");
                                        jComboBoxPermission.addItem("Infrastructure Committee Faculty");
                                        jComboBoxPermission.addItem("Management Information System Faculty");
                                    }

                                }

                            }
                        });

                    }

                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButtonLog = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldLastname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPasswordFieldPassword_1 = new javax.swing.JPasswordField();
        jPasswordFieldPassword_2 = new javax.swing.JPasswordField();
        jComboBoxPermission = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBoxField = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelCourse = new javax.swing.JLabel();
        jComboBoxPosition = new javax.swing.JComboBox<>();
        jComboBoxInstitute = new javax.swing.JComboBox<>();
        jButtonSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Copyright 2019 DoRsu all right reserve ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Document tracking system version 1.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(156, 156, 156))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 102, 0));
        jPanel7.setForeground(new java.awt.Color(204, 102, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 791, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 16, 339, 17));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Register (School Personel Group)");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 13, -1, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel15.setText("Password:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 115, 71, 18));

        jTextFieldName.setNextFocusableComponent(jTextFieldLastname);
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });
        jPanel6.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 69, 339, 40));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel16.setText("Firstname:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 39, 213, 24));
        jPanel6.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 485, 714, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Cancel_22px.png"))); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 493, 174, 40));

        jButtonLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Key_22px.png"))); // NOI18N
        jButtonLog.setText("Login");
        jButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 494, 151, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/log.png"))); // NOI18N
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 220, 136, 116));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("The Davao Oriental State University");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 102, 0));
        jLabel37.setText("(DOrSU) ");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, -1, 30));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Log in DTS Document Tracking System");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Already have an account? ");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, -1, 47));

        jTextFieldUsername.setNextFocusableComponent(jPasswordFieldPassword_1);
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        jPanel6.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 69, 356, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel17.setText("Username:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 44, 71, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel18.setText("Confirm_Password:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 187, 122, 23));

        jTextFieldLastname.setNextFocusableComponent(jButtonSubmit);
        jTextFieldLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastnameActionPerformed(evt);
            }
        });
        jPanel6.add(jTextFieldLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 140, 339, 41));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel21.setText("Lastname:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 115, 71, 19));

        jPasswordFieldPassword_1.setNextFocusableComponent(jPasswordFieldPassword_2);
        jPanel6.add(jPasswordFieldPassword_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 140, 356, 40));

        jPasswordFieldPassword_2.setNextFocusableComponent(jComboBoxField);
        jPanel6.add(jPasswordFieldPassword_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 219, 356, 40));

        jComboBoxPermission.setNextFocusableComponent(jTextFieldName);
        jComboBoxPermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPermissionActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxPermission, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 439, 356, 40));
        jComboBoxPermission.getAccessibleContext().setAccessibleParent(jTextFieldName);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel19.setText("Permission:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 417, 79, 18));

        jComboBoxField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Academic", "Administrative", "Research Development and Extension", "College Council" }));
        jComboBoxField.setNextFocusableComponent(jComboBoxPosition);
        jComboBoxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFieldActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxField, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 289, 356, 40));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel22.setText("Field:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 265, 79, 18));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel20.setText("Position:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 350, 80, -1));

        jLabelCourse.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelCourse.setText("Institute:");
        jPanel6.add(jLabelCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 350, 106, -1));

        jComboBoxPosition.setNextFocusableComponent(jComboBoxInstitute);
        jComboBoxPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxPositionMouseEntered(evt);
            }
        });
        jComboBoxPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPositionActionPerformed(evt);
            }
        });
        jComboBoxPosition.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxPositionKeyReleased(evt);
            }
        });
        jPanel6.add(jComboBoxPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 371, 177, 40));

        jComboBoxInstitute.setNextFocusableComponent(jComboBoxPermission);
        jComboBoxInstitute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxInstituteMouseEntered(evt);
            }
        });
        jComboBoxInstitute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxInstituteKeyReleased(evt);
            }
        });
        jPanel6.add(jComboBoxInstitute, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 371, 177, 40));

        jButtonSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/cheek.png"))); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });
        jButtonSubmit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonSubmitKeyReleased(evt);
            }
        });
        jPanel6.add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 493, 176, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Davao Oriental State University");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setText("Document Tracking System");

        jPanel2.setBackground(new java.awt.Color(204, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(537, 537, 537)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(533, 533, 533)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastnameActionPerformed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed
    LogInPage log;
    private void jButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogActionPerformed
        try {
            if (log == null || log.isClosed()) {
                LogInPage home = new LogInPage();
                home.setVisible(true);
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonLogActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextFieldUsername.setText("");
        jTextFieldName.setText("");
        jPasswordFieldPassword_1.setText("");
        jTextFieldLastname.setText("");
        jPasswordFieldPassword_2.setText("");
        jComboBoxPermission.setSelectedItem("Select");
        jComboBoxInstitute.setSelectedItem("Select");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jComboBoxPermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPermissionActionPerformed
        jButtonSubmit.setEnabled(true);         // TODO add your handling code here

    }//GEN-LAST:event_jComboBoxPermissionActionPerformed

    private void jComboBoxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFieldActionPerformed

    private void jComboBoxPositionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPositionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositionMouseEntered

    private void jComboBoxPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositionActionPerformed

    private void jComboBoxPositionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxPositionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositionKeyReleased

    private void jComboBoxInstituteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxInstituteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstituteMouseEntered

    private void jComboBoxInstituteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxInstituteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstituteKeyReleased

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        register();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButtonSubmitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSubmitKeyReleased
        register();
    }//GEN-LAST:event_jButtonSubmitKeyReleased

    public void register() {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String username = jTextFieldUsername.getText();
        String pass1 = jPasswordFieldPassword_1.getText();
        String pass2 = jPasswordFieldPassword_2.getText();
        String per = String.valueOf(jComboBoxPermission.getSelectedItem());
        String ins = String.valueOf(jComboBoxInstitute.getSelectedItem());
        String name = jTextFieldName.getText();
        String lname = jTextFieldLastname.getText();
        String field = String.valueOf(jComboBoxField.getSelectedItem());
        String program = String.valueOf(jComboBoxInstitute.getSelectedItem());
        String position = String.valueOf(jComboBoxPosition.getSelectedItem());

        try {
            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM users WHERE username='" + username + "' ");
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                JOptionPane.showMessageDialog(null, "Username Already Exist", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (username.length() < 6) {
                JOptionPane.showMessageDialog(null, "Username is Too Short! Minimum of 6 Character", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pass1.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password is Too Short! Minimum of 6 Character", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                if (username.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Add username", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (pass1.equalsIgnoreCase("")) {
                } else if (!pass1.equalsIgnoreCase(pass2)) {
                    JOptionPane.showMessageDialog(null, "Password did not match!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (per.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Add Permission", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (ins.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Add Institute", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (name.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Add Firstname", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (lname.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Add Lastname", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    PreparedStatement ps;
                    String query = "INSERT into users (username,password,permission,institute,name,lastname,field,program,position)values(?,?,?,?,?,?,?,?,?)";
                    try {
                        ps = myConnection.getConnection().prepareStatement(query);
                        ps.setString(1, username);
                        ps.setString(2, pass1);
                        ps.setString(3, per);
                        ps.setString(4, ins);
                        ps.setString(5, name);
                        ps.setString(6, lname);
                        ps.setString(7, field);
                        ps.setString(8, program);
                        ps.setString(9, position);

                        if (ps.executeUpdate() > 0) {
                            JOptionPane.showMessageDialog(null, "You are now registered",
                                    "INFRMATION", JOptionPane.INFORMATION_MESSAGE);
                            try {
                                if (log == null || log.isClosed()) {
                                    LogInPage home = new LogInPage();
                                    home.setVisible(true);
                                    dispose();
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //saveData();
                }
            }

        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonLog;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox<String> jComboBoxField;
    private javax.swing.JComboBox<String> jComboBoxInstitute;
    private javax.swing.JComboBox<String> jComboBoxPermission;
    private javax.swing.JComboBox<String> jComboBoxPosition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCourse;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordFieldPassword_1;
    private javax.swing.JPasswordField jPasswordFieldPassword_2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextFieldLastname;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
