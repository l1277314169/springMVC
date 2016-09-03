package web.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-05-01.
 */
public class Roles implements Serializable{

    private static final long serialVersionUID = 8593477749128878541L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    private String rolesName;


}
