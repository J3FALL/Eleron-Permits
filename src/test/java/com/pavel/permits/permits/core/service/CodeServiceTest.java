package com.pavel.permits.permits.core.service;

import com.pavel.permits.permits.core.service.impl.CodeServiceImpl;
import com.pavel.permits.permits.model.Code;
import com.pavel.permits.permits.persistence.repository.CodeRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Pavel on 21.08.2017.
 */
public class CodeServiceTest {

    private CodeService service;

    @Mock
    private CodeRepository repository;

    @Before
    public void setUp() {
        service = new CodeServiceImpl(mockRepository());
    }

    private CodeRepository mockRepository() {
        repository = mock(CodeRepository.class);

        Code returnedCode = new Code();
        returnedCode.setName("test-code");

        when(repository.save(returnedCode)).thenReturn(returnedCode);
        return repository;
    }

    @Test
    public void testSaveCode() {

        Code code = new Code();
        code.setName("test-code");

        Code savedCode = service.save(code);

        assertThat(savedCode).isEqualTo(code);
    }
}
