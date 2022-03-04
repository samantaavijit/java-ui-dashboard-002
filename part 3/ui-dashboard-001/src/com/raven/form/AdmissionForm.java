package com.raven.form;

import com.raven.main.Main;
import com.raven.swing.Notification;
import com.toedter.calendar.JDateChooser;
import helper.DbHelper;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Avijit
 */
public class AdmissionForm extends javax.swing.JPanel {

    JDateChooser dateChooser = new JDateChooser();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    final JComponent[] inputs = new JComponent[]{
        dateChooser
    };
    private String courseName, branchName, studentName, fatherName, motherName,
            presentAddress, permanentAddress, dateOfBirth, bloodGroup, contactNo, nationality;
    private String imageFilePath = null;

    private static final Color ERROR_COLOR = Color.RED;
    private static final Color SUCCESS_COLOR = new Color(3, 155, 216);

    private boolean isError = false;

    public AdmissionForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblFormName = new javax.swing.JLabel();
        inpCourseName = new com.raven.form.MaterialTextInput();
        inpBranch = new com.raven.form.MaterialTextInput();
        inpName = new com.raven.form.MaterialTextInput();
        inpFatherName = new com.raven.form.MaterialTextInput();
        inpMotherName = new com.raven.form.MaterialTextInput();
        inpPresentAddress = new com.raven.form.MaterialTextInput();
        inpPermanentAddress = new com.raven.form.MaterialTextInput();
        inpDOB = new com.raven.form.MaterialTextInput();
        jLblPhotoPreview = new javax.swing.JLabel();
        jBtnCamera = new javax.swing.JButton();
        jBtnFile = new javax.swing.JButton();
        inpNationality = new com.raven.form.MaterialTextInput();
        inpContactNo = new com.raven.form.MaterialTextInput();
        cmbBloodGroup = new com.raven.form.MaterialComboBox();
        jBtnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        jlblFormName.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jlblFormName.setForeground(new java.awt.Color(2, 253, 164));
        jlblFormName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFormName.setText("Admission Form");

        inpCourseName.setToolTipText("Enter your course name");
        inpCourseName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpCourseName.setLabelText("Course Name");

        inpBranch.setToolTipText("Enter your branch name");
        inpBranch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpBranch.setLabelText("Branch");

        inpName.setToolTipText("Enter your name");
        inpName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpName.setLabelText("Name of the Student");

        inpFatherName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpFatherName.setLabelText("Father's / Husband's Name");

        inpMotherName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpMotherName.setLabelText("Mother's Name");

        inpPresentAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpPresentAddress.setLabelText("Present Address");

        inpPermanentAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpPermanentAddress.setLabelText("Permanent Address");

