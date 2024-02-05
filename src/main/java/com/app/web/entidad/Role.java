//package com.app.web.entidad;
//
//
//import org.hibernate.mapping.Collection;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "SEC_ROLE")
//public class Role implements Serializable {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 8216539800374390907L;
//    @Id
//    @Column(name = "ROLENAME", unique = true, nullable = false, length = 100)
//    private String rolename;
//    @Column(name = "PROMPT", length = 255)
//    private String prompt;
//    @ManyToMany(targetEntity = User.class, mappedBy = "roles")
//    private Collection<User> users;
//
//    public String getRolename() {
//        return rolename;
//    }
//
//    public void setRolename(String rolename) {
//        this.rolename = rolename;
//    }
//
//    public String getPrompt() {
//        return prompt;
//    }
//
//    public void setPrompt(String prompt) {
//        this.prompt = prompt;
//    }
//
//    public Collection<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Collection<User> users) {
//        this.users = users;
//    }
//}
//
