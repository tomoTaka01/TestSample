/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsample;

/**
 *
 * @author tomo
 */
public class Person {
    private String name;
    private Type type;
    private int age;
    private int typeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
   
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
