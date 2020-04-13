/*
 * To change this license header, choose License Deaners in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package document_tracking_system;

import com.mysql.jdbc.Connection;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class Admin extends JFrame {

    public Admin(String username) {
        initComponents();
        ///     autoId();
        clock();
    //    jButtonDocuments.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        reg();

        jTableAccount.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableAccount.setRowHeight(30);

        jTableDocuments.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTableDocuments.setRowHeight(30);
        //
        //visend
        jLabel19s.setText(username);
        jLabel24.setText(username);

        jTableDocuments.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    int row = jTableDocuments.getSelectedRow();
                    if (row == -1) {

                    } else {
                        jButtonDocuments.setEnabled(true);
                        jLabelDocum.setText(jTableDocuments.getValueAt(row, 0).toString());

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

        jTableAccount.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    int row = jTableAccount.getSelectedRow();
                    if (row == -1) {

                    } else {
                        jButtonUpdate.setEnabled(true);
                        jButtonDelete.setEnabled(true);
                        jTextFieldFirstnameACC.setText(jTableAccount.getValueAt(row, 0).toString());
                        jPasswordLastnameACC.setText(jTableAccount.getValueAt(row, 1).toString());
                        jTextFieldUNameACC.setText(jTableAccount.getValueAt(row, 2).toString());
                        jTextFieldPasACC.setText(jTableAccount.getValueAt(row, 3).toString());
                        jPasswordUserID.setText(jTableAccount.getValueAt(row, 4).toString());

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
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldLastname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPasswordFieldPassword_1 = new javax.swing.JPasswordField();
        jPasswordFieldPassword_2 = new javax.swing.JPasswordField();
        jComboBoxPermission = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxField = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabelCourse = new javax.swing.JLabel();
        jComboBoxPosition = new javax.swing.JComboBox<>();
        jComboBoxInstitute = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButtonSubmit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDocuments = new javax.swing.JTable();
        jTextFieldDocument = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButtonTransactionHistoryV4 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jButtonDocuments = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldUNameACC = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldFirstnameACC = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAccount = new javax.swing.JTable();
        jTextFieldPasACC = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldAccounts = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPasswordLastnameACC = new javax.swing.JTextField();
        jPasswordUserID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelDocum = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelLastname = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabel19s = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jButtonSubmit7 = new javax.swing.JButton();
        jButtonHomeV = new javax.swing.JButton();
        jButtonTransactionHistoryV1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 102, 0));
        jLabel21.setText("Admin Page ");

        jLabel42.setBackground(new java.awt.Color(102, 102, 102));
        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Date");

        jLabelTime.setBackground(new java.awt.Color(102, 102, 102));
        jLabelTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTime.setText("December/12/ 2019");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 672, Short.MAX_VALUE)
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
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 1070, 30));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel11.setBackground(new java.awt.Color(204, 102, 0));
        jPanel11.setForeground(new java.awt.Color(204, 102, 0));
        jPanel11.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Add User'");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel15.setText("Password:");

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel17.setText("Firstname:");

        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel20.setText("Username:");

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel27.setText("Confirm_Password:");

        jTextFieldLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastnameActionPerformed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel28.setText("Lastname:");

        jComboBoxPermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPermissionActionPerformed(evt);
            }
        });

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel38.setText("Permission:");

        jComboBoxField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Academic", "Administrative", "Research Development and Extension", "College Council" }));
        jComboBoxField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFieldActionPerformed(evt);
            }
        });

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel39.setText("Field:");

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel41.setText("Position:");

        jLabelCourse.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCourse.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelCourse.setText("Institute:");

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

        jComboBoxInstitute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxInstituteMouseEntered(evt);
            }
        });
        jComboBoxInstitute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstituteActionPerformed(evt);
            }
        });
        jComboBoxInstitute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBoxInstituteKeyReleased(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Davao_Oriental_State_College_of_Science_and_Technology.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("The Davao Oriental State University");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("is a state university in Mati City, Davao Oriental,");

        jButtonSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/cheek.png"))); // NOI18N
        jButtonSubmit.setText("Add");
        jButtonSubmit.setFocusable(false);
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Cancel_22px.png"))); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(369, 369, 369)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxField, 0, 391, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldPassword_2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordFieldPassword_1)
                                .addComponent(jTextFieldUsername))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(jLabelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jComboBoxPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxInstitute, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldLastname, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(52, 52, 52))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldPassword_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldPassword_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jComboBoxField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabelCourse))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxInstitute, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel20.setBackground(new java.awt.Color(204, 102, 0));
        jPanel20.setForeground(new java.awt.Color(204, 102, 0));
        jPanel20.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Delete Documents");

        jTableDocuments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking Number", "From", "Document Type", "details", "Purpose", "Date Submitted"
            }
        ));
        jScrollPane2.setViewportView(jTableDocuments);

        jTextFieldDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDocumentActionPerformed(evt);
            }
        });
        jTextFieldDocument.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDocumentKeyReleased(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButtonTransactionHistoryV4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonTransactionHistoryV4.setForeground(new java.awt.Color(51, 51, 51));
        jButtonTransactionHistoryV4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Cancel Subscription_22px.png"))); // NOI18N
        jButtonTransactionHistoryV4.setText("Delete");
        jButtonTransactionHistoryV4.setAlignmentY(0.0F);
        jButtonTransactionHistoryV4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonTransactionHistoryV4.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jButtonTransactionHistoryV4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionHistoryV4ActionPerformed(evt);
            }
        });

        jLabel44.setBackground(new java.awt.Color(102, 102, 102));
        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("Delete Records");

        jButtonDocuments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButtonDocuments.setText("Refresh");
        jButtonDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentsActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Delete Document's");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jTextFieldDocument, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(410, 410, 410)
                                .addComponent(jButtonTransactionHistoryV4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTransactionHistoryV4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel18.setBackground(new java.awt.Color(204, 102, 0));
        jPanel18.setForeground(new java.awt.Color(204, 102, 0));
        jPanel18.setPreferredSize(new java.awt.Dimension(100, 2));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Edit Account(Setting)");

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel35.setText("LastName:");

        jTextFieldUNameACC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUNameACCActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel36.setText("UserName:");

        jTextFieldFirstnameACC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstnameACCActionPerformed(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel37.setText("FirstName:");

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel49.setText("Password:");

        jTableAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firstname", "Lastname", "Username", "Password", "userID"
            }
        ));
        jScrollPane1.setViewportView(jTableAccount);

        jTextFieldPasACC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPasACCActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Search Property_22px.png"))); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(51, 51, 51));
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Cancel Subscription_22px.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.setAlignmentY(0.0F);
        jButtonDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonDelete.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTextFieldAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAccountsActionPerformed(evt);
            }
        });
        jTextFieldAccounts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAccountsKeyReleased(evt);
            }
        });

        jLabel45.setBackground(new java.awt.Color(102, 102, 102));
        jLabel45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Delete Records");

        jButtonUpdate.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(51, 51, 51));
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/register.png"))); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.setAlignmentY(0.0F);
        jButtonUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUpdate.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Refresh_22px.png"))); // NOI18N
        jButton31.setText("Refresh");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jPasswordLastnameACC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordLastnameACCActionPerformed(evt);
            }
        });

        jPasswordUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordUserIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFirstnameACC)
                            .addComponent(jPasswordLastnameACC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jPasswordUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(143, 143, 143)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldUNameACC)
                                .addComponent(jTextFieldPasACC, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jTextFieldAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFirstnameACC, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextFieldUNameACC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPasACC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordLastnameACC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jTextFieldAccounts)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordUserID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", jPanel25);

        jLabelDocum.setText("jLabel2");

        jLabelName.setText("jLabel2");

        jLabelLastname.setText("jLabel2");

        jLabelUsername.setText("jLabel2");

        jLabelPassword.setText("jLabel2");

        jLabel19s.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel19s.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19s.setText("Admin");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDocum)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelName)
                                .addGap(46, 46, 46)
                                .addComponent(jLabelLastname)
                                .addGap(31, 31, 31)
                                .addComponent(jLabelUsername)
                                .addGap(39, 39, 39)
                                .addComponent(jLabelPassword))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel19s, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(742, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocum)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jLabel19s)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jLabelLastname)
                    .addComponent(jLabelUsername)
                    .addComponent(jLabelPassword))
                .addContainerGap(483, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel1);

        jPanel10.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 1060, 590));

        jPanel7.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAVAO ORIENTAL STATE UNIVERSITY");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Person_48px.png"))); // NOI18N

        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/icons8_Exit_22px.png"))); // NOI18N
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Log-out");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Admin");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 693, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(98, 98, 98)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addGap(70, 70, 70))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(19, 19, 19))
        );

        jPanel10.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 1060, 10));

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 250, 10));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Person_48px.png"))); // NOI18N
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, 50));
        jPanel8.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 250, 10));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Admin Page");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 90, 140, 30));

        jButtonSubmit7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Settings_30px.png"))); // NOI18N
        jButtonSubmit7.setText("Edit Account's");
        jButtonSubmit7.setFocusable(false);
        jButtonSubmit7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmit7ActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonSubmit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, 40));

        jButtonHomeV.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonHomeV.setForeground(new java.awt.Color(51, 51, 51));
        jButtonHomeV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/home.png"))); // NOI18N
        jButtonHomeV.setText("Add User's");
        jButtonHomeV.setAlignmentY(0.0F);
        jButtonHomeV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonHomeV.setMargin(new java.awt.Insets(2, 30, 2, 1));
        jButtonHomeV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeVActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonHomeV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, 40));

        jButtonTransactionHistoryV1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonTransactionHistoryV1.setForeground(new java.awt.Color(51, 51, 51));
        jButtonTransactionHistoryV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document_tracking_system/images/Cancel Subscription_22px.png"))); // NOI18N
        jButtonTransactionHistoryV1.setText("Delete Documents");
        jButtonTransactionHistoryV1.setAlignmentY(0.0F);
        jButtonTransactionHistoryV1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonTransactionHistoryV1.setMargin(new java.awt.Insets(0, 20, 0, 0));
        jButtonTransactionHistoryV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionHistoryV1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonTransactionHistoryV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 190, 40));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Logged in");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Admin");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jPanel10.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 600));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Document tracking system version 1.0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Copyright 2019 DOrSU all right reserve ");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(67, 67, 67))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1366, 765));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
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

                                        jComboBoxPermission.addItem("Head of FASST");
                                        jComboBoxPermission.addItem("Head of Health Service Unit");
                                        jComboBoxPermission.addItem("Head of GCTC");
                                        jComboBoxPermission.addItem("Head of Sports Development Office");
                                        jComboBoxPermission.addItem("Head of TLR-AEC/QAD");
                                        jComboBoxPermission.addItem("Head of Registrar Office");
                                        jComboBoxPermission.addItem("Head of Office of Student and Affairs");

                                        jComboBoxPermission.addItem("Graduate School Coordinator");
                                        jComboBoxPermission.addItem("Coordinator of NSTP");
                                        jComboBoxPermission.addItem("Director for Instructor");
                                        jComboBoxPermission.addItem("Director for Student Service");
                                        jComboBoxPermission.addItem("SHS Administrator");
                                        jComboBoxPermission.addItem("College Librarian");
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
                                        jComboBoxPermission.addItem("Head of Internal Control Unit");
                                        jComboBoxPermission.addItem("Head of Accounting Office");
                                        jComboBoxPermission.addItem("Head of Budget Office");
                                        jComboBoxPermission.addItem("Head of Cashier Office");
                                        jComboBoxPermission.addItem("Head of Procurement Office");
                                        jComboBoxPermission.addItem("Head of HRMD");
                                        jComboBoxPermission.addItem("Head of Supply and Property Unit");
                                        jComboBoxPermission.addItem("Head of ITSU");
                                        jComboBoxPermission.addItem("Head of General Service Unit");
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
                                        jComboBoxPermission.addItem("Head of Journal and Publication Office");
                                        jComboBoxPermission.addItem("Head of Monitoring and Evaluation Unit");
                                        jComboBoxPermission.addItem("Head of Reseach and Development");
                                        jComboBoxPermission.addItem("Director for Extension");
                                        jComboBoxPermission.addItem("Head of CAAD");
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
                                        jComboBoxPermission.addItem("Head of Quality of Management Office");
                                        jComboBoxPermission.addItem("Entrepreneurship and Management Officer");
                                        jComboBoxPermission.addItem("Public Information Officer");
                                        jComboBoxPermission.addItem("Executive Assistant to the President");
                                        jComboBoxPermission.addItem("Director for Planning and Development");
                                        jComboBoxPermission.addItem("Head of Infrastructure Committee");
                                        jComboBoxPermission.addItem("Head of Management Information System");
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

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("Admin")) {

                        jComboBoxPermission.removeAllItems();
                        jComboBoxPosition.setEnabled(false);
                        jComboBoxPosition.removeAllItems();
                        jComboBoxPermission.setEnabled(false);
                        jComboBoxInstitute.setEnabled(false);
                        jComboBoxInstitute.removeAllItems();
                        jComboBoxPermission.addItem("Admin");

                    } else if (jComboBoxField.getSelectedItem().toString().equalsIgnoreCase("President")) {
                        jComboBoxPosition.setEnabled(false);
                        jComboBoxPermission.removeAllItems();
                        jComboBoxPermission.setEnabled(false);
                        jComboBoxInstitute.setEnabled(false);
                        jComboBoxInstitute.removeAllItems();
                        jComboBoxPosition.removeAllItems();
                        jComboBoxPermission.addItem("President");

                    }

                }

            }
        });
    }
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

//    SubmitPage iFrameBook;
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed

        deleteDocuments();
        AccountsDisplayTable();
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxInstituteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxInstituteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstituteKeyReleased

    private void jComboBoxInstituteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstituteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstituteActionPerformed

    private void jComboBoxInstituteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxInstituteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstituteMouseEntered

    private void jComboBoxPositionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxPositionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositionKeyReleased

    private void jComboBoxPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositionActionPerformed

    private void jComboBoxPositionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPositionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositionMouseEntered

    private void jComboBoxFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFieldActionPerformed

    private void jComboBoxPermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPermissionActionPerformed
        jButtonSubmit.setEnabled(true);
    }//GEN-LAST:event_jComboBoxPermissionActionPerformed

    private void jTextFieldLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastnameActionPerformed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

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

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed

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

        if (username.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add username");
        } else if (pass1.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add password");
        } else if (!pass1.equalsIgnoreCase(pass2)) {
            JOptionPane.showMessageDialog(null, "not match");
        } else if (per.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add Permission");
        } else if (ins.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add institute");
        } else if (name.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add name");
        } else if (lname.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add lastname");
        } else if (position.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "add lastname");
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
                    JOptionPane.showMessageDialog(null, "Added ",
                            "INFRMATION", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            //saveData();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jTextFieldUNameACCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUNameACCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUNameACCActionPerformed

    private void jTextFieldFirstnameACCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstnameACCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFirstnameACCActionPerformed

    private void jButtonSubmit7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmit7ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        AccountsDisplayTable();
    }//GEN-LAST:event_jButtonSubmit7ActionPerformed

    private void jButtonHomeVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeVActionPerformed

        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_jButtonHomeVActionPerformed

    private void jTextFieldPasACCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPasACCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPasACCActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonTransactionHistoryV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionHistoryV1ActionPerformed
        DocumetnsDisplayTable();
        jTabbedPane1.setSelectedIndex(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTransactionHistoryV1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButtonTransactionHistoryV4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionHistoryV4ActionPerformed
        deleteIncoming();
        DocumetnsDisplayTable();
    }//GEN-LAST:event_jButtonTransactionHistoryV4ActionPerformed

    private void jTextFieldDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDocumentActionPerformed

    private void jTextFieldAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAccountsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAccountsActionPerformed

    private void jTextFieldDocumentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDocumentKeyReleased

        searchDocument();// TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDocumentKeyReleased

    private void jButtonDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentsActionPerformed
        DocumetnsDisplayTable();//        IncomingDisplayTable();
//        jButtonIncomingAccept.setEnabled(false);
    }//GEN-LAST:event_jButtonDocumentsActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        updateDocuments();

        AccountsDisplayTable();
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        AccountsDisplayTable();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jTextFieldAccountsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAccountsKeyReleased
        searchAccount();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAccountsKeyReleased

    private void jPasswordLastnameACCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordLastnameACCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordLastnameACCActionPerformed

    private void jPasswordUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordUserIDActionPerformed
    LogInPage log;

    public void DocumetnsDisplayTable() {
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT tracking_data,by_data, documenttype_data,details_data, purpose_data, postedtime_data FROM documents");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableDocuments.getModel();
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
            jTableDocuments.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AccountsDisplayTable() {
        try {
            String ad = "Admin";

            con = myConnection.getConnection();
            pst = con.prepareStatement("SELECT name , lastname, username,password,id FROM users where username !='"+ad+"'");
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTableAccount.getModel();
            model.setRowCount(0);
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),});
            }
            jTableAccount.setModel(model);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDocuments() {

        String name = jTextFieldFirstnameACC.getText().trim();
        String lastname = jPasswordLastnameACC.getText().trim();
        String username = jTextFieldUNameACC.getText().trim();
        String password = jTextFieldPasACC.getText().trim();
        String userID = jPasswordUserID.getText().trim();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("UPDATE users SET name = '" + name + "',lastname = '" + lastname + "',username ='" + username + "',password ='" + password + "' where id ='" + userID + "'");
            pst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteIncoming() {
        String from = jLabelDocum.getText().trim();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from documents where tracking_data ='" + from + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Successfully Deleted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDocuments() {
        String from = jPasswordUserID.getText().trim();
        try {

            con = myConnection.getConnection();
            pst = con.prepareStatement("delete from users where id ='" + from + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Successfully Deleted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchDocument() {
        try {

            String search = jTextFieldDocument.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM documents where  tracking_data like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableDocuments.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("tracking_data"),
                        rs.getString("by_data"),
                        rs.getString("documenttype_data"),
                        rs.getString("details_data"),
                        rs.getString("purpose_data"),
                        rs.getString("postedtime_data"),});
                }
                jTableDocuments.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    public void searchAccount() {
        try {

            String search = jTextFieldAccounts.getText();
            con = myConnection.getConnection();
            String q = ("SELECT * FROM users where  name   like '%" + search + "%'");

            pst = con.prepareStatement(q);
            rs = pst.executeQuery();

            try {

                DefaultTableModel model = (DefaultTableModel) jTableAccount.getModel();
                model.setRowCount(0);
                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("id"),
                    });
                }
                jTableAccount.setModel(model);
                con.close();

            } catch (Exception e) {
                e.printStackTrace();

//             
            }
        } catch (Exception e) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDocuments;
    private javax.swing.JButton jButtonHomeV;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JButton jButtonSubmit7;
    private javax.swing.JButton jButtonTransactionHistoryV1;
    private javax.swing.JButton jButtonTransactionHistoryV4;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxField;
    private javax.swing.JComboBox<String> jComboBoxInstitute;
    private javax.swing.JComboBox<String> jComboBoxPermission;
    private javax.swing.JComboBox<String> jComboBoxPosition;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19s;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCourse;
    private javax.swing.JLabel jLabelDocum;
    private javax.swing.JLabel jLabelLastname;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordFieldPassword_1;
    private javax.swing.JPasswordField jPasswordFieldPassword_2;
    private javax.swing.JTextField jPasswordLastnameACC;
    private javax.swing.JTextField jPasswordUserID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAccount;
    private javax.swing.JTable jTableDocuments;
    private javax.swing.JTextField jTextFieldAccounts;
    private javax.swing.JTextField jTextFieldDocument;
    private javax.swing.JTextField jTextFieldFirstnameACC;
    private javax.swing.JTextField jTextFieldLastname;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPasACC;
    private javax.swing.JTextField jTextFieldUNameACC;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

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

    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
