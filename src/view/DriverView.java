package view;

import control.DriverControl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Driver;
import table.TableDriver;
import exception.InputanKosongException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import session.AppSession;

public class DriverView extends javax.swing.JFrame {
    private DriverControl driverControl;
    String action = null;
    List<Driver> listDriver;
    int selectedId = 0;
    private String userInputText;
    String role2;
    
    public DriverView(String userInputText) {
        initComponents();
        setComponent(false);
        setRadioGender(false);
        setEditDeleteBtn(false);
        driverControl = new DriverControl();
        showDriver();
        setActionCommandRadio();
        
        if(userInputText.equalsIgnoreCase("No")){
            role2 = AppSession.getInstance().getRole();
            
            if(role2.equalsIgnoreCase("Admin")) {
                userPanel.setVisible(false);
                sidebarPanel.setPreferredSize(new Dimension(129, 645));
            }
        } else{
            this.userInputText = userInputText;
            String role = driverControl.getRoleFromDatabase(userInputText);
            AppSession.getInstance().setRole(role);

            if(AppSession.getInstance().getRole().equalsIgnoreCase("Admin")) {
                userPanel.setVisible(false);
                sidebarPanel.setPreferredSize(new Dimension(129, 645));
            }
        }
        
        tableDriver.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
    
    public void setComponent(boolean value){
        idInput.setEnabled(value);
        namaInput.setEnabled(value);
        umurInput.setEnabled(value);
        noTelpInput.setEnabled(value);
        alamatInput.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public void setRadioGender(boolean value){
        lakiRadio.setEnabled(value);
        perempuanRadio.setEnabled(value);
    }
    
    public void setEditDeleteBtn(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    public void clearText(){
        idInput.setText("");
        namaInput.setText("");
        umurInput.setText("");
        noTelpInput.setText("");
        alamatInput.setText("");
        
        genderGroup.clearSelection();
        searchInput.setText("");
    }
    
    public void setActionCommandRadio(){
        lakiRadio.setActionCommand("Laki-Laki");
        perempuanRadio.setActionCommand("Perempuan");
    }
    
    public void showDriver(){
        tableDriver.setModel(driverControl.showDriverBySearch(""));
    }
    
    public void inputanKosongException() throws InputanKosongException{
        if(namaInput.getText().isEmpty() || umurInput.getText().isEmpty() || noTelpInput.getText().isEmpty()
           || alamatInput.getText().isEmpty() || genderGroup.getSelection() == null){
            throw new InputanKosongException();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        headerPanel5 = new javax.swing.JPanel();
        penggunaLabel7 = new javax.swing.JLabel();
        motoLabel5 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        noTelpInput = new javax.swing.JTextField();
        noTelpLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        namaInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDriver = new javax.swing.JTable();
        genderLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        umurLabel = new javax.swing.JLabel();
        umurInput = new javax.swing.JTextField();
        alamatInput = new javax.swing.JTextField();
        lakiRadio = new javax.swing.JRadioButton();
        perempuanRadio = new javax.swing.JRadioButton();
        alamatLabel = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        sidebarPanel = new javax.swing.JPanel();
        driverPanel = new javax.swing.JPanel();
        driverIcon = new javax.swing.JLabel();
        taxiPanel = new javax.swing.JPanel();
        taxiIcon = new javax.swing.JLabel();
        historyPanel = new javax.swing.JPanel();
        historyIcon = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        logoIcon = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel5.setBackground(new java.awt.Color(204, 204, 255));

        penggunaLabel7.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        penggunaLabel7.setText("Driver");

        motoLabel5.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        motoLabel5.setForeground(new java.awt.Color(51, 51, 51));
        motoLabel5.setText("Taxi ala kadarnya Jogja");

        searchInput.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        searchBtn.setBackground(new java.awt.Color(0, 51, 153));
        searchBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        searchBtn.setBorder(null);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanel5Layout = new javax.swing.GroupLayout(headerPanel5);
        headerPanel5.setLayout(headerPanel5Layout);
        headerPanel5Layout.setHorizontalGroup(
            headerPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(headerPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(penggunaLabel7)
                    .addComponent(motoLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        headerPanel5Layout.setVerticalGroup(
            headerPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanel5Layout.createSequentialGroup()
                .addGroup(headerPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(penggunaLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(motoLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(headerPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        idLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(51, 51, 51));
        idLabel.setText("ID Driver");

        noTelpInput.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        noTelpInput.setForeground(new java.awt.Color(102, 102, 102));
        noTelpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTelpInputActionPerformed(evt);
            }
        });

        noTelpLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        noTelpLabel.setText("No. Telepon");

        namaLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        namaLabel.setText("Nama");

        namaInput.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        namaInput.setForeground(new java.awt.Color(102, 102, 102));
        namaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaInputActionPerformed(evt);
            }
        });

        tableDriver.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tableDriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama Driver", "Gender", "Merk", "Plat", "Tanggal", "Layanan", "No Telp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDriver.setRowHeight(25);
        tableDriver.getTableHeader().setReorderingAllowed(false);
        tableDriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDriverMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDriver);

        genderLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        genderLabel.setText("Jenis Kelamin");

        idInput.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        idInput.setForeground(new java.awt.Color(102, 102, 102));
        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        umurLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        umurLabel.setText("Umur");

        umurInput.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        umurInput.setForeground(new java.awt.Color(102, 102, 102));
        umurInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umurInputActionPerformed(evt);
            }
        });

        alamatInput.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        alamatInput.setForeground(new java.awt.Color(102, 102, 102));
        alamatInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatInputActionPerformed(evt);
            }
        });

        lakiRadio.setBackground(new java.awt.Color(255, 255, 255));
        genderGroup.add(lakiRadio);
        lakiRadio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lakiRadio.setText("Laki-Laki");

        perempuanRadio.setBackground(new java.awt.Color(255, 255, 255));
        genderGroup.add(perempuanRadio);
        perempuanRadio.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        perempuanRadio.setText("Perempuan");

        alamatLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        alamatLabel.setText("Alamat");

        addBtn.setBackground(new java.awt.Color(25, 135, 84));
        addBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        addBtn.setText("Tambah");
        addBtn.setBorder(null);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(241, 196, 15));
        editBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        editBtn.setText("Ubah");
        editBtn.setBorder(null);
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        deleteBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        deleteBtn.setText("Hapus");
        deleteBtn.setBorder(null);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(220, 53, 69));
        cancelBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Batal");
        cancelBtn.setBorder(null);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(13, 110, 253));
        saveBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Simpan");
        saveBtn.setBorder(null);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderLabel)
                                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaLabel)
                                    .addComponent(idLabel)
                                    .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(lakiRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(perempuanRadio)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(noTelpLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noTelpInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(umurLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(umurInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamatInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamatLabel, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(84, 84, 84)))
                .addGap(13, 13, 13))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(namaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(genderLabel)
                                    .addComponent(alamatLabel)))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(umurLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(umurInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(noTelpLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noTelpInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGap(5, 5, 5)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alamatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lakiRadio)
                                .addComponent(perempuanRadio)))
                        .addGap(65, 65, 65))
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(contentPanel);

        sidebarPanel.setBackground(new java.awt.Color(0, 51, 153));

        driverPanel.setBackground(new java.awt.Color(0, 0, 102));

        driverIcon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        driverIcon.setForeground(new java.awt.Color(255, 255, 255));
        driverIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Driver.png"))); // NOI18N
        driverIcon.setText("   Driver");
        driverIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        driverIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        driverIcon.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout driverPanelLayout = new javax.swing.GroupLayout(driverPanel);
        driverPanel.setLayout(driverPanelLayout);
        driverPanelLayout.setHorizontalGroup(
            driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(driverIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        driverPanelLayout.setVerticalGroup(
            driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(driverIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        taxiPanel.setBackground(new java.awt.Color(0, 51, 153));
        taxiPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taxiPanelMouseClicked(evt);
            }
        });

        taxiIcon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        taxiIcon.setForeground(new java.awt.Color(255, 255, 255));
        taxiIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Taksi.png"))); // NOI18N
        taxiIcon.setText("   Taxi");
        taxiIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        taxiIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        taxiIcon.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout taxiPanelLayout = new javax.swing.GroupLayout(taxiPanel);
        taxiPanel.setLayout(taxiPanelLayout);
        taxiPanelLayout.setHorizontalGroup(
            taxiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taxiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taxiIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        taxiPanelLayout.setVerticalGroup(
            taxiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taxiIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        historyPanel.setBackground(new java.awt.Color(0, 51, 153));
        historyPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyPanelMouseClicked(evt);
            }
        });

        historyIcon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        historyIcon.setForeground(new java.awt.Color(255, 255, 255));
        historyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/List.png"))); // NOI18N
        historyIcon.setText("   History");
        historyIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        historyIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        historyIcon.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        logoPanel.setBackground(new java.awt.Color(0, 51, 153));

        logoIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo.png"))); // NOI18N
        logoIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(logoIcon)
                .addGap(20, 20, 20))
        );

        userPanel.setBackground(new java.awt.Color(0, 51, 153));
        userPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userPanelMouseClicked(evt);
            }
        });

        userIcon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userIcon.setForeground(new java.awt.Color(255, 255, 255));
        userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User.png"))); // NOI18N
        userIcon.setText("   User");
        userIcon.setMaximumSize(new java.awt.Dimension(50, 50));
        userIcon.setMinimumSize(new java.awt.Dimension(50, 50));
        userIcon.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        logoutIcon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutIcon.setForeground(new java.awt.Color(255, 255, 255));
        logoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logout.png"))); // NOI18N
        logoutIcon.setText("Logout");
        logoutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(driverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(taxiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(historyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(driverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taxiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(logoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noTelpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noTelpInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noTelpInputActionPerformed

    private void namaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaInputActionPerformed

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void umurInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umurInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_umurInputActionPerformed

    private void alamatInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatInputActionPerformed

    private void tableDriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDriverMouseClicked
        setEditDeleteBtn(true);
        setComponent(false);
        setRadioGender(false);
        genderGroup.clearSelection();

        int clickedRow = tableDriver.getSelectedRow();
        TableModel tableModel = tableDriver.getModel();

        selectedId = Integer.parseInt(tableModel.getValueAt(clickedRow, 0).toString());
        idInput.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaInput.setText(tableModel.getValueAt(clickedRow, 1).toString());
        String gender = tableModel.getValueAt(clickedRow, 2).toString();
        switch(gender){
            case "Laki-Laki":
                lakiRadio.setSelected(true);
                break;
            case "Perempuan":
                perempuanRadio.setSelected(true);
                break;
        }
        umurInput.setText(tableModel.getValueAt(clickedRow, 3).toString());
        noTelpInput.setText(tableModel.getValueAt(clickedRow, 4).toString());
        alamatInput.setText(tableModel.getValueAt(clickedRow, 5).toString());
    }//GEN-LAST:event_tableDriverMouseClicked

    private void taxiPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxiPanelMouseClicked
        TaksiView tv = new TaksiView();
        this.dispose();
        tv.setVisible(true);
    }//GEN-LAST:event_taxiPanelMouseClicked

    private void historyPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyPanelMouseClicked
        PenggunaanView pv = new PenggunaanView();
        this.dispose();
        pv.setVisible(true);
    }//GEN-LAST:event_historyPanelMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        setComponent(true);
        setRadioGender(true);
        genderGroup.clearSelection();
        
        clearText();
        searchInput.setText("");
        action = "Tambah";
        
        idInput.setEnabled(false);
        int generatedId = driverControl.generateId();
        String generatedIdString = String.valueOf(generatedId);
        idInput.setText(generatedIdString);
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        setComponent(true);
        action = "Ubah";
        idInput.setEnabled(false);
        setRadioGender(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane,
            "Apakah yakin ingin menghapus data ? ", "Konfirmasi",
            JOptionPane.YES_NO_OPTION);

        if (getAnswer == JOptionPane.YES_OPTION) {
            try {
                driverControl.deleteDriver(selectedId);
                clearText();
                showDriver();
                setComponent(false);
                setRadioGender(false);
                setEditDeleteBtn(false);
                genderGroup.clearSelection();
                
                JOptionPane.showMessageDialog(null, "Data Driver berhasil dihapus!");
            } catch (Exception e) {
                System.out.println("Error : "+e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data Driver tidak jadi dihapus!");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        setEditDeleteBtn(false);
        setComponent(false);

        try {
            TableDriver td = driverControl.showDriverBySearch(searchInput.getText());

            if (td.getRowCount() == 0) {
                clearText();
                setEditDeleteBtn(false);
                JOptionPane.showConfirmDialog(null, "Data tidak ditemukan","Konfirmasi",JOptionPane.DEFAULT_OPTION);
            } else{
                tableDriver.setModel(td);
            }

            clearText();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setComponent(false);
        setEditDeleteBtn(false);
        clearText();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try{
            inputanKosongException();
            String gender = "";

            gender = genderGroup.getSelection().getActionCommand();

            if(action.equals("Tambah")) {
                Driver d = new Driver(Integer.parseInt(idInput.getText()), namaInput.getText(), Integer.parseInt(umurInput.getText()), gender, noTelpInput.getText(), alamatInput.getText());
                driverControl.insertDriver(d);
            } else {
                Driver d = new Driver(selectedId, namaInput.getText(), Integer.parseInt(umurInput.getText()), gender, noTelpInput.getText(), alamatInput.getText());
                driverControl.updateDriver(d);
            }
            clearText();
            showDriver();
            setComponent(false);
            setRadioGender(false);
            genderGroup.clearSelection();
            setEditDeleteBtn(false);
        } catch(InputanKosongException e){
            JOptionPane.showMessageDialog(this, e.message());
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void logoIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoIconMouseClicked
      
    }//GEN-LAST:event_logoIconMouseClicked

    private void userPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseClicked
        UserView tv = new UserView();
        this.dispose();
        tv.setVisible(true);
    }//GEN-LAST:event_userPanelMouseClicked

    private void logoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutIconMouseClicked
        // TODO add your handling code here:
        LoginView lg = new LoginView();
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_logoutIconMouseClicked

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
            java.util.logging.Logger.getLogger(DriverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DriverView("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField alamatInput;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel driverIcon;
    private javax.swing.JPanel driverPanel;
    private javax.swing.JButton editBtn;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel headerPanel5;
    private javax.swing.JLabel historyIcon;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton lakiRadio;
    private javax.swing.JLabel logoIcon;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JLabel motoLabel5;
    private javax.swing.JTextField namaInput;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField noTelpInput;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JLabel penggunaLabel7;
    private javax.swing.JRadioButton perempuanRadio;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JTable tableDriver;
    private javax.swing.JLabel taxiIcon;
    private javax.swing.JPanel taxiPanel;
    private javax.swing.JTextField umurInput;
    private javax.swing.JLabel umurLabel;
    private javax.swing.JLabel userIcon;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
