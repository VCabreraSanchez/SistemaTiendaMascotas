/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;
import Controlador.NegocioCuenta;
import Modelo.*;
import java.awt.Dialog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;
import org.w3c.dom.Text;

/**
 *
 * @author cabre
 */
public class frmProductos extends javax.swing.JFrame {
    NegocioCuenta obj = new NegocioCuenta();
    Detalle d = new Detalle();
    String todos = "Todos";
    
    /**
     * Creates new form frmProductos
     */
    public frmProductos() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Productos");
        filtraNombre("");
        filtraAnimal();
        filtraAlimento();
        filtraHigiene();
        filtraMarca("");
        filtraOtros();
    }
    
    void filtraNombre(String cad){
        DefaultTableModel dt = (DefaultTableModel)tabla1.getModel();
        dt.setRowCount(0);
        obj.lisPro().stream()
                .filter(x->x.getNombP().toLowerCase().startsWith(cad.toLowerCase()))
                .forEach(x->dt.addRow(new Object[]{x.getCode(),x.getNombP(),x.getPrecioU(),x.getStock()}));
    }
    
    void filtraAnimal(){
        DefaultTableModel dt = (DefaultTableModel)tabla2.getModel();
        dt.setRowCount(0);
        String animal = cmbAnimal.getSelectedItem().toString();
        for(Producto x: obj.lisPro()){
            String animalP = x.getAnimal();
            if((animalP.equals(animal)) || (animal.equals(todos))){
                Object v[] = {x.getCode(),x.getNombP(),x.getPrecioU(),x.getStock()};
                dt.addRow(v);
            }
        }
    }
    
    void filtraAlimento(){
        DefaultTableModel dt = (DefaultTableModel)tabla3.getModel();
        dt.setRowCount(0);
        String alimento = cmbAlimento.getSelectedItem().toString();
        for(TipoAlimento x: obj.lisAlimento()){
            if((x.getAnombre().equals(alimento)) || (alimento.equals(todos))){
                Object v[] = {x.getCode(),x.getNombP(),x.getPrecioU(),x.getStock()};
                dt.addRow(v);
            }
        }
    }
    
    void filtraHigiene(){
        DefaultTableModel dt = (DefaultTableModel)tabla4.getModel();
        dt.setRowCount(0);
        String higiene = cmbHigiene.getSelectedItem().toString();
        for(TipoHigiene x: obj.lisHigiene()){
            if(x.getHnombre().equals(higiene) || cmbHigiene.getSelectedItem().toString().equals(todos)){
                Object v[] = {x.getCode(),x.getNombP(),x.getPrecioU(),x.getStock()};
                dt.addRow(v);
            }
        }
    }
    
    void filtraMarca(String cad){
        DefaultTableModel dt = (DefaultTableModel)tabla5.getModel();
        dt.setRowCount(0);
        obj.lisPro().stream()
                .filter(x->x.getMarca().toLowerCase().startsWith(cad.toLowerCase()))
                .forEach(x->dt.addRow(new Object[]{x.getCode(),x.getNombP(),x.getPrecioU(),x.getStock()}));
    }
    
    void filtraOtros(){
        DefaultTableModel dt = (DefaultTableModel)tabla6.getModel();
        dt.setRowCount(0);
        String otros = cmbOtros.getSelectedItem().toString();
        for(TipoOtros x: obj.lisOtros()){
            if((x.getOnombre().equals(otros)) || (otros.equals(todos))){
                Object v[] = {x.getCode(),x.getNombP(),x.getPrecioU(),x.getStock()};
                dt.addRow(v);
            }
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tpProductos = new javax.swing.JTabbedPane();
        pTodos = new javax.swing.JPanel();
        txtNomProductos = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        pAnimal = new javax.swing.JPanel();
        cmbAnimal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbAlimento = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbHigiene = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabla4 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabla5 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbOtros = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabla6 = new javax.swing.JTable();
        btnCarrito = new javax.swing.JButton();
        btnAñadirCarro = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNomProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomProductosKeyReleased(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Stock"
            }
        ));
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);

        jLabel2.setText("NOMBRE DEL PRODUCTO");

        javax.swing.GroupLayout pTodosLayout = new javax.swing.GroupLayout(pTodos);
        pTodos.setLayout(pTodosLayout);
        pTodosLayout.setHorizontalGroup(
            pTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTodosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(pTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pTodosLayout.setVerticalGroup(
            pTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tpProductos.addTab("Todos", pTodos);

        cmbAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Perro", "Gato", "Ave", "Conejo", "Hamster" }));
        cmbAnimal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAnimalItemStateChanged(evt);
            }
        });
        cmbAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnimalActionPerformed(evt);
            }
        });

        jLabel1.setText("PRODUCTOS PARA");

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Stock"
            }
        ));
        jScrollPane7.setViewportView(tabla2);

        javax.swing.GroupLayout pAnimalLayout = new javax.swing.GroupLayout(pAnimal);
        pAnimal.setLayout(pAnimalLayout);
        pAnimalLayout.setHorizontalGroup(
            pAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(pAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pAnimalLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pAnimalLayout.setVerticalGroup(
            pAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(pAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pAnimalLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        tpProductos.addTab("Animal", pAnimal);

        jLabel3.setText("TIPO DE ALIMENTO");

        cmbAlimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Alimento húmedo", "Alimento Seco", "Snacks", "Leche y fórmulas" }));
        cmbAlimento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAlimentoItemStateChanged(evt);
            }
        });
        cmbAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlimentoActionPerformed(evt);
            }
        });

        tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Stock"
            }
        ));
        jScrollPane8.setViewportView(tabla3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        tpProductos.addTab("Alimento", jPanel3);

        jLabel4.setText("TIPO");

        cmbHigiene.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Antipulgas", "Pañales", "Areneros", "Suplementos y vitaminas", "Shampoo", "Cortadoras, peines y cepillos", "Cuidado externo" }));
        cmbHigiene.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHigieneItemStateChanged(evt);
            }
        });
        cmbHigiene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHigieneActionPerformed(evt);
            }
        });

        tabla4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Stock"
            }
        ));
        jScrollPane9.setViewportView(tabla4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(cmbHigiene, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHigiene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        tpProductos.addTab("Higiene", jPanel4);

        jLabel6.setText("NOMBRE DE LA MARCA");

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });

        tabla5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Stock"
            }
        ));
        jScrollPane10.setViewportView(tabla5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        tpProductos.addTab("Marca", jPanel2);

        jLabel5.setText("PRODUCTO");

        cmbOtros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Ropa", "Collar", "Correa", "Juguete", "Platos y bebederos", "Transportadores" }));
        cmbOtros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOtrosItemStateChanged(evt);
            }
        });
        cmbOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOtrosActionPerformed(evt);
            }
        });

        tabla6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Stock"
            }
        ));
        jScrollPane11.setViewportView(tabla6);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(cmbOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(409, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );

        tpProductos.addTab("Otros", jPanel5);

        btnCarrito.setText("Ver carrito");
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });

        btnAñadirCarro.setText("Añadir a carrito");
        btnAñadirCarro.setEnabled(false);
        btnAñadirCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirCarroActionPerformed(evt);
            }
        });

        txtCantidad.setText("0");

        jLabel7.setText("CANTIDAD");

        btnMenu.setText("Regresar al menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMenu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tpProductos)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAñadirCarro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCarrito)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tpProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarrito)
                    .addComponent(btnAñadirCarro)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnimalActionPerformed
       
    }//GEN-LAST:event_cmbAnimalActionPerformed

    private void cmbAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAlimentoActionPerformed

    private void cmbHigieneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHigieneActionPerformed
        filtraHigiene();
    }//GEN-LAST:event_cmbHigieneActionPerformed

    private void cmbOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOtrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOtrosActionPerformed

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed
        frmCarrito objfrmCarrito = new frmCarrito();
        objfrmCarrito.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCarritoActionPerformed

    private void txtNomProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProductosKeyReleased
        filtraNombre(txtNomProductos.getText());
    }//GEN-LAST:event_txtNomProductosKeyReleased

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        filtraMarca(txtMarca.getText());
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        int fila = tabla1.getSelectedRow();
        d.setCode(tabla1.getValueAt(fila, 0).toString());
        d.setNombP(tabla1.getValueAt(fila, 1).toString());
        d.setCantidad(Integer.parseInt(txtCantidad.getText()));
        d.setPrecioU(Double.parseDouble(tabla1.getValueAt(fila, 2).toString()));
        if(frmSistemaClientes.sesion == true){
            btnAñadirCarro.setEnabled(true);
        } else{
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión");
        }
    }//GEN-LAST:event_tabla1MouseClicked

    private void btnAñadirCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirCarroActionPerformed
        d.setCantidad(Integer.parseInt(txtCantidad.getText()));
        if(Integer.parseInt(txtCantidad.getText()) > 0){
            frmCarrito.lista.add(d);
            JOptionPane.showMessageDialog(null, "producto añadido");
        } else{
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        }  
    }//GEN-LAST:event_btnAñadirCarroActionPerformed

    private void cmbAnimalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAnimalItemStateChanged
        filtraAnimal();
    }//GEN-LAST:event_cmbAnimalItemStateChanged

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void cmbAlimentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAlimentoItemStateChanged
        filtraAlimento();
    }//GEN-LAST:event_cmbAlimentoItemStateChanged

    private void cmbHigieneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHigieneItemStateChanged
        filtraHigiene();
    }//GEN-LAST:event_cmbHigieneItemStateChanged

    private void cmbOtrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOtrosItemStateChanged
        filtraOtros();
    }//GEN-LAST:event_cmbOtrosItemStateChanged

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
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirCarro;
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> cmbAlimento;
    private javax.swing.JComboBox<String> cmbAnimal;
    private javax.swing.JComboBox<String> cmbHigiene;
    private javax.swing.JComboBox<String> cmbOtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel pAnimal;
    private javax.swing.JPanel pTodos;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    private javax.swing.JTable tabla3;
    private javax.swing.JTable tabla4;
    private javax.swing.JTable tabla5;
    private javax.swing.JTable tabla6;
    private javax.swing.JTabbedPane tpProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNomProductos;
    // End of variables declaration//GEN-END:variables
}
