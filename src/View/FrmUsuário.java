/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.UsuarioDao;
import Model.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Constantes;

/**
 *
 * @author clebe
 */
public class FrmUsuário extends javax.swing.JInternalFrame {

    private int modo;
    List<Usuario> usuarios;

    public FrmUsuário() {
        initComponents();
        listar();
    }
//    public FrmUsuário(FrmRegistraVenda registraVenda) {
//        initComponents();
//    }

    public void listar() {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarios = usuarioDao.select();
        DefaultTableModel dados = (DefaultTableModel) jTblUsuario.getModel();
        dados.setNumRows(0);

        for (Usuario usuario : usuarios) {
            dados.addRow(new Object[]{
                usuario.getId(),
                usuario.getNome(),
                usuario.getPerfil(),});
        }
    }

    private void habilitarCampos() {
        jTxtNome.setEnabled(true);
        jTxtLogin.setEnabled(true);
        jPassword.setEnabled(true);
        jTxtEmail.setEnabled(true);
        jCbxPerfil.setEnabled(true);
    }

    private void desabilitarCampos() {
        jTxtNome.setEnabled(false);
        jTxtLogin.setEnabled(false);
        jPassword.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jCbxPerfil.setEnabled(false);
    }

    private void desabilitarBotoes() {
        jBtnSalvar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        jBtnNovo.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
    }

    private void habilitarBotoes() {
        jBtnSalvar.setEnabled(true);
        jBtnCancelar.setEnabled(true);
        jBtnNovo.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
    }

    public void incluiCliente() {
        if (jTxtNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe o nome do Cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            jTxtNome.requestFocus();
        } else {
            Usuario usuario = new Usuario();
            usuario.setId(0);
            usuario.setNome(jTxtNome.getText());
            usuario.setLogin(jTxtLogin.getText());
            usuario.setSenha(jPassword.getText());
            usuario.setEmail(jTxtEmail.getText());
            usuario.setPerfil(jCbxPerfil.getSelectedItem().toString());

            UsuarioDao usuarioDao = new UsuarioDao();
            if (usuarioDao.insert(usuario)) {
                JOptionPane.showMessageDialog(this, "Cliente Cadastrado com Sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                listar();
                desabilitarBotoes();
                desabilitarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar o Cliente!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void alteraCliente() {
        if (jTxtNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe o nome do Cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            jTxtNome.requestFocus();
        } else {
            Usuario usuario = new Usuario();
            usuario.setId(usuarios.get(jTblUsuario.getSelectedRow()).getId());
            usuario.setNome(jTxtNome.getText());
            usuario.setLogin(jTxtLogin.getText());

            boolean passwordAlreadyChanged = false;

            if (jPassword.getText().equals("")) {
                usuario.setSenha(usuarios.get(jTblUsuario.getSelectedRow()).getSenha());
            } else {
                passwordAlreadyChanged = true;
                usuario.setSenha(jPassword.getText());
            }

            usuario.setEmail(jTxtEmail.getText());
            usuario.setPerfil(jCbxPerfil.getSelectedItem().toString());

            UsuarioDao usuarioDao = new UsuarioDao();

            if (usuarioDao.update(usuario, passwordAlreadyChanged)) {
                JOptionPane.showMessageDialog(this, "Cliente alterado com Sucesso!!!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                listar();
                desabilitarBotoes();
                desabilitarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Informe o nome do Cliente", "Erro", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void excluiCliente() {
        UsuarioDao usuarioDao = new UsuarioDao();
        if (usuarioDao.delete(usuarios.get(jTblUsuario.getSelectedRow()).getId())) {
            JOptionPane.showMessageDialog(this, "Dados do cliente excluídos com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            listar();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtFiltroNome = new javax.swing.JTextField();
        jBtnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblUsuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Bairro = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCbxPerfil = new javax.swing.JComboBox<>();
        jTxtLogin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jBtnNovo = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Java GUI Swing - TADS 2023 ! ! !");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário");
        jPanel1.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Filtro por Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jTxtFiltroNome, gridBagConstraints);

        jBtnPesquisar.setMnemonic('p');
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jBtnPesquisar, gridBagConstraints);

        jTblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Perfil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblUsuario.getTableHeader().setReorderingAllowed(false);
        jTblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblUsuario);
        if (jTblUsuario.getColumnModel().getColumnCount() > 0) {
            jTblUsuario.getColumnModel().getColumn(0).setMinWidth(1);
            jTblUsuario.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        jTxtNome.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jTxtNome, gridBagConstraints);

        jLabel4.setText("Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel4, gridBagConstraints);

        Bairro.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(Bairro, gridBagConstraints);

        jTxtEmail.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jTxtEmail, gridBagConstraints);

        jLabel5.setText("Perfil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel5, gridBagConstraints);

        jCbxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuario" }));
        jCbxPerfil.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jCbxPerfil, gridBagConstraints);

        jTxtLogin.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jTxtLogin, gridBagConstraints);

        jLabel6.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnNovo);

        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnAlterar);

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnExcluir);

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.setEnabled(false);
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnSalvar);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setEnabled(false);
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        String nome = "%" + jTxtFiltroNome.getText() + "%";
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> lista = usuarioDao.selectByName(nome);
        DefaultTableModel dados = (DefaultTableModel) jTblUsuario.getModel();
        dados.setRowCount(0);
        for (Usuario usuario : lista) {
            dados.addRow(new Object[]{
                usuario.getId(),
                usuario.getNome(),
                usuario.getPerfil()
            });
        }
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        habilitarCampos();
        habilitarBotoes();
        modo = Constantes.INSERT_MODE;
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        if (modo == Constantes.INSERT_MODE) {
            incluiCliente();
        } else if (modo == Constantes.EDIT_MODE) {
            alteraCliente();
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        listar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jTblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUsuarioMouseClicked
        if (jTblUsuario.getSelectedRow() != -1) {
            int indice = jTblUsuario.getSelectedRow();
            jTxtNome.setText(usuarios.get(indice).getNome());
            jTxtLogin.setText(usuarios.get(indice).getLogin());
            jTxtEmail.setText(usuarios.get(indice).getEmail());
            jCbxPerfil.setSelectedItem(usuarios.get(indice).getPerfil());
        }

    }//GEN-LAST:event_jTblUsuarioMouseClicked

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        if (jTblUsuario.getSelectedRow() != -1) {
            habilitarBotoes();
            habilitarCampos();
            modo = Constantes.EDIT_MODE;
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente da Lista", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (jTblUsuario.getSelectedRow() != -1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Confirma exclusão de cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                excluiCliente();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente na Lista");

        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        desabilitarBotoes();
        desabilitarCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bairro;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCbxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblUsuario;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtFiltroNome;
    private javax.swing.JTextField jTxtLogin;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
