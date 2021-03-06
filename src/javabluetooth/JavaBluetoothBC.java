/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

/**
 *
 * @author saliya
 */
public class JavaBluetoothBC extends javax.swing.JFrame {

    private boolean BT_CONNECTED = false;
    String RX_STRING = "";
    private boolean BT_SCAN_FINISHED = false;
    private String BT_DEVICE_ADDRESS = "";
    private String BT_URL = "btspp://" + BT_DEVICE_ADDRESS + ":1;authenticate=false;encrypt=false;master=false";
    private RemoteDevice BT_DEVICE;
    private String[] BT_SPLIT_STRING;

    private StreamConnection BT_STREAM_CONNECTION;
    private OutputStream BT_OUT_STREAM;
    private InputStream BT_IN_STREAM;
    private boolean BT_OUT_STREAM_OPEN = false;
    private boolean BT_IN_STREAM_OPEN = false;

    private Thread BT_SCAN_THREAD;
    private Thread BT_CONNECT_THREAD;
    private Thread BT_RECEIVE_THREAD;

    /**
     * Creates new form JavaBluetoothBC
     */
    public JavaBluetoothBC() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BT_SCAN_BTN = new javax.swing.JButton();
        BT_DEVICE_LIST = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        BT_CONNECT_BTN = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Bluetooth BlueCove");

