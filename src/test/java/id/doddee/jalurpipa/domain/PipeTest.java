package id.doddee.jalurpipa.domain;

import static org.assertj.core.api.Assertions.assertThat;

import id.doddee.jalurpipa.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class PipeTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Pipe.class);
        Pipe pipe1 = new Pipe();
        pipe1.setId(1L);
        Pipe pipe2 = new Pipe();
        pipe2.setId(pipe1.getId());
        assertThat(pipe1).isEqualTo(pipe2);
        pipe2.setId(2L);
        assertThat(pipe1).isNotEqualTo(pipe2);
        pipe1.setId(null);
        assertThat(pipe1).isNotEqualTo(pipe2);
    }
}
