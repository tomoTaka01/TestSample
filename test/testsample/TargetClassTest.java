/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsample;

import java.util.List;
import java.util.ArrayList;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author tomo
 */
public class TargetClassTest {
    private String sql1 = "selet * from person where name like name1";// <--★2
    @Mocked
    final DataUtils dataUtils = null; // <--★3モック対象
    
    /**
     * Test of doSomething method, of class TargetClass.
     */
    @Test
    public void testDoSomething() {
        PersonInfo personInfo = new PersonInfo();
        final List<Person> exp = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setType(Type.STUDENT);
        exp.add(person1); // <--パターン1用
        Person person2 = new Person();
        person2.setType(Type.OFFICEWORKER);
        exp.add(person2); // <--パターン2用
        new Expectations(){{
            DataUtils.getPersons(sql1); // <--★3モック対象のメソッド指定
            result = exp; // <--★3モック値を設定
        }};
        List<PersonInfo> personInfos = new ArrayList<PersonInfo>();
        TargetClass target = new TargetClass();
        Deencapsulation.setField(target, personInfos);// <--★1テスト時に必要な変数を設定
        String result = Deencapsulation.invoke(target, "doSomething", "name1"); // <--テスト対象メソッドの実行
        // ★パターン1の実行結果を検証
        assertThat(personInfos.get(0).getTypeName(), is("school"));
        assertThat(personInfos.get(0).getType(), is(Type.STUDENT));
        assertThat(personInfos.get(0).getAge(), is(20));
        // ★パターン2の実行結果を検証
        assertThat(personInfos.get(1).getTypeName(), is("company"));
        assertThat(personInfos.get(1).getType(), is(Type.OFFICEWORKER));
        assertThat(personInfos.get(1).getAge(), is(25));
    }
}