        inpDOB.setEditable(false);
        inpDOB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpDOB.setLabelText("Date of Birth");
        inpDOB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inpDOBMouseClicked(evt);
            }
        });

        jLblPhotoPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profile.png"))); // NOI18N
        jLblPhotoPreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLblPhotoPreview.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLblPhotoPreview.setIconTextGap(0);

        jBtnCamera.setBackground(java.awt.Color.cyan);
        jBtnCamera.setText("Camera");

        jBtnFile.setBackground(java.awt.Color.cyan);
        jBtnFile.setText("File");
        jBtnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFileActionPerformed(evt);
            }
        });

        inpNationality.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpNationality.setLabelText("Nationality");

        inpContactNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inpContactNo.setLabelText("Contact Number");

        cmbBloodGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        cmbBloodGroup.setSelectedIndex(-1);
        cmbBloodGroup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbBloodGroup.setLabelText("Blood Group");

        jBtnSave.setBackground(java.awt.Color.green);
        jBtnSave.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jBtnSave.setText("SAVE");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlblFormName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inpPermanentAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inpPresentAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inpMotherName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(inpCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(inpBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inpName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inpFatherName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inpContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(150, 150, 150)
                                    .addComponent(jLblPhotoPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtnCamera)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBtnFile)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inpDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inpNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbBloodGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(362, 362, 362))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jlblFormName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblPhotoPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnCamera)
                            .addComponent(jBtnFile))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inpBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(inpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(inpFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(inpMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpPresentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inpDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(inpPermanentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(cmbBloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inpContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jBtnSave)
                        .addGap(89, 89, 89))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inpDOBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inpDOBMouseClicked
        int result = JOptionPane.showConfirmDialog(null, inputs, "Choose Your Date of birth", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            if (dateChooser != null && dateChooser.getDate() != null) {
                String date = sdf.format(dateChooser.getDate());
                inpDOB.setText(date);
            }
        }
    }//GEN-LAST:event_inpDOBMouseClicked

    private void jBtnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFileActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filer = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        jFileChooser.addChoosableFileFilter(filer);

        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File imageFile = jFileChooser.getSelectedFile();
            imageFilePath = imageFile.getAbsolutePath();
            if (imageFilePath != null) {
                ImageIcon imageIcon = new ImageIcon(imageFilePath);
                if (imageIcon != null) {
                    Image profileImage = imageIcon.getImage().getScaledInstance(jLblPhotoPreview.getWidth(),
                            jLblPhotoPreview.getHeight(), Image.SCALE_SMOOTH);
                    jLblPhotoPreview.setIcon(new ImageIcon(profileImage));
                }
            }
        }
    }//GEN-LAST:event_jBtnFileActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        isError = false;
        inpCourseName.setLineColor(SUCCESS_COLOR);
        inpBranch.setLineColor(SUCCESS_COLOR);
        inpName.setLineColor(SUCCESS_COLOR);
        inpFatherName.setLineColor(SUCCESS_COLOR);
        inpMotherName.setLineColor(SUCCESS_COLOR);
        inpPresentAddress.setLineColor(SUCCESS_COLOR);
        inpPermanentAddress.setLineColor(SUCCESS_COLOR);
        inpDOB.setLineColor(SUCCESS_COLOR);
        inpContactNo.setLineColor(SUCCESS_COLOR);
        inpNationality.setLineColor(SUCCESS_COLOR);
        cmbBloodGroup.setLineColor(SUCCESS_COLOR);

        courseName = inpCourseName.getText();
        branchName = inpBranch.getText();
        studentName = inpName.getText();
        fatherName = inpFatherName.getText();
        motherName = inpMotherName.getText();
        presentAddress = inpPresentAddress.getText();
        permanentAddress = inpPermanentAddress.getText();
        dateOfBirth = inpDOB.getText();
        contactNo = inpContactNo.getText();
        nationality = inpNationality.getText();

        if (null == courseName || courseName.equalsIgnoreCase("")) {
            inpCourseName.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == branchName || branchName.equalsIgnoreCase("")) {
            inpBranch.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == studentName || studentName.equalsIgnoreCase("")) {
            inpName.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == fatherName || fatherName.equalsIgnoreCase("")) {
            inpFatherName.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == motherName || motherName.equalsIgnoreCase("")) {
            inpMotherName.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == presentAddress || presentAddress.equalsIgnoreCase("")) {
            inpPresentAddress.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == permanentAddress || permanentAddress.equalsIgnoreCase("")) {
            inpPermanentAddress.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == dateOfBirth || dateOfBirth.equalsIgnoreCase("")) {
            inpDOB.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == contactNo || contactNo.equalsIgnoreCase("")) {
            inpContactNo.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }

        if (null == nationality || nationality.equalsIgnoreCase("")) {
            inpNationality.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        }
        Object selectedItem = cmbBloodGroup.getSelectedItem();
        if (selectedItem == null) {
            cmbBloodGroup.setLineColor(ERROR_COLOR);
            if (!isError) {
                isError = true;
            }
        } else {
            bloodGroup = selectedItem.toString();
        }

        if (imageFilePath == null) {
            Notification noti = new Notification(Main.getJFrame(), Notification.Type.WARNING,
                    Notification.Location.TOP_CENTER, "Please upload your image");
            noti.showNotification();
            if (!isError) {
                isError = true;
            }
        }

        if (!isError) {
            saveData();
        }

    }//GEN-LAST:event_jBtnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.form.MaterialComboBox cmbBloodGroup;
    private com.raven.form.MaterialTextInput inpBranch;
    private com.raven.form.MaterialTextInput inpContactNo;
    private com.raven.form.MaterialTextInput inpCourseName;
    private com.raven.form.MaterialTextInput inpDOB;
    private com.raven.form.MaterialTextInput inpFatherName;
    private com.raven.form.MaterialTextInput inpMotherName;
    private com.raven.form.MaterialTextInput inpName;
    private com.raven.form.MaterialTextInput inpNationality;
    private com.raven.form.MaterialTextInput inpPermanentAddress;
    private com.raven.form.MaterialTextInput inpPresentAddress;
    private javax.swing.JButton jBtnCamera;
    private javax.swing.JButton jBtnFile;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JLabel jLblPhotoPreview;
    private javax.swing.JLabel jlblFormName;
    // End of variables declaration//GEN-END:variables

    private void saveData() {
        try {
            Connection con = DbHelper.connect();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String extension = null;
            int index = imageFilePath.lastIndexOf('.');
            if (index > 0) {
                extension = imageFilePath.substring(index + 1);
            }
            String outputImageName = String.valueOf(timestamp.getTime()) + "." + extension;
            String dbDir = "C:\\NHCMTI\\Profiles";

            String destination = dbDir + "\\" + outputImageName;

            if (!uploadImage(imageFilePath, destination)) {
                Notification noti = new Notification(Main.getJFrame(), Notification.Type.INFO,
                        Notification.Location.TOP_CENTER, "Something wrong please try again!!");
                noti.showNotification();
                return;
            }

            PreparedStatement statement = con.prepareStatement("INSERT INTO students (uid,course_name,branch,name,"
                    + "fathers_name,mothers_name,present_address,permanent_address,dob,blood,"
                    + "contact_no,nationality,image,qualification) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            statement.setString(1, String.valueOf(timestamp.getTime()));
            statement.setString(2, courseName);
            statement.setString(3, branchName);
            statement.setString(4, studentName);
            statement.setString(5, fatherName);
            statement.setString(6, motherName);
            statement.setString(7, presentAddress);
            statement.setString(8, permanentAddress);
            statement.setString(9, dateOfBirth);
            statement.setString(10, bloodGroup);
            statement.setString(11, contactNo);
            statement.setString(12, nationality);
            statement.setString(13, outputImageName);
            statement.setString(14, "");
            
            statement.close();
            con.commit();
            if (statement.executeUpdate() > 0) {
                Notification noti = new Notification(Main.getJFrame(), Notification.Type.SUCCESS,
                        Notification.Location.TOP_CENTER, "Recorded added successfully");
                noti.showNotification();
                clearField();
            } else {
                Notification noti = new Notification(Main.getJFrame(), Notification.Type.INFO,
                        Notification.Location.TOP_CENTER, "Something wrong please try again!!");
                noti.showNotification();
            }

        } catch (SQLException e) {
            Notification noti = new Notification(Main.getJFrame(), Notification.Type.WARNING,
                    Notification.Location.TOP_CENTER, "Something wrong!! please try again");
            noti.showNotification();
            System.out.println(e.getMessage());
        }
    }

    private void clearField() {
        inpCourseName.setText("");
        inpBranch.setText("");
        inpName.setText("");
        inpFatherName.setText("");
        inpMotherName.setText("");
        inpPermanentAddress.setText("");
        inpPresentAddress.setText("");
        inpDOB.setText("");
        cmbBloodGroup.setSelectedIndex(-1);
        inpContactNo.setText("");
        inpNationality.setText("");
        imageFilePath = null;
        jLblPhotoPreview.setIcon(null);
        dateChooser.setDate(null);
    }

    private boolean uploadImage(String src, String dest) {
        try {
            Path sourceDirectory = Paths.get(src);
            Path targetDirectory = Paths.get(dest);
            Files.copy(sourceDirectory, targetDirectory);
            return true;
        } catch (IOException e) {
            Notification noti = new Notification(Main.getJFrame(), Notification.Type.WARNING,
                    Notification.Location.TOP_CENTER, "Image Upload failed");
            noti.showNotification();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
