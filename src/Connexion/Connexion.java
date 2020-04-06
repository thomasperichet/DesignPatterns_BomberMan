package Connexion;


import java.sql.*;
 

public class Connexion extends javax.swing.JFrame {
	Connection c = null;
	Statement stmt = null;
	boolean connecte = false;
 
    /** Creates new form authentification */
    public Connexion() {
        initComponents();
    }
 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
 
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textlogin = new javax.swing.JTextField();
        textmdp = new javax.swing.JPasswordField();
        btnseconnecter = new javax.swing.JButton();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        jLabel1.setText("Connexion");
 
        jLabel2.setText("Nom d'utilisateur");
 
        jLabel3.setText("Mot de passe");
 
        textlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textloginActionPerformed(evt);
            }
        });
 
        textmdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textmdpActionPerformed(evt);
            }
        });
 
        btnseconnecter.setText("se connecter");
        btnseconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseconnecterActionPerformed(evt);
            }
        });
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textmdp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnseconnecter)
                            .addComponent(jLabel1))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textmdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnseconnecter)
                .addContainerGap(52, Short.MAX_VALUE))
        );
 
        pack();
    }// </editor-fold>                        
 
    private void textloginActionPerformed(java.awt.event.ActionEvent evt) {                                          
    }                                         
 
    private void textmdpActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }    
    
    public boolean getConnecte() {
    	System.out.println("Connecte :"+connecte);
    	return this.connecte;
    }
 
    private void btnseconnecterActionPerformed(java.awt.event.ActionEvent evt) {                                               
    		JDBCPostgres bdd_psql = new JDBCPostgres("etudiant","123456789");
    	boolean estPresent = bdd_psql.joueurExiste(textlogin.getText(),textmdp.getText());
    	if(estPresent)
    		this.connecte = true;
    	
        try {
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
 
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnseconnecter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textlogin;
    private javax.swing.JTextField textmdp;
    // End of variables declaration                   
}