package controllers;
import models.Employees;
import models.EmployeesDao;
import views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.SystemView;
/** * * @author Brayan */
public class LoginController implements ActionListener {
    private Employees employee;
    private EmployeesDao employees_dao;
    private LoginView login_view;

    public LoginController(Employees employee, EmployeesDao employees_dao, LoginView login_view) {
        this.employee = employee;
        this.employees_dao = employees_dao;
        this.login_view = login_view;
        this.login_view.btn_enter.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String user = login_view.txt_username.getText().trim();
        String pass = String.valueOf(login_view.txt_password.getPassword());
        if(e.getSource() == login_view.btn_enter){
            if(!user.equals("") || !pass.equals("")){
                employee = employees_dao.loginQuery(user, pass);
                if(employee.getUsername() != null){
                    if(employee.getRol().equals("Administrador")){
                        SystemView admin = new SystemView();
                        admin.setVisible(true);
                    }else{
                        SystemView aux = new SystemView();
                        aux.setVisible(true);
                    }
                    this.login_view.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Los campos están vacíos.");
            }
        }
    }
    
}
