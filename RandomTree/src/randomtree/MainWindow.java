/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robin
 */
public class MainWindow extends javax.swing.JFrame
{
     private Forest forest;
     private IndividualSet globalSet;
     private String path;
    /**
     * Creates new form MainWindow
     */
    public MainWindow()
    {
        path=null;
        forest = null;
        globalSet = null;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSlider3 = new javax.swing.JSlider();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSlider4 = new javax.swing.JSlider();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Forêt");
        jLabel1.setVisible(false);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setText("Durée de génération :");
        jLabel4.setVisible(false);
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel2.setText("Taille :");
        jLabel2.setVisible(false);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Résultats");
        jLabel6.setVisible(false);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel7.setText("Taux de réussite :");
        jLabel7.setVisible(false);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setVisible(false);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 53, -1, 10));

        jLabel5.setVisible(false);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 73, -1, 10));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 133, -1, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 220));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 200));
        jPanel1.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1000, -1));

        jButton3.setText("Déterminer classe des données");
        jButton3.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Enregistrer la forêt");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setLabel("Charger une forêt");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Sélectionner un fichier");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setLabel("Générer une forêt");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(17, 17, 17)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 290, 220));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1000, 470));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSlider1.setMinimum(1);
        jSlider1.setValue(20);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSlider1StateChanged(evt);
            }
        });
        jPanel4.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 13, -1, -1));

        jLabel8.setText("Intervale :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 70, 26));

        jLabel10.setText("Nombre d'arbre :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, 20));

        jSlider2.setMaximum(500);
        jSlider2.setMinimum(1);
        jSlider2.setValue(100);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSlider2StateChanged(evt);
            }
        });
        jPanel4.add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabel11.setText("20%");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 60, 30));

        jLabel12.setText("100");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 70, 40));

        jSlider3.setMaximum(20);
        jSlider3.setMinimum(1);
        jSlider3.setValue(4);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSlider3StateChanged(evt);
            }
        });
        jPanel4.add(jSlider3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 85, -1, -1));

        jLabel13.setText("Profondeur des arbres :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 140, -1));

        jLabel14.setText("4");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jSlider4.setValue(80);
        jSlider4.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSlider4StateChanged(evt);
            }
        });
        jPanel4.add(jSlider4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jLabel15.setText("Données considérées par arbre :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 116, 210, 30));

        jLabel16.setText("80%");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 60, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 510, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        final JFileChooser fc = new JFileChooser();
        if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)) 
        {
            path = fc.getSelectedFile().getPath();
            try
            {
                FileInputStream filestream = new FileInputStream(path);
                ObjectInputStream stream = new ObjectInputStream(filestream);
                forest = (Forest) stream.readObject();
                jLabel1.setVisible(true);
                jLabel2.setVisible(true);
                jLabel3.setVisible(true);
                jLabel3.setText(Integer.toString(forest.getForest().size()));
            }
            catch(IOException | ClassNotFoundException e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        long beginTime = System.currentTimeMillis();
        forest = new Forest();
        int ForestSize = jSlider2.getValue();
        if(globalSet != null)
        {
            IndividualSet testList = new IndividualSet();
            IndividualSet learningList = new IndividualSet(globalSet);
            //On prend 10% du jeu de données pour les tests.
            DataHandler.setLearningRatio(0.9f);
            DataHandler.buildRandomIndividualSets(learningList, testList);
            //On met le pourcentage de données que l'on prend par arbre
            DataHandler.setLearningRatio(jSlider4.getValue()/100f);
            while(ForestSize != forest.getForest().size())
            {
                //Création du jeu de données pour un arbre
                IndividualSet unusedData = new IndividualSet();
                IndividualSet treeData = new IndividualSet(learningList);
                DataHandler.buildRandomIndividualSets(treeData, unusedData);
                //Création de l'arbre
                DecisionTree tree = new DecisionTree(new Tree(treeData));
                tree.setStep(jSlider1.getValue()/100f);
                tree.setDepth(jSlider3.getValue());
                tree.build();
                //On ajoute l'arbre peut importe sa qualité
                forest.addTree(tree);
                //System.out.println(tree);
            }
        
            //Test de la fôret
            int passed = 0;
            for(Individual  indiv : testList.getList())
            {
                String determinedClass = forest.getClassOfIndividual(indiv);                
                if(indiv.getClassValue().equals(determinedClass))
                    passed++;
            }

            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel9.setText(passed * 100 / testList.getList().size() + " %");

            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel4.setVisible(true);
            jLabel3.setText(Integer.toString(forest.getForest().size()));
            jLabel3.setVisible(true);
            jLabel5.setText(Float.toString((float) (System.currentTimeMillis() - beginTime) / 1000));
            jLabel5.setVisible(true);
        }
        JOptionPane.showMessageDialog(rootPane, "La forêt a été générée avec " + forest.getForest().size() + " arbres.", "Information", JOptionPane.OK_OPTION, null);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        if(globalSet != null)
        {
            try (PrintWriter writer = new PrintWriter(new File(path))) {
                for(Individual  indiv : globalSet.getList())
                {
                    String determinedClass = forest.getClassOfIndividual(indiv);
                    String indivAsString = determinedClass;
                    for(String attr : indiv.getAttributes())
                    {
                        indivAsString = indivAsString + "," + attr;
                    }
                    writer.println(indivAsString);
                }
                JOptionPane.showMessageDialog(rootPane, "Terminé", "Information", JOptionPane.OK_OPTION, null);
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        final JFileChooser fc = new JFileChooser();
        if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)) 
        {
            path = fc.getSelectedFile().getPath();
            String option[] = {"gauche","droite", "sans classe"};
            int classPos;
            if(( classPos =  JOptionPane.showOptionDialog(rootPane,"Sélectionner où est situé la classe", "Sélection classes", 
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, option, "droite")) >= 0 && (classPos < 2))
            {
                globalSet = DataHandler.parseData(path, (classPos == JOptionPane.NO_OPTION),true);
                Object[] data = globalSet.getList().toArray();
                Object[][] dataModel = new Object[data.length][((Individual)data[0]).getAttributes().size() + 1];
                for(int i = 0; i < data.length; i++)
                {
                    Object[] tmp = ((Individual) data[i]).getAttributes().toArray();
                    dataModel[i][0] = ((Individual) data[i]).getClassValue();
                    for(int j = 1; j <= tmp.length; j++)
                    {
                        dataModel[i][j] = tmp[j - 1];
                    }
                    
                }
                Object[] columnNames = new Object[dataModel[0].length];
                columnNames[0] = "Classe";
                DefaultTableModel tableModel = new DefaultTableModel(dataModel, columnNames);
                jTable1.setModel(tableModel);
                tableModel.fireTableDataChanged();
            }
            else
                if(classPos == 2)
                {
                    globalSet = DataHandler.parseData(path, false,false);
                    Object[] data = globalSet.getList().toArray();
                    Object[][] dataModel = new Object[data.length][((Individual)data[0]).getAttributes().size()];
                    for(int i = 0; i < data.length; i++)
                    {
                        Object[] tmp = ((Individual) data[i]).getAttributes().toArray();
                        dataModel[i][0] = ((Individual) data[i]).getClassValue();
                        for(int j = 0; j < tmp.length; j++)
                        {
                            dataModel[i][j] = tmp[j];
                        }

                    }
                    Object[] columnNames = new Object[dataModel[0].length];
                    DefaultTableModel tableModel = new DefaultTableModel(dataModel, columnNames);
                    jTable1.setModel(tableModel);
                    tableModel.fireTableDataChanged();
                }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        String file = (String)JOptionPane.showInputDialog(rootPane, "Saisir nom du fichier", "enregistrer", HEIGHT, null, null, DISPOSE_ON_CLOSE);
                try{
            FileOutputStream filestream = new FileOutputStream("./" + file + ".forest");
            ObjectOutputStream stream = new ObjectOutputStream(filestream);
            stream.writeObject(forest);
            filestream.close();
            stream.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSlider1StateChanged
    {//GEN-HEADEREND:event_jSlider1StateChanged
        jLabel11.setText(Integer.toString(jSlider1.getValue())+"%");
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSlider2StateChanged
    {//GEN-HEADEREND:event_jSlider2StateChanged
        jLabel12.setText(Integer.toString(jSlider2.getValue()));
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSlider3StateChanged
    {//GEN-HEADEREND:event_jSlider3StateChanged
        jLabel14.setText(Integer.toString(jSlider3.getValue()));
    }//GEN-LAST:event_jSlider3StateChanged

    private void jSlider4StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSlider4StateChanged
    {//GEN-HEADEREND:event_jSlider4StateChanged
        jLabel16.setText(Integer.toString(jSlider4.getValue())+"%");
    }//GEN-LAST:event_jSlider4StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
