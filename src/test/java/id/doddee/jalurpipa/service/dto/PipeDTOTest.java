package id.doddee.jalurpipa.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import id.doddee.jalurpipa.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class PipeDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PipeDTO.class);
        PipeDTO pipeDTO1 = new PipeDTO();
        pipeDTO1.setId(1L);
        PipeDTO pipeDTO2 = new PipeDTO();
        assertThat(pipeDTO1).isNotEqualTo(pipeDTO2);
        pipeDTO2.setId(pipeDTO1.getId());
        assertThat(pipeDTO1).isEqualTo(pipeDTO2);
        pipeDTO2.setId(2L);
        assertThat(pipeDTO1).isNotEqualTo(pipeDTO2);
        pipeDTO1.setId(null);
        assertThat(pipeDTO1).isNotEqualTo(pipeDTO2);
    }
}
