/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomo
 */
public class TargetClass {
    private List<PersonInfo> personInfos = new ArrayList<PersonInfo>(); // <--★1
    
    private void doSomething(String name) {
        String sql1 = "selet * from person where name like " + name; // <--★2
        List<Person> persons = DataUtils.getPersons(sql1); // <--★3ここをモック
        for (Person person : persons) {
            PersonInfo personInfo = new PersonInfo();
            personInfo.setName(name);
            switch (person.getType()) {
                case STUDENT: // <--★パターン1
                    personInfo.setType(Type.STUDENT);
                    personInfo.setTypeName("school");
                    personInfo.setAge(20);
                    break;
                case OFFICEWORKER: // <--★パターン2
                    personInfo.setType(Type.OFFICEWORKER);
                    personInfo.setTypeName("company");
                    personInfo.setAge(25);
                    break;
            }
            personInfos.add(personInfo);
        }
    }
}
