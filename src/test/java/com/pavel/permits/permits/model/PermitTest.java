package com.pavel.permits.permits.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Pavel on 21.08.2017.
 */
public class PermitTest {

    @Test
    public void testPermit() {
        Permit permit = buildPermit();

        assertThat(permit.getPerson().getFirstName()).isEqualTo("ivan");
        assertThat(permit.getCodes().size()).isEqualTo(1);
    }

    private Permit buildPermit() {
        Organization org = new Organization();
        org.setName("OOO IVANOV");

        Person person = new Person();
        person.setFirstName("ivan");
        person.setLastName("ivanov");
        person.setOrganization(org);

        Code code = new Code();
        code.setName("test-code");

        Pass pass = new Pass();
        pass.setName("test-pass");

        Permit permit = new Permit();
        permit.setPerson(person);
        permit.setIssueDate(Calendar.getInstance().getTime());
        permit.setCodes(Arrays.asList(code));
        permit.setPass(pass);

        return permit;
    }
}
