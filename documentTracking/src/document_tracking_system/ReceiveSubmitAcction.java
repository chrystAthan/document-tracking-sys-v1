/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package document_tracking_system;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Thread.sleep;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ReceiveSubmitAcction extends javax.swing.JFrame {

    public ReceiveSubmitAcction() {
        initComponents();
        sub();
        clock();

        System.out.println(jComboBoxPermission);
        jTextFieldFrom.setEnabled(false);
        jTextFieldBy.setEnabled(false);
        jTextDoctype.setEnabled(false);
        jTextAreaDetails.setEnabled(false);
        jTextAreaPurpose.setEnabled(false);
        jButtonReturn.setEnabled(true);
        jButtonDone.setEnabled(true);
    }
    java.sql.Connection con;
    PreparedStatement pst;
    ResultSet rs;
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
                        jComboBoxPermission.addItem("Office of TLR-AEC/QAD");
                        jComboBoxPermission.addItem("Registrar Office");
                        jComboBoxPermission.addItem("Office of Student and Affairs");

                        jComboBoxPermission.addItem("Dean of IALS");
                        jComboBoxPermission.addItem("Dean of IBPA");
                        jComboBoxPermission.addItem("Dean of ICE");
                        jComboBoxPermission.addItem("Dean of IETT");

                        jComboBoxPermission.addItem("Office of Graduate School Coordinator");
                        jComboBoxPermission.addItem("Office of Coordinator of NSTP");
                        jComboBoxPermission.addItem("Director for Instructor");
                        jComboBoxPermission.addItem("Director for Student Service");
                        jComboBoxPermission.addItem("Office of SHS Administrator");
                        jComboBoxPermission.addItem("Office of College Librarian");

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
//    public void sub() {
//
//        jComboBoxField.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent ie) {
//                if (ie.getStateChange() == ItemEvent.SELECTED) {
//                    /////////////
//                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("School President")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("President");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Academic")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Vice-President for Academic Affairs");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Administrative")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Vice-President for Administrative");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Office of College Council")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
//                        jComboBoxPermission.addItem("Head of Quality of Management Office");
//                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
//                        jComboBoxPermission.addItem("Public Information Officer");
//                        jComboBoxPermission.addItem("Executive Assistant to the President");
//                        jComboBoxPermission.addItem("Director for Planning and Development");
//                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
//                        jComboBoxPermission.addItem("Head of Management Information System");
//
//                    }
//
//                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("School President")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("President");
//                        jComboBoxPermission.setEnabled(false);
//
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Reseach Development and Extension")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Administrative")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Vice-President for Administrative");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Office of College Council")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
//                        jComboBoxPermission.addItem("Head of Quality of Management Office");
//                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
//                        jComboBoxPermission.addItem("Public Information Officer");
//                        jComboBoxPermission.addItem("Executive Assistant to the President");
//                        jComboBoxPermission.addItem("Director for Planning and Development");
//                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
//                        jComboBoxPermission.addItem("Head of Management Information System");
//
//                    }
//
//                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("School President")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("President");
//                        jComboBoxPermission.setEnabled(false);
//
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Reseach Development and Extension")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Vice of Academic")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Vice-President for Academic Affairs");
//                        jComboBoxPermission.setEnabled(false);
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Office of College Council")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
//                        jComboBoxPermission.addItem("Head of Quality of Management Office");
//                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
//                        jComboBoxPermission.addItem("Public Information Officer");
//                        jComboBoxPermission.addItem("Executive Assistant to the President");
//                        jComboBoxPermission.addItem("Director for Planning and Development");
//                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
//                        jComboBoxPermission.addItem("Head of Management Information System");
//
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Academic ")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Head of ICE");
//                        jComboBoxPermission.addItem("Head of IALS");
//                        jComboBoxPermission.addItem("Head of IBPA");
//                        jComboBoxPermission.addItem("Head of IETT");
//
//                        jComboBoxPermission.addItem("Head of FASST");
//                        jComboBoxPermission.addItem("Head of Health Service Unit");
//                        jComboBoxPermission.addItem("Head of GCTC");
//                        jComboBoxPermission.addItem("Head of Sports Development Office");
//                        jComboBoxPermission.addItem("Head of TLR-AEC/QAD");
//                        jComboBoxPermission.addItem("Head of Registrar Office");
//                        jComboBoxPermission.addItem("Head of Office of Student and Affairs");
//
//                        jComboBoxPermission.addItem("Dean of IALS");
//                        jComboBoxPermission.addItem("Dean of IBPA");
//                        jComboBoxPermission.addItem("Dean of ICE");
//                        jComboBoxPermission.addItem("Dean of IETT");
//
//                        jComboBoxPermission.addItem("Graduate School Coordinator");
//                        jComboBoxPermission.addItem("Coordinator of NSTP");
//                        jComboBoxPermission.addItem("Director for Instructor");
//                        jComboBoxPermission.addItem("Director for Student Service");
//                        jComboBoxPermission.addItem("SHS Administrator");
//                        jComboBoxPermission.addItem("College Librarian");
//
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Administrative ")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Head of Internal Control Unit");
//                        jComboBoxPermission.addItem("Head of Accounting Office");
//                        jComboBoxPermission.addItem("Head of Budget Office");
//                        jComboBoxPermission.addItem("Head of Cashier Office");
//                        jComboBoxPermission.addItem("Head of Procurement Office");
//                        jComboBoxPermission.addItem("Head of HRMD");
//                        jComboBoxPermission.addItem("Head of Supply and Property Unit");
//                        jComboBoxPermission.addItem("Head of ITSU");
//                        jComboBoxPermission.addItem("Head of General Service Unit");
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Research Development and Extension ")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("Head of Journal and Publication Office");
//                        jComboBoxPermission.addItem("Head of Monitoring and Evaluation Unit");
//                        jComboBoxPermission.addItem("Head of Reseach and Development");
//                        jComboBoxPermission.addItem("Director for Extension");
//                        jComboBoxPermission.addItem("Head of CAAD");
//                        jComboBoxPermission.addItem("Director of Cooperative Development Center");
//                        jComboBoxPermission.addItem("Director of Gender and Development Center");
//                        jComboBoxPermission.addItem("Director of Provincial Institute of Agriculture");
//                        jComboBoxPermission.addItem("Director of Sentro ng Wika at Kultura");
//                        jComboBoxPermission.addItem("Director of RAC XI");
//                        jComboBoxPermission.addItem("Director of TIEC Center");
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("College Council ")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
//                        jComboBoxPermission.addItem("Head of Quality of Management Office");
//                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
//                        jComboBoxPermission.addItem("Public Information Officer");
//                        jComboBoxPermission.addItem("Executive Assistant to the President");
//                        jComboBoxPermission.addItem("Director for Planning and Development");
//                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
//                        jComboBoxPermission.addItem("Head of Management Information System");
//
//                    }
//                    /////////////
//                    if (("Head of ICE".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of ICE");
//                    } else {
//                        jComboBoxPermission.addItem("Head of ICE");
//                    }
//                    if (("Head of IALS".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of IALS");
//                    } else {
//                        jComboBoxPermission.addItem("Head of IALS");
//                    }
//                    if (("Head of IBPA".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of IBPA");
//                    } else {
//                        jComboBoxPermission.addItem("Head of IBPA");
//                    }
//                    if (("Head of IETT".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of IETT");
//                    } else {
//                        jComboBoxPermission.addItem("Head of IETT");
//                    }
//                    if (("President of DOSCST Alumni Association".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("President of DOSCST Alumni Association");
//                    } else {
//                        jComboBoxPermission.addItem("President of DOSCST Alumni Association");
//                    }
//                    if (("Head of Quality of Management Office".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of Quality of Management Office");
//                    } else {
//                        jComboBoxPermission.addItem("Head of Quality of Management Office");
//                    }
//                    if (("Entrepreneurship and Management Officer".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Entrepreneurship and Management Officer");
//                    } else {
//                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
//                    }
//                    if (("Public Information Officer".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Public Information Officer");
//                    } else {
//                        jComboBoxPermission.addItem("Public Information Officer");
//                    }
//                    if (("Executive Assistant to the President".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Executive Assistant to the President");
//                    } else {
//                        jComboBoxPermission.addItem("Executive Assistant to the President");
//                    }
//                    if (("Director for Planning and Development".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Director for Planning and Development");
//                    } else {
//                        jComboBoxPermission.addItem("Director for Planning and Development");
//                    }
//                    if (("Head of Infrastructure Committee".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of Infrastructure Committee");
//                    } else {
//                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
//                    }
//                    if (("Head of Management Information System".equals(jLabelPermission.getText()))) {
//                        jComboBoxPermission.removeItem("Head of Management Information System");
//                    } else {
//                        jComboBoxPermission.addItem("Head of Management Information System");
//                    }
//                    ////////////////
//                    if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Academic")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//                        jComboBoxPermission.addItem("Head of ICE");
//                        jComboBoxPermission.addItem("Head of IALS");
//                        jComboBoxPermission.addItem("Head of IBPA");
//                        jComboBoxPermission.addItem("Head of IETT");
//
//                        if (("Dean of IALS".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Dean of IALS");
//
//                            jComboBoxPermission.removeItem("Head of IALS");
//                            jComboBoxPermission.removeItem("Head of IBPA");
//                            jComboBoxPermission.removeItem("Head of ICE");
//                            jComboBoxPermission.removeItem("Head of IETT");
//                        } else {
//                            jComboBoxPermission.addItem("Dean of IALS");
//                        }
//                        if (("Dean of IBPA".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Dean of IBPA");
//
//                            jComboBoxPermission.removeItem("Head of IALS");
//                            jComboBoxPermission.removeItem("Head of IBPA");
//                            jComboBoxPermission.removeItem("Head of ICE");
//                            jComboBoxPermission.removeItem("Head of IETT");
//                        } else {
//                            jComboBoxPermission.addItem("Dean of IBPA");
//                        }
//                        if (("Dean of ICE".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Dean of ICE");
//
//                            jComboBoxPermission.removeItem("Head of IALS");
//                            jComboBoxPermission.removeItem("Head of IBPA");
//                            jComboBoxPermission.removeItem("Head of ICE");
//                            jComboBoxPermission.removeItem("Head of IETT");
//                        } else {
//                            jComboBoxPermission.addItem("Dean of ICE");
//                        }
//                        if (("Dean of IETT".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Dean of IETT");
//
//                            jComboBoxPermission.removeItem("Head of IALS");
//                            jComboBoxPermission.removeItem("Head of IBPA");
//                            jComboBoxPermission.removeItem("Head of ICE");
//                            jComboBoxPermission.removeItem("Head of IETT");
//                        } else {
//                            jComboBoxPermission.addItem("Dean of IETT");
//                        }
//
//                        if (("Head of FASST".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of FASST");
//                        } else {
//                            jComboBoxPermission.addItem("Head of FASST");
//                        }
//                        if (("Head of Health Service Unit".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Health Service Unit");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Health Service Unit");
//                        }
//                        if (("Head of GCTC".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of GCTC");
//                        } else {
//                            jComboBoxPermission.addItem("Head of GCTC");
//                        }
//                        if (("Head of Sports Development Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Sports Development Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Sports Development Office");
//                        }
//                        if (("Head of TLR-AEC/QAD".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of TLR-AEC/QAD");
//                        } else {
//                            jComboBoxPermission.addItem("Head of TLR-AEC/QAD");
//                        }
//                        if (("Head of Registrar Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Registrar Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Registrar Office");
//                        }
//                        if (("Head of Office of Student and Affairs".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Office of Student and Affairs");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Office of Student and Affairs");
//                        }
//                        if (("Graduate School Coordinator".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Graduate School Coordinator");
//                        } else {
//                            jComboBoxPermission.addItem("Graduate School Coordinator");
//                        }
//                        if (("Coordinator of NSTP".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Coordinator of NSTP");
//                        } else {
//                            jComboBoxPermission.addItem("Coordinator of NSTP");
//                        }
//                        if (("Director for Instructor".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director for Instructor");
//                        } else {
//                            jComboBoxPermission.addItem("Director for Instructor");
//                        }
//                        if (("Director for Student Service".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director for Student Service");
//                        } else {
//                            jComboBoxPermission.addItem("Director for Student Service");
//                        }
//                        if (("SHS Administrator".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("SHS Administrator");
//                        } else {
//                            jComboBoxPermission.addItem("SHS Administrator");
//                        }
//                        if (("SCollege Librarian".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("College Librarian");
//                        } else {
//                            jComboBoxPermission.addItem("College Librarian");
//                        }
//
//                        if (("Vice-President for Academic Affairs".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Vice-President for Academic Affairs");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Vice-President for Academic Affairs");
//                        }
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Administrative")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//                        if (("Head of ITSU".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of ITSU");
//                        } else {
//                            jComboBoxPermission.addItem("Head of ITSU");
//                        }
//                        if (("Head of Internal Control Unit".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Internal Control Unit");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Internal Control Unit");
//                        }
//                        if (("Head of Accounting Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Accounting Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Accounting Office");
//                        }
//                        if (("Head of Budget Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Budget Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Budget Office");
//                        }
//                        if (("Head of Cashier Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Cashier Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Cashier Office");
//                        }
//                        if (("Head of Procurement Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Procurement Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Procurement Office");
//                        }
//                        if (("Head of HRMD".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of HRMD");
//                        } else {
//                            jComboBoxPermission.addItem("Head of HRMD");
//                        }
//                        if (("Head of Supply and Property Unit".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Supply and Property Unit");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Supply and Property Unit");
//                        }
//                        if (("Head of General Service Unit".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of General Service Unit");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Supply and Property Unit");
//                        }
//                        if (("Vice-President for Administrative".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Vice-President for Administrative");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Vice-President for Administrative");
//
//                        }
//
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Research Development and Extension")) {
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//
//                        if (("Head of Journal and Publication Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Journal and Publication Office");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Journal and Publication Office");
//                        }
//
//                        if (("Head of Monitoring and Evaluation Unit".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Monitoring and Evaluation Unit");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Journal and Publication Office");
//                        }
//                        if (("Head of Reseach and Development".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Reseach and Development");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Reseach and Development");
//                        }
//                        if (("Director for Extension".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director for Extension");
//                        } else {
//                            jComboBoxPermission.addItem("Director for Extension");
//                        }
//                        if (("Head of CAAD".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of CAAD");
//                        } else {
//                            jComboBoxPermission.addItem("Head of CAAD");
//                        }
//                        if (("Director of Cooperative Development Center".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director of Cooperative Development Center");
//                        } else {
//                            jComboBoxPermission.addItem("Director of Cooperative Development Center");
//                        }
//                        if (("Director of Gender and Development Center".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director of Gender and Development Center");
//                        } else {
//                            jComboBoxPermission.addItem("Director of Gender and Development Center");
//                        }
//                        if (("Director of Provincial Institute of Agriculture".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director of Provincial Institute of Agriculture");
//                        } else {
//                            jComboBoxPermission.addItem("Director of Provincial Institute of Agriculture");
//                        }
//                        if (("Director of Sentro ng Wika at Kultura".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director of Sentro ng Wika at Kultura");
//                        } else {
//                            jComboBoxPermission.addItem("Director of Sentro ng Wika at Kultura");
//                        }
//                        if (("Director of RAC XI".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director of RAC XI");
//                        } else {
//                            jComboBoxPermission.addItem("Director of RAC XI");
//                        }
//                        if (("Director of TIEC Center".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director of TIEC Center");
//                        } else {
//                            jComboBoxPermission.addItem("Director of TIEC Center");
//                        }
//                        if (("Vice-President for Reseach Development and Extension".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Vice-President for Reseach Development and Extension");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Vice-President for Reseach Development and Extension");
//
//                        }
//                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("College Council")) {
//
//                        jComboBoxPermission.removeAllItems();
//                        jComboBoxPermission.setEnabled(true);
//
//                        if (("President of DOSCST Alumni Association".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("President of DOSCST Alumni Association");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("President of DOSCST Alumni Association");
//                        }
//                        if (("Head of Quality of Management Office".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Quality of Management Office");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Quality of Management Office");
//                        }
//                        if (("Entrepreneurship and Management Officer".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Entrepreneurship and Management Officer");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
//                        }
//                        if (("Public Information Officer".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Public Information Officer");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Public Information Officer");
//                        }
//                        if (("Executive Assistant to the President".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Executive Assistant to the President");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Executive Assistant to the President");
//                        }
//                        if (("Director for Planning and Development".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Director for Planning and Development");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Director for Planning and Development");
//                        }
//                        if (("Head of Infrastructure Committee".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Infrastructure Committee");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Infrastructure Committee");
//                        }
//                        if (("Head of Management Information System".equals(jLabelPermission.getText()))) {
//                            jComboBoxPermission.removeItem("Head of Management Information System");
//                            jComboBoxPermission.addItem("President");
//                        } else {
//                            jComboBoxPermission.addItem("Head of Management Information System");
//                        }
//
//                    }
//                }
//
//            }
//        });
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonReturn = new javax.swing.JButton();
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
        jComboBoxPermission = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTextDoctype = new javax.swing.JTextField();
        jButtonDone = new javax.swing.JButton();
        jLabelPermission = new javax.swing.JLabel();
        jLabelTrackingForPending = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabelUserID = new javax.swing.JLabel();
        jLabelStatusForwarded = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jButtonReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Go Back_22px.png"))); // NOI18N
        jButtonReturn.setText("Return");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        jButtonSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/forward.png"))); // NOI18N
        jButtonSubmit.setText("Forward");
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

        jComboBoxPermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPermissionActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel17.setText("Field:");

        jButtonDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Ok_22px.png"))); // NOI18N
        jButtonDone.setText("Done");
        jButtonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextDoctype, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldBy, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxField, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextDoctype, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 590));

        jLabelPermission.setText("Permission");
        getContentPane().add(jLabelPermission, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 30, 36));

        jLabelTrackingForPending.setText("Tracking");
        getContentPane().add(jLabelTrackingForPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, -1, 33));

        jLabelTime.setText("time");
        getContentPane().add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 86, 33));

        jLabelUserID.setText("userid");
        getContentPane().add(jLabelUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 86, 33));

        jLabelStatusForwarded.setText("Forwarded");
        getContentPane().add(jLabelStatusForwarded, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 86, 33));

        jLabelUsername.setText("username");
        getContentPane().add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 83, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        saveToViewdetailsFromPendingReturn();
        SaveToOutGoingReturn();
        saveToPendingListReturn();
        updateTracingPageReturn();
        deletePendingReturn();
        incomingReturn();
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReturnActionPerformed
    public void saveToPendingListRejected() {

        try {
            String status = "Done";
            String tracking_data = jLabelTrackingForPending.getText().trim();
            String from_data = jTextFieldFrom.getText().trim();
            String by_data = jTextFieldBy.getText().trim();
            String to_data = jLabelUsername.getText().trim();
            String type_data = jTextDoctype.getText().trim();
            String purpose_data = jTextAreaPurpose.getText().trim();
            String Details = jTextAreaDetails.getText().trim();
            String postedTime = jLabelTime.getText().trim();
            String userId = jLabelUserID.getText().trim();
            String forwardBy = jLabelPermission.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into pendinglist (tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data,userID,forwarded_by)values(?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(11, forwardBy);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void saveToViewdetailsRejected() {

        try {
            String status = "Done";
            String tracking_data = jLabelTrackingForPending.getText().trim();
            String from_data = jTextFieldFrom.getText().trim();
            String by_data = jTextFieldBy.getText().trim();
            String destination = jLabelUsername.getText().trim();
            String doctype = jTextDoctype.getText().trim();
            String actionNeeded = jTextAreaPurpose.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String time = jLabelTime.getText().trim();
            String userId = jLabelUserID.getText().trim();

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

    public void deleteTrackingPage() {
        String from = jLabelTrackingForPending.getText().trim();
        //   String to = jComboBoxPermission.getSelectedItem().toString();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from trackingpage where tracking_data='" + from + "'");
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SaveToOutGoing() {

        try {
            String status = "Forwarded";
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String type = jTextDoctype.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String tosend = jComboBoxPermission.getSelectedItem().toString();
            String time = jLabelTime.getText().trim();
            String ussid = jLabelUserID.getText().trim();
            String trId = jLabelTrackingForPending.getText();
            String subBy = jLabelUsername.getText();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into outgoing(from_data,by_data,documenttype_data, details_data, purpose_data, to_data,postedtime_data,userID,tracking_number,status,forwarded_by)values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, from);
            pst.setString(2, by);
            pst.setString(3, type);
            pst.setString(4, details);
            pst.setString(5, purpose);
            pst.setString(6, tosend);
            pst.setString(7, time);
            pst.setString(8, ussid);
            pst.setString(9, trId);
            pst.setString(10, status);
            pst.setString(11, subBy);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void incoming() {

        try {
            String tracking = jLabelTrackingForPending.getText();
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String tosend = jComboBoxPermission.getSelectedItem().toString();
            String type = jTextDoctype.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String time = jLabelTime.getText().trim();
            String ussid = jLabelUserID.getText();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into incoming(tracking_data,from_data,by_data,to_data,documenttype_data,purpose_data, details_data,postedtime_data,userID)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking);
            pst.setString(2, from);
            pst.setString(3, by);
            pst.setString(4, tosend);
            pst.setString(5, type);
            pst.setString(6, purpose);
            pst.setString(7, details);
            pst.setString(8, time);
            pst.setString(9, ussid);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveToPendingList() {

        try {
            String status = "Accepted";
            String tracking_data = jLabelTrackingForPending.getText().trim();
            String from_data = jTextFieldFrom.getText().trim();
            String by_data = jTextFieldBy.getText().trim();
            String to_data = jComboBoxPermission.getSelectedItem().toString();
            String type_data = jTextDoctype.getText().trim();
            String purpose_data = jTextAreaPurpose.getText().trim();
            String Details = jTextAreaDetails.getText().trim();
            String postedTime = jLabelTime.getText().trim();
            String userId = jLabelUserID.getText().trim();
            String forwardBy = jLabelPermission.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into pendinglist (tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data,userID,forwarded_by)values(?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(11, forwardBy);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void saveToViewdetailsFromPending() {

        try {
            String tracking_data = jLabelTrackingForPending.getText().trim();
            String from_data = jTextFieldFrom.getText().trim();
            String by_data = jTextFieldBy.getText().trim();
            String destination = jComboBoxPermission.getSelectedItem().toString();
            String doctype = jTextDoctype.getText().trim();
            String actionNeeded = jTextAreaPurpose.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String status = jLabelStatusForwarded.getText().trim();
            String time = jLabelTime.getText().trim();
            String userId = jLabelUserID.getText().trim();

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

    public void updateTracingPage() {
        String trackID = jLabelTrackingForPending.getText().trim();
        String to = jComboBoxPermission.getSelectedItem().toString();
        String status = "Forwarded";
        String time = jLabelTime.getText();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("UPDATE trackingpage SET to_data = '" + to + "', status = '" + status + "',postedtime_data ='" + time + "' where tracking_data ='" + trackID + "'");
            pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deletePending() {
        String from = jLabelTrackingForPending.getText().trim();
        //       String to = jComboBoxPermission.getSelectedItem().toString();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from pending where tracking_number ='" + from + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Success!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed

        saveToPendingList();
        incoming();
        saveToViewdetailsFromPending();
        SaveToOutGoing();
        updateTracingPage();
        deletePending();
        dispose();
    }//GEN-LAST:event_jButtonSubmitActionPerformed
    public void InsertIntoTrackingHistoryRejected() {

        try {

            String status = "Done";
            String tracking = jLabelTrackingForPending.getText();
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String tosend = jLabelUsername.getText().trim();
            String type = jTextDoctype.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String time = jLabelTime.getText().trim();
            String ussid = jLabelUserID.getText();
            int number = Integer.parseInt(ussid);
            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into trackinghistory(tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data, details_data,postedtime_data,userID,status)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking);
            pst.setString(2, from);
            pst.setString(3, by);
            pst.setString(4, tosend);
            pst.setString(5, type);
            pst.setString(6, purpose);
            pst.setString(7, details);
            pst.setString(8, time);
            pst.setInt(9, number);
            pst.setString(10, status);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveToViewdetailsFromPendingReturn() {

        try {

            String tracking_data = jLabelTrackingForPending.getText().trim();
            String from_data = jTextFieldFrom.getText().trim();
            String by_data = jTextFieldBy.getText().trim();
            String destination = jTextFieldBy.getText().trim();
            String doctype = jTextDoctype.getText().trim();
            String actionNeeded = jTextAreaPurpose.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String status = jLabelStatusForwarded.getText().trim();
            String time = jLabelTime.getText().trim();
            String userId = jLabelUserID.getText().trim();

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

    public void SaveToOutGoingReturn() {

        try {
            String status = "Return";
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String type = jTextDoctype.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String tosend = jTextFieldBy.getText().trim();
            String time = jLabelTime.getText().trim();
            String ussid = jLabelUserID.getText().trim();
            String trId = jLabelTrackingForPending.getText();
            String subBy = jLabelPermission.getText();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into outgoing(from_data,by_data,documenttype_data, details_data, purpose_data, to_data,postedtime_data,userID,tracking_number,status,forwarded_by)values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, from);
            pst.setString(2, by);
            pst.setString(3, type);
            pst.setString(4, details);
            pst.setString(5, purpose);
            pst.setString(6, tosend);
            pst.setString(7, time);
            pst.setString(8, ussid);
            pst.setString(9, trId);
            pst.setString(10, status);
            pst.setString(11, subBy);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void saveToPendingListReturn() {

        try {
            String status = "Accepted";
            String tracking_data = jLabelTrackingForPending.getText().trim();
            String from_data = jTextFieldFrom.getText().trim();
            String by_data = jTextFieldBy.getText().trim();
            String to_data = jTextFieldBy.getText().trim();
            String type_data = jTextDoctype.getText().trim();
            String purpose_data = jTextAreaPurpose.getText().trim();
            String Details = jTextAreaDetails.getText().trim();
            String postedTime = jLabelTime.getText().trim();
            String userId = jLabelUserID.getText().trim();
            String forwardBy = jLabelPermission.getText().trim();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into pendinglist (tracking_number,from_data,by_data,to_data,documenttype_data,purpose_data,details_data,status,postedtime_data,userID,forwarded_by)values(?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(11, forwardBy);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateTracingPageReturn() {
        String trackID = jLabelTrackingForPending.getText().trim();
        String to = jTextFieldBy.getText().trim();
        String status = "Forwarded";
        String time = jLabelTime.getText();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("UPDATE trackingpage SET to_data = '" + to + "', status = '" + status + "',postedtime_data ='" + time + "' where tracking_data ='" + trackID + "'");
            pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deletePendingReturn() {
        String from = jLabelTrackingForPending.getText().trim();
        String to = jTextFieldBy.getText().trim();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from pending where tracking_number ='" + from + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Success!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void incomingReturn() {

        try {
            String tracking = jLabelTrackingForPending.getText();
            String from = jTextFieldFrom.getText().trim();
            String by = jTextFieldBy.getText().trim();
            String tosend = jTextFieldBy.getText().trim();
            String type = jTextDoctype.getText().trim();
            String purpose = jTextAreaPurpose.getText().trim();
            String details = jTextAreaDetails.getText().trim();
            String time = jLabelTime.getText().trim();
            String ussid = jLabelUserID.getText();

            con = myConnection.getConnection();
            pst = con.prepareStatement("insert into incoming(tracking_data,from_data,by_data,to_data,documenttype_data,purpose_data, details_data,postedtime_data,userID)values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tracking);
            pst.setString(2, from);
            pst.setString(3, by);
            pst.setString(4, tosend);
            pst.setString(5, type);
            pst.setString(6, purpose);
            pst.setString(7, details);
            pst.setString(8, time);
            pst.setString(9, ussid);
            pst.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void jTextFieldFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFromActionPerformed

    }//GEN-LAST:event_jTextFieldFromActionPerformed

    private void jComboBoxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFieldActionPerformed
        jButtonSubmit.setEnabled(true);
        jButtonReturn.setEnabled(false);
        jButtonDone.setEnabled(false);
    }//GEN-LAST:event_jComboBoxFieldActionPerformed

    private void jComboBoxPermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPermissionActionPerformed
        jButtonSubmit.setEnabled(true);
        jButtonReturn.setEnabled(false);
        jButtonDone.setEnabled(false);

// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPermissionActionPerformed

    private void jButtonSubmitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSubmitKeyReleased
        if (evt.getKeyCode() == com.sun.glass.events.KeyEvent.VK_ENTER) {
            submit();
        }
    }//GEN-LAST:event_jButtonSubmitKeyReleased

    private void jButtonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoneActionPerformed
        InsertIntoTrackingHistoryRejected();
        saveToViewdetailsRejected();
        saveToPendingListRejected();
        deleteTrackingPage();
        deletePending();
        dispose();
    }//GEN-LAST:event_jButtonDoneActionPerformed

    public void submit() {
        saveToPendingList();
        incoming();
        saveToViewdetailsFromPending();
        SaveToOutGoing();
        updateTracingPage();
        deletePending();
        dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonDone;
    public javax.swing.JButton jButtonReturn;
    public javax.swing.JButton jButtonSubmit;
    public javax.swing.JComboBox<String> jComboBoxField;
    public javax.swing.JComboBox<String> jComboBoxPermission;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelPermission;
    public javax.swing.JLabel jLabelStatusForwarded;
    public javax.swing.JLabel jLabelTime;
    public javax.swing.JLabel jLabelTrackingForPending;
    public javax.swing.JLabel jLabelUserID;
    public javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    public javax.swing.JTextArea jTextAreaDetails;
    public javax.swing.JTextArea jTextAreaPurpose;
    public javax.swing.JTextField jTextDoctype;
    public javax.swing.JTextField jTextFieldBy;
    public javax.swing.JTextField jTextFieldFrom;
    // End of variables declaration//GEN-END:variables

    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
