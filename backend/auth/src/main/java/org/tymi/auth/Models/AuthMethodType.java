package org.tymi.auth.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "authmethodtype")
public class AuthMethodType {
     @Id
     @Column(name = "id", nullable = false)
     private Integer id;

     @Column(name = "name", nullable = false, length = 64)
     private String name;

     @ColumnDefault("0")
     @Column(name = "canPrimary", nullable = false)
     private Boolean canPrimary;

     @ColumnDefault("0")
     @Column(name = "canSecondary", nullable = false)
     private Boolean canSecondary;

     @ColumnDefault("0")
     @Column(name = "canPassthrough", nullable = false)
     private Boolean canPassthrough;

     @ColumnDefault("0")
     @Column(name = "canSupplemental", nullable = false)
     private Boolean canSupplemental;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Boolean getCanPrimary() {
          return canPrimary;
     }

     public void setCanPrimary(Boolean canPrimary) {
          this.canPrimary = canPrimary;
     }

     public Boolean getCanSecondary() {
          return canSecondary;
     }

     public void setCanSecondary(Boolean canSecondary) {
          this.canSecondary = canSecondary;
     }

     public Boolean getCanPassthrough() {
          return canPassthrough;
     }

     public void setCanPassthrough(Boolean canPassthrough) {
          this.canPassthrough = canPassthrough;
     }

     public Boolean getCanSupplemental() {
          return canSupplemental;
     }

     public void setCanSupplemental(Boolean canSupplemental) {
          this.canSupplemental = canSupplemental;
     }

}
