
package com.njoroge.is.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "user_role", uniqueConstraints = { @UniqueConstraint(
        columnNames = { "fk_user", "fk_role" } ) } )
public class UserRole extends AbstractPersistentEntity {

    private static final long serialVersionUID = 8077499013591975362L;

    @ManyToOne( )
    @JoinColumn( name = "fk_user", nullable = false )
    private User user;

    @ManyToOne( )
    @JoinColumn( name = "fk_role", nullable = false )
    private Role role;


    public User getUser() {

        return user;
    }


    public void setUser( User user ) {

        this.user = user;
    }


    public Role getRole() {

        return role;
    }


    public void setRole( Role role ) {

        this.role = role;
    }


    @Override
    public boolean equals( Object obj ) {

        return super.equals( obj );
    }
}
