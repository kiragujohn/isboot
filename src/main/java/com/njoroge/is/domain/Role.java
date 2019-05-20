
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "app_role" )
public class Role extends AbstractPersistentEntity {

    private static final long serialVersionUID = -2242262152050882384L;

    @Column( name = "name", nullable = false, unique = false, length = 60 )
    private String roleName;


    public String getRoleName() {

        return roleName;
    }


    public void setRoleName( String roleName ) {

        this.roleName = roleName;
    }


    @Override
    public int hashCode() {

        return super.hashCode();
    }


    @Override
    public boolean equals( Object obj ) {

        return super.equals( obj );
    }

}
