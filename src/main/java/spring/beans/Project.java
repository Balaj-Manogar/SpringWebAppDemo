package spring.beans;

import com.sun.istack.internal.NotNull;

import org.springframework.stereotype.Component;

/**
 * Created by Balaji on 14/07/16.
 */
@Component
public class Project
{
    private String name;

    @NotNull
    private long id;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
