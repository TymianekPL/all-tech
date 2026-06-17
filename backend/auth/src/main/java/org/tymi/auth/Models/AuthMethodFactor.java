package org.tymi.auth.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authmethodfactor")
public class AuthMethodFactor {
     @Id
     @Column(name = "id", nullable = false)
     private Integer id;

     @Column(name = "name", nullable = false, length = 64)
     private String name;

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

}
