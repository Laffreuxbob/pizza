package fr.epsi.rennes.peoc.bob;

import fr.epsi.rennes.poec.bob.exception.BusinessException;
import fr.epsi.rennes.poec.bob.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class unitTest {

    @Autowired
    private TestService service;

    @Test
    public void unitTest1() throws BusinessException {
        // given
        int test1 = 3;

        // when
        int test2 = service.testmethod(test1);

        // then
        assertEquals(120, test2);
    }
}
