//package com.app.web.entidad;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.management.relation.Role;
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//    @Entity
//    @Table(name="SEC_USER")
//    public class User implements Serializable, UserDetails {
//
//        /**
//         *
//         */
//        private static final long serialVersionUID = 4654282337754230886L;
//        @Id
//        @Column(name="USERNAME",unique=true,nullable=false,length=100)
//        private String username;
//        @Column(name="PASSWORD",length=255)
//        private String password;
//        @ManyToMany(targetEntity= Role.class,fetch=FetchType.EAGER)
//        @JoinTable(name="SEC_ROLE_USER",joinColumns={@JoinColumn(name="USERNAME",referencedColumnName="USERNAME")},
//                inverseJoinColumns={@JoinColumn(name="ROLENAME",referencedColumnName="ROLENAME")})
//        private Collection<Role> roles;
//        public String getUsername() {
//            return username;
//        }
//        public void setUsername(String username) {
//            this.username = username;
//        }
//        public String getPassword() {
//            return password;
//        }
//        public void setPassword(String password) {
//            this.password = password;
//        }
//        public Collection<Role> getRoles() {
//            return roles;
//        }
//        public void setRoles(Collection<Role> roles) {
//            this.roles = roles;
//        }
//        public Collection<GrantedAuthority> getAuthorities() {
//            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//            Iterator<Role> iter = this.roles.iterator();
//            while(iter.hasNext()){
//                Role role = iter.next();
//                GrantedAuthority authority = new GrantedAuthorityImpl(role.getRolename());
//                authorities.add(authority);
//            }
//
//		/*String[] roles = this.role.split(",");
//		for(String r : roles){
//			if(r != null && !"".equals(r)){
//				GrantedAuthority authority = new GrantedAuthorityImpl(r);
//				authorities.add(authority);
//			}
//		}*/
//            return authorities;
//        }
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//        public boolean isEnabled() {
//            return true;
//        }
//    }