        BT_SCAN_BTN.setText("Scan Bluetooth Devices");
        BT_SCAN_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SCAN_BTNActionPerformed(evt);
            }
        });

        BT_DEVICE_LIST.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO DEVICE SELECTED" }));
        BT_DEVICE_LIST.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BT_DEVICE_LISTItemStateChanged(evt);
            }
        });

        jLabel17.setText("Device :");

        BT_CONNECT_BTN.setText("Connect");
        BT_CONNECT_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CONNECT_BTNActionPerformed(evt);
            }
        });

        jRadioButton1.setText("BTN 1");
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.setFocusable(false);
        jRadioButton1.setRequestFocusEnabled(false);
        jRadioButton1.setRolloverEnabled(false);
        jRadioButton1.setVerifyInputWhenFocusTarget(false);

        jToggleButton1.setText("led 1");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("led 2");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("BTN 2");
        jRadioButton2.setFocusPainted(false);
        jRadioButton2.setFocusable(false);
        jRadioButton2.setRequestFocusEnabled(false);
        jRadioButton2.setRolloverEnabled(false);
        jRadioButton2.setVerifyInputWhenFocusTarget(false);

        jRadioButton3.setText("BTN 3");
        jRadioButton3.setFocusPainted(false);
        jRadioButton3.setFocusable(false);
        jRadioButton3.setRequestFocusEnabled(false);
        jRadioButton3.setRolloverEnabled(false);
        jRadioButton3.setVerifyInputWhenFocusTarget(false);

        jToggleButton3.setText("led 3");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("led 4");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("BTN 4");
        jRadioButton4.setFocusPainted(false);
        jRadioButton4.setFocusable(false);
        jRadioButton4.setRequestFocusEnabled(false);
        jRadioButton4.setRolloverEnabled(false);
        jRadioButton4.setVerifyInputWhenFocusTarget(false);

        jRadioButton5.setText("BTN 5");
        jRadioButton5.setFocusPainted(false);
        jRadioButton5.setFocusable(false);
        jRadioButton5.setRequestFocusEnabled(false);
        jRadioButton5.setRolloverEnabled(false);
        jRadioButton5.setVerifyInputWhenFocusTarget(false);

        jToggleButton5.setText("led 5");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("::");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BT_DEVICE_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BT_SCAN_BTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BT_CONNECT_BTN))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton5)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_DEVICE_LIST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_CONNECT_BTN)
                    .addComponent(BT_SCAN_BTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(jToggleButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton5)))
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SCAN_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SCAN_BTNActionPerformed
        BT_DEVICE_LIST.removeAllItems();

        BT_SCAN_THREAD = new Thread(() -> {
            try {
                BT_SCAN_FINISHED = false;
                LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
                    @Override
                    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                        try {
                            String name = btDevice.getFriendlyName(false);
                            BT_DEVICE = btDevice;
                            BT_DEVICE_LIST.addItem(name.trim() + "::" + BT_DEVICE.getBluetoothAddress().trim());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void inquiryCompleted(int discType) {
                        BT_SCAN_FINISHED = true;
                    }

                    @Override
                    public void serviceSearchCompleted(int transID, int respCode) {
                    }

                    @Override
                    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                    }
                });
                while (!BT_SCAN_FINISHED) {
                    logg("Scanning...");
                    Thread.sleep(500);
                }
                UUID uuid = new UUID(0x1101);
                UUID[] searchUuidSet = new UUID[]{uuid};
                int[] attrIDs = new int[]{
                    0x0100
                };
                BT_SCAN_FINISHED = false;
                logg("Allmost there...");

                LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, BT_DEVICE, new DiscoveryListener() {
                    @Override
                    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                    }

                    @Override
                    public void inquiryCompleted(int discType) {
                    }

                    @Override
                    public void serviceSearchCompleted(int transID, int respCode) {
                        logg("Scanning finished");
                        BT_SCAN_FINISHED = true;
                        BT_DEVICE_LIST.setSelectedIndex(0);
                    }

                    @Override
                    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                        for (ServiceRecord servRecord1 : servRecord) {
                            BT_URL = servRecord1.getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                            if (BT_URL != null) {
                                break;
                            }
                        }
                    }
                });
            } catch (InterruptedException | BluetoothStateException e) {
                System.out.println(e);
            }
        });

        BT_SCAN_THREAD.start();
    }//GEN-LAST:event_BT_SCAN_BTNActionPerformed

    private void BT_DEVICE_LISTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BT_DEVICE_LISTItemStateChanged

    }//GEN-LAST:event_BT_DEVICE_LISTItemStateChanged

    private void BT_CONNECT_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CONNECT_BTNActionPerformed
        if (BT_DEVICE_LIST.getSelectedIndex() == -1 || BT_DEVICE_LIST.getSelectedItem() == "NO DEVICE SELECTED") {
        } else {

            logg("connecting...");
            BT_CONNECT_THREAD = new Thread(() -> {
                String dd = BT_DEVICE_LIST.getSelectedItem().toString();
                BT_SPLIT_STRING = dd.split("::");
                BT_DEVICE_ADDRESS = BT_SPLIT_STRING[1];
                BT_URL = "btspp://" + BT_DEVICE_ADDRESS + ":1;authenticate=false;encrypt=false;master=false";
                if ("Disconnect".equals(BT_CONNECT_BTN.getText()) && BT_CONNECTED) {
                    try {
                        BT_OUT_STREAM.close();
                        BT_IN_STREAM.close();
                        BT_STREAM_CONNECTION.close();
                        BT_OUT_STREAM_OPEN = false;
                        BT_IN_STREAM_OPEN = false;
                        BT_CONNECTED = false;
                        BT_CONNECT_BTN.setText("Connect");
                        logg("disconnected");

                    } catch (IOException e) {
                    }
                } else if (!BT_CONNECTED) {
                    try {
                        BT_STREAM_CONNECTION = (StreamConnection) Connector.open(BT_URL);
                        BT_OUT_STREAM = BT_STREAM_CONNECTION.openOutputStream();
                        BT_IN_STREAM = BT_STREAM_CONNECTION.openInputStream();
                        BT_OUT_STREAM_OPEN = false;
                        BT_IN_STREAM_OPEN = false;
                    } catch (IOException e) {
                        BT_CONNECTED = false;
                        BT_OUT_STREAM_OPEN = false;
                        BT_IN_STREAM_OPEN = false;
                        logg("cannot connect to selected device !");
                        return;
                    }
                    BT_CONNECTED = true;
                    BT_CONNECT_BTN.setEnabled(true);
                    logg("connected to :" + BT_DEVICE_LIST.getSelectedItem() + "\n");
                }
                if (BT_CONNECTED) {
                    BT_CONNECT_BTN.setText("Disconnect");
                    BT_DEVICE_LIST.setEnabled(false);
                    BT_OUT_STREAM_OPEN = true;
                    BT_IN_STREAM_OPEN = true;

                    ReceiveData();
                } else {
                }

            });
            BT_CONNECT_THREAD.start();
        }
    }//GEN-LAST:event_BT_CONNECT_BTNActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (BT_CONNECTED && BT_OUT_STREAM_OPEN) {
            if (jToggleButton1.isSelected()) {
                SendData("a");
            } else {
                SendData("A");
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (BT_CONNECTED && BT_OUT_STREAM_OPEN) {
            if (jToggleButton2.isSelected()) {
                SendData("b");
            } else {
                SendData("B");
            }
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (BT_CONNECTED && BT_OUT_STREAM_OPEN) {
            if (jToggleButton3.isSelected()) {
                SendData("c");
            } else {
                SendData("C");
            }
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        if (BT_CONNECTED && BT_OUT_STREAM_OPEN) {
            if (jToggleButton4.isSelected()) {
                SendData("d");
            } else {
                SendData("D");
            }
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        if (BT_CONNECTED && BT_OUT_STREAM_OPEN) {
            if (jToggleButton5.isSelected()) {
                SendData("e");
            } else {
                SendData("E");
            }
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaBluetoothBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaBluetoothBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaBluetoothBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaBluetoothBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaBluetoothBC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_CONNECT_BTN;
    private javax.swing.JComboBox<String> BT_DEVICE_LIST;
    private javax.swing.JButton BT_SCAN_BTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    // End of variables declaration//GEN-END:variables
  private void SendData(String x) {
        if (x == null || x.isEmpty()) {
            return;
        }
        try {
            if (BT_CONNECTED && BT_OUT_STREAM_OPEN) {
                BT_OUT_STREAM.write(x.getBytes());
                BT_OUT_STREAM.flush();
            }
        } catch (Exception e) {
        }
    }

    private void ReceiveData() {
        BT_RECEIVE_THREAD = new Thread(() -> {
            byte[] BUFFER = new byte[1];
            if (BT_CONNECTED && BT_IN_STREAM_OPEN) {
                try {
                    while (BUFFER.length != 0 && BT_IN_STREAM_OPEN) {
                        BT_IN_STREAM.read(BUFFER);
                        for (byte b : BUFFER) {
                            RX_STRING = RX_STRING + (char) b;
                        }
                        RX_STRING = RX_STRING.trim();
                        if ("F".equals(RX_STRING)) {
                            jRadioButton1.setSelected(true);
                        } else if ("f".equals(RX_STRING)) {
                            jRadioButton1.setSelected(false);
                        }
                        if ("G".equals(RX_STRING)) {
                            jRadioButton2.setSelected(true);
                        } else if ("g".equals(RX_STRING)) {
                            jRadioButton2.setSelected(false);
                        }
                        if ("H".equals(RX_STRING)) {
                            jRadioButton3.setSelected(true);
                        } else if ("h".equals(RX_STRING)) {
                            jRadioButton3.setSelected(false);
                        }
                        if ("I".equals(RX_STRING)) {
                            jRadioButton4.setSelected(true);
                        } else if ("i".equals(RX_STRING)) {
                            jRadioButton4.setSelected(false);
                        }
                        if ("J".equals(RX_STRING)) {
                            jRadioButton5.setSelected(true);
                        } else if ("j".equals(RX_STRING)) {
                            jRadioButton5.setSelected(false);
                        }

                        logg("Rx :" + RX_STRING);
                        RX_STRING = "";
                    }
                } catch (IOException ex) {

                }
            }
        });
        BT_RECEIVE_THREAD.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {

        }
    }

    private void logg(String evt) {
        jLabel1.setText(evt);
    }
}
