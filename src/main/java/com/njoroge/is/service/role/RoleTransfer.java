
package com.njoroge.is.service.role;

/**
 * @author John Njoroge
 * @date 20/05/2019
 */
public class RoleTransfer {

    private Long id;
    private String roleName;


    public RoleTransfer( Long id, String roleName ) {

        this.id = id;
        this.roleName = roleName;
    }


    public RoleTransfer() {

        super();
    }


    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
    }


    public String getRoleName() {

        return roleName;
    }


    public void setRoleName( String roleName ) {

        this.roleName = roleName;
    }
}
